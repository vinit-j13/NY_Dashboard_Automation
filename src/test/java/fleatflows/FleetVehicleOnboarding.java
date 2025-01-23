package fleatflows;
import org.testng.annotations.Test;
import baseClass.BaseClass;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import utils.FleetHelper;
public class FleetVehicleOnboarding extends BaseClass
{
    @Test
    public void vehicleOnboardingTest() throws IOException {
        // Load properties from config file
        FileReader fr = new FileReader(System.getProperty("user.dir") + "/src/test/resources/config file/config.properties");
        Properties properties = new Properties();
        properties.load(fr);
        String rcNumber = properties.getProperty("rcNumber");
        String rcFilePath = properties.getProperty("rcFilePath");
        FleetHelper fleetHelper = new FleetHelper();
        fleetHelper.fleetLogin();     
        fleetHelper.onboardVehicle(rcNumber, rcFilePath);
    }
}
