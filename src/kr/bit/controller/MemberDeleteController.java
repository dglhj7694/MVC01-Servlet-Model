package kr.bit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemberDAO;

/**
 * Servlet implementation class MemberDeleteController
 */
@WebServlet("/memberDelete.do")
public class MemberDeleteController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));

		MemberDAO dao = new MemberDAO();
		int cnt = dao.memberDelete(num);

		if (cnt > 0) {
			response.sendRedirect("/MVC01/memberList.do"); //서버가 클라이언트 브라우저를  sendRedirect 다시 해당 경로로 다시 바꿔준다. 
		} else {
			throw new ServletException("not delete");
		}
	}

}
