package core_module;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

import database.BuyerOperationsDB;
import database.CRUD;
import database.RegisterDB;

public class BuyerOperations implements Operations {

	static String table;
	static int id;
	static Scanner scan=new Scanner(System.in);
	static BuyerOperationsDB bodb=new BuyerOperationsDB();
	@Override
	public void operate() throws ClassNotFoundException, SQLException {
		table="buyers";
		id=Login.id;
		//id=1;
		String num="";int n=0;
		while(true) {
			System.out.println("1->View/Edit Profile"
					   + "\n2->Show And Buy Properties"
					   + "\n3->Show Mails"
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
				showProperties();
			}
			else if(n==3){
				
			}
			else if(n==0){
				break;
			}
			else {
				System.out.println("please select given numbers only");
			}
		}
	}


	private  void editProfile() throws ClassNotFoundException, SQLException {
		table="buyers";
		//id=Login.id;
		//id=1;
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
					System.out.println(i+1+")"+CRUD.getColumnNameByIndex("buyers",i+2)
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
						if(n1==1) {
							while(RegisterDB.checkRegister(new_value, table)) {
								System.out.println("This email already exists");
								System.out.println("Enter new value");
								new_value=scan.next();
							}
						}
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
	
	private void showProperties() throws ClassNotFoundException, SQLException {
		String num="";int n=0;
		while(true) {
			System.out.println("\n1->land"
				          	 + "\n2->house"
				             + "\n0->back");
			num=scan.next();
			try {
				n=Integer.parseInt(num);
			}
		    catch(NumberFormatException e) {
		    	System.out.println("please enter numbers only");
				showProperties();
		    }
			if(n==1) {
				landFilter();
			}
			else if(n==2) {
				houseFilter();
			}
			else {
				break;
			}
		}
	}
	private void landFilter() throws ClassNotFoundException, SQLException {
		HashMap<String, ArrayList<String>> filters = new HashMap<String, ArrayList<String>>();
		ArrayList location=new ArrayList();
		location.add("ch");
		location.add("then");
		location.add("coi");
		filters.put("location",location);
		ArrayList type=new ArrayList();
		type.add("farm");
		type.add("house");
		type.add("com");
		filters.put("type",type);
		ArrayList decide=new ArrayList();
		decide.add("yes");
		decide.add("no");
		filters.put("decide",decide);
		//System.out.println(filters);
		String display_location="Select Location"
					+ "\n1->Chennai"
					+ "\n2->ThenKasi"
					+ "\n3->Coimbatore";
		String location_regexp=regexpResult(filters,"location",display_location);
		String display_type="Select Preference"
				+ "\n1->Farming"
				+ "\n2->House Site"
				+ "\n3->Comercial";
		String type_regexp=regexpResult(filters,"type",display_type);
		int area_start=0,area_end=0;
		System.out.println("Select Area range");
		while(true) {
			System.out.println("Enter starting range");
			String num1=scan.next();
			try {
				area_start=Integer.parseInt(num1);
				break;
			}
			catch(NumberFormatException e) {
				System.out.println("please enter numbers only");
			}
		}
		while(true) {
			System.out.println("Enter ending range");
			String num2=scan.next();
			try {
				area_end=Integer.parseInt(num2);
				break;
			}
			catch(NumberFormatException e) {
				System.out.println("please enter numbers only");
			}
		}
		int cost_start=0,cost_end=0;
		System.out.println("Select cost range");
		while(true) {
			System.out.println("Enter starting range");
			String num1=scan.next();
			try {
				cost_start=Integer.parseInt(num1);
				break;
			}
			catch(NumberFormatException e) {
				System.out.println("please enter numbers only");
			}
		}
		while(true) {
			System.out.println("Enter ending range");
			String num2=scan.next();
			try {
				cost_end=Integer.parseInt(num2);
				break;
			}
			catch(NumberFormatException e) {
				System.out.println("please enter numbers only");
			}
		}
			
		bodb.readLand(location_regexp, cost_start, cost_end, area_start, area_end, type_regexp);	
	}
	
	 private void houseFilter() throws ClassNotFoundException, SQLException {
		HashMap<String, ArrayList<String>> filters = new HashMap<String, ArrayList<String>>();
		ArrayList location=new ArrayList();
		location.add("ch");
		location.add("then");
		location.add("coi");
		filters.put("location",location);
		ArrayList type=new ArrayList();
		type.add("pg");
		type.add("sephouse");
		type.add("appartment");
		type.add("comercial");
		type.add("villa");
		type.add("office");
		filters.put("type",type);
		ArrayList used_for=new ArrayList();
		used_for.add("rent");
		used_for.add("lease");
		used_for.add("sell");
		filters.put("used_for",used_for);
		ArrayList prefered_for=new ArrayList();
		prefered_for.add("mens");
		prefered_for.add("womens");
		prefered_for.add("family");
		prefered_for.add("All");
		prefered_for.add("comercial");
		filters.put("prefered_for",prefered_for);
		ArrayList decide=new ArrayList();
		decide.add("yes");
		decide.add("no");
		filters.put("decide",decide);
		//System.out.println(filters);
		String display_location="Select Location"
					+ "\n1->Chennai"
					+ "\n2->ThenKasi"
					+ "\n3->Coimbatore";
		String location_regexp=regexpResult(filters,"location",display_location);
		String display_type="Select House_type"
				+ "\n1->PG"
				+ "\n2->Seperate house"
				+ "\n3->Appartment"
				+ "\n4->Commercial"
				+ "\n5->Villa"
				+ "\n6->Office";
		String type_regexp=regexpResult(filters,"type",display_type);
		String display_used_for="Select User For"
				+ "\n1->Rent"
				+ "\n2->Lease"
				+ "\n3->Sale";
		String used_for_regexp=regexpResult(filters,"used_for",display_used_for);
		String display_prefered_for="Select Prefered_for"
				+ "\n1->mens only"
				+ "\n2->womens only"
				+ "\n3->family"
				+ "\n4->All"
				+ "\n5->comercial";
		String prefered_for_regexp=regexpResult(filters,"prefered_for",display_prefered_for);
		int bhk_count=0;
		System.out.println("Enter bhk count");
		while(true) {
			System.out.println("Enter starting range");
			String num=scan.next();
			try {
				bhk_count=Integer.parseInt(num);
				break;
			}
			catch(NumberFormatException e) {
				System.out.println("please enter numbers only");
			}
		}
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");  
		LocalDateTime now = LocalDateTime.now();  
		String current_date=dtf.format(now);  
		int area_start=0,area_end=0;
		System.out.println("Select Area range");
		while(true) {
			System.out.println("Enter starting range");
			String num1=scan.next();
			try {
				area_start=Integer.parseInt(num1);
				break;
			}
			catch(NumberFormatException e) {
				System.out.println("please enter numbers only");
			}
		}
		while(true) {
			System.out.println("Enter ending range");
			String num2=scan.next();
			try {
				area_end=Integer.parseInt(num2);
				break;
			}
			catch(NumberFormatException e) {
				System.out.println("please enter numbers only");
			}
		}
		int cost_start=0,cost_end=0;
		System.out.println("Select cost range");
		while(true) {
			System.out.println("Enter starting range");
			String num1=scan.next();
			try {
				cost_start=Integer.parseInt(num1);
				break;
			}
			catch(NumberFormatException e) {
				System.out.println("please enter numbers only");
			}
		}
		while(true) {
			System.out.println("Enter ending range");
			String num2=scan.next();
			try {
				cost_end=Integer.parseInt(num2);
				break;
			}
			catch(NumberFormatException e) {
				System.out.println("please enter numbers only");
			}
		}
		
			
		bodb.readHouse(location_regexp, area_start, area_end, type_regexp, used_for_regexp, prefered_for_regexp, bhk_count, cost_start, cost_end, current_date);
	}	
	
	
	private String regexpResult(HashMap<String, ArrayList<String>> filters,String param,String print) {
		HashSet temp=new HashSet<>();
		String regexp="";
		while(true) {
			String val="";
			while(val.equals("")) {
				System.out.println(print);
				val=selector(filters.get(param));
				if(!val.equals("")) {
					temp.add(val);
				}
				//System.out.println(temp);
			}String decide="";	
			while(decide.equals("")) {
				System.out.println("want to add another"
						+ "\n1->yes"
						+ "\n2->No");
				decide=selector(filters.get("decide"));
			}
			if(decide.equals("no")||temp.size()==filters.get(param).size()) {
				break;
			}
		}
		if(temp.size()==1) {
			regexp+=temp.toArray()[0];
			return regexp;
		}
		else {
			for(int i=0;i<temp.size();i++) {
				if(i==temp.size()-1) {
					regexp+=temp.toArray()[i];
				}
				else {
				regexp+=temp.toArray()[i]+"|";
				}
			}
		}
		
		return regexp;
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
		}System.out.println("Please select Given numbers");
		return "";
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	}
}
