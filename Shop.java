//import java.util.ArrayList;
import java.awt.*;
//import java.util.Scanner;
import java.io.*;
//import java.util.Random;
//import java.util.HashSet;
import java.util.List;
import java.util.*;
import java.util.Date;
/**
 * The shop class represents the shop which store the whole functionality of the project.
 * From the Shop class a customer can make reservation for a particular item and then delete it.
 * A list of the items, customers and reservations can be made fromthis class as well as reading those files.
 */
public class Shop
{
    private List<ShopItem> itemsList;
    private List<Customer> customerList;
    //private ArrayList<ShopItem> itemsList;
    //private ArrayList<Customer> customerList;
    private Random randomGenerator;
    private HashSet<String> existingIDs;
    private Map<String, ShopItem> itemsMap;
    private Map<String, Customer> customerMap;
    private Map<String, ShopItemReservation> itemReservationMap; 
    private Diary diary;
    /**
     * Constructor for objects of class Shop
     */
    public Shop()
    {
        //itemsList = new ArrayList<ShopItem>();
        //customerList = new ArrayList<Customer>();       
        randomGenerator = new Random();
        existingIDs = new HashSet<String>();
        itemsMap = new HashMap<String, ShopItem>();
        customerMap = new HashMap<String, Customer>();
        itemReservationMap = new HashMap<String, ShopItemReservation>();
        diary = new Diary();
    }

    /**
     * Add a new item to the item list.
     */
    public void storeItem(ShopItem shopItem)
    {
        //itemsList.add(shopItem);          
        String iC = shopItem.getItemCode(); 
        if (!iC.isEmpty() && iC != null) 
        {
            itemsMap.put(iC, shopItem);
        }
    }

    /**
     * Remove an item from the item list by its itemCode.
     */
    public void removeItem(String itemCode) {
        if (itemsMap.containsKey(itemCode)) {
            itemsMap.remove(itemCode);
        }else {
            System.out.println("The item with code: " + itemCode + " was not found in the collection!");       
        }
        //for (int i = 0; i < itemsList.size(); i++) {
        //    if (itemsList.get(i).getItemCode().equals(itemCode)) {
        //        itemsList.remove(i);
        //        break;
    }

    /**
     * Add a new customer to the customer list and assign it a random ID if customerID is unknown.
     */
    public void storeCustomer(Customer customer) 
    {
        if (customer.getCustomerID().equals("unknown") || customer.getCustomerID().isEmpty()) {
            //String customerID = generateCustomerID("AB-", 6);
            //customer.setCustomerID(customerID);
            String customerID = customer.getFirstName().substring(0,1) + customer.getSurname().substring(0,1) + "-";
            customer.setCustomerID(generateCustomerID(customerID, 6));
        }
        customerMap.put(customer.getCustomerID(), customer);
        //customerList.add(customer);
    }

    /**
     * Remove a customer from the customer list by their customerID.
     */
    public void removeCustomer(String customerID) {
        if (customerMap.containsKey(customerID)) {
            customerMap.remove(customerID);
        } else {
            System.out.println("Customer with customer ID: " + customerID + " was not found in the collection!");
        }
        //for (int i = 0; i < customerList.size(); i++) {
        //    if (customerList.get(i).getCustomerID().equals(customerID)) {
        //        customerList.remove(i);
        //        break;
    }

    /**
     * Add a reservation to the reservation map and add it to a diary object.
     */
    public void storeItemReservation(ShopItemReservation sIres)
    {
        String reservation = sIres.getReservationNo();
        if (reservation !=null && !reservation.isEmpty()) {
            itemReservationMap.put(reservation, sIres);
            diary.addReservation(sIres);
        }
        else
        {
            System.out.println("");
        }
    }

    /**
     * Get all information of an item by looking for its CODE
     */
    public ShopItem getItem(String itemCode)
    {
        if (itemsMap.get(itemCode) == null)
        {
            return null;
        }
        else
        {
            return itemsMap.get(itemCode);
        }
    }

    /**
     * Get all information of a customer by looking for their ID
     */
    public Customer getCustomer(String custID)
    {
        if (customerMap.get(custID) == null)
        {
            return null;
        }
        else
        {
            return customerMap.get(custID);
        }
    }

    /**
     * Get all information for a reservation by looking for its reservation number.
     */

    public ShopItemReservation getShopItemReservation(String sIr)
    {
        if (itemReservationMap.get(sIr) == null) {
            return null;
        }
        else
        {
            return itemReservationMap.get(sIr);
        }
    }

    /**
     * Display all details of all items from the item list.
     */
    public void printAllItems()
    {
        System.out.println("Displaying details of all items from the item list...");
        System.out.println();
        //for (ShopItem shopItem : itemsList)
        for (ShopItem shopItem : itemsMap.values())
        {
            shopItem.printDetails();
        }
        System.out.println();
        System.out.println("----End of listing----");
    }

