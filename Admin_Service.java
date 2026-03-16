public class Admin_Service {
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
