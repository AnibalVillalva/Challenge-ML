package Sistema;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;

/**
 * 
 * @author villalvan
 *
 */

public class Exportador {
	String path;
	
	public Exportador(String path){
		this.path = path;
	}
	/**
	 * Exporta la lista de clima a un archivo con formato JSON
	 * @param dias
	 * @throws JsonIOException
	 * @throws IOException
	 */
	public void toJSON(ArrayList<ClimaDia> dias) throws JsonIOException, IOException{

		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		try (FileWriter writer = new FileWriter(path)) {
				gson.toJson(dias, writer);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
