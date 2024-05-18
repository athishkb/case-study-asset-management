package dao;
import myexceptions.*;
import model.*;
import util.*;
import java.sql.*;
import java.sql.Date;
import java.util.*;

public class AssetManagementServiceImpl implements AssetManagementService {
    private  Connection connection;
    PreparedStatement s;
    
    public AssetManagementServiceImpl(){
    	connection= DBPropertyUtil.getconnect(); 
    }
    
	
	public boolean addAsset(assets asset) {
		try {
			s=connection.prepareStatement("insert into assets values(?,?,?,?,?,?,?,?)");
            Date purchase_date = Date.valueOf(asset.getpurchase_date());

			s.setInt(1, asset.getasset_id());
			s.setString(2, asset.getname());
			s.setString(3, asset.gettype());
			s.setInt(4, asset.getserial_number());
			s.setDate(5, purchase_date);
			s.setString(6, asset.getlocation());
			s.setString(7, asset.getstatus());
			s.setInt(8,asset.getowner_id());
			int a=s.executeUpdate();
			if(a>0) {
				System.out.println("asset added into the database");
				return true;
			}
			else {
				System.out.print("failed to add asset");
				return false;
			}
			
			
			
		}
		catch(Exception e) {
			System.out.print(e);
			return false;
		}
	}
	
	
	
	public boolean updateAsset(assets asset) throws AssetNotFoundException {
	    try {
	     
	         s = connection.prepareStatement("select * from assets where asset_id = ?");
	        s.setInt(1, asset.getasset_id());
	        ResultSet r = s.executeQuery();
	        if (!r.next()) {
	            throw new AssetNotFoundException("no asset_id: " + asset.getasset_id() + " found.");
	        }
	        s = connection.prepareStatement("update assets set location = ?, status = ? where asset_id = ?");
	        s.setString(1, asset.getlocation());
	        s.setString(2, asset.getstatus());
	        s.setInt(3, asset.getasset_id());
	        int rowsAffected = s.executeUpdate();

	        if (rowsAffected > 0) {
	            System.out.println("asset updated successfully.");
	            return true;
	        } else {
	            System.out.println("failed to update asset.");
	            return false;
	        }
	    } 
	    catch (AssetNotFoundException e) {
	        System.out.println(e.getMessage());
	        return false;
	    } 
	    catch (Exception e) {
	        System.out.println(e.getMessage());
	        return false;
	    }
	}
	
	
	
	public boolean deleteAsset(int assetId) throws AssetNotFoundException {
		try {
			s = connection.prepareStatement("select * from assets where asset_id = ?");
	        s.setInt(1, assetId);
	        ResultSet r = s.executeQuery();
	        if (!r.next()) {
	            throw new AssetNotFoundException("no asset_id: " + assetId + " found.");
	        }   		
			s=connection.prepareStatement("delete from assets where asset_id=?");
			s.setInt(1, assetId);
			int a=s.executeUpdate();
			if(a>0) {
				System.out.print("asset deleted");
				return true;
			}
			else {
				System.out.print("failed to delete asset");
				return false;
			}
			
		}
		catch (AssetNotFoundException e) {
	        System.out.println(e.getMessage());
	        return false;
	    } 
		catch (Exception e) {
			System.out.print(e);
			return false;
		}
    	
    }
	
	
	
	public boolean allocateAsset(int allocation_id,int assetId, int employeeId, String allocationDate)throws AssetNotFoundException {
		try {
			s = connection.prepareStatement("select * from assets where asset_id = ?");
	        s.setInt(1, assetId);
	        ResultSet r = s.executeQuery();
	        if (!r.next()) {
	            throw new AssetNotFoundException("no asset_id: " + assetId + " found.");
	        } 
			s=connection.prepareStatement("insert into asset_allocations(allocation_id,asset_id,employee_id,allocation_date) values(?,?,?,?)");
			Date allocation_Date  = Date.valueOf(allocationDate);
			s.setInt(1,allocation_id);
			s.setInt(2,assetId);
			s.setInt(3, employeeId);
			s.setDate(4, allocation_Date);
			int a=s.executeUpdate();
			if(a>0) {
				System.out.print("asset allocated");
				return true;
			}
			else {
				System.out.print("failed to allocate asset");
				return false;
			}
		}
		catch (AssetNotFoundException e) {
	        System.out.println(e.getMessage());
	        return false;
	    } 
		catch (Exception e) {
			System.out.print(e);
			return false;
		}
    	
    }
	
	
	
