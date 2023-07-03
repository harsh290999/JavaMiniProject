package org.example.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import org.example.domain.Pet;
import org.example.domain.Sort;
import org.example.test.PetTest;
import org.example.domain.ArrayListOp;
import org.example.utils.*;

public class Program {

	static Scanner sc = new Scanner(System.in);

	private static Pet[] getArray() {
		System.out.print("How many pets sales you want to store : ");
		int n = sc.nextInt();
		Pet[] arr = new Pet[n];
		// System.out.println("Enter below pet details : ");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new Pet();
			System.out.println();
			System.out.println("Add details of pet sales [" + (i + 1) + "]");
			System.out.println("Enter Pet Species: ");
			sc.nextLine();
			arr[i].setSpecies(sc.nextLine());
			System.out.println("Enter Breed of pet : ");
			arr[i].setBreed(sc.nextLine());
			System.out.println("Enter Gender of pet: ");
			arr[i].setGender(sc.nextLine());
			System.out.println("Enter Age of pet: ");
			arr[i].setAge(sc.nextInt());
			System.out.println("Enter Pet ID: ");
			arr[i].setPetId(sc.nextInt());
			System.out.println("Enter Pet Price: ");
			arr[i].setPrice(sc.nextFloat());
			System.out.println();
		}
		return arr;
	}

	private static void getPetId(int[] petId) {
		if (petId != null) {
			System.out.print("Enter pet id	:	");
			petId[0] = sc.nextInt();
		}
	}

	private static void printRecord(Pet pet) {
		if (pet != null)
			System.out.println(pet.toString());
		else
			System.out.println("Pet not found.");
	}
	static void showName() {
		System.out.println("=================================================================");
		System.out.println("_________Welcome to PETMART SALES RECORD MANAGEMENT SYSTEM_______");
		System.out.println("=================================================================");
	}
	static ArrayListOp menuList() {
		System.out.println("-----------------------------------------------------------------");
		System.out.println("1. Add Pet sales record");
		System.out.println("2. Find Pet sale record");
		System.out.println("3. View total revenue");
		System.out.println("4. Remove Pet sale record");
		System.out.println("5. View sold pets record");
		System.out.println("6. Exit");
		return ArrayListOp.values()[sc.nextInt() - 1];
	}

	private static Sort subMenuList() {
		System.out.println("-----------------------------------------------------------------");
		System.out.println("1. By ID");
		System.out.println("2. By Species");
		System.out.println("3. By Gender");
		System.out.println("4. By Breed");
		System.out.println("5. By Price");
		System.out.println("6.Exit");
		return Sort.values()[sc.nextInt() - 1];
	}

	public static void main(String[] args) {
		ArrayListOp ch;//reference of enum
		Sort s;  //reference of enum
		int pId[] = new int[1];
		PetTest test = new PetTest();
		test.setPetList(new ArrayList<>());
		Program.showName();
		while ((ch = Program.menuList()) != ArrayListOp.EXIT) {

			switch (ch) {
			// Add pet
			case ADD_PETS:
				Pet[] pet = Program.getArray();
				test.addPets(pet);
				break;
			// Find pet
			case FIND_PET:
				//get pet Id from user
				Program.getPetId(pId);
				Pet value;
				try {
					value = test.findPet(pId[0]); //pass by reference, 
					Program.printRecord(value);
				} catch (PetListNullException e) {
					e.printStackTrace();
				}

				break;
			case TOTAL_REVENUE:
				test.getRevenue();
				break;
			case REMOVE_PET:
				Program.getPetId(pId);
				boolean status = test.removePet(pId[0]);
				System.out.println(status ? " Pet sale record removed Successfully" : "Pet sale record not found");
				break;
			case SORT:
				while ((s = Program.subMenuList()) != Sort.EXIT) {
					Comparator<Pet> comparator = null;
					switch (s) {
					case BY_ID:
						comparator = new IdComparator();
						break;
					case BY_SPECIES:
						comparator = new SpeciesComparator();
						break;
					case BY_GENDER:
						comparator = new GenderComparator();
						break;
					case BY_BREED:
						comparator = new BreedComparator();
						break;
					case BY_PRICE:
						comparator = new PriceComparator();
						break;
					default:
						break;
					}
					test.printPets(comparator);
				}
			default:
				break;
			}
		}

	}

}
