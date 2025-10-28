public class BibleCoding2 {
    

    public static void main(String[] args) {
        System.out.println("");
       
        System.out.println("Years based on the stated requirements: " + Bible2());
    }
    


    public static int Bible2(){

        int maxAge = 72;
        long amountOfHumans = 7700000000L;
        int age = 18;
        long humansTaught = 13L;
        int totalYears = 0;

        while(humansTaught < amountOfHumans) {
            humansTaught = humansTaught + humansTaught * 2;
            totalYears = totalYears + 3;
            age = age + 3;

            if(age == 30) {
                long babies = amountOfHumans / 2;
                amountOfHumans = amountOfHumans + babies;
            }

            if(age > maxAge) {
                age = maxAge;
            }
        }

        return totalYears;
    }



}