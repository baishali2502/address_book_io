package Address_Book;

import java.io.Serializable;
import java.util.Objects;

//@desc:Conatct node contains all info related to a contact like name,address, phoneno,email etc
public class contact_node implements Serializable
{
	String firstname;
	String lastname;
	long phone;
	String email;
	String address;
	String city;
	String state;
	long zip;
	
	
	contact_node next;
	
	contact_node(String firstname, String lastname, long phone,String email,
			     String address, String city, String state, long zip) 
	{
		this.firstname = firstname;
		this.lastname = lastname;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		
		this.next = null;
	}
	contact_node()
	{
		next = null;
	}
	// Override equals method to check for duplicates based on person's name
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        contact_node other = (contact_node) obj;
        return Objects.equals(firstname, other.firstname) && Objects.equals(lastname, other.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname);
    }

}
