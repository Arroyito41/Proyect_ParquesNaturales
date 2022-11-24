package json;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;

import persistencias.Parque;
import persistencias.Parques;

public class CodigoJson {
	
	public String leerFichero (String pathname) throws SQLException, IOException{
		
		String fichero = "";
		
		BufferedReader br = null;
		FileReader fr = null;
		
		try {
			fr = new FileReader(pathname);
			br = new BufferedReader(fr);
			
			String linea = "";
			
			while((linea = br.readLine()) != null) {
				fichero = fichero + linea;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return fichero;
	}
	
	public void convertirStringToArrayJson (String fichero) throws Exception{
		
		Parques parques = new Parques();
		JSONArray jsonArray = new JSONArray(fichero);
		
		for (int i = 0; i < jsonArray.length(); i++) {
		    JSONObject explrObject = jsonArray.getJSONObject(i);
		    
		    String categoria = (String) ((JSONObject)jsonArray.get(i)).get("ESPACIOS NATURALES PROTEGIDOS EN CASTILLA-LA MANCHA (2018)");
		    String provincia = (String) ((JSONObject)jsonArray.get(i)).get("");
		    
		    Parque parque = new Parque(categoria, provincia);
		    parques.getListaParques().add(parque);
		}
	}
	
	public static String peticionHttpGet(String urlParaVisitar) throws Exception {
		
		StringBuilder resultado = new StringBuilder();
		
		URL url = new URL(urlParaVisitar);

		// Abrir la conexión e indicar que será de tipo GET
		HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
		conexion.setRequestMethod("GET");
		BufferedReader br = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
		String linea;
		// Mientras el BufferedReader se pueda leer, agregar contenido a resultado
		while ((linea = br.readLine()) != null) {
			resultado.append("\r\n" + linea);
		}
		br.close();
		// Regresar resultado, pero como cadena, no como StringBuilder
		return resultado.toString();
	}
	
	public static void main(String[] args) throws Exception {
		
		String url = "https://datosabiertos.castillalamancha.es/sites/datosabiertos.castillalamancha.es/files/espacios%20naturales.json";
		String json = "";
		
		CodigoJson helper = new CodigoJson();
		
		Parques parques = new Parques();
		
		FileWriter fw = null;
		
		try {
			json = peticionHttpGet(url);
			
			File file = new File("parques_naturales.json");
			fw =  new FileWriter(file);
			fw.write(json);
			fw.flush();
			
		} catch (Exception e) {
			// Manejar excepción
			e.printStackTrace();
		}
		String contenido = helper.leerFichero("parques_naturales.json");
		helper.convertirStringToArrayJson(contenido);
		
	}

}
