package jpabook.jpashop.service;

import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class OrderServiceTest {

    @Test
    void 상품주문() throws Exception {
        Member member = new Member();
        member.setName("회원1");
//        member.setAddress(new Address("서울", "강가", "123-123"));

        Item item = new Book();
    }

    @Test
    void 주문취소() throws Exception {
        
    }

    @Test
    void 상품주문_재고수량초과() throws Exception {

    }
    
}