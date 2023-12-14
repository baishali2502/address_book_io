package Address_Book;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class AddressBook implements Serializable
{
	// Maintains a list of contacts in the address-book
	LinkedList<contact_node> head = new LinkedList<>();
	
	//---------------------------------------- UC-1 ---------------------------------------------

		/*
		 * @desc:This function creates a new contact
		 * 
		 * @returns:The new contact created
		 * 
		 * @params:none
		 */
		contact_node create() {
			Scanner s = new Scanner(System.in);

			System.out.print("Enter first-name : ");
			String firstname = s.nextLine();
			System.out.print("Enter last-name : ");
			String lastname = s.nextLine();
			System.out.println("Enter email : ");
			String email = s.nextLine();
			System.out.print("Enter address : ");
			String address = s.nextLine();
			System.out.print("Enter city : ");
			String city = s.nextLine();
			System.out.print("Enter state : ");
			String state = s.nextLine();
			System.out.print("Enter zip : ");
			long zip = s.nextInt();
			System.out.print("Enter phone-no. : ");
			long phone = s.nextLong();

			contact_node c = new contact_node(firstname, lastname, phone, email, address, city, state, zip);

			return c;
		}

    
}