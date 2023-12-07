package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class BoardServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter(); // 응답 바디에 출력
        out.println("<form method='post' action='/exam04/board'>");
        out.println("제목 : <input type='text' name='subject'> <br>");
        out.println("내용 : <textarea name='content'></textarea> <br>");
        out.println("<button type='submit'>작성하기</button>");
        out.println("</form>");
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}