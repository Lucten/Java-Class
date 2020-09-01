package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus_01;

public class Order_01 {
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private Date moment;
	private OrderStatus_01 status;
	
	private Client client;
	private List<OrderItem> orderItens = new ArrayList<>();
	
	public Order_01() {
	}

	public Order_01(Date moment, OrderStatus_01 status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus_01 getStatus() {
		return status;
	}

	public void setStatus(OrderStatus_01 status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getOrderItem() {
		return orderItens;
	}
	
	public void addItem(OrderItem item) {
		orderItens.add(item);
	}
	public void removeItem(OrderItem item) {
		orderItens.remove(item);
	}
	
	public Double total() {
		
		double aux = 0;
		for(OrderItem c: orderItens) {
			aux += c.subTotal();
		}
		return aux;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nORDER SUMMARY:\n");
		sb.append("Order moment: " + sdf.format(moment) + "\n");
		sb.append("Order status: " + status + "\n");
		sb.append("Client: " + client);
		sb.append("\nOrder items:\n");
		for(OrderItem v : orderItens) {
			sb.append(v);
		}
		sb.append("Total price: $" + total() + "\n");
		return sb.toString();
	}
	
}
