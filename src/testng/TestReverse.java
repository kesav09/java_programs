package testng;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestReverse {

	@DataProvider(name="input")
	public Object[][] getDataProvider() {
		Object[][] string = { { "abc", "cba" }, { "efg", "gfe" } };
		return string;
	}

	@Test(dataProvider = "input", groups = {"functional"})
	public void testInput(String testString,String expectedString) {
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(Reverse.reverse(testString),expectedString);
		
		softAssert.assertAll();
	}

	@Test(dataProvider = "input", groups = {"testMe2"})
	public void testSoftAssertInput(String testString,String expectedString) {
		Assert.assertEquals(Reverse.reverse(testString),expectedString);
	}
	
	@Test(expectedExceptions = {NullPointerException.class},groups = "functional")
	public void testNPE(){
		Reverse.reverse(null);
	}
	
	@Test(description= "this test should fail the test.",groups = "test")
	public void testFail(){
		Assert.fail("Intentional failure.");
	}
	
	@Test(dependsOnMethods={"testFail"}, groups = "sanity")
	public void dependsOnFailedTest(){
		System.out.println("Inside dependsOnFailedTest: This test should have been skipped, so this satement shouldn't be printed. ");
	}
	
	@Test(dependsOnMethods={"testNPE"}, groups = "sanity")
	public void dependsOnPassedTest(){
		System.out.println("Inside dependsOnPassedTest: This test should pass. ");
	}
	
	@Test(dependsOnGroups={"sanity"},groups = "regression")
	public void dependsOnFailedTestGroup(){
		System.out.println("Inside dependsOnFailedTestGroup: This test should have been skipped, so this satement shouldn't be printed.  ");
	}
	
	@Test(dependsOnGroups={"functional"}, groups = "regression")
	public void dependsOnPassedTestGroup(){
		System.out.println("Inside dependsOnPassedTestGroup: This test should pass. ");
	}
	
	@Test(dependsOnGroups={"sanity"},groups = "regression",alwaysRun=true)
	public void dependsOnFailedTestGroupButAlwaysRun(){
		System.out.println("Inside dependsOnFailedTestGroupButAlwaysRun: This test should be executed since alwaysRun=true.  ");
	}
	
	@Test(dependsOnMethods={"testFail"}, groups = "sanity",alwaysRun=true)
	public void dependsOnFailedTestButAlwaysRun(){
		System.out.println("Inside dependsOnFailedTestButAlwaysRun: This test should be executed since alwaysRun=true.  ");
	}
	
	@Test(enabled=false,dependsOnMethods={"testFail"}, groups = "sanity",alwaysRun=true)
	public void disabledTest(){
		System.out.println("This test has been disbaled. This statement shouldn't be printed.");
	}
	
	
	@Test(groups={"functional"})
	@Parameters({"param1"})
	public void testParameterizedMethod(String param){
		System.out.println("param1 value: " + param);
	}
}
