package design.book;

import java.util.List;

public class BookController {
	BookApp bookApp = null;
	private static final String _DEL = "delete";//삭제하기
	private static final String _SEL = "detail";//상세조회
	private static final String _INS = "insert";//입력하기
	private static final String _UPD = "update";//수정하기
	private static final String _ALL = "all";//전체조회
	public BookController(BookApp bookApp) {
		this.bookApp = bookApp;
	}
	public BookVO send(BookVO pbVO) {
		BookVO rbVO = new BookVO();
		String command = pbVO.getCommand();
		//insert here
		if(_DEL.equals(command)) {//삭제버튼을 눌렀겠구나?
		//DELETE FROM book2020 WHERE b_no=1	
			int result = 0;
			result = bookApp.bDao.bookDelete(pbVO);
			rbVO.setResult(result);
		}
		else if(_INS.equals(command)) {//입력을 원한다
		//INSERT INTO book2020(b_no, b_name, b_author, b_publish, b_info)
		//VALUES(?,?,?,?,?)	
			int result = 0;
			result = bookApp.bDao.bookInsert(pbVO);
			rbVO.setResult(result);
		}
		else if(_UPD.equals(command)) {//수정하기를 처리
		//UPDATE book2020 SET b_name=?, b_author=?, b_publish=?
		// WHERE b_no=2	
			int result = 0;
			result = bookApp.bDao.bookUpdate(pbVO);
			rbVO.setResult(result);
		}
		else if(_SEL.equals(command)) {//상세조회 예측
			System.out.println("상세조회 호출 성공");
		//SELECT b_no, b_name, b_author, b_publish FROM book2020
		// WHERE b_no=3	
			rbVO = bookApp.bDao.bookDetail(pbVO);
		}
		return rbVO;
	}///////////////////end of send
	//전체 조회
	public List<BookVO> sendALL(BookVO pbVO){
		System.out.println("sendALL 호출 성공");
		List<BookVO> bList = null;
		String command = pbVO.getCommand();//all
		if(_ALL.equals(command)) {//너 전체조회를 누른거니?
			//사용자의 선택은 읽었지만 여기서 db연동을 하지는 않는다. BookDao
			bList = bookApp.bDao.bookList(pbVO);			
		}
		return bList;
	}///////////////////end of sendALL
}
