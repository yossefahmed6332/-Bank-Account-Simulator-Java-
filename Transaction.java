import java.time.LocalDateTime;

public class Transaction {
    private String ID;
    private String operation;
    private Double amount;
    private LocalDateTime time;
    public Transaction( String operation, Double amount,User_Details user) {
        user.newTransaction();
        this.ID =user.getID()+user.getNumOFtransactions();
        this.operation = operation;
        this.amount = amount;
        this.time = LocalDateTime.now();
    }

    String showDetails(){
        return "Year "+time.getYear()+"Month "+time.getMonth()+"Day "+time.getDayOfMonth()+
                "Time "+time.getHour()+":"+time.getMinute()+":"+time.getSecond();
    }

}


