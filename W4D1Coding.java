public class W4D1Coding {
    public static void main(String[] args) {
        
        int[] result = GenerateRandomUnique(3, 19, 7);
        System.out.println("");
        System.out.println("Random Unique Numbers:");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println("\n");
        System.out.println("Scan for 5: " + Scan(result, 5));  
        System.out.println("");      
        System.out.println("Stor for 5: " + Stor(result, 5));

    }

    public static int[] GenerateRandomUnique(int start, int end, int total)
    {
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

            if(duplicate == false)
            {
                arr[i] = random;
            }
        }

        return arr;
    }

    public static boolean Scan(int[] input, int target){
        for (int i = 0; i < input.length; i++) {
            if(input[i] == target){
                return true;
            }
        }
        return false;
    }

    public static boolean Stor(int[] input, int target){

        int maxNumberInArray = 0;
        
        for (int i = 0; i < input.length; i++) {
            if(input[i] > maxNumberInArray){
                maxNumberInArray = input[i];
            }
        }

        int[] array = new int[maxNumberInArray + 1];
        boolean targetFound = false;

        for (int i = 0; i < input.length; i++) {
            array[input[i]] = 1;
            if(input[i] == target){ 
                targetFound = true;
            }
        }

        System.out.println("Stor Array:");
        for(int i = 0; i < array.length; i++){
            
            System.out.print(array[i] + " ");
        }
        System.out.println("\n");

        return targetFound;
    }   
}
