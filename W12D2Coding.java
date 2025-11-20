import java.util.Stack;
import java.lang.Character; //found this when researching, import Character

public class W12D2Coding {

    public static void main(String[] args) {
            
            System.out.println();
            System.out.println("Input: (3+4)*2/(1-5)" );
            System.out.println();
            String thePostfix = ShuntingYardAlgorithm("(3+4)*2/(1-5)");
            System.out.println("Postfix: " + thePostfix );
            System.out.println();
            System.out.println("Result: " +  math(thePostfix));
            System.out.println("------------------------------------");

            System.out.println();
            System.out.println("Input: 8*9/2-(4+5)" );
            System.out.println();
            String thePostfix2 = ShuntingYardAlgorithm("8*9/2-(4+5)");
            System.out.println("Postfix: " + thePostfix2);
            System.out.println();
            System.out.println("Result: " +  math(thePostfix2));
            System.out.println("------------------------------------");

            System.out.println();
            System.out.println("Input: (7*7)+2/3^4-8" );
            System.out.println();
            String thePostfix3 = ShuntingYardAlgorithm("(7*7)+2/3^4-8");
            System.out.println("Postfix: " + thePostfix3);
            System.out.println();
            System.out.println("Result: " +  math(thePostfix3));

            
    }

    public static int order(char operator){

        if(operator == '+' || operator == '-'){
            return 1;
        }
        else if(operator == '*' || operator == '/') {
            return 2;
        }
        else if(operator == '^'){
            return 3;
        } 

        return -1;
    }

    public static boolean isFurtherOnTheLeft(char operator){
        if(operator == '+' || operator == '-' || operator == '/' || operator == '*'){
            
            return true;
        }else{
            
            return false;
        }
        
    }

    

    public static String ShuntingYardAlgorithm(String string) {

        Stack<Character> theStack = new Stack<>();
        String answer = "";        

        for(int i = 0; i < string.length(); i++){
            char save = string.charAt(i);
            
            if(Character.isLetterOrDigit(save)){//found this when researching, checks to see if it is a letter or digit
                
                answer = answer + save;
            }
            else if(save == '(')
            {
                theStack.push(save);
            }
            else if(save == ')'){
                while(!theStack.isEmpty() && theStack.peek() != '(') {
                    
                    answer = answer + theStack.pop();
                }
                theStack.pop();
            }
            else{
                while(!theStack.isEmpty() && order(save) <= order(theStack.peek()) && isFurtherOnTheLeft(save)) {
                    
                    answer = answer + theStack.pop();
                }
                theStack.push(save);
            }

        }

        while(!theStack.isEmpty()) {
                if(theStack.peek() == '('){
                    return "Invalid expression: Unbalanced parentheses";
                }
                
                answer = answer + theStack.pop();
            }
        
            return answer;

    }

    public static float math(String string){
        Stack<Float> theStack = new Stack<>();
        float answer = 0;

        for(int i = 0; i < string.length(); i++){
            
            char save = string.charAt(i);

            if(Character.isDigit(save)){
                theStack.push((float)(save - '0'));//had to look up how to convert a character to a float 
            } else {
                float rightNumber = theStack.pop();
                float leftNumber = theStack.pop();

                if(save == '+'){
                    answer = leftNumber + rightNumber;
                }
                else if(save == '-'){
                    answer = leftNumber - rightNumber;
                }
                else if(save == '*'){
                    answer = leftNumber * rightNumber;
                }
                else if(save == '/'){
                    answer = leftNumber / rightNumber;
                }
                else if(save == '^'){
                    answer = (float) Math.pow(leftNumber,rightNumber);
                }
                theStack.push(answer);


            }
        }
        return theStack.pop();
    }
}