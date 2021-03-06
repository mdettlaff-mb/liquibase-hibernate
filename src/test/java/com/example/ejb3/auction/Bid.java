package com.example.ejb3.auction;

import javax.persistence.*;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("Y")
public class Bid extends Persistent {
    private AuctionItem item;
    private float amount;
    private Date datetime;
    private User bidder;

    @ManyToOne
    public AuctionItem getItem() {
        return item;
    }

    public void setItem(AuctionItem item) {
        this.item = item;
    }

    public float getAmount() {
        return amount;
    }

    @Column(nullable = false, name = "datetime")
    public Date getDatetime() {
        return datetime;
    }

    public void setAmount(float f) {
        amount = f;
    }

    public void setDatetime(Date date) {
        datetime = date;
    }

    @ManyToOne(optional = false)
    public User getBidder() {
        return bidder;
    }

    public void setBidder(User user) {
        bidder = user;
    }

    public String toString() {
        return bidder.getUserName() + " $" + amount;
    }

    @Transient
    public boolean isBuyNow() {
        return false;
    }

}
