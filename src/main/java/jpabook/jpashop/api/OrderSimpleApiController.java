package jpabook.jpashop.api;

import jpabook.jpashop.domain.Order;
import jpabook.jpashop.repository.OrderRepository;
import jpabook.jpashop.repository.OrderSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    /**
     * V1. 엔티티 직접 노출
     * - Hibernate5Module 모듈 등록, LAZY=null 처리
     * - 양방향 관계 문제 발생 -> @JsonIgnore
     */
    @GetMapping("/api/v1/simple-orders")
    public List<Order> ordersV1() {
        // Order 가지고옴 -> Order MTO(fetch = LAZY = DB에서 가져오지 않음(가짜 프록시 멤버 객체 생성), 자바 객체가 아님
        // 그래서 지연로딩인 경우에는 JSON 라이브러리는 아무것도 하지않도록 hibernate 모듈 설치해야됨.
        List<Order> all = orderRepository.findAllByString(new OrderSearch());
        return all;
    }



}
