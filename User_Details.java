import java.util.ArrayList;

class User_Details extends User{
    private String accountNumber;
    private String PIN;
    private double balance ;
    private ArrayList<Transaction> transactions;



    //using constractor to initial user details
    public User_Details( String account_number, String PIN, String ID, String email, String password, String userName){//default set , all is unknown
        super(ID,userName,email,password);
        this.accountNumber = account_number;
        this.PIN = PIN;
        this.balance = 0;
        transactions=new ArrayList<>();

    }



    public void setPIN(String PIN) {//set PIN

        this.PIN = PIN;

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


    double getBalance() {
        return balance;
    }

    void decrease  (double amount ){
        this.balance-=amount;

    }
    void increase (double amount){
        this.balance+=amount;

    }
    void getTransactions() {
        for (int i = 0; i < transactions.size(); i++) {
            System.out.println(transactions.get(i).showDetails());
            System.out.println("\n");
        }
    }
    String display(){
        return "Account Number: "+accountNumber+" \nBalance: "+balance+"" +
                " \nUsername: "+this.getUserName()+"\nemail: "+this.getEmail();
    }



}
