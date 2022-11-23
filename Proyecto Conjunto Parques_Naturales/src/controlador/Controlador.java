package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;

import vista.Vista;

public class Controlador implements ActionListener {

	Vista vista = new Vista();
	int posicion;
	
	public Controlador (Vista vista) {
		
		this.vista.comboBoxSeleccionFiltro.addActionListener(this);
		this.vista.comboBoxFiltro.addActionListener(this);
		this.vista.btnFiltrar.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == vista.btnFiltrar) {
			
			posicion = this.vista.comboBoxSeleccionFiltro.getSelectedIndex();
			
			if(posicion == 2) {
				this.vista.comboBoxFiltro.setModel(new DefaultComboBoxModel(new String [] {"...", "CIUDAD REAL", "TOLEDO", "ALBACETE", "CUENCA", "GUADALAJARA"}));
				//vista.comboBoxFiltro.addItem("CIUDAD REAL");
			}
		}
	}

}
