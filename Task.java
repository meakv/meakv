package Multithread;

class Task extends Thread {
	
	private int number;

	public Task(int number) {
		this.number = number;
	}
	
	public void run() { //SIGNATURE
		System.out.print("\nTask " + number + " Started");
		
		for(int i=number*100;i<=number*100 + 99; i++) 
			System.out.print(i + " ");
		
		System.out.print("\nTask" + number +  "Done");
	}
}