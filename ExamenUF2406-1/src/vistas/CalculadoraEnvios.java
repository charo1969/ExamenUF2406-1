package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Envio;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CalculadoraEnvios extends JFrame {

	private JPanel contentPane;
	private JTextField txtCiudadO;
	private JTextField txtCiudadD;
	private final ButtonGroup grupoOrigen = new ButtonGroup();
	private final ButtonGroup grupoDestino = new ButtonGroup();
	private JComboBox comboTipo;
	private JSpinner spinnerPeso;
	private JRadioButton rbdNacionalO;
	private JRadioButton rbdNacionalD;
	private JRadioButton rbdExtranjeroD;
	private JRadioButton rbdExtrajeroO;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculadoraEnvios frame = new CalculadoraEnvios();
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
	public CalculadoraEnvios() {
		setTitle("Calculadora de Envios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][grow][]", "[][][][][][][][][]"));
		
		JLabel lblNewLabel = new JLabel("Ciudada Origen:");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(lblNewLabel, "cell 1 1,alignx trailing");
		
		txtCiudadO = new JTextField();
		txtCiudadO.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(txtCiudadO, "cell 2 1,growx");
		txtCiudadO.setColumns(10);
		
		rbdNacionalO = new JRadioButton("Nacional");
		grupoOrigen.add(rbdNacionalO);
		rbdNacionalO.setSelected(true);
		rbdNacionalO.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(rbdNacionalO, "flowx,cell 2 2");
		
		JLabel lblNewLabel_1 = new JLabel("Ciudad Destino:");
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(lblNewLabel_1, "cell 1 3,alignx trailing");
		
		txtCiudadD = new JTextField();
		txtCiudadD.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(txtCiudadD, "cell 2 3,growx");
		txtCiudadD.setColumns(10);
		
		rbdNacionalD = new JRadioButton("Nacional");
		grupoDestino.add(rbdNacionalD);
		rbdNacionalD.setSelected(true);
		rbdNacionalD.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(rbdNacionalD, "flowx,cell 2 4");
		
		rbdExtranjeroD = new JRadioButton("Extranjero");
		grupoDestino.add(rbdExtranjeroD);
		rbdExtranjeroD.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(rbdExtranjeroD, "cell 2 4");
		
		JLabel lblNewLabel_2 = new JLabel("Tipo de Envio:");
		lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(lblNewLabel_2, "cell 1 5,alignx trailing");
		
		comboTipo = new JComboBox();
		comboTipo.setModel(new DefaultComboBoxModel(new String[] {"Pag 10 - Antes de las 10 h", "Pag 14 - Antes de las 14 h", "Pag 24 - Al día siguiente"}));
		comboTipo.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(comboTipo, "cell 2 5,growx");
		
		JLabel lblNewLabel_3 = new JLabel("Peso:");
		lblNewLabel_3.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(lblNewLabel_3, "cell 1 6,alignx right");
		
		spinnerPeso = new JSpinner();
		spinnerPeso.setModel(new SpinnerNumberModel(1, 1, 40, 1));
		spinnerPeso.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(spinnerPeso, "cell 2 6");
		
		rbdExtrajeroO = new JRadioButton("Extranjero");
		grupoOrigen.add(rbdExtrajeroO);
		rbdExtrajeroO.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(rbdExtrajeroO, "cell 2 2");
		
		JPanel panel = new JPanel();
		contentPane.add(panel, "cell 2 8,grow");
		
		JButton btnCalcularPrecio = new JButton("Calcular Precio");
		btnCalcularPrecio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ValidarPrecio();
			}
			
		});
		btnCalcularPrecio.setFont(new Font("Verdana", Font.PLAIN, 14));
		panel.add(btnCalcularPrecio);
	}

	protected void ValidarPrecio() {
		if(txtCiudadO.getText() == null || txtCiudadO.getText().isBlank() ||
				txtCiudadD.getText() == null || txtCiudadD.getText().isBlank()) {
			JOptionPane.showMessageDialog(this, "Debe introducir los datos de origen y destino",
					"Compruebe los datos",JOptionPane.WARNING_MESSAGE);
		}
		String ciudadO = txtCiudadO.getText();
		
		String ciudadD = txtCiudadD.getText();
		String tipoEnvio = (String) comboTipo.getSelectedItem();
		int peso = (int) spinnerPeso.getValue();
		
		Envio e = new Envio("Montilla",true,"Cordoba",true,"Antes de las 10 h",5);
		
		
	}

}
