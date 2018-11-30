package Test;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

import Sistema.Posicion;
import Sistema.Punto;

public class PruebaPosicion {
	@Test
	public void probarCoordenadasCartesianas() {
		Posicion p1 = new Posicion(3.0,90.0);
		Double d = p1.distancia(new Punto(4,0));
		assertThat(d).isEqualTo(5.0);
	}
	
}
