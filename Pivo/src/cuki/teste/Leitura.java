package cuki.teste;

import cuki.utils.ConnectionModbus;
import cuki.utils.DeviceModbus;
import cuki.utils.SyncDevice;
import net.wimpi.modbus.procimg.SimpleRegister;

public class Leitura {

	public static void main(String[] args) {

		ConnectionModbus con = new ConnectionModbus("COM2");
		DeviceModbus plc = new DeviceModbus(1, 42);
		SyncDevice sync = new SyncDevice(plc, con);

		sync.execute();

		for (SimpleRegister reg : plc.getRegisters())
			System.out.println(reg.getValue());

	}
}
