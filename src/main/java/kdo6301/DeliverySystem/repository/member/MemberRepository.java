package kdo6301.DeliverySystem.repository.member;

import kdo6301.DeliverySystem.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {
    public Member findByLoginName(String loginName);
}
