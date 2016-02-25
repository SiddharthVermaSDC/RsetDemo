package learn;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
 
public class Image {
 
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "1october";
 
        String filePath = "D:/Image/babu.jpg";
 
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
 
            String sql = "INSERT INTO person (first_name, last_name, photo) values (?, ?, ?)";
            System.out.println(filePath);
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, "Sarthak");
            statement.setString(2, "Verma");
            InputStream inputStream = new FileInputStream(new File(filePath));
            System.out.println(filePath);
            System.out.println(inputStream);
            statement.setBlob(3, inputStream);
            System.out.println(inputStream);
            int row = statement.executeUpdate();
            if (row > 0) {
                System.out.println("A contact was inserted with photo image.");
                System.out.println(inputStream);
            }
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}