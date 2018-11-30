package Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;

import org.junit.Test;

import Sistema.Planeta;
import Sistema.Posicion;
import Sistema.SistemaSolar;
import Sistema.Tiempo;
import Sistema.Triangulo;

public class PruebaSistemaSolar {
	@Test
	public void probarPlanetasAlineados() {
		SistemaSolar sistema = new SistemaSolar(new Posicion(2.0, 0.0), 3.0 );
		sistema.agregarPlaneta(new Posicion(2.0, 0.0), 4.0 );
		sistema.agregarPlaneta(new Posicion(2.0, 0.0), 5.0 );
		
		Boolean resultado = sistema.estanAlineadosConElSol();
		
		assertThat(resultado).isTrue();
	}
	
	@Test
	public void probarPlanetasDesalineados() {

		SistemaSolar sistema = new SistemaSolar(new Posicion(2.0, 0.0), 3.0 );
		sistema.agregarPlaneta(new Posicion(2.0, 90.0), 4.0);
		sistema.agregarPlaneta(new Posicion(2.0, 0.0), 5.0 );
		
		Boolean resultado = sistema.estanAlineadosConElSol();
		
		assertThat(resultado).isFalse();
	}
	
	@Test
	public void probarTrianguloContieneAlSolConTraslacion() {
		SistemaSolar sistema = new SistemaSolar(new Posicion(2.0, 0.0), 10.0);
		
		// La velocidad relativa es 45-10
		sistema.agregarPlaneta(new Posicion(2.0, 0.0), 45.0);
		sistema.agregarPlaneta(new Posicion(2.0, 0.0), 195.0 );
		
		sistema.actualizarA(Tiempo.DIAENMIN);
		Boolean resultado = sistema.trianguloContenieneSol();
		assertThat(resultado).isTrue();
	}
	
	@Test
	public void ProbarTraslacion(){
		ArrayList<Planeta> Planeta = new ArrayList<Planeta>();
		
		SistemaSolar sistema = new SistemaSolar(new Posicion(5E5, 0.0), 1.0 );
	    sistema.agregarPlaneta(new Posicion(2E6, 0.0), 3.0 );
	    sistema.agregarPlaneta(new Posicion(1E6, 0.0), -5.0 );
	    
	   	sistema.actualizarA(Tiempo.DIAENMIN*23);
	   	
	   	Planeta = sistema.getPlanetas();
	   	Double angulo = Planeta.get(0).getPosicion().getAngulo().getAnguloAbs();
	   	assertThat(angulo).isEqualTo(0);
	   	angulo = Planeta.get(1).getPosicion().getAngulo().getAnguloAbs();
	   	assertThat(angulo).isEqualTo(46.0);
	   	angulo = Planeta.get(2).getPosicion().getAngulo().getAnguloAbs();
	   	assertThat(angulo).isEqualTo(-138+360);
	}
	@Test
	public void ProbartrianguloContenieneSol1(){
		
		SistemaSolar sistema = new SistemaSolar(new Posicion(5E5, 0.0), 1.0 );
	    sistema.agregarPlaneta(new Posicion(2E6, 0.0), 3.0 );
	    sistema.agregarPlaneta(new Posicion(1E6, 0.0), -5.0 );

	   	sistema.actualizarA(Tiempo.DIAENMIN*2);
		
	   	Boolean resultado = sistema.trianguloContenieneSol();
		assertThat(resultado).isFalse();
	}
	@Test
	public void ProbartrianguloContenieneSol(){
		
		SistemaSolar sistema = new SistemaSolar(new Posicion(5E5, 0.0), 1.0 );
	    sistema.agregarPlaneta(new Posicion(2E6, 0.0), 3.0 );
	    sistema.agregarPlaneta(new Posicion(1E6, 0.0), -5.0 );

	   	sistema.actualizarA(Tiempo.DIAENMIN*22);
		
	   	Boolean resultado = sistema.trianguloContenieneSol();
		assertThat(resultado).isFalse();

		
	   	sistema.actualizarA(Tiempo.DIAENMIN*23);
		
	   	resultado = sistema.trianguloContenieneSol();
		assertThat(resultado).isTrue();

	   	sistema.actualizarA(Tiempo.DIAENMIN*(67));
		
	   	resultado = sistema.trianguloContenieneSol();
		assertThat(resultado).isFalse();

	   	sistema.actualizarA(Tiempo.DIAENMIN*68);
		
	   	resultado = sistema.trianguloContenieneSol();
		assertThat(resultado).isTrue();
}
	@Test
	public void ProgarPlanetasAlineados(){
		SistemaSolar sistema = new SistemaSolar(new Posicion(5E5, 0.0), 1.0 );
	    sistema.agregarPlaneta(new Posicion(2E6, 0.0), 3.0 );
	    sistema.agregarPlaneta(new Posicion(1E6, 0.0), -5.0 );

	   	sistema.actualizarA(Tiempo.DIAENMIN*90);
		
	   	Boolean resultado = sistema.trianguloContenieneSol();
		assertThat(resultado).isTrue();
	}
}
