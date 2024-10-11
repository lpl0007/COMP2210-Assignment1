import java.util.Arrays;

/**
* Defines a library of selection methods
* on arrays of ints.
*
* @author   Lanie Louque (lpl0007@auburn.edu)
* @author   Dean Hendrix (dh@auburn.edu)
* @version  8/26/23
*
*/
public final class Selector {

    /**
     * Can't instantiate this class.
     *
     * D O   N O T   C H A N G E   T H I S   C O N S T R U C T O R
     *
     */
    private Selector() { }


    /**
     * Selects the minimum value from the array a. This method
     * throws IllegalArgumentException if a is null or has zero
     * length. The array a is not changed by this method.
     */
    public static int min(int[] a) {
       if(a == null || a.length == 0) {throw new IllegalArgumentException();}
       int minimum = a[0];
       for (int i : a) {
         if(i < minimum) {
            minimum = i;
         }
       }
       return minimum;
    }


    /**
     * Selects the maximum value from the array a. This method
     * throws IllegalArgumentException if a is null or has zero
     * length. The array a is not changed by this method.
     */
    public static int max(int[] a) {
       if(a == null || a.length == 0) {throw new IllegalArgumentException();}
       int maximum = a[0];
       for (int i : a) {
         if(i > maximum) {
            maximum = i;
         }
       }
       return maximum;
    }


    /**
     * Selects the kth minimum value from the array a. This method
     * throws IllegalArgumentException if a is null, has zero length,
     * or if there is no kth minimum value. Note that there is no kth
     * minimum value if k < 1, k > a.length, or if k is larger than
     * the number of distinct values in the array. The array a is not
     * changed by this method.
     */
    public static int kmin(int[] a, int k) {
        if(a == null || a.length == 0 || k < 1 || k > a.length) {throw new IllegalArgumentException();}
        if(a.length == 1 && k ==1) {return a[0];}
        int[] b = Arrays.copyOf(a,a.length);
        Arrays.sort(b);
        int repeat = 0;
        for(int i = 1; i < b.length; i++) {
            if(b[i-1] == b[i]) {
               repeat++;
            }
        }
        int[] c = new int[b.length-repeat];
        if(k > c.length) {throw new IllegalArgumentException();}
        c[0] = b[0];
        int j = 1;
        for(int i = 1; i < b.length; i++) {
            if(!(b[i-1] == b[i])) {
               c[j] = b[i];
               j++;
            }
        }
        return c[k-1];
    }


    /**
     * Selects the kth maximum value from the array a. This method
     * throws IllegalArgumentException if a is null, has zero length,
     * or if there is no kth maximum value. Note that there is no kth
     * maximum value if k < 1, k > a.length, or if k is larger than
     * the number of distinct values in the array. The array a is not
     * changed by this method.
     */
    public static int kmax(int[] a, int k) {
        if(a == null || a.length == 0 || k < 1 || k > a.length) {throw new IllegalArgumentException();}
        if(a.length == 1 && k ==1) {return a[0];}
        int[] b = Arrays.copyOf(a,a.length);
        Arrays.sort(b);
        int repeat = 0;
        for(int i = 1; i < b.length; i++) {
            if(b[i-1] == b[i]) {
               repeat++;
            }
        }
        int[] c = new int[b.length-repeat];
        if(k > c.length) {throw new IllegalArgumentException();}
        c[0] = b[0];
        int j = 1;
        for(int i = 1; i < b.length; i++) {
            if(!(b[i-1] == b[i])) {
               c[j] = b[i];
               j++;
            }
        }
        return c[c.length-k];
    }


    /**
     * Returns an array containing all the values in a in the
     * range [low..high]; that is, all the values that are greater
     * than or equal to low and less than or equal to high,
     * including duplicate values. The length of the returned array
     * is the same as the number of values in the range [low..high].
     * If there are no qualifying values, this method returns a
     * zero-length array. Note that low and high do not have
     * to be actual values in a. This method throws an
     * IllegalArgumentException if a is null or has zero length.
     * The array a is not changed by this method.
     */
    public static int[] range(int[] a, int low, int high) {
        if(a == null || a.length == 0) {throw new IllegalArgumentException();}
        int count = 0;
        for(int i : a) {
            if(i >= low && i <= high) {
               count++;
            }
        }
        int[] b = new int[count];
        int j = 0;
        for(int i : a) {
            if(i >= low && i <= high) {
               b[j] = i;
               j++;
            }
        }
        for(int i = 0; i < count - 1; i++) {
            for(j = i+1; j < count - 1; j++) {
               if(b[i] > b[j]) {
                  int temp = b[i];
                  b[i] = b[j];
                  b[j] = temp;
               }
            }
        }
        return b;
    }


    /**
     * Returns the smallest value in a that is greater than or equal to
     * the given key. This method throws an IllegalArgumentException if
     * a is null or has zero length, or if there is no qualifying
     * value. Note that key does not have to be an actual value in a.
     * The array a is not changed by this method.
     */
    public static int ceiling(int[] a, int key) {
        if(a == null || a.length == 0) {throw new IllegalArgumentException();}
        int c = key;
        boolean value = false;
        for(int i : a) {
            if(i >= key) {
               if(i < c || !value) {
                    c = i;
               }
               value = true;
            }
        }
        if(value) {
            return c;
        }
        throw new IllegalArgumentException();
    }


    /**
     * Returns the largest value in a that is less than or equal to
     * the given key. This method throws an IllegalArgumentException if
     * a is null or has zero length, or if there is no qualifying
     * value. Note that key does not have to be an actual value in a.
     * The array a is not changed by this method.
     */
    public static int floor(int[] a, int key) {
        if(a == null || a.length == 0) {throw new IllegalArgumentException();}
        int f = key;
        boolean value = false;
        for(int i : a) {
            if(i <= key) {
               if(i > f || !value) {
                    f = i;
               }
               value = true;
            }
        }
        if(value) {
            return f;
        }
        throw new IllegalArgumentException();
    }
}