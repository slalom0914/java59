package book.chap12;
//조인시에 VO클래스 설계는 어떻게 가져가야 할까요?
public class TdeptVO {
	private String dept_code  =null;  
	private String dept_name  =null;  
	private String parent_dept=null;  
	private String use_yn     =null;  
	private String area       =null;  
	private int    boss_id    =0;
	public String getDept_code() {
		return dept_code;
	}
	public void setDept_code(String dept_code) {
		this.dept_code = dept_code;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public String getParent_dept() {
		return parent_dept;
	}
	public void setParent_dept(String parent_dept) {
		this.parent_dept = parent_dept;
	}
	public String getUse_yn() {
		return use_yn;
	}
	public void setUse_yn(String use_yn) {
		this.use_yn = use_yn;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public int getBoss_id() {
		return boss_id;
	}
	public void setBoss_id(int boss_id) {
		this.boss_id = boss_id;
	}  
}
