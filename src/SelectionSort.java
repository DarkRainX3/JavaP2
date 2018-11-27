
public class SelectionSort {
	public void selectionSort(int arr[]) {
		for (int i = 0; i<arr.length-1;i++) {
			int min = 0;
			for (int j = i+1; j<arr.length-1;j++) {
				if (arr[j]<arr[min])
					min = j;
			}
			int temp = arr[min];
			arr[min]=arr[i];
			arr[i]= temp;
		}
	}
}
