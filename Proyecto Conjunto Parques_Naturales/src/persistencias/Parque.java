package persistencias;

public class Parque {
	
	private String categoria;
	private String provincia;
	
	public Parque() {
		
	}
	
	public Parque(String categoria, String provincia) {
		
		this.categoria = categoria;
		this.provincia = provincia;
	}
	
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	
	@Override
	public String toString() {
		return "Parque [categoria=" + categoria + ", provincia=" + provincia + "]";
	}
	
	
	
	
}
