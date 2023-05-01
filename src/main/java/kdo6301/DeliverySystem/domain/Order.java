package kdo6301.DeliverySystem.domain;

import javax.persistence.*;

@Entity
public class Order {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    private Long id;

    private String state;

    @ManyToOne
    @JoinColumn(name="member_id")
    private Member member;

    public Order(){}

}