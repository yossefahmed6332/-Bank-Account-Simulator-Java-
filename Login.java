public class Login {

    User_Details login_Byemail(String email, String password  ,UsersRepo rep) {
        for (User_Details user : rep.getUsers()) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return user;
            }
            System.out.println("Invalid email or Password");

        }
        return null;
    }


    User_Details login_ByuserName( String password,String username,UsersRepo rep){
        for (User_Details user : rep.getUsers()) {
            if (user.getUserName().equals(username) && user.getPassword().equals(password)) return user;
        }
        System.out.println("Invalid Username or Password");
        return null;
    }

}

