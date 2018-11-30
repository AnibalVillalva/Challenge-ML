package Sistema;

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
	
	public Double getvAngularPorMin() {
		return vAngular;
	}
	
	public Posicion getPosicion() {
		return p;
	}
	
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
	
	public void actualizar(){
		this.moverA(Tiempo.getMinutos());
	}
}
