 class Operations{





        public void withdraw(double amount,Security sec,User_Details user){
            if(sec.check_Withdraw(amount,user.getBalance())){
                user.withdraw(amount,user);
                Transaction transaction=new Transaction("Withdrawal",amount,user);
                user.AddTransaction(transaction);
                return;
            }
            System.out.println("invalid operation");
            return;

        }

         void deposit(double amount,Security sec,User_Details user){
            if(sec.check_Deposit(amount,user.getBalance())){
                user.diposit(amount,user);
                Transaction transaction=new Transaction("Withdrawal",amount,user);
                user.AddTransaction(transaction);
                return;
            }
             System.out.println("invalid operation");
             return;
            }




    }

