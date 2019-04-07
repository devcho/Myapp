
package com.Myapp.test.infra.commons.spring.aop;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.support.BindingAwareModelMap;


@Aspect
public class ExecutionLoggingAspect implements InitializingBean{

	private Logger logger;
	private String loggerName;
	
	public void setLoggerName(String loggerName) {
		this.loggerName = loggerName;
	}
	
	public void afterPropertiesSet() throws Exception {
		
		if(loggerName == null){
			logger = LoggerFactory.getLogger(getClass());
		}else{
			logger = LoggerFactory.getLogger(loggerName);
		}
	}
	
	
	@Around("execution(* com.Myapp..*Controller.*(..))")
	public Object doControllerProfiling(ProceedingJoinPoint joinPoint) throws Throwable {

		logger.info("+->[CONTROLLER] {}", buildSimpleExecutionInfo(joinPoint));
		return joinPoint.proceed();

	}
	
	
	@Around("execution(* com.Myapp..*Service.*(..))")
	public Object doServiceProfiling(ProceedingJoinPoint joinPoint) throws Throwable {
		
		logger.info("+--->[SERVICE ] {}", buildSimpleExecutionInfo(joinPoint));
		return joinPoint.proceed();
		
	}
	
	
	@Around("execution(* com.Myapp..*Dao.*(..))")
	public Object doDaoProfiling(ProceedingJoinPoint joinPoint) throws Throwable {
		
		logger.info("+----->[DAO   ] {}", buildSimpleExecutionInfo(joinPoint));
		return joinPoint.proceed();
	}
	

	private String buildSimpleExecutionInfo(ProceedingJoinPoint joinPoint) {
		
		StringBuffer buffer = new StringBuffer();

		String className = joinPoint.getTarget().getClass().getSimpleName();
		String methodName = joinPoint.getSignature().getName();

		StringBuffer paramListInfo = new StringBuffer();
		
		for (int i = 0; i < joinPoint.getArgs().length; i++) {
			Object param = joinPoint.getArgs()[i];
			
			if (param instanceof BeanPropertyBindingResult) {
				continue;
			}
			
			if (param instanceof String) {
				paramListInfo.append("String" + "[" + param + "]");
			} else {
				String result = ToStringBuilder.reflectionToString(param, ToStringStyle.SHORT_PREFIX_STYLE);
				paramListInfo.append(result);
			}
			
			if (i < joinPoint.getArgs().length - 1) {
				paramListInfo.append(", ");
			}
		}
		
		buffer.append(className + "." + methodName + "(" + paramListInfo + ")");

		return buffer.toString();
	}

	@Deprecated
	private String buildExecutionInfo(ProceedingJoinPoint joinPoint) {

		StringBuffer buffer = new StringBuffer();

		String className = joinPoint.getSignature().getDeclaringTypeName();
		String methodName = joinPoint.getSignature().getName();

		String paramListInfo = "";
		for (int i = 0; i < joinPoint.getArgs().length; i++) {
			Object param = joinPoint.getArgs()[i];

			paramListInfo += param.getClass().getSimpleName();
			if (i < joinPoint.getArgs().length - 1) {
				paramListInfo += ", ";
			}
		}

		buffer.append("\n");
		buffer.append("*========================== EXECUTION_INFO ============================\n");
		buffer.append("* CallInfo : " + className + "." + methodName + "(" + paramListInfo + ")\n");

		// MAKE-------------------------- PARAM_LIST
		// --------------------------------

		Object[] objectArr = joinPoint.getArgs();
		for (int i = 0; i < objectArr.length; i++) {
			Object param = objectArr[i];
			buffer.append("* Param" + (i + 1) + "   : ");

			if (param instanceof String) {
				buffer.append("String" + "[" + param + "]\n");
			} else {
				String result = ToStringBuilder.reflectionToString(param, ToStringStyle.SHORT_PREFIX_STYLE);
				buffer.append(result + "\n");
			}
		}

		buffer.append("*======================================================================\n");
		return buffer.toString();
	}

}
