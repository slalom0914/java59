package thread.step1;
/*
 * 프로세스란 실행중인 프로그램이다.
 * 프로그램을 실행하면 OS로부터 실행에 필요한 자원(메모리)을 할당받아 프로세스가 된다.
 * 프로세스는 프로그램을 수행하는데 필요한 데이터와 메모리 등의 자원 그리고 스레드로 구성
 * 되어 있으며 프로세스의 자원을 이용하여 실제로 작업을 수행하는 것이 바로 스레드이다.
 * 프로세스와 스레드 관계
 * 모든 프로세스에는 하나 이상의 스레드가 존재한다.
 * 둘 이상의 스레드를 가진 프로세스를 멀티스레드 프로세스라고 한다.
 * 
 */
public class ProcessTest extends Thread{
	@Override
	public void run() {
		System.out.println("run호출 성공===>"+this.getName());
		
	}
	public static void main(String[] args) {
		ProcessTest pt = new ProcessTest();
		Thread th = new ProcessTest();
		pt.start();
		//th.start();

	}

}
