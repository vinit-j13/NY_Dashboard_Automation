package invokeTest;

import bapFlows.bapLogin;
import baseClass.BaseClass;

public class invokeTest extends BaseClass {
	public void invokeFlowTests()
	{
		bapLogin login = new bapLogin();
		login.bapLoginFlow();
	}

}
