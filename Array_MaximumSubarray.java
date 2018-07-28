/*
Given an array like [1, -3, 2, 1, -1]. Find a subarray with maximum sum
A subarray is an array of contiguous elements of the original array.

Brute-Force Solution: compare all sum of all possible subarraies.
Kadane's Algorithm: find maximum of the subarray ending at a given index,
compare with previous global maximum and move on
*/
class MaximumSubarray{
    // find maximum subarray
    public int maximumSubarray(int arrayA[], int size){
        int max_global = arrayA[0];
        int max_current = arrayA[0];
        for(int i = 1; i <size; i ++){// dont need to start from the first one
            if(arrayA[i] > max_current + arrayA[i]){
                max_current = arrayA[i];
            } else {
                max_current += arrayA[i];
            }
            if(max_current > max_global){
                max_global = max_current;
            }
        }
        return max_global;
    }

    public static void main(String[] args){
        int[] arr = {1, -3, 2, 1, -1};
        int size = 5;
        MaximumSubarray max = new MaximumSubarray();
        System.out.println("The maximum subarry is: " + max.maximumSubarray(arr, size));
    }
}
