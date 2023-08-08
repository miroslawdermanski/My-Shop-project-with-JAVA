import java.util.Scanner;
/**
 * Perishable is a type of accessory which has additional fields that separate it from the shop item.
 *
 * @author (Miroslav Dermanski)
 * @version (09.03.23)
 */
public class Perishable extends Accessory
{

    private boolean isIrritant;

    private String useByDate;

    private int volume;

    /**
     * Constructor for objects of class Perishable
     */
    public Perishable(String itemName, String itemCode, int cost, boolean isRecyclable, boolean isIrritant, String useByDate, int volume)
    {
        super(itemName, itemCode, cost, isRecyclable);

        this.isIrritant = isIrritant;

        this.useByDate = useByDate;

        this.volume = volume;      
    }

    public Perishable()
    {
        super();
        isIrritant = false;
        useByDate = "";
        volume = 0;
    }

    /**
     * Get the value of isIrritant.
     */
    public boolean getIsIrritant()
    {
        return isIrritant;
    }

    /**
     * Change whether or not an accessory is irritant.
     */
    public void setIsIrritant(boolean newVal)
    {
        isIrritant = newVal; 
    }

    /**
     * Get the value useByDate.
     */
    public String getUseByDate()
    {
        return useByDate;
    }

    /**
     * Set the end use by date of a perishable accessory.
     */
    public void setUseByDate(String newDate)
    {
        useByDate = newDate;
    }

    /**
     * Get the volume of an accessory.
     */
    public int getVolume()
    {
        return volume;
    }

    /**
     * Set the volume of a perishable accessory.
     */
    public void setVolume(int newVol)
    {
        volume = newVol;
    }
    
    /**
     * Read values for each of the accessories fields.
     */
    public void readData(Scanner scanner)
    {
        super.readData(scanner);
        isIrritant = scanner.nextBoolean();
        useByDate = scanner.next();
        volume = scanner.nextInt();
    }
    
    /**
     * Print all details of an accessory including a perishable.
     */
    public void printDetails()
    {
        super.printDetails();
        System.out.println("Irritant: " + isIrritant + "; " + "Use by date: " + useByDate + "; " + "Volume: " + volume + "; ");
    }

}
