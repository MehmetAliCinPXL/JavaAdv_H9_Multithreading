package be.pxl.ja.oefening3;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BankAccount {
	private int balance;
	private String accountNumber;
	private BufferedWriter logger;
	
	public BankAccount(String accountNumber, int initialBalance, BufferedWriter logger) {
		this.accountNumber = accountNumber;
		this.balance = initialBalance;
		this.logger = logger;
	}
	
	public void deposit(int amount, String user) {
		// TODO
		balance += amount;
		try {
			logger.write((user + " has deposited " + amount + " | balance: " + getBalance()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void withdraw(int amount, String user) {
		// TODO
		if(!(getBalance() - amount < 0)){
			balance -= amount;
			try {
				logger.write((user + " has withdrawn " + amount + " | balance left: " + getBalance()));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public double getBalance() {
		return balance;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}

	static class Gebruiker extends Thread{
		String naam;
		int amount;
		BankAccount bankAccount;
		String deposit;

		Gebruiker(String naam, int amount, BankAccount bankAccount,  String deposit){
			this.naam = naam;
			this.amount = amount;
			this.bankAccount = bankAccount;
			this.deposit = deposit;
		}

		@Override
		public void run(){
			if (deposit.equals("j")){
				bankAccount.withdraw(amount, naam);
			}else {
				bankAccount.deposit(amount, naam);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedWriter logger = Files.newBufferedWriter(Paths.get("resources/bank.txt"));
		BankAccount rekening = new BankAccount("BE 6703 4444", 500, logger);
		int aantalTransacties = 3;
		Gebruiker bill = new Gebruiker("bill gates", 100, rekening,"n");
		Gebruiker jeff = new Gebruiker("jeff bezos", 100, rekening, "n");
		Gebruiker donald = new Gebruiker("Donald Trump", 200, rekening, "j");

		bill.start();
		jeff.start();
		donald.start();
	}
}