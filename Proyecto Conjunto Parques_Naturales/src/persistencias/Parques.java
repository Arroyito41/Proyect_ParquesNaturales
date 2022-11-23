package persistencias;

import java.util.ArrayList;

public class Parques {
	
	private ArrayList <Parque> listaParques = null;

	public Parques() {
		
	}

	public ArrayList<Parque> getListaParques() {
		if(null == listaParques) {
			listaParques = new ArrayList<Parque>();
		}
		return listaParques;
	}

	public void setListaParques(ArrayList<Parque> listaParques) {
		this.listaParques = listaParques;
	}

	@Override
	public String toString() {
		return "Parques [listaParques=" + listaParques + "]";
	}
}
