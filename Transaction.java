import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Transaction {
    private final String type;
    private final double amount;
    private final LocalDateTime date;
    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.date = LocalDateTime.now();
    }
    @Override
    public String toString() {
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        return type + " : " + amount + " on " + date.format(formatter);
    }
}