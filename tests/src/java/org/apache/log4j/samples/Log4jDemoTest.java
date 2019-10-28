package org.apache.log4j.samples;

import junit.framework.TestCase;
import org.apache.log4j.Logger;

/**
 * @author : <a href="mailto:gnehcgnaw@gmail.com">gnehcgnaw</a>
 * @since : 2019/10/28 21:35
 */
public class Log4jDemoTest extends TestCase {

    Logger logger = Logger.getLogger("Log4jDemoTest");

    public void test(){
        logger.trace("Trace Message!");
        logger.debug("Debug Message!");
        logger.info("Info Message!");
        logger.warn("Warn Message!");
        logger.error("Error nihao 你好!");
        logger.fatal("Fatal Message!");
    }
}
