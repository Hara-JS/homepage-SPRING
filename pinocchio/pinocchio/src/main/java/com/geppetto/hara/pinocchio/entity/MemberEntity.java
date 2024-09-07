package com.geppetto.hara.pinocchio.entity;

import com.geppetto.hara.pinocchio.dto.MemberDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

// JPA가 DATABASE TABLE을 DB에 만들어줌
@Entity
@Setter
@Getter
@Table(name= "member_table")
public class MemberEntity {
  @Id // pk 지정
  @GeneratedValue(strategy = GenerationType.IDENTITY) // mysql : auto_increment, oracle : sequence 지정
  private Long id;

  @Column(unique = true) // unique 제약 조건 추가
  private String memberEmail; // DB에서는 member_email로 변환

  @Column
  private String memberPassword;

  @Column
  private String memberName;

  public static MemberEntity toMemberEntity(MemberDTO memberDTO) {
    MemberEntity memberEntity = new MemberEntity();
    memberEntity.setMemberEmail(memberDTO.getMemberEmail());
    memberEntity.setMemberPassword(memberDTO.getMemberPassword());
    memberEntity.setMemberName(memberDTO.getMemberName());
    return memberEntity;
  }

  public static MemberEntity toUpdateMemberEntity(MemberDTO memberDTO) {
    MemberEntity memberEntity = new MemberEntity();
    memberEntity.setId(memberDTO.getId());
    memberEntity.setMemberEmail(memberDTO.getMemberEmail());
    memberEntity.setMemberPassword(memberDTO.getMemberPassword());
    memberEntity.setMemberName(memberDTO.getMemberName());
    return memberEntity;
  }
}
