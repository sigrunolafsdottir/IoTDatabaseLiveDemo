package Demo1;

import java.sql.*;

public class DbDemo2 {

    public void doDatabaseeStuff(String username, String password) throws SQLException {
        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/bigtomtedatabase?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true",
                username, password);
             Statement stmt =  con.createStatement();
             ResultSet rs = stmt.executeQuery("select id, name, address from child"))
        {
            while (rs.next()) {
                String adress = rs.getString("address");
                int id = rs.getInt("id");
                String name = rs.getString("name");
                System.out.println("id: " + id + ", name: " + name + ", address: " + adress);
            }
        }
    }
    public static void main(String[] args) throws SQLException {
        System.out.println("Hello World");
        DbDemo2 dbDemo = new DbDemo2();
        dbDemo.doDatabaseeStuff("sigrun", "secretpassword");

    }



}
