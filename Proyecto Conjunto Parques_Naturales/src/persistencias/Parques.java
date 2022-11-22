package persistencias;

import java.util.ArrayList;

public class Parques {
	ArrayList <Parque> listaParques;

	public Parques(ArrayList<Parque> listaParques) {
		super();
		this.listaParques = listaParques;
	}

	public Parques() {
		super();
	}

	public ArrayList<Parque> getListaParques() {
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
