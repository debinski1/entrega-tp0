package entrega0;

import org.junit.jupiter.api.*;
import entrega0.NoSePuedeCambiarPrecioException;

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
		Assertions.assertEquals(3375, totalCuenta, 0.01);
		
		//AHORA SUMAMOS DOS SERVICIOS Y VEMOS SI EL POLIMORFISMO FUNCIONA
		changuito.agregarAlCarrito(revocar);
		changuito.agregarAlCarrito(pintar);
		totalCuenta = changuito.calcularTotal();
		Assertions.assertEquals(4425, totalCuenta, 0.01);
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
		Assertions.assertEquals(4425, totalCuenta, 0.01);
	}
	
	@Test
	public void restandoItemsAlChanguito() {
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
		
		changuito.sacarDelCarrito(garrafa);
		changuito.sacarDelCarrito(cemento);
		
		double totalCuenta = changuito.calcularTotal();
		Assertions.assertEquals(2705, totalCuenta, 0.01);
	}
	
	@Test
	public void cerrandoLaCompra() {
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
		
		changuito.cerrarOperacion();
		double totalCuenta = changuito.calcularTotal();
		
		Assertions.assertEquals(4425, totalCuenta, 0.01);
		Assertions.assertTrue(changuito.operacionCerrada);
	}
	
	@Test
	public void tratandoDeCambiarElPrecio() throws NoSePuedeCambiarPrecioException {
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
		
		changuito.cerrarOperacion();
		double totalCuenta = changuito.calcularTotal();
		
		Assertions.assertEquals(4425, totalCuenta, 0.01);
		Assertions.assertTrue(changuito.operacionCerrada);
		
		Assertions.assertThrows(NoSePuedeCambiarPrecioException.class, () -> {
				cemento.setPrecio(300);
			});
	}
	
	@Test
	public void cambiandoElPrecioAntesDeLaOperacion() throws NoSePuedeCambiarPrecioException {
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
		Assertions.assertEquals(4425, totalCuenta, 0.01);

		// DADO QUE NO CERRAMOS LA OPERACION, PODEMOS CAMBIAR EL PRECIO
		cemento.setPrecio(300);
		totalCuenta = changuito.calcularTotal();
		Assertions.assertEquals(4505, totalCuenta, 0.01);
		
		// Ahora CERRAMOS LA OPERACION Y YA NO PODREMOS CAMBIAR
		changuito.cerrarOperacion();
		Assertions.assertTrue(changuito.operacionCerrada);
		
		// CAMBIAMOS EL PRECIO DEL CEMENTO SIN EXITO
		Assertions.assertThrows(NoSePuedeCambiarPrecioException.class, () -> {
			cemento.setPrecio(300);
		});
	}
	
	@Test
	public void generandoRemito() throws NoSePuedeGenerarRemitoException {
		//CREAMOS LOS OBJETOS QUE VAN A INTERACTUAR CON LA ORDEN DE COMPRA
		AComprarInterface garrafa = new Producto(1500);
		AComprarInterface pintura = new Producto(1600);
		AComprarInterface pincel = new Producto(55);
		AComprarInterface cemento = new Producto(220);
		Compra changuito = new Compra();
		
		changuito.agregarAlCarrito(garrafa);
		changuito.agregarAlCarrito(pintura);
		changuito.agregarAlCarrito(pincel);
		changuito.agregarAlCarrito(cemento);
		
		// CREAMOS UN REMITO
		Remito remito = changuito.generarRemito("Calle Falsa 123");

		Assertions.assertTrue(Remito.class.isInstance(remito));
	}
	
	@Test
	public void evitandoElRemito() throws NoSePuedeGenerarRemitoException {
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
		
		// CREAMOS UN REMITO, PERO DADO QUE HAY SERVICIOS, VA A FALLAR
		Assertions.assertThrows(NoSePuedeGenerarRemitoException.class, () -> {
			changuito.generarRemito("Calle Falsa 123");
		});
	}
}
