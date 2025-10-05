public class W6D1Coding {
    public static void main(String[] args) {

        int size = 15000;
        int[] array = GenerateRandomUnique(1, 15010, size);
        
        
        //System.out.println("");
        // System.out.println("Unsorted random array: ");
        // for(int i = 0; i < array.length; i++) {
        //     System.out.print(array[i] + " ");
        // }

        //System.out.println("\n");

        int[] intervals = {3, 2, 1};


        int[] manualShellArray = new int[array.length];
        for (int i = 0; i < manualShellArray.length; i++) {
            manualShellArray[i] = array[i];
        }
        //System.out.println("Sorted array with manual intervals: ");
        long startMillisManual = System.currentTimeMillis();
        ShellSort(manualShellArray, intervals);
        long finishMillisManual = System.currentTimeMillis();
        long timeElapsedMillisManual = finishMillisManual - startMillisManual;
        System.out.println("Shell Sort Manual Time: " + timeElapsedMillisManual + "ms");
        
        System.out.println("");

        int[] autoShellArray = new int[array.length];
        for (int i = 0; i < autoShellArray.length; i++) {
            autoShellArray[i] = array[i];
        }
        //System.out.println("Sorted array with auto generated intervals: ");
        long startMillisAuto = System.currentTimeMillis();
        ShellSort(autoShellArray);
        long finishMillisAuto = System.currentTimeMillis();
        long timeElapsedMillisAuto = finishMillisAuto - startMillisAuto;
        System.out.println("Shell Sort Auto Time: " + timeElapsedMillisAuto + "ms");
        
        System.out.println("");

        int[] insertionArray = new int[array.length];
        for (int i = 0; i < insertionArray.length; i++) {
            insertionArray[i] = array[i];
        }
        long startMillisInsertion = System.currentTimeMillis();
        InsertionSort(insertionArray, 1);
        long finishMillisInsertion = System.currentTimeMillis();
        long timeElapsedMillisInsertion = finishMillisInsertion - startMillisInsertion;
        System.out.println("Insertion Sort Time: " + timeElapsedMillisInsertion + "ms");
        
    }

    public static int[] ShellSort(int[] randomArray, int[] intervals) {

        for(int i = 0; i < intervals.length; i++) {

            //System.out.print( "The interval is: " + intervals[i] + "\n");
            InsertionSort(randomArray, intervals[i]);

            //for(int k = 0; k < randomArray.length; k++) {
            //    System.out.print(randomArray[k] + " ");
            //}
            //System.out.print("\n");
        }
        return randomArray;
        
    }

    public static int[] ShellSort(int[] randomArray){

        int arraySize = randomArray.length;
        int powerOfTwo = 1;
        
        while(powerOfTwo * 2 < arraySize) {
            powerOfTwo = powerOfTwo * 2;
        }

        while(powerOfTwo >= 1) {
            
            //System.out.print( "The interval is: " + powerOfTwo + "\n");
            InsertionSort(randomArray, powerOfTwo);

            // for(int k = 0; k < randomArray.length; k++) {
            //     System.out.print(randomArray[k] + " ");
            // }
            //System.out.print("\n");
        
            powerOfTwo = powerOfTwo / 2;

            
        }

        return randomArray;

    }

    public static void InsertionSort(int[] array, int theInterval) {
        
		for(int k = 0; k < theInterval; k++) {
		    for (int i = k; i < array.length; i = i + theInterval) {
                
		        int current = i;
		        while ((current - theInterval) >= 0 && array[current] < array[current - theInterval]) {

		            int temp = array[current];
		            array[current] = array[current - theInterval];
		            array[current - theInterval] = temp;
		            current = current - theInterval;
		        }
		    }
		}
	}

    public static int[] GenerateRandomUnique(int start, int end, int total) {
        if(total > (end - start) || start >= end ){
            System.out.println("Error: This is an invalid input!");
            return new int[0];
        }

        int[] arr = new int[total];

        for (int i = 0; i < total; i++) {
            int random = (int)(Math.random() * (end - start)) + start;
            boolean duplicate = false;

            for(int k = 0; k < i; k++){
                if(random == arr[k]){
                    i--;
                    duplicate = true;
                    break;
                }
            }

            if(duplicate == false) {
                arr[i] = random;
            }
        }

        return arr;
    }
}