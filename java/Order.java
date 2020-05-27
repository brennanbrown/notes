package GizmoProject;

import java.text.SimpleDateFormat;
import java.util.*;

public class Order {
	// Attributes
	private int orderNumber;

	private String gizmoDescription;
	private int gizmoQuantity;

	private String supplierCompanyName;
	private String supplierSalesContact;

	private Date orderDate;
	private int quantityOrdered;

	// Constructors
	public Order(int orderNumber, String description, int quantity, String companyName, String salesContact,
			Date orderDate, int quantityOrdered) {
		
		this.orderNumber = orderNumber;
		this.gizmoDescription = description;
		this.gizmoQuantity = quantity;
		this.supplierCompanyName = companyName;
		this.supplierSalesContact = salesContact;
		this.orderDate = orderDate;
		this.quantityOrdered = quantityOrdered;
	}

	public String toString() {
		/*
		 * If this is a general format for printing orders, you should write it
		 * in the to string method of Order class. If this format is specific
		 * for the shops created by the RetailInventoryManager class, this
		 * method should be part of that class.
		 * 
		 * Here, we have assumed that This is a general format for printing
		 * Orders and any order must be printed with this format.
		 */
		String orderString = "";
		orderString += "*****************************************************************\n";
		// line 1
		orderString += formatLine("ORDER No. :", String.valueOf(this.orderNumber));
		// line 2
		orderString += '\n';
		// line 3
		orderString += formatLine("Gizmo Description:", this.gizmoDescription);
		// line 4
		orderString += formatLine("Current Number in stock:", String.valueOf(this.gizmoQuantity));
		// line 5
		orderString += formatLine("Amount ordered:", String.valueOf(this.quantityOrdered));
		// line 6
		orderString += '\n';
		// line 7
		orderString += formatLine("Manufacturer:", this.supplierCompanyName);
		// line 8
		orderString += formatLine("Sales Contact:", this.supplierSalesContact);
		// line 9
		orderString += '\n';
		// line 10
		SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd, yyyy");
		orderString += formatLine("Date Ordered:", sdf.format(orderDate));
		// line 11
		orderString += '\n';
		orderString += "*****************************************************************";

		return orderString;
	}

	private String formatLine(String title, String value) {
		String leftAlignedText;
		String rightAlignedText;
		leftAlignedText = String.format("%1$-" + 30 + "s", title);
		rightAlignedText = String.format("%1$" + 30 + "s", value);
		return leftAlignedText + rightAlignedText + '\n';
	}

}
