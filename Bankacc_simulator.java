import java.util.Scanner;
import java.util.ArrayList;
public class Bankacc_simulator {
    public static Scanner input = new Scanner(System.in);
    //methods design in main class including 3 methods call other methods

    public static boolean Checkpassword(User_Details user) {
        System.out.println("Please enter your password: ");//ask user to enter password
        if(user.checkPassword(input.next())) {//call check method
            System.out.println("true password");
            return true;
        }
        System.out.println("Wrong password");
        return false;
    }
        public static void changePassword(User_Details user) {
        if(Checkpassword(user)){
        System.out.println("enter new password : ");
        String newpassword = input.next();//user enter new password
        user.setPassword(newpassword);}//call password setter

    }
    public static void changeUSername(User_Details user) {
        if(Checkpassword(user)){
        System.out.println("enter new user name ");
        String newusername = input.next();//new user name
        user.setUsername(newusername);}
    }
    public static void ChangeEmail(User_Details user) {
      if(Checkpassword(user)){
        System.out.println("enter your new email ");
        String email = input.next();//new email
        user.setEmail(email);}
    }
    public static void ChangePIN(User_Details user) {
        if(Checkpassword(user)){
        System.out.println("enter your new PIN ");
        String pin = input.next();//new PIN
        user.setPIN(pin);}
    }

    public static void Changedetails(User_Details user) {
        System.out.println("enter 1 to change user name \n 2 to change password \n 3 to change email \n 4 to change PIN \"you can't change account number\" ");
        int choice = input.nextInt();
        switch (choice) {

                case 1:
                   changeUSername(user);
                    break;
                    case 2:
                        changePassword(user);
                        break;
                        case 3:
                            ChangeEmail(user);
                            break;
                            case 4:
                               ChangePIN(user);
                            default:
                                System.out.println("invalid choice");
        }
    }

    public static boolean CheckPIN(User_Details user) {
        System.out.println("Please enter your PIN : ");
        String PIN = input.next();//user enter PIN to check
        if(user.checkPIN(PIN)) {//check if user input equals to existPIN
            System.out.println("true PIN");
            return true;
        }
        System.out.println("Wrong PIN");
        return false;
    }
    public static double Amount () {
        System.out.println("enter amount");
        double amount = input.nextDouble();
        return amount;
    }

    public static void Withdraw(Operations user_opertation,User_Details user) {
        if(CheckPIN(user)){
        user_opertation.withdraw(Amount());}//call method
    }
    public static void Deposit(Operations user_opertation,User_Details user) {
       if(CheckPIN(user)){
        user_opertation.deposit(Amount());}
    }
    public static void showBalance(Operations user_opertation,User_Details user) {
       if(CheckPIN(user)){
        System.out.println(user_opertation.getBalance());
       }//print returned value"Balance"
    }
    public static void dooperations(Operations user_opertation,User_Details user) {
        System.out.println("enter 1 to withdraw , 2 to diposite , 3 to show Balance");//give user a menu
        int choice = input.nextInt();//user enter choice
        switch (choice) {
            case 1:
                Withdraw(user_opertation,user);
                break;
                case 2:
                   Deposit(user_opertation,user);
                    break;
                    case 3:
                       showBalance(user_opertation,user);
                        break;
                        default:
                            System.out.println("invalid choice");



        }
    }

    public static void report(User_Details user,Operations operations) {
        System.out.println("Thanks for using my Bank account simulator \n enter your password for report , enter 0 to refuse ");//thank user
       if (Checkpassword(user)){
           report report=new report(operations, user);
          report.getInfo();//get user details
          report.ShowValues();//get Values list
          report.ShowOperations();//get operations list

       }
        System.out.println("Thanks for using my bank account simulator");

    }

    public static void main(String[] args) {
        System.out.println("welcome to Bank account simulator");
        System.out.println("Please enter user name: ");
        String username=input.next();//user enter his name
        System.out.println("please enter email :");
        String email=input.next();//user enter email
        System.out.println("Please enter password: ");
        String password=input.next();//user enter password
        System.out.println("please enter your national ID: ");
        String id=input.next();//userenter ID
        String account_number=id;
        String PIN="432343";
        User_Details user =new User_Details(username,password,email,account_number,id,PIN);//new object has detailes of user
        System.out.println("");
        Operations user_operations = new Operations();//new object has user operation
        Show_DetailsAfterregisteration show=new Show_DetailsAfterregisteration(user);
        show.getDetails();//method show all user's data
        int choice;
        do {
            System.out.println( " enter 1 to control to details \n enter 2 to do an operation \n enter 3 to exist");
             choice=input.nextInt();
             switch (choice) {
                 case 1:
                     Changedetails(user);
                     break;
                     case 2:
                         dooperations(user_operations,user);
             }
        }
        while(choice!=3);

        report(user,user_operations);



    }
}


