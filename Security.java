
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
    boolean Repeated (String checked,UsersRepo repository){//check if any checked
        for (int i=0; i< repository.getSize(); i++){
            if (checked.equals(repository.getUser(checked).getAccount_number()))return true;
            if (checked.equals(repository.getUser(checked).getPIN()))return true;
            if (checked.equals(repository.getUser(checked).getID()))return true;
            if (checked.equals(repository.getUser(checked).getUsername()))return true;
        }
        return false;

    }


}
