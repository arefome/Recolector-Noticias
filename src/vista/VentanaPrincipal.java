package vista;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import logica.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.URI;
import java.util.ArrayList;
import org.edisoncor.gui.util.*;

public class VentanaPrincipal extends JFrame implements ActionListener{

	//Atributos
	private JPanel contentPane;
	private CuentaUsuario user;
	private JPanel panel;
	private JLabel lblFoto;
	private JButton btnUser;
	private JButton btnVerFavoritos;
	private JButton btnCambiar;
	private JButton btnFoto;
	private JButton btnSalir;
	private FileNameExtensionFilter nPerfil;
	private JPanel pnlMenu;
	private JLabel lblUser;
	private JPanel pnlContenedor;
	private JPanel pnlEntret;
	private JPanel pnlPolitica;
	private JScrollPane scrollPane;
	private JLabel lblCategorias;
	private JButton btnDeportes;
	private JButton btnEntret;
	private JButton btnPolitica;
	private JButton btnTec;
	private JButton btnFavoritos;
	private JPanel pnlTec;
	private JPanel pnlFav;
	private JPanel pnlDeportes;
	private JPanel pnlBotones;
	private JButton btnActualizar;
	private ArrayList<Noticia> fav;
	private JLabel nNoticias;
	private RecolectorNoticias noticias;
	
	//Metodos
	
	/**
	 * Create the Frame 
	 */
	public VentanaPrincipal(CuentaUsuario u, RecolectorNoticias n) {
		
		//configuración de la ventana
		setTitle("Noti-Ya");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 747, 485);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(this);
		contentPane.setLayout(null);
		
		
		user=u;
		nPerfil= new FileNameExtensionFilter("Archivo de Imagen","png");
		noticias = n;
		//configuración de los elementos graficos de la ventana
		panel = new JPanel();
		panel.setBorder(new LineBorder(Color.WHITE, 5));
		panel.setBounds(0, 0, 731, 446);
		panel.setBackground(Color.WHITE);
		contentPane.add(panel);
		panel.setLayout(null);
		
		Image img = user.getImagen().getImage();
		img = img.getScaledInstance(98, 86, java.awt.Image.SCALE_SMOOTH);
		ImageIcon icon= new ImageIcon(img);
		
