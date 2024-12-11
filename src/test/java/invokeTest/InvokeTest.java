package invokeTest;
import org.testng.annotations.Test;
import bapFlows.BapLogin;
import bapFlows.RideSearch;
import baseClass.BaseClass;
import bppFlows.BppLogin;
import bppFlows.EndRide;

public class InvokeTest extends BaseClass {
	
	@Test
	public void invokeFlowTests() throws InterruptedException
	{
		//BAP Flows
		BapLogin bapLogin = new BapLogin();
		bapLogin.bapLoginFlow();
		
		RideSearch search = new RideSearch();
		search.rideSearchFlow();
		
		//BPP Flows
		BppLogin bppLogin = new BppLogin();
		bppLogin.bppLoginFlow();
		
		EndRide endRide = new EndRide();
		endRide.endRideFlow();
	}

}
