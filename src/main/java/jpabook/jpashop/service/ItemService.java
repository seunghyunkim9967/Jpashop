package jpabook.jpashop.service;

import jpabook.jpashop.repository.ItemRepository;
import jpabook.jpashop.domain.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional
    public void saveItem(Item item) {
        itemRepository.save(item);
    }
    @Transactional
    public void updateItem(Long itemId, String name, int price, int stockQuantity) {
    //public void updateItem(Long itemId, UpdateItemDto itemDto) {
        Item item = itemRepository.findOne(itemId);
        item.setName(name);
        item.setPrice(price);
        item.setStockQuantity(stockQuantity);
        //itemRepository : em.merge(item) 동일.
        //주의 : 변경 감지 기능 사용 시 원하는 속성만 선택 변경 가능하지만, 병합 사용하면 모든 속성이 변경됨.(병합 시 값이 없으면 Null)
    }
    public List<Item> findItems() {
        return itemRepository.findAll();
    }

    public Item findOne(Long itemId) {
        return itemRepository.findOne(itemId);
    }
}
