package Sistema;

public class Punto {
	
    private Double r;
    private Angulo phi;
   /**
    * Coordenadas en polares
    * @param r es el radio
    * @param phi es un angulo en grados
    */              
    public Punto(Double r, Double phi){
    	this.r = r;
    	this.phi = new Angulo(phi);
    }

    /**
     * Constructo en base a coordenadas cartesianas
     * Se considera que como los valores superan los miles, se usa enteros
     * ya que el error es despreciable en decimos.
     * @param x Entero
     * @param y Entero
     */
    public Punto(Integer x, Integer  y){
    	r = Math.pow(x*x+y*y, 0.5);
    	phi = new Angulo( x, y);
    }
	public Double getRadio() {
		return r;
	}

	public Angulo getAngulo() {
		return phi;
	}

	public Integer getX(){
		return (int) (this.getRadio()*Math.cos(this.getAngulo().getAnguloRad()));
	}
	public Integer getY(){
		
		return (int) (this.getRadio()*Math.sin(this.getAngulo().getAnguloRad()));
	}

	public void setPhi(Angulo phi) {
		this.phi = phi;
	}
	
	/**
	 * 
	 * @param p2
	 * @return un vector con la resta.
	 */
	public Punto menos(Punto p2){
		return new Punto(this.getX()-p2.getX(),this.getY()-p2.getY());
	}
	
	public Boolean estaSemiplanoSuperior(){
		return phi.getAnguloAbs() <= 180;
	}
	
	public Boolean estaSemiplanoInferior(){
		return (phi.getAnguloAbs() >= 180 || phi.getAnguloAbs() == 0);
	}
	
	public Boolean estaEnEjeX(){
		return phi.getPendiente() == 0;
	}
}
