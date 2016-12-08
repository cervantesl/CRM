package graficos.apariencia;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

public class VentanaApariencia {

	private static LookAndFeelInfo[] aspectos;
	private static String[] nombreAspectos;

	public static LookAndFeelInfo[] obtenerAspectos() {
		aspectos = UIManager.getInstalledLookAndFeels();

		return aspectos;
	}

	public static String[] obtenerNombresAspectos(LookAndFeelInfo[] aspectos) {
		nombreAspectos = new String[aspectos.length];

		for (int i = 0; i < aspectos.length; i++) {
			nombreAspectos[i] = aspectos[i].getName();
		}

		return nombreAspectos;
	}

	public static void establecerAspecto(int posicion) {
		try {
			UIManager.setLookAndFeel(aspectos[posicion].getClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}
}
