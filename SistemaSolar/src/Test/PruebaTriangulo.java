package Test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import Sistema.Angulo;
import Sistema.Triangulo;
import Sistema.Posicion;


public class PruebaTriangulo {
	@Test
	public void probarTrianguloConteniendoOrigen() {
		Triangulo t = new Triangulo(new Posicion(2.0,0.0),new Posicion(5.0,90.0),new Posicion(6.0,180+45.0));
		Boolean resultado = t.contieneOrigen();
		assertThat(resultado).isTrue();
	}
	
	@Test
	public void probarTrianguloNoConteniendoOrigen() {
		Triangulo t = new Triangulo(new Posicion(2.0,0.0),new Posicion(5.0,30.0),new Posicion(6.0,180+45.0));
		Boolean resultado = t.contieneOrigen();
		assertThat(resultado).isFalse();
	}
	
	@Test
	public void probarTrianguloNoConteniendoOrigen2() {
		Triangulo t = new Triangulo(new Posicion(2.0,0.0),new Posicion(5.0,190.0),new Posicion(6.0,180+45.0));
		Boolean resultado = t.contieneOrigen();
		assertThat(resultado).isFalse();
	}
	@Test
	public void probarTrianguloPerimetro() {
		Triangulo t = new Triangulo(new Posicion(3.0,0.0),new Posicion(4.0,90.0),new Posicion(4.0,90+180.0));
		Double p = t.getPerimetro();
		assertThat(p).isEqualTo(18);
	}
	
}
