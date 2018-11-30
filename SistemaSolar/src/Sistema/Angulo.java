package Sistema;
/**
 * 
 * @author villalvan
 *
 */
public class Angulo {
	// El angulo esta expresado en Grados
	private Double angulo;
	
	public Angulo(Double angulo){
		this.angulo = angulo;
	}
	
	public Angulo(Integer x, Integer y){
		angulo = Math.toDegrees((Math.atan2(y.doubleValue(), x.doubleValue())));
	}
	
	/**
	 * 
	 * @return angulo en grados
	 */
	public Double getAngulo(){
		return angulo;
	}
	
	/**
	 * Calcula las vueltas de un angulo
	 * @return devuelve un entero correspondiente a la cantidad de vueltas.
	 */
	public Integer getVueltas(){
		Double aux = angulo/360.0;
		return aux.intValue();
	}

	/**
	 * Calcula el angulo en Radianes
	 * @return Devuelve angulo en radianes.
	 */
	public Double getAnguloRad(){
		return Math.toRadians(angulo);
	}
	/**
	 * Calcula el valor absoluto de un angulo entre [0,360)
	 * @return el angulo en grados
	 */
	public Double getAnguloAbs(){
		Double anguloAbs;
		if (angulo<0)
			anguloAbs = angulo+((1-this.getVueltas())*360);
		else 
			anguloAbs = angulo-(this.getVueltas()*360);
		return anguloAbs;
	}
	
	/**
	 * Devuelve la pendiente, es decir el angulo en el semiplano superior.
	 * Si el angulo absoluto esta en el semiplano inferior (180,360), le resta 180. 
	 * @return Pendiente en grados [0,180]
	 */
	public Double getPendiente(){
		Double pendiente = this.getAnguloAbs();
		if(pendiente>180)
			pendiente-=180;
		return pendiente;
	}
	
	/**
	 * Suma dos angulos angulos
	 * @param sumando Definido en Grados
	 */
	public void sumar(Double sumando){
		angulo += sumando;
	}

	public void setAngulo(double angulo) {
		this.angulo = angulo;
	}
	
}
