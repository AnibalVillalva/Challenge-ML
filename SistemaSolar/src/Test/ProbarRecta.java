package Test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import Sistema.Punto;
import Sistema.Recta;

public class ProbarRecta {
	@Test
	public void probarPuntoDentroRecta() {
		Recta r = new Recta(new Punto(2.0, 90.0),new Punto(2.0,0.0));
		Punto p = new Punto(1,1);
		Boolean resultado = r.contienePunto(p);
		assertThat(resultado).isTrue();
	}
	
	public void probarPuntoFueraRecta(){
		Recta r = new Recta(new Punto(2.0, 90.0),new Punto(2.0, 0.0));
		Boolean resultado = r.contienePunto(new Punto(1,1));
		assertThat(resultado).isFalse();
	}
}
