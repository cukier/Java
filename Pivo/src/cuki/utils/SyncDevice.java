package cuki.utils;

import net.wimpi.modbus.io.ModbusSerialTransaction;
import net.wimpi.modbus.msg.ReadMultipleRegistersRequest;
import net.wimpi.modbus.msg.ReadMultipleRegistersResponse;

public class SyncDevice {

	ConnectionModbus con = null;
	ModbusSerialTransaction trans = null;
	ReadMultipleRegistersRequest req = null;
	ReadMultipleRegistersResponse res = null;
	DeviceModbus device = null;

	public SyncDevice(DeviceModbus device, ConnectionModbus con) {
		this.device = device;
		this.con = con;
	}

	public void execute() {

		try {
			con.open();

			if (con.isDoorOpen()) {
				req = new ReadMultipleRegistersRequest();
				req.setReference(0);
				req.setWordCount(device.getQtdMemoria());
				req.setUnitID(device.getAddress());
				req.setHeadless();

				trans = new ModbusSerialTransaction(con.getConection());
				trans.setRequest(req);
				trans.execute();

				res = (ReadMultipleRegistersResponse) trans.getResponse();

				if (res != null) {
					for (int cont = 0; cont < res.getWordCount(); cont++) {
						device.setData(cont, res.getRegisterValue(cont));
					}
				}
			}
		} catch (Exception e) {
			System.exit(1);
		} finally {
			con.close();
		}
	}
}
