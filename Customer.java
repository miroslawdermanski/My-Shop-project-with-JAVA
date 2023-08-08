import java.util.Scanner;
import java.io.PrintWriter;
/**
 * A customer class represents the profile of the clients who would like to book a shop item from the shop.
 *
 * @author (Miroslav Dermanski)
 * @version (09.03.23)
 */
public class Customer
{

    private String customerID;
    private String surname;
    private String firstName;
    private String otherInitials;
    private String title;

    /**
     * Constructor for objects of class Customer
     */
    public Customer(String surname, String firstName, String otherInitials, String title)
    {
        this.customerID = "unknown";
        this.surname = surname;
        this.firstName = firstName;
        this.otherInitials = otherInitials;
        this.title = title;
    }

    /**
     * A default/no parameter onstructor for objects of class Customer
     */
    public Customer()
    {
        this.customerID = "unknown";
        this.surname = "";
        this.firstName = "";
        this.otherInitials = "";
        this.title = "";
    }

    /**
     * Accessor method for an ID of a customer.
     */
    public String getCustomerID()
    {
        return customerID;
    }

    /**
     * Set the ID of a customer.
     */
    public void setCustomerID(String customerID) 
    {
        this.customerID = customerID;
    }

    /**
     * Accessor method for a surname of a customer.
     */
    public String getSurname()
    {
        return surname;
    }

    /**
     * Set the surname of a customer.
     */
    public void setSurname(String surname) 
    {
        this.surname = surname;
    }

    /**
     * Accessor method for a first name of a customer.
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * Set the first name of a customer.
     */
    public void setFirstName(String firstName) 
    {
        this.firstName = firstName;
    }

    /**
     * Accessor method for other initials of a customer.
     */
    public String getOtherInitials()
    {
        return otherInitials;
    }

    /**
     * Set other initials of a customer.
     */
    public void setOtherInitials(String otherInitials)
    {
        this.otherInitials = otherInitials;
    }

    /**
     * Accessor method for the title of a customer.
     */
    public String getTitile()
    {
        return title;
    }

    /**
     * Set the title of a customer.
     */
    public void setTitle(String title) 
    {
        this.title = title;
    }

    /**
     * Print all details of the customer.
     */
    public void printDetails()
    {
        System.out.println("----");
        System.out.println("Customer ID: " + customerID + "; ");
        System.out.println("Title: " + title + "; ");
        System.out.println("First Name: " + firstName + "; ");
        System.out.println("Other Initials: " + otherInitials + "; ");
        System.out.println("Surname: " + surname + "; ");
    }

    /**
     * Read values for each of the customer from Customer class.
     */
    public void readData(Scanner scanner)
    {
        customerID = scanner.next();
        surname = scanner.next();
        firstName = scanner.next();
        otherInitials = scanner.next();
        title = scanner.next();
    }
    
    /**
     * Write a customer data to a PrintWriter object in a comma-separated format.
     * The customer ID, surname, first name, other initials, and title are concatenated
     * into a single string and printed to the writer, followed by a newline character.
     */
    public void writeData(PrintWriter writer)
    {
        String allCustData = (customerID + ", " + surname + ", " + firstName + ", " + otherInitials + ", " + title);
        writer.println(allCustData);
        //writer.print(customerID + ", ");
        //writer.print(surname + ", ");
        //writer.print(firstName + ", ");
        //writer.print(otherInitials + ", ");
        //writer.println(title);        
    }
}
