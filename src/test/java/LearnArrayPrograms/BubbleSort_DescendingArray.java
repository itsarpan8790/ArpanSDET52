package LearnArrayPrograms;

public class BubbleSort_DescendingArray {
	public static void main(String[] args) {
		int[] ar = { 65, 15, 35, 5, 25, 37, 13 };
		int temp = 0;
		int length = ar.length;
		for (int i = 0; i < ar.length; i++) {

			for (int j = 0; j < ar.length - 1; j++) {
				if (ar[i] > ar[j]) {
					temp = ar[i];
					ar[i] = ar[j];
					ar[j] = temp;
				}
			}

		}
		for (int i = 0; i < ar.length; i++) {
			System.out.println(ar[i]);
		}

		System.out.println("Max no is " + ar[0]);
		System.out.println("Min No is  " + ar[length - 1]);
	}

}
