package design.book;

import java.util.List;

public class BookTest {

	public static void main(String[] args) {
		BookController bCtrl = new BookController();
		BookVO pbVO = new BookVO();
		pbVO.setCommand("delete");
		BookVO rbVO = bCtrl.send(pbVO);
		System.out.println("삭제 처리 여부 ===> "+rbVO.getResult());
		pbVO = null;
		pbVO = new BookVO();
		pbVO.setCommand("update");
		rbVO = bCtrl.send(pbVO);
		System.out.println("수정 처리 여부 ===> "+rbVO.getResult());
		pbVO = null;
		pbVO = new BookVO();
		pbVO.setCommand("insert");
		rbVO = bCtrl.send(pbVO);
		System.out.println("입력 처리 여부 ===> "+rbVO.getResult());
		pbVO = null;
		pbVO = new BookVO();
		pbVO.setCommand("detail");
		pbVO.setB_no(2);
		rbVO = bCtrl.send(pbVO);
		System.out.println("상세조회 처리 여부 ===> "+rbVO);
		pbVO = null;
		pbVO = new BookVO();
		List<BookVO> bookList = null;
		pbVO.setCommand("all");
		bookList = bCtrl.sendALL(pbVO);
		System.out.println("전체조회 처리 여부 ===> "+bookList);
	}

}
