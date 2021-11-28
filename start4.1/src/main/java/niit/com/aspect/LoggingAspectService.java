package niit.com.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.util.Arrays;

@Component
@Aspect
public class LoggingAspectService {
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("execution (* niit.com.service.ProductServiceImpl.*(..))")
    public void serviceMethods() {

    }

    @Before("serviceMethods()")
    public void beforeAdvice(JoinPoint joinPoint) {
        logger.info("**********@Before**********");
        logger.debug("Method Name: {}", joinPoint.getSignature().getName());
        logger.debug("Method Args: {}", Arrays.toString(joinPoint.getArgs()));
        logger.info("**************************");
    }

    @After("serviceMethods()")
    public void afterAdvice(JoinPoint joinPoint) {
        logger.info("**********@After**********");
        logger.debug("Method Name: {}", joinPoint.getSignature().getName());
        logger.debug("Method Args: {}", Arrays.toString(joinPoint.getArgs()));
        logger.info("**************************");
    }

    @AfterReturning(value="serviceMethods()",returning = "result")
    public void afterAdvice(JoinPoint joinPoint, Object result) {
        logger.info("**********@AfterReturning**********");
        logger.debug("Method Name: {}", joinPoint.getSignature().getName());
        logger.debug("Method Args: {}", Arrays.toString(joinPoint.getArgs()));
        logger.debug("Return Value: {}", result);
        logger.info("**************************");
    }

    @AfterThrowing(value="serviceMethods()",throwing = "error")
    public void afterAdvice(JoinPoint joinPoint, Throwable error) {
        logger.info("**********@AfterThrowing**********");
        logger.debug("Method Name: {}", joinPoint.getSignature().getName());
        logger.debug("Method Args: {}", Arrays.toString(joinPoint.getArgs()));
        logger.debug("Exception: {}", error);
        logger.info("**************************");
    }



}


