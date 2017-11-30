
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
			while (userInput < 1 || userInput > 5) {

				userInput = Integer.parseInt(prompt());

				if (userInput < 1 || userInput > 5) {
					System.out.println("Invalid Entry! Please Enter A Valid Option From The Menu: ");
				}
			}

		} catch (NumberFormatException e) {

			System.out.print("Invalid Entry! Please Enter A Valid Option From The Menu Below ");
		}
		switch (userInput) {
		case 1:
			add();
			break;
		case 2:
			search();
			break;
		case 3:
			update();
			break;
		case 4:
			delete();
			break;
		case 5:
			viewAll();
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

	private void add() {
		int guestID = 1; // From Account
		System.out.println("Please Enter Table Number");
		int tableNum = promptInt();
		System.out.println("Please Enter Number of Guests");
		int numGuests = promptInt();
		System.out.println("Please Enter Date in YYYY-MM-DD Format");
		String date = prompt();
		RestaurantReservationForm newReservation = new RestaurantReservationForm(guestID, tableNum, date, numGuests);
		resList.add(newReservation);
	}

	private void update() {
		int resId = 0;
		while (resId <= 0) {
			System.out.println("Please Enter Reservation ID: ");
			resId = promptInt();
			if (resId <= 0) {
				System.out.println("Reservation ID cannot be 0!");
			}
			int guestID = 1; // From Account
			System.out.println("Please Enter Table Number");
			int tableNum = promptInt();
			System.out.println("Please Enter Number of Guests");
			int numGuests = promptInt();
			System.out.println("Please Enter Date in YYYY-MM-DD Format");
			String date = prompt();
			RestaurantReservationForm newReservation = new RestaurantReservationForm(guestID, tableNum, date,
					numGuests);
			resList.updateReservation(resId, newReservation);
		}

	}

	private void delete() throws SQLException {
		int resId = 0;
		while (resId <= 0) {
			System.out.println("Please Enter Reservation ID: ");
			resId = promptInt();
			if (resId <= 0) {
				System.out.println("Reservation ID cannot be 0!");
			}

			resList.deleteReservation(resId);

		}
	}

	private void search() throws SQLException {
		int resId = 0;
		while (resId <= 0) {
			System.out.println("Please Enter Reservation ID: ");
			resId = promptInt();
			if (resId <= 0) {
				System.out.println("Reservation ID cannot be 0!");
			}
			resList.searchReservation(resId);
		}
	}

	private void viewAll() throws SQLException {
		List<RestaurantReservationForm> list = resList.viewResReservation();
		System.out.println("\n" + list.toString().replace("[", "").replace("]", ""));
	}

	@SuppressWarnings("resource")
	private String prompt() {
		Scanner input = new Scanner(System.in);
		return input.nextLine();
	}

	@SuppressWarnings("resource")
	private int promptInt() {
		Scanner input = new Scanner(System.in);
		return input.nextInt();
	}

}