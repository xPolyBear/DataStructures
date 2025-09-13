public class W3D2Coding {

    public static void main(String[] args) {
            
            System.out.println();
            System.out.println("Does the word stack have all unique characters? " + Unique("stack"));
            System.out.println("Does the word queue have all unique characters? " + Unique("queue"));
            System.out.println();
            System.out.println("Occurrence of 'the': " + Occurrence("In the beginning God created the heavens and the earth", "the"));
            System.out.println("Occurrence of 'begin': " + Occurrence("In the beginning God created the heavens and the earth", "begin"));
            System.out.println("Occurrence of 'recreate': " + Occurrence("In the beginning God created the heavens and the earth", "recreate"));
    }

    public static boolean Unique(String str) {

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            for (int k = i + 1; k < str.length(); k++) {
				if(ch == str.charAt(k)) {
                    return false;
                }
            }
        }
    
        return true;
    }


    public static int Occurrence(String str, String word) {

        String[] theSentence = str.split(" ");
        int count = 0;

        for (int i = 0; i < theSentence.length; i++) {
            if(theSentence[i].equals(word)) {
                count++;
            }
        }

        return count;
    }
}