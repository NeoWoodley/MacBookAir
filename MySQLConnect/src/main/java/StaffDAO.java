import java.sql.SQLException;

public interface StaffDAO {
	void searchTable(String SQL) throws SQLException;

	void updateTable(String SQL) throws SQLException;
}
