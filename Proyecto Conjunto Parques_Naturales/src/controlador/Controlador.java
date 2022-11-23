package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import vista.Vista;

public class Controlador implements ActionListener {

	Vista vista = new Vista();
	int provincia=1;
	
	public Controlador (Vista vista) {
		this.vista=vista;
		this.vista.comboBoxSeleccionFiltro.addActionListener(this);
		this.vista.comboBoxFiltro.addActionListener(this);
		this.vista.btnFiltrar.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()== vista.btnFiltrar) {
	
			if (vista.comboBoxFiltro.getModel().getSelectedItem().equals("PROVINCIA")) {
				 vista.comboBoxSeleccionFiltro.setModel(new DefaultComboBoxModel(new String[] {"...", "CIUDAD REAL", "TOLEDO", "ALBACETE", "CUENCA", "GUADALAJARA"}));
			} else if (vista.comboBoxFiltro.getModel().getSelectedItem().equals("CATEGORIA")) {
				vista.comboBoxSeleccionFiltro.setModel(new DefaultComboBoxModel(new String[] {"...", "PAISAJE PROTEGIDO", "MONUMENTO NATURAL", "RESERVA FLUVIAL", "MICRORESERVA", "RESERVA NATURAL", "PARQUE NATURAL", "PARQUE NACIONAL"}));
			}
			
			
		}
		
			
	}

}
