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
    User_Details getUser_ByID(String userID) {//find user index by user's ID
        for (User_Details user : users) {
            if (user.getID().equals(userID)) return users.get(users.indexOf(user));
        }
        return null;
    }
    User_Details getUser_ByEmail(String userEmail) {//get user index by user's Email
          for (User_Details user : users) {
              if (user.getEmail().equals(userEmail)) return users.get(users.indexOf(user));
          }
          return null;
    }
    User_Details getUser_ByAccountnumber(String userAccountNumber) {//get user index by user's account number
          for (User_Details user : users) {
              if (user.getAccount_number().equals(userAccountNumber)) return users.get(users.indexOf(user));
          }
          return null;
    }
    User_Details getUser_ByUserName(String userName) {
          for (User_Details user:users){
              if(user.getUserName().equals(userName)) return users.get(users.indexOf(user));
          }
          return null;
    }
    void deleteUser(String userID){//delete user , get user by ID
          if(getUser_ByID(userID) == null)return;
          users.remove(getUser_ByID(userID));
    }
    void addUser(User_Details user){//add user
          users.add(user);
    }
    int getSize(){
          return users.size();
    }



}
