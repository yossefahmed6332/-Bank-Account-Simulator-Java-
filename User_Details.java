import java.util.ArrayList;

class User_Details{
    //variables have values of object "user"
    private String userName;
    private String passWord;
    private String email;
    private String accountNumber;
    private String ID;
    private String PIN;
    private double numOFTransactions;
    private double balance ;
    private ArrayList<Transaction> transactions=new ArrayList<>();
    static ArrayList<User_Details> users = new ArrayList<>();

    //using constractor to initial user details
    public User_Details(String username,String password,String email,String account_number,String Id,String PIN){//dafault set , all is uknown
        this.userName = username;
        this.passWord = password;
        this.email = email;
        this.accountNumber = account_number;
        this.ID = Id;
        this.PIN = PIN;
        this.numOFTransactions = 0;
        this.balance = 0;
    }
    public User_Details() {
        this.PIN = "5005054";
    }



    public void setUsername(String username) {// set user name

        this.userName=username;
        System.out.println("User name changed successfully");

    }
    public void setPassword(String newpassword) {//set password with validation
        this.passWord=newpassword;
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

    public void setNumOFtransactions(double numOFtransactions) {
        this.numOFTransactions = numOFtransactions;
    }
    public void newTransaction() {
        numOFTransactions++;

    }
    void AddTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    //methods to return details
    public String getUsername() {
        return userName;
    }
     String getPassword() {
        return passWord;
    }
     String getEmail() {
        return email;
    }
     String getAccount_number() {
        return accountNumber;
    }
     String getPIN() {
        return PIN;

    }
     String getID() {
        return ID;
    }
    double getNumOFtransactions() {
        return numOFTransactions;
    }
    double getBalance() {
        return balance;
    }
    void ShowTransactions() {
        for (int i = 0; i < transactions.size(); i++) {
            System.out.println(transactions.get(i).showDetails());
        }
    }
    void withdraw (double amount , User_Details user){
        user.balance-=amount;

    }
    void diposit (double amount , User_Details user){
        user.balance+=amount;

    }



}
