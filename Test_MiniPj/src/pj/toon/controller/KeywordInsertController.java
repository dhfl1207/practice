package pj.toon.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pj.toon.dao.WebtoonDao;
import pj.toon.vo.KeywordVo;

@WebServlet("/KeywordInsertController.do")
public class KeywordInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public KeywordInsertController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		WebtoonDao dao = new WebtoonDao();
		KeywordVo vo = new KeywordVo();
		
		String toon_no = request.getParameter("toon_no");
		
		vo.setK_no(Integer.valueOf(""));
		vo.setK_name(request.getParameterValues("keyword"));
		vo.setToon_no(Integer.valueOf(toon_no));
		vo.setReview_no(Integer.valueOf(""));
		
		int n = dao.insert_keyword(vo);
		if ( n != 0 ) {
			response.sendRedirect("/MiniPj/DetailController.do?toon_no="+toon_no);
		} else {
			System.out.println("댓글 등록 실패");	
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
