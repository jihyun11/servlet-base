package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// 파라미터 전송 기능
// http://localhost:8080/request-param?username=hello&age=20

@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        printHeaders(request);

        System.out.println("전체 파라미터 조회 - start");

        // username에 속한 "jihyun" 같은 값 꺼내기
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> System.out.println(paramName + "=" + request.getParameter(paramName)));

        System.out.println("전체 파라미터 조회 - end");
        System.out.println();

        System.out.println("단일 파라미터 조회");
        String username = request.getParameter("username");
        String age = request.getParameter("age");

        System.out.println("username = " + username);
        System.out.println("age = " + age);
        System.out.println();

        System.out.println("이름이 같은 복수 파라미터 조회");
        String[] usernames = request.getParameterValues("username");
        for (String user : usernames) {
            System.out.println("username = " + user);
        }

        response.getWriter().write("ok");


    }

    private void printHeaders(HttpServletRequest request) {
        System.out.println("--- Headers - start ---");

        request.getHeaderNames().asIterator()
                .forEachRemaining(headerName -> System.out.println(headerName + ": " + request.getHeader(headerName)));

        System.out.println("--- Headers - end ---");
        System.out.println();
    }
}
