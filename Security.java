
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
    boolean check_Deposit(double amount){
         return amount >=0;
    }
    boolean Repeated(String checked, UsersRepo repository) {

        for (User_Details user : repository.getUsers()) {
            if (checked.equals(user.getAccount_number())) return true;
            if (checked.equals(user.getPIN())) return true;
            if (checked.equals(user.getID())) return true;
            if (checked.equals(user.getUsername())) return true;
        }

        return false;
    }


}
