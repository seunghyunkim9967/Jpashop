package jpabook.jpashop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpashopApplication {

	public static void main(String[] args) {
		Hello hello = new Hello();
		hello.setData("hello");
		String data = hello.getData();
		System.out.println("data = " + data);





		SpringApplication.run(JpashopApplication.class, args);
		/*
		엔티티 클래스 개발 할때
		실무에서는 가급적 Getter는 열어두고 Setter는 꼭 필요한 경우에만 사용 권장
		(엔티티 변경 추적 어려움 가급적 사용 X)
		모든 연관관계는 지연로딩 설정 (LAZY)
		컬렉션은 필드에서 초기화 (null 안전)
		*/
	}

}
