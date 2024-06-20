package Auth;

import UI.Login;
import utility.GenerateID;
import java.sql.*;

public class User {

    public String id, name, email;
    private String password;
    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    public User() {
        id = "";
        name = "";
        email = "";
    }

    public User(String nm, String em, String pass) {
        name = nm;
        email = em;
        password = pass;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/chitchat", "root", "root");
            stmt = con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public User createUser() {
        String randID = GenerateID.getRandomID();

        User user = new User();
        try {
            String query = "SELECT email FROM users WHERE email='" + email + "'";
            rs = stmt.executeQuery(query);

            if (rs.next()) {
                return user;
            }

            query = "INSERT INTO users(id, name, email, password) VALUES('" + randID + "','" + name + "','" + email + "','" + password + "')";

            stmt.executeUpdate(query);

            user.id = randID;
            user.name = name;
            user.email = email;

            return user;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return user;
    }

    public User authenticate() {

        User user = new User();
        try {
            String query = "SELECT * FROM users WHERE email='" + email + "'";
            rs = stmt.executeQuery(query);

            if (!rs.next()) {
                return user;
            }

            if (password.equals(rs.getString("password"))) {
                user.id = rs.getString("id");
                user.name = rs.getString("name");
                user.email = rs.getString("email");

                return user;
            } else {
                return user;
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return user;
    }

    public User[] getUsers(String user, String group) {
        try {
            String query = "SELECT id,name FROM users WHERE id!='" + user + "'";
            rs = stmt.executeQuery(query);

            int rows = 0;
            while (rs.next()) {
                rows++;
            }
            User[] data = new User[rows];
            int it = 0;
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                data[it] = new User();
                data[it].id = rs.getString("id");
                data[it].name = rs.getString("name");
                it++;
            }
            return data;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        User[] data = new User[1];
        return data;
    }

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        new Login().setVisible(true);
    }
}
