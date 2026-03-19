public class Login {

    static User_Details login_Byemail(String email, String password  ,UsersRepo rep) {
        for (User_Details user : rep.getUsers()) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return user;
            }

        }
        return null;
    }


    static User_Details login_ByuserName(String username, String password, UsersRepo rep) {
        for (User_Details user : rep.getUsers()) {
            if (user.getUserName().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

}

