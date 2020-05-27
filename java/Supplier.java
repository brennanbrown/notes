

import java.util.ArrayList;

public class Supplier {
	private int id;
	private String companyName;
	private String address;
	private String salesContact;
	private ArrayList<Integer> gizmosIds;

	public Supplier(int id, String companyName, String address, String salesContact, ArrayList<Integer> gizmosIds) {
		this.id = id;
		this.companyName = companyName;
		this.address = address;
		this.salesContact = salesContact;
		this.gizmosIds = gizmosIds;
	}

	public int getID() {
		return this.id;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public String getSalesContact() {
		return this.salesContact;
	}

	public ArrayList<Integer> getGizmosIds() {
		return this.gizmosIds;
	}

	public void addNewGizmo(int gizmoId) {
		this.gizmosIds.add(gizmoId);
	}

	@Override
	public String toString() {
		return "ID= " + this.id + ", CompanyName = " + this.companyName + ", address= " + this.address
				+ ", sales contact= " + this.salesContact + ", Gizmo list = " + gizmosIds;
		//You can use Arrays.toString() or a helper method for printing an array
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Supplier) {
			Supplier inputSupplier = (Supplier) obj;
			if (inputSupplier.id == this.id) {
				return true;
			}
		}
		return false;
	}
	// Helper method ---------------------------------------------------------
	// You can use this helper method in writing your toString method if your
	// gizmosIds is an int array
	private String printGizmoIds()
	{
		String ids = "";
		for (int i = 0; i < gizmosIds.length; i++) 
		{
			ids += gizmosIds[i];
			ids += ", ";
		}
		return ids;
	}
}
