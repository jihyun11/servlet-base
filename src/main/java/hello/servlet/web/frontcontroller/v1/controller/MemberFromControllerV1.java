package hello.servlet.web.frontcontroller.v1.controller;

import hello.servlet.web.frontcontroller.v1.ControllerV1;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class MemberFromControllerV1 implements ControllerV1 {
    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String viewPath = "/WEB-INF/views/new-form.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);// 컨트롤러에서 뷰로 이동하게 해주는것

        // 다른 서블릿이나 jsp로 진짜로 이동하게 함
        // 서버 내부에서 다시 호출이 발생한(리다이렉트의 개념이 아님. 클라이언트-서버를 왔다갔다 하지 않고 서버 내부에서만 호출함)
        // web-inf 안에 있는 파일들은 반드시 컨트롤러를 거쳐야 한다.
        dispatcher.forward(request, response);
    }
}
