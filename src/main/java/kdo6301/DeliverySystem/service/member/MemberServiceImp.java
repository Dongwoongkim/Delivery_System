package kdo6301.DeliverySystem.service.member;

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
public class MemberServiceImp implements MemberService{
    private final MemberRepository memberRepository;
    @Override
    public void save(MemberSignInDTO memberSignInDTO) {

        memberRepository.save(new Member(
                        memberSignInDTO.getLoginName(),
                        memberSignInDTO.getName(),
                        memberSignInDTO.getPassword()));
    }
    public boolean DuplicateId(MemberSignInDTO memberSignInDTO) {
        Member findMember = memberRepository.findByLoginName(memberSignInDTO.getLoginName());
        if (findMember == null) {
            return false;
        }
        return true;
    }
}
