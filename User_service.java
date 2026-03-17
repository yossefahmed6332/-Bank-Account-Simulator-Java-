  import java.util.Scanner;

     class User_service {
        //change methods
         static void ChangePassword(User_Details user , String oldpassword,String newPassword,Security sec){
            if(!sec.CheckPassword(oldpassword,user)){
                System.out.println("Wrong password");
                return;
            }
            user.setPassword(newPassword);
        }

         static void ChangeUsername(User_Details user,String new_username,String oldpassword,Security sec) {
            if(!sec.CheckPassword(oldpassword,user)){
                System.out.println("Wrong password");
                return;
            }
            user.setUserName(new_username);
        }

        static void ChangeEmail(User_Details user,String NewEmail,String OldPassword,Security sec) {
            if(!sec.CheckPassword(OldPassword,user)){
                System.out.println("Wrong password");
                return;
            }
            user.setEmail(NewEmail);
        }
        static void ChangePIN(User_Details user,String PIN,String oldpassword,Security sec) {
            if(!sec.CheckPassword(oldpassword,user)){
                System.out.println("Wrong password");
                return;
            }
            user.setPIN(PIN);
        }


        //Create account num

         static String CreateAccountnum(Security sec,UsersRepo repo){
            String accountnum="";
            for(int i =0 ; i<13; i++){
                double num=(Math.random()*10);
                int numInt=(int)num;
                accountnum+=numInt;
            }
            if(!sec.Repeated(accountnum,repo))return accountnum;
            return CreateAccountnum(sec,repo);
        }
        //Create PIN
         static String CreatePIN(Security sec,UsersRepo repo){
            String PIN="";
            for(int i =0 ; i<6; i++){
                double num=(Math.random()*10);
                int numInt=(int)num;
                PIN+=numInt;
            }
            if(!sec.Repeated(PIN,repo))return PIN;
            return CreatePIN(sec,repo);
        }

         static String CreateID(Security sec,UsersRepo repo) {
            String ID = "";
            for (int i = 0; i < 6; i++) {
                double num = (Math.random() * 10);
                int numInt = (int) num;
                ID += numInt;
            }
            if(!sec.Repeated(ID,repo))return ID;
            return CreateID(sec,repo);
        }
         String ShowData(User_Details user){
            return "ID: "+user.getID()+ " Email: "+user.getEmail()+" Account number: "+user.getAccount_number();
        }


         static User_Details CreateUser(String user_name,String email,String password,User_service userService,Security sec,User user,UsersRepo repo){
            System.out.println("Welcome to Bank account simulator,In first enter your data");
            System.out.println("Enter username");
            System.out.println("Enter email");
            System.out.println("Enter password");
            User_Details newUser=new User_Details(userService.CreateAccountnum(sec,repo),userService.CreatePIN(sec,repo),userService.CreateID(sec,repo)
                    ,email,password,user_name);
             repo.addUser(newUser);
            return newUser;

    }

    static void getTransactions(User_Details user){
             user.getTransactions();

    }


}
