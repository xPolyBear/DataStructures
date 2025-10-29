public class BibleCoding2 {
    

    public static void main(String[] args) {
        System.out.println("");
       
        System.out.println("Years based on the stated requirements: " + People.Bible3());
    }
    

    public static class People
    {
        int age;
        int humansTaught;

        public People(int age, int humansTaught) 
		{
			this.age = age;
            this.humansTaught = humansTaught;
		}

        public static int Bible3()
        {
            int years = 0;
            int maxAge = 72;

            long amountOfHumans = 100000000L;//had to lower the amount of humans to make it so that it doesn't crash
            long humansTaught = 13L;

            People[] people = new People[13];

            for(int i = 0; i < 13; i++) {
                people[i] = new People(18, 1);
            }

            while(humansTaught < amountOfHumans)
            {
                years = years + 3;

                People[] newPeople = new People[people.length * 2];

                for(int i = 0; i < people.length; i++) {//had to get help making sure that it makes new Disciples
                    newPeople[i] = people[i];           //and not just teaching the same 13 disciples over and over
                    newPeople[i + people.length] = new People(18, 1);
                    
                }
                people = newPeople;


                for(int i = 0; i < people.length; i++) {

                    people[i].age = people[i].age + 3;

                    if(people[i].age >= 18 && people[i].age <= maxAge) {
                        humansTaught = humansTaught + people[i].humansTaught * 2;
                    }

                    if(people[i].age == 30 && i % 2 == 0) {
                        amountOfHumans++;
                    }
                }

            }

            return years;
        }
    }  

}