package kdo6301.DeliverySystem.web.member;

import kdo6301.DeliverySystem.domain.Member;
import kdo6301.DeliverySystem.repository.MemberRepository;
import kdo6301.DeliverySystem.service.member.MemberService;
import kdo6301.DeliverySystem.service.member.MemberServiceImp;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/members")
public class SignInController {
    private final MemberServiceImp memberService;

    @GetMapping("/add")
    public String addForm(@ModelAttribute("member") Member member)
    {
        return "members/addForm";
    }

    @PostMapping("/add")
    public String save(@Validated @ModelAttribute("member") Member member, BindingResult bindingResult)
    {
        if (bindingResult.hasErrors()) {
            return "members/addForm";
        }

        // 아이디 중복 object error
        if (memberService.DuplicateId(member))
        {
            bindingResult.reject("duplicateId","이미 존재하는 아이디입니다. 다른 아이디를 사용해 주세요.");
            return "members/addForm";
        }

        else
        {
            memberService.save(member);
            return "redirect:/";
        }
    }
}
