package co.cleverly.cleverlybakes.service;

import co.cleverly.cleverlybakes.model.BakeryItems;
import co.cleverly.cleverlybakes.repo.BakeryItemsRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Random;

import static java.lang.Boolean.TRUE;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class BakeryItemsServiceImpl implements BakeryItemsService{

    private  final BakeryItemsRepo itemsRepo;
    @Override
    public BakeryItems create(BakeryItems item) {
        log.info("Saving New ITem", item.getItemName());
        item.setItemSampleImage(setImageUrl());
        return itemsRepo.save(item);
    }

    @Override
    public Collection<BakeryItems> list(int limit) {
        log.info("Fetching ALl Bakery ITems");
        return itemsRepo.findAll(PageRequest.of(0, limit)).toList();
    }

    @Override
    public BakeryItems get(Long itemId) {
        log.info("Get ITems by Id", itemId);
        return itemsRepo.findById(itemId).get();
    }

    @Override
    public BakeryItems updateItem(BakeryItems bakeryItem) {
        log.info("Get ITems by Id", bakeryItem.getItemName());
        return itemsRepo.save(bakeryItem);
    }

    @Override
    public Boolean deleteItem(Long itemId) {
        log.info("Deleting Server : {}", itemId);
        itemsRepo.deleteById(itemId);
        return TRUE;
    }

    private String setImageUrl() {
        String[] imageNames = { "item1.png", "item2.png", "item3.png", "item4.png" };
        return ServletUriComponentsBuilder.fromCurrentContextPath().path("/server/image/" + imageNames[new Random().nextInt(4)]).toUriString();
    }
}
