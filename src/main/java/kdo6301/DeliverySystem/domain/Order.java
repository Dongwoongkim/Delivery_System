package kdo6301.DeliverySystem.domain;

import javax.persistence.*;

@Entity
public class Order {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private String state;

    @ManyToOne
    @JoinColumn(name="member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name="item_id")
    private Item item;

    public Order(){}

    public Order(String state, Member member, Item item) {
        this.state = state;
        this.member = member;
        this.item = item;
    }
}