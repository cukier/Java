package cuki.utils;

import net.wimpi.modbus.procimg.SimpleRegister;

public class DeviceModbus {

	private int qtdMemoria;
	private int addr;
	private SimpleRegister[] data;

	public DeviceModbus(int addr, int qtdMemoria) {
		this.addr = addr;
		this.qtdMemoria = qtdMemoria;
		data = new SimpleRegister[qtdMemoria];
		for (int cont = 0; cont < qtdMemoria; cont++) {
			data[cont] = new SimpleRegister();
		}
	}

	public void setData(int addr, int value) {
		data[addr].setValue(value);
	}

	public int getQtdMemoria() {
		return this.qtdMemoria;
	}

	public int getAddress() {
		return this.addr;
	}

	public int getValue(int addr) {
		return this.data[addr].getValue();
	}

	public SimpleRegister[] getRegisters() {
		return this.data;
	}

}
