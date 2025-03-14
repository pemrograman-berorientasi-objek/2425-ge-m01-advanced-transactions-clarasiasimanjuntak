// 12S23019_clarasia l. simanjuntak
// 12S23043_grage tiodora

package fintech.model;

public class Account {
    private final String owner;
    private final String accountname;
    private  double balance;

    public Account(String owner, String accountname, double balance) {
        this.owner = owner;
        this.accountname = accountname;
        this.balance = balance;
    }
    
    public String getAccountName() {
        return accountname;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public String getOwner() {
        return owner;
    }
    
    public boolean updateBalance(double amount) {
        if (balance + amount < 0) {
            return false; // Prevent negative balance
        }
        balance += amount;
        return true;
    }

    @Override
    public String toString() {
        return accountname + "|" + owner + "|" + String.format("%.1f", balance);
    }
}