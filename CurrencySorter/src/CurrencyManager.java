import java.util.Scanner;

public class CurrencyManager {

	private int numDenominations;
	private int denominations[];
	private int amount;
	private Scanner sc;
	private MergeSort mergeSortObj;
	
	public CurrencyManager() {
		sc = new Scanner(System.in);
		mergeSortObj = new MergeSort();
	}
	
	private void InputNoOfDenominations() {
		System.out.println("enter the size of currency denominations");
		this.numDenominations = sc.nextInt();
		this.denominations = new int[this.numDenominations];
	}
	
	private void inputDenominations() {
		System.out.println("enter the currency denominations value");
		for(int i=0;i<this.denominations.length;i++) {
			this.denominations[i] = sc.nextInt();
		}
		
		this.mergeSortObj.sort(this.denominations, 0,this.numDenominations-1);
	}
	
	private void InputAmount() {
		System.out.println("enter the amount you want to pay");
		this.amount = sc.nextInt();
	}
	
	private void CalculateRequiredDenominations() {
		Integer[] tempArray = new Integer[this.numDenominations]; 
		for(int i=0;i<this.denominations.length;i++) {
			tempArray[i] = this.amount/this.denominations[i];;
			amount = amount%this.denominations[i];
		}
		if(amount==0)
			this.GetRequiredDenominations(tempArray);
		else
			System.out.println("It is not possible to pay the amount in given denominations");
		
	}
	public void Run() {
		this.InputNoOfDenominations();
		this.inputDenominations();
		this.InputAmount();
		this.CalculateRequiredDenominations();
	}
	
	  private void GetRequiredDenominations(Integer[] tempArray) {
	  
		    System.out.println("Your payment approach in order to give min no of notes will be");
			for(int i=0;i<this.numDenominations;i++) {
				if(tempArray[i]>0)
					System.out.println(this.denominations[i] + ":" + tempArray[i]);
			}
	  }
	 
}



