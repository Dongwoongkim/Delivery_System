package kdo6301.DeliverySystem.web;

import kdo6301.DeliverySystem.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Slf4j
@Controller
public class HomeController {

    @GetMapping("/")
    public String home(@SessionAttribute(name="loginMember", required = false) Member loginMember, Model model)
    {
        // 세션에 회원데이터 없으면 home 이동
        if(loginMember == null) {
            return "home";
        }

        // 세션에 회원데이터 있으면 loginhome 이동
        model.addAttribute("member",loginMember);
        return "loginHome";
    }
}
