import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Comparator;

//Вариант 8. Задания[ 6,18,23,24,8 ]

//Task 6
//Створіть метод, який дозволяє порівняти 2 будь яких масиви int[] по складу.
//Масиви можуть відрізнятися по порядку елементів , но бути однаковими зі складу.

class Equals{
    public static void main(String[] args){
        int [][] Diff = {{3,1,2},{1,2,3}};
        int [][] Diff2 = {{1, 2, 3, 4},{4, 2, 3, 1}};
        int [][] Diff3 = {{2,1,3},{1,2,3}};

        System.out.println("is objects equals to each other? : " + Arrays.equals(Diff, Diff));
        System.out.println("is objects equals to each other? : " + Arrays.equals(Diff2,Diff2));
        System.out.println("is objects equals to each other? : " + Arrays.equals(Diff3,Diff3));
    }
}

//Task 8
//Створіть метод, який підраховує кількість однакових чисел у будь якому масиві int[] .
class Siblings {

	public static void main( String[] args ) {
		new Siblings().task();
	}

	public void task() {
		int[] input = RandomArray(13 , 0 , 13);
		showArray(input);
		int[][] output = CountSiblings(input);
		showResult(output);
	}

	private int[] RandomArray( int size , int min , int max ) {
		int[] output = new int[size];
		for (int i = 0; i < size; i++) {
			output[i] = ThreadLocalRandom.current().nextInt(min , max);
		}
		return output;
	}

	private void showArray( int[] input ) {
		System.out.println("\nInput:");
		for (int elem : input) {
			System.out.print(elem + " ");
		}
		System.out.println();
	}

	private void showResult( int[][] output ) {
		System.out.println("\nOutput:");
		for (int[] item : output) {
			System.out.printf("Value: [%d] \tcount: %d\n" , item[0] , item[1]);
		}
		System.out.println();
	}

	private int[][] CountSiblings( int[] arr ) {
		int len = lengthOfArray(arr);
		int index = 0;
		int[][] output = new int[len][2];
		boolean isNew;
		for (int value : arr) {
			isNew = true;
			for (int i = 0; i < index; i++) {
				if (output[i][0] == value) {
					output[i][1]++;
					isNew = false;
					break;
				}
			}
			if (isNew) {
				output[index][0] = value;
				output[index][1] = 1;
				index++;
			}
		}
		return output;
	}

	private int lengthOfArray( int[] arr ) {
		int len = 0;
		for (int i = 0; i < arr.length; i++) {
			if (!isContain(arr , arr[i] , i + 1)) len++;
		}
		return len;
	}

	private boolean isContain( int[] arr , int value , int pos ) {
		for (int i = pos; i < arr.length; i++) {
			if (arr[i] == value) return true;
		}
		return false;
	}
}

//Task 23
// Створіть метод, який рекурсивно рахує суму елементів масиву int[], який передається як параметр методу
class Recursion{

    static int Sum(int i, int[] A) {
        if (i==(A.length-1))
            return A[i];
        return A[i] + Sum(i+1,A);
    }

    public static void main(String[] args) {
        int[] A = { 3, 12, 10, 11 };
        int sum;
        sum = Sum(0,A);
        System.out.println(sum);
    }
}

//Task 24
//Створіть метод, який сортує масив String у порядку довжини рядків
class SortByRows implements Comparator<String>{
	@Override
	public int compare(String o1, String o2){
		return Integer.compare(o1.length() , o2.length());
	}

	public static void main(String[] args) {
		String [] list = {"Deaaaaaaan", "Deaaan", "Deaaaaaaaan", "Dean", "Deaaaaaan", "Deaan", "Deaaaaaaaaan",  "Deaaaan", "Deaaaaan"};
		Comparator<String> stringLengthComparator = new SortByRows();
		for(String str : list){
			System.out.println(str);
		}
		Arrays.sort(list, stringLengthComparator); // применяем сортировку
		System.out.println("\nСортировка по количеству символов в строке\n");
		for(String str : list){
			System.out.println(str);
		}
	}
}
