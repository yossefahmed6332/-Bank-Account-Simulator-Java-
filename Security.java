
 class Security {

    //methods to check PIN , password
     boolean CheckPassword(String Password,User_Details user){
        return Password. equals(user.getPassword());
    }
     boolean CheckPIN (String PIN , User_Details user){
        return PIN.equals(user.getPIN());
    }

    //methods for check amount
    boolean check_Withdraw(double amount,double balance){
         return amount >=0 && amount >=balance;
    }
    boolean check_Deposit(double amount,double balance){
         return amount >=0;
    }


}
