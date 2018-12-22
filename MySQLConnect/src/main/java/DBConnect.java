//import java.sql.*;
//
//public class DBConnect {
//	// JDBC驱动名及数据库URL
//	private static final String driverName = "com.mysql.jdbc.Driver";
//	private static final String dbURL = "jdbc:mysql://localhost:3306/homework2?useSSL=false&allowPublicKeyRetrieval";
//	private static final String userName = "root";
//	private static final String userPassword = "Abc1030278756";
//	private static String separator = "----------------------------------------";
//
//	public static void main(String[] args) {
//		Connection dbConnection = null;
//		Statement statement = null;
//		String sql;
//		ResultSet resultSet;
//
//		try {
//			Class.forName(driverName);  // 注册JDBC驱动
//			dbConnection = DriverManager.getConnection(dbURL, userName, userPassword);  // 打开链接
//			System.out.println("连接数据库成功");
//
//			// 执行SQL语句
//			System.out.println("实例化Statement对象...");
//			statement = dbConnection.createStatement();
//
//			// 查询操作
//			sql = insertSQL();
//
//
//			// 插入操作
//
//			// 删除操作
//
//			// 更新操作
//
//			resultSet = statement.executeQuery(sql);
//
//			// 展开结果集数据库
//			while (resultSet.next()) {
//				// 通过字段检索
////				int id
//				// 输出数据
//				System.out.println();
//			}
//
//
//			// 完成后关闭
//			resultSet.close();
//			statement.close();
//			dbConnection.close();
//		} catch (SQLException se) {
//			// 处理JDBC错误
//			se.printStackTrace();
//		} catch (Exception e) {
//			// 处理Class.forName错误
//			e.printStackTrace();
//			System.out.println("连接失败");
//		} finally {
//			// 关闭资源
//			try {
//				if (statement != null) {
//					statement.close();
//				}
//			} catch (SQLException se) {
//				se.printStackTrace();
//			}
//
//			try {
//				if (dbConnection != null) {
//					dbConnection.close();
//				}
//			} catch (SQLException se) {
//				se.printStackTrace();
//			}
//		}
//		System.out.println("成功关闭数据库\nBye bye");
//	}
//
//	/**
//	 * 查询年龄在[20,23]之间的员工的sname、sno、age
//	 * @return 返回查询语句
//	 */
//	private static String searchAgeSQL() {
//		System.out.println(separator);
//		System.out.println("查询年龄在[20,23]之间的员工的sname、sno、age：");
//		return "select staff.sname,staff.age" +
//				"from staff" +
//				"where staff.age between 20,23;";
//	}
//
//	/**
//	 * 查询salary大于3000000的员工的sname、sno、salary
//	 * @return 返回查询语句
//	 */
//	private static String searchSalary() {
//		System.out.println(separator);
//		System.out.println("查询salary大于3000000的员工的sname、sno、salary：");
//		return "select staff.sname,staff.sno,staff.salary" +
//				"from staff" +
//				"where staff.salary > 3000000;";
//	}
//
//	/**
//	 * 显示被新添加的数据记录
//	 * @return 返回查询语句
//	 */
//	private static String searchNewSQL() {
//		System.out.println(separator);
//		System.out.println("显示被新添加的数据记录：");
//		return "select staff.*" +
//				"from staff" +
//				"where staff.sno between 171250021 and 171250025;";
//	}
//
//	/**
//	 * 向staff表中添加新的纪录
//	 * @return 返回插入语句
//	 */
//	private static String insertSQL() {
//		System.out.println(separator);
//		System.out.println("向staff表中添加记录: ");
//		return "insert into staff" +
//				"values" +
//				"('周',171250021,20,4000000,10087)" +
//				"('吴',171250022,21,4000010,10088)" +
//				"('郑',171250023,22,5000000,10089)" +
//				"('王',171250024,24,6000000,10087)" +
//				"('林',171250025,25,3000000,10088)" +
//				"('冯',171250026,40,2000000,10089;";
//	}
//
//	/**
//	 * 在staff表中删除sno为171250022的记录
//	 * @return 返回删除语句
//	 */
//	private static String deleteSQL() {
//		System.out.println(separator);
//		System.out.println("在staff表中删除sno为171250022的记录：");
//		return "delete from staff" +
//				"where staff.sno=171250022;";
//	}
//
//	/**
//	 * 在staff表中删除age大于等于40的记录
//	 *
//	 * @return 返回删除语句
//	 */
//	private static String deleteSQL2() {
//		System.out.println(separator);
//		System.out.println("在staff表中删除age大于等于40的记录: ");
//		return "delete from staff" +
//				"where staff.age >= 40;";
//	}
//
//	/**
//	 * 对staff表中的sno为171250024的记录进行更新，更新其年龄为18
//	 * @return 返回更新语句
//	 */
//	private static String updateSQL() {
//		System.out.println(separator);
//		System.out.println("对staff表中的sno为171250024的记录进行更新，更新其age为18：");
//		return "update staff" +
//				"set staff.age=18" +
//				"where staff.sno=171250024;";
//	}
//
//	/**
//	 * 对staff表中的sno为171250023的记录进行更新，更新其salary为6000000
//	 * @return 返回查询语句
//	 */
//	private static String updateSQL2() {
//		System.out.println(separator);
//		System.out.println("对staff表中的sno为171250023的记录进行更新，更新其salary为6000000：");
//		return "update staff" +
//				"set staff.salary=6000000" +
//				"where staff.sno=171250023;";
//	}
//
//	/**
//	 * 显示staff整张表
//	 * @return 返回查询语句
//	 */
//	private static String showStaffTable() {
//		System.out.println(separator);
//		System.out.println("显示staff表：");
//		return "select staff.*" +
//				"from staff;";
//	}
//}
