package Sistema;
/**
 * 
 * @author villalvan
 *
 */
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
    
    /**
     * 
     * @return Devuelve la distancia al origen.
     */
	public Double getRadio() {
		return r;
	}

	/**
	 * 
	 * @return Devuelve el angulo del punto. No es absoluto puede ir de -infinito a +infinito.
	 */
	public Angulo getAngulo() {
		return phi;
	}

	/**
	 * 
	 * @return Devuelve la commponente X de las coordenadas cartesianas.
	 */
	public Integer getX(){
		return (int) (this.getRadio()*Math.cos(this.getAngulo().getAnguloRad()));
	}
	
	/**
	 * 
	 * @return Devuelve la commponente Y de las coordenadas cartesianas.
	 */
	public Integer getY(){
		
		return (int) (this.getRadio()*Math.sin(this.getAngulo().getAnguloRad()));
	}

	public void setPhi(Angulo phi) {
		this.phi = phi;
	}
	
	/**
	 * 
	 * @param p2
	 * @return Devuelve un vector con la resta entre ambos.
	 */
	public Punto menos(Punto p2){
		return new Punto(this.getX()-p2.getX(),this.getY()-p2.getY());
	}
	
	/**
	 * 
	 * @return Devuelve la condicion que este en semiplano superior, podria estar en el eje X.
	 */
	public Boolean estaSemiplanoSuperior(){
		return phi.getAnguloAbs() <= 180;
	}
	
	/**
	 * 
	 * @return Devuelve la condicion que este en semiplano inferior, podria estar en el eje X.
	 */
	public Boolean estaSemiplanoInferior(){
		return (phi.getAnguloAbs() >= 180 || phi.getAnguloAbs() == 0);
	}
	
	/**
	 * 
	 * @return Devuelve la condicion que este en el Eje X.
	 */
	public Boolean estaEnEjeX(){
		return phi.getPendiente() == 0;
	}
}
