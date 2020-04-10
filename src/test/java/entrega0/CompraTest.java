package entrega0;

import org.junit.jupiter.api.*;

class CompraTest {

	@BeforeAll
	void crearPrecondiciones() {
		//Creamos los objetos que van a interactuar con la Orden de compra
		AComprarInterface garrafa = new Producto(1500);
		AComprarInterface pintura = new Producto(1600);
		AComprarInterface pincel = new Producto(55);
		AComprarInterface cemento = new Producto(220);
		AComprarInterface revocar = new Servicio(500);
		AComprarInterface pintar = new Servicio(550);
	}

}
