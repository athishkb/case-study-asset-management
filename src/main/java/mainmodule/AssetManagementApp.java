package mainmodule;
import dao.*;
import util.*;
import model.*;
import myexceptions.*;
import java.util.*;
import java.sql.*;
public class AssetManagementApp {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		AssetManagementServiceImpl am= new AssetManagementServiceImpl();
		boolean flag=true;
		while(flag==true){
		 System.out.println("1. Add Asset");
         System.out.println("2. Update Asset");
         System.out.println("3. Delete Asset");
         System.out.println("4. Allocate Asset");
         System.out.println("5. Deallocate Asset");
         System.out.println("6. Perform Maintenance");
         System.out.println("7. Reserve Asset");
         System.out.println("8. Withdraw Reservation");
         System.out.println("9. Exit");
         System.out.print("Enter your choice: ");
         int choice=sc.nextInt();
         switch(choice) {
         case 1:
        	 assets a=new assets();
        	 System.out.print("Enter Asset_ID: ");
        	 a.setasset_id(sc.nextInt());
        	 sc.nextLine();
        	 System.out.print("Enter Asset Name: ");
             a.setname(sc.nextLine());

             System.out.print("Enter Asset Type: ");
             a.settype(sc.nextLine());

             System.out.print("Enter Asset Serial Number: ");
             a.setserial_number(sc.nextInt());
             sc.nextLine();
             System.out.print("Enter Purchase Date (YYYY-MM-DD): ");
             a.setpurchase_date(sc.nextLine());

             System.out.print("Enter Location: ");
             a.setlocation(sc.nextLine()); 

             System.out.print("Enter Status: ");
             a.setstatus(sc.nextLine());

             System.out.print("Enter Owner ID: ");
             a.setowner_id(sc.nextInt());
             am.addAsset(a);
        	 break;
        	 
        	 
         case 2:
        	 assets a1=new assets();
        	 System.out.print("Enter AssetID : ");
        	 a1.setasset_id(sc.nextInt());
        	 sc.nextLine();
        	 System.out.print("Enter Location : ");
        	 a1.setlocation(sc.nextLine());
        	 System.out.print("Enter Status : ");
        	 a1.setstatus(sc.nextLine());
        	 try {
				am.updateAsset(a1);
			} catch (Exception e2) {
                System.out.println(e2.getMessage());
			}
        	 break;
        	 
        	 
         case 3:
        	 
        	 System.out.print("Enter AssetID: ");
             int assetId = sc.nextInt();
             try {
				am.deleteAsset(assetId);
			} catch (AssetNotFoundException e1) {
                System.out.println(e1.getMessage());
			}
        	 break;
        	 
        	 
         case 4:
        	 System.out.print("Enter AssetallocationID: ");
        	 int allocationId = sc.nextInt();
        	 
        	 System.out.print("Enter Asset ID: ");
             int assetId1 = sc.nextInt();
             sc.nextLine();

             System.out.print("Enter Employee ID: ");
             int employeeId = sc.nextInt();
             sc.nextLine(); 

             System.out.print("Enter Allocation Date (YYYY-MM-DD): ");
             String allocationDate = sc.nextLine();
             try {
				am.allocateAsset(allocationId,assetId1, employeeId, allocationDate);
			} catch (AssetNotFoundException e1) {
                System.out.println(e1.getMessage());
			}
              break;
              
              
         case 5:
        	 System.out.print("Enter AllocationID: ");
        	 int allocationID=sc.nextInt();
        	 sc.nextLine();
        	 System.out.print("Enter ReturnDate YYYY-MM-DD: ");
        	 String returnDate=sc.nextLine();
        	 am.deallocateAsset(allocationID, returnDate);
        	 break;
        	 
        	 
         case 6:
        	 
        	 System.out.println("Enter MaintenanceID:");
        	 int Maintenanceid=sc.nextInt();
        	 System.out.print("Enter Asset ID: ");
             int assetid = sc.nextInt();
             sc.nextLine(); 
             
             System.out.print("Enter MaintenanceDate YYYY-MM-DD: ");
             String maintenanceDate = sc.nextLine();
             
             System.out.print("Enter Description: ");
             String Description = sc.nextLine();
             
             System.out.print("Enter Cost: ");
             double maintenanceCost = sc.nextDouble();
             try {
				am.performMaintenance(Maintenanceid,assetid, maintenanceDate, Description, maintenanceCost);
			} catch (AssetNotFoundException e1) {
				 System.out.println(e1.getMessage());
			}
             break;
        	 
        	 
         case 7:
        	 reservations r=new reservations();
        	 System.out.print("Enter reservtionID: ");
        	 r.setReservation_id(sc.nextInt());
        	 System.out.print("Enter Asset ID: ");
             r.setAsset_id(sc.nextInt());
             sc.nextLine(); 
             System.out.print("Enter Employee ID: ");
             r.setEmployee_id(sc.nextInt());
             sc.nextLine(); 
             System.out.print("Enter Reservation Date YYYY-MM-DD: ");
             r.setReservation_date(sc.nextLine());
             System.out.print("Enter Start Date YYYY-MM-DD: ");
             r.setStart_date(sc.nextLine());
             System.out.print("Enter End Date YYYY-MM-DD: ");
             r.setEnd_date(sc.nextLine());
             System.out.print("Enter End Status: ");
             r.setStatus(sc.nextLine());
             try {
				am.reserveAsset(r);
			} catch (AssetNotFoundException e) {
                System.out.println(e.getMessage());
			} catch (AssetNotMaintainException e) {
				 System.out.println(e.getMessage());
			}
            
         
        	 break;
        	 
        	 
         case 8:
        	 int reservationId = sc.nextInt();
        	 am.withdrawReservation(reservationId);
        	 break;
        	 
        	 
         case 9:
        	 flag=false;
         	break;
         	
         	
         default :
         System.out.println("Invalid choice");
              
         }
		}
	}

}
