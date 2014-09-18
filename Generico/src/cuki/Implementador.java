package cuki;

public class Implementador {

	public static void main(String[] args) {

		String s = "cuki";
		int nr = 1244;
		float p = (float) 0.5;

		TipoGenerico<Integer> tipo = new TipoGenerico<>();

		// tipo.set(s);
		tipo.set(nr);

		System.out.println(tipo.get() + " " + sizeof);

	}
}
