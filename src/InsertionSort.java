
public class InsertionSort {
	public void insertionSort(int arr[]) {
		for (int i = 1, j; i<arr.length;i++) {
			int temp = arr[i];
			for (j = i; j>0 && temp <arr[j-1]; j--)
				arr[j]=arr[j-1];
			arr[j]=temp;
		}
	}
}
