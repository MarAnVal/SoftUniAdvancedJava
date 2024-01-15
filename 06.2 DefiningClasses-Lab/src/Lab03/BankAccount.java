package Lab03;

public class BankAccount {
    private static final double DEFAULT_INTEREST_RATE = 0.02;
    private static double interestRate = DEFAULT_INTEREST_RATE;
    private static int countId = 0;
    private int id;
    private double balance;

    public BankAccount() {
        this.id = countId + 1;
        countId++;
        this.balance = 0;
    }

    public static double getInterestRate() {
        return interestRate;
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public double getInterest(int years) {
        return this.balance * interestRate * years;
    }

    public void deposit(double balance) {
        this.balance += balance;
    }

    public static void setInterestRate(double interest) {
        interestRate = interest;
    }

}
