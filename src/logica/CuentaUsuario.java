
package logica;
import java.io.Serializable;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class CuentaUsuario implements Serializable{

	
	private String user;
	private ImageIcon perfil;
	private String pwd;
	private int ingresos;
	
	
	// Metodos
	/**
	 * constructor parametrico
	 * @param u identificador usuario
	 */
	public CuentaUsuario(String u){
		
		this.perfil = new ImageIcon(CuentaUsuario.class.getResource("/recursos/icono-user.png"));
		this.user = u;
		this.ingresos=0;
		this.pwd = "qwerty123";	
		
	}
	
	/**
	 * Metodo para asignar la contrase�a
	 * @param p contrase�a
	 * @return
	 */
	public boolean asignarPwd(String p) {
		if(p.length()>=8) {
			this.pwd=p;
			return true;
		}
		else {	
			JOptionPane.showMessageDialog(null,"la contrase�a debe tener 8 o mas caracteres", "Contrase�a no cambiada", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
	}
	
	/**
	 * Metodo para cambiar la contrase�a
	 * @param cp confirmacion nueva contrase�a
	 * @param np nueva contrase�a
	 * @return
	 */
	public boolean cambiarPwd(String np,String cp) {
		if(np.equals(cp)) {
			return this.asignarPwd(np);
		}else if(np != cp){
			System.out.println("las contrase�as no coinciden");
			return false;
		}
		else return false;
			
	}
	 /**
	 * Metodo que valida si la contrase�a corresponde al usuario
	 * @param p contrase�a
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

}
