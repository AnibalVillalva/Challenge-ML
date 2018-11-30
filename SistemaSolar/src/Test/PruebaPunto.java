package Test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import Sistema.Punto;

public class PruebaPunto {
	@Test
	public void probarCoordenadasCartesianas() {
		Punto p1 = new Punto(2.0, 90.0);
		Integer x = p1.getX();
		Integer y = p1.getY();
		assertThat(x).isEqualTo(0);
		assertThat(y).isEqualTo(2);
	}
	
}
