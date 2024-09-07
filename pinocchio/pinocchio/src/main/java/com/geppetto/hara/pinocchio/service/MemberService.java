package com.geppetto.hara.pinocchio.service;

import com.geppetto.hara.pinocchio.dto.MemberDTO;
import com.geppetto.hara.pinocchio.entity.MemberEntity;
import com.geppetto.hara.pinocchio.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

  private final MemberRepository memberRepository;

  // join, signup 다 가능하지만 repository의 메서드 이름은 save로 지정해야 함
  public void save(MemberDTO memberDTO) {
    // 1. dto -> entity 변환
    // 2. repository의 save 메서드 호출 (조건. entity 객체를 넘겨줘야 함)
    MemberEntity memberEntity = MemberEntity.toMemberEntity(memberDTO);
    // repository의 save 메서드는 JPA가 제공해주는 메서드이기 때문에 이름을 save()로 지정해야 함
    memberRepository.save(memberEntity);
  }

  public MemberDTO signin(MemberDTO memberDTO) {
    // 1. 회원이 입력한 이메일로 DB에서 조회를 함
    // 2. DB에서 조회한 비밀번호와 사용자가 입력한 비밀번호가 일치하는지 판단
    Optional<MemberEntity> byMemberEmail = memberRepository.findByMemberEmail(memberDTO.getMemberEmail());
    if (byMemberEmail.isPresent()) {
      // 조회 결과 있음 (해당 이메일을 가진 회원 정보가 있음)
      MemberEntity memberEntity = byMemberEmail.get();
      if (memberEntity.getMemberPassword().equals(memberDTO.getMemberPassword())) {
        // 비밀번호 일치
        // entity -> dto 변환 후 반환
        MemberDTO dto = MemberDTO.toMemberDTO(memberEntity);
        return dto;
      } else {
        // 비밀번호 불일치 (로그인 실패)
        return null;
      }
    } else {
      // 조회 결과 없음 (해당 이메일을 가진 회원 정보가 없음)
      return null;
    }
  }

  public List<MemberDTO> findAll() {
    List<MemberEntity> memberEntityList = memberRepository.findAll();
    List<MemberDTO> memberDTOList = new ArrayList<>();
    for (MemberEntity memberEntity : memberEntityList) {
      // DTO 객체를 담기 위한 리스트
      memberDTOList.add(MemberDTO.toMemberDTO(memberEntity));
      // entity를 DTO로 변환
//            MemberDTO memberDTO = MemberDTO.toMemberDTO(memberEntity);
      // 변환된 DTO를 담기 위한 리스트
//            memberDTOList.add(memberDTO);
    }
    return memberDTOList;
  }

  public MemberDTO findById(Long id) {
    Optional<MemberEntity> optionalMemberEntity = memberRepository.findById(id);
    if (optionalMemberEntity.isPresent()) {
//            MemberEntity memberEntity = optionalMemberEntity.get();
//            MemberDTO memberDTO = MemberDTO.toMemberDTO(memberEntity);
//            return memberDTO;
      return MemberDTO.toMemberDTO(optionalMemberEntity.get());
    } else {
      return null;
    }

  }

  public MemberDTO updateForm(String myEmail) {
    Optional<MemberEntity> optionalMemberEntity = memberRepository.findByMemberEmail(myEmail);
    if (optionalMemberEntity.isPresent()) {
      return MemberDTO.toMemberDTO(optionalMemberEntity.get());
    } else {
      return null;
    }
  }

  public void update(MemberDTO memberDTO) {
    memberRepository.save(MemberEntity.toUpdateMemberEntity(memberDTO));
  }

  public void deleteById(Long id) {
    memberRepository.deleteById(id);
  }

  public String emailCheck(String memberEmail) {
    Optional<MemberEntity> byMemberEmail = memberRepository.findByMemberEmail(memberEmail);
    if (byMemberEmail.isPresent()) {
      // 조회 결과 있음 -> 사용 불가능
      return null;
    } else {
      // 조회 결과 없음 -> 사용 가능
      return "ok";
    }
  }
}
