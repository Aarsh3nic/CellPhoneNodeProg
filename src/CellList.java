

import java.util.NoSuchElementException;

/**
 *  Aarsh Patel (40295201)<br/>
 *  COMP249<br/>
 *  Assignment # 3<br/>
 *  Due Date: Dec 2nd<br/>
 * CellList Class has two attributes CellNode HEAD pointer and Size of the CellList<br/>
 * It also has inner class CellNode having a CellPhone object and  pointer for the next CellNode;
 *  @author Aarsh Patel
 */
public class CellList {

    private CellNode head;
    private int size;

    class CellNode {

        private CellPhone cp;
        private CellNode next;

        public CellNode(){
            cp = null;
            next= null;
        }//default const. ends

        public CellNode(CellPhone cp, CellNode next){
            this.cp = cp;
            this.next = next;
        }//para const. ends

        public CellNode(CellNode cn){
            this.cp = cn.cp;
            this.next = cn.next;
        }//copy const. ends

        public CellNode clone(){
            return new CellNode(this.cp, this.next);
        }

        public CellNode getNext() {
            return next;
        }

        public void setNext(CellNode next) {
            this.next = next;
        }

        public CellPhone getCp() {
            return cp;
        }

        public void setCp(CellPhone cp) {
            this.cp = cp;
        }

    }//class CellNode ends

    public CellList(){
        head = null;
        size = 0;
    }

    /**
     * Copy Constructor which ensures the serial number is unique and deep copies the list
     * @param cl
     */
    public CellList(CellList cl){

        if(cl.size ==0){
            head = null;
            size = 0;
        }
        else{
            CellPhone temp = null;
            //this.size = cl.size; // also check if you want iterate the exact times for loop
            head = null;
            CellNode p = cl.head; // pointer for cl
            CellNode t = null; // pointer  for this object

            while(p != null){

                temp = p.cp.clone();

                if(this.head == null){

                    if(contains(temp.getSerialNum()) || cl.contains(temp.getSerialNum())){
                        System.out.println("Cannot ADD - "+ temp +" \nSerial number already added to the list");
                    }
                    else{
                        head = new CellNode(temp,null);
                        t = head;
                        this.size++;
                    }

                }
                else{

                    if(contains(temp.getSerialNum()) || cl.contains(temp.getSerialNum())){
                        System.out.println("Cannot ADD - "+ temp +" \nSerial number already added to the list");
                    }
                    else {
                        t.next = new CellNode(temp, null);
                        t = t.next;
                        this.size++;
                    }

                }
                p = p.next;
            }

            // not to leave any pointer at the list (preventing leakage)
            t= null;

        }

    }// copy const. ends

    /**
     * Adds element to the Start of the list
     * @param cp
     */
    public void addToStart(CellPhone cp){
        if(!contains(cp.getSerialNum())) {
            head = new CellNode(cp, head);
            size++;
        }
        else{
            System.out.println("Cannot ADD - "+ cp +" \nSerial number already added to the list"+ "\n\n");
        }

    }//addToStart() ends


    /**
     * Display all the contents of the list
     */
    public void showContents(){

        CellNode temp = head;
        int counter =1;
        if (temp == null)
            System.out.println("\nThere is nothing to display; list is empty." );
        else
            System.out.println("\nHere are the contents of the list." );
        while(temp != null)
        {
            System.out.print(temp.cp + " ---> ");
            temp = temp.next;// Move to the next node

            if(counter % 3 == 0 && temp != null)
                System.out.println(); // To format

            counter++;
        }
        System.out.println("X");	// "X" indicating the end of the list (null)


    }//showContents() ends

    /**
     * Adds element to the desired index of the list
     * @param cp
     * @param index
     * @throws NoSuchElementException
     */
    public void insertAtIndex(CellPhone cp, int index) throws NoSuchElementException{

        if(index<0 || index>=size)
            throw new NoSuchElementException("Entered Index: "+ index+ " is Invalid... \n" + cp +
                    " CANNOT BE INSERTED");

        if(index ==0){
            addToStart(cp);
        }
        else{

            if(!contains(cp.getSerialNum())) {
                CellNode t = head, p = head;
                for(int i= 0 ; i < index; i++){
                    p=t;
                    t= t.next;
                }
                t= new CellNode(cp, t);
                p.next = t;

                size++;
                // not to leave any pointer at the list (preventing leakage)
                t= null;
                p= null;
            }
            else{
                System.out.println("Cannot ADD - "+ cp +" \nSerial number already added to the list"+ "\n\n");
            }

        }

    }


    /**
     * Deletes element from the desired index of the list
     * @param index
     * @throws NoSuchElementException
     */
    public void deleteFromIndex(int index) throws NoSuchElementException{

        if(index<0 || index>=size)
            throw new NoSuchElementException("Entered Index: "+ index+ " is Invalid... \n " +
                    "ELEMENT CANNOT BE DELETED");

        if(index ==0){
            deleteFromStart();
        }
        else{
            CellNode t = head, p = head;
            for(int i= 0 ; i < index; i++){
                p=t;
                t= t.next;
            }
            p.next = t.next;
            size--;

            // not to leave any pointer at the list (preventing leakage)
            t= null;
            p= null;
        }

    }//not ready yet

    /**
     * Deletes element from the Start of the list
     */
    public void deleteFromStart(){

        if(size==0)
            System.out.println("No elements to delete.");
        else{
            head = head.next;
            size--;
        }

    }//addToStart() ends

    /**
     * Replaces element to the desired index of the list
     * @param cp
     * @param index
     * @return
     */
    public boolean replaceAtIndex(CellPhone cp, int index){

        if(index<0 || index>=size){
            System.out.println("Entered Index: "+ index+ " is Invalid... \n" + cp +
                    " CANNOT BE REPLACED");
            return false;
        }

        CellNode t = head;
        for(int i= 0 ; i < index; i++){
            t= t.next;
        }
        t.cp = cp;

        // not to leave any pointer at the list (preventing leakage)
        t= null;

        return true;

    }//replaceAtIndex() ends


    //THIS METHOD MAY RESULT IN PRIVACY LEAK
    //Proposal - Not to return pointer address instead return object details if required.

    /**
     * Finds and returns the pointer address from the list if the given serial number exists in the list.
     * THIS METHOD MAY RESULT IN PRIVACY LEAK
     * Proposal - Not to return pointer address instead return object details if required.
     * @param serialNum
     * @return
     */
    public CellNode find(long serialNum){
        CellNode t = head;
        int counter =1;
        while(t != null){

            if(t.cp.getSerialNum() == serialNum)
                break;

            counter++;
            t = t.next;
        }

        if(t!=null)
            System.out.println("Iteration made to find = " + counter );

        return t;
    }//find() ends

    /**
     * Returns TRUE if the given serial number exists in the list.
     * @param serialNum
     * @return
     */
    public boolean contains(long serialNum){
        return (find(serialNum) != null);
    }

}//class CellList ends
