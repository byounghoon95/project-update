package com.example.projectupdate.user.mypage.repository;

import com.example.projectupdate.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyPageRepository extends JpaRepository<MemberEntity, String> {
}
