package fleatflows;
import java.io.IOException;
import org.testng.annotations.Test;
import baseClass.BaseClass;
import utils.FleetHelper;
public class FleetSignUp extends BaseClass {
    @Test
    public void FleetLoginFlow() throws IOException {     
    	try {
    		FleetHelper fleetHelper = new FleetHelper();
    		System.out.println("Started....launching Fleet in browser");	
    		System.out.println("Running tests......");
    		fleetHelper.fleetSignUp();
    		System.out.println("Starting Fleet Sighnup...");
        } catch (Exception e) {
            System.out.println("An error occurred during Sighnp: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
