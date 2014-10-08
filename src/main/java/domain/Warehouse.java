package domain;

import java.util.Collection;
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

    public void products(final ProductSearchCriteria criteria) {
        Collection<Product> products = new HashSet<>();
        for (Item item : items) {
            final Product product = item.product;
            if (criteria.test(product)) {
                System.out.println(product.name);
            }
        }
    }

    public void products(final String name) {
        products(new ProductSearchCriteria() {
            @Override
            public boolean test(Product product) {
                return product.name.equals(name);
            }
        });
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
