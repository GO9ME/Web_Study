package kr.multicampus.erp.board;

import java.util.ArrayList;

import dao.CustomerVO;

public interface BoardDAO {
	public int insert(BoardDTO board);
	public ArrayList<BoardDTO> select();
	public BoardDTO read(int boardNo);
}
