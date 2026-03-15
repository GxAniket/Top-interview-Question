// 1️⃣ Linear Search
// Idea

// Linear Search me array ko start se end tak ek-ek element check karte hain.

// Time Complexity:

// Case	Complexity
// Best	O(1)
// Worst	O(n)

//code

public class LinearSearch {

    static int linearSearch(int arr[], int key) {

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == key) {
                return i;   // element mil gaya
            }
        }

        return -1;  // element nahi mila
    }

    public static void main(String[] args) {

        int arr[] = {10, 20, 30, 40, 50};
        int key = 30;

        int result = linearSearch(arr, key);

        if(result == -1)
            System.out.println("Element not found");
        else
            System.out.println("Element found at index: " + result);
    }
}
