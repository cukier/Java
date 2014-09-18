package cuki;

public class TipoGenerico<T> {

	private T valor;

	public void set(T t) {
		this.valor = t;
	}

	public T get() {
		return valor;
	}

}
