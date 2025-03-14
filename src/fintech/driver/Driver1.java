package fintech.driver;

import fintech.model.Account;
import fintech.model.Transaction;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver1 {
    public static void main(String[] _args) {
        Scanner sc = new Scanner(System.in);
        List<Account> accounts = new ArrayList<>();
        List<Transaction> transactions = new ArrayList<>();

        while (sc.hasNextLine()) {
            String[] input = sc.nextLine().split("#");
            String command = input[0];
            
            if ("create-account".equals(command)) {
                String owner = input[1];
                String accountName = input[2];
                Account newAccount = new Account(owner, accountName, 0.0);
                accounts.add(newAccount);
                System.out.println(newAccount);
            } 
            else if ("create-transaction".equals(command)) {
                String accountName = input[1];
                double amount = Double.parseDouble(input[2]);
                String postedAt = input[3];
                String note = input[4];
                
                Account targetAccount = null;
                for (Account acc : accounts) {
                    if (acc.getAccountName().equals(accountName)) {
                        targetAccount = acc;
                        break;
                    }
                }
                
                if (targetAccount == null) {
                    System.out.println("Account not found");
                    continue;
                }

                if (targetAccount.updateBalance(amount)) {
                    Transaction newTransaction = new Transaction(accountName, amount, postedAt, note);
                    transactions.add(newTransaction);
                    System.out.println(newTransaction);
                }
            } 
            else if ("show-account".equals(command)) {
                String accountName = input[1];
                for (Account acc : accounts) {
                    if (acc.getAccountName().equals(accountName)) {
                        System.out.println(acc);
                        break;
                    }
                }
            } 
            else {
                System.out.println("Unknown command");
            }
        }
        sc.close();
    }
}
