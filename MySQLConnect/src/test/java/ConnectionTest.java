import org.junit.Before;
import org.junit.Test;

import java.sql.*;

public class ConnectionTest {
	private ConnectionTest test;
	private static final int count=2000;
	private static final String driverName = "com.mysql.jdbc.Driver";
	private static final String dbURL = "jdbc:mysql://localhost:3306/homework2?useSSL=false&allowPublicKeyRetrieval";
	private static final String userName = "root";
	private static final String userPassword = "Abc1030278756";
	private static final String SQL = "select staff.* " +
			"from staff " +
			"where sno=171250016;";  // 要执行的查询语句

	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;

	@Before
	public void setUp() {
		test = new ConnectionTest();
	}

	/**
	 * 使用直接连接模式和连接池模式打开连接、执行查询、关闭连接2000次
	 */
	public void directConnection() throws SQLException {
		try {
			Class.forName(driverName);
			connection = DriverManager.getConnection(dbURL, userName, userPassword);
			preparedStatement = connection.prepareStatement(SQL);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				System.out.printf("%-8s %-8d %-8d %-8d %-8d", resultSet.getString("sname"), resultSet.getInt("sno"),
						resultSet.getInt("age"), resultSet.getInt("salary"), resultSet.getInt("deptno"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (resultSet != null) {
				resultSet.close();
			}
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
	}

	/**
	 * 使用连接池模式打开连接、执行查询、关闭连接2000次
	 */
	public void DBCPConnection() {
		try {
			connection = DBCPUtils.getConnection();
			preparedStatement = connection.prepareStatement(SQL);
//			preparedStatement.setInt(1, 171250016);  // 从1开始计数，而不是0
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				System.out.printf("%-8s %-8d %-8d %-8d %-8d", resultSet.getString("sname"), resultSet.getInt("sno"),
						resultSet.getInt("age"), resultSet.getInt("salary"), resultSet.getInt("deptno"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBCPUtils.releaseConnection(connection, preparedStatement, resultSet);
		}
	}

	@Test
	public void directConnectionTest() throws SQLException {
		for (int i = 0; i < count; i++) {
			test.directConnection();
		}
	}

	@Test
	public void DBCPConnectionTest() {
		for (int i = 0; i < count; i++) {
			test.DBCPConnection();
		}

	}
}