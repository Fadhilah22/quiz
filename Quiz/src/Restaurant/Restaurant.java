import java.util.Scanner;
import java.util.ArrayList;

class Restaurant{

	public ArrayList<Menu> regularMenu;
	public ArrayList<Menu> specialMenu;
	Scanner scan = new Scanner(System.in);

	public void Restaurant(){
		this.regularMenu = new ArrayList<Menu>();
		this.specialMenu = new ArrayList<Menu>();
	}

	public void addRegularMenu(){
		String code="";
		String name="";
		int price=0;
		boolean notValidated = true;

		System.out.println("Add Regular Menu");
		System.out.println("========================");
						
		while(notValidated) {
			System.out.println("input menu code [Rxxx]: ");
			code = scan.nextLine();
			if(code.toCharArray()[0] != 'R') {
				System.out.println("Code must start with R");
			} else if(code.length() != 4){
				System.out.println("Code length must be 4 character");
			} else {
				for(int i = 1; i<code.length();i++){
					if(code.toCharArray()[i] < '0' || code.toCharArray()[i] > '9'){
						System.out.println("Code must start with R followed by numbers");
				 	}				
				}
			}

			for(Menu menu : regularMenu) {
				if (menu.code == code) {
				System.out.println("Menu code exists");
				} else {
					notValidated = false;
				}
			}
			
		}
		notValidated = true;
		while(notValidated){
			System.out.println("input menu name [5..20]: ");
			name = scan.nextLine();
			if(name.length() < 5 || name.length() > 20){
				System.out.println("name length must be bewteen 5 - 20 character");
			} else {
				notValidated = false;		
			}
		}
		notValidated = true;
		while(notValidated){
			System.out.println("input menu price [10.000 - 100.000]: ");
			price = scan.nextInt();
			if(price < 10000 || price > 100000){
				System.out.println("Price must be between 10.000 - 100.000");
			} else {
				notValidated = false;
			}
		}
		
		Menu newMenu = new Menu(0, code, name, price, 0);
		regularMenu.add(newMenu);
	}

public void addSpecialMenu(){
		String code="";
		String name="";
		int price=0;
		int discount=0;
		boolean notValidated = true;
		System.out.println("Add Special Menu");
		System.out.println("========================");
		while(notValidated) {
			System.out.print("input menu code [Sxxx]: ");
			code = scan.nextLine();
			if(code.toCharArray()[0] != 'S') {
				System.out.println("Code must start with S");
			} else if(code.length() != 4){
				System.out.println("Code length must be 4 character");
			} else {
				for(int i = 1; i<code.length();i++){
					if(code.toCharArray()[i] < '0' || code.toCharArray()[i] > '9'){
						System.out.println("Code must start with S followed by numbers");
				 	}				
				}
			}

			for(Menu menu : specialMenu) {
				if (menu.code == code) {
				System.out.println("Menu code exists");
				} else {
					notValidated = false;
				}
			}
			
		}
		notValidated = true;
		while(notValidated){
			System.out.print("input menu name [5..20]: ");
			name = scan.nextLine();
			if(name.length() < 5 || name.length() > 20){
				System.out.println("name lenght must be bewteen 5 - 20 character");
			} else {
				notValidated = false;		
			}
		}
		notValidated = true;
		while(notValidated){
			System.out.print("input menu price [10.000 - 100.000]: ");
			price = scan.nextInt();
			if(price < 10000 || price > 100000){
				System.out.println("Price must be between 10.000 - 100.000");
			} else {
				notValidated = false;
			}
		}

		notValidated = true;
		while(notValidated){
			System.out.print("input menu price [10 | 25 | 50]: ");
			discount = scan.nextInt();
			if(discount != 10 || discount != 25 || discount != 50){
				System.out.println("Enter valid discount [10 | 25 | 50]");
			} else {
				notValidated = false;		
			}
		}
		
		
		Menu newMenu = new Menu(1, code, name, price, 0);
		specialMenu.add(newMenu);
	}

	public void deleteRegularMenu(){
		String code="";
		boolean notValidated = true;
		System.out.println("Delete Regular Menu");
		System.out.println("========================");
		while(notValidated) {
			System.out.print("input menu code [Rxxx]: ");
			code = scan.nextLine();
			if(code.toCharArray()[0] != 'R') {
				System.out.println("Code must start with R");
			} else if(code.length() != 4){
				System.out.println("Code length must be 4 character");
			} else {
				for(int i = 1; i<code.length();i++){
					if(code.toCharArray()[i] < '0' || code.toCharArray()[i] > '9'){
						System.out.println("Code must start with R followed by numbers");
				 	} else {
						notValidated = false;
					}			
				}	
			}
		}
		for(Menu menu : regularMenu) {
			if(menu.code == code) {
				regularMenu.remove(menu);
			} else {
				System.out.println("Code is Wrong");
			}
		}
	}

	public void deleteSpecialMenu(){
		String code="";
		boolean notValidated = true;
		System.out.println("Delete Special Menu");
		System.out.println("========================");
		while(notValidated) {
			System.out.print("input menu code [Sxxx]: ");
			code = scan.nextLine();
			if(code.toCharArray()[0] != 'S') {
				System.out.println("Code must start with S");
			} else if(code.length() != 4){
				System.out.println("Code length must be 4 character");
			} else {
				for(int i = 1; i<code.length();i++){
					if(code.toCharArray()[i] < '0' || code.toCharArray()[i] > '9'){
						System.out.println("Code must start with S followed by numbers");
				 	} else {
						notValidated = false;
					}			
				}	
			}
		}
		for(Menu menu : specialMenu) {
			if(menu.code == code) {
				specialMenu.remove(menu);
			} else {
				System.out.println("Code is Wrong");
			}
		}
	}

	public void showAllMenu(){
		System.out.println("Regular Menu");
		for(Menu menu : this.regularMenu){
			System.out.println("" + menu.code + " " + menu.name + " " + menu.price);
		}
		
		System.out.println("Special Menu");
		for(Menu menu : this.specialMenu){
			System.out.println("" + menu.code + " " + menu.name + " " + menu.price + " " + menu.discount);
		}		

	}

	public void printMenu(){
		System.out.println("Family Restaurant");
		System.out.println("======================");
		System.out.println("1. Add Regular Menu");
		System.out.println("2. Add Specual Menu");
		System.out.println("3. Show All Menu");
		System.out.println("4. Delete Regular Menu");
		System.out.println("5. Delete Special Menu");
		System.out.println("6. Exit");
		System.out.print("Choice [1-6]: ");
	}

	public void menuApp(){
	// mui importante
		int option;
		boolean isRunning = true;
		while(isRunning){
			printMenu();
			option = scan.nextInt();
			if (option == 1){
				addRegularMenu();			
			} else if (option == 2){
				addSpecialMenu();
			} else if (option == 3){
				showAllMenu();
			} else if (option == 4) {
				deleteRegularMenu();
			} else if (option == 5) {
				deleteSpecialMenu();			
			} else if (option == 6) {
				System.exit(0);
			} else {
				System.out.println("Please select valid option");
			}
		}
	}

	public static void main(String[] args) {
		
		Restaurant restaurant = new Restaurant();
		restaurant.menuApp();
	}
}
