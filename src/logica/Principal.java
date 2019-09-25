package logica;

import java.awt.EventQueue;

import vista.VentanaU;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaU frame = new VentanaU();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	}

}
