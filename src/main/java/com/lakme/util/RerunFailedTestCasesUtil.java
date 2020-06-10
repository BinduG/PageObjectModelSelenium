package com.lakme.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import com.lakme.basesetup.BaseSetup;


public class RerunFailedTestCasesUtil extends BaseSetup implements IRetryAnalyzer,IAnnotationTransformer {

	private int retrycount = 0;
	
	private int maxretryCount=3;
	
	public boolean retry(ITestResult testResult) {
		
		if (!testResult.isSuccess()) {   //Check if test not succeed
            
            if (retrycount < maxretryCount) {                            //Check if maxtry count is reached
            	
            	retrycount++;                                     //Increase the maxTry count by 1
            	
            	testResult.setStatus(ITestResult.FAILURE);  //Mark test as failed
                
            	log.info("Since the test case " +testResult.getName() + " is failed, re-executing it !!" );
            	
            	return true;                                 //Tells TestNG to re-run the test
            
            } else {
            	
            	testResult.setStatus(ITestResult.FAILURE);  //If maxCount reached,test marked as failed
            
            }
            
        } else {
        	
        	testResult.setStatus(ITestResult.SUCCESS);      //If test passes, TestNG marks it as passed
        }
		
		return false;
	}

	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		
		annotation.setRetryAnalyzer(RerunFailedTestCasesUtil.class);
		
	}

}
