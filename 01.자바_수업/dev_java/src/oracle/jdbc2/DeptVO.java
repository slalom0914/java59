package oracle.jdbc2;

public class DeptVO {
	private int 	deptno 	= 0;//부서번호 -primary key-중복불가 or null불가
	private String 	dname 	= null;//부서명
	private String 	loc 	= null;//지역
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
}
