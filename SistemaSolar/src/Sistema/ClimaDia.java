package Sistema;

public class ClimaDia {

	Integer dia;
	String clima;
	
	public ClimaDia(Integer dia, TipoClima clima){
		this.dia = dia;
		this.clima = clima.toString();
	}
}
