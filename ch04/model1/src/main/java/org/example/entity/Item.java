package org.example.entity;

import javax.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
public class Item {
    @Id
    @GeneratedValue
    @Column(name="ITEM_ID")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;
}
