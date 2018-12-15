package com;

import java.io.Serializable;

public class ListEntry implements Serializable {
    private String product;
    private boolean isBought;
    private float price;

    public ListEntry(String product) {
        this.product = product;
        isBought = false;
        price = -1;
    }

    public void buyIt(float price) {
        if (price >= 0) {
            this.price = price;
            isBought = true;
        } else {

        }
    }

    public String getProduct() {
        return product;
    }

    @Override
    public String toString() {
        return product + " | " + priceToString();
    }

    public String priceToString() {
        if (isBought) {
            return price + " zł";
        } else {
            return "Not Bought";
        }
    }
}
