package Sistema;
/**
 * 
 * @author villalvan
 *
 */
public class Recta {
	Punto p1;
	Double pendiente;
	static Double Error = 1.0;
	
	public Recta(Punto p1, Punto p2){
		this.p1 = p1;
		pendiente = (p1.menos(p2)).getAngulo().getPendiente();
	}
	/**
	 * La siguiente funcion verifica que el punto este dentro de la recta.
	 * para esto verifica que la pendiente de uno sea similar al otro.
	 * @param p3
	 * @return
	 */
	public Boolean contienePunto(Punto p3){
		Double pendiente2 = (p1.menos(p3)).getAngulo().getPendiente();
		if (Math.abs(pendiente2 - pendiente) < Error ){
			return true;
		}
		return false;
	}
}
