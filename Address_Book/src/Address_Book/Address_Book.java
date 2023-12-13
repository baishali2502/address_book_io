package Address_Book;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class AddressBook implements Serializable
{
	// empty linkedlist
	LinkedList<contact_node> head = new LinkedList<>();

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

	/*
	 * @desc:This function deletes an already existing contact
	 * 
	 * @params:firstname & lastname of already existing contact
	 * 
	 * @returns:the deleted contact
	 */
	contact_node delete(String firstname, String lastname) {
		contact_node deleted_node = null;
		// linked-list is empty
		if (head == null)
			return null;

		for (contact_node temp : head) {
			if (temp.firstname.equals(firstname) && temp.lastname.equals(lastname)) {
				head.remove(temp);
				return temp;
			}

		}

		return null;
	}

	/*
	 * @desc:This function displays all contacts in the address-book
	 * 
	 * @params:none
	 * 
	 * @returns:void
	 */
	void print() {
		int count = 1;
		for (contact_node temp : head) {
			System.out.println("\nContact - " + count + " :- ");
			System.out.println("\nFirstname :" + temp.firstname);
			System.out.println("Lastname :" + temp.lastname);
			System.out.println("Address :" + temp.address);
			System.out.println("City :" + temp.city);
			System.out.println("State :" + temp.state);
			System.out.println("Zip :" + temp.zip);
			System.out.println("Phone no. :" + temp.phone);
			System.out.println("Email :" + temp.email);

			count++;
		}
		System.out.println();
	}
//<----------------------------------------- UC-7 -------------------------------------------->
	/*
	 * To ensure that there are no duplicate entries of the same person in a
	 * particular address book, you can modify your AddressBook class by overriding
	 * the equals method in the contact_node class and using collection methods and
	 * Java Streams for duplicate checks.
	 */
	
	// @desc:Check for duplicate entry before adding a person to the address book
//	   @param:contact
//	   @returns:void
    public boolean isDuplicate(contact_node person) {
        return head.stream().anyMatch(existingPerson -> existingPerson.equals(person));
    }
  //<----------------------------------------- UC-8 -------------------------------------------->
  	/*
  	 * I've added two static methods: searchPersonsInCity and searchPersonsInState.
  	 * These methods take a list of AddressBook instances and a City or State as
  	 * input, and they use Java Streams to search for persons in the specified City
  	 * or State across multiple address books. The results are grouped by City or
  	 * State.
  	*/
      
      
  	// @desc:Search for persons in a specific City across multiple AddressBooks using Java Streams
//  	   @param:address books and cityname
//  	   @returns:person and the list of cities 
  	public static Map<String, List<contact_node>> searchPersonsInCity(List<AddressBook> addressBooks, String city) {
          return addressBooks.stream()
                  .flatMap(book -> book.head.stream())
                  .filter(contact -> contact.city.equalsIgnoreCase(city))
                  .collect(Collectors.groupingBy(contact -> contact.city));
      }

      // Search for persons in a specific State across multiple AddressBooks using Java Streams
//  	   @param:address books and cityname
//  	   @returns:person and the list of cities 
  	public static Map<String, List<contact_node>> searchPersonsInState(List<AddressBook> addressBooks, String state) {
          return addressBooks.stream()
                  .flatMap(book -> book.head.stream())
                  .filter(contact -> contact.state.equalsIgnoreCase(state))
                  .collect(Collectors.groupingBy(contact -> contact.state));
      }

  //<----------------------------------------- UC-9 -------------------------------------------->
  	/*
  	 * I've added two dictionaries: cityDictionary and stateDictionary. These
  	 * dictionaries are populated using Java Streams and the Collectors,groupingBy
  	 * collector, which groups contacts by City and State, respectively.
  	 * 
  	 * Additionally, I've added two methods: viewPersonsByCity and
  	 * viewPersonsByState, which return the dictionaries of City and Person as well
  	 * as State and Person.
  	 */	
  	
  	// Dictionary to maintain City and Person
      Map<String, List<contact_node>> cityDictionary = new HashMap<>();
      
      // Dictionary to maintain State and Person
      Map<String, List<contact_node>> stateDictionary = new HashMap<>();

      // @desc:View persons by City using Java Streams
//  	   @param:none
//  	   @returns:cityDictionary
      public Map<String, List<contact_node>> viewPersonsByCity() 
      {
          return head.stream()
                  .collect(Collectors.groupingBy(contact -> contact.city));
      }

      // View persons by State using Java Streams
//  	   @param:address books and state
//  	   @returns:stateDictionary 
      public Map<String, List<contact_node>> viewPersonsByState() 
      {
          return head.stream()
                  .collect(Collectors.groupingBy(contact -> contact.state));
      }

//       @desc:Initialize City and State Dictionaries
//  	   @param:none
//  	   @returns:none
      public void initializeDictionaries() {
          cityDictionary = head.stream().collect(Collectors.groupingBy(contact -> contact.city));
          stateDictionary = head.stream().collect(Collectors.groupingBy(contact -> contact.state));
      }

//  	<-----------------------------------------UC-10-------------------------------------------->
  	/*
  	 * I've added two methods: getCountByCity and getCountByState, which use Java
  	 * Streams to group contacts by City and State, respectively, and then count the
  	 * number of contacts for each group.
  	 */	
      
      
//       @desc:Get the count of contact persons by City using Java Streams
//  	   @param:none
//  	   @returns: group contacts by City
      public Map<String, Long> getCountByCity() {
          return head.stream()
                  .collect(Collectors.groupingBy(contact -> contact.city, Collectors.counting()));
      }

//       @desc:Get the count of contact persons by state using Java Streams
//  	   @param:none
//  	   @returns: group contacts by state
      public Map<String, Long> getCountByState() {
          return head.stream()
                  .collect(Collectors.groupingBy(contact -> contact.state, Collectors.counting()));
      }

//  	<-----------------------------------------UC-11-------------------------------------------->
  	
//       @desc:Sort the address book alphabetically by Person's name using Java Streams
//  	   @param:none
//  	   @returns:none
      
      public void sortByNameUsingStreams() 
      {
          head = head.stream()
                  .sorted(Comparator.comparing(contact -> (contact.firstname + contact.lastname).toLowerCase()))
                  .collect(Collectors.toCollection(LinkedList::new));
      }

//       @desc:Override toString method to finally print Person Entry in Console
//  	   @param:none
//  	   @returns:String
      
      @Override
      public String toString() 
      {
          return head.stream()
                  .map(contact_node::toString)
                  .collect(Collectors.joining("\n"));
      }
  	
//  	<-----------------------------------------UC-12-------------------------------------------->
  	
//       @desc:Sort the address book by City using Java Streams
//  	   @param:none
//  	   @returns:none
      public void sortByCityUsingStreams() {
          head = head.stream()
                  .sorted(Comparator.comparing(contact -> contact.city.toLowerCase()))
                  .collect(Collectors.toCollection(LinkedList::new));
      }

//       @desc:Sort the address book by State using Java Streams
//  	   @param:none
//  	   @returns:none
      public void sortByStateUsingStreams() {
          head = head.stream()
                  .sorted(Comparator.comparing(contact -> contact.state.toLowerCase()))
                  .collect(Collectors.toCollection(LinkedList::new));
      }

//      b  vv @desc:Sort the address book by Zip using Java Streams
//  	   @param:none
//  	   @returns:none
      public void sortByZipUsingStreams() {
          head = head.stream()
                  .sorted(Comparator.comparing(contact -> contact.zip))
                  .collect(Collectors.toCollection(LinkedList::new));
      }
//  	<-----------------------------------------UC-13-------------------------------------------->
      
  	/*
  	 * @desc:This function appends new data to existing data in file (if file
  	 *       exists). 
  	 *       If the file does not exist , then it creates a file and writes into
  	 *       it
  	 * 
  	 * @params:none
  	 * 
  	 * @returns:none
  	 */
  	 public void appendToFile() {
  	        try (BufferedWriter writer = new BufferedWriter(new FileWriter("addressbook1.txt", true))) {
  	            for (contact_node contact : head) 
  	            {
  	                // Write each contact's information as text
  	                writer.write("Firstname: " + contact.firstname);
  	                writer.newLine();
  	                writer.write("Lastname: " + contact.lastname);
  	                writer.newLine();
  	                writer.write("Email: " + contact.email);
  	                writer.newLine();
  	                writer.write("Address: " + contact.address);
  	                writer.newLine();
  	                writer.write("City: " + contact.city);
  	                writer.newLine();
  	                writer.write("State: " + contact.state);
  	                writer.newLine();
  	                writer.write("Zip: " + contact.zip);
  	                writer.newLine();
  	                writer.write("Phone: " + contact.phone);
  	                writer.newLine();
  	              
  	                writer.newLine(); // Separate contacts with an empty line
  	            }
  	            System.out.println("Address book appended successfully.");
  	        } catch (IOException e) {
  	            e.printStackTrace();
  	        }
  	    }
  	 /*
  		 * @desc:This function reads data from an existing data in file (if file
  		 *       exists). 
  		 *       If the file does not exist , then it shows FileNotFoundException
  		 * 
  		 * @params:none
  		 * 
  		 * @returns:none
  		 */
  	 public void loadFromFile() {
  		    try (BufferedReader reader = new BufferedReader(new FileReader("addressbook1.txt"))) {
  		        String line;
  		        contact_node contact = new contact_node();

  		        while ((line = reader.readLine()) != null) {
  		            String[] parts = line.split(":");
  		            if (parts.length == 2) {
  		                String fieldName = parts[0].trim();
  		                String fieldValue = parts[1].trim();

  		                switch (fieldName) {
  		                    case "Firstname":
  		                        contact.firstname = fieldValue;
  		                        break;
  		                    case "Lastname":
  		                        contact.lastname = fieldValue;
  		                        break;
  		                    case "Email":
  		                        contact.email = fieldValue;
  		                        break;
  		                    case "Address":
  		                        contact.address = fieldValue;
  		                        break;
  		                    case "City":
  		                        contact.city = fieldValue;
  		                        break;
  		                    case "State":
  		                        contact.state = fieldValue;
  		                        break;
  		                    case "Zip":
  		                        contact.zip = Long.parseLong(fieldValue);
  		                        break;
  		                    case "Phone":
  		                        contact.phone = Long.parseLong(fieldValue);
  		                        break;
  		                }
  		            } else if (line.trim().isEmpty()) {
  		                // Empty line, consider it as a separator between contacts
  		                printContactDetails(contact);
  		                contact = new contact_node(); // Start a new contact
  		            }
  		        }

  		        // Print the details of the last contact in case the file doesn't end with an empty line
  		        if(contact.firstname!=null)
  		            printContactDetails(contact);
  		        else
  		            System.out.println("Address book loaded successfully.");
  		        
  		    } catch (FileNotFoundException e) {
  		        System.out.println("No existing address book file found. Starting with an empty address book.");
  		    } catch (IOException e) {
  		        e.printStackTrace();
  		    }
  		}

  		private void printContactDetails(contact_node contact) {
  		    // Print the contact details to the console
  		    System.out.println("\nContact Details:");
  		    System.out.println("Firstname: " + contact.firstname);
  		    System.out.println("Lastname: " + contact.lastname);
  		    System.out.println("Address: " + contact.address);
  		    System.out.println("City: " + contact.city);
  		    System.out.println("State: " + contact.state);
  		    System.out.println("Zip: " + contact.zip);
  		    System.out.println("Phone: " + contact.phone);
  		    System.out.println("Email: " + contact.email);
  		}

    
}