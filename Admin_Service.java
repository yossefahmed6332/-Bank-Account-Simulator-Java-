//Admin service for Admin only
public class Admin_Service {

    static String getUser_ByID(String ID,UsersRepo rep){//show user details by ID
        User_Details user=rep.getUser_ByID(ID);
        if(user!=null){
            return user.display();
        }
        else  {
            return "user not found";
        }
    }
    static String getUser_ByUsername(String username,UsersRepo rep){
        User_Details user=rep.getUser_ByUserName(username);
        if(user!=null){
            return user.display();
        }
        else  {
            return "user not found";
        }
    }
    static String getUser_ByEmail(String email,UsersRepo rep){
        User_Details user=rep.getUser_ByEmail(email);
        if(user!=null){
            return user.display();
        }
        else  {
            return "user not found";
        }
    }
    static void removeUser(String ID,UsersRepo rep){
        rep.deleteUser(ID);
    }


}
