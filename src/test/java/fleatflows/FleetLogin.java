package fleatflows;
import java.io.IOException;
import org.testng.annotations.Test;
import baseClass.BaseClass;
import utils.FleetHelper;
public class FleetLogin extends BaseClass {
    @Test
    public void FleetLoginFlow() throws IOException {     
    	try {
    		FleetHelper fleetHelper = new FleetHelper();
    		fleetHelper.fleetLogin();
    		System.out.println("Started....launching Fleet in browser");	
    		System.out.println("Running tests......");
    		
    		System.out.println("Starting Fleet login...");
        } catch (Exception e) {
            System.out.println("An error occurred during login: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
