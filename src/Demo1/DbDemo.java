package Demo1;

import java.sql.*;
public class DbDemo {

    public void doDatabaseeStuff(String username, String password){
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        System.out.println("Hello World");
        DbDemo dbDemo = new DbDemo();
        dbDemo.doDatabaseeStuff("sigrun", "secretpassword");

    }



}
