public class BankAccount {

	private double balance;

	public synchronized void credit(double amount){
		balance = balance + amount;
		System.out.println(balance);
		notify();
	}

	public synchronized void debit(double amount){
		if(balance < amount) {
            try {
				System.out.println("Venter...");
                wait();
				if (balance-amount >= 0){
					balance = balance-amount;
					System.out.println("Hæver");
				}
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }else{
			balance = balance - amount;
			System.out.println(balance);
		}
	}


	public double getBalance() {
		return balance;
	}
}
