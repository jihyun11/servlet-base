package hello.servlet.web.servletmvc;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "mvcMemberListServlet", urlPatterns = "/servlet-mvc/members")
public class MvcMemberListServlet extends HttpServlet {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    // 클라이언트가 컨트롤러를 통해 호출 (1)
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServletException {

        // 서비스, 리포지토리 등을 통해 비즈니스로직 데이터 접근 (2)
        List<Member> members = memberRepository.findAll();

        // 데이터 모델에 전달 (3)
        request.setAttribute("members", members);

        // 어디 뷰로 갈 건지 정하기 (4)
        String viewPath = "/WEB-INF/views/members.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);

        // 뷰에서는 데이터 참조 (5)
        // 응답 (6)
        dispatcher.forward(request, response);

    }
}
