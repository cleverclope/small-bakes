package co.cleverly.cleverlybakes.service;

import co.cleverly.cleverlybakes.model.BakeryItems;

import java.util.Collection;

public interface BakeryItemsService {
    BakeryItems create(BakeryItems bakeryItem);

    Collection <BakeryItems> list(int limit);

    BakeryItems get(Long itemId);

    BakeryItems updateItem(BakeryItems bakeryItem);

    Boolean deleteItem(Long itemId);
}
