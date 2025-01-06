

import java.util.Scanner;

/**
 *  Aarsh Patel (40295201)<br/>
 *  COMP249<br/>
 *  Assignment # 3<br/>
 *  Due Date: Dec 2nd<br/>
 * CellPhone Class contains all the attributes of a cellphone: Serial Number, Brand name, launched year and Price<br/>
 * It also has all the Getter-Setter methods and all constructors to create cellphone objects<br/>
 *  @author Aarsh Patel
 */
public class CellPhone implements Cloneable{

    private long serialNum;
    private String brand;
    private int year;
    private double price;
    Scanner scan = new Scanner(System.in);

    public long getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(long serialNum) {
        this.serialNum = serialNum;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public CellPhone(long serialNum, String brand, double price, int year ) {
        this.serialNum = serialNum;
        this.brand = brand;
        this.year = year;
        this.price = price;
    }

    public CellPhone(CellPhone cp, long serialNum) {
        this.serialNum = serialNum;
        this.brand = cp.brand;
        this.year = cp.year;
        this.price = cp.price;
    }

    /**
     * Clone method to get a UNIQUE serial number from the user
     * and copy(clone) the rest of the elements for Cellphone
     * @return
     */
    @Override
    public CellPhone clone(){
        try
        {
            CellPhone cp = (CellPhone)super.clone();
            // Adjusting the serial number
            System.out.println("\nFor, Brand: "+ this.brand + "| Year: "+year + "| Price: "+ price);
            cp.serialNum = getValidEntry();

            return cp;
        }catch(CloneNotSupportedException e)
        {
            System.out.println("Cannot Clone CellPhone!");
            return null; // needed for the compiler!
        }
    }

    /**
     * Gets you a valid entry for the serial number[7 digits - all numbers]
     * @return
     */
    public long getValidEntry(){
        boolean invalid = true;
        String choice = null;
        long entry = -1;
        while(invalid){
            try{
                System.out.print("Enter Serial number (7 digits): ");
                choice = scan.nextLine();
                if(choice.length() ==7) {
                    entry = Long.parseLong(choice);
                    invalid = false;
                }
                else
                    System.out.println("\nRequiring a 7 digit number...");

            }catch(Exception e){
                System.out.println("\nInvalid entry, try again...");
            }
        }

        return entry;
    }//getValidEntry() ends

    /**
     * Converts CellPhone details to String
     * @return
     */
    public String toString(){
        return "[" + serialNum +
                ": " + brand +
                " " + price +
                "$ " + year + "]";
    }

    /**
     * Checks if the both Cellphones are equal or not
     * @param x
     * @return
     */
    @Override
    public boolean equals(Object x){

        if(x == null || this.getClass() != x.getClass())
            return false;

        CellPhone cp = (CellPhone) x;

        return(this.brand.equals(cp.brand)
        && this.year == cp.year
        && this.price == cp.price);
    }

}//CellPhone class cnds
