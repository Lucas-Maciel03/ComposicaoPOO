package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Enter cliente data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next());

		Client client = new Client(name, email, birthDate);

		System.out.println("Enter Order Data:");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		Order order = new Order(new Date(), status, client);

		System.out.print("How many items to this order? ");
		int q = sc.nextInt();

		for (int i = 0; i < q; i++) {
			System.out.printf("Enter #%d item data:", i+1);
			System.out.println();
			System.out.print("Product Name: ");
			sc.nextLine();
			String pnome = sc.nextLine();
			System.out.print("Product price: ");
			double price = sc.nextDouble();
			Product product = new Product(pnome, price);
			System.out.print("Quantity: ");
			int qtd = sc.nextInt();
			OrderItem orderItem = new OrderItem(qtd, price, product);
			order.addItem(orderItem);

		} // fim for
		System.out.println();
		System.out.println("ORDER SUMMARY:");
		System.out.println(order.toString());
		System.out.println("lucas");
		sc.close();
	}// fim main

}