package arrayListchallenge1;
import java.util.*;
import java.util.ArrayList;

public class Mobilephone {
	private String myNumber;
	ArrayList<Contacts> mycontact;
	
	public Mobilephone(String myNumber) {
		this.myNumber=myNumber;
		this.mycontact=new ArrayList<Contacts>();//create empty list
		
	}
	public boolean addNewContact(Contacts contact) {
		if(findContact(contact.getName())>=0) {
			System.out.println("Contact already exists");
			return false;
		}
		mycontact.add(contact);
		return true;
	}
	
	private int findContact(Contacts contact){
		return this.mycontact.indexOf(contact);
	}
	private int findContact(String contactName) {
		for(int i=0;i<this.mycontact.size();i++) {
			Contacts contact=this.mycontact.get(i);
			if(contact.getName().contentEquals(contactName)) {
				return 1;
			}
		}return -1;
	}
	
	public boolean updateContact(Contacts oldContact,Contacts newContact) {
		int foundpostion=findContact(oldContact);
		if (foundpostion <0) {
			System.out.println(oldContact.getName()+" Not found");
			return false;
		}
		this.mycontact.set(foundpostion, newContact);
		System.out.println(oldContact.getName()+" was replaced with "+newContact.getName());
		return true;
	}
	public boolean removeContact(Contacts contact) {
		int position=findContact(contact);
		if(position<0) {
			System.out.println(contact.getName()+" was not found ");
			return false;
		}
		this.mycontact.remove(position);
		System.out.println(contact.getName()+" was deleted");
		return true;
	}
	public Contacts QueryContact(String name) {
        int position = findContact(name);
        if(position >=0) {
            return this.mycontact.get(position);
        }

        return null;
    }
	
	public String QueryContact(Contacts contact) {
		if(findContact(contact)>=0) {
			return contact.getName();
		}return null;
	}
	public void printContact() {
		System.out.println("Contact list :");
		for(int i=0;i<this.mycontact.size();i++) {
			System.out.println((i+1)+"."+this.mycontact.get(i)+" --> "
					+this.mycontact.get(i).getNumber());
		}
	}
}
