package jpabook.jpashop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;

@SpringBootApplication
public class JpashopApplication {

	public static void main(String[] args) {
		/*
		* 예제 시작 전.
		* 로그인과 권한 관리 X
		* 파라미터 검증과 예외 처리 단순화
		* 상품은 도서만 사용
		* 카테고리 사용 X
		* 배송 정보 사용 X
		* */
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


