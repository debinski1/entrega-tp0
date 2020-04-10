package entrega0;

public class CosaAcomprar implements AComprarInterface {
	double precio;
	boolean vendido;
	
	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) throws NoSePuedeCambiarPrecioException {
		if (this.isVendido() == false) {
			this.precio = precio;
		} else {
			throw new NoSePuedeCambiarPrecioException();
		}
	}

	public boolean isVendido() {
		return vendido;
	}

	public void setVendido() throws NoHayDevolucionesException {
		if (this.vendido == false) {
			this.vendido = true;
		} else {
			throw new NoHayDevolucionesException();
		}
	}

}
