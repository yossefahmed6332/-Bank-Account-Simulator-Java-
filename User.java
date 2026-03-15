import java.util.ArrayList;
import java.util.Scanner;

public class User {
    private String ID;
    private String userName;
    private String email;
    private String password;
    private ArrayList<Address> addresses;
    //constructor
    User(){}
    User(String ID, String userName, String email, String password, Address addresses) {
        this.ID = ID;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.addresses.add(addresses);
    }
    //setters
    void setID(String ID){
        this.ID = ID;
    }
    void setUserName(String userName){
        this.userName = userName;
    }
    void setEmail(String email){
        this.email = email;
    }
    void setPassword(String password){
        this.password = password;
    }
    void setAddresses(ArrayList<Address> addresses){
        this.addresses = addresses;
    }
    //getters
    String getID(){
        return this.ID;
    }
    String getUserName(){
        return this.userName;
    }
    String getEmail(){
        return this.email;
    }
    String getPassword(){
        return this.password;
    }
    ArrayList<Address> getAddresses(){
        return this.addresses;
    }
    //Arraylist
    Address Address(Scanner sc){
        //take user first choice
        System.out.println("if your address contains floor number and room/apartment enter yes ,otherwise write no");
        String choice = sc.nextLine();
        choice = choice.toLowerCase();

        //user enter address with floor number and department
        if(choice.equals("yes")){
            System.out.println("enter these data in this specific order: country ,state," +
                    "city,street number,street name , postal code,floor number and department number");
            Address address = new Address(sc.nextLine(),sc.nextLine(),sc.nextLine(),sc.nextInt()
                    ,sc.next(),sc.nextLine(),sc.nextInt(),sc.nextInt());
            return address;
        }
        //user enter data without floor number and department
        else if(choice.equals("no")){
            System.out.println("enter these data in this specific order: country ,state," +
                    "city,street number,street name , postal code");
            Address address = new Address(sc.nextLine(),sc.nextLine(),sc.nextLine(),sc.nextInt()
                    ,sc.next(),sc.nextLine());
            return address;
        }
        //user enter don't equal yes or no so call method again
        else{
            System.out.println("invalid choice , try again");
            return Address(sc);
        }


    }

    void AddAddress(Scanner sc,Security sec){
        Address address=Address(sc);

        //if address is already exist
        if (sec.IsExist_Address(address,this.addresses)){
            System.out.println("Address already exists");
            System.out.println("for add another address enter 1 , otherwise enter 2");
            int choice =sc.nextInt();
            if(choice==1)AddAddress(sc,sec);
            else if(choice==2)return;
            else {
                System.out.println("invalid choice , try again");
                AddAddress(sc,sec);
            }
        }
        this.addresses.add(address);
    }
    void RemoveAddress(Scanner sc,Security sec){
        Address address=Address(sc);
        //check if address exist
        if(!sec.IsExist_Address(address,this.addresses)){
            System.out.println("invalid address, try again");
            RemoveAddress(sc,sec);
        }
        this.addresses.remove(address);
    }
}
