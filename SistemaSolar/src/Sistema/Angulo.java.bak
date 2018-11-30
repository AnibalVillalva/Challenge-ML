package Sistema;

public class Angulo {
	// El angulo esta expresado en Grados
	private Double angulo;
	
	public Angulo(Double angulo){
		this.angulo = angulo;
	}
	
	public Angulo(Integer x, Integer y){
		angulo = Math.toDegrees((Math.atan2(y.doubleValue(), x.doubleValue())));
	}
	
	public Double getAngulo(){
		return angulo;
	}
	
	public Integer getVueltas(){
		Double aux = angulo/360.0;
		return aux.intValue();
	}
	
	public Double getAnguloRad(){
		return Math.toRadians(angulo);
	}
	/**
	 * 
	 * @return el angulo entre [0 y 360)
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
	 * Devuelve la pendiente, el angulo en el semiplano superior 
	 * @return
	 */
	public Double getPendiente(){
		Double pendiente = this.getAnguloAbs();
		if(pendiente>180)
			pendiente-=180;
		return pendiente;
	}
	/**
	 * 
	 * @param sumando Definido en Grados
	 */
	public void sumar(Double sumando){
		angulo += sumando;
	}

	public void setAngulo(double angulo) {
		this.angulo = angulo;
	}

	
}
