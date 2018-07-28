// write a function to rotate an array of size n by d elements -  rotate left
/*
int arrayA[] = {a0, a1, a2, a3, a4, ..., an-1}

Solution 1:
- store first d elements in a temp array
int temp[] = {a0, a1, ... , ad-1}
- shift the rest of arrayA left
arrayA[] = {ad, ad+1, ... an-1, an-d, ... an-1}
- store back d elements
arrayA[] = {ad, ad+1, ..., an-1, a0, a1, ..., ad-1}
Time complexity: O(n)
Auxiliary space: O(d)

Solution 2:
- Shift element of arrayA left one by one d times
temp = a0, a1=a2, a2=a3, ..., an-2=an-1, an-1=temp. repeat d times
Time complexity: O(n*d)
Auxiliary space: O(1)

Solution 3: extends solution 2 instead of moving one by one, moving by GCD(n,d)
divive array of n elements into gcd sets, then move elements among each set
temp = a0, a[l] = a[l+d]
*/
class RotateArray{
    // rotate left by d elements
    void rotateLeft(int arr[], int d, int n){
        for(int i = 0; i < gcd(d,n); i++){
            int temp = arr[i];
            int j = i;
            int k;
            while(true){
                k = j+ d;
                if (k>=n)
                    k -= n;
                if (k==i)
                    break;
                arr[j]=arr[k];
                j=k;
            }
            arr[j] = temp;
        }
    }


    // calculate gcd
    int gcd(int a, int b){
        if(a==b)
            return a;
        else if (a<b)
            return gcd(a,b-a);
        else
            return gcd(a-b,b);
    }

    // print the result
    void printResult(int arrayA[], int size){
        for (int i = 0; i < size; i++){
            System.out.print(arrayA[i] + " ");
        }
    }

    public static void main(String[] args){
        int arrayA[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        RotateArray rotateArray = new RotateArray();
        rotateArray.rotateLeft(arrayA, 8, 12);
        rotateArray.printResult(arrayA, 12);
    }
}
