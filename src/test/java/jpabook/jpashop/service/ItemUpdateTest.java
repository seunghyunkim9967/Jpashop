package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.swing.text.html.parser.Entity;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
public class ItemUpdateTest {

    @Autowired
    EntityManager em;
    @Test
    public void updateTest() throws Exception {
        em.find(Book.class, 1L);

        book.setName("asdasd");
    }

}
