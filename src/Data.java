import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class Data {

	private static ArrayList<String> adjectives = new ArrayList<>();
	private static ArrayList<String> mainDish = new ArrayList<>();
	private static ArrayList<String> accessory = new ArrayList<>();
	private static HashSet<String> dishes = new HashSet<>();

	public Data() {
		
	}
	
	
	

	public static HashSet<String> getDishes() {
		return dishes;
	}




	public static void begin() {

		adjectives.add("Hot");
		adjectives.add("Green");
		adjectives.add("Red");
		adjectives.add("Spicy");
		adjectives.add("Iced");
		adjectives.add("Chilly");
		adjectives.add("Blue");
		adjectives.add("Rainbow");
		adjectives.add("Tasty");
		adjectives.add("Fast");
		adjectives.add("Delicious");
		adjectives.add("Organic");
		adjectives.add("Biodynamic");
		adjectives.add("Yummy");
		adjectives.add("Dutch");
		adjectives.add("Asian-style");
		adjectives.add("Cosmopolitan");
		adjectives.add("Rare");
		adjectives.add("Medium");
		adjectives.add("Well Done");
		adjectives.add("European-style");
		adjectives.add("American-style");
		adjectives.add("Genuine");
		adjectives.add("French");
		adjectives.add("Japanese");
		adjectives.add("American");
		adjectives.add("Chinese");
		adjectives.add("Boiled");
		adjectives.add("Braised");
		adjectives.add("Steamed");
		adjectives.add("Cooked");
		adjectives.add("Sweet");
		adjectives.add("Salty");
		adjectives.add("Sweet and Sour");
		adjectives.add("Sour");
		adjectives.add("Bitter");
		adjectives.add("Raw");
		adjectives.add("Fermented");
		adjectives.add("Tender");
		adjectives.add("Smoked");
		adjectives.add("Soft");
		adjectives.add("Baked");
		adjectives.add("Spanish");
		adjectives.add("Fresh");
		adjectives.add("Virgin");

		mainDish.add("Spaghetti");
		mainDish.add("Ravioli");
		mainDish.add("Dumplings");
		mainDish.add("Chicken");
		mainDish.add("Bacon");
		mainDish.add("Sushi");
		mainDish.add("Tofu");
		mainDish.add("Octopus");
		mainDish.add("Lasagna");
		mainDish.add("Koldskål");
		mainDish.add("Barbecue");
		mainDish.add("Potatoes");
		mainDish.add("Carrots");
		mainDish.add("Lutefisk");
		mainDish.add("Miso Soup");
		mainDish.add("Chili Soup");
		mainDish.add("Veggie Soup");
		mainDish.add("Asparagus");
		mainDish.add("Pork Soup");
		mainDish.add("Cabbage");
		mainDish.add("Ice Cream");
		mainDish.add("Mashed Potatoes");
		mainDish.add("Peking Chicken");
		mainDish.add("Ramen Noodles");
		mainDish.add("Calamari");
		mainDish.add("Ramen Noodles");
		mainDish.add("Caesar Salad");
		mainDish.add("Bacon Salad");
		mainDish.add("Sirloin");
		mainDish.add("T-bone Steak");
		mainDish.add("Foie Gras");		
		mainDish.add("Marlin");
		mainDish.add("Salmon");
		mainDish.add("Cod");
		mainDish.add("Trout");
		mainDish.add("Beef");
		mainDish.add("Pork");
		mainDish.add("Tuna");
		mainDish.add("Pizza");
		mainDish.add("Spareribs");
		mainDish.add("Prawns");
		mainDish.add("Steak");
		mainDish.add("Pancakes");

		accessory.add("Curry");
		accessory.add("Oregano");
		accessory.add("Chili");
		accessory.add("Bell Pepper");
		accessory.add("Ghost Pepper");
		accessory.add("Cumin");
		accessory.add("Cranberries");
		accessory.add("Watermelon");
		accessory.add("Pineapple");
		accessory.add("Candy");
		accessory.add("Onion Rings");
		accessory.add("Fortune Cookies");
		accessory.add("Pretzels");
		accessory.add("Cupcakes");
		accessory.add("Cucumbers");
		accessory.add("Cookies");
		accessory.add("Caviar");
		accessory.add("Bolognese Sauce");
		accessory.add("Parmesan");
		accessory.add("Dressing");
		accessory.add("Gravy");
		accessory.add("Biscuits");
		accessory.add("Weed Cookies");
		accessory.add("Fries");
		accessory.add("Chips");
		accessory.add("Camembert");
		accessory.add("Sauce");
		accessory.add("Dill");
		accessory.add("Lemons");
		accessory.add("Oranges");
		accessory.add("Vegetable Oil");
		accessory.add("Omelet");
		accessory.add("Mozzarella");
		accessory.add("Shellfish");
		accessory.add("Tiramisu");

		System.out.println(adjectives.size() * mainDish.size() * accessory.size() * accessory.size() * adjectives.size()
				* adjectives.size());

	}

	public static void generateDishes() {
		if (mainDish.size() == 0) {
			begin();
		}
		for (int i = 0; i < 1500000; i++) {
			int i1 = new Random().nextInt(adjectives.size());
			String adj1 = (adjectives.get(i1));
			int i2 = new Random().nextInt(adjectives.size());
			String adj2 = (adjectives.get(i2));
			int i3 = new Random().nextInt(adjectives.size());
			String adj3 = (adjectives.get(i3));
			int i4 = new Random().nextInt(mainDish.size());
			String main = (mainDish.get(i4));
			int i5 = new Random().nextInt(accessory.size());
			String acc1 = (accessory.get(i5));
			int i6 = new Random().nextInt(accessory.size());
			String acc2 = (accessory.get(i6));

			dishes.add(adj1 + " " + main + " with " + adj2 + " " + acc1 + " and " + adj3 + " " + acc2);
			if (i % 50000 == 0) {
				System.out.println("Done processing " + i + " units.");
			}
		}
		try {
			FileWriter fwriter = new FileWriter("Dishes.csv");
			for (String s : dishes){
				fwriter.write(s + "," + GenerateRandData.time() + "," + GenerateRandData.price() + "," + GenerateRandData.karma() + "\r\n");
			}
			fwriter.close();
		} catch (IOException e) {
			System.out.println("An error occurred: " + e);
		}

		System.out.println("Done generating dishes.");
	}

}
