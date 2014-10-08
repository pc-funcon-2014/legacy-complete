package com.funcon.domain;

public class Item implements Comparable<Item> {

    public final Product product;
    private final int quantity;

    public Item(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public boolean isInStock() {
        return quantity > 0;
    }

    public String name() {
        return product.name;
    }

    public int quantity() {
        return quantity;
    }

    public boolean isOf(Category category) {
        return product.category == category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        return product.equals(item.product);
    }

    @Override
    public int hashCode() {
        return product.hashCode();
    }

    @Override
    public String toString() {
        return "product=" + product +
                ", quantity=" + quantity;
    }

    @Override
    public int compareTo(Item another) {
        return Integer.compare(quantity, another.quantity);
    }
}