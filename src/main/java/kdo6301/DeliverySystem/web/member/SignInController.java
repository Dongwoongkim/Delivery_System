package kdo6301.DeliverySystem.web.member;

import kdo6301.DeliverySystem.dto.member.MemberDTO;
import kdo6301.DeliverySystem.dto.member.MemberSignInDTO;
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
    public String addForm(@ModelAttribute("member") MemberSignInDTO memberAddDTO)
    {
        return "members/addForm";
    }

    @PostMapping("/add")
    public String save(@Validated @ModelAttribute("member") MemberSignInDTO memberSignInDTO, BindingResult bindingResult)
    {
        if (bindingResult.hasErrors()) {
            return "members/addForm";
        }
        // 아이디 중복 object error
        if (memberService.DuplicateId(memberSignInDTO)) {
            bindingResult.reject("duplicateId","이미 존재하는 아이디입니다. 다른 아이디를 사용해 주세요.");
            return "members/addForm";
        }
        else {
            memberService.save(memberSignInDTO);
            return "redirect:/";
        }
    }
}
