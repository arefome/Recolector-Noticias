package vista;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;


public class VentanaInfo extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblInformacionUsuarios;
	private JButton btnOk;
	private JScrollPane scrollPane;
	public JEditorPane editorPane;
	
	/**
	 * Create the Frame
	 */
	public VentanaInfo() {
		
		//Configuración de la ventana
		
		setBounds(100, 100, 487, 326);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		
		//Creación de elementos gráficos
		panel = new JPanel();
		lblInformacionUsuarios = new JLabel("Informacion Usuarios");
		btnOk = new JButton("OK");
		scrollPane = new JScrollPane();
		editorPane = new JEditorPane();
		
		//Configuración de elementos gráficos
		panel.setBackground(SystemColor.inactiveCaptionBorder);
		panel.setBounds(0, 0, 481, 297);
		panel.setLayout(null);
		scrollPane.setBounds(44, 54, 383, 201);
		lblInformacionUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		lblInformacionUsuarios.setBounds(57, 11, 365, 37);
		lblInformacionUsuarios.setLabelFor(this);
		lblInformacionUsuarios.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 28));
		btnOk.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 11));
		btnOk.setBounds(367, 263, 89, 23);
		btnOk.addActionListener(this);
		editorPane.setEditable(false);
		editorPane.setFont(new Font("Arial", Font.PLAIN, 12));
		
		//Incorporación de elementos gráficos a la ventana
		contentPane.add(panel);
		panel.add(btnOk);
		panel.add(lblInformacionUsuarios);
		panel.add(scrollPane);
		scrollPane.setViewportView(editorPane);
		
	}
	/**
	 * Metodo que responde a los botones
	 */
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==btnOk)
			this.setVisible(false);;
	}
}
