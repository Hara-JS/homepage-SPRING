package com.geppetto.hara.pinocchio.repository;

import com.geppetto.hara.pinocchio.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
  // 이메일로 회원 정보 조회 (SELECT * FROM member_table WHERE member_email=?)
  Optional<MemberEntity> findByMemberEmail(String memberEmail);
}
