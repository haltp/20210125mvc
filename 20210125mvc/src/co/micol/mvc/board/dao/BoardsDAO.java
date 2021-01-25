package co.micol.mvc.board.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.micol.mvc.board.service.BoardVO;
import co.micol.mvc.common.DAO;

public class BoardsDAO extends DAO {
	// 보드테이블 접속하는 dao
	private PreparedStatement psmt;
	private ResultSet rs;

	private final String BOARDSELECTLIST = "SELECT * FROM BOARDS ORDER BY BOARD_NO DESC";
	private final String BOARDSELECT = "SELECT * FROM BOARDS WHERE BOARD_NO = ?";
	private final String BOARDINSERT = "INSERT INTO BOARDS VALUES(?,?,?,?,?)";
	private final String BOARDDELECT = "DELETE BOARDS WHERE BOARD_NO =?";

	public ArrayList<BoardVO> selectList() {
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		BoardVO vo;

		try {
			psmt = conn.prepareStatement(BOARDSELECTLIST);
			rs = psmt.executeQuery(); // record set을 리턴한다.
			while (rs.next()) {
				vo = new BoardVO();
				vo.setBoardNo(rs.getInt("board_no"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setWriter(rs.getString("writer"));
				vo.setCreationDate(rs.getDate("creation_date"));
				list.add(vo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return list;
	}

	public BoardVO select(BoardVO vo) {
		// 레코드 한건 조회 구문 작성
		try {
			psmt = conn.prepareStatement(BOARDSELECT);
			psmt.setInt(1, vo.getBoardNo()); // 구문=?에 대한 값 넣기
			rs = psmt.executeQuery(); // record set을 리턴한다.
			if (rs.next()) {
				vo.setBoardNo(rs.getInt("board_no"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setWriter(rs.getString("writer"));
				vo.setCreationDate(rs.getDate("creation_date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return vo;
	}

	public int insert(BoardVO vo) {
		int n = 0;
		// 여기에 입력작업을 쓴다
		try {
			psmt = conn.prepareStatement(BOARDINSERT);
			psmt.setInt(1, vo.getBoardNo()); // 구문=?에 대한 값 넣기
			psmt.setString(2, vo.getTitle());
			psmt.setString(3, vo.getContent());
			psmt.setString(4, vo.getWriter());
			psmt.setDate(5, vo.getCreationDate());
			n = psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return n;
	}

	public int update(BoardVO vo) {
		int n = 0;
		// 여기에 변경(수정)작업을 쓴다
		return n;
	}

	public int delete(BoardVO vo) {
		int n = 0;
		// 여기에 삭제작업을 쓴다
		try {
			psmt = conn.prepareStatement(BOARDDELECT);
			psmt.setInt(1, vo.getBoardNo()); // 구문=?에 대한 값 넣기
			n = psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return n;
	}

	private void close() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
