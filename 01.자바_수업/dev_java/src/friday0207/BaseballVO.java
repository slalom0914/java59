package friday0207;

public class BaseballVO {
	private int    game_no   =0;// 
	private int    game_seq  =0;// 
	private String game_date =null;// 
	private String input     =null;// 
	private String hint      =null;// 
	private String dap       =null;// 
	private int    score     =0;// 
	private String mem_id    =null;// 
	public BaseballVO(String mem_id, int no, String input
			        , String hint, String dap) {
		this.mem_id 	= mem_id;
		this.game_seq 	= no;
		this.input 		= input;
		this.hint 		= hint;
		this.dap 		= dap;
	}
	public int getGame_no() {
		return game_no;
	}
	//setter메소드의 파라미터로 사용자가 입력한 값 혹은 선택한 정보 또는 결정된 값 들이
	//넘어온다. 그런데 이값들은 지변에 담기게 되어서 메소드 영역밖에서는 사용이 불가함.
	//이 때 지변에 담긴 정보를 전변에 다시 초기화 해주면 클래스 전역에서 사용가능함.
	//또 내안이 아니더라도 다른 클래스에서 인스턴스화 하면 전변은 그대로 누릴 수 있다.
	public void setGame_no(int game_no) {
		this.game_no = game_no;
	}
	public int getGame_seq() {
		return game_seq;
	}
	public void setGame_seq(int game_seq) {
		this.game_seq = game_seq;
	}
	public String getGame_date() {
		return game_date;
	}
	public void setGame_date(String game_date) {
		this.game_date = game_date;
	}
	public String getInput() {
		return input;
	}
	public void setInput(String input) {
		this.input = input;
	}
	public String getHint() {
		return hint;
	}
	public void setHint(String hint) {
		this.hint = hint;
	}
	public String getDap() {
		return dap;
	}
	public void setDap(String dap) {
		this.dap = dap;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
}
