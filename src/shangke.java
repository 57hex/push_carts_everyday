public class shangke {
    public static void main(String[] args) {
        int i = 1;
        int max = 0;
        int min = 0;
        int arr[] = {2, 5, 10, 9, 19, 8, 2};
        for (i = 0; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
            if (arr[i] < min) min = arr[i];

        }
        System.out.println(max);
        System.out.println(min);
    }
}
