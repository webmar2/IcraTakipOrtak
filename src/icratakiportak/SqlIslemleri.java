package icratakiportak;

import java.sql.*;

/**
 * @author thdursun
 */
public class SqlIslemleri {

    public static boolean KullanıcıSorgula(String user, String pass) {
        return check(user, pass);
    }

    public static Connection ConnectDB() {
        Connection conn = null;
        try {

            conn = DriverManager.getConnection("jdbc:sqlite:D:/JAVA/IcraTakipOrtak/nbproject/sqlite_db.db");
            System.out.println("Connection to SQLite has been established.");

            return conn;
        } catch (SQLException ex) {
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

    public static boolean check(String user, String pass) {
        String sql = "SELECT username, password FROM tableUSERPASS";

        try (Connection conn = ConnectDB();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getString("username") + "\t"
                        + rs.getString("password"));
                if (user.equals(rs.getString("username"))) {
                    if (pass.equals(rs.getString("password"))) {
                        System.out.println("Login Başarılı.");
                        return true;
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Login Başarısız.");
        return false;
    }
}
