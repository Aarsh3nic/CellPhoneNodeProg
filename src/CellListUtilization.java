

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *  Aarsh Patel (40295201)<br/>
 *  COMP249<br/>
 *  Assignment # 3<br/>
 *  Due Date: Dec 2nd<br/>
 * CellListUtilization Class to run all the coded methods and function the program.
 * @author Aarsh Patel
 */
public class CellListUtilization {

    public static void main(String[] args)   {


        //------------  Creating CellList
        CellList list1 = new CellList();
        CellList listOrig = new CellList();

        //------------ Creating CellPhones
        CellPhone cp1 = new CellPhone(1111111, "Sony", 99.99, 2000 );
        CellPhone cp2 = new CellPhone(1111333, "JBL", 98.99, 2001 );
        CellPhone cp3 = new CellPhone(1111111, "Jockey", 88.99, 2002 );
        CellPhone cp4 = new CellPhone(3333333, "Jockey", 88.99, 2002 );
        CellPhone cp5 = new CellPhone(4444444, "Samsung", 199.99, 2000 );
        CellPhone cp6 = new CellPhone(2222333, "Coolpix", 198.99, 2001 );
        CellPhone cp7 = new CellPhone(4444111, "Google", 188.99, 2002 );
        CellPhone cp8 = new CellPhone(3334444, "Oppo", 188.99, 2003 );
        CellPhone cp9 = new CellPhone(3334441, "OnePlus", 18.99, 2013 );
        // Here we know that cp1 and cp3 has same serial number
        // And cp3 and cp4 are equal.

        //For Another List
        CellPhone cp10 = new CellPhone(5555555, "Nokia", 299.99, 2005);
        CellPhone cp11 = new CellPhone(6666666, "Sony", 250.99, 2006);
        CellPhone cp12 = new CellPhone(7777777, "HTC", 220.00, 2007);
        CellPhone cp13 = new CellPhone(8888888, "Motorola", 210.99, 2008);
        CellPhone cp14 = new CellPhone(9999999, "BlackBerry", 199.00, 2009);



                                //------------ DEMONSTRATION ---------//


        System.out.println("\n||--------- copyContructor() [CellList] ----------||\n\n");

        //Adding elements to listOrig
        listOrig.addToStart(cp14);
        listOrig.addToStart(cp13);
        listOrig.addToStart(cp12);
        listOrig.addToStart(cp11);
        listOrig.addToStart(cp10);

        System.out.println("\tContents of -listOrig-");
        listOrig.showContents();

        System.out.println("\nNow Let's create a deep copy of it and store in -listCopy- [using copyConst.]");

        CellList listCopy = new CellList(listOrig);

        System.out.println("\n\n\tContents of -listCopy-");
        listCopy.showContents();



        System.out.println("\n||--------- READing and ADDing elements [Cell_Info.txt] ----------||\n\n");


        try(Scanner scan = new Scanner(new FileInputStream("Cell_Info.txt"))){

            while(scan.hasNextLine()){
                list1.addToStart(new CellPhone(scan.nextLong(),scan.next(),scan.nextDouble(),scan.nextInt()));
            }

        }
        catch(FileNotFoundException e){
            System.out.println("File NOT found.");
        }
        finally {
            list1.showContents();

            System.out.println("\n\n");


            System.out.println("\n||--------- equals() ----------||\n");
            System.out.println("Is " + cp1 + " and "+cp4+" equal?\n\t\t --> " + ((cp1.equals(cp4)) ? "YES" : "NO") );

            System.out.println("Is " + cp3 + " and "+cp4+" equal?\n\t\t --> " + ((cp3.equals(cp4)) ? "YES" : "NO") );




            System.out.println("\n||--------- CONTAINS() ----------||\n");

            System.out.println("\nChecking for " + 5555902);
            if(!list1.contains(5555902))
                System.out.println("Element NOT found.");

            System.out.println("\nChecking for " + 1111111);
            if(!list1.contains(1111111))
                System.out.println("Element NOT found.");

            System.out.println("\nChecking for " + 9675654);
            if(!list1.contains(9675654))
                System.out.println("Element NOT found.");


            //find() method explanation
            System.out.println("\n||--------- FIND() ----------||\n\n");
            System.out.println("There is a risk of PRIVACY LEAK when I use the find() method\n");

            System.out.println("Let's find serial: 9675654 and store the cp pointer...\n");

            CellPhone cpNew = list1.find(9675654).getCp();

            System.out.println("Pointer address : "+ list1.find(9675654) + "\nStored Cellphone data:" +
                    cpNew);

            //Now see how easily I can break in and change the cellPhone data
            System.out.println("Now see how easily I can break in and change the cellPhone data...\n");
            System.out.println("Modifying brand name...\n");
            cpNew.setBrand("BASKINROBINS");
            System.out.println("Modifying PRICE...\n");
            cpNew.setPrice(0);
            System.out.println("\n\t\tModified data: "+cpNew);


            System.out.println("\n||--------- addToStart() ----------||\n");

            System.out.println("Adding "+ cp1 + " to the start...");
            list1.addToStart(cp1);

            System.out.println("Adding "+ cp2 + " to the start...");
            list1.addToStart(cp2);

            System.out.println("Adding "+ cp3 + " to the start...");
            list1.addToStart(cp3);

            System.out.println("\n\t\t----- Modified LIST: ");
            list1.showContents();


            try{
                System.out.println("\n||--------- insertAtIndex() ----------||\n");

                System.out.println("Adding "+ cp4 + " to Index --> 3 (0 to size-1)...");
                list1.insertAtIndex(cp4, 3);

                System.out.println("Adding "+ cp5 + " to Index --> 0 (0 to size-1)...");
                list1.insertAtIndex(cp5, 0);

                System.out.println("Adding "+ cp6 + " to Index --> 99 (0 to size-1)...");
                list1.insertAtIndex(cp6, 99);

            }
            catch (NoSuchElementException e){
                System.out.println("\n\t"+e.getMessage());
            }
            finally{

                System.out.println("\n\t\t----- Modified LIST: ");
                list1.showContents();

                System.out.println("\n||--------- deleteFromStart() ----------||\n");
                System.out.println("Deleting 1 element from the start...");
                list1.deleteFromStart();

                System.out.println("\n\t\t----- Modified LIST: ");
                list1.showContents();

                try{
                    System.out.println("\n||--------- deleteAtIndex() ----------||\n");

                    System.out.println("Deleting element from Index --> 4 (0 to size-1)...");
                    list1.deleteFromIndex(4);

                    System.out.println("Deleting element from Index --> 0 (0 to size-1)...");
                    list1.deleteFromIndex(0);

                    System.out.println("Deleting element from Index --> 99 (0 to size-1)...");
                    list1.deleteFromIndex(99);

                }
                catch (NoSuchElementException e){
                    System.out.println("\n\t"+e.getMessage());
                }
                finally{

                    System.out.println("\n\t\t----- Modified LIST: ");
                    list1.showContents();

                    try{
                        System.out.println("\n||--------- replaceAtIndex() ----------||\n");

                        System.out.println("Replacing with "+ cp7 + " at Index --> 3 (0 to size-1)...");
                        list1.replaceAtIndex(cp7, 3);

                        System.out.println("Replacing with "+ cp8 + " at Index --> 0 (0 to size-1)...");
                        list1.replaceAtIndex(cp8, 0);

                        System.out.println("Replacing with "+ cp9 + " at Index --> 99 (0 to size-1)...");
                        list1.replaceAtIndex(cp9, 99);

                    }
                    catch (NoSuchElementException e){
                        System.out.println("\n\t"+e.getMessage());
                    }
                    finally{
                        System.out.println("\n\t\t----- Modified LIST: ");
                        list1.showContents();

                    }//finally-4-replace() ends

                }//finally-3-delete() ends

            }//finally-2-insert() ends

        }//finally-1() ends

    }// main() ends

}// class  CellListUtilization ends




