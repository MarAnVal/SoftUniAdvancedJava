package Lab03;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        Map<Integer, BankAccount> accounts = new HashMap<>();
        while (!line.equals("End")) {
            String[] commandsArr = line.split("\\s+");
            String result = "Account does not exist";
            switch (commandsArr[0]) {
                case "Create":
                    BankAccount account = new BankAccount();
                    accounts.put(account.getId(), account);
                    result = String.format("Account ID%d created", account.getId());
                    break;
                case "Deposit":
                    int accountIdDeposit = Integer.parseInt(commandsArr[1]);
                    double sumDeposit = Double.parseDouble(commandsArr[2]);
                    BankAccount accountDeposit = accounts.get(accountIdDeposit);
                    if (accountDeposit != null) {
                        accountDeposit.deposit(sumDeposit);
                        result = String.format("Deposited %s to ID%d", commandsArr[2], accountIdDeposit);
                    }
                    break;
                case "SetInterest":
                    double newInterest = Double.parseDouble(commandsArr[1]);
                    BankAccount.setInterestRate(newInterest);
                    result = "";
                    break;
                case "GetInterest":
                    int accountIdInterest = Integer.parseInt(commandsArr[1]);
                    int interestYears = Integer.parseInt(commandsArr[2]);
                    BankAccount accountInterest = accounts.get(accountIdInterest);
                    if (accountInterest != null) {
                        result = String.format("%.2f", accountInterest.getInterest(interestYears));
                    }
                    break;
            }
            if (result.length() > 0) {
                System.out.println(result);
            }
            line = input.nextLine();
        }
    }
}