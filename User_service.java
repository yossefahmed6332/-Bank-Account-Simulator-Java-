  import java.util.Scanner;

    public class User_service {
        //change password
         void ChangePassword(User_Details user , String oldpassword,String newPassword,Security sec){
            if(!sec.CheckPassword(oldpassword,user)){
                System.out.println("Wrong password");
                return;
            }
            user.setPassword(newPassword);
        }

         void ChangeUsername(User_Details user,String new_username,String oldpassword,Security sec) {
            if(!sec.CheckPassword(oldpassword,user)){
                System.out.println("Wrong password");
                return;
            }
            user.setUsername(new_username);
        }

         void ChangeEmail(User_Details user,String NewEmail,String OldPassword,Security sec) {
            if(!sec.CheckPassword(OldPassword,user)){
                System.out.println("Wrong password");
                return;
            }
            user.setEmail(NewEmail);
        }
         void ChangePIN(User_Details user,String PIN,String oldpassword,Security sec) {
            if(!sec.CheckPassword(oldpassword,user)){
                System.out.println("Wrong password");
                return;
            }
            user.setPIN(PIN);
        }


        //Create account num

         String CreateAccountnum(Security sec,UsersRepo repo){
            String accountnum="";
            for(int i =0 ; i<6; i++){
                double num=(Math.random()*10);
                int numInt=(int)num;
                accountnum+=numInt;
            }
            if(!sec.Repeated(accountnum,repo))return accountnum;
            return CreateAccountnum(sec,repo);
        }
        //Create PIN
         String CreatePIN(Security sec,UsersRepo repo){
            String PIN="";
            for(int i =0 ; i<3; i++){
                double num=(Math.random()*10);
                int numInt=(int)num;
                PIN+=numInt;
            }
            if(!sec.Repeated(PIN,repo))return PIN;
            return CreatePIN(sec,repo);
        }

         String CreateID(Security sec,UsersRepo repo) {
            String ID = "";
            for (int i = 0; i < 3; i++) {
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


         User_Details CreateUser(Scanner sc,User_service userService,Security sec,UsersRepo repository,UsersRepo repo){
            System.out.println("Welcome to Bank account simulator,In first enter your data");
            System.out.println("Enter username");
            String user_name=sc.next();
            System.out.println("Enter email");
            String email=sc.next();
            System.out.println("Enter password");
            String password=sc.next();
            User_Details newUser=new User_Details(user_name,password,email,
                    userService.CreateAccountnum(sec,repo),userService.CreateID(sec,repo),userService.CreatePIN(sec,repo));
            repository.addUser(newUser);
            return newUser;

    }



}
