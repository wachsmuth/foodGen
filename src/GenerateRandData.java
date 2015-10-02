/***
	* BULK INSERT WITH:
	* LOAD DATA INFILE 'C:/DataSet.csv'
	* INTO TABLE test.LargeDataSet
	* FIELDS TERMINATED BY ','
	* LINES TERMINATED BY '\r\n';
	***/
	import java.io.FileWriter;
	import java.io.IOException;
	import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.math.BigInteger;

	public class GenerateRandData
	{
		
		private static SecureRandom random = new SecureRandom();
		private static ArrayList<String> weekdayArray = new ArrayList<>();
		private static ArrayList<String> monthArray = new ArrayList<>();
		private static ArrayList<String> dishes = new ArrayList<>();
		public static void main(String[] args){
			Collections.shuffle(dishes);
			weekdayArray.add("Monday");
			weekdayArray.add("Tuesday");
			weekdayArray.add("Wednesday");
			weekdayArray.add("Thursday");
			weekdayArray.add("Friday");
			weekdayArray.add("Saturday");
			weekdayArray.add("Sunday");
			monthArray.add("January");
			monthArray.add("February");
			monthArray.add("March");
			monthArray.add("April");
			monthArray.add("May");
			monthArray.add("June");
			monthArray.add("July");
			monthArray.add("August");
			monthArray.add("September");
			monthArray.add("Oktober");
			monthArray.add("November");
			monthArray.add("December");
			Data.generateDishes(); 
			users();
			extras();
			
			System.out.println("I'm done!!!");
		}
		
		private static String getRandomWeekday(){
			return weekdayArray.get((int) Math.floor(Math.random()*7));
		}
		
		private static String getRandomMonth(){
			return monthArray.get((int) Math.floor(Math.random()*12));
		}
		
		public static String karma(){
			return "" + (int) Math.floor(Math.random()*101);
		}
		
		public static String time(){
			return "" + ((int) Math.floor(Math.random()*4)) + ":" + 5*((int) Math.floor(Math.random()*11));
		}
		
		public static String price(){
			return "" + (int) Math.floor(Math.random()*1001);
		}
		
		public static void users(){
			
			ArrayList<String> dishArray = new ArrayList<String>(Data.getDishes());
			try{
				FileWriter karmaWriter = new FileWriter("Karma.csv");
				FileWriter favDishWriter = new FileWriter("FavDish.csv");
				
				for(int i = 0;i <= 1000000; i++) {
					
					karmaWriter.write(i + "," + karma() +"\r\n");
					int i1 = new Random().nextInt(dishArray.size());
					String dish = dishArray.get(i1);
					favDishWriter.write(i + "," + dish + "," + karma() +"\r\n");
					if (i % 100000 == 0){
						System.out.println("Done processing " + i + " karma units.");
					}
				}
				
				karmaWriter.close();
				favDishWriter.close();
			}
			catch(IOException e){
				System.out.println("An error occurred: " + e);
			} 
		}
		
		public static void extras(){
			ArrayList<String> dishArray = new ArrayList<String>(Data.getDishes());
			try{
				FileWriter extraWriter = new FileWriter("Extras.csv");
				
				for(int i = 0;i <= 10000; i++) {
					int range = ThreadLocalRandom.current().nextInt(2, 20);
					for (int j = 0; j <= range; j++)
					{
						int i1 = new Random().nextInt(dishArray.size());
						String dish = dishArray.get(i1);
						extraWriter.write(i + "," + dish + "\r\n");
					}
					if (i % 5000 == 0){
						System.out.println("Done processing " + i + " extra units.");
					}
				}
				
				extraWriter.close();
			}
			catch(IOException e){
				System.out.println("An error occurred: " + e);
			} 
		}
		}
	