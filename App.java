public class App {
	public static void main(String[] args)
	{
		Salesman[] salesmen = new Salesman[20];
        salesmen[0] = new Salesman("Katie", 1000);
        salesmen[1] = new Salesman("Jenny", 925);
        salesmen[2] = new Salesman("Finn", 950);
        salesmen[3] = new Salesman("Lincoln", 100);
        salesmen[4] = new Salesman("Tristen", 500);
        salesmen[5] = new Salesman("Michelle", 650);
        salesmen[6] = new Salesman("Scott", 50);
        salesmen[7] = new Salesman("Paige", 915);
        salesmen[8] = new Salesman("Lucky", 90);
        salesmen[9] = new Salesman("Taya", 355);
        salesmen[10] = new Salesman("Casey", 250);
        salesmen[11] = new Salesman("Poly", 900);
        salesmen[12] = new Salesman("Crystal", 800);
        salesmen[13] = new Salesman("Hollow", 700);
        salesmen[14] = new Salesman("Rose", 600);
        salesmen[15] = new Salesman("Ann", 775);
        salesmen[16] = new Salesman("Taylor", 555);
        salesmen[17] = new Salesman("Kim", 342);
        salesmen[18] = new Salesman("Edward", 128);
        salesmen[19] = new Salesman("Scarlet", 810);

        Salesman[] topFiveSalesmanBasedOnRevenueList = Salesman.TopFiveSalesmanBasedOnRevenue(salesmen);

		System.out.println();
        System.out.println("The Top Five Salesmen List - Based On Revenue:");
        for (int i = 0; i < topFiveSalesmanBasedOnRevenueList.length; i++) {
            System.out.println(topFiveSalesmanBasedOnRevenueList[i].salesmanName + ": " + topFiveSalesmanBasedOnRevenueList[i].salesmanRevenue);
        }
	}

	public static class Salesman
	{
		String salesmanName;
		int salesmanRevenue;
		
		public Salesman(String salesmanName, int salesmanRevenue) 
		{
			this.salesmanName = salesmanName;
			this.salesmanRevenue = salesmanRevenue;
		}

		public static Salesman[] TopFiveSalesmanBasedOnRevenue(Salesman[] salesmanList)
		{
			Salesman[] topFiveSalesman = new Salesman[5];
			Salesman switchMen = new Salesman("", 0);
			for (int x = 0; x < salesmanList.length; x++)
			{
				for (int k = x + 1; k < salesmanList.length; k++)
				{
					if(salesmanList[x].salesmanRevenue < salesmanList[k].salesmanRevenue)
					{
						switchMen = salesmanList[x];
						salesmanList[x] = salesmanList[k];
						salesmanList[k] = switchMen;
					}
				}
			}
			
			for (int i = 0; i < salesmanList.length; i++)
			{
				if(i < 5)
				{
					topFiveSalesman[i] = salesmanList[i];
				}
			}

			return topFiveSalesman;
		}


	}
}

