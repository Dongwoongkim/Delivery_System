package kdo6301.DeliverySystem.repository;

import kdo6301.DeliverySystem.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface MemberRepository extends JpaRepository<Member,Long> {
    public Member findByLoginId(String loginId);
}
