public class LList<T> { 
	// singly linked list with both head and tail
   	private Node<T> head;
	private Node<T> tail;

	// initialize the list to being an empty list
	public LList(){

	}
	
	// returns the first node in the list
	// O(1)
	public Node<T> getFirst() {

	}

	// inserts a new node with value T at the begining of the list
	// O(1)
	public void insertFirst(T value) {


	}
	
	// inserts a new node with value T at the begining of the list
	// O(1)
	public void insertFirst(Node<T> newNode) {
		
	}

	// inserts a new node with value T at the end of the list
	// O(1)
	public void insertLast(Node<T> newNode) {		
	
	}

	// remove and return the first node in the list
	// O(1)
	public Node<T> removeFirst()
	{
	}
	
	// return a string representing the values in the list seperated by a single space
	// O(n)
	// Warning: concatenating String objects will yield a O(n^2) solution
	public String listToString() {  

	}

	

	public static void main(String[] args) {
		class SomeType {
			private int value;

			public SomeType(int value) { this.value = value; }
			public String toString() { return "" + value; }
			public boolean equals(Object o) {
				if (!(o instanceof SomeType)) return false;
				return ((SomeType)o).value == value;
			}	
		}
		
		SomeType item1 = new SomeType(100);
		SomeType item2 = new SomeType(200);
		SomeType item3 = new SomeType(300);
		SomeType item4 = new SomeType(400);
		Node<SomeType> n5 = new Node<>(new SomeType(500));
		
		LList<SomeType> list = new LList<>();
		list.insertFirst(item1);
		list.insertFirst(item2);
		list.insertFirst(item3);
		list.insertFirst(item4);		

		if (list.listToString().equals("400 300 200 100")) {
			System.out.println("Yay1");
		}

		list.insertLast(n5);	
		if (list.listToString().equals("400 300 200 100 500")) {
			System.out.println("Yay2");
		}

		list.removeFirst();	
		if (list.listToString().equals("300 200 100 500")) {
			System.out.println("Yay3");
		}

		if (list.getFirst().getValue().toString().equals("300")) {
			System.out.println("Yay4");
		}
		
		list.insertFirst(new SomeType(600));	
		if (list.listToString().equals("600 300 200 100 500")) {
			System.out.println("Yay5");
		}		



	}
}