import java.util.Scanner;

public class PayMoney {

	int numTransactions;
	int numTargets;
	int transactionArray[];
	Scanner sc;
	
	public PayMoney() {
		sc = new Scanner(System.in);
	}
	
	public void InputNoOfTransactions() {
		System.out.println("enter the size of transaction array"); 
		this.numTransactions = sc.nextInt();
		this.transactionArray = new int[this.numTransactions];
	}
	
	public void InputTransactions() {
		System.out.println("enter the values of array");
		for(int i=0;i<this.transactionArray.length;i++) {
			this.transactionArray[i] = sc.nextInt();
		}
	}
	
	public void InputTargets() {
		System.out.println("enter the total no of targets that needs to be achieved");
		this.numTargets = sc.nextInt();
		int i=0;
		while(i<this.numTargets) {
			System.out.println("enter the value of target");
			int target = sc.nextInt();
			checkTarget(target);
			i++;
		}
	}
	
	private void checkTarget(int target) {
		int sum = 0;
		for(int i=0;i<this.transactionArray.length;i++) {
			sum = sum + this.transactionArray[i];
			if(sum>=target) {
				int transactions = i+1;
				System.out.println("Target achieved after " + transactions + " transactions");
				return;
			}
		}
		System.out.println("Given target is not achieved");
	}
	
	public void run() {
		this.InputNoOfTransactions();
		this.InputTransactions();
		this.InputTargets();
	}
}
