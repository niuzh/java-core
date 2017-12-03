package v1.ch14.unsynch;

public class TransferRunnable implements Runnable{
	private Bank bank;
	private int fromAccount;
	private double maxAmount;
	private int delay=100;
	public TransferRunnable(Bank bank,int from, double max) {
		this.bank=bank;
		fromAccount=from;
		this.maxAmount=max;
	}
	public void run() {
		try {
			while (true) {
				int toAccount=(int)(bank.size()*Math.random());
				double amount=maxAmount*Math.random();
				bank.transfer(toAccount, toAccount, amount);
				Thread.sleep((int)(delay*Math.random()));
			}
		} catch (InterruptedException e) {
		}
	}
}
