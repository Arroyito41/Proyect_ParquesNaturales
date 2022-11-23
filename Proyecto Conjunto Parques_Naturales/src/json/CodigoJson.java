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

import com.fasterxml.jackson.databind.ObjectMapper;

import persistencias.Parques;

public class CodigoJson {

	public Parques fromStringToObject(String fichero) {
		
		Parques parques = null;
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			parques = mapper.readValue(new File(leerFichero(fichero)), Parques.class);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return parques;
	}
	
	public String leerFichero (String pathname) throws SQLException, IOException{
		
		String fichero = "";
		
		BufferedReader br = null;
		FileReader fr = null;
		
		try {
			fr = new FileReader(pathname);
			br = new BufferedReader(fr);
			
			String linea = "";
			
			while((linea=br.readLine())!=null)
	            fichero = linea;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return fichero;
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
	
	public static void main(String[] args) {
		
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
		
		parques = helper.fromStringToObject("parques_naturales.json");

	}

}
