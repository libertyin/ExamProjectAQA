package listener;

import logger.CustomLogger;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        CustomLogger.logger.info("Test case: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        CustomLogger.logger.info("Test passed" + "\n");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        CustomLogger.logger.info("Test failed!");
        CustomLogger.logger.info(result.getThrowable().getMessage() + "\n");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        CustomLogger.logger.info("Test was skipped!");
        CustomLogger.logger.info(result.getThrowable().getMessage() + "\n");
    }

}
