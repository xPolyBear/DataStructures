public class W5D1Coding {
    public static void main(String[] args) {
        
        int size = 10000;
        int[] result = GenerateRandomUnique(1, 110000, size);

        long startMillisBubble = System.currentTimeMillis();
        BubbleSort(result);
        long finishMillisBubble = System.currentTimeMillis();
        long timeElapsedMillisBubble = finishMillisBubble - startMillisBubble;

        long startMillisSelection = System.currentTimeMillis();
        SelectionSort(result);
        long finishMillisSelection = System.currentTimeMillis();
        long timeElapsedMillisSelection = finishMillisSelection - startMillisSelection;

        long startMillisInsertion = System.currentTimeMillis();
        InsertionSort(result);
        long finishMillisInsertion = System.currentTimeMillis();
        long timeElapsedMillisInsertion = finishMillisInsertion - startMillisInsertion;

        System.out.println("Sorting a random array size of " + size + " took Bubble Sort " + timeElapsedMillisBubble + "ms to complete.");
        System.out.println("Sorting a random array size of " + size + " took Selection Sort " + timeElapsedMillisSelection + "ms to complete.");
        System.out.println("Sorting a random array size of " + size + " took Insertion Sort " + timeElapsedMillisInsertion + "ms to complete.");


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

}
