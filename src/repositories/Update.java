package repositories;

import db.DB;
import db.DbException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {
    private Connection conn;

    public Update(Connection conn) {
        this.conn = conn;
    }

    public void updateBaseSalary(double baseSalary, int departament){
        PreparedStatement st = null;
        try {
            conn.setAutoCommit(false);

            st = conn.prepareStatement(
                    "UPDATE seller "
                            + "SET BaseSalary = BaseSalary + ? "
                            + "WHERE "
                            + "(DepartmentId = ?)");

            st.setDouble(1, baseSalary);
            st.setInt(2, departament);

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
