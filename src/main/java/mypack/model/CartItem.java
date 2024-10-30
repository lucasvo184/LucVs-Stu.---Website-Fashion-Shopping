package mypack.model;

public class CartItem {
    private Product product;
    private int quantity;
    private String size;  

    public CartItem(Product product, int quantity, String size) {
        this.product = product;
        this.quantity = quantity;
        this.setSize(size);
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSubtotal() {
        return product.getPrice() * quantity;
    }

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
}

