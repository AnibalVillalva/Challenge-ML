package Sistema;
/**
 * 
 * @author villalvan
 *
 */
public final class TipoClima {
	private String clima;
	
	private TipoClima(String tipo){
		clima = tipo;
	}
	
	public String toString(){
		return clima;
	}
	
	public final static TipoClima
		LLUVIA = new TipoClima("Lluvia"),
		LLUVIAINTENSA = new TipoClima("Lluvia intensa"),
		OPTIMO = new TipoClima("Clima Optimo"),
		SEQUIA = new TipoClima("Sequia"),
	    DEFAULT = new TipoClima("Indefinido");
	
	public final static TipoClima[] tipo = {
		LLUVIA, LLUVIAINTENSA, OPTIMO, SEQUIA, DEFAULT
	};


}
