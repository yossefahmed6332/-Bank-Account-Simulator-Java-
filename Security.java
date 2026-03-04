import java.net.PasswordAuthentication;

public class Security {


     static boolean CheckPassword(String Password,User_Details user){
        return Password. equals(user.getPassword());
    }
    static boolean CheckPIN (String PIN , User_Details user){
         return PIN.equals(user.getPIN());
    }


}
