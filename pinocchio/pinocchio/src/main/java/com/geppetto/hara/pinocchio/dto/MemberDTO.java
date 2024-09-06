package com.geppetto.hara.pinocchio.dto;

import com.geppetto.hara.pinocchio.entity.MemberEntity;
import lombok.*;

@Getter // 각각 필드에 대한 getter 자동 생성
@Setter // 각각 필드에 대한 setter 자동 생성
@NoArgsConstructor // 기본 생성자 자동 생성
@AllArgsConstructor // 필드를 모두 매개 변수로 하는 생성자 자동 생성
@ToString // DTO 객체가 가지고 있는 필드값을 출력. ToString 메서드를 자동 생성
public class MemberDTO {
    private Long id;
    private String memberEmail;
    private String memberPassword;
    private String memberName;

    public static MemberDTO toMemberDTO(MemberEntity memberEntity) {
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setId(memberEntity.getId());
        memberDTO.setMemberEmail(memberEntity.getMemberEmail());
        memberDTO.setMemberPassword(memberEntity.getMemberPassword());
        memberDTO.setMemberName(memberEntity.getMemberName());
        return memberDTO;
    }
}
