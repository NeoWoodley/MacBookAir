/**
 * Staff实体类
 */
public class Staff {
	private String sname;
	private int sno;
	private int age;
	private int salay;
	private int deptno;

	public Staff(String sname, int sno, int age, int salay, int deptno) {
		this.sname = sname;
		this.sno = sno;
		this.age = age;
		this.salay = salay;
		this.deptno = deptno;
	}

	public String getSname() {
		return sname;
	}

	public int getSno() {
		return sno;
	}

	public int getAge() {
		return age;
	}

	public int getSalay() {
		return salay;
	}

	public int getDeptno() {
		return deptno;
	}
}
