package herramientas;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class CargadorRecursos {

	public static ImageIcon cargarIcono(final String ruta) {

		ImageIcon imagen = null;
		try {
			imagen = new ImageIcon(ImageIO.read(CargadorRecursos.class.getResourceAsStream(ruta)));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return imagen;
	}

	public static BufferedImage cargarImagen(final String ruta) {
		BufferedImage imagen = null;
		try {
			imagen = ImageIO.read(ClassLoader.class.getResource(ruta));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return imagen;
	}
}
