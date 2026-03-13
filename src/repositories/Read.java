package repositories;

import db.DB;
import db.DbException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Read {
    private final Connection conn;

    public Read(Connection conn) {
        this.conn = conn;
    }

    public void get(String query) {
        Statement st = null;
        ResultSet rs = null;

        try {
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
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }


}
