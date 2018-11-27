
public class WordLinkedList {
	private Word head;
	
	public WordLinkedList() {
		head = null;
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
//	public void insertInOrder (Word s){
//		if (head==null) {
//			head = s;
//			return;
//		}
//		if (search(s.getId())!=null)
//			return;
//		Student current = head, prev = head;
//		while (current!=null) {
//			if (current.getId()<s.getId()) {
//				prev=current;
//				current=current.getNext();
//				if(current==null) {
//					prev.setNext(s);// not using insertToEndOfList method here since it would be simpler to just do prev.setnext
//					return;
//				}
//			}
//			else if(current == head) {
//				insertToFrontOfList(s);
//				return;
//				}
//			else {
//				s.setNext(current);
//				prev.setNext(s);
//				return;
//			}
//		}
//	}
	
	public void printLinkedList (){
		Word cursor = head;
		if (head==null)
			return;
		while (cursor!=null) {
			System.out.println(cursor.toString());
			cursor=cursor.getNext();
		}
	}
	public static void main(String args[]) {
		WordLinkedList list = new WordLinkedList();
		list.insertToEndOfList(new Word("happy"));
		list.insertToEndOfList(new Word("car"));
		list.insertToEndOfList(new Word("zapper"));
		list.printLinkedList();
	}

}
