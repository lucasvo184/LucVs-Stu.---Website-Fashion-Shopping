package mypack.model;


public class Payment {
	private String orderId;
	private String name;
	private String num;
	private String month;
	private String year;
	private String cvv;
	
	public Payment(String orderId, String name, String num, String month, String year, String cvv) {
        this.orderId = orderId;
        this.name = name;
        this.num = num;
        this.month = month;
        this.year = year;
        this.cvv = cvv;
    }
	
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	
}
