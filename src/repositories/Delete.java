package repositories;

import db.DB;
import db.DbException;
import db.DbIntegrityException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete {
    private Connection conn;

    public Delete(Connection conn) {
        this.conn = conn;
    }

    public void deleteSaller(int id){
        PreparedStatement st = null;
        try {
            conn = DB.getConnection();

            st = conn.prepareStatement(
                    "DELETE FROM seller "
                        + "WHERE "
                        + "Id = ?");

            st.setInt(1, id);

            int rowsAffected = st.executeUpdate();

            System.out.println("Done! Rows affected: " + rowsAffected);
        }
        catch (SQLException e) {
            throw new DbIntegrityException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}
