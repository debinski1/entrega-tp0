package entrega0;

public interface AComprarInterface {
	public double getPrecio();
	public void setPrecio(double precio) throws NoSePuedeCambiarPrecioException;
	public boolean isVendido();
	public void setVendido(boolean vendido) throws NoHayDevolucionesException;
}
