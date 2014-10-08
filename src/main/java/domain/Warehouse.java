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
        inventory(new InStockSearchCriteria());
    }

    public void inventory(final Category category) {
        inventory(new InStockCategorySearchCriteria(category));
    }

    public void inventory(ItemSearchCriteria criteria) {
        for (Item item : items) {
            if (criteria.test(item)) {
                System.out.println(item.name());
            }
        }
    }

    private static class InStockSearchCriteria implements ItemSearchCriteria {
        @Override
        public boolean test(Item item) {
            return item.isInStock();
        }
    }

    private static class InStockCategorySearchCriteria implements ItemSearchCriteria {
        private final Category category;

        public InStockCategorySearchCriteria(Category category) {
            this.category = category;
        }

        @Override
        public boolean test(Item item) {
            return item.isInStock() && item.isOf(category);
        }
    }
}
