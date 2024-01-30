package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Order;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.EntityManager;
import java.util.List;

@Getter @Setter
@RequiredArgsConstructor
public class OrderSearch {

    private final EntityManager em;

    public void save(Order order) { em.persist(order); }

    public Order findOne(Long id) { return em.find(Order.class, id); }

    public List<Order> findAll(OrderSearch orderSearch) {
        em.createQuery("select o from Order o join o.member m ", Order.class);
    }

}
