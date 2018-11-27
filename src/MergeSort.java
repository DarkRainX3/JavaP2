
public class MergeSort {
	public void mergeSort(int arr[], int f, int l) {
		if (f<l) {
			int mid = (f+l)/2;
			mergeSort(arr,f,mid);
			mergeSort(arr,mid+1,l);
			//merge(arr,f,mid,mid+1,l);
		}
	}
}
