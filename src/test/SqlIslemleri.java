package test;

import java.sql.*;

/**
 * @author thdursun
 */
public class SqlIslemleri {

    public static Connection ConnectDB() {
        Connection conn = null;
        try {

            conn = DriverManager.getConnection("jdbc:sqlite:D:/JAVA/IcraTakipOrtak/nbproject/users.db");
            System.out.println("Connection to SQLite has been established.");
            return conn;
            
        } catch (SQLException ex) {
            System.out.println("SQL yazım hatası tespit var.");
        } finally {
            try {
                if (conn == null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return conn;
    }

    public static boolean checkUserAndPass(String user, String pass) {
        String sql = "SELECT username, password FROM tableUSERPASS";

        try (
                Connection conn = ConnectDB();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
            ) {

            // Sonuc dizisinde döngü oluştur ve kullanıcı parola eşleştirmesi yap.
            while (rs.next()) {
                if ( user.equalsIgnoreCase(rs.getString("username")) && pass.equals(rs.getString("password"))) {

                    System.out.println("Login Başarılı.");
                    System.out.println("Bağlanan Kullanıcı: " + rs.getString("username") + "\t"
                            + rs.getString("password"));
                    return true;

                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("Login Başarısız.");
        return false;
    }
}
