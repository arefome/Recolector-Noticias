
package logica;

import java.io.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class CuentaUsuario implements Serializable{
	//Atributos
	
	/**
	 * Atributo que almacena el nombre de la cuenta de usuario 
	 */
	
	private String user;
	
	/**
	 * Atributo que almacena la imagen de la cuenta de usuario 
	 */
	
	private ImageIcon perfil;
	
	/**
	 * Atributo que almacena la contraseņa de la cuenta de usuario 
	 */
	
	private String pwd;
	
	/**
	 * Atributo que almacena la cantidad de inicios de la cuenta de usuario 
	 */
	
	private int ingresos;
	
	
	// Metodos
	/**
	 * constructor parametrico
	 * @param u identificador usuario
	 */
	public CuentaUsuario(String u) {
		
		this.perfil = new ImageIcon(CuentaUsuario.class.getResource("/recursos/icono-user.png"));
		this.user = u;
		this.ingresos=0;
		if(!cargarDatos()) {
			this.pwd = "qwerty123";	
		}
		
	}
	
	/**
	 * Metodo para asignar la contraseņa
	 * @param p contraseņa
	 * @return
	 */
	public boolean asignarPwd(String p) {
		if(p.length()>=8) {
			this.pwd=p;
			return true;
		}
		else {	
			JOptionPane.showMessageDialog(null,"la contraseņa debe tener 8 o mas caracteres", "Contraseņa no cambiada", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
	}
	
	/**
	 * Metodo para cambiar la contraseņa
	 * @param cp confirmacion nueva contraseņa
	 * @param np nueva contraseņa
	 * @return
	 */
	public boolean cambiarPwd(String np,String cp) {
		if(np.equals(cp)) {
			return this.asignarPwd(np);
		}else if(np != cp){
			System.out.println("las contraseņas no coinciden");
			return false;
		}
		else return false;
			
	}
	 /**
	 * Metodo que valida si la contraseņa corresponde al usuario
	 * @param p contraseņa
	 * @param u nombre de usuario
	 * @return
	 */
	public boolean validar(String u,String p) {
		
		//return (u.equals(user)) && (p.equals(pwd));
		if(this.user.equals(u) && this.pwd.equals(p)) {
			return true;
		}
		else 
			return false;
		
	}
	
	//Getters and Setters CuentaUsuario
	public int getIngresos() {
		return ingresos;
	}
	public void contIngresos() {
		ingresos++;
	}
	public ImageIcon getImagen() {
		return perfil;
	}
	
	public void setImagen(ImageIcon a) {
		perfil= a;
	}
	
	public String getUser() {
		return user;
	}

	
	public boolean cargarDatos() {
		try {
			CuentaUsuario temp;
			
			FileInputStream fin= new FileInputStream("./data/" + this.user + ".bin");
			ObjectInputStream in = new ObjectInputStream(fin);
			temp= (CuentaUsuario) in.readObject();
			this.user = temp.user;
			this.pwd = temp.pwd;
			this.ingresos = temp.ingresos;
			this.perfil = temp.perfil;
			in.close();
			fin.close();
			
		
			return true;
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

}
