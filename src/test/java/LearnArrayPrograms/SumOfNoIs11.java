package LearnArrayPrograms;

public class SumOfNoIs11 {

	public static void main(String[] args) {
		int[] ar = { 8, 2, 3, 7, 6, 4, 9, 5 };
		int l = ar.length;
		for (int i = 0; i < l; i++) { // ar[i]!=ar[j]
			

			for (int j = 0; j < l; j++) {
				int sum = 0;
				if (i != j) { // same value should not added to itself
					sum = sum + ar[i] + ar[j];
					if (sum == 11) {
						System.out.println(ar[i] + " " + ar[j]);
					}
				}
			}
		}
	}

}
