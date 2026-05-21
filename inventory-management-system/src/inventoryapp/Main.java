package inventoryapp;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// Initialize scanner and variables
				Scanner scnr = new Scanner(System.in);
				int choice = 0;
				ArrayList<Product> inventory = new ArrayList<Product>();
				
				// Calls method to print the menu for user display and input
				printMenu();
				while(!scnr.hasNextInt()) {
					System.out.println("Please enter a number 1-5: ");
					scnr.next();
				}
				choice = scnr.nextInt();
				scnr.nextLine();
				
				// Implemented a while loop and switch structure in order to check correct user input for response
				while (choice != 5) {
					switch (choice) {
					case 1: {

						// try catch statement within a switch case for exception handling of user
						// inputs
						try {

							System.out.print("Enter the product ID: ");
							String id = scnr.nextLine();
							if (id.isEmpty()) {

								throw new IllegalArgumentException();

							}

							System.out.print("Enter the product name: ");
							String name = scnr.nextLine();

							if (name.isEmpty()) {

								throw new IllegalArgumentException();

							}

							System.out.print("Enter the product price: ");
							double price = Double.parseDouble(scnr.nextLine());

							System.out.print("Enter the product quantity: ");
							int quantity = Integer.parseInt(scnr.nextLine());

							// Creates a new product and stores it within the inventory ArrayList
							Product p = new Product (id, name, price, quantity);
							inventory.add(p);

							System.out.println("\n\nYour entries have been recorded!");

						} catch (IllegalArgumentException e) {
							System.out.println(
									"\nPlease enter the correct values in your response. You are being returned to the menu.");

						}
					}

						break;

					case 2:
						// Implemented product removal from ArrayList inventory based on user input ID
						// If no ID is found then the user will receive a display message saying that there was no product with the entered ID found
						System.out.print("Enter the product ID to remove: ");
						String removeId = scnr.nextLine();
						boolean found = false;
						for(int i = 0; i < inventory.size(); i++){
							if(inventory.get(i).getId().equalsIgnoreCase(removeId.trim())) {
								inventory.remove(i);
								found = true;
								break;
							}
						}
						if(found) {
							System.out.println("Product removal successful. Press Enter to return to the menu.");
						} else {
							System.out.printf("Product with ID %s not found.%n",removeId);
							System.out.println("Press Enter to return to the menu.");
						}
							scnr.nextLine();
						
						
						break;	
					case 3:
						// Determines if the inventory ArrayList is empty, if so then it displays a prompt to the user.
						// If inventory is not empty, it then displays the products in the inventory to the user. 
						if (inventory.isEmpty()) {
							System.out.println("No products currently in inventory. Please press enter to return to the menu.");
							scnr.nextLine();
						} else {
							System.out.println("ID:        Name:           Price:           Quantity:");
							System.out.println("----------------------------------------------------");
							for(Product products: inventory) {
								System.out.printf("%-10s %-15s $%-15.2f %-8d\n", products.getId(),products.getName(),products.getPrice(),products.getQuantity());
					
							}
							System.out.println("\nOnce done viewing, please press enter to return to the menu.");
							scnr.nextLine();
						}
						
						break;
					case 4:
						// User Updates a product of their choice
						// If the user input ID update matches the existing product in inventory ArrayList, then product updates with new user input
						System.out.print("Please enter the ID of the product you would like to update: ");
						String updateId = scnr.nextLine();
						
						boolean updateFound = false;
						
						for(Product products: inventory) {
							System.out.printf("%-10s %-15s $%-15.2f %-8d\n", products.getId(),products.getName(),products.getPrice(),products.getQuantity());
								if(products.getId().equalsIgnoreCase(updateId)) {
									System.out.print("Enter the new product ID: ");
									String idUpdate = scnr.nextLine();
									
									System.out.print("Enter the new product name: ");
									String nameUpdate = scnr.nextLine();
									
									System.out.print("Enter the new product price: ");
									double priceUpdate = scnr.nextDouble();
									scnr.nextLine();
						
									System.out.print("Enter the new product quantity: ");
									int quantityUpdate = scnr.nextInt();
									scnr.nextLine();
									
									products.setId(idUpdate);
									products.setName(nameUpdate);
									products.setPrice(priceUpdate);
									products.setQuantity(quantityUpdate);
									
									updateFound = true;
									System.out.println("\nProduct has been successfully updated. Please press enter to return to the menu.");
									scnr.nextLine();
									break;
								}
							}
						if(updateFound != true) {
							System.out.printf("Product ID %s was not found.%n", updateId);
							System.out.println("\nPlease press enter to return to the menu.");
							scnr.nextLine();
							break;
						}
						
					default:
						System.out.println("Please enter a valid option");
					
						
					}
					
					// Calls the print menu method again 
					printMenu();
					while(!scnr.hasNextInt()) {
						System.out.println("Please enter a number 1-5: ");
						scnr.next();
					}
					choice = scnr.nextInt();
					scnr.nextLine();
				}
				// Once the user exits the program, there will be a goodbye message and the 
				// scanner will be closed to prevent resource leaks
				System.out.println("Thank you for using Inventory Manager!");
				scnr.close();
			}
			
			// Print menu method is created for user display
			public static void printMenu() {
				// Header
				System.out.println("\n------ Inventory Manager ------\n");
				
				// Menu text options for user
				System.out.println("Please select one of the following:\n"
						+ "1) Add Product\n"
						+ "2) Remove product\n"
						+ "3) View products\n"
						+ "4) Update product\n"
						+ "5) Exit manager\n");
				
			}
		
		
		
	}
