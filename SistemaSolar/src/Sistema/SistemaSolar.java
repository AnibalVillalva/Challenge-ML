package Sistema;

import java.util.ArrayList;
/*
 * En este ejemplo, como lo que me interesa es la posicion de los planetas, y siempre la posicion depende
 * de 1 planeta y el sol, para facilitar  es crear los planetas con velocidades relativas al eje formado por
 * el planeta principal y el sol.
 *  
 */
public class SistemaSolar {
	private ArrayList<Planeta> Planetas = new ArrayList<Planeta>();
	public Tiempo tiempo = Tiempo.crearTiempo();

	/*
	 * El constructor se genera con un planeta al menos. 
	 * Considerandose que el sol esta en el eje de coordenadas y el planeta a una distancia r1. 
	 * Ademas se supone que aunque exista una velocidad angular del planeta principal, lo que gira es el resto 
	 * y el planeta siempre mantiene su posicion con angulo phi = 0.
	 */
	Double velocidadAngularSistema;

	public SistemaSolar(Posicion posicionPlaneta , Double velocidadAngular){
		this.velocidadAngularSistema = -velocidadAngular;
		Planeta planetaPrincipal = new Planeta(posicionPlaneta, 0.0);
		Planetas.add(planetaPrincipal);
	}
	
	public void agregarPlaneta( Posicion posicionPlaneta , Double velocidadAngular ){
		Planeta p = new Planeta(posicionPlaneta, velocidadAngular+this.velocidadAngularSistema);
		Planetas.add(p);
	}
	
	/*
	 * Para chequear que esten alineados solo se fija si el angulo es 0 para todos los planetas, 
	 * Esto es factible ya que siempre el planeta principal esta con angulo 0, y la galaxia gira con un phi.  
	 */
	public Boolean estanAlineadosConElSol(){
		for ( Planeta p : Planetas){
			if (p.getPhi() != 0 && p.getPhi() != 180)
				return false;
		}
		return true;
	}
	
	public Boolean estanAlineadosSinElSol(){
		/*
		 * Resta la posicion de un planeta con el principal, luego el tercero con el principal
		 * y compara ambos angulos, si son iguales +- 180 entonces estan en la misma recta. 
		 */
		Recta r = new Recta(Planetas.get(0).getPosicion(),Planetas.get(1).getPosicion());
		if (r.contienePunto(Planetas.get(2).getPosicion()))
			return true;
		
		return false;
	}
	
	public Boolean trianguloContenieneSol(){
			Triangulo triangulo = new Triangulo(Planetas.get(0).getPosicion(),Planetas.get(1).getPosicion(),Planetas.get(2).getPosicion());
			if (triangulo.contieneOrigen())
				return true;
			return false;
	}
	
	public Double getPerimetro(){
		Triangulo triangulo = new Triangulo(Planetas.get(0).getPosicion(),Planetas.get(1).getPosicion(),Planetas.get(2).getPosicion());
		return triangulo.getPerimetro();
	
	}

	private void actualizar(){
		for ( Planeta p : Planetas){
			p.actualizar();
		}
	}
	public ArrayList<Planeta> getPlanetas(){
		return Planetas;
	}
	/**
	 * 
	 * @param tiempo medido en minutos
	 */
	public void actualizarA(Integer tiempo){
		Tiempo.setMinutos(tiempo);
		actualizar();
	}
	
	public void actualizarT(){
		Tiempo.Actualizar();
		actualizar();
	}
	
}