	public boolean deallocateAsset(int allocation_id, String return_date) {
		try{
			s=connection.prepareStatement("update asset_allocations set return_date=? where allocation_id=?");
			Date returndate= Date.valueOf(return_date);
			s.setDate(1,returndate);
			s.setInt(2, allocation_id);
			int a=s.executeUpdate();
			if(a>0) {
				System.out.print("asset deallocated");
				return true;
			}
			else {
				System.out.print("failed to deallocate asset");
				return false;
			}
		}
		catch (Exception e) {
			System.out.print(e);
			return false;
		}	

    }
	
	
	
	public boolean performMaintenance(int maintenance_id,int assetId, String maintenanceDate, String description, double cost)throws AssetNotFoundException {
    		try {
    			s = connection.prepareStatement("select * from assets where asset_id = ?");
    	        s.setInt(1, assetId);
    	        ResultSet r = s.executeQuery();
    	        if (!r.next()) {
    	            throw new AssetNotFoundException("no asset_id: " + assetId + " found.");
    	        } 
    		s=connection.prepareStatement("insert into maintenance_records(maintenance_id,asset_id,maintenance_date,description,cost) values(?,?,?,?,?)");
			Date maintenance_Date= Date.valueOf(maintenanceDate);
			s.setInt(1, maintenance_id);
			s.setInt(2, assetId);
			s.setDate(3, maintenance_Date);
			s.setString(4, description);
			s.setDouble(5, cost);
			int a=s.executeUpdate();
			if(a>0) {
				System.out.print("asset deallocated");
				return true;
			}
			else {
				System.out.print("failed to deallocate asset");
				return false;
			}
    	}
    		catch (AssetNotFoundException e) {
    	        System.out.println(e.getMessage());
    	        return false;
    	        }
    	catch (Exception e) {
			System.out.print(e);
			return false;
		}
    	
    }
	
	
	
	public boolean reserveAsset(reservations reserve)throws AssetNotFoundException,AssetNotMaintainException{
		try {
			s = connection.prepareStatement("select * from assets where asset_id = ?");
	        s.setInt(1, reserve.getAsset_id());
	        ResultSet r = s.executeQuery();
	        if (!r.next()) {
	            throw new AssetNotFoundException("no asset_id: " + reserve.getAsset_id() + " found.");
	        } 
	        s = connection.prepareStatement("select max(maintenance_date) from maintenance_records where asset_id = ?");
	        s.setInt(1, reserve.getAsset_id());
	        ResultSet r2 = s.executeQuery();
	        r2.next();
	        String last_date = r2.getDate(1).toString();
	        int y1 = Integer.parseInt(last_date.substring(0, 4));
	        int y2 = Integer.parseInt(reserve.getReservation_date().substring(0, 4));
	        if (y2 - y1 >= 2) {
	                throw new AssetNotMaintainException("Your asset has not been maintained for 2 years.");
	            }
    	
    		s=connection.prepareStatement("insert into reservations(reservation_id,asset_id, employee_id, reservation_date, start_date, end_date, status) VALUES (?,?,?,?,?,?,?)");
			Date reservation= Date.valueOf(reserve.getReservation_date());
			Date start= Date.valueOf(reserve.getStart_date());
			Date end= Date.valueOf(reserve.getEnd_date());
			s.setInt(1, reserve.getReservation_id());
    		s.setInt(2, reserve.getAsset_id());
    		s.setInt(3,reserve.getEmployee_id());
    		s.setDate(4,reservation);
    		s.setDate(5, start);
    		s.setDate(6, end);
    		s.setString(7, reserve.getStatus());
    		int a=s.executeUpdate();
    		if(a>0) {
				System.out.print("asset reserved");
				return true;
			}
			else {
				System.out.print("failed to reserve asset");
				return false;
			}
    	}
    	catch (AssetNotFoundException e) {
	        System.out.println(e.getMessage());
	        return false;
	        }
    	catch (AssetNotMaintainException e) {
	        System.out.println(e.getMessage());
	        return false;
	        }
    	catch (Exception e) {
			System.out.print(e);
			return false;
		}
    }
	
	
	
	public boolean withdrawReservation(int reservationId) {
    	try {
    		s=connection.prepareStatement("delete from reservations where reservation_id=?");
    		s.setInt(1, reservationId);	
    		int a=s.executeUpdate();
    		return a>0;
    	}
    	catch (Exception e) {
			System.out.print(e);
			return false;
		}
    }
}
