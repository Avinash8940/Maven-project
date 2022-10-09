package com.furnitureapp.main;

import java.util.Scanner;
import com.furnitureapp.model.Category;
import com.furnitureapp.model.Furniture;
import com.furnitureapp.model.Material;
import com.furnitureapp.model.Type;
import com.furnitureapp.model.User;
import com.furnitureapp.service.CartServiceImpl;
import com.furnitureapp.service.FurnitureServiceImpl;
import com.furnitureapp.service.ICartService;
import com.furnitureapp.service.IFurnitureService;
import com.furnitureapp.service.IUserService;
import com.furnitureapp.service.UserServiceImpl;

/**
 * @author AvinashSankineni
 *
 */
public class Main {
	public static void main(String[] args) {
		IUserService userService = new UserServiceImpl();
		IFurnitureService service = new FurnitureServiceImpl();
		ICartService cart = new CartServiceImpl();
		Scanner sc = new Scanner(System.in);
		System.out.println("............WELCOME TO OUR FURNITURE APP..........");
		boolean flag = false;
		System.out.println("PLEASE ENTER.....\n1.Admin\n2.User");
		int choose = sc.nextInt();
		sc.nextLine();
		if (choose == 1) {
			String type = "Admin";
			System.out.println("please enter username");
			String username = sc.nextLine();
			// sc.nextLine();
			System.out.println("please enter your password");
			String password = sc.nextLine();
			userService.login(username, password, type);
			System.out.println("Welcome Admin\nchoose your option");
			System.out.println("1.Add Furniture\n2.Update Furniture\n3.Delete Furniture\n4.change password");
			int choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
			case 1:
				System.out.println("Enter  furniture id");
				int furnitureid = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter  furniture name");
				String furnitureName = sc.nextLine();
				System.out.println("Enter material\t0.STEEL\t1.IRON\t2.WOOD\t3.DECOLAM   4.GLASS");
				int option = sc.nextInt();
				sc.nextLine();
				String material = Material.values()[option].material;
				System.out.println(
						"Enter type\t0.TWOSOFA\t1.FOURSOFA\t2.BEDS\t3.SINGLEBED\n4.TABLES\t5.CENTERTABLE\t6.CHAIRS\t7.STUDYCHAIR  8.RACKS");
				choose = sc.nextInt();
				sc.nextLine();
				String type1 = Type.values()[choose].type;
				System.out.println("Enter category\t0.STUDYROOM\t1.HALL\t2.BEDROOM  3.DINING  4.OFFICE");
				int select = sc.nextInt();
				sc.nextLine();
				String category = Category.values()[select].category;
				System.out.println("Enter shape");
				String shape = sc.nextLine();
				System.out.println("Enter price");
				Double price = sc.nextDouble();
				sc.nextLine();
				System.out.println("Enter quantity");
				int quantity = sc.nextInt();
				sc.nextLine();
				Furniture furniture = new Furniture(furnitureid, furnitureName, material, type1, category, shape, price,
						quantity);
				service.addFurniture(furniture);
				System.out.println("Added successfully");
				break;
			case 2:
				System.out.println("Enter furniture Id");
				int furnitureId = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter price");
				price = sc.nextDouble();
				sc.nextLine();
				System.out.println(service.updateFurniture(furnitureId, price));
				System.out.println("Updated successfully");
				break;
			case 3:
				System.out.println("Enter furniture Id");
				furnitureId = sc.nextInt();
				sc.nextLine();
				service.deleteFurniture(furnitureId);
				System.out.println("Deleted successfully");
				break;
			case 4:
				System.out.println("please enter username");
				username = sc.nextLine();
				System.out.println("please enter your password");
				password = sc.nextLine();
				userService.changePassword(username, password);
				break;
			default:
				System.out.println("you opted wrong option");
				break;
			}
		} else {
			System.out.println("Please Enter \n1.For Registration\n2.For Login ");
			int setChoice = sc.nextInt();
			sc.nextLine();
			User user = null;
			if (setChoice == 1) {
				user = new User();
				String type = "user";
				System.out.println("please enter username");
				String username = sc.nextLine();
				System.out.println("enter name");
				String name = sc.nextLine();
				System.out.println("enter mobile no:");
				long mobileNo = sc.nextLong();
				sc.nextLine();
				System.out.println("enter email");
				String email = sc.nextLine();
				System.out.println("enter city");
				String city = sc.nextLine();
				User userList = new User(username, name, mobileNo, email, city, type);
				userService.register(userList);

			} else {
				String type = "user";
				System.out.println("please enter username");
				String username = sc.nextLine();
				System.out.println("please enter your password");
				String password = sc.nextLine();
				user = userService.login(username, password, type);
			}
			do {
				System.out.println("welcome user");
				System.out.println(
						"1.Get Furniture by id\n2.Get All Furnitures\n3.Get Furniture by category\n4.Get Furniture by type\n5.Get Furniture By Category And Type\n6.Get Furniture By Name And Shape\n7.Get Furniture By Name And Material\n8.Get Furniture By Name And Price\n9.Get Furniture By Name And Category\n10.Change Password\n11.Add to cart\n12.delete cart by furnitureId\n 3.Purchase Cart by username");
				int choice = sc.nextInt();
				sc.nextLine();
				switch (choice) {
				case 1:
					System.out.println("Enter furniture Id");
					int furnitureId = sc.nextInt();
					sc.nextLine();
					System.out.println(service.getById(furnitureId));
					break;

				case 2:
					service.getAllFurnitures().forEach(System.out::println);
					break;

				case 3:
					System.out.println("Enter category\t0.STUDYROOM\t1.HALL\t2.BEDROOM  3.DINING  4.OFFICE");
					int select = sc.nextInt();
					sc.nextLine();
					String category = Category.values()[select].category;
					service.getByCategory(category).forEach(System.out::println);
					break;

				case 4:
					System.out.println(
							"Enter type\t0.TWOSOFA\t1.FOURSOFA\t2.BEDS\t3.SINGLEBED\n4.TABLES\t5.CENTERTABLE\t6.CHAIRS\t7.STUDYCHAIR  8.RACKS");
					choose = sc.nextInt();
					sc.nextLine();
					String type = Type.values()[choose].type;
					service.getByType(type).forEach(System.out::println);
					break;

				case 5:
					System.out.println("Enter category\t0.STUDYROOM\t1.HALL\t2.BEDROOM  3.DINING  4.OFFICE");
					select = sc.nextInt();
					sc.nextLine();
					category = Category.values()[select].category;
					System.out.println(
							"Enter type\t0.TWOSOFA\t1.FOURSOFA\t2.BEDS\t3.SINGLEBED\n4.TABLES\t5.CENTERTABLE\t6.CHAIRS\t7.STUDYCHAIR  8.RACKS");
					choose = sc.nextInt();
					sc.nextLine();
					type = Type.values()[choose].type;
					service.getByCategoryAndType(category, type).forEach(System.out::println);
					break;

				case 6:
					System.out.println("Enter furniture name");
					String furnitureName = sc.nextLine();
					System.out.println("Enter furniture shape");
					String shape = sc.nextLine();
					service.getByNameAndShape(furnitureName, shape).forEach(System.out::println);
					break;

				case 7:
					System.out.println("Enter furniture name");
					furnitureName = sc.nextLine();
					System.out.println("Enter material\t0.STEEL\t1.IRON\t2.WOOD\t3.DECOLAM   4.GLASS");
					int option = sc.nextInt();
					sc.nextLine();
					String material = Material.values()[option].material;
					service.getByNameAndMaterial(furnitureName, material).forEach(System.out::println);
					break;

				case 8:
					System.out.println("Enter furniture name");
					furnitureName = sc.nextLine();
					System.out.println("Enter furniture price");
					double price = sc.nextDouble();
					sc.nextLine();
					service.getByNameAndPrice(furnitureName, price).forEach(System.out::println);
					break;

				case 9:
					System.out.println("Enter furniture name");
					furnitureName = sc.nextLine();
					System.out.println("Enter category\t0.STUDYROOM\t1.HALL\t2.BEDROOM  3.DINING  4.OFFICE");
					select = sc.nextInt();
					sc.nextLine();
					category = Category.values()[select].category;
					service.getByNameAndCategory(furnitureName, category).forEach(System.out::println);
					break;

				case 10:
					System.out.println("please enter username");
					String username = sc.nextLine();
					System.out.println("please enter your password");
					String password = sc.nextLine();
					userService.changePassword(username, password);
					break;
				case 11:
					System.out.println("Enter furntureId");
					furnitureId = sc.nextInt();
					System.out.println("Enter quantity");
					int quantity = sc.nextInt();
					Furniture furniture = cart.getAvailability(furnitureId, quantity);
					cart.addCart(furniture, user);
					break;
				case 12:
					System.out.println("Enter furnitureId");
					furnitureId = sc.nextInt();
					sc.nextLine();
					System.out.println("Enter username");
					username=sc.next();
					cart.deleteCart(furnitureId,username);
					break;
				case 13:
					System.out.println("Enter username");
					username=sc.nextLine();
					cart.purchase(username).forEach(System.out::println);
					break;
				default:
					System.out.println("YOU HAVE ENTERD WRONG ONE....\n CHOOSE CORRECT ONE");
					break;
				}
				System.out.println("Do you want to continue\n1.continue\n2.exit");
				int enter = sc.nextInt();
				sc.nextLine();
				if (enter == 1)
					flag = true;
				else
					flag = false;

			} while (flag);
			System.out.println("Thank You....Visit Again....");
			sc.close();
		}
	}
}