class User_Details{
    //variables have values of object "user"
    private String username;
    private String password;
    private String email;
    private String account_number;
    private String ID;
    private String PIN;
    //using constractor to initial user details
    public User_Details(String username,String password,String email,String account_number,String Id,String PIN){//dafault set , all is uknown
        this.username = username;
        this.password = password;
        this.email = email;
        this.account_number = account_number;
        this.ID = Id;
        this.PIN = PIN;
    }
    public User_Details() {
        this.PIN = "5005054";
    }

    public boolean checkPIN(String PIN){
        if(PIN.equals(getPIN())){
            return true;
        }
        return false;
    }

    public boolean checkPassword(String password){
        if(password.equals(this.password)){
            return true;
        }
        else
            return false;
    }
    public void setUsername(String username) {// set user name

        this.username=username;
            System.out.println("User name changed successfully");

    }
    public void setPassword(String newpassword) {//set password with validation
        this.password=newpassword;
        System.out.println("password changed successfully");

    }
    public void setEmail(String email ) {//set new email with validation

        this.email=email;
        System.out.println("email changed successfully");


    }
    public void setPIN(String PIN) {//set PIN

            this.PIN = PIN;
            System.out.println("PIN changed successfully");

    }
    //methods to return details
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getEmail() {
        return email;
    }
    public String getAccount_number() {
        return account_number;
    }
    public String getPIN() {
        return PIN;

    }
    public String getID() {
        return ID;
    }

}

class Operations{
    private ArrayList<Double> Values;
    private ArrayList<String> Operations;
    private double balance ;

    public Operations(){//set all elements as null or zero
        balance=0;
        Values=new ArrayList<>();
        Operations=new ArrayList<>();
    }


    public boolean check_withdraw(double amount){
        if(amount>balance){//if user amount more than balance
            System.out.println("You can't withdraw more than your Balance");
            return false;
        }
        else if(amount<=0){//if user amount less than 0
            System.out.println("You can't withdraw less than or equal 0");
            return false;
        }
        return true;
    }

    public void withdraw(double amount){
        if(!check_withdraw(amount)){
            System.out.print(" operation failed");
        }
        else {
            this.balance -=amount;
            Operations.add("Withdraw");
            Values.add(amount);
            System.out.println("withdraw successfully");
        }

    }
    public boolean check_diposite(double amount){

        if(amount<=0){
           System.out.println("You can't diposite less than or equal 0");
           return false;
       }
        else
            return true;
    }

    public void deposit(double amount){

     if (!check_diposite(amount)){
         System.out.print(" operation failed");
     }
         else{
            this.balance +=amount;
           Operations.add("Deposit");
           Values.add(amount);
            System.out.println("diposit successfully");
        }
        System.out.println("Balance is "+this.balance);
    }


    public String getBalance(){//if user want to see balance
            return String.valueOf(balance);

    }
    public ArrayList<String> getOperations(){//method to get operations
        return Operations;
    }
    public ArrayList<Double> getValues(){//method to get values
        return Values;
    }

}

 class report{
    private  Operations operation;//declare new object
    private   User_Details user;
    public report(Operations operation,User_Details user){//call refrence original oblect's data
        this.operation=operation;
        this.user=user;
    }
    public  void getInfo(){
        System.out.println("Account Number: "+user.getAccount_number());
        System.out.println("Username: "+user.getUsername());
        System.out.println("Password: ***** ");
        System.out.println("Email: "+user.getEmail());
    }

     public  void ShowOperations(){
        for(int i=0;i<operation.getOperations().size();i++){
            System.out.print(operation.getOperations().get(i)+" ");//user get operations
        }
     }
     public void ShowValues(){
        for (int i=0; i<operation.getValues().size();i++){
            System.out.println(operation.getValues().get(i)+" ");//get values
        }}

 }

 class Show_DetailsAfterregisteration {
    private  User_Details user;
    public Show_DetailsAfterregisteration(User_Details user){
        this.user=user;
    }
    public void getDetails(){
        System.out.println("Your ID: "+user.getID());
        System.out.println("Your PIN: "+user.getPIN());
        System.out.println("Your Email: "+user.getEmail());
        System.out.println("Your Account Number: "+user.getAccount_number());
        System.out.println("Your Password: "+user.getPassword());
    }
 }



