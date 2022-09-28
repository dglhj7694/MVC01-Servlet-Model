package kr.bit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloStart
 */
@WebServlet("/h.do")
public class HelloStart extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1. 클라이언트의 요청을 받는 작업 (파라미터 수집)
		//2. 처리하는 작업 (비지니스 로직)
		//3. 클라이언트에게 요청했던 응답하는 작업
		int sum = 0;
		for (int i = 1; i <= 10; i++) {
			sum += i;
		}
		PrintWriter out = response.getWriter(); // getWrite() : 출력스트림
		out.println("<html>");
		out.println("<body>");
		out.println(sum);
		out.println("</body>");
		out.println("</html>");
	}
}
