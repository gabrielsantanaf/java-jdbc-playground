package application.use_cases;

import db.DB;
import db.DbException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Leitura {
    private String query;

    public Leitura() {
    }

    public void get(String query) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            conn =  DB.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(query);

            while (rs.next()){
                System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));
            }

        }
        catch (SQLException e){
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeResultSet(rs);
            DB.closeStatment(st);
            DB.closeConnection();
        }
    }
}
