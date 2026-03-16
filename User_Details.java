import java.util.ArrayList;

class User_Details extends User{
    private String accountNumber;
    private String PIN;
    private int numOFTransactions;
    private double balance ;
    private ArrayList<Transaction> transactions;



    //using constractor to initial user details
    public User_Details(String account_number,String PIN,String ID,String email,String password,String userName,Address address){//dafault set , all is uknown
        this.accountNumber = account_number;
        this.PIN = PIN;
        this.numOFTransactions = 0;
        this.balance = 0;
        transactions=new ArrayList<>();
        super(ID,userName,email,password,address);

    }



    public void setPIN(String PIN) {//set PIN

        this.PIN = PIN;
        System.out.println("PIN changed successfully");

    }

     void newTransaction() {
        numOFTransactions++;

    }
    void AddTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    //methods to return details
    String getAccount_number() {
        return accountNumber;
    }
    String getPIN() {
        return PIN;

    }

    int getNumOFtransactions() {
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
    void decrease  (double amount ){
        this.balance-=amount;

    }
    void increase (double amount){
        this.balance+=amount;

    }



}