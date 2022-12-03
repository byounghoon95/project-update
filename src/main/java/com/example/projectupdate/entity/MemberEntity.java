package com.example.projectupdate.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name = "member")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class MemberEntity {

	@Builder
	public MemberEntity(String id, String name, String password, String userImg, int warningcnt, int bcd, int mcd, String role) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.userImg = userImg;
		this.warningcnt = warningcnt;
		this.bcd = bcd;
		this.mcd = mcd;
		this.role = role;
	}

	@Id
	@Column(name = "member_id", unique = true)
	private String id;
	@NotNull
	private String name;
	@NotNull
	private String password;
	private String userImg;
	private int warningcnt;
	private int bcd;
	private int mcd;
	private String role;


	//join
	@Transient
	private String content;
	@Transient
	private int chk;
	@Transient
	private int start;
	@Transient
	private int end;
	@Transient
	private String keyword;
	@Transient
	private String search;
}
