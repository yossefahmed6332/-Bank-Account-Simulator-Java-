      import java.util.Scanner;

     class User_service {
        //change methods

         //change password take password ,new password and  user
         static void ChangePassword(User_Details user , String oldpassword,String newPassword){
            if(!Security.CheckPassword(oldpassword,user)){//security , if wrong don't change password and return
                return;
            }
            user.setPassword(newPassword);
        }

         //change username take password ,new password and  user
         static void ChangeUsername(User_Details user,String new_username,String oldpassword) {
            if(!Security.CheckPassword(oldpassword,user)){//security , if wrong don't change password and return
                return;
            }
            user.setUserName(new_username);
        }

         //change email take password ,new password and  user
         static void ChangeEmail(User_Details user,String NewEmail,String OldPassword) {
            if(!Security.CheckPassword(OldPassword,user)){//security , if wrong don't change password and return
                return;
            }
            user.setEmail(NewEmail);
        }

         //change PIN take password ,new password and  user
         static void ChangePIN(User_Details user,String PIN,String oldpassword) {
            if(!Security.CheckPassword(oldpassword,user)){//security , if wrong don't change password and return
                return;
            }
            user.setPIN(PIN);
        }


        //Create account num

         static String CreateAccountnum(UsersRepo repo){
             String accountnum;
             do{
             accountnum="";
            for(int i =0 ; i<13; i++){
                double num=(Math.random()*10);
                int numInt=(int)num;
                accountnum+= numInt;
            }
             
             }while (Security.Repeated_Accnum(accountnum,repo));
            return accountnum;
        }
        //Create PIN

         //create PIN for user
         static String CreatePIN(UsersRepo repo){
             String PIN;
             do{
             PIN="";//set initial value for PIN
            for(int i =0 ; i<6; i++){//every loop add one more number , total numbers is 7
                double num=(Math.random()*10);//Create random for 0 to .9 and multiply by 10
                int numInt=(int)num;//turn it to integer , clean .00
                PIN+=numInt;//add number to PIN
            }
             }while(Security.Repeated_Accnum(PIN,repo));

            return PIN;//check if PIN is equal to another user PIN ,if recreate PIN
        }

         static String CreateID(UsersRepo repo) {
             String ID;
             do{
               ID = "";
               for (int i = 0; i < 6; i++) {
                 double num = (Math.random() * 10);
                 int numInt = (int) num;
                 ID+= numInt;
                }
             }while(Security.Repeated_ID(ID,repo));
             return ID;

        }
         String ShowData(User_Details user){
            return "ID: "+user.getID()+ " Email: "+user.getEmail()+" Account number: "+user.getAccount_number();
        }


         static User_Details CreateUser(String user_name,String email,String password,UsersRepo repo){
             if(Security.Repeated_Username(user_name,repo)){//check if username is repeated
                 return null;
             }
             if(Security.Repeated_Email(email,repo)){//check if email is repeated
                 return null;
             }
            User_Details newUser=new User_Details(User_service.CreateAccountnum(repo),User_service.CreatePIN(repo),User_service.CreateID(repo)
                    ,email,password,user_name);
             repo.addUser(newUser);
            return newUser;

    }

    static void getTransactions(User_Details user){
             user.getTransactions();

    }


}
