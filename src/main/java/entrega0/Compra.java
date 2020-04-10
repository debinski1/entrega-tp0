package entrega0;
import java.util.ArrayList;
import java.util.function.Consumer;

public class Compra {

	ArrayList<AComprarInterface> items = new ArrayList<AComprarInterface>();
	boolean operacionCerrada = false;
	
	public void cerrarOperacion() {
		items.stream().forEach(i -> {
			try {
				i.setVendido();
			} catch (NoHayDevolucionesException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		this.operacionCerrada = true;
	}
	
	public void agregarAlCarrito(AComprarInterface item) {
		this.items.add(item);
	}
	
	public void sacarDelCarrito(AComprarInterface item) {
		this.items.remove(item);
	}
	
	public double calcularTotal() {
		return (items.stream()
		.mapToDouble(AComprarInterface::getPrecio)
		.sum());
	}
	
	private boolean esProducto (AComprarInterface obj) {
		return (Producto.class.isInstance(obj));
	}
	
	public Remito generarRemito(String domicilioEntrega) throws NoSePuedeGenerarRemitoException {
		if (items.stream().allMatch(item -> esProducto(item))) {
			return new Remito(domicilioEntrega);
		} else {
			throw new NoSePuedeGenerarRemitoException();
		}
	}
}