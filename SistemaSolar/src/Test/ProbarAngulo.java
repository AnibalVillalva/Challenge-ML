package Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

import Sistema.Angulo;

public class ProbarAngulo {
	@Test
	public void probarVueltas() {
		Angulo a = new Angulo(3.0*360+45);
		Integer vueltas = a.getVueltas();
		assertThat(vueltas).isEqualTo(3);
	}
	
	@Test
	public void probarPendiente() {
		Angulo a = new Angulo(3.0*360+45+180);
		Double phi = a.getPendiente();
		assertThat(phi).isEqualTo(45.0);
	}
	@Test
	public void probarAnguloAbsoluto() {
		Angulo a = new Angulo(3.0*360+37);
		Double phi = a.getAnguloAbs();
		assertThat(phi).isEqualTo(37.0);
	}
}
