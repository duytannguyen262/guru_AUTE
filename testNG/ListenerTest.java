package testNG;

import org.testng.*;

public class ListenerTest implements ITestListener{
	
	@Override
	public void onFinish(ITestContext arg0) {
		System.out.println("onFinish");
	}
	
	@Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Đây là test case bị bỏ qua: " + result.getName());

    }
	
	@Override
	public void onTestStart(ITestResult arg0) {
		System.out.println("onTestStart");
	}
	
	@Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Đây là test case chạy thành công: " + result.getName());

    }
	
	@Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Đây là test case bị fail: " + result.getName());

    }
}
