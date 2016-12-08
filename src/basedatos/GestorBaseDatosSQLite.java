package basedatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ente.Cliente;

public class GestorBaseDatosSQLite {

	String contenido;

	Connection connect;

	public void connect() {

		try {
			Class.forName("org.sqlite.JDBC");
			connect = DriverManager.getConnection("jdbc:sqlite:src/basedatos/programa.db");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	public void close() {
		try {
			connect.close();
			System.out.println("Conexion cerrada");
		} catch (SQLException ex) {
			ex.getMessage();
		}
	}

	public void guardarCliente(Cliente cliente) {
		try {
			PreparedStatement st = connect
					.prepareStatement("insert into clientes (id, nombre, apellidos, dni) values (?,?,?,?)");
			st.setInt(1, cliente.obtenerId());
			st.setString(2, cliente.obtenerNombre());
			st.setString(3, cliente.obtenerApellidos());
			st.setString(4, cliente.obtenerDni());
			st.execute();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public void mostrarClientes() {
		ResultSet result = null;
		try {
			PreparedStatement st = connect.prepareStatement("select * from clientes");
			result = st.executeQuery();

			while (result.next()) {
				System.out.print("ID: ");
				System.out.println(result.getInt("id"));

				System.out.print("Nombre ");
				System.out.println(result.getString("nombre"));

				System.out.print("Apellidos ");
				System.out.println(result.getString("apellidos"));

				System.out.println("==========================");
			}
		} catch (SQLException ex) {
			ex.getMessage();
		}
	}

	public void eliminarCliente(final int id) {
		Statement s = null;
		try {
			s = connect.createStatement();

			s.execute("DELETE FROM clientes WHERE id = " + id);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
