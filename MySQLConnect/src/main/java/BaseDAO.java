import java.sql.*;

/**
 * 完成数据库的连接
 */
public class BaseDAO {
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/homework2";
	private static String user = "root";
	private static String password = "Abc1030278756";

	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}

	public static void closeAll(Connection connection, Statement statement, ResultSet resultSet) throws SQLException {
		if (resultSet != null) {
			resultSet.close();
		}
		if (statement != null) {
			statement.close();
		}
		if (connection != null) {
			connection.close();
		}
	}

	public int executeSQL(String preparedSQL, Object[] parameter) throws ClassNotFoundException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		// 处理SQL，执行SQL
		try {
			connection = getConnection();  // 得到数据库连接
			preparedStatement = connection.prepareStatement(preparedSQL);  // 得到PreparedStatement对象
			if (parameter != null) {
				for (int i = 0; i < parameter.length; i++) {
					preparedStatement.setObject(i + 1, parameter[i]);  // 为预编译SQL设置参数
				}
			}
			ResultSet num = preparedStatement.executeQuery();  // 执行SQL语句
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				BaseDAO.closeAll(connection, preparedStatement, null);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
}
