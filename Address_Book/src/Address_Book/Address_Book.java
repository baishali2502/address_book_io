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
		//---------------------------------------- UC-2 ---------------------------------------------
		
		/*
		 * @desc:This function adds a new contact to the address book after checking for duplicates
		 * 
		 * @params: the new contact to be added
		 * 
		 * @returns: void
		 */

	    void insert() {
	        contact_node newcontact = create();

	        if (!isDuplicate(newcontact)) {
	            head.add(newcontact);
	            System.out.println("New contact added\n");
	        } else {
	            System.out.println("Duplicate entry found. Contact not added.\n");
	        }
	    }
	  //---------------------------------------- UC-3 ---------------------------------------------
	    
		/*
		 * @desc:This function edits an already present contact
		 * 
		 * @params:firstname and lastname of already present contact
		 * 
		 * @returns:void
		 */
		boolean editContact(String first, String last) {
			boolean editted = false;
			Scanner s = new Scanner(System.in);
			// contact_node temp = head;
			for (contact_node temp : head) {
				if (temp.firstname.equals(first) && temp.lastname.equals(last)) {
					editted = true;
					System.out.println("Do you want to change firstname?");
					boolean changefirst = s.nextBoolean();
					if (changefirst) {
						System.out.print("Enter new firstname : ");
						temp.firstname = s.next();
					}

					System.out.println("Do you want to change lastname?");
					boolean changelast = s.nextBoolean();
					if (changelast) {
						System.out.print("Enter new lastname : ");
						temp.lastname = s.next();
					}

					System.out.print("Do you want to change email?");
					boolean changeemail = s.nextBoolean();
					if (changeemail) {
						System.out.print("Enter new email-id : ");
						temp.email = s.next();
					}

					System.out.print("Do you want to change address?");
					boolean changeaddress = s.nextBoolean();
					if (changeaddress) {
						System.out.print("Enter new address : ");
						temp.address = s.next();
					}

					System.out.print("Do you want to change city?");
					boolean changecity = s.nextBoolean();
					if (changecity) {
						System.out.print("Enter new city : ");
						temp.city = s.next();
					}

					System.out.print("Do you want to change state?");
					boolean changestate = s.nextBoolean();
					if (changestate) {
						System.out.print("Enter new state : ");
						temp.state = s.next();
					}

					System.out.print("Do you want to change zip?");
					boolean changezip = s.nextBoolean();
					if (changezip) {
						System.out.print("Enter new zip : ");
						temp.zip = s.nextInt();
					}

					System.out.print("Do you want to change phone?");
					boolean changephone = s.nextBoolean();
					if (changephone) {
						System.out.print("Enter new phone : ");
						temp.phone = s.nextLong();
					}

					return true;
				}

			}
			return editted;
		}

    
}