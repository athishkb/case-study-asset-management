package finalproject;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;
import dao.AssetManagementServiceImpl;
import model.assets;
import myexceptions.AssetNotFoundException;

class testing {
	
	@Test
	void test() {
		
			AssetManagementServiceImpl a=new AssetManagementServiceImpl();
			assets asset=new assets(7,"telephone","electronic","help desk","out","2024-05-17",777,1);
			boolean test1=a.addAsset(asset);
			
			assertEquals(true,test1);
		}
	@Test
	void exceptiontest() throws AssetNotFoundException {
		AssetManagementServiceImpl a=new AssetManagementServiceImpl();
       boolean test=a.deleteAsset(7);
       assertEquals(false,test);
	}



	
	}

