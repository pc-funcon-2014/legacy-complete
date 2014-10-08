package domain;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("UnusedDeclaration")
public class Warehouse {

    final Set<Item> items;

    public Warehouse() {
        items = new HashSet<>();
    }

    public Warehouse add(Product product, int quantity) {
        items.add(new Item(product, quantity));
        return this;
    }

    public void inventory() {
        for (Item item : items) {
            if (item.isInStock()) {
                System.out.println(item.name());
            }
        }
    }
}
