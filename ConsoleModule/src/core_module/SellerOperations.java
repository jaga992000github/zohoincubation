package core_module;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import database.CRUD;
import database.SellerOperationsDB;

public class SellerOperations implements Operations {
	static String table;
	static int id;
	static Scanner scan=new Scanner(System.in);
	@Override
	public void operate() throws ClassNotFoundException, SQLException {
		table="sellers";
		//id=Login.id;
		id=9;
		String num="";int n=0;
		while(true) {
			System.out.println("1->View/Edit Profile"
					   + "\n2->Add Property"
					   + "\n3->View/Edit Property"
					   + "\n4->Show Mails"
					   + "\n5->View Transactions"
					   + "\n0->back");
			num=scan.next();
			try {
				n=Integer.parseInt(num);
			}
		    catch(NumberFormatException e) {
		    	System.out.println("please enter numbers only");
				operate();
		    }
			if(n==1) {
				editProfile();
			}
			else if(n==2){
				addProperty();
			}
			else if(n==3){
				editProperty();
			}
			else if(n==4){
				
			}
			else if(n==5){
				
			}
			else if(n==0){
				break;
			}
			else {
				System.out.println("please select given numbers only");
			}
		}
	}
	
	
	private void editProfile() throws ClassNotFoundException, SQLException {
		table="sellers";
		//id=Login.id;
		String num="";int n=0;
		while(true) {
			System.out.println("\n1->view"
				          	 + "\n2->edit/delete"
				             + "\n0->back");
			num=scan.next();
			try {
				n=Integer.parseInt(num);
			}
		    catch(NumberFormatException e) {
		    	System.out.println("please enter numbers only");
				editProfile();
		    }
			if(n==1) {
				ArrayList details=CRUD.readRow(table,id);
				//System.out.println(details);
				for(int i=0;i<details.size();i++) {
					System.out.println(i+1+")"+CRUD.getColumnNameByIndex("sellers",i+2)
					+": "+details.get(i));	
				}
			}
			else if(n==2) {
				while(true) {
					int i=0;
					ArrayList details=CRUD.readRow(table,id);
					for(i=0;i<details.size();i++) {
						System.out.println(i+1+"->"+CRUD.getColumnNameByIndex(table,i+2)
						+": "+details.get(i));	
					}
					System.out.println("\n-1->DeleateProfile\n0->Cancel\n\n"
							+ "please select field");
					int n1=scan.nextInt();
					if(n1==0) {
						break;
					}
					if(n1==-1) {
						CRUD.deleteRow(id,table);
						System.out.println("Your Profile Deleated Sucessfully");
						Main.main(null);
						break;
					}
					else if (n1>i||n1<0) {
						System.out.println("Please select valid number only");
					}
					else{
						System.out.println("Enter new value");
						String new_value=scan.next();
						String col=CRUD.getColumnNameByIndex(table, n1+1);
						CRUD.update(new_value,table,col,id);
					}
				}	
			}
			else if(n==0) {
				break;
			}
			else {
				System.out.println("Please select a valid Number");
			}
		}
	}
	private  void  editProperty(String Table) throws ClassNotFoundException, SQLException {
		SellerOperationsDB sodb=new SellerOperationsDB();
		table=Table;
		//id=Login.id;
		String num="";int n=0;
		while(true) {
			System.out.println("\n1->view"
				          	 + "\n2->edit/delete"
				             + "\n0->back");
			num=scan.next();
			try {
				n=Integer.parseInt(num);
			}
		    catch(NumberFormatException e) {
		    	System.out.println("please enter numbers only");
				editProfile();
		    }
		
			if(n==1) {
				if(table.equals("land")) {
					sodb.readLand(id);		
				}
				else {
					sodb.readHouse(id);
				}
			}	
			
			else if(n==2) {
				if(table.equals("land")) {
					sodb.readLand(id);}
				else {
					sodb.readHouse(id);}
				System.out.println("Select Property ID");
				int prop_id =scan.nextInt();
				while(true) {
					ArrayList details=new ArrayList<>();
					int i=0;
					try {
						details=sodb.readRow(table,prop_id);
					}
					catch(SQLException e) {
						System.out.println("There is no Property\n"
								+ "Please add a property and edit");
						break;
					}
					for(i=0;i<details.size();i++) {
						System.out.println(i+1+"->"+CRUD.getColumnNameByIndex(table,i+3)
						+": "+details.get(i));	
					}
					System.out.println("\n-1->DeleateProperty\n0->Cancel\n\n"
							+ "please select field");
					int n1=scan.nextInt();
					if(n1==0) {
						break;
					}
					if(n1==-1) {
						CRUD.deleteRow(prop_id,table);
						System.out.println("Your Property Deleated Sucessfully");
						break;
					}
					else if (n1>i||n1<0) {
						System.out.println("Please select valid number only");
					}
					else{
						System.out.println("Enter new value");
						String new_value=scan.next();
						String col=CRUD.getColumnNameByIndex(table, n1+2);
						CRUD.update(new_value,table,col,prop_id);
					}
				}	
			}
			else if(n==0) {
				break;
			}
			else {
				System.out.println("Please select a valid Number");
			}
		}
	}
	
