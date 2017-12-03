package v1.ch14.unsynch;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
	private final double[] accounts;
	private Lock bankLock = new ReentrantLock();
	private Condition condition;

	public Bank(int n, double initialBalance) {
		accounts = new double[n];
		for (int i = 0; i < accounts.length; i++) {
			accounts[i] = initialBalance;
		}
		condition = bankLock.newCondition();
	}

/*	public void transfer(int from, int to, double amount) {
		bankLock.lock();
		try {
			// if(accounts[from]<amount)return;
			System.out.printf("%10.2f from %d to %d", amount, from, to);
			if (accounts[from] < amount) {
				System.out.println("condition.await()");
				condition.await();
			}
			;
			System.out.print(Thread.currentThread());
			accounts[from] -= amount;
			Thread.sleep(100);
			accounts[to] += amount;
			condition.signalAll();
			System.out.printf("toal balance %10.2f%n", getTotalBalance());
		} catch (InterruptedException e) {
		} finally {
			bankLock.unlock();
		}
	}*/

	public synchronized void transfer(int from, int to, double amount) {
		try {
			// if(accounts[from]<amount)return;
			System.out.printf("%10.2f from %d to %d", amount, from, to);
			if (accounts[from] < amount) {
				System.out.println("condition.await()");
				wait();
			}
			System.out.print(Thread.currentThread());
			accounts[from] -= amount;
			Thread.sleep(100);
			accounts[to] += amount;
			notifyAll();
			System.out.printf("toal balance %10.2f%n", getTotalBalance());
		} catch (InterruptedException e) {}
	}
	
	private Object getTotalBalance() {
		double sum = 0;
		for (double d : accounts) {
			sum += d;
		}
		return sum;
	}

	public int size() {
		return accounts.length;
	}
}
