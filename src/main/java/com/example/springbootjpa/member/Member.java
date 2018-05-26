package com.example.springbootjpa.member;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

@Table(name="Member")	// class명과 같다면 생략가능.
@Entity
@Data
public class Member {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(columnDefinition="varchar(20)", nullable=false)
	private String name;
	
	@Column(length=14, nullable=false, updatable=false)
	private String telephone;
	
	@Column
	private int age;
	
	private Date regDate;
	
	@Transient	// DB에 저장되지 않음.
	private int birthYear;
	
	public Member() {}
	
	public Member(String name, int age) {
		this(name, "010-1234-1234", age);
	}
	
	public Member(String name, String telephone, int age) {
		this.name = name;
		this.telephone = telephone;
		this.age = age;
		this.birthYear = 2018 - age;
		this.regDate = new Date();
	}
	
	public int getBirthYear() {
		
		return Calendar.getInstance().get(Calendar.YEAR) - this.age;
	}
	
	@Override
	public String toString() {
		return String.format("[%d] name: %s, telephone: %s, age: %d(%d), regDate: %s", id, name, telephone, age, getBirthYear(), regDate);
	}
}
