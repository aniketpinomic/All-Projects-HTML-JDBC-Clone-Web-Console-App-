package com.edubridge.com.edubridge.jdbc;

import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class IMManagement extends IndiaMartManagement implements IndiaMart{
	static Scanner scannerObj = new Scanner(System.in);
	ProductList listOfProduct = new ProductList();
	private int totalItemInChart;
	private String customerName;
	private String address;
	static int flag = 1;
	private ArrayList <String> itemsInChart = new ArrayList<String>();
	private ArrayList <Integer> priseAfterPerchase = new ArrayList<Integer>();
	LocalDate date = LocalDate.now();
	LocalTime time = LocalTime.now();

	public int Stock() {
		// Stock method starts

		System.out.println("********************** Welcome India Mart Management **********************\n");
		System.out.println("Total Perchase Products: "+listOfProduct.product.size());

		int sum = 0;
		for(int prise : listOfProduct.productPrise) {
			sum += prise;
		}
		System.out.print("Total IndiaMart Cost : Rs. "+sum);
		System.out.println("\n__________________________________________________________________________");
		System.out.println("SrNo\tItem\t\t\t\tPrise");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");

		for (int ctr=0; ctr<listOfProduct.product.size();ctr++) {
			System.out.println(ctr+"\t"+listOfProduct.product.get(ctr)+"\t\t\t\t"+listOfProduct.productPrise.get(ctr));
		}
		System.out.println("____________________________________________________________________________");
		System.out.println("******************************** India Mart ********************************\n\n\n");
		return sum;
	}


	public void Admin() {
		// Admin method starts

		System.out.println("********************** Welcome India Mart Management **********************\n");
		System.out.println("View as Admin\n");
		System.out.println("\tChoose Option : ");
		System.out.println("\t\t\t1 : Add Item ");
		System.out.println("\t\t\t2 : Update Existing Item ");
		System.out.println("\t\t\t3 : Remove Item ");
		System.out.println("\t\t\t4 : Stock Details ");
		System.out.println("\t\t\t5 : Customer Record ");
		System.out.println("\t\t\t6 : Log Out \n");
		System.out.println("******************************** India Mart ********************************");

		System.out.print("Choice : ");
		short adminChoice = scannerObj.nextShort();
		System.out.println("\n\n\n");

		if(adminChoice==1) {
			//Add Item

			System.out.println("Product Name and Prise");
			System.out.print("Name : ");
			scannerObj.nextLine();
			String addProduct = scannerObj.nextLine();
			listOfProduct.product.add(listOfProduct.product.size(),addProduct);
			System.out.println();
			System.out.print("Prise : ");
			int addPrise = scannerObj.nextInt();
			//listOfProduct.productPrise.add(addPrise);
			//insert with prepared statement

			System.out.println("Product Added Successfully...!");
			Admin();
		}

		else if (adminChoice==2) {
			//Update List

			System.out.println("\n__________________________________________________________");
			System.out.println("SrNo\t\tItem\t\t\tPrise\n");

			for (int ctr=0; ctr<=listOfProduct.product.size()-1;ctr++) {
				System.out.println(ctr+"\t\t"+listOfProduct.product.get(ctr)+"\t\t\t"+listOfProduct.productPrise.get(ctr));
			}
			System.out.println("____________________________________________________________\n\n");

			System.out.print("\tIndex Number : ");
			short index = scannerObj.nextShort();
			System.out.print("\tUpdate Product Name : ");
			scannerObj.nextLine();
			String updateProduct = scannerObj.nextLine();
			System.out.print("\tUpdate Prise : ");
			int updatePrise = scannerObj.nextInt();

			//listOfProduct.product.set(index,updateProduct);
			//update product
			//listOfProduct.productPrise.set(index,updatePrise);
			//update prise
			System.out.println();
			System.out.println("Item Update Successfully...!\n");

			System.out.println("________________\n");
			System.out.println("1 : Continue ");
			System.out.println("2 : Exit \n");
			System.out.println("________________");
			System.out.println("Choice : ");
			short adminChoice1 = scannerObj.nextShort();
			System.out.println("\n\n\n");

			if(adminChoice1 == 1) {
				Admin();
			}
			else if (adminChoice1 == 2) {
				return;
			}
			else {
				return;
			}
		}

		else if (adminChoice==3) {
			//Remove Item 

			Stock();
			System.out.println("Enter Item Index Number : ");
			int removeItemIndex = scannerObj.nextInt();
			listOfProduct.product.remove(removeItemIndex);
			listOfProduct.productPrise.remove(removeItemIndex);
			System.out.println("Remove Item Successfully...!\n");
			Admin();
		}

		else if (adminChoice==4) {
			//Stock Details

			Stock();
			System.out.println("________________");
			System.out.println("1 : Continue ");
			System.out.println("2 : Exit ");
			System.out.println("________________");
			System.out.print("Choice : ");
			short adminChoice2 = scannerObj.nextShort();
			System.out.println("\n\n\n");

			if (adminChoice2==1) {
				Admin();
			}
			else if (adminChoice2==2) {
				return;
			}
			else {
				return;
			}
		}

		else if (adminChoice==5) {
			CustomerRecord();
		}
		
		else if (adminChoice==6) {
			System.out.println("You are Successfully Logged Out...");
			flag = 0;
		}

		else {
			System.out.println("Please Enter Valid Choice...!");
			Admin();
		}

	}


	public void Customer() {
		System.out.println("********************** Welcome India Mart Management **********************\n");
		System.out.println("View as Customer\n");
		System.out.println("\tChoose Option : ");
		System.out.println("\t\t\t\t1 : Purchase ");
		System.out.println("\t\t\t\t2 : Goto Cart ");
		System.out.println("\t\t\t\t3 : Billing ");
		System.out.println("\t\t\t\t4 : Back \n");
		System.out.println("********************************* India Mart *********************************");
		System.out.print("Choice : ");
		short customerChoice = scannerObj.nextShort();
		System.out.println("\n\n\n");

		if(customerChoice==1) {
			//System.out.println("Available Items \n");
			//Stock();

			System.out.print("How meany items you want? : ");
			int itemsWant = scannerObj.nextInt();

			for (int ctr1=0;ctr1<itemsWant;ctr1++) {
				System.out.print("Please enter "+ctr1+"th product number : ");
				short itemNO = scannerObj.nextShort();
				itemsInChart.add(listOfProduct.product.get(itemNO));
				priseAfterPerchase.add(listOfProduct.productPrise.get(itemNO));
			}

			System.out.println("--------->  All the items placed in cart  <---------");
			totalItemInChart = itemsWant;
			System.out.println("Total items are : "+totalItemInChart);

			System.out.println("\n__________________________________________________________________________");
			System.out.println("SrNo\tItem\t\t\t\tPrise");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			for(int ctr2=0;ctr2<itemsWant;ctr2++) {
				System.out.println(ctr2+"\t"+itemsInChart.get(ctr2)+"\t\t\t\t"+priseAfterPerchase.get(ctr2));
			}
			System.out.println("__________________________________________________________________________\n");


			System.out.println("_________________________");
			System.out.println("1 : Add items in cart");
			System.out.println("2 : View Cart");
			System.out.println("3 : Remove Items In Cart");
			System.out.println("4 : Continue");
			System.out.println("5 : Exit");
			System.out.println("_________________________");
			System.out.print("Choice : ");
			short customerChoice1 = scannerObj.nextShort();

			if(customerChoice1==1) {
				System.out.println("How menay items you want to add? ");
				int addItem = scannerObj.nextInt();

				for (int ctr1=0;ctr1<addItem;ctr1++) {
					System.out.print("Please enter "+ctr1+"th product number : ");
					short itemNO = scannerObj.nextShort();
					itemsInChart.add(listOfProduct.product.get(itemNO));
					priseAfterPerchase.add(listOfProduct.productPrise.get(itemNO));
				}

				System.out.println(addItem+" Items are added in cart");
				totalItemInChart = itemsWant+addItem;
				System.out.println("Total items are : "+totalItemInChart);
			}

			else if (customerChoice1==2) {
				Cart();
			}

			else if (customerChoice1==3) {
				System.out.println("How menay items you want to Remove? ");
				int removeItem = scannerObj.nextInt();

				for (int ctr1=0;ctr1<removeItem;ctr1++) {
					System.out.print("Please enter "+ctr1+"th product number : ");
					short itemNO = scannerObj.nextShort();
					itemsInChart.remove(listOfProduct.product.get(itemNO));
					priseAfterPerchase.remove(listOfProduct.productPrise.get(itemNO));
				}

				System.out.println(removeItem+" Items are remove in cart");
				totalItemInChart = itemsWant-removeItem;
				System.out.println("Total items are : "+totalItemInChart);
			}

			else if (customerChoice1==4) {
				Bill();
			}

			else {
				return;
			}

		}

		else if (customerChoice==2) {
			System.out.println("***************************** Your Cart ********************************");
			System.out.println("------------------------------------------------------------------------");
			Cart();
			System.out.println("------------------------------------------------------------------------\n");
			System.out.println("Items Quantity : "+itemsInChart.size());
			int sum = 0;
			for (int d : priseAfterPerchase) {
				sum += d;
			}
			System.out.println("Total cost : Rs."+sum);
			System.out.println("------------------------------------------------------------------------");
		}

		else if (customerChoice==3) {
			Bill();
			System.out.println("________________");
			System.out.println("1 : Continue ");
			System.out.println("2 : Exit ");
			System.out.println("________________");
			System.out.print("Choice: ");
			short customerChoice2 = scannerObj.nextShort();
			System.out.println("\n\n\n");

			if(customerChoice2==1) {
				Customer();
			}
			else if(customerChoice2==2) {
				return;
			}
			else {
				return;
			}
		}

		else {
			Stock();
		}

	}


	public void Cart() {
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("Item No\t\tItem\t\t\t\tPrise");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

		for (int ctr3=0; ctr3 < totalItemInChart; ctr3++) {
			short num = (short) (ctr3+1);
			System.out.println(num+"\t\t"+itemsInChart.get(ctr3)+"\t\t\t\t"+priseAfterPerchase.get(ctr3));
		}
		System.out.println("---------------------------------------------------------------------------");
	}


	public void Bill() {
		System.out.print("Click on 0 and enter to make a Bill...\n");
		int enter = scannerObj.nextInt();
		if(enter==0) {
			scannerObj.nextLine();
			System.out.print("Enter Your Name: ");
			customerName = scannerObj.nextLine();
			System.out.print("Enter Your Address: ");
			address = scannerObj.nextLine();
			System.out.println("\n\n\n");
		}
		else {
			System.out.println("Please click on Zero...");
			Bill();
		}

		System.out.println("******************************** Your Bill ********************************");
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("Customer Name: "+customerName);
		System.out.println("Customer Address: "+address);
		System.out.println("Date : "+date);
		System.out.println("Time : "+time);
		System.out.println();

		Cart();

		System.out.println("Total Items: "+itemsInChart.size());
		int sum = 0;
		for(int show : priseAfterPerchase) {
			sum+=show;
		}
		System.out.println("Total ammount without Discount : "+sum+"\n");

		if(sum>0&&sum<=500) {
			sum -= (sum/20);
			System.out.println("Congratulations... You are eligible for 5% Discount");
		}
		else if (sum>500&&sum<=1000) {
			sum -= (sum/18);
			System.out.println("Congratulations... You are eligible for 6% Discount");
		}
		else if (sum>1000&&sum<=1500) {
			sum -= (sum/16);
			System.out.println("Congratulations... You are eligible for 7% Discount");
		}
		else if (sum>1500&&sum<=2000) {
			sum -= (sum/14);
			System.out.println("Congratulations... You are eligible for 8% Discount");
		}
		else if(sum>2000&&sum<=2500){
			sum -= (sum/12);
			System.out.println("Congratulations... You are eligible for 9% Discount");
		}
		else {
			sum -= (sum/10);
			System.out.println("Congratulations... You are eligible for 10% Discount");
		}

		System.out.println("Total Bill with Discount: "+sum);
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("******************************** Thank You *********************************\n\n");

		File recordFile = new File("newFile.txt");
		String name = customerName;
		String customerAddress = address;

		try {
			FileWriter output = new FileWriter("newFile.txt");

			output.write("----------------------------------------------------------------------------");
			output.write("\nCustomer Name: "+name);
			output.write("\nCustomer Address: "+customerAddress);
			output.write("\nDate and Time: "+date+" "+time);
			output.write("\nQuantity: "+itemsInChart.size());
			output.write("\nList of Purchase Item: "+itemsInChart);
			output.write("\nTotal Purchasr Ammount: "+sum);
			output.write("\n----------------------------------------------------------------------------");
			output.close();
		}

		catch (Exception exception) {
			exception.getStackTrace();
		}

		System.out.println("Choose Option : ");
		System.out.println("1 : Customer Record ");
		System.out.println("2 : Continue ");
		System.out.println("3 : Exit ");
		System.out.print("Choice: ");
		short Billchoice1 = scannerObj.nextShort();
		System.out.println("\n\n\n");

		if(Billchoice1==1) {
			CustomerRecord();
		}
		else if(Billchoice1==2) {
			Customer();
		}
		else if (Billchoice1==3) {
			return;
		}

		else {
			System.out.println("Entered Choice is Incorrect...!\n");
			System.out.println("________________");
			System.out.println("1 : Continue ");
			System.out.println("2 : Exit ");
			System.out.println("________________");
			System.out.print("Choice: ");
			short Billchoice2 = scannerObj.nextShort();
			System.out.println();
			if(Billchoice2==1) {
				Customer();
			}
			else if(Billchoice2==2) {
				return;
			}
			else {
				System.out.println("Entered Choice is Incorrect...!\n");
			}
		}
	}


	public void CustomerRecord() {
		char[] array = new char [1000];
		try {
			FileReader input = new FileReader("newFile.txt");
			input.read(array);
			System.out.println("Customer Details\n");
			if(input!=null) {
				System.out.println(array);
			}
		}
		catch(Exception exception) {
			exception.getStackTrace();
		}

		System.out.println("________________");
		System.out.println("1 : Continue ");
		System.out.println("2 : Exit ");
		System.out.println("________________");
		System.out.print("Choice: ");
		short customerRecordChoice1 = scannerObj.nextShort();

		if(customerRecordChoice1==1) {
			Customer();
		}
		else {
			return;
		}
	}
}
