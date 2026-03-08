
public class Security {

    //methods to check PIN , password
     boolean CheckPassword(String Password,User_Details user){
        return Password. equals(user.getPassword());
    }
     boolean CheckPIN (String PIN , User_Details user){
        return PIN.equals(user.getPIN());
    }

    //methods for check amount
    boolean check_Withdraw(double amount,double balance){
         return amount >=0 && amount <=balance;
    }
    boolean check_Deposit(double amount,double balance){
         return amount >=0;
    }
    boolean Repeated (String checked){
        for (int i=0; i<User_Details.users.size(); i++)
            if (checked.equals(User_Details.users.get(i).getAccount_number()))return true;
        return false;

    }


}
