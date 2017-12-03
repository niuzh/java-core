package v1.ch14.unsynch;

public class UnsynchBankTest {
	public static final int nAccounts = 10;
	public static final double initialBalance = 100;

	public static void main(String[] args) {
		Bank bank = new Bank(nAccounts, initialBalance);
		int i;
		for (i = 0; i < nAccounts; i++) {
			TransferRunnable runnable = new TransferRunnable(bank, i, initialBalance);
			Thread thread = new Thread(runnable);
			thread.start();
		}
	}

}
