package json;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DescargarJson {

	public static String peticionHttpGet(String urlParaVisitar) throws Exception {
		// Esto es lo que vamos a devolver
		StringBuilder resultado = new StringBuilder();
		// Crear un objeto de tipo URL
		URL url = new URL(urlParaVisitar);

		// Abrir la conexión e indicar que será de tipo GET
		HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
		conexion.setRequestMethod("GET");
		// Búferes para leer
		BufferedReader rd = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
		String linea;
		// Mientras el BufferedReader se pueda leer, agregar contenido a resultado
		while ((linea = rd.readLine()) != null) {
			resultado.append("\r\n" + linea);
		}
		// Cerrar el BufferedReader
		rd.close();
		// Regresar resultado, pero como cadena, no como StringBuilder
		return resultado.toString();
	}
	
	public static void main(String[] args) {
		
		String url = "https://datosabiertos.castillalamancha.es/sites/datosabiertos.castillalamancha.es/files/espacios%20naturales.json";
		String json = "";
		
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

	}

}
