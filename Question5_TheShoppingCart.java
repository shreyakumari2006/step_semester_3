/**
 * Problem 5: The Shopping Cart
 * 
 * Scenario:
 * An online store's cart holds the prices of items you're about to buy.
 * 
 * Problem Statement:
 * Design a Cart class that stores item prices internally but only exposes the total
 * and item count — never direct access to the prices themselves.
 * 
 * Requirements:
 * - Store item prices in a private array (assume a fixed maximum number of items).
 * - Provide a method to add an item's price to the cart.
 * - Provide a read-only total (sum of all prices) and a read-only item count — computed on request, not stored separately.
 * - Give the cart a final cart ID, fixed when it's created.
 * 
 * Expected Behavior:
 * - Adding prices 250, 99, and 151 gives a total of 500 and a count of 3.
 * - There is no method that returns the array of individual prices.
 * - The total is always correct immediately after any item is added, with no extra step needed.
 * 
 * Sample Input/Output:
 * Cart cart = new Cart("CART-5", 20);
 * cart.addItem(250); cart.addItem(99); cart.addItem(151);
 * cart.getTotal() -> 500
 * cart.getItemCount() -> 3
 */

class Cart {
    private final String cartId;
    private final double[] prices;
    private int count;

    public Cart(String cartId, int maxCapacity) {
        if (cartId == null || cartId.trim().isEmpty()) {
            throw new IllegalArgumentException("Cart ID cannot be null or empty.");
        }
        if (maxCapacity <= 0) {
            throw new IllegalArgumentException("Max capacity must be greater than 0.");
        }
        this.cartId = cartId;
        this.prices = new double[maxCapacity];
        this.count = 0;
    }

    public void addItem(double price) {
        if (price < 0) {
            System.out.println("Item price cannot be negative.");
            return;
        }
        if (this.count >= this.prices.length) {
            System.out.println("Warning: Cart is full. Cannot add item with price: " + price);
            return;
        }
        this.prices[this.count] = price;
        this.count++;
        System.out.println("Added item price: " + (price == (long) price ? String.format("%d", (long) price) : price));
    }

    // Computed on request by summing the private array contents
    public double getTotal() {
        double total = 0.0;
        for (int i = 0; i < this.count; i++) {
            total += this.prices[i];
        }
        return total;
    }

    public int getItemCount() {
        return this.count;
    }

    public String getCartId() {
        return this.cartId;
    }
}

public class Question5_TheShoppingCart {
    public static void main(String[] args) {
        System.out.println("=== Problem 5: The Shopping Cart ===");
        Cart cart = new Cart("CART-5", 20);
        System.out.println("Cart created with ID: " + cart.getCartId());

        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        double total = cart.getTotal();
        System.out.println("cart.getTotal() -> " + (total == (long) total ? String.format("%d", (long) total) : total));
        System.out.println("cart.getItemCount() -> " + cart.getItemCount());
    }
}
