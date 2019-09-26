package vista;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import logica.CuentaUsuario;
import logica.Noticia;
import logica.RecolectorNoticias;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class VentanaLogin extends JFrame implements ActionListener{

	//Atributos de clase
	private JPanel contentPane;
	private JTextField txtFsf;
	private JPasswordField pwdContrasea;
	private JLabel lblIniciarSesion;
	private ArrayList<CuentaUsuario> listaUsuarios;
	private CuentaUsuario user;
	private int actual;
	private JButton btnSalir;
	private JButton btnIngresar;
	private JButton btnLimpiar;
	protected boolean conf;
	private JButton btnSiguiente;
	private JLabel logo;
	private JButton btnAniadir;
	private JButton btnEliminar;
	private JLabel lblIngresos;
	private JButton btnInfo;
	private JButton btnEliminarLista;
	private RecolectorNoticias noticias;

	/**
	 * Create the Frame
	 */
	public VentanaLogin() {
		
		JOptionPane.showMessageDialog(null,"Cargando...Por favor Espere");
		
		//Configuración de la ventana
		setTitle("Noti-Ya");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 503, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		setLocationRelativeTo(null);
		setResizable(false);
		
		//Creación de elementos gráficos
		JPanel panel =new JPanel();
		JPanel panel_1 = new JPanel();
		JLabel lblUser = new JLabel("Usuario:");
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		txtFsf = new JTextField();
		pwdContrasea = new JPasswordField();
		btnIngresar = new JButton("");
		btnSalir = new JButton("Salir");
		btnLimpiar = new JButton("limpiar");
		btnSiguiente = new JButton(">");
		logo = new JLabel("");
		btnAniadir = new JButton("+");
		btnEliminar = new JButton("-");
		btnEliminarLista = new JButton("Eliminar lista");
		btnInfo = new JButton("");
		
		
		//Configuración de los elemntos gráficos
		panel.setBorder(null);
		panel.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblIniciarSesion = new JLabel("Noti-Ya");
		lblIniciarSesion.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 38));
		panel.add(lblIniciarSesion);
		
		
		panel_1.setBackground(SystemColor.text);
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		
		lblUser.setBounds(89, 123, 73, 17);
		panel_1.add(lblUser);
		lblUser.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 14));
		
		
		lblContrasea.setBounds(89, 151, 97, 17);
		panel_1.add(lblContrasea);
		lblContrasea.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 14));
		
		
		
		txtFsf.setToolTipText("");
		txtFsf.setBounds(208, 123, 193, 20);
		panel_1.add(txtFsf);
		txtFsf.setColumns(10);
		txtFsf.setBackground(SystemColor.inactiveCaptionBorder);
		txtFsf.addKeyListener(new KeyAdapter() {
			
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()== KeyEvent.VK_ENTER)
					pwdContrasea.requestFocus();
			}
		});
		
		
		pwdContrasea.addKeyListener(new KeyAdapter() {
			
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()== KeyEvent.VK_ENTER) {
					ingresar();
				}

			}
		});
		pwdContrasea.setBounds(208, 151, 193, 20);
		pwdContrasea.setBackground(SystemColor.inactiveCaptionBorder);
		panel_1.add(pwdContrasea);
		pwdContrasea.setToolTipText("");
		
		
		
		btnIngresar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnIngresar.setRolloverIcon(new ImageIcon(VentanaLogin.class.getResource("/recursos/btnLoginPress.png")));
		btnIngresar.setPressedIcon(new ImageIcon(VentanaLogin.class.getResource("/recursos/btnLoginSel.png")));
		btnIngresar.setContentAreaFilled(false);
		btnIngresar.setIcon(new ImageIcon(VentanaLogin.class.getResource("/recursos/btnLogin.png")));
		btnIngresar.setBorder(null);
		btnIngresar.addActionListener(this);
		btnIngresar.setFont(new Font("Arial", Font.BOLD, 13));
		btnIngresar.setBounds(148, 188, 184, 73);//(x,y,a,l)
		panel_1.add(btnIngresar);
		
		
		btnSalir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSalir.setBorder(UIManager.getBorder("Button.border"));
		btnSalir.addActionListener(this);
		btnSalir.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 13));
		btnSalir.setBounds(10, 256, 108, 23);
		panel_1.add(btnSalir);
		
		
		btnLimpiar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLimpiar.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 13));
		btnLimpiar.addActionListener(this);
		btnLimpiar.setBounds(342,256,135,23);
		panel_1.add(btnLimpiar);
		
		
		btnSiguiente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSiguiente.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 16));
		btnSiguiente.addActionListener(this);
		btnSiguiente.setBounds(407, 120, 52, 23);
		panel_1.add(btnSiguiente);
		
		
		logo.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				logo.setIcon(user.getImagen());
			}
		});
		logo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		logo.setBorder(new EtchedBorder(EtchedBorder.LOWERED, SystemColor.inactiveCaptionBorder, SystemColor.inactiveCaptionBorder));
		logo.setHorizontalAlignment(SwingConstants.CENTER);
		logo.setBounds(189, 27, 98, 86);
		panel_1.add(logo);
		
		
		
		btnAniadir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAniadir.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 16));
		btnAniadir.addActionListener(this);
		btnAniadir.setBorder(null);
		btnAniadir.setBounds(53, 120, 26, 23);
		panel_1.add(btnAniadir);
		
		
		btnEliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEliminar.addActionListener(this);
		btnEliminar.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 16));
		btnEliminar.setBorder(null);
		btnEliminar.setBounds(17, 120, 26, 23);
		panel_1.add(btnEliminar);
		
		
		btnEliminarLista.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEliminarLista.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 11));
		btnEliminarLista.setBounds(337, 87, 122, 24);
		btnEliminarLista.addActionListener(this);
		panel_1.add(btnEliminarLista);
		
		
		btnInfo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnInfo.setBounds(444, 11, 32, 32);
		panel_1.add(btnInfo);
		btnInfo.setRolloverIcon(new ImageIcon(VentanaLogin.class.getResource("/recursos/infoPress.png")));
		btnInfo.setBorder(null);
		btnInfo.setContentAreaFilled(false);
		btnInfo.setIcon(new ImageIcon(VentanaLogin.class.getResource("/recursos/info.png")));
		btnInfo.addActionListener(this);
		
		boolean exito = cargarDatos();
		if(!exito ) {
			//instanciar la lista de usuarios
			listaUsuarios = new ArrayList();
			listaUsuarios.add(new CuentaUsuario("invitado"));
		}
		
		
		actual = 0;
		user=listaUsuarios.get(actual);
		this.txtFsf.setText(user.getUser());
		
		lblIngresos = new JLabel("Ingresos: "+user.getIngresos());
		lblIngresos.setBounds(28, 26, 80, 14);
		panel_1.add(lblIngresos);
		
		logo.setIcon(user.getImagen());

		noticias = RecolectorNoticias.getInstance();
			
	} 
	
	
	
	/**
	 * Metodo que valida el inicio de sesion
	 */
	private void ingresar() {
		
		String us,pw;
		us= txtFsf.getText();
		pw = pwdContrasea.getText();
	
		if(us.isEmpty() || pw.isEmpty()) {
			JOptionPane.showMessageDialog(null,"Algun campo esta vacio");
			conf= false;
		}
		else if(user.validar(us,pw)) {
			
			user.contIngresos();
			JOptionPane.showMessageDialog(null,"Bienvenido "+ us + "!");
			lblIngresos.setText("ingresos: "+ user.getIngresos());
			conf= true;
			pwdContrasea.setText(null);
			VentanaPrincipal v= new VentanaPrincipal(user, noticias);
			v.setVisible(true);
			
		}else {
			JOptionPane.showMessageDialog(null,"Contraseña o usuario incorrecto");
			conf= false;
		}
		
	}
	
	/**
	 * Metodo que limpia las barras de texto
	 */
	private void limpiar() {
		txtFsf.setText(null);
		pwdContrasea.setText(null);
		txtFsf.requestFocus();
	}
	
	/**
	 * Metodo que finaliza el programa
	 */
	private void salir() {
		// Finaliza el programa
		JOptionPane.showMessageDialog(null, "Guardando Datos...");
		this.guardarDatos();
		System.exit(0);
	}
	
	/**
	 * Metodo que avanza a la siguiente posicion de la lista de usuarios
	 */
	private void siguiente() {
		if(listaUsuarios.size()>0) {
			actual= (actual+1)% listaUsuarios.size();
			user= listaUsuarios.get(actual);
			txtFsf.setText(user.getUser());
			lblIngresos.setText("Ingresos: "+user.getIngresos());
			logo.setIcon(user.getImagen());
			conf=false;
		}
		else
			btnSiguiente.setEnabled(false);
	}
	
	/**
	 * Metodo que permite añadir un usuario
	 */
	private void aniadirUsuario() {
		
		int aux=0;
		String nu= JOptionPane.showInputDialog("Nombre nuevo usuario: ");
		for(int i=0;i<listaUsuarios.size();i++) {
			if(nu.equals(listaUsuarios.get(i).getUser())) {
				aux=0;
			}
			else aux++;
		}
		
		if(aux!=listaUsuarios.size())
			JOptionPane.showMessageDialog(null, "Usuario ya existente");
		else {
			listaUsuarios.add(new CuentaUsuario(nu));
			JOptionPane.showMessageDialog(null, "Usuario añadido");
			actual=aux;
			user= listaUsuarios.get(aux);
			txtFsf.setText(user.getUser());
			lblIngresos.setText("Ingresos: "+user.getIngresos());
			btnSiguiente.setEnabled(true);
			this.guardarDatos();
			
		}
	}
	
	/**
	 * Metodo que permite eliminar un usuario
	 */
	public void eliminarUsuario() {
		
		int s = JOptionPane.showConfirmDialog(null, "¿Desea eliminar a "+ 
				listaUsuarios.get(actual).getUser()+ "?",
				"Confirmación",JOptionPane.YES_NO_OPTION);
		
		if(s== JOptionPane.YES_OPTION) {
			listaUsuarios.remove(actual);
			JOptionPane.showMessageDialog(null, "Usuario Eliminado");
			txtFsf.setText(null);
			pwdContrasea.setText(null);
			lblIngresos.setText(null);
		}
		
	}
	
	/**
	 * Metodo que despliga una ventana on la información de los usuarios
	 */
	private void info() {
		
		VentanaInfo v= new VentanaInfo();
		String a="";
		int c=0;
		
		for(int i=0;i<listaUsuarios.size();i++) {
			a+= i+1+". "+listaUsuarios.get(i).getUser()+ "	Inicios: "+ 
					listaUsuarios.get(i).getIngresos()+"\n\n";
			
			c+=listaUsuarios.get(i).getIngresos();
			
		}
		a+= "Inicios totales: "+ c;
		
		v.editorPane.setText(a);
		v.setVisible(true);
	
		
	}
	
	/**
	 * Metodo que elimina todas las cuentas de usuario
	 */
	private void eliminarUsuarios() {
		int s = JOptionPane.showConfirmDialog(null, "¿Desea eliminar todos los usuarios?",
				"Confirmación",JOptionPane.YES_NO_OPTION);
		if(s==JOptionPane.YES_OPTION) {
			listaUsuarios.clear();
			txtFsf.setText(null);
			pwdContrasea.setText(null);
			lblIngresos.setText(null);
			logo.setIcon(new ImageIcon(VentanaLogin.class.getResource("/recursos/icono-user.png")));
			
		}
	}
	
	/**
	 * Metodo que responde a los botones de la ventana
	 */
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnSalir)
			this.salir();
		else if(e.getSource() == btnIngresar)
			this.ingresar();
		else if(e.getSource() == btnLimpiar)
			this.limpiar();
		else if(e.getSource() == btnSiguiente) 
			this.siguiente();
		else if(e.getSource() == btnAniadir )
			this.aniadirUsuario();
		else if(e.getSource() == btnInfo )
			this.info();
		else if(e.getSource() == btnEliminarLista )
			this.eliminarUsuarios();
		else
			this.eliminarUsuario();
		
	}
	
	/**
	 * Metodo que guarda los datos de los usuarios registrados
	 * @return
	 */
	public boolean guardarDatos() {
		try {
			FileOutputStream fout= new FileOutputStream("./data/usuarios.bin");
			ObjectOutputStream out = new ObjectOutputStream(fout);
			out.writeObject(listaUsuarios);
			out.close();
			fout.close();
			return true;
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	/**
	 * Metodo que carga los datos de los usuarios registrados
	 * @return
	 */
	public boolean cargarDatos() {
		try {
			
			FileInputStream fin= new FileInputStream("./data/usuarios.bin");
			ObjectInputStream in = new ObjectInputStream(fin);
			listaUsuarios = (ArrayList<CuentaUsuario>) in.readObject();
			if(listaUsuarios.size()==0) {
				in.close();
				fin.close();
				JOptionPane.showMessageDialog(null, "Error de lectura: Sin datos " );
				return false;
			}
			else {
				in.close();
				fin.close();
				return true;
			}
		}catch(Exception e) {
			
			JOptionPane.showMessageDialog(null, "Error de lectura: " + e.getMessage());
			return false;
		}
	}
}
