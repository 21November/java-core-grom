package lesson22.arrays;

public class ArrayUtils {

    public static int maxElement (int[] array){
        int max = array[0];

        for (int el : array){
            if (el > max)
                max = el;
        }
        return max;
    }

    public static int nCount(int[] array, int n){
        int count = 0;

        for (int el : array){
            if (el == n)
                count++;
        }
        return count;
    }

    //сортировка пузырьком по убыванию
    public static int[] sortAscending(int[] arr){
        int n = arr.length;
        int temp;

        for (int i = 0; i < n; i++){
            for (int j = 0; j < (n - 1); j++){
                if (arr[j - 1] > arr[j]){
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    //сортировка пузырьком по возврастанию
    public static int[] sortDescending(int[] arr){
        int n = arr.length;
        int temp;

        for (int i = 0; i < n; i++){
            for (int j = 0; j < (n - 1); j++){
                if (arr[j - 1] < arr[j]){
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
}
