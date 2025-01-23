package fleatflows;
import java.io.IOException;
import org.testng.annotations.Test;
import baseClass.BaseClass;
import utils.FleetHelper;
public class FleetLinkDriverRcStatus extends BaseClass {
    @Test
    public void LinkDriver_rc() throws IOException {
       try {
    	   FleetHelper fleetHelper = new FleetHelper();
    	fleetHelper.fleetLogin();
    	fleetHelper.LinkDriverRcStatus();
       }
            catch (Exception e) {
                System.out.println("An error occurred during the Edit Vehicle Details flow: " + e.getMessage());
                e.printStackTrace();
            }
    }
}

            
            
            