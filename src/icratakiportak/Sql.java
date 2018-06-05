package icratakiportak;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/** @author thdursun 
*/
public class Sql {

    // Kayıtlı olan db dosyasına bağlantıyı yapar.
    public static Connection connectDB() {
        Connection conn = null;
        try {

            conn = DriverManager.getConnection("jdbc:sqlite:D:/JAVA/IcraTakipOrtak/nbproject/users.db");
            System.out.println("Connection to SQLite has been established.");
            return conn;

        } catch (SQLException ex) {
            System.out.println("SQL yazım hatası var.");
        } finally {
            try {
                if (conn == null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return conn;
    }

    // Bu metod veritabanından sadece kullanıcı adı ve parola alanlarındaki değerleri çeker.
    // O yüzden parametresi yoktur ve static'tir.
    public static ResultSet getUserAndPassResultSet() {

        String sql = "SELECT username, password FROM tableUSERPASS";

        try {
            Connection conn = connectDB();
            Statement stmt = conn.createStatement();
            ResultSet userAndPassResultSet = stmt.executeQuery(sql);
            return userAndPassResultSet;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Login Başarısız.");
        return null;
    }

}
