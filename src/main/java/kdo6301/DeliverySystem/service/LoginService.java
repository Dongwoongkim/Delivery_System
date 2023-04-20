package kdo6301.DeliverySystem.service;

import kdo6301.DeliverySystem.domain.Member;
import kdo6301.DeliverySystem.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final MemberRepository memberRepository;

    public Member login(String loginId, String password) {
        Member member = memberRepository.findByLoginId(loginId);

        if(Member.validateLogin(member,password))
        {
            return member;
        }
        return null;
    }
}
