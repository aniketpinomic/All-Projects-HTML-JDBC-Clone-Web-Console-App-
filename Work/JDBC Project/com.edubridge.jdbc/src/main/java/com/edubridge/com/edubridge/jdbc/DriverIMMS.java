package com.edubridge.com.edubridge.jdbc;
public class DriverIMMS {

	public static void main(String[] args) {

		IMManagement object = new IMManagement();
		System.out.println("********************** Welcome India Mart Management **********************\n");
		System.out.println("\tChoose any Option : ");
		System.out.println("\t\t\t1 : Management ");
		System.out.println("\t\t\t2 : Shopping \n");
		System.out.println("******************************** India Mart ********************************");
		System.out.print("Choice : ");
		short choice = object.scannerObj.nextShort();
		System.out.println("\n");
		do {
			switch(choice) {
			case 1 :
				System.out.println("********************** Welcome India Mart Management **********************\n");
				System.out.println("\tChoose any Option : ");
				System.out.println("\t\t\t 1 : New Registration");
				System.out.println("\t\t\t 2 : If Already registered Go for Login directly \n");
				System.out.println("******************************** India Mart ********************************");
				
				int loginChoice = IMManagement.scannerObj.nextInt();
				switch (loginChoice) {
				case 1 :
					System.out.print("Enter user name as Employee ID");
					IMManagement.scannerObj.nextLine();
					String userIdAdmin = IMManagement.scannerObj.nextLine();
					System.out.print("Enter your Password");
					String passwordAdmin = IMManagement.scannerObj.nextLine();
					System.out.println("Your account Created Successfully");
					System.out.println("\n");
					
					object.Admin();
					
					if (IMManagement.flag==0) {
						IMManagement.flag=1;
					}
					break;
				}
				continue;

			case 2 :
				object.Stock();
				object.Customer();
				object.Cart();
				object.Bill();
				object.CustomerRecord();
				break;

			default :
				System.out.println("Please enter currect choice and try again...");
			}
			break;
		}
		while(choice<=2||choice>3);
	}

}
