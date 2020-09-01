package enumerationComposition;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.OrderItem;
import entities.Order_01;
import entities.Product;
import entities.enums.OrderStatus_01;

public class ECommerce {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date(DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next());
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		OrderStatus_01 status = OrderStatus_01.valueOf(sc.next());
		Order_01 order = new Order_01(new Date(), status, 
				new Client(name, email, birthDate));
		System.out.print("How many itens to this order? ");
		int quantity = sc.nextInt();
		for(int i=1; i <= quantity; i++) {
			System.out.printf("Enter %d item data:\n", i);
			System.out.print("Product name: ");
			sc.nextLine();
			String product = sc.nextLine();
			System.out.print("Product price: ");
			double price = sc.nextDouble();
			System.out.print("Quantity: ");
			int prodQuantity = sc.nextInt();
			order.addItem(new OrderItem(prodQuantity, price, new Product(product, price)));
		}
		
		System.out.println(order);
		
		sc.close();
		
	}

}
