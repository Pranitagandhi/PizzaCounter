import java.util.HashMap;

public class cart {

	HashMap<String, Integer> CartItems;

	public cart() {
		CartItems = new HashMap<>();

	}

	public HashMap getCartItems() {
		return CartItems;
	}

	public void addToCart(String itemId, int price) {
		CartItems.put(itemId, price);
	}

}
