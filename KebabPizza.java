package com.company;

public class KebabPizza extends  Pizza {
    public KebabPizza() {
        super("Kebab Pizza", "White dough", "tomato sauce, pound meat, yogurt sauce" +
                ", bell pepper, onion, oregano, cumin,black pepper", 14.0);
    }

    @Override
    public void fetchSelectionFromUser(String x) {
        super.fetchSelectionFromUser(x);
    }

    @Override
    public void additionalIngredients() {
        super.additionalIngredients();
    }

    @Override
    public void print() {
        super.print();
    }

    @Override
    public double finalPrice() {
        return super.finalPrice();
    }
}
