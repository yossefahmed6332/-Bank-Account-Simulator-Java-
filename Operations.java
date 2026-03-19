
class Operations{





    static String withdraw(double amount,User_Details user,String PIN){
        if(!Security.CheckPIN(PIN,user)){
            return "Invalid PIN";
        }
        if(Security.check_Withdraw(amount,user.getBalance())){
            user.decrease(amount);
            Transaction transaction=new Transaction("Withdrawal",amount,user);
            user.AddTransaction(transaction);
            return"Success withdrawal";
        }
        return"Invalid operation";
    }

    static String deposit (double amount,User_Details user,String PIN){
        if(!Security.CheckPIN(PIN,user)){
            return"Invalid PIN";
        }
        if(Security.check_Deposit(amount)){
            user.increase(amount);
            Transaction transaction=new Transaction("deposit",amount,user);
            user.AddTransaction(transaction);
            return"Success deposit";
        }
        return"Invalid operation";
    }

    static String transfer(double amount, User_Details usersend, String receive_AccNum, String PIN, UsersRepo repo) {

        if (!Security.CheckPIN(PIN, usersend)) {
            return "Invalid PIN";
        }

        User_Details reference = repo.getUser_ByAccountnumber(receive_AccNum);

        if (!Security.transfer(usersend, reference, amount)) {
            return "Invalid operation";
        }

        // sender
        usersend.decrease(amount);
        Transaction transaction = new Transaction("Transfer 'send'", amount, usersend);
        usersend.AddTransaction(transaction);

        // receiver
        reference.increase(amount);
        Transaction transaction2 = new Transaction("Transfer 'receive'", amount, reference);
        reference.AddTransaction(transaction2);

        return "Success transfer";
    }






}

