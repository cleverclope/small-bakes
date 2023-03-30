package co.cleverly.cleverlybakes.repo;

import co.cleverly.cleverlybakes.model.BakeryItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BakeryItemsRepo extends JpaRepository<BakeryItems, Long> {

    BakeryItems findByItemName(String itemName);
}
