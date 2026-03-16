import java.util.ArrayList;

public class UsersRepo {
     private ArrayList<User_Details> users = new ArrayList<>();
      UsersRepo(ArrayList<User_Details> users) {
         this.users = users;
     }
     UsersRepo (){}
    ArrayList<User_Details> getUsers(){
          return this.users;
    }


    User_Details getUser_ByAccnum(String account_number){
          for (User_Details user : users){
              if (user.getAccount_number().equals(account_number))return user;
          }
          return null;
    }
    User_Details GetUser_ID(String userID) {//find user index by user's ID
        for (User_Details user : users) {
            if (user.getID().equals(userID)) return users.get(users.indexOf(user));
        }
        return null;
    }
    User_Details GetUser_Email(String userEmail) {//get user index by user's Email
          for (User_Details user : users) {
              if (user.getEmail().equals(userEmail)) return users.get(users.indexOf(user));
          }
          return null;
    }
    User_Details GetUser_Accountnumber(String userAccountNumber) {//get user index by user's account number
          for (User_Details user : users) {
              if (user.getAccount_number().equals(userAccountNumber)) return users.get(users.indexOf(user));
          }
          return null;
    }
    User_Details GetUser_UserName(String userName) {
          for (User_Details user:users){
              if(user.getUserName().equals(userName)) return users.get(users.indexOf(user));
          }
          return null;
    }
    void deleteUser(String userID){//delete user , get user by ID
          if(GetUser_ID(userID) == null)return;
          users.remove(GetUser_ID(userID));
    }
    void addUser(User_Details user){//add user
          users.add(user);
    }
    int getSize(){
          return users.size();
    }



}
