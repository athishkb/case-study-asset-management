package dao;
import myexceptions.*;
import model.*;

public interface AssetManagementService {
	boolean addAsset(assets asset);
    boolean updateAsset(assets asset) throws AssetNotFoundException ;
    boolean deleteAsset(int assetId)throws AssetNotFoundException;
    boolean allocateAsset(int allocation_id,int assetId, int employeeId, String allocationDate)throws AssetNotFoundException;
    boolean deallocateAsset(int allocation_id,String return_date);
    boolean performMaintenance(int maintenance_id,int assetId, String maintenanceDate, String description, double cost)throws AssetNotFoundException;
    boolean reserveAsset(reservations reserve)throws AssetNotFoundException,AssetNotMaintainException;
    boolean withdrawReservation(int reservationId);
}
