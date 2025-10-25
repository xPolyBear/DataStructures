public class W8D3Coding {
    public static void main(String[] args) {
        int size = 100000;
        int[] array = GenerateRandomUnique(1, 150000, size);

        int[] bubbleSortArray = new int[array.length];
        for (int i = 0; i < bubbleSortArray.length; i++) {
            bubbleSortArray[i] = array[i];
        }

        long startMillisBubble = System.currentTimeMillis();
        BubbleSort(bubbleSortArray);
        long finishMillisBubble = System.currentTimeMillis();
        long timeElapsedMillisBubble = finishMillisBubble - startMillisBubble;
        System.out.println("Bubble Sort: " + timeElapsedMillisBubble + "ms");

        int[] selectionSortArray = new int[array.length];
        for (int i = 0; i < selectionSortArray.length; i++) {
            selectionSortArray[i] = array[i];
        }

        long startMillisSelection = System.currentTimeMillis();
        SelectionSort(selectionSortArray);
        long finishMillisSelection = System.currentTimeMillis();
        long timeElapsedMillisSelection = finishMillisSelection - startMillisSelection;
        System.out.println("Selection Sort: " + timeElapsedMillisSelection + "ms");

        int[] insertionSortArray = new int[array.length];
        for (int i = 0; i < insertionSortArray.length; i++) {
            insertionSortArray[i] = array[i];
        }

        long startMillisInsertion = System.currentTimeMillis();
        InsertionSort(insertionSortArray);
        long finishMillisInsertion = System.currentTimeMillis();
        long timeElapsedMillisInsertion = finishMillisInsertion - startMillisInsertion;
        System.out.println("Insertion Sort: " + timeElapsedMillisInsertion + "ms");

        int[] intervals = {3, 2, 1};

        int[] manualShellArray = new int[array.length];
        for (int i = 0; i < manualShellArray.length; i++) {
            manualShellArray[i] = array[i];
        }
        long startMillisManual = System.currentTimeMillis();
        ShellSort(manualShellArray, intervals);
        long finishMillisManual = System.currentTimeMillis();
        long timeElapsedMillisManual = finishMillisManual - startMillisManual;
        System.out.println("Shell Sort Manual Time: " + timeElapsedMillisManual + "ms");
        
        int[] autoShellArray = new int[array.length];
        for (int i = 0; i < autoShellArray.length; i++) {
            autoShellArray[i] = array[i];
        }
        long startMillisAuto = System.currentTimeMillis();
        ShellSort(autoShellArray);
        long finishMillisAuto = System.currentTimeMillis();
        long timeElapsedMillisAuto = finishMillisAuto - startMillisAuto;
        System.out.println("Shell Sort Auto Time: " + timeElapsedMillisAuto + "ms");
        
        int[] quickSortArray = new int[array.length];
        for (int i = 0; i < quickSortArray.length; i++) {
            quickSortArray[i] = array[i];
        }

        long startMillisQuickSort = System.currentTimeMillis();
        QuickSort(quickSortArray, 0, quickSortArray.length - 1);
        long finishMillisQuickSort = System.currentTimeMillis();
        long timeElapsedMillisQuickSort = finishMillisQuickSort - startMillisQuickSort;
        System.out.println("Quick Sort Time: " + timeElapsedMillisQuickSort + "ms");
        
        int[] mergeSortArray = new int[array.length];
        for (int i = 0; i < mergeSortArray.length; i++) {
            mergeSortArray[i] = array[i];
        }

        long startMillisMergeSort = System.currentTimeMillis();
        MergeSort(mergeSortArray, 0, mergeSortArray.length - 1);
        long finishMillisMergeSort = System.currentTimeMillis();
        long timeElapsedMillisMergeSort = finishMillisMergeSort - startMillisMergeSort;
        System.out.println("Merge Sort Time: " + timeElapsedMillisMergeSort + "ms");
        
        System.out.println("");

    }

    public static int[] BubbleSort(int[] randomArray) {

    	int[] bubbleArray = new int[randomArray.length];
        
        for (int i = 0; i < randomArray.length; i++) {
            bubbleArray[i] = randomArray[i];
        }

		for (int x = 0; x < bubbleArray.length - 1; x++) {
            boolean isArraySorted = true;
			for (int k = 0; k < bubbleArray.length - 1 - x; k++){
				if(bubbleArray[k] > bubbleArray[k+1])
				{
					int temp = bubbleArray[k];
					bubbleArray[k] = bubbleArray[k+1];
					bubbleArray[k+1] = temp;
                    isArraySorted = false;
				}
			}

            if(isArraySorted) {
                break;
            }
		}
			
		return bubbleArray;
	}

    public static int[] SelectionSort(int[] randomArray) {
        
        int[] selectionArray = new int[randomArray.length];
        int smallIndex = 0;

        for (int i = 0; i < randomArray.length; i++) {
            selectionArray[i] = randomArray[i];
        }

        for (int x = 0; x < selectionArray.length; x++) {
            smallIndex = x;
            for (int k = x + 1; k < selectionArray.length; k++) {
                if(selectionArray[k] < selectionArray[smallIndex]) {
                    smallIndex = k;
                }
            }

            int temp = selectionArray[x];
            selectionArray[x] = selectionArray[smallIndex];
            selectionArray[smallIndex] = temp;
            
        }

        return selectionArray;
    }

    public static int[] InsertionSort(int[] randomArray) {

        int[] insertionArray = new int[randomArray.length];

        for (int i = 0; i < randomArray.length; i++) {
            insertionArray[i] = randomArray[i];
        }

        for (int i = 1; i < insertionArray.length; i++) {
            int current = i;
            while (current > 0 && insertionArray[current] < insertionArray[current-1]) {

                int temp = insertionArray[current];
                insertionArray[current] = insertionArray[current - 1];
                insertionArray[current - 1] = temp;
                current--;
            }
        }
        return insertionArray;
    }

    public static int[] ShellSort(int[] randomArray, int[] intervals) {

        for(int i = 0; i < intervals.length; i++) {

            InsertionSortWithIntervals(randomArray, intervals[i]);

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
            
            InsertionSortWithIntervals(randomArray, powerOfTwo);
        
            powerOfTwo = powerOfTwo / 2;
        }

        return randomArray;

    }

    public static void InsertionSortWithIntervals(int[] array, int theInterval) {
            
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

    public static int[] QuickSort(int[] array, int lowIndex, int highIndex) {

        if (lowIndex >= highIndex) {
            return array;
        }
        int pivot = array[(lowIndex + highIndex) / 2];
        int index = Partition(array, lowIndex, highIndex, pivot);
        QuickSort(array, lowIndex, index - 1);
        QuickSort(array, index, highIndex);

        return array;
        
    }

    private static int Partition(int[] array, int lowIndex, int highIndex, int pivot) {
        
        while (lowIndex <= highIndex) {
            while (array[lowIndex] < pivot) {
                lowIndex++;
            }
            while (array[highIndex] > pivot) {
                highIndex--;
            }
            if (lowIndex <= highIndex) {
                int temp = array[lowIndex];
                array[lowIndex] = array[highIndex];
                array[highIndex] = temp;
                lowIndex++;
                highIndex--;
            }
        }
        return lowIndex;
    }

    public static int MergeSort(int[] array, int start, int end) {

        if(start < end) {
            int middle = (start + end) / 2;

            MergeSort(array, start, middle);
            MergeSort(array, middle + 1, end);
            Merge(array, start, middle, end);
        }
        return 0;
        
    }

    public static void Merge(int[] array, int start, int middle, int end) {
        int[] finalMergedNumbers = new int[end - start + 1];
        int leftPosition = start;
        int rightPosition = middle + 1;
        int mergedArrayPosition = 0;

        while(leftPosition <= middle && rightPosition <= end) {
            if(array[leftPosition] <= array[rightPosition]) {
                finalMergedNumbers[mergedArrayPosition] = array[leftPosition];
                leftPosition++;
            } else {
                finalMergedNumbers[mergedArrayPosition] = array[rightPosition];
                rightPosition++;
            }
            mergedArrayPosition++;
        }

        while(leftPosition <= middle) {
            finalMergedNumbers[mergedArrayPosition] = array[leftPosition];
            leftPosition++;
            mergedArrayPosition++;
        }

        while(rightPosition <= end) {
            finalMergedNumbers[mergedArrayPosition] = array[rightPosition];
            rightPosition++;
            mergedArrayPosition++;
        }

        for(int i = 0; i < finalMergedNumbers.length; i++) {
            array[start + i] = finalMergedNumbers[i];
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