package inventoryProject;

import java.util.HashMap;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

class entity {
	HashMap<Integer, entity> obj = new HashMap<Integer, entity>();
	String EntityName;
	float Price;
	int qualtity;
	int SerialNumber;

	public void SetItem(String EntityName, float Price, int qualtity, int SerialNumber) {
		this.EntityName = EntityName;
		this.Price = Price;
		this.qualtity = qualtity;
		this.SerialNumber = SerialNumber;
	}

	public void getItem() {
		System.out.println("Seriel number: " + SerialNumber + ", Item: " + EntityName + ", Price: " + Price
				+ ", Quantity: " + qualtity);
	}
	
	
}

public class Inventory {
	int i =1;
	HashMap<String, Integer> Boughtobj = new HashMap<String, Integer>();
	HashMap<Integer, entity> obj = new HashMap<Integer, entity>();
	entity ob1 = new entity();
	entity ob2 = new entity();

	public void BuyProduct() {
		
		if (i == 1){
			
			ob1.EntityName = "Tea";
			ob1.Price = 40;
			ob1.qualtity = 200;
			ob1.SerialNumber = 1;
			ob2.EntityName = "Coffee";
			ob2.Price = 50;
			ob2.qualtity = 200;
			ob2.SerialNumber = 2;
			obj.put(1, ob1);
			obj.put(2, ob2);
			i++;
		}
		System.out.println("************Avaliable products******************");
		
		for (Map.Entry<Integer, entity> MapEntities : obj.entrySet()) {
			entity Item = MapEntities.getValue();
			Item.getItem();
		}
		System.out.println("************************************************");
		System.out.println("Please enter the Item Serial Number you wish to buy");
		Scanner sc = new Scanner(System.in);
		try{ int inputSerialNumber = sc.nextInt();
		switch (inputSerialNumber) {
		
		case 1:
			System.out.println("************************************************");
			System.out.println(" You selected to buy Tea");
			System.out.println("************************************************");
		/*	int newQuanitityTea =0;
			System.out.println("Please enter the quantity you wish to buy");
			int TeaQuantity = sc.nextInt();
			if(ob1.qualtity >= TeaQuantity && TeaQuantity>0 ){
				  newQuanitityTea = ob1.qualtity - TeaQuantity;
				 ob1.qualtity = newQuanitityTea;
				 obj.put(1, ob1);
				 int orderedQuantityTea = 200 - newQuanitityTea;
					Boughtobj.put("Tea", orderedQuantityTea);
				 
			}else{
				System.out.println("You entered a invalid quantity.");
				
			} *//*int x=0;
			for (Map.Entry<String, Integer> MapEntities : Boughtobj.entrySet()) {
				x++;
				String name = MapEntities.getKey();
				Integer value = MapEntities.getValue();
				System.out.println(x + "You have " + name + " " + value);
			} */
			Tea();
			Choise();
			break;
		case 2:
			System.out.println("************************************************");
			System.out.println(" You selected to buy Coffee");
			System.out.println("************************************************");
			Coffee();
		/*	int newQuanitity =0;
			System.out.println("Please enter the quantity you wish to buy");
			int CoffeeQuantity = sc.nextInt();
			if(ob2.qualtity >= CoffeeQuantity && CoffeeQuantity>0){
				  newQuanitity = 	ob2.qualtity - CoffeeQuantity;
				 ob2.qualtity = newQuanitity;
				 obj.put(2, ob2);
				 int orderedQuantityCoffee = 200 - newQuanitity;
					Boughtobj.put("Coffee", orderedQuantityCoffee);
			}else{
				System.out.println("The quantity you entered is more than the available quantity.");
				
			} 
			if (CoffeeQuantity<0) {
				System.out.println("I am sorry you have entered invalid quantity");
			} */
			Choise();
			break;
		
		default:
			System.out.println("You entered a invalid number please enter a vaild number ");
			BuyProduct();
		}
	}catch(InputMismatchException e){
		System.out.println("You entered a invalid number please enter a vaild number ");
		BuyProduct();
	}
	}
public void Coffee(){
	int newQuanitity =0;
	Scanner sc = new Scanner(System.in);
	System.out.println("Please enter the quantity you wish to buy");
	int CoffeeQuantity = sc.nextInt();
	if(ob2.qualtity >= CoffeeQuantity && CoffeeQuantity>0){
		  newQuanitity = 	ob2.qualtity - CoffeeQuantity;
		 ob2.qualtity = newQuanitity;
		 obj.put(2, ob2);
		 int orderedQuantityCoffee = 200 - newQuanitity;
			Boughtobj.put("Coffee", orderedQuantityCoffee);
	}else{ if (ob1.qualtity == 0){
		System.out.println("Tea is sold out");
		BuyProduct();
		
	} else {
		System.out.println("You entered a invalid quantity.");
	}
	}
}
public void Tea(){
	int newQuanitityTea =0;
	Scanner sc = new Scanner(System.in);
	System.out.println("Please enter the quantity you wish to buy");
	int TeaQuantity = sc.nextInt();
	if(ob1.qualtity >= TeaQuantity && TeaQuantity>0 ){
		  newQuanitityTea = ob1.qualtity - TeaQuantity;
		 ob1.qualtity = newQuanitityTea;
		 obj.put(1, ob1);
		 int orderedQuantityTea = 200 - newQuanitityTea;
			Boughtobj.put("Tea", orderedQuantityTea);
		 
	}else{ if (ob1.qualtity == 0){
		System.out.println("Tea is sold out");
		BuyProduct();
		
	} else {
		System.out.println("You entered a invalid quantity.");
	}
	}
}
	public void MainMenu() {
		
		System.out.println("************Please select the option************");
		System.out.println("1- Buy the product");
		System.out.println("2- Viw your cart");
		System.out.println("3- Exit");
		System.out.println("************************************************");
		Scanner sc = new Scanner(System.in);
		try {int inputOption = sc.nextInt();
		switch (inputOption) {
		case 1:
			BuyProduct();
			break;
		case 2: if(i == 1){
			System.out.println("At present you not have anything in your cart");
			MainMenu();
		} else {
			int x =0;
			System.out.println("**********Avaliable products in your cart*******");
			for (Map.Entry<String, Integer> MapEntities : Boughtobj.entrySet()) {
				x++;
				String name = MapEntities.getKey();
				Integer value = MapEntities.getValue();
				System.out.println(x + "- You have " +value + " " + name);
			} 
			System.out.println("************************************************");
			ViewCart();
		}
			break;
		case 3: 
			System.out.println("************************************************");
			System.out.println("                   Thank you                    ");
			System.out.println("************************************************");
			break;
		default:
			System.out.println("You entered the wrong input Please enter the correct serial number");
			MainMenu();
		}
		}catch (InputMismatchException e){
			System.out.println("You entered a wrong input please enter the correct serial number");
			MainMenu();
		}
	}

	public void ViewCart(){
		Scanner sc = new Scanner(System.in);
		int x =0;
	
		System.out.println("************Enter the option********************");
		
		System.out.println("1- Continue shoping");
		System.out.println("2- Exit");
		System.out.println("************************************************");
		
	try{	int InputChoise = sc.nextInt();
		switch (InputChoise){
		case 1 :
			BuyProduct();
	
		case 2 :
			System.out.println("Thank you for shoping");
			break;
			default :
				System.out.println("You entered  a wrong option");
				
	} } catch(InputMismatchException e){
		System.out.println("You entered  a wrong option");
	}
		
	}

	public void Choise() {
		System.out.println("Do you wish to shop more please enter y for yes and n to go to main menu");
		Scanner sc = new Scanner(System.in);
		String choise = sc.nextLine();
		switch (choise) {
		case "y":
			BuyProduct();
			break;
		case "n":
			MainMenu();

			break;
		default:
			System.out.println("Please enter the correct input");
			Choise();
		}
	}

	
	public static void main(String[] arg) {	
		Inventory Obj = new Inventory();
		Obj.MainMenu();
	}
}
