

import java.io.*;
import java.util.*;

public class RetailShop {
	private final int Quantity_THRESHOLD = 40;
	private final int ORDER_AMOUNT = 200;
	private final String GIZMO_FILE = "res/gizmos.txt";
	private final String SUPPLIER_FILE = "res/suppliers.txt";
	private final String ORDER_REPORT_FILE = "res/orderReport.txt";
	private ArrayList<Gizmo> gizmoList;
	private ArrayList<Supplier> supplierList;
	private ArrayList<Order> orderList;
	private int maxOrderId = 0;

	public RetailShop() throws FileNotFoundException {
		gizmoList = new ArrayList<Gizmo>();
		supplierList = new ArrayList<Supplier>();
		orderList = new ArrayList<Order>();
		
		loadGizmoRecords(GIZMO_FILE);
		loadSupplierRecords(SUPPLIER_FILE);

		System.out.println("The store is created");
	}

	public void sell(int gizmoID, int quantity) {
		Gizmo gizmoToSell = searchGizmoByID(gizmoID);
		
		if (gizmoToSell.getQuantity() < quantity) {
			System.out.println("Sorry, we are out of stock!");
		} else {
			int newQuantity = gizmoToSell.getQuantity() - quantity;
			gizmoToSell.setQuantity(newQuantity);
			System.out.println(quantity + "items of " + gizmoToSell.getDescription() + "is sold");
		}
	}

	public void addNewGizmo(Gizmo gizmo) {
		gizmoList.add(gizmo);
		System.out.println("New gizmo is added to the store \n");
	}

	public boolean deleteGizmoById(int gizmoId) {
		Gizmo gizmo;
		for (int i = 0; i < gizmoList.size(); i++) {
			gizmo = gizmoList.get(i);
			if (gizmo.getID() == gizmoId) {
				gizmoList.remove(i);
				System.out.println("Removed Gizmo id = " + gizmoId + "\n");
				return true;
			}
		}
		return false; // This could not find the gizmo id to delete it.
	}

	public void updateInventory(Gizmo gizmo, int quantity) {
		gizmo.setQuantity(quantity);
	}

	public Gizmo searchGizmoByName(String nameToFind) {
		Gizmo gizmo;
		for (int i = 0; i < gizmoList.size(); i++) {
			gizmo = gizmoList.get(i);
			if (gizmo.getDescription().equals(nameToFind)) {
				return gizmo;
			}
		}
		return null;
	}

	public Supplier searchForSupplierofGizmo(Gizmo gizmo) {
		Supplier supplier;
		int supplierID = gizmo.getSupplierID();
		for (int i = 0; i < supplierList.size(); i++) {
			supplier = supplierList.get(i);
			if (supplier.getID() == supplierID) {
				return supplier;
			}
		}
		return null;
	}

	public Gizmo[] searchGizmosOfSupplier(Supplier supplier) {
		ArrayList<Integer> idList = supplier.getGizmosIds();
		Gizmo[] gizmoList = new Gizmo[idList.size()];
		Gizmo gizmo;
		for (int i = 0; i < idList.size(); i++) {
			gizmo = searchGizmoByID(idList.get(i));
			gizmoList[i] = gizmo;
		}
		return gizmoList;
	}

	public void generateOrderList() {
		int orderNumber = maxOrderId++;
		Gizmo gizmo;
		for (int i = 0; i < gizmoList.size(); i++) {
			gizmo = gizmoList.get(i);
			if (checkQuantity(gizmo)) {
				Order order = new Order(orderNumber++, gizmo, searchForSupplierofGizmo(gizmo), new Date(),
						ORDER_AMOUNT);
				orderList.add(order);
			}
		}
	}

	public void saveOrderReport() throws FileNotFoundException {
		PrintWriter outputFile = new PrintWriter(ORDER_REPORT_FILE);
		Order order;
		for (int i = 0; i < orderList.size(); i++) {
			order = orderList.get(i);
			outputFile.println(order);
		}
		outputFile.close();
		System.out.println("Order report file is generated");
	}

	@Override
	public String toString() {
		return "Gizmo list =" + gizmoList + "\n" + "Supplier list =" + supplierList + "\n" + "Order list =" + orderList
				+ "\n";
	}

	// Helper methods
	// -------------------------------------------------------------
	private Gizmo searchGizmoByID(int idToFind) {
		for (int i = 0; i < gizmoList.size(); i++) {
			Gizmo gizmo = gizmoList.get(i);
			if (gizmo.getID() == idToFind) {
				return gizmo;
			}
		}
		System.out.println("Gizmo is not found");
		return null;
	}

	private Supplier searchForSupplierByID(int idToFind) {
		for (int i = 0; i < supplierList.size(); i++) {
			Supplier supplier = supplierList.get(i);
			if (supplier.getID() == idToFind) {
				return supplier;
			}
		}
		System.out.println("Supplier is not found");
		return null;
	}

	private boolean checkQuantity(Gizmo gizmo) {
		if (gizmo.getQuantity() < Quantity_THRESHOLD) {
			return true; // it needs to be reordered.
		} else {
			return false;
		}
	}

	private void loadGizmoRecords(String fileURL) throws FileNotFoundException {
		File file = new File(fileURL);
		Scanner inputFile = new Scanner(file);
		String line;
		String[] parts;
		int id;
		String description;
		int quantity;
		double price;
		int supplierID;
		Gizmo gizmo;

		while (inputFile.hasNextLine()) {
			line = inputFile.nextLine();
			parts = line.split(";");
			id = Integer.parseInt(parts[0]);
			description = parts[1];
			quantity = Integer.parseInt(parts[2]);
			price = Double.parseDouble(parts[3]);
			supplierID = Integer.parseInt(parts[4]);

			gizmo = new Gizmo(id, description, quantity, price, supplierID);
			gizmoList.add(gizmo);
		}
		inputFile.close();
	}

	private void loadSupplierRecords(String fileURL) throws FileNotFoundException {
		File file = new File(fileURL);
		Scanner inputFile = new Scanner(file);
		String line;
		String[] parts;

		int id;
		String companyName;
		String address;
		String salesContact;
		ArrayList<Integer> gizmoIds;
		String gizmoIdsString;
		String[] ids;
		while (inputFile.hasNextLine()) {
			line = inputFile.nextLine();
			parts = line.split(";");
			id = Integer.parseInt(parts[0]);
			companyName = parts[1];
			address = parts[2];
			salesContact = parts[3];
			
			gizmoIdsString = parts[4];
			ids = gizmoIdsString.split(":");
			gizmoIds = new ArrayList<Integer>();
			for (int i = 0; i < ids.length; i++) {
				gizmoIds.add(Integer.parseInt(ids[i]));
			}
			Supplier supplier = new Supplier(id, companyName, address, salesContact, gizmoIds);
			supplierList.add(supplier);
		}
	}

}
