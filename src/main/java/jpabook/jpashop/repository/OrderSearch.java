package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderStatus;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.EntityManager;
import java.util.List;

@Getter @Setter
@RequiredArgsConstructor
public class OrderSearch {

//    private final EntityManager em;
//
//    public void save(Order order) { em.persist(order); }
//
//    public Order findOne(Long id) { return em.find(Order.class, id); }

    private String memberName; //회원 이름
    private OrderStatus orderStatus; //주문 상태[ORDER, CANCEL]
}
