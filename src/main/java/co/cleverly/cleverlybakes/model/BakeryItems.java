package co.cleverly.cleverlybakes.model;

import co.cleverly.cleverlybakes.enumiration.InStoreStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BakeryItems {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long itemId;

    @Column(unique = true)
    @NotEmpty(message = "Item Name cannot be Empty or NUll")
    private String itemName;

    private String itemDescription;

    private int numberProducedWeekly;

    private String itemSampleImage;

    private InStoreStatus inStoreStatus;
}
