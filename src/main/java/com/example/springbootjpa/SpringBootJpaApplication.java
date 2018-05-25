package com.example.springbootjpa;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.springbootjpa.member.Member;
import com.example.springbootjpa.member.MemberRepository;

@SpringBootApplication
public class SpringBootJpaApplication implements CommandLineRunner {

	Logger logger = LoggerFactory.getLogger(SpringBootJpaApplication.class);
	
	@Autowired
	MemberRepository memberRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		memberRepository.save(new Member("a", 10));
		memberRepository.save(new Member("b", 15));
		memberRepository.save(new Member("c", 10));
		memberRepository.save(new Member("d", 5));
		
		logger.info("findAll() Method.");
		Iterable<Member> list1 = memberRepository.findAll();
		printMember(list1);
		
		logger.info("findByNameAndAgeLessThan() Method.");
		List<Member> list2 = memberRepository.findByNameAndAgeLessThan("a", 10);
		printMember(list2);
		
		logger.info("findByNameAndAgeLessThanSQL() Method.");
		List<Member> list3 = memberRepository.findByNameAndAgeLessThanSQL("a", 10);
		printMember(list3);
		
		logger.info("findByNameAndAgeLessThanSQL() Method.");
		List<Member> list4 = memberRepository.findByNameAndAgeLessThanOrderByAgeDesc("a", 15);
		printMember(list4);

		//memberRepository.deleteAll();
		
	}

	private void printMember(Iterable<Member> list) {
		for (Member m :list) {
			logger.info(m.toString());
		}
	}
}
