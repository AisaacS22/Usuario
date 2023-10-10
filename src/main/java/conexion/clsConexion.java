package conexion;

import java.sql.*;

public class clsConexion {
    private Connection conn = null;

    public void conexion() throws SQLException {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/b", "root", "aifx87xwk");
            System.out.println("Conexion realizada exitosamente");
        } catch (SQLException ex) {
            System.out.println("Hubo un error al conectar a la base de datos: " + ex.getMessage());
            throw ex;
        }
    }

    public String asignarValores(String username, String password) throws SQLException {
        String dbusername = "";
        String dbpassword = "";

        conexion();

        String sql = "SELECT * FROM usuario WHERE username = ? AND password = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, password);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    dbusername = rs.getString("username");
                    dbpassword = rs.getString("password");
                }
            }
        }

        if (dbusername.equals(username) && dbpassword.equals(password)) {
            return "true";
        } else {
            return "false";
        }
    }
}
