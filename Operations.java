import java.util.ArrayList;

class Operations{
    private ArrayList<Double> Values;
    private ArrayList<String> Operations;
    private double balance ;

    public Operations(){//set all elements as null or zero
        balance=0;
        Values=new ArrayList<>();
        Operations=new ArrayList<>();
    }


    public boolean check_withdraw(double amount){
        if(amount>balance){//if user amount more than balance
            System.out.println("You can't withdraw more than your Balance");
            return false;
        }
        else if(amount<=0){//if user amount less than 0
            System.out.println("You can't withdraw less than or equal 0");
            return false;
        }
        return true;
    }

    public void withdraw(double amount){
        if(!check_withdraw(amount)){
            System.out.print(" operation failed");
        }
        else {
            this.balance -=amount;
            Operations.add("Withdraw");
            Values.add(amount);
            System.out.println("withdraw successfully");
        }

    }
    public boolean check_diposite(double amount){

        if(amount<=0){
            System.out.println("You can't diposite less than or equal 0");
            return false;
        }
        else
            return true;
    }

    public void deposit(double amount){

        if (!check_diposite(amount)){
            System.out.print(" operation failed");
        }
        else{
            this.balance +=amount;
            Operations.add("Deposit");
            Values.add(amount);
            System.out.println("diposit successfully");
        }
        System.out.println("Balance is "+this.balance);
    }


    public String getBalance(){//if user want to see balance
        return String.valueOf(balance);

    }
    public ArrayList<String> getOperations(){//method to get operations
        return Operations;
    }
    public ArrayList<Double> getValues(){//method to get values
        return Values;
    }

}
