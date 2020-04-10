package entrega0;

import org.junit.jupiter.api.*;

public class CompraTest {

	@Test
	public void sumandoItemsAlChanguito() {
		//CREAMOS LOS OBJETOS QUE VAN A INTERACTUAR CON LA ORDEN DE COMPRA
		AComprarInterface garrafa = new Producto(1500);
		AComprarInterface pintura = new Producto(1600);
		AComprarInterface pincel = new Producto(55);
		AComprarInterface cemento = new Producto(220);
		AComprarInterface revocar = new Servicio(500);
		AComprarInterface pintar = new Servicio(550);
		Compra changuito = new Compra();
		
		changuito.agregarAlCarrito(garrafa);
		changuito.agregarAlCarrito(pintura);
		changuito.agregarAlCarrito(pincel);
		changuito.agregarAlCarrito(cemento);

		//HASTA ACÁ SUMAMOS 3375 EN PLATA
		double totalCuenta = 0;
		totalCuenta = changuito.calcularTotal();
		Assertions.assertEquals(3375, totalCuenta, 0);
		
		//AHORA SUMAMOS DOS SERVICIOS Y VEMOS SI EL POLIMORFISMO FUNCIONA
		changuito.agregarAlCarrito(revocar);
		changuito.agregarAlCarrito(pintar);
		totalCuenta = changuito.calcularTotal();
		Assertions.assertEquals(4425, totalCuenta, 0);
	}
	
	@Test
	public void sumandoMasItemsAlChanguito() {
		//CREAMOS LOS OBJETOS QUE VAN A INTERACTUAR CON LA ORDEN DE COMPRA
		AComprarInterface garrafa = new Producto(1500);
		AComprarInterface pintura = new Producto(1600);
		AComprarInterface pincel = new Producto(55);
		AComprarInterface cemento = new Producto(220);
		AComprarInterface revocar = new Servicio(500);
		AComprarInterface pintar = new Servicio(550);
		Compra changuito = new Compra();
		
		changuito.agregarAlCarrito(garrafa);
		changuito.agregarAlCarrito(pintura);
		changuito.agregarAlCarrito(pincel);
		changuito.agregarAlCarrito(cemento);
		changuito.agregarAlCarrito(revocar);
		changuito.agregarAlCarrito(pintar);
		
		double totalCuenta = changuito.calcularTotal();
		Assertions.assertEquals(4425, totalCuenta, 0);
	}
}
