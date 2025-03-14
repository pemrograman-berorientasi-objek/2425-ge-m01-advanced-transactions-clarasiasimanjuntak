// 12S23019_clarasia l. simanjuntak
// 12S23043_grage tiodora


package fintech.model;

public class Transaction {
    private static int counter = 1;
    
    private final int id;
    private final String accountName;
    private final double amount;
    private final String postedAt;
    private final String note;

    public Transaction(String accountName, double amount, String postedAt, String note) {
        this.id = counter++;
        this.accountName = accountName;
        this.amount = amount;
        this.postedAt = postedAt;
        this.note = (note.length() > 40) ? note.substring(0, 40) : note;
    }

    public String getAccountName() {
        return accountName;
    }
    
    public double getAmount() {
        return amount;
    }
    
    public String getPostedAt() {
        return postedAt;
    }
    
    public String getNote() {
        return note;
    }
    
    @Override
    public String toString() {
        return id + "|" + accountName + "|" + String.format("%.1f", amount) + "|" + postedAt + "|" + note;
    }
}