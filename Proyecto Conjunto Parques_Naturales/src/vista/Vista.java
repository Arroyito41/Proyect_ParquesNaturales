package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;

public class Vista extends JFrame {

	public JPanel contentPane, panelPrincipal,  panelCLM, panelInfo;
	public JLabel lblLogo, lblParqueAlbacete, lblParqueCuenca, lblParqueGuada, lblParqueCiu, lblParqueToledo, lblMapaCLM, lblFiltro; 
	public JTextPane txtpnInformacion; 
	public JComboBox comboBoxFiltro;
	public JList list;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista frame = new Vista();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Vista() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 693, 599);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelPrincipal = new JPanel();
		panelPrincipal.setBackground(new Color(255, 250, 205));
		panelPrincipal.setBounds(0, 0, 677, 560);
		contentPane.add(panelPrincipal);
		panelPrincipal.setLayout(null);
		
		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon("img/logoClm.PNG"));
		lblLogo.setBounds(20, 11, 69, 69);
		panelPrincipal.add(lblLogo);
		
		panelCLM = new JPanel();
		panelCLM.setBackground(new Color(199, 21, 133));
		panelCLM.setBounds(263, 11, 404, 282);
		panelPrincipal.add(panelCLM);
		panelCLM.setLayout(null);
		
		lblParqueAlbacete = new JLabel("");
		lblParqueAlbacete.setIcon(new ImageIcon("img/chincheta.png"));
		lblParqueAlbacete.setBounds(253, 183, 77, 45);
		panelCLM.add(lblParqueAlbacete);
		
		lblParqueCuenca = new JLabel("");
		lblParqueCuenca.setIcon(new ImageIcon("img/chincheta.png"));
		lblParqueCuenca.setBounds(234, 106, 77, 45);
		panelCLM.add(lblParqueCuenca);
		
		lblParqueGuada = new JLabel("");
		lblParqueGuada.setIcon(new ImageIcon("img/chincheta.png"));
		lblParqueGuada.setBounds(172, 29, 77, 45);
		panelCLM.add(lblParqueGuada);
		
		lblParqueCiu = new JLabel("");
		lblParqueCiu.setIcon(new ImageIcon("img/chincheta.png"));
		lblParqueCiu.setBounds(118, 183, 77, 45);
		panelCLM.add(lblParqueCiu);
		
		lblParqueToledo = new JLabel("");
		lblParqueToledo.setIcon(new ImageIcon("img/chincheta.png"));
		lblParqueToledo.setBounds(95, 120, 77, 45);
		panelCLM.add(lblParqueToledo);
		
		lblMapaCLM = new JLabel("");
		lblMapaCLM.setIcon(new ImageIcon("img/mapaclm.jpg"));
		lblMapaCLM.setBounds(10, 11, 384, 260);
		panelCLM.add(lblMapaCLM);
		
		panelInfo = new JPanel();
		panelInfo.setBounds(20, 96, 225, 197);
		panelPrincipal.add(panelInfo);
		panelInfo.setLayout(null);
		
		txtpnInformacion = new JTextPane();
		txtpnInformacion.setEnabled(false);
		txtpnInformacion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtpnInformacion.setBounds(0, 0, 225, 197);
		panelInfo.add(txtpnInformacion);
		
		lblFiltro = new JLabel("FILTRO:");
		lblFiltro.setForeground(new Color(0, 0, 139));
		lblFiltro.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFiltro.setBounds(20, 331, 54, 14);
		panelPrincipal.add(lblFiltro);
		
		comboBoxFiltro = new JComboBox();
		comboBoxFiltro.setModel(new DefaultComboBoxModel(new String[] {"...", "CATEGOR\u00CDA", "PROVINCIA"}));
		comboBoxFiltro.setBounds(96, 327, 168, 22);
		panelPrincipal.add(comboBoxFiltro);
		
		list = new JList();
		list.setBounds(10, 370, 657, 179);
		panelPrincipal.add(list);
	}
}
