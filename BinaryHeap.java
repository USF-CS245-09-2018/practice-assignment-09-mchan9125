
public class BinaryHeap {
	private int[] array;
	private int size;

	public BinaryHeap() {
		array = new int[10];
		size = 0;
	}

	private void growArray() {
		int[] temp = new int[array.length * 2];
		for(int i = 0; i < array.length; i ++) {
			temp[i] = array[i];
		}
		array = temp;
	}
	public void add(int element) {
		if(size >= array.length) {
			growArray();
		}
		array[size] = element;
		size++;
		int item = size -1;
		while(item > 0) {
			int parent = (item - 1) / 2;
			if(array[item] < array[parent]) {
				swap(array, item, parent);
				item = parent;
			}else {
				return;
			}
		}
	}

	public int remove() {
		int priority = array[0];
		array[0] = array[size -1];
		size--;
		shiftdown(0);
		return priority;
	}

	private void shiftdown(int index) {
		int child = index * 2 + 1;
		if(child +1 >= size ) {
			return;
		}
		if(array[child + 1] <= array[child]) {
			child = child + 1;
		}
		if(array[index] > array[child]) {
			swap(array, index, child);
			shiftdown(child);
		}
	}

	private void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	private void print() {
		for(int i = 0; i < array.length; i ++) {
			System.out.println(array[i]);
		}
	}
	public static void main(String args[]) {
		BinaryHeap b = new BinaryHeap();
		b.add(8);
		b.print();
		System.out.println("-----------------");
		b.add(3);
		b.print();
		b.add(5);
		b.print();
		System.out.println("-----------------");
		b.remove();
		b.print();

	}
}
