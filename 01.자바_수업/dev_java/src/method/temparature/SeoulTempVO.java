package method.temparature;
/* VO(Value Object)생성하기-자바와 오라클 사이에서 인터페이스 역할을 하게 됨.
 * 오라클과 자바는 데이터 타입이 서로 다르다.
 * 그런데 자료는 서로 공유해야 한다.
 * 그럴때 VO패턴을 통해서 값을 주고 받고자 한다.
 * 
 */
public class SeoulTempVO {
	private String sdate  =null;// 
	private int    loc 	  =0;// 
	private double atemp  =0.0;// 
	private double mitemp =0.0;// 
	private double matemp =0.0;// 
	//실제 테이블에 존재하는 컬럼은 아니지만 프로그램에 필요한 변수 선언도 가능함.
	private String nYear = null;//콤보박스에서 사용자가 선택한 년도 저장하기
	private String nMonth = null;//콤보박스에서 사용자가 선택한 월 정보 저장하기
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public int getLoc() {
		return loc;
	}
	public void setLoc(int loc) {
		this.loc = loc;
	}
	public double getAtemp() {
		return atemp;
	}
	public void setAtemp(double atemp) {
		this.atemp = atemp;
	}
	public double getMitemp() {
		return mitemp;
	}
	public void setMitemp(double mitemp) {
		this.mitemp = mitemp;
	}
	public double getMatemp() {
		return matemp;
	}
	public void setMatemp(double matemp) {
		this.matemp = matemp;
	}
	public String getnYear() {
		return nYear;
	}
	public void setnYear(String nYear) {
		this.nYear = nYear;
	}
	public String getnMonth() {
		return nMonth;
	}
	public void setnMonth(String nMonth) {
		this.nMonth = nMonth;
	}
}
