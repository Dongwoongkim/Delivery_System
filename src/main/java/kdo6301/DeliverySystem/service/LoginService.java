package kdo6301.DeliverySystem.service;

import kdo6301.DeliverySystem.domain.Member;
import kdo6301.DeliverySystem.dto.member.MemberDTO;
import kdo6301.DeliverySystem.dto.member.MemberSignInDTO;
import kdo6301.DeliverySystem.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class LoginService {
    private final MemberRepository memberRepository;

    public MemberDTO login(String loginName, String password) {
        Member member = memberRepository.findByLoginName(loginName);

        if(member!=null) {
            if(member.validateLogin(password)) {
                return member.toDto();
            }
        }
        return null;
    }
}
