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
            conn.setAutoCommit(false);

            st = conn.prepareStatement(
                    "DELETE FROM seller "
                        + "WHERE "
                        + "Id = ?");

            st.setInt(1, id);

            int rowsAffected = st.executeUpdate();
            conn.commit();

            System.out.println("Done! Rows affected: " + rowsAffected);
        }
        catch (SQLException e) {
            try {
                conn.rollback();
                throw new DbException("Transaction rolled back! Caused by: " + e.getMessage());
            }
            catch (SQLException e1){
                throw new DbException("Error trying to rollback! Caused by: " + e1.getMessage());
            }
        }
        finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}
