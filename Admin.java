import java.util.ArrayList;

public class Admin extends User{
     Admin(String ID, String username,String email, String password, Address address)
    {
        super(ID,username,email,password,address);
    }
    //Admin service
    void getUser_ByID(String ID,UsersRepo rep){
         User_Details user=rep.GetUser_ID(ID);
         if(user!=null){
             System.out.println(user.toString());
         }
         else  {
             System.out.println("User not found");
         }
    }
    void getUser_ByUsername(String username,UsersRepo rep){
         User_Details user=rep.GetUser_UserName(username);
         if(user!=null){
             System.out.println(user.toString());
         }
         else  {
             System.out.println("User not found");
         }
    }
    void getUser_ByEmail(String email,UsersRepo rep){
         User_Details user=rep.GetUser_Email(email);
         if(user!=null){
             System.out.println(user.toString());
         }
         else  {
             System.out.println("User not found");
         }
    }
    void getAll_users(UsersRepo rep){
         for(User_Details user:rep.getUsers()){
             System.out.println(user.toString());
         }
    }
    void removeUser(String ID,UsersRepo rep){
         rep.deleteUser(ID);
    }


}
