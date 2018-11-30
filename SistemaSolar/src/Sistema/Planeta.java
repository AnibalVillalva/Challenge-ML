package Sistema;
/**
 * 
 * @author villalvan
 *
 */
public class Planeta {
	private Posicion p;
	private static Double anguloInicial;
	// Velocidad angular medida en Grados/minutos
	private Double vAngular;
	
	/**
	 * Planeta s
	 * @param p Poscion Polar
	 * @param velAngular (Grados/Dia)
	 */
	public Planeta (Posicion p , Double velAngular){
		this.p = p;
		anguloInicial= this.p.getAngulo().getAngulo();
		this.vAngular = velAngular.doubleValue()/Tiempo.DIAENMIN;
		
	}
	
	/**
	 * 
	 * @return Devuelve la velocidad angular
	 */
	public Double getvAngularPorMin() {
		return vAngular;
	}
	/**
	 * 
	 * @return Devuelve la posicion del planeta
	 */
	public Posicion getPosicion() {
		return p;
	}
	
	/**
	 * 
	 * @return Devuelve el phi del planeta expresado en un angulo entre [0,360)
	 */
	public Double getPhi(){
		return p.getAngulo().getAnguloAbs();
	}
	
	/**
	 * Genera el movimiento en un periodo de tiempo T de acuerdo a la velocidad Angular.
	 * @param periodoTiempo en minutos
	 */
	private void moverA(Integer periodoTiempo){
		this.p.getAngulo().setAngulo(vAngular*periodoTiempo+anguloInicial);
	}
	
	/**
	 * Genera la traslacion del planeta de acuerdo al Delta de Tiempo determinado en el sistema.
	 */
	public void actualizar(){
		this.moverA(Tiempo.getMinutos());
	}
}
