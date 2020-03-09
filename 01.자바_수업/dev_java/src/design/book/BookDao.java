package design.book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.util.DBConnectionMgr;


public class BookDao {
	DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	public int bookDelete(BookVO pbVO) {
		int result = 0;
		System.out.println("bookDelete");
		result = 1;
		return result;
	}

	public int bookInsert(BookVO pbVO) {
		System.out.println("bookInsert");
		return 0;
	}

	public int bookUpdate(BookVO pbVO) {
		System.out.println("bookUpdate");
		return 0;
	}

	public BookVO bookDetail(BookVO pbVO) {
		System.out.println("bookDetail");
		BookVO rbVO = null;
		StringBuilder sql = new StringBuilder();
		try {
			sql.append("SELECT b_no, b_name, b_author, b_publish");
			sql.append(" ,b_info FROM book2020                         ");
			sql.append(" WHERE b_no=?");//2
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			//insert here
			pstmt.setInt(1, pbVO.getB_no());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				rbVO = new BookVO();
				rbVO.setB_no(rs.getInt("b_no"));
				rbVO.setB_name(rs.getString("b_name"));
				rbVO.setB_author(rs.getString("b_author"));
				rbVO.setB_publish(rs.getString("b_publish"));
				rbVO.setB_info(rs.getString("b_info"));
			}
			System.out.println("rbVO:"+rbVO.getB_info());
		} catch (SQLException se) {
			System.out.println(se.toString());
			System.out.println("[query]"+ sql.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return rbVO;
	}
	//전체 조회 구현
	public List<BookVO> bookList(BookVO pbVO) {
		System.out.println("bookList() 호출 성공");
		List<BookVO> bookList = new ArrayList<>();//bookList.size()=0
		StringBuilder sql = new StringBuilder();
		try {
			sql.append("SELECT b_no, b_name, b_author, b_publish");
			sql.append("  FROM book2020                         ");
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			BookVO rbVO = null;
			while(rs.next()) {
				rbVO = new BookVO();
				rbVO.setB_no(rs.getInt("b_no"));
				rbVO.setB_name(rs.getString("b_name"));
				rbVO.setB_author(rs.getString("b_author"));
				rbVO.setB_publish(rs.getString("b_publish"));
				bookList.add(rbVO);
			}
			System.out.println("bookList.size():"+bookList.size());
		} catch (SQLException se) {
			System.out.println(se.toString());
			System.out.println("[query]"+ sql.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bookList;
	}/////////////////////end of bookList

}
