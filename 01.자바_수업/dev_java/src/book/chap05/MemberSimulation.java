package book.chap05;

public class MemberSimulation {

	public static void main(String[] args) {
		//String mem_name=null;
		Member mem = new Member();
		//before
		System.out.println("before "+mem.mem_name);
		mem.mem_name="김유신";//초기화 null==>김유신
		mem = null;
		//after
		//System.out.println("after "+mem.mem_name);//김유신
		mem = new Member();
		mem.mem_name="이순신";
		System.out.println("after "+mem.mem_name);//이순신
		
	}

}
