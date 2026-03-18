import java.util.ArrayList;

class Operations{





    static void withdraw(double amount,User_Details user,String PIN){
        if(!Security.CheckPIN(PIN,user)){
            return;
        }
        if(Security.check_Withdraw(amount,user.getBalance())){
            user.decrease(amount);
            Transaction transaction=new Transaction("Withdrawal",amount,user);
            user.AddTransaction(transaction);
            return;
        }
        return;
    }

    static void deposit (double amount,User_Details user,String PIN){
        if(!Security.CheckPIN(PIN,user)){
            return;
        }
        if(Security.check_Deposit(amount)){
            user.increase(amount);
            Transaction transaction=new Transaction("deposit",amount,user);
            user.AddTransaction(transaction);
            return;
        }
        return;
    }

    static void transfer(double amount,User_Details usersend,String receive_AccNum,String PIN,UsersRepo repo){
        //user send operations
        if(!Security.CheckPIN(PIN,usersend))return;//check PIN

        Transaction transaction=new Transaction("Transfer \'send\'",amount,usersend);
        usersend.AddTransaction(transaction);
        usersend.decrease(amount);


        //user received operations
        User_Details reference=repo.getUser_ByAccountnumber(receive_AccNum);
        if(!Security.transfer(usersend,reference,amount))return;//check


        Transaction transaction2=new Transaction("Transfer \'receive\'",amount,reference);
        reference.AddTransaction(transaction2);
        reference.increase(amount);
    }






}

