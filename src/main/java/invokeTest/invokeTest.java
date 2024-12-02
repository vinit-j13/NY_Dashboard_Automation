package invokeTest;
import bapFlows.BapLogin;
import bapFlows.RideSearch;
import baseClass.BaseClass;
import bppFlows.BppLogin;

public class InvokeTest extends BaseClass {
	public void invokeFlowTests() throws InterruptedException
	{
		//BAP Flows
		BapLogin bapLogin = new BapLogin();
		bapLogin.bapLoginFlow();
		
		RideSearch search = new RideSearch();
		search.rideSearchFlow();
		
		BppLogin bppLogin = new BppLogin();
		bppLogin.bppLogin();
	}

}
