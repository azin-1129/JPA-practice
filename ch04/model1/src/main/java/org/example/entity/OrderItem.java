package org.example.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name="ORDER_ITEM")
@Getter
@Setter
public class OrderItem {
    @Id
    @GeneratedValue
    @Column(name="ORDER_ITEM_ID")
    private Long id;

    @Column(name="ITEM_ID")
    private Long itemId; // FK

    @Column(name="ORDER_ID")
    private Long orderId; // FK

    private int orderPrice;
    private int count;
}
