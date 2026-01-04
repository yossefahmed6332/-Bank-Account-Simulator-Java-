import java.util.Scanner;

public class Bankacc_simulator {
    public static Scanner input = new Scanner(System.in);
    //methods design in main class including 3 methods call other methods

    public static void Cdetails(User_Details user) {
        System.out.println("enter choice 0 to change password\n 1 to change user name \n 2 to change password \n 3 to change email \n 4 to change PIN \"you can't change account number\" ");
        int choice = input.nextInt();
        switch (choice) {
            case 0:
                System.out.println("enter old password : ");
                String oldpassword = input.next();//user enter old password to check
                System.out.println("enter new password : ");
                String newpassword = input.next();//user enter new password
                user.setPassword(oldpassword,newpassword);//call password setter
                break;
                case 1:
                    System.out.println("enter new user name ");
                    String newusername = input.next();//new user name
                    System.out.println("enter your password ");
                    String password = input.next();//password to check
                    user.setUsername(password,newusername);
                    break;
                    case 2:
                        System.out.println("enter old password ");
                        String password2 = input.next();//password to check
                        System.out.println("enter new password ");
                        String newpassword2 = input.next();//new password
                        user.setPassword(password2,newpassword2);
                        break;
                        case 3:
                            System.out.println("enter your password ");
                            String password3 = input.next();//password to check
                            System.out.println("enter your new email ");
                            String email = input.next();//new email
                            user.setEmail(email,password3);
                            break;
                            case 4:
                                System.out.println("enter your password ");
                                String password4 = input.next();//password to check
                                System.out.println("enter your new PIN ");
                                String pin = input.next();//new PIN
                                user.setPIN(pin,password4);

                            default:
                                System.out.println("invalid choice");
        }
    }


    public static void report(User_Details user,Operations operations) {
        System.out.println("Thanks for using my Bank account simulator \n enter your password for report , enter 0 to refuse ");//thank user
        String password = input.next();
        while (!password.equals("0")){
        if (password.equals(user.getPassword())) {
            System.out.println("\t\t--------------------------------");
            System.out.println("your account number is " + user.getAccount_number() + "\nyour email is " + user.getEmail() + "\nyour ID is " + user.getID()+"\nyou password is ******"+"\n your user name"+user.getUsername());
            System.out.println("\t\t--------------------------------");
            for (int i=0; i<operations.getValue().length; i++)//give report about operation , values for each operation
            {
                if(operations.getValue()[i]!=0){
                    System.out.println(operations.getOperation()[i]+":    "+operations.getValue()[i]);
                }
                else
                    break;
            }
        }
    }}
    public static void Coperations(Operations user_opertation,User_Details user) {
        System.out.println("enter 1 to withdraw , 2 to diposite , 3 to show Balance");//give user a menu
        int choice = input.nextInt();//user enter choice
        switch (choice) {
            case 1:
                System.out.println("enter your PIN : ");
                String pin = input.next();//PIN checker
                System.out.println("enter amount : ");
                double amount = input.nextDouble();//enter amount
                user_opertation.withdraw(amount,pin,user.getPIN());//call method
                break;
                case 2:
                    System.out.println("enter your PIN : ");
                    String pin2 = input.next();//user enter PIN to check
                    System.out.println("enter amount : ");
                    double amount2 = input.nextDouble();//user enter amount
                    user_opertation.deposit(amount2,pin2,user.getPIN());
                    break;
                    case 3:
                        System.out.println("enter your PIN : ");
                        String pin3 = input.next();//user enter PIN to check
                        System.out.println(user_opertation.getBalance(pin3,user.getPIN()));//print returned value
                        break;
                        default:
                        System.out.println("invalid choice");



        }
        report(user,user_opertation);
    }

