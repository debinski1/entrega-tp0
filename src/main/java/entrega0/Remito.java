package entrega0;

public class Remito {
	String domicilio = new String();
	
	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public Remito(String domicilio) {
		this.domicilio = domicilio;
	}
}
