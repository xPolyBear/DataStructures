public class BibleCoding1 {
    

    public static void main(String[] args) {
        System.out.println("");
        System.out.println("Years it would take to convert all humans to be disciple of Christ is " + Bible());
        System.out.println("Number of disciples needed to be taught to convert all humans to be disciples of Christ in 50 years is " + Bible50Years());
    }


    public static int Bible(){

        long humansTaught = 13L;
        int totalYears = 0;
        while(humansTaught < 7700000000L) {
            humansTaught = humansTaught + humansTaught * 2;
            totalYears = totalYears + 3;
        }

        return totalYears;
    }

    public static int Bible50Years(){
        int disciplesNeededToBeTaught = 0; 
        
        while(true) {
            long humansTaught = 13L;
            int totalYears = 0;
    
            while(humansTaught < 7700000000L) {
                humansTaught = humansTaught + humansTaught * disciplesNeededToBeTaught;
                totalYears = totalYears + 3;
                if(totalYears > 50) {
                    break;
                }
            }

            if(totalYears > 50) {
                disciplesNeededToBeTaught++;
            }
            else {
                break;
            }
        
        }
        return disciplesNeededToBeTaught;
        
    }

}