    public static void main(String[] args) {
        System.out.println("welcome to Bank account simulator");
        System.out.println("Please enter user name: ");
        String username=input.next();//user enter his name
        System.out.println("please enter email :");
        String email=input.next();//user enter email
        System.out.println("Please enter password: ");
        String password=input.next();//user enter password
        System.out.println("please enter your ID: ");
        String id=input.next();//userenter ID
        String account_number=id;
        String PIN="432343";
        User_Details user =new User_Details(username,password,email,account_number,id,PIN);//new object has detailes of user
        System.out.println("");
        Operations user_operations = new Operations();//new object has user operation
        int choice;
        do {
            System.out.println( " enter 1 to control to details \n enter 2 to do an operation \n enter 3 to exist");
             choice=input.nextInt();
             switch (choice) {
                 case 1:
                     Cdetails(user);
                     break;
                     case 2:

             }
        }
        while(choice!=3);




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
        this.PIN = "5005054";
    }
    public User_Details() {
        this.PIN = "5005054";
    }

    public void setUsername(String password,String username) {// set user name
        if (this.password.equals(password)) {//check if user enter true password
        this.username=username;
            System.out.println("User name changed successfully");}
        else {//else
            System.out.println("failed , password not match ");
        }
    }
    public void setPassword(String password,String newpassword) {//set password with validation
        if(this.password.equals(password)){
        this.password=newpassword;
        System.out.println("password changed successfully");
        }
        else{
            System.out.println("Passwords don't match,changing failed");
        }
    }
    public void setEmail(String email,String password) {//set new email with validation
        if(this.password==null||this.password.equals(password)){
        this.email=email;
        System.out.println("email changed successfully");}
        else{
            System.out.println("Passwords don't match,changing failed");
        }
    }
    public void setAccount_number(String account_number) {//set account number , cannot be changed
        if(this.account_number==null){
        this.account_number=account_number;
        }
        else{
            System.out.println("Account number already exists,setting failed");
        }
    }
    public void setPIN(String PIN,String password) {//set PIN
        if(password.equals(this.password)) {//check if password matchs with Data
            this.PIN = PIN;
            System.out.println("PIN changed successfully");
        }else
            System.out.println("Passwords don't match,changing failed");
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
    private String[] operation=new String[50];//array has operation type
    private double[] value=new double[50];//array has operation value
    private double balance ;

    public Operations(){//set all elements as null or zero
        balance=0;
    }

    public void withdraw(double amount,String PIN,String pin){
        if(amount>balance){//if user amount more than balance
            System.out.println("You can't withdraw more than "+amount+" money");
        }
        else if(amount<=0){//if user amount less than 0
            System.out.println("You can't withdraw less than or equal 0");
        }
        else if(!PIN.equals(pin)){//if PIN is wrong
            System.out.println("wrong PIN");
        }
        else {
            this.balance -=amount;
            for(int i=0;i<operation.length;i++){//for loop to check frist unformed part
                if(operation[i]==null){
                    operation[i]="Withdraw";//enter operation
                    break;
                }
            }
            for(int i=0;i<value.length;i++){//check frist unformed part
                if(value[i]==0){
                    value[i]=amount;//enter value
                    break;//out of loop
                }
            }
            System.out.println("withdraw successfully");
        }

    }
    public void deposit(double amount,String PIN,String pin){

        if(amount<=0){//if user amount less than 0
            System.out.println("You can't diposit less than or equal 0");
        } else if (!PIN.equals(pin)) {
            System.out.println("wrong PIN, deposit failed");

        } else{
            this.balance +=amount;
            for(int i=0;i<operation.length;i++){//for loop to check frist unformed part
                if(operation[i]==null){
                    operation[i]="Diposit";//enter operation
                    break;
                }
            }
            for(int i=0;i<value.length;i++){//check frist unformed part
                if(value[i]==0){
                    value[i]=amount;//enter value
                    break;//out of loop
                }
            }
            System.out.println("diposit successfully");
        }
        System.out.println("Balance is "+this.balance);
    }


    public String getBalance(String PIN,String pin){//if user want to see balance
        if (PIN.equals(pin)) //check PIN
            return String.valueOf(balance);
        else
            return "PIN wrong , try again";


    }

    public double[] getValue() {
        return value;
    }

    public String[] getOperation() {
        return operation;
    }
}