	private void editProperty() throws ClassNotFoundException, SQLException {
		String num="";int n=0;
		while(true) {
			System.out.println("1->land"
					       + "\n2->house"
					   	   + "\n0->cancel");
			System.out.println("select property type");
			num=scan.next();
			try {
				n=Integer.parseInt(num);
			}
		    catch(NumberFormatException e) {
		    	System.out.println("please enter numbers only");
				editProperty();
		    }
			if(n==1) {
				editProperty("land");
			}
			else if(n==2) {
				editProperty("house");			}
			else if(n==0) {
				break;
			}
			else {
				System.out.println("please enter given number only");
			}
		}
	}
	
	
	private void addProperty() throws ClassNotFoundException, SQLException {
		String num="";int n=0;
		while(true) {
			System.out.println("1->land"
					       + "\n2->house"
					   	   + "\n0->cancel");
			System.out.println("select property type");
			num=scan.next();
			try {
				n=Integer.parseInt(num);
			}
		    catch(NumberFormatException e) {
		    	System.out.println("please enter numbers only");
				addProperty();
		    }
			if(n==1) {
				addLand();
			}
			else if(n==2) {
				addHouse();
			}
			else if(n==0) {
				break;
			}
			else {
				System.out.println("please enter given Numbers only");
			}
		}
	}
	
