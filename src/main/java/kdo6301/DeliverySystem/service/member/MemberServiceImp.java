package kdo6301.DeliverySystem.service.member;

import kdo6301.DeliverySystem.domain.Member;
import kdo6301.DeliverySystem.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberServiceImp implements MemberService{
    private final MemberRepository memberRepository;
    @Override
    public Member save(Member member) {
        return memberRepository.save(member);
    }

    public boolean DuplicateId(Member member)
    {
        log.info("member login id = {}", member.getLoginId());
        Member findMember = memberRepository.findByLoginId(member.getLoginId());

        if (findMember == null) {
            return false;
        }

        return true;
    }
}
