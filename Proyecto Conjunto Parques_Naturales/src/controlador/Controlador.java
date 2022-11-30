package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import org.json.JSONArray;
import org.json.JSONObject;

import persistencias.Parque;
import persistencias.Parques;
import vista.Vista;

public class Controlador implements ActionListener {

	Vista vista = new Vista();
	int provincia=1;
	String contenido;
	
	public Connection createConnection() throws SQLException, FileNotFoundException, IOException, ClassNotFoundException {
		
		Connection connection = null;
		
		try {
			Properties config = new Properties();
			config.load(new FileReader("src/resources/database.properties"));
			String driver = config.getProperty("database.driver");
			String url = config.getProperty("database.url");
			String user = config.getProperty("database.user");
			String password = config.getProperty("database.password");
			
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password);
			connection.setAutoCommit(false);
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		return connection;
	}
	
	public String peticionHttpGet(String urlParaVisitar) throws Exception {
		
		StringBuilder resultado = new StringBuilder();
		
		URL url = new URL(urlParaVisitar);

		// Abrir la conexi�n e indicar que ser� de tipo GET
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
	
	public void generarFichero() {
		
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
			// Manejar excepci�n
			e.printStackTrace();
		}
	}
	
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
	
	public Controlador (Vista vista) {
		this.vista=vista;
		this.vista.comboBoxSeleccionFiltro.addActionListener(this);
		this.vista.comboBoxFiltro.addActionListener(this);
		this.vista.btnFiltrar.addActionListener(this);
		this.vista.btnIniciarApp.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == vista.btnIniciarApp) {
			
			vista.panelPrincipal.setVisible(true);
			vista.panelInfo.setVisible(false);
			vista.btnIniciarApp.setVisible(false);
			
			generarFichero();
			try {
				contenido = leerFichero("parques_naturales.json");
				
			} catch (SQLException | IOException e1) {
				e1.printStackTrace();
			}
			try {
				convertirStringToArrayJson(contenido);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			try {
				createConnection();
			} catch (ClassNotFoundException | SQLException | IOException e2) {
				e2.printStackTrace();
			}
			
		}
		
		if(e.getSource()== vista.btnFiltrar) {
	
			if (vista.comboBoxFiltro.getModel().getSelectedItem().equals("PROVINCIA")) {
				 vista.comboBoxSeleccionFiltro.setModel(new DefaultComboBoxModel(new String[] {"...", "CIUDAD REAL", "TOLEDO", "ALBACETE", "CUENCA", "GUADALAJARA"}));
			} else if (vista.comboBoxFiltro.getModel().getSelectedItem().equals("CATEGORIA")) {
				vista.comboBoxSeleccionFiltro.setModel(new DefaultComboBoxModel(new String[] {"...", "PAISAJE PROTEGIDO", "MONUMENTO NATURAL", "RESERVA FLUVIAL", "MICRORESERVA", "RESERVA NATURAL", "PARQUE NATURAL", "PARQUE NACIONAL"}));
			}
		}
	}
}
