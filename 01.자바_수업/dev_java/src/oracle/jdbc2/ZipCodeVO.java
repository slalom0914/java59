package oracle.jdbc2;
/*
 * private<protected<friendly[코딩하지않음]<public 
 */
public class ZipCodeVO {
	//protected int i;
	private int    uid_no  =0;//  
	//인스턴스화를 해야만 사용할 수 있으니까...
	//인스턴스화가 null로 초기화되면 그 값은 사라지므로 변조할 수 없을거야
	private int    zipcode =0;//private으로 둔 이유는 변조를 방지하기 위해서...  
	private String zdo     ="";//  
	private String sigu    ="";//  
	private String dong    ="";//  
	private String ri      ="";//  
	private String bungi   ="";//  
	private String aptname ="";//  
	private String upd_date="";//  
	private String address ="";//  
	//getter메소드 - 읽기
	public int getUid_no() {
		return uid_no;
	}
	//setter메소드 - 저장,쓰기,기억, 초기화 - 메소드 이름은 카멜표기법
	public void setUid_no(int uid_no) {
		this.uid_no = uid_no;
	}
	public int getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	public String getZdo() {
		return zdo;
	}
	public void setZdo(String zdo) {
		this.zdo = zdo;
	}
	public String getSigu() {
		return sigu;
	}
	public void setSigu(String sigu) {
		this.sigu = sigu;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	public String getRi() {
		return ri;
	}
	public void setRi(String ri) {
		this.ri = ri;
	}
	public String getBungi() {
		return bungi;
	}
	public void setBungi(String bungi) {
		this.bungi = bungi;
	}
	public String getAptname() {
		return aptname;
	}
	public void setAptname(String aptname) {
		this.aptname = aptname;
	}
	public String getUpd_date() {
		return upd_date;
	}
	public void setUpd_date(String upd_date) {
		this.upd_date = upd_date;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
