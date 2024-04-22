import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class BitonicSearch {

    public static int search(int[] array, int target) {
        int n = array.length;
        int result;
        int peak = findPick(array, 0, n - 1);
        result = binarySearch(array, target, 0, peak, true);
        if (result != -1) {
            return result;
        }

        result = binarySearch(array, target, peak, 0, false);
        return result;
    }


    private static int findPick(int[] array, int low, int high) {

        while (low < high) {
            int mid = (low + high) / 2;

            if (array[mid] > array[mid + 1]) {
                high = mid;
            } else {
                low = mid + 1;
            }

        }

        return low;
    }


    private static int binarySearch(int[] array, int target, int left, int right, boolean is_increasing) {

        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] == target) {
                return mid;
            }
            if (is_increasing) {
                if (array[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (array[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int target = StdIn.readInt();
        int [] array = StdIn.readAllInts();
        StdOut.println(search(array, target));

    }
}
