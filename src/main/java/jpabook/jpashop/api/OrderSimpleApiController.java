package jpabook.jpashop.api;

import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderStatus;
import jpabook.jpashop.repository.OrderRepository;
import jpabook.jpashop.repository.OrderSearch;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.stream.Collectors.toList;

/*
*
* xToOne(MTO, OTO)
* order
* order -> member
* order -> delivery
* */
@RestController
@RequiredArgsConstructor
public class OrderSimpleApiController {

    private final OrderRepository orderRepository;
//    private final OrderSimpleQueryDto orderSimpleQueryDto;

    // 쿼리방식 선택 권장 순서
//    1. 엔티티 DTO 변환
//    2. 필요하면 페치 조인 성능최적화(대부분 해결)
//    3. DTO로 직접 조회
//    4. 최후 JPA 네이티브 SQL or 스프링JDBC Template SQL 직접 사용
    //DTO로 변환해서 반환해

    /**
     * V1. 엔티티 직접 노출
     * - Hibernate5Module 모듈 등록, LAZY=null 처리
     * - 양방향 관계 문제 발생 -> @JsonIgnore
     * - 엔티티 직접호출 -> 좋지않음
     */
    @GetMapping("/api/v1/simple-orders")
    public List<Order> ordersV1() {
        // Order 가지고옴 -> Order MTO(fetch = LAZY = DB에서 가져오지 않음(가짜 프록시 멤버 객체 생성), 자바 객체가 아님
        // 그래서 지연로딩인 경우에는 JSON 라이브러리는 아무것도 하지않도록 hibernate 모듈 설치해야됨.
        List<Order> all = orderRepository.findAllByString(new OrderSearch());
        for (Order order : all) {
            order.getMember().getName(); // Lazy 강제 초기화
            order.getDelivery().getAddress(); // Lazy 강제 초기화
        }
        return all;
    }

    @GetMapping("/api/v2/simple-orders")
    public List<SimpleOrderDto> ordersV2() {
        List<Order> orders = orderRepository.findAll();
        List<SimpleOrderDto> result = orders.stream()
                .map(o -> new SimpleOrderDto(o))
                .collect(toList());

        return result;
    }

    /**
     * V3. 엔티티를 조회해서 DTO로 변환(fetch join 사용O)
     * - fetch join으로 쿼리 1번 호출
     * 참고: fetch join에 대한 자세한 내용은 JPA 기본편 참고(정말 중요함)
     *  N+1 문제 해결
     */
    @GetMapping("/api/v3/simple-orders")
    public List<SimpleOrderDto> ordersV3() {
        List<Order> orders = orderRepository.findAllWithMemberDelivery();
        List<SimpleOrderDto> result = orders.stream()
                .map(o -> new SimpleOrderDto(o))
                .collect(toList());
        return result;
    }

    //v4주석제거 후 실행해볼것
//    @GetMapping("/api/v4/simple-orders")
//    public List<OrderSimpleQueryDto> ordersV4() {
//        return orderSimpleQueryDto.findOrderDtos();
//    }


    @Data
    static class SimpleOrderDto {

        private Long orderId;
        private String name;
        private LocalDateTime orderDate; //주문시간
        private OrderStatus orderStatus;
        private Address address;

        public SimpleOrderDto(Order order) {
            orderId = order.getId();
            name = order.getMember().getName();
            orderDate = order.getOrderDate();
            orderStatus = order.getStatus();
            address = order.getDelivery().getAddress();
        }
    }

}