    /**
     * Display all details of all customers from the customer list.
     */
    public void printAllCustomers() 
    {
        System.out.println("Displaying details of all customers from the customer list...");
        System.out.println();
        //for (Customer customer : customerList) 
        for (Customer customer : customerMap.values())
        {
            customer.printDetails();
        }
        System.out.println();
        System.out.println("----End of listing----");
    }

    /**
     *  Read in data from the data file customer_data.txt
     */
    public void readCustomerData()
    {
        Frame aFrame = null;
        FileDialog fileBox = new FileDialog(aFrame, "Open", FileDialog.LOAD);
        fileBox.setVisible(true);
        fileBox.setDirectory("/Users/miroslavdermanski/Documents");
        String fileName = fileBox.getFile();
        //print a message if the user closes the file box.
        if (fileName == null) {
            System.out.println("File selection cancelled.");
            return;
        }
        File file = new File(fileName);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String lineOfText = scanner.nextLine().trim();
                if (lineOfText.isEmpty() || lineOfText.startsWith("//")) {
                    continue;
                }
                try (Scanner scanner2 = new Scanner(lineOfText).useDelimiter("\\s*,\\s*")) {
                    Customer customer = new Customer();
                    customer.readData(scanner2);
                    storeCustomer(customer);
                } catch (Exception e) {
                    System.out.println("An error occurred on line: " + lineOfText);
                }
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe.getMessage());
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    /**
     * Write data from customerList to a text file.
     */
    public void writeCustomerData()
    {
        Frame aFrame = null;
        FileDialog fileBox = new FileDialog(aFrame, "Save", FileDialog.SAVE);
        fileBox.setVisible(true);        
        String fileName = fileBox.getFile();
        // print a message if the user closes the file box.
        if (fileName == null) {
            System.out.println("File box was closed.");
            return;
        }
        File file = new File(fileName);

        try (PrintWriter writer = new PrintWriter(file)) {
            //for (Customer customer : customerList) {
            for (Customer customer : customerMap.values()) {
                customer.writeData(writer);
            }
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    /**
     * Generate a custom ID made of characters and digits and assign it to customerID field.
     */
    public String generateCustomerID(String prefix, int digits)
    {
        String custID = prefix;
        for (int i = 0; i < digits; i++)
        {
            int ranDig = randomGenerator.nextInt(10);
            custID = custID + ranDig;
        }
        //an if statements ensures the custID is always unique as we store existing IDs in a HashSet
        if (existingIDs.contains(custID))
        {
            return generateCustomerID(prefix, digits);
        }
        else {
            existingIDs.add(custID);
            return custID;
        }
    }

    /**
     * Generate a reservation number consisting of 6 digits that start with zeros.
     */
    public String generateReservationNo(){
        int lastRes = itemReservationMap.size();
        lastRes ++;
        String lastResString = lastRes + "";
        int diff = 6 - lastResString.length();
        for (int i = 0; i < diff; i++) {
            lastResString = "0" + lastResString;
        }
        return lastResString;
    }

    /**
     * Reserve an item by passing 4 arguments as parameters- customerID, itemID, startDate and noOfDays
     * The code uses the method daysBetween from DateUtil class to compare todays date and
     * the start date passed as parameter which ensures past dates are not accepted as an argument.
     */
    public boolean makeItemReservation(String customerID, String itemID, String startDate, int noOfDays) {        
        DateUtil dateChecker = new DateUtil();
        Date today = new Date();
        Date start = dateChecker.convertStringToDate(startDate);
        if (getCustomer(customerID) != null && getItem(itemID) != null && dateChecker.isValidDateString(startDate) && noOfDays > 0 && dateChecker.daysBetween(today, start) >= -1) {
            for (int day = 0; day < noOfDays; day++){
                ShopItemReservation[] reserveList = diary.getReservations(start);
                if (reserveList != null) {
                    int position = 0;
                    int size = reserveList.length;
                    while(position < size) {
                        ShopItemReservation sIreservation = reserveList[position];
                        String reserveItemID = sIreservation.getItemID();
                        if (reserveItemID.equalsIgnoreCase(itemID)) {
                            System.out.println("The item is already reserved, try another item or date.");
                            return false;
                        }
                        position++;
                    }
                }
                start = dateChecker.incrementDate(start, 1);
            }
            String genNum = generateReservationNo();
            ShopItemReservation sIReservation = new ShopItemReservation(genNum, itemID, customerID, startDate, noOfDays);
            storeItemReservation(sIReservation);
            return true;
        } 
        else
        {
            System.out.println("The customer with ID: " + customerID + " and the item with ID: " + itemID + " are not found.");
            System.out.println("Double check the details and try again.");
            return false;
        }
    }

    /**
     * Display the details of all reservations
     */
    public void printItemReservations() {
        for (ShopItemReservation shopItemReservation : itemReservationMap.values()) {
            shopItemReservation.printDetails();
            System.out.println("");
        }       
    }

    /**
     * Create a text file with all reservations stored in the reservation map.
     */
    public void writeItemReservationData() {
        Frame aFrame = null;
        FileDialog fileBox = new FileDialog(aFrame, "Save", FileDialog.SAVE);
        fileBox.setVisible(true);
        String fileName = fileBox.getFile();
        // print a message if the user closes the file box.
        if (fileName == null) {
            System.out.println("File box was closed.");
            return;
        }
        File file = new File(fileName);

        try (PrintWriter writer = new PrintWriter(file)) {
            for (ShopItemReservation sIReservation : itemReservationMap.values()) {
                sIReservation.writeData(writer);
            }
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    /**
     * Select a file and read the data from the selected file then save the data into a the program.
     */
    public void readItemReservationData() {
        Frame aFrame = null;
        FileDialog fileBox = new FileDialog(aFrame, "Open", FileDialog.LOAD);
        fileBox.setVisible(true);
        fileBox.setDirectory("/Users/miroslavdermanski/Documents");
        String fileName = fileBox.getFile();
        //print a message if the user closes the file box.
        if (fileName == null) {
            System.out.println("File selection cancelled.");
            return;
        }
        File file = new File(fileName);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String lineOfText = scanner.nextLine().trim();
                if (lineOfText.isEmpty() || lineOfText.startsWith("//")) {
                    continue;
                }
                try (Scanner scanner2 = new Scanner(lineOfText).useDelimiter("\\s*,\\s*")) {
                    ShopItemReservation sIReservation = new ShopItemReservation();
                    sIReservation.readData(scanner2);
                    storeItemReservation(sIReservation);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe.getMessage());
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    /**
     * View diary entries for a specified period.
     */
    public void printDiaryEntries(String firstD, String lastD){
        DateUtil dateChecker = new DateUtil();
        Date start = dateChecker.convertStringToDate(firstD);
        Date end = dateChecker.convertStringToDate(lastD);
        diary.printEntries(start, end);
    }

    /**
     * Delete a reservation from the map collection.
     */
    public void deleteItemReservation(String reservationNo) {
        ShopItemReservation shopItemReservation = getShopItemReservation(reservationNo);
        if (shopItemReservation != null ){
            itemReservationMap.remove(reservationNo);
            diary.deleteReservation(shopItemReservation);
        }      
    }

    /**
     * Select a file and read the data from the selected file then save the data into a the program.
     * The data in the file must be in a specific format, with each line representing a single item reservation.
     * Blank lines and lines starting with "//" are ignored.
     * If an error occurs during the read process, an error message is printed to the terminal.
     */
    public void readShopItemData()
    {
        Frame aFrame = null;
        FileDialog fileBox = new FileDialog(aFrame, "Open", FileDialog.LOAD);
        fileBox.setVisible(true);
        fileBox.setDirectory("/Users/miroslavdermanski/Documents");
        String fileName = fileBox.getFile();
        //print a message if the user closes the file box.
        if (fileName == null) {
            System.out.println("File selection cancelled.");
            return;
        }

        File file = new File(fileName);
        String dataType = "";

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String lineOfText = scanner.nextLine().trim();
                if (lineOfText.startsWith("//")) {
                    continue;
                } else if (lineOfText.isEmpty()) {
                    continue;
                } else if (lineOfText.startsWith("[")) {
                    System.out.println("");
                    dataType = lineOfText;
                } else {
                    try (Scanner scanner2 = new Scanner(lineOfText).useDelimiter("\\s*,\\s*")) {
                        ShopItem item = null;
                        if (dataType.equalsIgnoreCase("[ElectricTool data]")) {
                            System.out.println("");
                            item = new ElectricTool();
                        } else if (dataType.equalsIgnoreCase("[HandTool data]")) {
                            System.out.println("");
                            item = new HandTool();
                        } else if (dataType.equalsIgnoreCase("[Perishable data]")) {
                            System.out.println("");
                            item = new Perishable();
                        } else if (dataType.equalsIgnoreCase("[Workwear data]")) {
                            System.out.println("");
                            item = new Workwear();                       
                        }

                        if (item != null)
                        {
                            item.readData(scanner2);
                            storeItem(item);
                        }
                        scanner2.close();
                    } catch (Exception e) {
                        System.out.println("An error occured on line: " + lineOfText);
                    }
                }
            }
            scanner.close();
        } catch (FileNotFoundException fnfe) {
            System.out.println("The file was not found: " + file.getAbsolutePath());
        } catch (IOException ioe) {
            System.out.println("An error occured when reading file: " + file.getAbsolutePath());
        }
    }
}