		JLabel label_1 = new JLabel("Noti-Ya");
		label_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 38));
		label_1.setBounds(286, 11, 135, 44);
		panel.add(label_1);
		
		pnlMenu = new JPanel();
		pnlMenu.setBounds(new Rectangle(0, 0, 3, 0));
		pnlMenu.setBorder(new DropShadowBorder());
		pnlMenu.setBackground(Color.WHITE);
		pnlMenu.setBounds(-174, 5, 174, 436);
		panel.add(pnlMenu);
		pnlMenu.setLayout(null);
		
		lblFoto = new JLabel("");
		lblFoto.setBounds(35, 41, 98, 86);
		pnlMenu.add(lblFoto);
		lblFoto.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblFoto.setIcon(icon);
		
		btnFoto = new JButton("Cambiar foto");
		btnFoto.setBackground(new java.awt.Color(0, 153, 204));
		btnFoto.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
		btnFoto.setForeground(new java.awt.Color(255, 255, 255));
		btnFoto.setBorder(null);
		btnFoto.setContentAreaFilled(false);
		btnFoto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnFoto.setOpaque(true);
		btnFoto.addActionListener(this);
		btnFoto.setBounds(0, 267, 169, 41);
		pnlMenu.add(btnFoto);
		
		btnSalir = new JButton("Cerrar Sesion");
		btnSalir.setBackground(new java.awt.Color(0, 153, 204));
		btnSalir.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
		btnSalir.setForeground(new java.awt.Color(255, 255, 255));
		btnSalir.setBorder(null);
		btnSalir.setContentAreaFilled(false);
		btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnSalir.setOpaque(true);
		btnSalir.addActionListener(this);
		btnSalir.setBounds(0, 314, 169, 41);
		pnlMenu.add(btnSalir);
		
		btnVerFavoritos = new JButton("Ver Favoritos");
		btnVerFavoritos.setBackground(new java.awt.Color(0, 153, 204));
		btnVerFavoritos.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
		btnVerFavoritos.setForeground(new java.awt.Color(255, 255, 255));
		btnVerFavoritos.setBorder(null);
		btnVerFavoritos.setContentAreaFilled(false);
		btnVerFavoritos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnVerFavoritos.setOpaque(true);
		btnVerFavoritos.addActionListener(this);
		btnVerFavoritos.setBounds(0, 173, 169, 41);
		pnlMenu.add(btnVerFavoritos);
		
		lblUser = new JLabel(user.getUser());
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setBounds(35, 138, 98, 14);
		pnlMenu.add(lblUser);
		
		btnCambiar = new JButton("Cambiar clave");
		btnCambiar.setBackground(new java.awt.Color(0, 153, 204));
		btnCambiar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
		btnCambiar.setForeground(new java.awt.Color(255, 255, 255));
		btnCambiar.setBorder(null);
		btnCambiar.setContentAreaFilled(false);
		btnCambiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnCambiar.setOpaque(true);
		btnCambiar.setBounds(0, 220, 169, 41);
		btnCambiar.addActionListener(this);
		pnlMenu.add(btnCambiar);
		
		
		btnUser = new JButton("");
		btnUser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUser.setRolloverIcon(new ImageIcon(VentanaPrincipal.class.getResource("/recursos/icono-menu1.png")));
		btnUser.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/recursos/icono-menu.png")));
		btnUser.setBorder(null);
		btnUser.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnUser.setContentAreaFilled(false);;
		btnUser.addActionListener(this);
		btnUser.setBounds(5, 11, 43, 44);
		panel.add(btnUser);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(181, 70, 504, 328);
		panel.add(scrollPane);
		
		pnlContenedor = new JPanel();
		scrollPane.setViewportView(pnlContenedor);
		pnlContenedor.setPreferredSize(new Dimension(480, 158*35));//158*numero noticias
		pnlContenedor.setBackground(Color.WHITE);
		pnlContenedor.setLayout(new CardLayout(0, 0));
		
		pnlDeportes = new JPanel();
		pnlDeportes.setBorder(new TitledBorder(null, "Deportes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlDeportes.setBackground(Color.WHITE);
		pnlContenedor.add(pnlDeportes, "name_1372358693320949");
		pnlDeportes.setLayout(new BoxLayout(pnlDeportes, BoxLayout.Y_AXIS));
		
		pnlEntret = new JPanel();
		pnlEntret.setBorder(new TitledBorder(null, "Entretenimiento", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlEntret.setBackground(Color.WHITE);
		pnlContenedor.add(pnlEntret, "name_1370058857091224");
		pnlEntret.setLayout(new BoxLayout(pnlEntret, BoxLayout.Y_AXIS));
		 
		pnlPolitica = new JPanel();
		pnlPolitica.setBorder(new TitledBorder(null, "Pol\u00EDtica", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlPolitica.setBackground(Color.WHITE);
		pnlContenedor.add(pnlPolitica, "name_1370058903010005");
		pnlPolitica.setLayout(new BoxLayout(pnlPolitica, BoxLayout.Y_AXIS));
	
		pnlTec = new JPanel();
		pnlTec.setBorder(new TitledBorder(null, "Tecnologia", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlTec.setBackground(Color.WHITE);
		pnlContenedor.add(pnlTec, "name_1370058926723466");
		pnlTec.setLayout(new BoxLayout(pnlTec, BoxLayout.Y_AXIS));
		
		pnlFav = new JPanel();
		pnlFav.setBorder(new TitledBorder(null, "Favoritos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlFav.setBackground(Color.WHITE);
		pnlContenedor.add(pnlFav, "name_1370058948757767");
		pnlFav.setLayout(new BoxLayout(pnlFav, BoxLayout.Y_AXIS));
		
		
		
		pnlBotones = new JPanel();
		pnlBotones.setBackground(Color.WHITE);
		pnlBotones.setBounds(59, 70, 118, 148);
		panel.add(pnlBotones);
		pnlBotones.setLayout(null);
		
		lblCategorias = new JLabel("Categorias");
		lblCategorias.setBounds(0, 0, 112, 18);
		pnlBotones.add(lblCategorias);
		lblCategorias.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 120, 215)));
		lblCategorias.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		
		btnDeportes = new JButton("Deportes");
		btnDeportes.setBounds(0, 22, 113, 23);
		pnlBotones.add(btnDeportes);
		
		btnEntret = new JButton("Entretenemiento");
		btnEntret.setBounds(0, 46, 113, 23);
		pnlBotones.add(btnEntret);
		
		btnPolitica = new JButton("Pol\u00EDtica");
		btnPolitica.setBounds(0, 71, 113, 23);
		pnlBotones.add(btnPolitica);
		
		btnTec = new JButton("Tecnologia");
		btnTec.setBounds(0, 95, 113, 23);
		pnlBotones.add(btnTec);
		
		btnFavoritos = new JButton("Favoritos");
		btnFavoritos.setBounds(0, 120, 113, 23);
		pnlBotones.add(btnFavoritos);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(this);
		btnActualizar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnActualizar.setContentAreaFilled(false);
		btnActualizar.setBorder(new MatteBorder(0, 0, 2, 0, (Color) SystemColor.textHighlight));
		btnActualizar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnActualizar.setBounds(583, 21, 89, 23);
		panel.add(btnActualizar);
		
		btnFavoritos.addActionListener(this);
		btnTec.addActionListener(this);
		btnPolitica.addActionListener(this);
		btnEntret.addActionListener(this);
		btnDeportes.addActionListener(this);
		
		nNoticias = new JLabel();
		nNoticias.setHorizontalAlignment(SwingConstants.CENTER);
		nNoticias.setBounds(181, 400, 125, 23);
		panel.add(nNoticias);
		nNoticias.setVisible(false);
		
		this.visualizarNoticias();
		
		boolean exito = cargarDatos();
		if(!exito ) {
			//instanciar la lista de favoritos
			fav = new ArrayList();
		}
		pnlContenedor.setPreferredSize(new Dimension(480, 158*noticias.getNotiDeportes().size()));
		nNoticias.setText("Noticias guardadas: "+ fav.size());
		
	}
	
	/**
	 * Metodo que configura la ficha de una noticia
	 * @return 
	 * Ficha Noticia
	 */
	public JPanel retornarNoticia (Noticia n){
		
		
		JPanel pnl= new JPanel();
		JButton btnOcultar;
		JButton btnGuardar;
		JButton btnVerOriginal;
		JLabel lblDescripcion;
		JLabel lblPortal;
		
		pnl.setSize(new Dimension(480,158));
		pnl.setBackground(Color.WHITE);
		pnl.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnl.setLayout(null);
		pnl.setMaximumSize ( new Dimension ( 480, 158 ) );
		pnl.setMinimumSize ( new Dimension ( 480, 158 ) );
		
				
		lblPortal = new JLabel("");
		lblPortal.setBorder(null);
		lblPortal.setBounds(32, 14, 79, 65);
		pnl.add(lblPortal);
		
		ImageIcon icon= new ImageIcon(Noticia.class.getResource("/recursos/"+n.getFuente()+".png"));
		Image img= icon.getImage();
		img= img.getScaledInstance(79, 65,  java.awt.Image.SCALE_SMOOTH);
		icon.setImage(img);
		lblPortal.setIcon(icon);
		
		
		String texto; 
		texto = "<html><h3>"+n.getTitulo() +"</h3>";
		texto += "<p>" + n.getDescripcion()+"<br>"; 
	
		lblDescripcion = new JLabel(texto,JLabel.CENTER);
		lblDescripcion.setBorder(null);
		lblDescripcion.setBounds(136,4, 300, 100);
		pnl.add(lblDescripcion);
			
		btnOcultar = new JButton("Eliminar");
		btnOcultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(nNoticias.isVisible()) {
					fav.remove(n);
					actualizarFav();
				}
				else {
					pnl.setVisible(false);
				}
			}
		});
		btnOcultar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnOcultar.setBounds(136, 111, 99, 23);
		pnl.add(btnOcultar);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Noticia aux= n;
				fav.add(aux);
				JOptionPane.showMessageDialog(null,"¡Añadida a favoritos!");
			}
		});
		btnGuardar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGuardar.setBounds(236, 111, 99, 23);
		pnl.add(btnGuardar);
			
		btnVerOriginal = new JButton("Leer");
		btnVerOriginal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (arg0.getSource()==btnVerOriginal) {
					try {
						Desktop.getDesktop().browse(new URI(n.getDirEnlace()));
					}
					catch(Exception e) {
						System.out.println(e.getMessage());
					}
				}
			}
		});
		btnVerOriginal.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVerOriginal.setBounds(336, 111, 99, 23);
		pnl.add(btnVerOriginal);

		return pnl;
	}

	public void visualizarNoticias() {

		for(Noticia n: noticias.getNotiDeportes()) {
			pnlDeportes.add(this.retornarNoticia(n));
		}
		
		for(Noticia n:noticias.getNotiEntret()) {
			pnlEntret.add(this.retornarNoticia(n));
		}
		
		for(Noticia n:noticias.getNotiPolitica()) {
			pnlPolitica.add(this.retornarNoticia(n));
		}
		
		for(Noticia n: noticias.getNotiTec()) {
			pnlTec.add(this.retornarNoticia(n));
		}
		
		
	
	}
	
	
	public void actualizar() {
		
		JOptionPane.showMessageDialog(null, "Actualizando...");
		JOptionPane.showMessageDialog(null, "Noticias Actualizadas");
		
	}
	/**
	 * Metodo que oculta los contenedores de noticias
	 */
	public void ocultarPnls() {	
		this.pnlDeportes.setVisible(false);
		this.pnlEntret.setVisible(false);
		this.pnlPolitica.setVisible(false);
		this.pnlTec.setVisible(false);
		this.pnlFav.setVisible(false);
		this.nNoticias.setVisible(false);
	}
	
	
	/**
	 * Metodo que permite cambiar la imagen de perfil de un usuario
	 */
	public void editarImg() {
		
		JFileChooser dig= new JFileChooser();
		dig.setFileFilter(nPerfil);
		int op= dig.showOpenDialog(this);
			
		String fil = dig.getSelectedFile().getPath();
		ImageIcon icon= new ImageIcon(fil);
		Image img = icon.getImage();
		img = img.getScaledInstance(98, 86, java.awt.Image.SCALE_SMOOTH);
		icon= new ImageIcon(img);
		user.setImagen(icon);
		lblFoto.setIcon(icon);
	}
	
	/**
	 * Metodo que permite cambiar la contraseña de un usuario
	 */
	public void cambiar() {
		
		String a= JOptionPane.showInputDialog("Nueva Contraseña:");
		String an= JOptionPane.showInputDialog("Confirmar Contraseña:");
					
		if(user.cambiarPwd(a, an))
			JOptionPane.showMessageDialog(this,"Contraseña cambiada exitosamente!");
		else
			JOptionPane.showMessageDialog(null, "Inicia sesion primero", null, JOptionPane.INFORMATION_MESSAGE);
	}
	
	/**
	 * Metodo que desplega el menu de opciones del usuario
	 */
	public void desplegar() {
		int pos= btnUser.getX();
		if(pos > 5) {
			Animacion.Animacion.mover_izquierda(185, 5, 2, 2, btnUser);
			Animacion.Animacion.mover_izquierda(5, -176, 2, 2, pnlMenu);
			this.pnlBotones.setVisible(true);
		}
		else {
			Animacion.Animacion.mover_derecha(5, 184, 2, 2, btnUser);
			Animacion.Animacion.mover_derecha(-176, 5, 2, 2, pnlMenu);
			this.pnlBotones.setVisible(false);
		}
			
		
	}
	
	public void actualizarFav() {
		this.ocultarPnls();
		this.pnlFav.setVisible(true);
		pnlFav.removeAll();
		for(Noticia n: fav) {
			pnlFav.add(this.retornarNoticia(n));
		}
		pnlContenedor.setPreferredSize(new Dimension(480, 158*fav.size()));
		pnlFav.updateUI();
		
		nNoticias.setText("Noticias guardadas: "+ fav.size());
		nNoticias.setVisible(true);
	}
	
	public void salir() {
		guardarDatos();
		this.setVisible(false);
		VentanaU v =new VentanaU();
		v.setVisible(true);
	}
	
	/**
	 * Metodo que ejecuta los eventos al presionar los botones
	 */
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnSalir) {	
			this.salir();
		}
		else if(e.getSource() == btnCambiar)
			this.cambiar();
	
		else if(e.getSource()== btnFoto)
			this.editarImg();
		else if(e.getSource()== btnUser)
			this.desplegar();
		else if(e.getSource()== btnFavoritos) 
			this.actualizarFav();
			
		else if(e.getSource()== btnDeportes) {
			this.ocultarPnls();
			pnlContenedor.setPreferredSize(new Dimension(480, 158*noticias.getNotiDeportes().size()));
			this.pnlDeportes.setVisible(true);
		}
		else if(e.getSource()== btnPolitica) {
			this.ocultarPnls();
			pnlContenedor.setPreferredSize(new Dimension(480, 158*noticias.getNotiPolitica().size()));
			this.pnlPolitica.setVisible(true);
		}
		else if(e.getSource()== btnEntret) {
			this.ocultarPnls();
			pnlContenedor.setPreferredSize(new Dimension(480, 158*noticias.getNotiEntret().size()));
			this.pnlEntret.setVisible(true);
		}
		else if(e.getSource()== btnTec) {
			this.ocultarPnls();
			pnlContenedor.setPreferredSize(new Dimension(480, 158*noticias.getNotiTec().size()));
			this.pnlTec.setVisible(true);
		}
		else if(e.getSource()== btnActualizar) {
			this.actualizar();
		}
	}
	public boolean guardarDatos() {
		try {
			FileOutputStream fout= new FileOutputStream("./data/fav_"+ user.getUser() +".bin");
			ObjectOutputStream out = new ObjectOutputStream(fout);
			out.writeObject(fav);
			out.close();
			fout.close();
			return true;
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	public boolean cargarDatos() {
		try {
			
			FileInputStream fin= new FileInputStream("./data/fav_"+ user.getUser() +".bin");
			ObjectInputStream in = new ObjectInputStream(fin);
			fav = (ArrayList<Noticia>) in.readObject();
			if(fav.size()==0) {
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

