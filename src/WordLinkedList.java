
public class WordLinkedList {
	private Word head;
	private Word sorted;
	
	public WordLinkedList() {
		head = null;
	}
	
	public WordLinkedList(Word word) {
		head = word;
	}
	
	public Word getHead() {
		return head;
	}
	
	public void insertToEndOfList (Word s){
		Word cursor = head; 
		if (head==null) {
			head=s;
			return;
		}
		while (cursor.getNext() != null)
			cursor = cursor.getNext();
		cursor.setNext(s);
	}
	
	public void printLinkedList (){
		Word cursor = head;
		if (head==null)
			return;
		while (cursor!=null) {
			System.out.println(cursor.toString());
			cursor=cursor.getNext();
		}
	}
	
	void insertionSort() {  //Code supplied by geeksforgeeks 
        // Initialize sorted linked list 
        sorted = null; 
        Word current = head; 
        // Traverse the given linked list and insert every 
        // node to sorted 
        while (current != null)  
        { 
            // Store next for next iteration 
            Word next = current.getNext(); 
            // insert current in sorted linked list 
            sortedInsert(current); 
            // Update current 
            current = next; 
        } 
        // Update head_ref to point to sorted linked list 
        head = sorted; 
    }
	
	void sortedInsert(Word newnode) { 
        /* Special case for the head end */
        if (sorted == null || sorted.getOriginalWord().compareToIgnoreCase(newnode.getOriginalWord()) >= 0)  
        { 
            newnode.setNext(sorted); 
            sorted = newnode; 
        } 
        else 
        { 
            Word current = sorted; 
            /* Locate the node before the point of insertion */
            while (current.getNext() != null && current.getNext().getOriginalWord().compareToIgnoreCase(newnode.getOriginalWord()) < 0)  
            { 
                current = current.getNext(); 
            } 
            newnode.setNext(current.getNext()); 
            current.setNext(newnode); 
        } 
    } 
	
	@Override
	public String toString() {
		Word cursor = head;
		String temp = "";
		if (head==null)
			return "";
		while (cursor!=null) {
			temp += cursor.toString()+", ";
			cursor=cursor.getNext();
		}
		return temp;
	}
	
	public static void main(String args[]) {
		WordLinkedList list = new WordLinkedList();
		list.insertToEndOfList(new Word("happy"));
		list.insertToEndOfList(new Word("car"));
		list.insertToEndOfList(new Word("zapper"));
		list.printLinkedList();
	}

}