	private void addLand() throws ClassNotFoundException, SQLException {
		table="land";
		ArrayList land_values=new ArrayList();
		ArrayList selector=new ArrayList();
		land_values.add(id);
		String location="";
		while(location.equals("")) {
			selector.clear();
			System.out.println("Select Loction"
					+ "\n1->Chennai"
					+ "\n2->Thenkasi"
					+ "\n3->Coimbatore"
					);
			selector.add("Chennai");
			selector.add("Thenkasi");
			selector.add("Coimbatore");
			location=selector(selector);
			System.out.println(location);
		}
		land_values.add(location);
		
		System.out.println("Area in sqr.ft");
		int area= scan.nextInt();
		land_values.add(area);
		
		String dtcp="";
		while(dtcp.equals("")) {
			selector.clear();
			System.out.println("Having DTCP\n"
					+ "1->Yes\n2->No");
			selector.add("yes");
			selector.add("no");
			dtcp=selector(selector);
			System.out.println(dtcp);
		}
		land_values.add(dtcp);
		
		String prefered_for="";
		while(prefered_for.equals("")) {
			selector.clear();
			System.out.println("Select Preference"
					+ "\n1->Farming"
					+ "\n2->House Site"
					+ "\n3->Comercial"
					);
			selector.add("farming");
			selector.add("house site");
			selector.add("comercial");
			prefered_for=selector(selector);
			System.out.println(prefered_for);
		}
		land_values.add(prefered_for);
		
		String Available="";
		while(Available.equals("")) {
			selector.clear();
			System.out.println("Availabale status\n"
					+ "1->Yes\n2->No");
			selector.add("yes");
			selector.add("no");
			Available=selector(selector);
			System.out.println(Available);
		}
		land_values.add(Available);
		
		System.out.println("Total cost");
		int cost= scan.nextInt();
		land_values.add(cost);
		System.out.println(land_values);
		System.out.println("land registered sucessFully");
		CRUD.insert(land_values,table);
	}
	private  void addHouse() throws ClassNotFoundException, SQLException {
		table="house";
		ArrayList house_values=new ArrayList();
		ArrayList selector=new ArrayList();
		house_values.add(id);
		String location="";
		while(location.equals("")) {
			selector.clear();
			System.out.println("Select Loction"
					+ "\n1->Chennai"
					+ "\n2->Thenkasi"
					+ "\n3->Coimbatore"
					);
			selector.add("Chennai");
			selector.add("Thenkasi");
			selector.add("Coimbatore");
			location=selector(selector);
			System.out.println(location);
		}
		house_values.add(location);
		System.out.println("Area in sqr.ft");
		int area= scan.nextInt();
		house_values.add(area);
		String dtcp="";
		while(dtcp.equals("")) {
			selector.clear();
			System.out.println("Having DTCP\n"
					+ "1->Yes\n2->No");
			selector.add("yes");
			selector.add("no");
			dtcp=selector(selector);
			System.out.println(dtcp);
		}
		house_values.add(dtcp);
		
		String house_type="";
		while(house_type.equals("")) {
			selector.clear();
			System.out.println("Select House_type"
					+ "\n1->PG"
					+ "\n2->Seperate house"
					+ "\n3->Appartment"
					+ "\n4->Commercial"
					+ "\n5->Villa"
					+ "\n6->Office"
					);
			selector.add("pg");
			selector.add("sephouse");
			selector.add("appartment");
			selector.add("comercial");
			selector.add("villa");
			selector.add("office");
			house_type=selector(selector);
			System.out.println(house_type);
		}
		house_values.add(house_type);
		
		String used_for="";
		while(used_for.equals("")) {
			selector.clear();
			System.out.println("Select User For"
					+ "\n1->Rent"
					+ "\n2->Lease"
					+ "\n3->Sale"
					);
			selector.add("rent");
			selector.add("lease");
			selector.add("sell");
			used_for=selector(selector);
			System.out.println(used_for);
		}
		house_values.add(used_for);
		
		String prefered_for="";
		while(prefered_for.equals("")) {
			selector.clear();
			System.out.println("Select Prefered_for"
					+ "\n1->mens only"
					+ "\n2->womens only"
					+ "\n3->family"
					+ "\n4->All"
					+ "\n5->comercial"
					);
			selector.add("mens");
			selector.add("womens");
			selector.add("family");
			selector.add("All");
			selector.add("comercial");
			prefered_for=selector(selector);
			System.out.println(prefered_for);
		}
		house_values.add(prefered_for);
		
		String avail_from="";
		while(true) {
			System.out.println("Enter Date of available from"
					+ "\n(dd-MM-yyyy)");
			avail_from= scan.next();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			Date date=null;
			try {
			    date = dateFormat.parse(avail_from);
			    System.out.println(avail_from);
			    house_values.add(avail_from);
			    break;
			} 
			catch (ParseException e) {
			    System.out.println("Please enter date in given Format");
			}
		}
		System.out.println("Enter No of BHK\n(if no enter 0)");
		int bhk_count=scan.nextInt();
		house_values.add(bhk_count);
		System.out.println("Give some HighLights");
		Scanner sc=new Scanner(System.in);
		String highlights=sc.nextLine();
		System.out.println(highlights);
		house_values.add(highlights);
		System.out.println("Enter cost\n(if rent enter monthly pay only)");
		int cost=scan.nextInt();
		house_values.add(cost);
		System.out.println(house_values);
		System.out.println("house registered sucessFully");
		CRUD.insert(house_values,table);		
	}
	
	private  String selector(ArrayList values) {
		String select="";
		int decide=0;
		String num=scan.next();
		try {
		decide=Integer.parseInt(num);
		}
		catch(NumberFormatException e) {
			System.out.println("please enter numbers only");
			return selector(values);
		}
		
		if(decide<=values.size()&&decide>0) {
			for(int i=0;i<values.size();i++) {
				if(i==decide-1) {
					select= values.get(i).toString();
					return select;
				}
			}
		}
		System.out.println("Please select Given numbers");
		return "";	
	}
	
	
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		SellerOperations so=new SellerOperations();
		so.operate();
	}
}
