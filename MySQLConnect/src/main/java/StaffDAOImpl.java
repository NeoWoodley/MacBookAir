import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StaffDAOImpl extends BaseDAO implements StaffDAO {
	private static String separator = "----------------------------------------------------------------------";
	private Connection connection;
	private String SQL;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	private List<Staff> staffList;

	public StaffDAOImpl() throws SQLException {
		connection = BaseDAO.getConnection();

	}

	public void searchTable(String SQL) throws SQLException {
		this.SQL = SQL;
		searchTable();
	}

	private void searchTable() throws SQLException {
		staffList = new ArrayList<Staff>();
		System.out.println(separator);
		System.out.println("执行：" + SQL);
		preparedStatement = connection.prepareStatement(SQL);
		resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			Staff staff = new Staff(
					resultSet.getString("sname"),
					resultSet.getInt("sno"),
					resultSet.getInt("age"),
					resultSet.getInt("salary"),
					resultSet.getInt("deptno")
			);
			staffList.add(staff);
		}
		printStaffs();
	}

	public void updateTable(String SQL) throws SQLException {
		this.SQL = SQL;
		updateTable();
	}

	private void updateTable() throws SQLException {
		System.out.println(separator);
		System.out.println("执行：" + SQL);
		preparedStatement = connection.prepareStatement(SQL);
		int influencedRows = preparedStatement.executeUpdate();
		System.out.println("受影响的行数为：" + influencedRows);
		searchTable(showStaffTable());
	}

	/**
	 * 查询年龄在[20,23]之间的员工
	 *
	 * @return 返回查询语句
	 */
	private static String searchAgeSQL() {
		return "select staff.* " +
				"from staff " +
				"where staff.age between 20 and 23;";
	}

	/**
	 * 查询salary大于3000000的员工
	 *
	 * @return 返回查询语句
	 */
	private static String searchSalarySQL() {
		return "select staff.* " +
				"from staff " +
				"where staff.salary > 3000000;";
	}

	/**
	 * 向staff表中添加新的纪录
	 *
	 * @return 返回插入语句
	 */
	private static String insertSQL() {
		return "insert into staff " +
				"values " +
				"('周',171250021,20,4000000,10087)," +
				"('吴',171250022,21,4000010,10088)," +
				"('郑',171250023,22,5000000,10089)," +
				"('王',171250024,24,6000000,10087)," +
				"('林',171250025,25,3000000,10088)," +
				"('冯',171250026,40,2000000,10089);";
	}

	/**
	 * 在staff表中删除sno为171250022的记录
	 *
	 * @return 返回删除语句
	 */
	private static String deleteSQL() {
		return "delete from staff " +
				"where staff.sno=171250022;";
	}

	/**
	 * 在staff表中删除age大于等于40的记录
	 *
	 * @return 返回删除语句
	 */
	private static String deleteSQL2() {
		return "delete from staff " +
				"where staff.age >= 40;";
	}

	/**
	 * 对staff表中的sno为171250024的记录进行更新，更新其年龄为18
	 *
	 * @return 返回更新语句
	 */
	private static String updateSQL() {
		return "update staff " +
				"set staff.age=18 " +
				"where staff.sno=171250024;";
	}

	/**
	 * 对staff表中的sno为171250023的记录进行更新，更新其salary为6000000
	 *
	 * @return 返回查询语句
	 */
	private static String updateSQL2() {
		return "update staff " +
				"set staff.salary=6000000 " +
				"where staff.sno=171250023;";
	}

	/**
	 * 显示staff整张表
	 *
	 * @return 返回查询语句
	 */
	private static String showStaffTable() {
		return "select staff.* " +
				"from staff;";
	}

	public void printStaffs() {
		System.out.println("打印staffs：");
		System.out.printf("%-16s%-16s%-16s%-16s%-16s\n", "sname", "sno", "age", "salary", "deptno");
		for (Staff staff : staffList) {
			System.out.printf("%-16s%-16d%-16d%-16d%-16d\n", staff.getSname(), staff.getSno(), staff.getAge(),
					staff.getSalay(),
					staff.getDeptno());
//			System.out.printf("sname\tsno\tage\tsalay\tdeptno");
//			System.out.printf(staff.getSname() + "\t" + staff.getSno() + "\t" + staff.getAge() + "\t" + staff.getSalay() +
//					"\t" + staff.getDeptno());
		}
	}

	public static void main(String[] args) throws SQLException {
		StaffDAOImpl staffDAOImpl = new StaffDAOImpl();
		String SQL;
		// 打印最初的表格
		SQL = showStaffTable();
		staffDAOImpl.searchTable(SQL);

		// search
		// 查询年龄在[20,23]之间的员工的sname、sno、age
		SQL = searchAgeSQL();
		staffDAOImpl.searchTable(SQL);
		// 查询salary大于3000000的员工
		SQL = searchSalarySQL();
		staffDAOImpl.searchTable(SQL);

		// insert
		SQL = insertSQL();
		staffDAOImpl.updateTable(SQL);

		// delete
		SQL = deleteSQL();
		staffDAOImpl.updateTable(SQL);
		SQL = deleteSQL2();
		staffDAOImpl.updateTable(SQL);

		// update
		SQL = updateSQL();
		staffDAOImpl.updateTable(SQL);
		SQL = updateSQL2();
		staffDAOImpl.updateTable(SQL);

		BaseDAO.closeAll(staffDAOImpl.connection, staffDAOImpl.preparedStatement, staffDAOImpl.resultSet);
	}


}
