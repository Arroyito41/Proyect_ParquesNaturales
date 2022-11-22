package persistencias;

public class Parque {
	private long id_parque;
	private String categoria;
	private String provincia;
	private String informacion;
	
	public Parque(long id_parque, String categoria, String provincia, String informacion) {
		super();
		this.id_parque = id_parque;
		this.categoria = categoria;
		this.provincia = provincia;
		this.informacion = informacion;
	}
	
	public Parque() {
		super();
	}
	public long getId_parque() {
		return id_parque;
	}
	public void setId_parque(long id_parque) {
		this.id_parque = id_parque;
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
	public String getInformacion() {
		return informacion;
	}
	public void setInformacion(String informacion) {
		this.informacion = informacion;
	}
	
	@Override
	public String toString() {
		return "Parque [id_parque=" + id_parque + ", categoria=" + categoria + ", provincia=" + provincia
				+ ", informacion=" + informacion + "]";
	}
	
	
	
	
}
