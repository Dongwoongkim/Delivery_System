package kdo6301.DeliverySystem.web.member.login;

import kdo6301.DeliverySystem.domain.Member;
import kdo6301.DeliverySystem.dto.member.MemberDTO;
import kdo6301.DeliverySystem.dto.member.MemberLogInDTO;
import kdo6301.DeliverySystem.dto.member.MemberSignInDTO;
import kdo6301.DeliverySystem.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/members")
public class LoginController {
    private final LoginService loginService;

    @GetMapping("/login")
    public String loginForm(@ModelAttribute("memberLogInDTO") MemberLogInDTO memberSignInDTO) {
        return "members/loginForm";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("memberLogInDTO") MemberLogInDTO memberLogInDTO, BindingResult bindingResult, HttpServletRequest request,
                        @RequestParam(defaultValue = "/") String redirectURL) {
        if(bindingResult.hasErrors()) {
            return "members/loginForm";
        }
        MemberDTO memberDTO = loginService.login(memberLogInDTO.getLoginName(), memberLogInDTO.getPassword());

        // 실패 (object error)
        if (memberDTO == null) {
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 일치하지 않습니다.");
            return "members/loginForm";
        }
        // 성공
        // 세션이 있으면 있는 세션 리턴, 없으면 신규 세션 생성
        HttpSession session = request.getSession();
        session.setAttribute("loginMember", memberDTO);
        return "redirect:" + redirectURL;
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request)
    {
        HttpSession session = request.getSession(false);
        if(session!=null) {
            session.invalidate(); // 세션 삭제
        }
        return "redirect:/";
    }
}
