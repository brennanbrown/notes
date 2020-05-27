/**
 * This class contains information about a gizmo. Upon creation of an
 * instance of this class the quantity of a Gizmo must be set. From an  
 * instance of this class the Gizmo's ID, name, description, price and
 * Supplier ID can be obtained.
 *
 * @version     20 Jan 2017
 * @author      Brennan Brown
 */

import java.util.*;

public class Gizmo 
{
	

	/**
	 * The ID of each individual Gizmo
	 */
	private int id = 0;
	/**
	 * The name is each individual Gizmo
	 */
	private String name = null;
	/**
	 * The description of each individual Gizmo
	 */
	private String description = null;
	/**
	 * The price of each individual Gizmo
	 */
	private double price = 0.0;
	/**
	 * The supplier ID of each individual Gizmo
	 */
	private int supplierID = 0;
	/**
	 * The amount of each individual Gizmo in stock
	 */
	private int quantity = 0;
	
	/**
	 * Default Constructor
	 * @param id an int for the ID of each individual Gizmo
	 * @param description a String for the name is each individual Gizmo
	 * @param quantity an int for the amount of each individual Gizmo in stock
	 * @param price a double for the price of each individual Gizmo
	 * @param supplierID an int for the supplier ID of each individual Gizmo
	 */
	
	public Gizmo(int id, String description, int quantity, double price, int supplierID)
	{		
		this.id = id;
		this.description = description;
		this.quantity = quantity;
		this.price = price;
		this.supplierID = supplierID;
	}	
	
	/**
	 * 
	 * @return the ID of each individual Gizmo
	 */
	
	public int getID() 
	{
		return id;
	}
	
	/**
	 * 
	 * @return the description of each individual Gizmo
	 */
	
	public String getDescription() 
	{
		return description;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public int getSupplierID()
	{
		return supplierID;
	}

	/**
	 * 
	 * @return
	 */
	public int getQuantity() 
	{
		return quantity;
	}

	/**
	 * 
	 * @param newQuantity
	 */
	public void setQuantity(int newQuantity)
	{
		quantity = newQuantity;
	}

	/**
	 * 
	 */
	@Override
	public String toString()
	{		
		return 	"ID =" + id+", Description = " + description + ", quantity in stock = " + quantity + ", price = " + price+", SupplierID = " + supplierID;
	}
	
	/**
	 * 
	 */
	@Override
	public boolean equals(Object obj) 
	{
		if(obj instanceof Gizmo)
		{
			Gizmo inputGizmo = (Gizmo)obj;
			if(inputGizmo.id == this.id)
			{
				return true;
			}
		}
		return false;
	}


}

