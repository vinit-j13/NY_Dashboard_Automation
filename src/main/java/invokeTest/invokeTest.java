package invokeTest;

import bapFlows.bapLogin;
import bapFlows.rideSearch;
import baseClass.BaseClass;

public class invokeTest extends BaseClass {
	public void invokeFlowTests() throws InterruptedException
	{
		//BAP Flows
		bapLogin login = new bapLogin();
		login.bapLoginFlow();
		
		rideSearch search = new rideSearch();
		search.rideSearchFlow();
	}

}
