package com.yaoyong.demo.base.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 *
 * @ClassName:  MyControllerAdvice
 * @Description:
 * @author: yaoyong
 * @date:   2018年12月5日 下午8:49:57
 *
 */
@ControllerAdvice
public class MyControllerAdvice {

//	@ResponseBody
//	@ExceptionHandler(value = Exception.class)
//	public Map errorHandler(Exception ex) {
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("status", "500");
//		map.put("msg", "运行时异常");
//		map.put("data", "");
//		return map;
//
//	}


//	  // 捕捉shiro的异常
//    @ResponseStatus(HttpStatus.UNAUTHORIZED)
//    @ExceptionHandler(ShiroException.class)
//    public ResponseBean handle401(ShiroException e) {
//        return new ResponseBean(401, e.getMessage(), null);
//    }
//
//    // 捕捉UnauthorizedException
//    @ResponseStatus(HttpStatus.UNAUTHORIZED)
//    @ExceptionHandler(UnauthorizedException.class)
//    public ResponseBean handle401() {
//        return new ResponseBean(401, "Unauthorized", null);
//    }
//
//    // 捕捉其他所有异常
//    @ExceptionHandler(Exception.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ResponseBean globalException(HttpServletRequest request, Throwable ex) {
//        return new ResponseBean(getStatus(request).value(), ex.getMessage(), null);
//    }
//
//    private HttpStatus getStatus(HttpServletRequest request) {
//        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
//        if (statusCode == null) {
//            return HttpStatus.INTERNAL_SERVER_ERROR;
//        }
//        return HttpStatus.valueOf(statusCode);
//    }


}
