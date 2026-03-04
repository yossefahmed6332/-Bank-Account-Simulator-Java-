import java.util.ArrayList;

class User_Details{
        //variables have values of object "user"
        private String username;
        private String password;
        private String email;
        private String account_number;
        private String ID;
        private String PIN;
        static ArrayList<User_Details> Users = new ArrayList<>();

    //using constractor to initial user details
        public User_Details(String username,String password,String email,String account_number,String Id,String PIN){//dafault set , all is uknown
            this.username = username;
            this.password = password;
            this.email = email;
            this.account_number = account_number;
            this.ID = Id;
            this.PIN = PIN;
        }
        public User_Details() {
            this.PIN = "5005054";
        }



        public void setUsername(String username) {// set user name

            this.username=username;
            System.out.println("User name changed successfully");

        }
        public void setPassword(String newpassword) {//set password with validation
            this.password=newpassword;
            System.out.println("password changed successfully");

        }
        public void setEmail(String email ) {//set new email with validation

            this.email=email;
            System.out.println("email changed successfully");


        }
        public void setPIN(String PIN) {//set PIN

            this.PIN = PIN;
            System.out.println("PIN changed successfully");

        }
        //methods to return details
        public String getUsername() {
            return username;
        }
        public String getPassword() {
            return password;
        }
        public String getEmail() {
            return email;
        }
        public String getAccount_number() {
            return account_number;
        }
        public String getPIN() {
            return PIN;

        }
        public String getID() {
            return ID;
        }


}
