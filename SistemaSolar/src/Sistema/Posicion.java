package Sistema;


public class Posicion extends Punto{
	/**
	 * 
	 * @param r
	 * @param phi
	 */
	public Posicion(Double r, Double phi){
		super(r, phi);
	}	

	/**
	 * Calcula la distancia entra la coordenada y el parametro b
	 * @param b
	 * @return
	 */
	public Double distancia(Punto b){
		return Math.pow(Math.pow(b.getX()-this.getX(), 2) + Math.pow(b.getY()-this.getY(), 2),0.5);
	}
	
}
