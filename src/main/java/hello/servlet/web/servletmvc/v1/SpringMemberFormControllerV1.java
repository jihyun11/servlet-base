package hello.servlet.web.servletmvc.v1;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// Controller 어노테이션 있으면 핸들러 매핑의 대상이 자동으로 됨
// 이거 아니면 Component, RequestMapping 이렇게 2개 붙어 있으면 똑같은 기능 됨
// 단, 클래스 레벨에 붙어있어야 한다
@Controller
//@Component
//@RequestMapping
public class SpringMemberFormControllerV1 {

    // 요청 정보를 매핑
    @RequestMapping("/springmvc/v1/members/new-form")
    public ModelAndView process() {
        return new ModelAndView("new-form");
    }
}
