import org.apache.commons.dbcp2.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * DBCP工具类
 */
public class DBCPUtils {
	private static DataSource dataSource;
	private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();

	static {
		try {
			// 加载properties配置文件
			InputStream inputStream = DBCPUtils.class.getClassLoader().getResourceAsStream("config/dbcp.properties");
			// 加载输入流
			Properties properties = new Properties();
			properties.load(inputStream);
			// 创建数据源
			dataSource = BasicDataSourceFactory.createDataSource(properties);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static DataSource getDataSource() {
		return dataSource;
	}

	public static Connection getConnection() throws SQLException {
//		try {
//			 从本地线程管理对象threadLocal中拿connection
//			Connection connection = threadLocal.get();
//			if (connection == null) {
//				connection = dataSource.getConnection();
//				 放入threadLocal中
//				threadLocal.set(connection);
//			}
//			return connection;
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return null;
		return dataSource.getConnection();
	}

	public static void releaseConnection(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
