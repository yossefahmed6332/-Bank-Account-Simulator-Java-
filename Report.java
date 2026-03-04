public class Report {
    private  Operations operation;//declare new object
    private   User_Details user;
    public Report(Operations operation,User_Details user){//call refrence original oblect's data
        this.operation=operation;
        this.user=user;
    }
    public   void getInfo(){
        System.out.println("Account Number: "+user.getAccount_number());
        System.out.println("Username: "+user.getUsername());
        System.out.println("Password: ***** ");
        System.out.println("Email: "+user.getEmail());
    }

    public  void ShowOperations(){
        for(int i=0;i<operation.getOperations().size();i++){
            System.out.print(operation.getOperations().get(i)+" ");//user get operations
        }
    }
    public void ShowValues(){
        for (int i=0; i<operation.getValues().size();i++){
            System.out.println(operation.getValues().get(i)+" ");//get values
        }}

}

class Show_DetailsAfterregisteration {
    private  User_Details user;
    public Show_DetailsAfterregisteration(User_Details user){
        this.user=user;
    }
    public void getDetails(){
        System.out.println("Your ID: "+user.getID());
        System.out.println("Your PIN: "+user.getPIN());
        System.out.println("Your Email: "+user.getEmail());
        System.out.println("Your Account Number: "+user.getAccount_number());
        System.out.println("Your Password: "+user.getPassword());
    }
}
