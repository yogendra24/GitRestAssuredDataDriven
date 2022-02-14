package logs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class TestLog4J {
	
	private static final Logger logger =LogManager.getLogger(TestLog4J.class);
	
	@Test
	public void logInfoMessage() {
		logger.info("this is info message");
	}
	@Test
	public void logWarnMessage() {
		logger.warn("this is warn message");
	}
	@Test
	public void logErrorMessage() {
		logger.error("this is error message");
	}

}
