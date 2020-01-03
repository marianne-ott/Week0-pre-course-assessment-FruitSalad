import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	// FLYTT I KLASSER?
	// Hvis man skriver inn ord med mellomrom så crasher programmet. (Generelt, hvordan endre så SCANNER leser alt?)
	// Om to ting koster det samme, kommer det bare opp en som billigst/dyrest

	static Scanner scanner = new Scanner(System.in);

	static ArrayList<String> itemList = new ArrayList<String>();
	static ArrayList<Double> priceList = new ArrayList<Double>();

	static int i = 0;
	static int t = 0;
	static int option;
	static double mostExpensivePrice;
	static String mostExpensiveItem;
	static boolean isEmpty = true;
	static double sum;


	public static void main(String[] args) {

		do {
			displayShoppingList();
			displayMenu();
			int option = getOption();

			// 1. ADD ITEM
			if (option == 1) {
				optionOne();
			}

			// 2. DELETE ITEM
			else if (option == 2) {
				optionTwo();
			}

			// 3. MOST EXPENSIVE ITEM
			else if (option == 3) {
				optionThree();
			}

			// 4. LEAST EXPENSIVE ITEM
			else if (option == 4) {
				optionFour();
			}

			// 5. SUM OF ALL ITEMS
			else if (option == 5) {
					optionFive();
			}

			else if (option == 6) {
				// EXIT PROGRAM
					System.out.println("\nExiting...");
				break;
			}

		} while (true);
	}



	// DISPLAY SHOPPING LIST
	static void displayShoppingList() {

		System.out.println("-----------------------------------------------");
		System.out.println("\n- FRUIT SALAD SHOPPING LIST -\n");

		if (itemList.isEmpty()) {
			System.out.println("(There are no items in your shopping list at the moment.)");
		}

		for (i = 0; i < itemList.size(); i++) {

			// TEMP LIST NUMBER REMOVE/DELETE
			if (itemList.isEmpty()) {
				System.out.println("(There are no items in your shopping list at the moment.)");
			}

			for (i = 0; i < itemList.size(); i++) {
				if (itemList.get(i) == null) {
					itemList.remove(i);
				}

				if (priceList.get(i) == 0) {
					priceList.remove(i);
				}
			}

			// DISPLAY ITEMS
			if (itemList.isEmpty()) {
				System.out.println("(There are no items in your shopping list at the moment.)");
			}

			for (i = 0; i < itemList.size(); i++) {

				System.out.print(" " + (i + 1) + ". " + itemList.get(i));
				System.out.println("  --  " + priceList.get(i) + " kr");
			}
		}
	}


	// DISPLAY MENU
	static void displayMenu () {

		System.out.println("\n-----------------------------------------------");
		System.out.println("- OPTIONS - \n");
		System.out.println("1: Add item");
		System.out.println("2: Remove item");
		System.out.println("3: Show MOST expensive item");
		System.out.println("4: Show LEAST expensive item");
		System.out.println("5: Show SUM of all items");
		System.out.println("6: Exit");
	}

	// GET OPTION
			static int getOption () {
		System.out.print("\nPlease select an option: ");
		option = scanner.nextInt();

		if (option == 1 || option == 2 || option == 3 || option == 4 || option == 5 || option == 6) {
			return option;
		}

		else {
			System.out.print("Sorry, " + option + " is not a valid option. Please try again... \n");
			return getOption();
		}
	}

	static void optionOne () {
		for (i = 0; i <= itemList.size(); i++) {

			System.out.print("Item to add to shopping list: ");
			String in = scanner.next().toUpperCase();
			itemList.add(in);

			System.out.print("Price in NOK: ");
			double in2 = scanner.nextDouble();
			priceList.add(in2);

			break;
		}
	}

	static void optionTwo () {
		System.out.print("Item to be removed from shopping list: ");
		String delete = scanner.next().toUpperCase();

		for (i = 0; i < itemList.size(); i++) {
			if (itemList.get(i) != null && itemList.get(i).equals(delete)) {
				itemList.set(i, null);
				priceList.set(i, 0.00);

				break;
			}
		}
	}

	static void optionThree () {
		if (itemList.isEmpty()) {
			System.out.println("(There are currently no items in your shopping list.)");
			displayMenu();
		}

		else {

			for (int i = 0; i < priceList.size(); i++) {
				if (priceList.get(i) > mostExpensivePrice) {
					mostExpensivePrice = priceList.get(i);
					mostExpensiveItem = itemList.get(i);
				}
			}

			System.out.println("\n\n ***** The MOST expensive item is " + mostExpensiveItem + ", which cost " + mostExpensivePrice + " kr.\n");
		}
	}

	static void optionFour() {
		if (itemList.isEmpty()) {
			System.out.println("(There are currently no items in your shopping list.)");
			displayMenu();
		}

		else {
			for (int i = 0; i < priceList.size(); i++) {

				if (priceList.get(i) < mostExpensivePrice && priceList.get(i) > 0) {
					mostExpensivePrice = priceList.get(i);
					mostExpensiveItem = itemList.get(i);
				}
			}

			System.out.println("\n\n ***** The LEAST expensive item is " + mostExpensiveItem + ", which cost " + mostExpensivePrice + " kr.\n");
		}
	}

	static void optionFive () {
		sum = 0;
		for (int i = 0; i < priceList.size(); i++) {
			sum = sum + priceList.get(i);
		}
		System.out.println("\n\n ***** The sum of all the items come to: " + sum + " kr.\n");
	}
}