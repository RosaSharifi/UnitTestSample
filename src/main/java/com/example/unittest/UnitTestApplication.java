package com.example.unittest;

import com.example.unittest.session4.models.CollegeStudent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@SpringBootApplication
public class UnitTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnitTestApplication.class, args);
	}

//	@Bean
//	public String fizzBuzz3() {
//		for (int i = 0; i < 100; i++) {
//			System.out.println(FizzBuzz.compute(i));
//		}
//		return "";
//	}

	@Bean(name = "collegeStudent")
	@Scope(value = "prototype")
	CollegeStudent getCollegeStudent() {
		return new CollegeStudent();
	}
}