package mypack.model;

import java.util.List;

public class Order {
    private String id;
    private List<CartItem> item;
    private int userId;
    private String name;
    private String email;
    private String address;
    private String city;
    private String state;
    private Payment payment;
    private double total;

    // Constructor
    public Order(String id, List<CartItem> item, int userId, String name, String email, String address, String city, String state, Payment payment, double total) {
        this.id = id;
        this.item = item;
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.address = address;
        this.city = city;
        this.state = state;
        this.payment = payment;
        this.total = total;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<CartItem> getItem() {
        return item;
    }

    public void setItem(List<CartItem> item) {
        this.item = item;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
    
	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
    
    
    public double calculateTotal(List<CartItem> cartItems) {
        double total = 0.0;
        for (CartItem item : cartItems) {
            total += item.getSubtotal();
        }
        this.total = total;
        return total;
    }
}
