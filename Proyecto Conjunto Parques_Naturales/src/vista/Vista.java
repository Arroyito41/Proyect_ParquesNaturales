package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.ImageIcon;

public class Vista extends JFrame {

	private JPanel contentPane;

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
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setBounds(0, 0, 677, 560);
		contentPane.add(panelPrincipal);
		panelPrincipal.setLayout(null);
		
		JLabel lblLogo = new JLabel("Logo");
		lblLogo.setBounds(20, 11, 225, 69);
		panelPrincipal.add(lblLogo);
		
		JPanel panelCLM = new JPanel();
		panelCLM.setBounds(263, 11, 404, 282);
		panelPrincipal.add(panelCLM);
		panelCLM.setLayout(null);
		
		JLabel lblParqueAlbacete = new JLabel("");
		lblParqueAlbacete.setIcon(new ImageIcon("C:\\Users\\jarro\\git\\repositoryProyectoConjunto\\Proyecto Conjunto Parques_Naturales\\img\\chincheta.png"));
		lblParqueAlbacete.setBounds(253, 183, 77, 45);
		panelCLM.add(lblParqueAlbacete);
		
		JLabel lblParqueCuenca = new JLabel("");
		lblParqueCuenca.setIcon(new ImageIcon("C:\\Users\\jarro\\git\\repositoryProyectoConjunto\\Proyecto Conjunto Parques_Naturales\\img\\chincheta.png"));
		lblParqueCuenca.setBounds(234, 106, 77, 45);
		panelCLM.add(lblParqueCuenca);
		
		JLabel lblParqueGuada = new JLabel("");
		lblParqueGuada.setIcon(new ImageIcon("C:\\Users\\jarro\\git\\repositoryProyectoConjunto\\Proyecto Conjunto Parques_Naturales\\img\\chincheta.png"));
		lblParqueGuada.setBounds(172, 29, 77, 45);
		panelCLM.add(lblParqueGuada);
		
		JLabel lblParqueCiu = new JLabel("");
		lblParqueCiu.setIcon(new ImageIcon("C:\\Users\\jarro\\git\\repositoryProyectoConjunto\\Proyecto Conjunto Parques_Naturales\\img\\chincheta.png"));
		lblParqueCiu.setBounds(118, 183, 77, 45);
		panelCLM.add(lblParqueCiu);
		
		JLabel lblParqueToledo = new JLabel("");
		lblParqueToledo.setIcon(new ImageIcon("C:\\Users\\jarro\\git\\repositoryProyectoConjunto\\Proyecto Conjunto Parques_Naturales\\img\\chincheta.png"));
		lblParqueToledo.setBounds(95, 120, 77, 45);
		panelCLM.add(lblParqueToledo);
		
		JLabel lblMapaCLM = new JLabel("");
		lblMapaCLM.setIcon(new ImageIcon("C:\\Users\\jarro\\git\\repositoryProyectoConjunto\\Proyecto Conjunto Parques_Naturales\\img\\mapaclm.jpg"));
		lblMapaCLM.setBounds(10, 11, 384, 260);
		panelCLM.add(lblMapaCLM);
		
		JPanel panelInfo = new JPanel();
		panelInfo.setBounds(20, 96, 225, 197);
		panelPrincipal.add(panelInfo);
		panelInfo.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Informacion");
		lblNewLabel.setBounds(30, 32, 171, 136);
		panelInfo.add(lblNewLabel);
		
		JLabel lblFiltro = new JLabel("FILTRO");
		lblFiltro.setBounds(20, 331, 46, 14);
		panelPrincipal.add(lblFiltro);
		
		JComboBox comboBoxFiltro = new JComboBox();
		comboBoxFiltro.setBounds(96, 327, 168, 22);
		panelPrincipal.add(comboBoxFiltro);
		
		JList list = new JList();
		list.setBounds(10, 370, 657, 179);
		panelPrincipal.add(list);
	}
}
