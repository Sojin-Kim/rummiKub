package com.workout.app.common.aop;

import java.util.List;
import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;



import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class EscapeXmlAspect {

	//@Pointcut("execution(* com.workout.app.todo.controller.TodoController.todoList(..))")
	//public void pc() {}
	
	/*
	 * @AfterReturning(pointcut = "pc()", returning = "returnObj") public void
	 * escapeXml(JoinPoint joihnPoint, Object returnObj) { ModelAndView mav =
	 * (ModelAndView) returnObj; log.debug("mav = {}", mav);
	 * 
	 * Map<String, Object> model = mav.getModel(); List<Todo> list = (List<Todo>)
	 * model.get("list"); for(Todo todo : list) { String maybeXss = todo.getTodo();
	 * String safeXss = escapeXmlProcess(maybeXss); todo.setTodo(safeXss); }
	 * 
	 * }
	 */

	private String escapeXmlProcess(String maybeXss) {
		return maybeXss.replaceAll("<", "&lt;")
						.replaceAll(">", "&gt;");
	}
	
}
