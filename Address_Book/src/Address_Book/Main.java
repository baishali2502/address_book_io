package Address_Book;

import java.util.*;

public class Main {
	// main function
	public static void main(String[] args) 
	{
		// UC-6:
		
		List<AddressBook> addressbooks = new ArrayList<>(); // list of all address-books
		
		Scanner s = new Scanner(System.in);
		
		AddressBook book = new AddressBook(); // create a new address-book
		
		addressbooks.add(book); // adding an address-book to the list 
		
		System.out.println("Welcome to Address Book Program !!");
		System.out.println("\nMenu:-\n" 
		+ "1.)Add new contact\n" 
		+ "2.)Delete new contact\n" 
		+ "3.)Edit new contact\n"
		+ "4.)Display all contacts\n"
		+ "5.)No. of contacts\n" 
		+ "Choose : ");
		
		  int choice = s.nextInt();
		  
			while (choice != -1) 
			{
				if (choice == 1) {
					book.insert();
					System.out.println("New contact added\n");
					book.appendToFile();
				} else if (choice == 2) {
					System.out.print("Enter first name of contact:");
					String first = s.next();

					System.out.print("Enter last name of contact:");
					String last = s.next();
					contact_node c = book.delete(first, last);
					if (c == null)
						System.out.println("Contact not found");
					else
						System.out.println("Contact deleted\n");
				} else if (choice == 3) {
					System.out.print("Enter first name of contact:");
					String first = s.next();

					System.out.print("Enter last name of contact:");
					String last = s.next();

					boolean ans = book.editContact(first, last);
					System.out.println("Contact edited = " + ans);

				} else if (choice == 4) {
					book.print();
				} else {
					System.out.println("No. of contacts = " + book.head.size());
				}
				System.out.println("Enter choice : ");
				choice = s.nextInt();
			}
		 
		
		    book.loadFromFile();
	}

}
