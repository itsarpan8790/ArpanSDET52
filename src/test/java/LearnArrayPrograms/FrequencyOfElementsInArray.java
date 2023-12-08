package LearnArrayPrograms;

public class FrequencyOfElementsInArray {
	public static void main(String[] args) {
		int[] ar = { 10, 15, 5, 5, 5, 5, 5, 10, 15, 3, 6, 3, 3, 6, 6, 6, 6 };
		int l = ar.length;
		int max = 0;
		int value = 0;
		boolean[] br = new boolean[l];

		for (int i = 0; i < l; i++) {
			if (br[i] == false) {
				int n = ar[i];
				int count = 0;

				for (int j = 0; j < l; j++) {

					if (n == ar[j]) {
						count++;
						br[j] = true;
					}

				}
				System.out.println(ar[i] + "  occurs " + count + "  times");
				if (count > max) {
					max = count;
					value = ar[i];
				}
			}

		}
		System.out.println(value + " occurs maximum and " + max + " times");

	}

}
