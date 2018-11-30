package Sistema;
/**
 * Tiempo maneja el transpaso del tiempo se toma la unidad minima el minuto.
 * @author villalvan
 *
 */
public class Tiempo {
	private static Tiempo tiempo;
	private static Integer minutos;
	// Se toma como intervalo de tiempo a medir, 120 min (2hs), es decir que en un dia va a haber 12 mediciones. 
	// Esto podria hacer una prueba de un tiempo considerable y aumentar el intervalo, si sigue dando igual,
	// Se mantiene el mayor. 
	// Conviene si que el valor sea multiplo de 1440. En caso de modificarlo, deberia cambiar la funcion getDia
	
	public static final Integer DELTAT = 120;
	public static final Integer DIAENMIN = 1440;
	public static final Integer ANIOENMIN = DIAENMIN*365;
	
	private Tiempo (){
		minutos = new Integer(0);
	}
	
	public static Tiempo crearTiempo(){
		if (tiempo == null){
			tiempo = new Tiempo();
		}
		return tiempo;
	}
	/**
	 * Actualiza el tiempo en el Delta de T determinado en minutos. 
	 */
	public static void Actualizar(){
		Tiempo.minutos += DELTAT;
	}
	
	/**
	 * Setea el tiempo actual en minutos. 
	 * @param minutos
	 */
	public static void setMinutos(Integer minutos){
		Tiempo.minutos = minutos;
	}
	
	/**
	 * Calcula el dia de acuerdo a los minutos transcurridos. 
	 * @return Devuelve el dia (Entero)
	 */
	public static Integer getDia(){
		return minutos/DIAENMIN;
	}
	
	/**
	 * 
	 * @return Deveuelve el tiempo transcurrido en minutos. 
	 */
	public static Integer getMinutos(){
		return minutos;
	}
}
