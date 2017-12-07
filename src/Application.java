
/** 
 *@author Muzakkir
*/
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * This class allows user to interact with the program. Along with the main
 * method it contains methods such as print menu, prompt user to enter input
 * etc.
 */
public class Application {

	public static void main(String[] args) throws SQLException {
		Application mainApp = new Application();
		mainApp.runApp();
	}

	private boolean Exit = false;
	RestaurantResList resList = new RestaurantResList();
	ServiceList serviceList = new ServiceList();

	public void runApp() throws SQLException {
		while (!Exit) {
			printServiceMenu();
			processServiceMenuInput();
		}
	}

	public void printServiceMenu() {
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("\nHello! Please Enter One of The following Options From The Menu: ");
		System.out.println("1) Room Service");
		System.out.println("2) Concierge Service");
		System.out.println("3) Airport Shuttle");
		System.out.println("4) Dining Package");
		System.out.println("5) Beverage Package");
		System.out.println("6) Luandry Package");
		System.out.println("7) Restaurant Reservation");
		System.out.println("8) Exit");
	}

	public void printRestaurantMenu() {
		System.out.println("\nHello! Please Enter One of The following Options From The Menu: ");
		System.out.println("1) Add a New Restaurant Reservation");
		System.out.println("2) Search a Restaurant Reservation by Reservation ID");
		System.out.println("3) Update a Restaurant Reservation by Reservation ID");
		System.out.println("4) Delete a Restaurant Reservation by Reservation ID");
		System.out.println("5) View All Restaurant Reservations");
		System.out.println("6) Exit");
	}

	/**
	 * Processes the option chosen by user.
	 * 
	 * @throws SQLException
	 */
	private void processRestaurantInput() throws SQLException {
		int userInput = 0;

		try {
			while (userInput < 1 || userInput > 6) {

				userInput = Integer.parseInt(prompt());

				if (userInput < 1 || userInput > 6) {
					System.out.println("Invalid Entry! Please Enter A Valid Option From The Menu: ");
				}
			}

		} catch (NumberFormatException e) {

			System.out.print("Invalid Entry! Please Enter A Valid Option From The Menu Below ");
		}
		switch (userInput) {
		case 1:
			addRestaurant();
			break;
		case 2:
			searchRestaurant();
			break;
		case 3:
			updateRestaurant();
			break;
		case 4:
			deleteRestaurant();
			break;
		case 5:
			viewAllRestaurant();
			break;
		case 6:
			Exit = true;
			System.out.println("Bye Bye!");
			break;

		}
	}

	private void processServiceMenuInput() throws SQLException {
		int userInput = 0;

		try {
			while (userInput < 1 || userInput > 8) {

				userInput = Integer.parseInt(prompt());

				if (userInput < 1 || userInput > 8) {
					System.out.println("Invalid Entry! Please Enter A Valid Option From The Menu: ");
				}
			}

		} catch (NumberFormatException e) {

			System.out.print("Invalid Entry! Please Enter A Valid Option From The Menu Below ");
		}
		switch (userInput) {
		case 1:
			deleteService();
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		case 7:
			printRestaurantMenu();
			processRestaurantInput();
			break;
		case 8:
			Exit = true;
			System.out.println("Bye Bye!");
			break;

		}
	}

	private void requestService() throws SQLException {
		int guestID = 1; // From Account
		System.out.println("Please Enter List ID");
		int service_id = Integer.parseInt(prompt());
		System.out.println("Please Enter Date in YYYY-MM-DD Format");
		String date = prompt();
		Service newService = new Service(service_id, guestID, date);
		serviceList.addService(newService);
	}

	private void searchService() throws SQLException {
		int listID = 0;
		while (listID <= 0) {
			System.out.println("Please Enter List ID: ");
			listID = Integer.parseInt(prompt());
			if (listID <= 0) {
				System.out.println("Reservation ID cannot be 0!");
			}
			serviceList.searchService(listID);
		}
	}
	
	private void deleteService() throws SQLException {
		int listID = 0;
		while (listID <= 0) {
			System.out.println("Please Enter List ID: ");
			listID = Integer.parseInt(prompt());
			if (listID <= 0) {
				System.out.println("Reservation ID cannot be 0!");
			}
			serviceList.deleteService(listID);
		}
	}

	private void addRestaurant() {
		int guestID = 1; // From Account
		System.out.println("Please Enter Table Number");
		int tableNum = Integer.parseInt(prompt());
		System.out.println("Please Enter Number of Guests");
		int numGuests = Integer.parseInt(prompt());
		System.out.println("Please Enter Date in YYYY-MM-DD Format");
		String date = prompt();
		RestaurantReservationForm newReservation = new RestaurantReservationForm(guestID, tableNum, date, numGuests);
		resList.add(newReservation);
	}

	private void updateRestaurant() {
		int resId = 0;
		while (resId <= 0) {
			System.out.println("Please Enter Reservation ID: ");
			resId = Integer.parseInt(prompt());
			if (resId <= 0) {
				System.out.println("Reservation ID cannot be 0!");
			}
			int guestID = 1; // From Account
			System.out.println("Please Enter Table Number");
			int tableNum = Integer.parseInt(prompt());
			System.out.println("Please Enter Number of Guests");
			int numGuests = Integer.parseInt(prompt());
			System.out.println("Please Enter Date in YYYY-MM-DD Format");
			String date = prompt();
			RestaurantReservationForm newReservation = new RestaurantReservationForm(guestID, tableNum, date,
					numGuests);
			resList.updateReservation(resId, newReservation);
		}

	}

	private void deleteRestaurant() throws SQLException {
		int resId = 0;
		while (resId <= 0) {
			System.out.println("Please Enter Reservation ID: ");
			resId = Integer.parseInt(prompt());
			if (resId <= 0) {
				System.out.println("Reservation ID cannot be 0!");
			}

			resList.deleteReservation(resId);

		}
	}

	private void searchRestaurant() throws SQLException {
		int resId = 0;
		while (resId <= 0) {
			System.out.println("Please Enter Reservation ID: ");
			resId = Integer.parseInt(prompt());
			if (resId <= 0) {
				System.out.println("Reservation ID cannot be 0!");
			}
			resList.searchReservation(resId);
		}
	}

	private void viewAllRestaurant() throws SQLException {
		List<RestaurantReservationForm> list = resList.viewResReservation();
		System.out.println("\n" + list.toString().replace("[", "").replace("]", ""));
	}

	@SuppressWarnings("resource")
	private String prompt() {
		Scanner input = new Scanner(System.in);
		return input.nextLine();
	}

}