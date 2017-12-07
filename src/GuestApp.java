
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
public class GuestApp {

	public static void main(String[] args) throws SQLException {
		GuestApp mainApp = new GuestApp();
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
			break;
		case 8:
			Exit = true;
			System.out.println("Bye Bye!");
			break;

		}
	}

	private void addService() throws SQLException {
		int guestID = 1; // From Account
		System.out.println("Please Enter List ID");
		int service_id = Integer.parseInt(prompt());
		System.out.println("Please Enter Date in YYYY-MM-DD Format");
		String date = prompt();
		Service newService = new Service(service_id, guestID, date);
		serviceList.addService(newService);
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

	@SuppressWarnings("resource")
	private String prompt() {
		Scanner input = new Scanner(System.in);
		return input.nextLine();
	}

}