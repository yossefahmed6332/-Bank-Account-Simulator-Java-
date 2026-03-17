import java.util.ArrayList;
import java.util.Scanner;

public class User {
    private String ID;
    private String userName;
    private String email;
    private String password;
    //constructor
    User(){}
    User(Scanner sc,String ID, String userName, String email, String password) {
        this.ID = ID;
        this.userName = userName;
        this.email = email;
        this.password = password;
//        AddAddress(sc,sec);
    }
    //setters
    void setID(String ID){
        this.ID = ID;
    }
    void setUserName(String userName){
        this.userName = userName;
    }
    void setEmail(String email){
        this.email = email;
    }
    void setPassword(String password){
        this.password = password;
    }
    String getID(){
        return this.ID;
    }
    String getUserName(){
        return this.userName;
    }
    String getEmail(){
        return this.email;
    }
    String getPassword(){
        return this.password;
    }
}
   
