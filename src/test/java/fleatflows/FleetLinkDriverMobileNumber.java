package fleatflows;
import java.io.IOException;
import org.testng.annotations.Test;
import baseClass.BaseClass;
import utils.FleetHelper;
public class FleetLinkDriverMobileNumber extends BaseClass {

    @Test
    public void automateEditVehicleDetails() throws IOException {
        try {
        	FleetHelper fleetHelper = new FleetHelper();       	
          	 fleetHelper.fleetLogin();         	
          	 fleetHelper.LinkDriverMobilenumber();
        } catch (Exception e) {
            System.out.println("An error occurred during the Edit Vehicle Details flow: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
