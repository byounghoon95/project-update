package com.example.projectupdate.user.login.repository;

import com.example.projectupdate.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<MemberEntity, String> {
}
