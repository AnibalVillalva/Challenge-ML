package Test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import Sistema.Planeta;
import Sistema.Posicion;
import Sistema.Tiempo;

public class PruebaPlaneta {
	@Test
	public void probarCoordenadasCartesianas() {
		Planeta p1 = new Planeta(new Posicion(2.0, 90.0), 9.0);
		Integer x = p1.getPosicion().getX();
		Integer y = p1.getPosicion().getY();
		assertThat(x).isEqualTo(0);
		assertThat(y).isEqualTo(2);
	}
	
	@Test
	public void probarTrasladarPlaneta() {
		Planeta p1 = new Planeta(new Posicion(2.0,90.0), 9.0);
		Tiempo.setMinutos(10*Tiempo.DIAENMIN);
		p1.actualizar();
		Double angulo = p1.getPhi();
		
		assertThat(angulo).isEqualTo(180);
	}
}
