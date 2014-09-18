package cap17_2;

public class Programa implements Runnable {
	private int id;

	// colocar getter e setter pro atributo id

	public void run() {
		for (int i = 0; i < 10000; i++) {
			System.out.println("Programa " + id + " valor: " + i);
		}
	}

	public void setId(int id) {
		this.id = id;
	}
}
