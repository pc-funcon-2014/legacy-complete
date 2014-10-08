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
        inventory(new ItemSearchCriteria() {
            @Override
            public boolean test(Item item) {
                return item.isInStock();
            }
        });
    }

    public void inventory(final Category category) {
        inventory(new ItemSearchCriteria() {
            @Override
            public boolean test(Item item) {
                return item.isInStock() && item.isOf(category);
            }
        });
    }

    public void inventory(ItemSearchCriteria criteria) {
        for (Item item : items) {
            if (criteria.test(item)) {
                System.out.println(item.name());
            }
        }
    }

}
