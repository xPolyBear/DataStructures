public class W13D2Coding {
   
    public int Empty_Since_Start = 0;
    public int isOccupied = 1;
    public int Empty_After_Removal = 2;

    public int[] theKeys;
    public String[] theStrings;
    public int[] theBucketStates;

    //initiates the hash table
    public W13D2Coding(int capacity) {

        theKeys = new int[capacity];
        theStrings = new String[capacity];
        theBucketStates = new int[capacity];

        for (int i = 0; i < capacity; i++){
            theBucketStates[i] = Empty_Since_Start;
        }
    }

    public int GetHashing(int key){
        return key % theKeys.length;
    }

    public int LinearProbing(int key, int i){

        return (GetHashing(key) + i) % theKeys.length;
    }

    public boolean HashInsert(int key, String string){

        for(int i = 0; i < theKeys.length; i++) {
            int bucketIndex = LinearProbing(key, i);

            
            if (theBucketStates[bucketIndex] == isOccupied && theKeys[bucketIndex] == key) {
                
                    theStrings[bucketIndex] = string;
                    return true;
            }

            if (theBucketStates[bucketIndex] == Empty_Since_Start || theBucketStates[bucketIndex] == Empty_After_Removal) {
                
                    theKeys[bucketIndex] = key;
                    theStrings[bucketIndex] = string;
                    theBucketStates[bucketIndex] = isOccupied;
                    return true;
            }

        }
        return false;
    }


    public boolean HashRemove(int key){

        for(int i = 0; i < theKeys.length; i++) {
            int bucketIndex = LinearProbing(key, i);

            if (theBucketStates[bucketIndex] == Empty_Since_Start) {
                return false;
            }

            if (theBucketStates[bucketIndex] == isOccupied && theKeys[bucketIndex] == key) {
                
                    theBucketStates[bucketIndex] = Empty_After_Removal;
                    return true;
            }
        }

        return false;
    }

    public String HashGet(int key){

        for(int i = 0; i < theKeys.length; i++) {
            int bucketIndex = LinearProbing(key, i);

            if (theBucketStates[bucketIndex] == Empty_Since_Start) {
                return null;
            }

            if (theBucketStates[bucketIndex] == isOccupied && theKeys[bucketIndex] == key) {
                
                    return theStrings[bucketIndex];
            }
        }

        return null;
    }

    public void ResizeHashTable(int newCapacity){

        int[] oldKeys = theKeys;
        String[] oldValues = theStrings;
        int[] oldBucketStates = theBucketStates;

        theKeys = new int[newCapacity];
        theStrings = new String[newCapacity];
        theBucketStates = new int[newCapacity];

        for (int i = 0; i < newCapacity; i++){
            theBucketStates[i] = Empty_Since_Start;
        }

        for (int i = 0; i < oldKeys.length; i++){

            if (oldBucketStates[i] == isOccupied){
                HashInsert(oldKeys[i], oldValues[i]);
            }
        }
    }

    public void HashDisplay(){

        for(int i = 0; i < theKeys.length; i++) {
            if (theBucketStates[i] == isOccupied) {

                System.out.println("Bucket " + i + ": Key = " + theKeys[i] + ", String = " + theStrings[i]);
            } else if (theBucketStates[i] == Empty_After_Removal) {

                System.out.println("Bucket " + i + ": Empty_After_Deleted");
            } else {

                System.out.println("Bucket " + i + ": Empty_Since_Start");
            }

        }
    }


        public static void main(String[] args) {

            W13D2Coding hashTable = new W13D2Coding(7);
            
            System.out.println();
            System.out.println("Inserting Key 1, 2, and 3");
            hashTable.HashInsert(1, "KT");
            hashTable.HashInsert(2, "Finn");
            hashTable.HashInsert(3, "Jen");
            hashTable.HashDisplay();
            System.out.println();

            System.out.println("Inserting Key 8 (Causes a collision with Key 1)");
            hashTable.HashInsert(8, "Collision Test");
            hashTable.HashDisplay();
            System.out.println();

            System.out.println("Removing Key 3");
            hashTable.HashRemove(3);
            hashTable.HashDisplay();
            System.out.println();

            System.out.println("Getting Key 3 to check output");
            System.out.println("Get Key 3: " + hashTable.HashGet(3));
            
            System.out.println();
            System.out.print("Resizing Hash Table to: 10");
            hashTable.ResizeHashTable(10);
            System.out.println();
            hashTable.HashDisplay();
            System.out.println();

            


        }
    }

