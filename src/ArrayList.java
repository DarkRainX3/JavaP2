
public class ArrayList {
	
	private WordLinkedList [] array;
	
	public ArrayList(int size){
		if (size > 0)
			array = new WordLinkedList [size];
	}
	
	public ArrayList() {
	}

	public void addElement (WordLinkedList x) {
		if (array == null) {
			array = new WordLinkedList [1];
			array[0] = x;
		}
		else {
			WordLinkedList [] temp = new WordLinkedList [array.length+1];
			for (int i = 0; i<array.length; i++) {
				temp [i] = array [i];
			}
			temp[array.length] = x;
			array = temp;
		}
	}
	public void insertAt (int y, WordLinkedList x) {
		if (y < 0 || y > array.length) {
			System.out.println("Error insertAt index out of bounds, array not changed.");
			return;
		}
		WordLinkedList [] temp = new WordLinkedList [array.length+1];
		for (int i = 0; i<y; i++) {
			temp [i] = array [i];
		}
		temp[y] = x;
		for (int i = array.length-1; i>y-1; i--) 
			temp [i+1] = array [i];
		array = temp;
	}
	
	public void removeAt (int x) {
		if (x < 0 || x >= array.length) {
			System.out.println("\nError removeAt index out of bounds, array not changed.");
			return;
		}
		WordLinkedList [] temp = new WordLinkedList [array.length-1];
		for (int i = 0; i<x; i++) {
			temp [i] = array [i];
		}
		for (int i = array.length-1; i>x; i--) 
			temp [i-1] = array [i];
		array = temp;
	}
	
	public void resize (int length) {
		if (length == 0) {
			System.out.println("\nError cannot resize to 0, array not changed.");
			return;
		}
		WordLinkedList temp [] = new WordLinkedList [length];
		if (length > array.length) {
			for (int i = 0; i < array.length; i++) 
				temp [i] = array [i];
			array = temp;
		}
		else if (length < array.length) {
			for (int i = 0; i < temp.length; i++) 
				temp [i] = array [i];
			array = temp;
		}
	}
	public void printElements() {
		for (int i = 0; i<array.length; i++) {
			//System.out.print(array[i] + ", ");
			System.out.println(array[i].toString());
		}
	}
	public void sortEachElement() {
		for (int i =0; i<array.length;i++) {
			array[i].insertionSort();
		}
	}
	public WordLinkedList[] getArray() {
		return array;
	}
	
	
	
	
	
	
	
	/* This function takes last element as pivot, 
    places the pivot element at its correct 
    position in sorted array, and places all 
    smaller (smaller than pivot) to left of 
    pivot and all greater elements to right 
    of pivot */
 int partition(int arr[], int low, int high) 
 { 
     int pivot = arr[high];  
     int i = (low-1); // index of smaller element 
     for (int j=low; j<high; j++) 
     { 
         // If current element is smaller than or 
         // equal to pivot 
         if (arr[j] <= pivot) 
         { 
             i++; 

             // swap arr[i] and arr[j] 
             int temp = arr[i]; 
             arr[i] = arr[j]; 
             arr[j] = temp; 
         } 
     } 

     // swap arr[i+1] and arr[high] (or pivot) 
     int temp = arr[i+1]; 
     arr[i+1] = arr[high]; 
     arr[high] = temp; 

     return i+1; 
 } 


 /* The main function that implements QuickSort() 
   arr[] --> Array to be sorted, 
   low  --> Starting index, 
   high  --> Ending index */
 void sort(int arr[], int low, int high) 
 { 
     if (low < high) 
     { 
         /* pi is partitioning index, arr[pi] is  
           now at right place */
         int pi = partition(arr, low, high); 

         // Recursively sort elements before 
         // partition and after partition 
         sort(arr, low, pi-1); 
         sort(arr, pi+1, high); 
     } 
 } 
 
//	public static void main (String [] args) {
//		ArrayList ar = new ArrayList ();
//		Word ab = new Word("happy");
//		Word cd = new Word("mad");
//		Word ef = new Word("haggle");
//		Word gh = new Word("time");
//		ar.addElement (ab);
//		ar.addElement (cd);
//		ar.printElements();
//		
//		System.out.println();
//		ar.insertAt (2, ef);
//		ar.insertAt (1, gh);
//		ar.printElements();
//		
//		System.out.println();
//		ar.removeAt (0); 
//		ar.printElements();
//		
//		System.out.println();
//		ar.resize (4); 
//		ar.printElements();
//	}

}
