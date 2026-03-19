
public class Security {

    //methods to check PIN , password
     static boolean CheckPassword(String Password,User_Details user){
        return Password. equals(user.getPassword());
    }
     static boolean CheckPIN (String PIN , User_Details user){
        return PIN.equals(user.getPIN());
    }

    //methods for check amount
    static boolean check_Withdraw(double amount, double balance) {
        return amount > 0 && amount <= balance;
    }
    static boolean check_Deposit(double amount) {
        return amount > 0;
    }
    static boolean Repeated_Accnum(String checked, UsersRepo repository) {

        for (User_Details user : repository.getUsers()) {
            if (checked.equals(user.getAccount_number())) return true;
        }

        return false;
    }
    static boolean Repeated_ID(String checked, UsersRepo repository) {
         for (User_Details user : repository.getUsers()) {
             if (checked.equals(user.getID())) return true;
         }
         return false;
    }
    static boolean Repeated_Email(String checked, UsersRepo repository) {
         for (User_Details user : repository.getUsers()) {
             if (checked.equals(user.getEmail())) return true;
         }
         return false;
    }
    static boolean Repeated_PIN(String checked, UsersRepo repository) {
         for (User_Details user : repository.getUsers()) {
             if (checked.equals(user.getPIN())) return true;
         }
         return false;
    }
    static boolean Repeated_Username(String checked, UsersRepo repository) {
         for (User_Details user : repository.getUsers()) {
             if (checked.equals(user.getUserName())) return true;
         }
         return false;
    }
    static boolean transfer(User_Details userSend,User_Details userReceive,double amount){
         //check amount sent
        if(amount>userSend.getBalance())return false;
        //check userReceive if exist
        if(userReceive==null)return false;
        //accessing security system
        return true;




    }


}
