
    class Operations{





        public void withdraw(double amount,Security sec,User_Details user,String PIN){
            if(!sec.CheckPIN(PIN,user))return;
            if(sec.check_Withdraw(amount,user.getBalance())){
                user.decrease(amount);
                Transaction transaction=new Transaction("Withdrawal",amount,user);
                user.AddTransaction(transaction);
                return;
            }
            System.out.println("invalid operation");
            return;
        }

         void deposit (double amount,Security sec,User_Details user,String PIN){
             if(!sec.CheckPIN(PIN,user))return;
             if(sec.check_Deposit(amount)){
                user.increase(amount);
                Transaction transaction=new Transaction("deposit",amount,user);
                user.AddTransaction(transaction);
                return;
            }
             System.out.println("invalid operation");
             return;
            }

         void transfer(double amount,Security sec,User_Details usersend,String receive_AccNum,String PIN,UsersRepo repo){
             //user send
            if(!sec.CheckPIN(PIN,usersend))return;
            Transaction transaction=new Transaction("Transfer \'send\'",amount,usersend);
            usersend.AddTransaction(transaction);
            usersend.decrease(amount);
            //user receives
             User_Details reference=repo.GetUser_Accountnumber(receive_AccNum);
             Transaction transaction2=new Transaction("Transfer \'receive\'",amount,reference);
             reference.AddTransaction(transaction2);
             usersend.increase(amount);
         }






    }

