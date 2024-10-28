package roy;

import java.util.ArrayList;

class Cart {
    ArrayList<Item> items;

    public Cart() {
        items = new ArrayList<>();
    }

    void addItem(Item item) {
        items.add(item);
        System.out.println(item.name + " added to cart.");
    }

    void removeItem(int itemId) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).id == itemId) {
                System.out.println(items.get(i).name + " removed from cart.");
                items.remove(i);
                return;
            }
        }
        System.out.println("Item not found in cart.");
    }

    void showItems() {
        if (items.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }
        System.out.println("Items in Cart:");
        for (Item item : items) {
            System.out.println(item.name + " - $" + item.price);
        }
    }

    double calculateTotal() {
        double total = 0;
        for (Item item : items) {
            total += item.price;
        }
        return total;
    }
}
