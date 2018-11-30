package Sistema;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;



public class Exportador {
	String path;
	
	public Exportador(String path){
		this.path = path;
	}
	
	public void toJSON(ArrayList<ClimaDia> dias) throws JsonIOException, IOException{

		Gson gson = new Gson();

		try (FileWriter writer = new FileWriter(path)) {
			for(ClimaDia dia : dias){
				gson.toJson(dia, writer);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
