import java.util.Date;
import java.util.Scanner;
import java.io.PrintWriter;
/**
 * The shop item reservation class stores the details of the customer and the item which is being reserved by the client.
 *
 * @author (Miroslav Dermanski)
 * @version (16.03.23)
 */
public class ShopItemReservation
{
    // instance variables - replace the example below with your own
    private String reservationNo;
    private String itemID;
    private String customerID;
    private Date startDate;
    private int noOfDays;

    /**
     * Constructor for objects of class ShopItemReservation
     */
    public ShopItemReservation(String reservationNo, String itemID, String customerID, String startDate, int noOfDays)
    {
        this.reservationNo = reservationNo;
        this.itemID = itemID;
        this.customerID = customerID;
        DateUtil newDate = new DateUtil();
        if (newDate.isValidDateString(startDate))
        {
            this.startDate = newDate.convertStringToDate(startDate);
        }
        else {
            System.out.println("Please insert the date in the specified format(dd-MM-yyyy) ");
        } 
        this.noOfDays = noOfDays;
    }
    
    public ShopItemReservation()// Default-empty parameter constructor
    {
        this.reservationNo = "";
        this.itemID = "";
        this.customerID = "";
        this.startDate = null;
        this.noOfDays = 0;
    }
    
    /**
     * Accessor and mutator methods for the number of reservation
     */
    public String getReservationNo(){
        return reservationNo;
    }
    public void setReservationNo(String reservationNo){
        this.reservationNo = reservationNo;
    }
    /**
     * Accessor and mutator for the ID of an item
     */
    public String getItemID(){
        return itemID;
    }
    public void setItemID(String itemID){
        this.itemID = itemID;
    }
    /**
     * Accessor and mutator methods for the ID of a customer
     */
    public String getCustomerID(){
        return customerID;
    }
    public void setCustomerID(String customerID){
       this.customerID = customerID; 
    }
    /**
     * Accessor and mutator for the start date
     */
    public Date getStartDate(){
        return startDate;
    }
    public String getStringStartDate(){
        DateUtil uDate = new DateUtil();
        return uDate.convertDateToShortString(startDate);
    }
    public void setStartDate(String startDate) {
        DateUtil newDate = new DateUtil();
        if (newDate.isValidDateString(startDate))
        {
            this.startDate = newDate.convertStringToDate(startDate);
        }
        else {
            System.out.println("Please insert the date in the specified format(dd-MM-yyyy) ");
        }        
    }
    public void setStartDate(Date startDate){
        this.startDate = startDate;
    }
    /**
     * Accessor and mutator for the number of days
     */
    public int getNoOfDays(){
        return noOfDays;
    }
    public void setNoOfDays(int noOfDays){
        this.noOfDays = noOfDays;
    }
    
    /**
     * Print the details of the reservation, including the reservation ID, item ID, customer ID,
     * start date, and number of days.
     */
    public void printDetails() {
        System.out.println("Reservation ID: " + reservationNo + "; Item ID: " + itemID + "; Customer ID: " + customerID);
        System.out.print("Start date: " + getStringStartDate() + "; Number of days: " + noOfDays);
    }
    
    /**
     * Read the data for the reservation from the given Scanner object. Expects the input in the
     * following order-reservationNo, itemID, customerID, start date, and number of days.
     */
    public void readData(Scanner scanner){
        reservationNo = scanner.next();
        itemID = scanner.next();
        customerID = scanner.next();
        setStartDate(scanner.next());
        noOfDays = scanner.nextInt();
    }
    /**
     * Write the data for the reservation to the given PrintWriter object in the following format-
     * reservation No; itemID; customerID; Start date; noOfDays
     */
    public void writeData(PrintWriter writer) {
        String lineOfText = "Reservation No: " + reservationNo + "; Item ID: " + itemID + "; Customer ID: " + customerID + "; Start date: " + getStartDate() + "; No. of days: " + noOfDays;
        writer.println(lineOfText);
    }
    
    /**
     * Returns a String representation of the reservation, including the reservation ID, item ID and customer ID
     */
    public String toString(){
        return ("Reservation No: " + reservationNo + "; Item ID: " + itemID + "; Customer ID: " + customerID);
    }
}