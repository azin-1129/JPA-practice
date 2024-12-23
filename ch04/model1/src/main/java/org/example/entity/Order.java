package org.example.entity;

import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="ORDERS")
@Getter
@Setter
public class Order{
    @Id
    @GeneratedValue
    @Column(name="ORDER_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name="MEMBER_ID")
    private Member member;

    @OneToMany(mappedBy="order")
    private List<OrderItem> orderItems=
            new ArrayList<OrderItem>();

    @OneToOne
    @JoinColumn(name="DELIVERY_ID")
    private Delivery delivery;

    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    public void setMember(Member member){
        if(this.member!=null){
            this.member.getOrders().remove(this);
        }
        this.member=member;
        member.getOrders().add(this);
    }

    public void addOrderItem(OrderItem orderItem){
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

    public void setDelivery(Delivery delivery){
        this.delivery=delivery;
        delivery.setOrder(this);
    }
}
