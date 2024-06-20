package utility;

import java.sql.*;

public class Group {

    public String name, id;

    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    public Group() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/chitchat", "root", "root");
            stmt = con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public Group createGroup(String name, String user) {

        Group group = new Group();

        String randID = GenerateID.getRandomID();
        try {

            String query = "INSERT INTO rooms(id, name, admin) VALUES('" + randID + "', '" + name + "', '" + user + "')";

            stmt.executeUpdate(query);

            group.id = randID;
            group.name = name;

            query = "INSERT INTO members(userid, groupid, groupname) VALUES('" + user + "', '" + randID + "', '" + name + "')";

            stmt.executeUpdate(query);

            return group;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return group;
    }

    public Group[] getGroups(String user) {
        try {
            String query = "SELECT * FROM members WHERE userid = '" + user + "'";
            rs = stmt.executeQuery(query);

            int rows = 0;
            while (rs.next()) {
                rows++;
            }
            Group[] data = new Group[rows];
            int it = 0;
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                data[it] = new Group();
                data[it].id = rs.getString("groupid");
                data[it].name = rs.getString("groupname");
                it++;
            }
            return data;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        Group[] data = new Group[1];
        return data;
    }
}
