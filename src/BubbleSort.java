
public class BubbleSort {
	public void bubbleSortNum(int arr[]) {
		for (int i = 0; i< arr.length-1; i++) {
			for (int j =arr.length-1; j>i;j--) {
				if(arr[j]<arr[j-1]) {
					int temp = arr[j-1];
					arr[j-1]=arr[j];
					arr[j]=temp;
				}
			}
		}
	}
	public void bubbleSortAlpha(String a) {
		
	}
}
