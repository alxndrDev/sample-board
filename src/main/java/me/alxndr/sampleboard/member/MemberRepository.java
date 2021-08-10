package me.alxndr.sampleboard.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : Alexander Choi
 * @date : 2021/08/10
 */
@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
}
