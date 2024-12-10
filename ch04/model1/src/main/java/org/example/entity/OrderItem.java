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

    @ManyToOne
    @JoinColumn(name="ITEM_ID")
    private Item item; // FK

    @ManyToOne
    @JoinColumn(name="ORDER_ID")
    private Order order; // FK

    private int orderPrice;
    private int count;
}
