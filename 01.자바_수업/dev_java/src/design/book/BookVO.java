package design.book;

import java.util.List;

public class BookVO {
	private int    b_no     =0;//  
	private String b_name   ="";//  
	private String b_author ="";//  
	private String b_publish="";//  
	private String b_info   ="";//  
	private String b_img    ="";//도서 이미지 파일명 추가하기
	public String command = null;//delete or update or insert or select or all
	public int 	   result = 0;//INSERT or UPDATE or DELETE 0:실패 1:성공
	public List<Integer> bnos = null;
	public int getB_no() {
		return b_no;
	}
	public void setB_no(int b_no) {
		this.b_no = b_no;
	}
	public String getB_name() {
		return b_name;
	}
	public void setB_name(String b_name) {
		this.b_name = b_name;
	}
	public String getB_author() {
		return b_author;
	}
	public void setB_author(String b_author) {
		this.b_author = b_author;
	}
	public String getB_publish() {
		return b_publish;
	}
	public void setB_publish(String b_publish) {
		this.b_publish = b_publish;
	}
	public String getB_info() {
		return b_info;
	}
	public void setB_info(String b_info) {
		this.b_info = b_info;
	}
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {//all or detail or insert or update or delete
		this.command = command;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public String getB_img() {
		return b_img;
	}
	public void setB_img(String b_img) {
		this.b_img = b_img;
	}
	public List<Integer> getBnos() {
		return bnos;
	}
	public void setBnos(List<Integer> bnos) {
		this.bnos = bnos;
	}
}
