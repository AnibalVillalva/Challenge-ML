package Sistema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/**
 * 
 * @author villalvan
 *
 */
public class SistemaMeteorologico {	
 
	/**
	 * Es la funcion principal que se encarga de recorrer los dias y determinar el clima.
	 * @param args
	 */
	public static void main (String [ ] args) {
		ArrayList<Integer> diasDeLluviaIntensa = new ArrayList<Integer>();
		Map<TipoClima,Integer> PeriodosClimaticos = new HashMap<TipoClima,Integer>();
		ArrayList<ClimaDia> clima = new ArrayList<ClimaDia>();
		
		Double PerimetroMaximo = 0.0;
		Double PerimetroActual = 0.0;
		Integer diaLluviaIntenso =0;
		Integer fecha = 0;
		Integer fechaAnterior = 0;
		
		Exportador exportar = new Exportador(".\\clima.json");

		PeriodosClimaticos.put(TipoClima.LLUVIA, 0);
		PeriodosClimaticos.put(TipoClima.OPTIMO, 0);
		PeriodosClimaticos.put(TipoClima.SEQUIA, 0);

		
		SistemaSolar sistemaSolar;
		
		
		TipoClima climaDia = TipoClima.DEFAULT;
	    TipoClima climaActual = TipoClima.DEFAULT;
	    TipoClima climaAnterior = TipoClima.DEFAULT;
	    // Ferengi
	    sistemaSolar = new SistemaSolar(new Posicion(5E5, 0.0), 1.0 );
	    // Betasoide
	    sistemaSolar.agregarPlaneta(new Posicion(2E6, 0.0), 3.0 );
	    // Vulcano
	    sistemaSolar.agregarPlaneta(new Posicion(1E6, 0.0), -5.0 );
	      		
	    
   		while (Tiempo.getMinutos()<10*Tiempo.ANIOENMIN){
	    	fecha = Tiempo.getDia();
	    	climaActual = determinarTipoClima(sistemaSolar);
	    	 
	    	/*
	    	 * Se fija si es un dia lluvia y compara con el perimetro del triangulo maximo del periodo.
	    	 * Si es mayor, entonces aun no llegue al pico y lo guarda como maximo. 
	    	 * Guarda en una variable el dia que fue el pico maximo de lluvia del periodo. 
	    	 */
	    	if(climaActual == TipoClima.LLUVIA){
	    		PerimetroActual = sistemaSolar.getPerimetro();
	    		if (PerimetroActual > PerimetroMaximo){
	    			PerimetroMaximo = PerimetroActual;
	    			diaLluviaIntenso = fecha;
	    		}
	    	}
	    	else {
	    		/*
	    		 * La siguiente condicion se da por si el maximo perimetro se da en el ultimo dia
	    		 * del periodo. Como se esta midiendo mas de una vez al dia, se pone ">=".
	    		 * Luego se resetea el dia de lluvia intenso, para que no vuelva a grabarlo.
	    		 */
	    		if (PerimetroMaximo != 0){
	    			diasDeLluviaIntensa.add(diaLluviaIntenso);
	    			PerimetroMaximo = 0.0;
	    		}
	    		
	    	}
	    	/* Sumo los acumuladores de los periodos
	    	 * Si el dia anterior hubo otro clima, entonces empieza un nuevo periodo.
	    	 * Ademas chequeo que no sea un tipo de clima indefinido en el enunciado.
	    	 */
	    	if (climaActual != climaAnterior && climaActual != TipoClima.DEFAULT){
	    		PeriodosClimaticos.put(climaActual, PeriodosClimaticos.get(climaActual) + 1);
	    	}
	    	
	    	/*
	    	 * Se Determina que clima hizo en el dia, ponderando el tipo. 
	    	 * Esto es porque para los casos de sequia y optimo, son casos puntuales y
	    	 * para mejorar la medicion se toman intervalos de tiempo menores a un dia.
	    	 * Ademas sabiendo que no puede haber en el mismo dia un caso de sequia y optimo, 
	    	 * solo se tiene en cuenta que no sea de lluvia y default.  
	    	 */
	    	if(fechaAnterior.equals(fecha)){
	    		if(climaDia != climaActual &&
	    		   (climaActual != TipoClima.LLUVIA || climaActual != TipoClima.DEFAULT)){
	    				climaDia = climaActual;
	    		}
	        }
	    	else{ // Cambio de dia. Guardo el clima del dia de ayer.
	    		clima.add(new ClimaDia(fecha-1,climaDia));
	    		climaDia = climaActual;
	    	}

	    	climaAnterior = climaActual;
	    	sistemaSolar.actualizarT();
	    	fechaAnterior = fecha;
	    }
   		
   		// En caso que el ultimo dia medido sea de lluvia, se guarda el dia de lluvia intensa.
   		if (climaActual == TipoClima.LLUVIA){
   			diasDeLluviaIntensa.add(diaLluviaIntenso);
   		}
   			

	    System.out.println("Periodos de " + TipoClima.SEQUIA+": "+PeriodosClimaticos.get(TipoClima.SEQUIA));
	    System.out.println("Periodos de " + TipoClima.LLUVIA+": "+PeriodosClimaticos.get(TipoClima.LLUVIA));
	    System.out.println("Periodos de " + TipoClima.OPTIMO+": "+PeriodosClimaticos.get(TipoClima.OPTIMO));
	    System.out.println("Dias de lluvia intensa: "+diasDeLluviaIntensa);
	    try{
	    	exportar.toJSON(clima);
	    }
	    catch (Exception e){
	    	System.out.println("No se pudo exportar");
	    }

	}
	    	
	    
	/**
	 * Determina el Tipo de Clima del momento de acuerdo a la ubicacion de los astros.
	 * Se deja el periodo de Lluvia a lo ultimo ya que depende si los planetas forman un 
	 * triangulo que contiene al sol. En los casos anteriores sucede en casos puntuales. 
	 * @param sistemaSolar
	 * @return TipodeClima
	 */
	private static TipoClima determinarTipoClima(SistemaSolar sistemaSolar){
		TipoClima periodoClima;
		if (esPeriodoSequia(sistemaSolar)){
			periodoClima = TipoClima.SEQUIA;
		}
		else if (esCondicionesOptimas(sistemaSolar)){
			periodoClima = TipoClima.OPTIMO;
		}
		else if (esPeriodoLluvia(sistemaSolar)){
			periodoClima = TipoClima.LLUVIA;
		}
		else{
            periodoClima = TipoClima.DEFAULT;
        }	
 		return periodoClima;
	}
	
	/**
	 * Esto sucede cuando estan alineados con el sol.
	 * @return
	 */
	private static Boolean esPeriodoSequia(SistemaSolar sistemaSolar){
		return sistemaSolar.estanAlineadosConElSol();
	}
	
	/**
	 * Esto sucede cuando los planetas forman un triangulo y contiene al sol.
	 * Si el perimetro es maximo tiene un pico de intensidad
	 * @return
	 */
	private static Boolean esPeriodoLluvia(SistemaSolar sistemaSolar){
		return sistemaSolar.trianguloContenieneSol();
	}
	
	/**
	 * Esto sucede cuando los planetas estan alineados, pero no con el sol.
	 * @return
	 */
	private static Boolean esCondicionesOptimas(SistemaSolar sistemaSolar){
		return sistemaSolar.estanAlineadosSinElSol();
	}
}
