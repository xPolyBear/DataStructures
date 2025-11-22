public class W12D3Coding {

    public static void main(String[] args) {

        TheArrayList myList = new TheArrayList();
        
        System.out.println();
        System.out.println("Append: 10, 22, 1, 7, 25, 2");
        myList.append(10);
        myList.append(22);
        myList.append(1);
        myList.append(7);
        myList.append(25);
        myList.append(2);
        myList.print();
        System.out.println();
        System.out.println();

        System.out.println("Prepend: 3, 13, 17");
        myList.prepend(3);
        myList.prepend(13);
        myList.prepend(17);
        myList.print();
        System.out.println();
        System.out.println();

        System.out.println("Insert at index 4, 99");
        myList.insertAt(4, 99);
        myList.print();
        System.out.println();
        System.out.println();

        System.out.println("Remove the number at index 6");
        myList.removeAt(6);
        myList.print();
        System.out.println();
        System.out.println();

        System.out.println("Search for the number 10 and return the index");
        int indexOfNumberFound = myList.search(10);
        System.out.println("Index of the number: " + indexOfNumberFound);
        myList.print();
        System.out.println();
        System.out.println();

        System.out.println("Sort Array List to Ascending if true");
        myList.Sort(true);
        myList.print();
        System.out.println();
        System.out.println();
        
   }
}
    class TheArrayList {
    private int[] data;
    private int listLength;

    public TheArrayList() {
        this(4);
    }
    
    public TheArrayList(int startingAllocation) {
        this.data = new int[startingAllocation];
        this.listLength = 0;
    }
    
    public void append(int newItem) {
        if (data.length == listLength) {
            resize(listLength * 2);
        }

        // Insert the new item at index listLength
        data[listLength] = newItem;

        // Increment the array's length
        ++listLength;
    }
    
    public void resize(int newAllocationSize) {
        int[] newArray = new int[newAllocationSize];

        for (int i = 0; i < listLength; i++) {
            newArray[i] = data[i];
        }

        data = newArray;
    }
    
    public void prepend(int newItem) {

        if (data.length == listLength) {
            resize(listLength * 2);
        }
        
        for (int i = listLength; i > 0; i--) {
            data[i] = data[i - 1];
        }
            
        data[0] = newItem;
        listLength++;

    }
    
    public void insertAt(int index, int newItem) {

        if (data.length == listLength) {
            resize(listLength * 2);
        }

        for (int i = listLength; i > index; i--) {
            data[i] = data[i - 1];
        }

        data[index] = newItem;
            
        listLength++;
    }

    public void removeAt(int index) {

        if (index >= 0 && index < listLength) {

            for (int i = index; i < listLength - 1; i++) 
            {
                data[i] = data[i + 1];
            }

            listLength--;
        }
    }

    public int search(int item) {
        for (int i = 0; i < listLength; i++){

            if (data[i] == item) {
                return i;
            }
        }

        return -1;
    }

    public void Sort(boolean Acsending) {

		for (int x = 0; x < listLength - 1; x++) {
			for (int k = 0; k < listLength - 1 - x; k++){
                if(Acsending == true){
                    if(data[k] > data[k+1])
                    {
                        int temp = data[k];
                        data[k] = data[k+1];
                        data[k+1] = temp;
                    }
                } else {
                    if(data[k] < data[k+1])
                    {
                        int temp = data[k];
                        data[k] = data[k+1];
                        data[k+1] = temp;
                    }
                }
				
			}

		}
			
	}
    
    public void print() {
        for (int i = 0; i < listLength; i++) {
            System.out.print(data[i] + " -> ");
        }

    }
      
}