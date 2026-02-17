
public class SLLTest {


	public static void main( String[] args) {

		SLL<String> list = new SLL<String>();

		list.addHead("Hector");
		list.addHead("Grizzly");
		list.addHead("Prairie");
		list.addHead("The Wedge");
		list.addHead("Loder");
		list.addHead("Heart");

		list.printList();
		list.swap();
		list.printList();
	
	
	
	}

}

