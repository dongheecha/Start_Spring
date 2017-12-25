package com.javalec.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class Measuringinterceptor extends HandlerInterceptorAdapter {
    // private transient Logger logger = LoggerFactory.getLogger(Measuringinterceptor.class); 
    // transient 이거 절대 쓰지마.. null 포인터 유발한다.
 
    // Logger은 꼭 private static이 붙어야 한다. getLogger(클래스명.clss) 적어라.
    private static Logger logger = LoggerFactory.getLogger(Measuringinterceptor.class);
    
    @Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler) throws Exception {
        
        // 현재 시간을 가져온다
        long currentTime = System.currentTimeMillis();
        
        //  컨트롤러 -> DS : 응답을 받아주기 위헤
        //  현재 시간을 모델에 넣는다.
        request.setAttribute("bTime", currentTime);
        
        
        return true;
    }
    
    @Override
    public void afterCompletion(HttpServletRequest request,
            HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        
        //View를 리턴하기 직전 실햄 됨
        
        //현재 시간을 구한다.
        long currentTime = System.currentTimeMillis();
        
        // 요청이 시작된 시간을 가져온다
        long beginTime = (long)request.getAttribute("bTime");
        
        // 현재 시간에서 요청이 시작된 시간을 뺀다.
        // --> 총 처리 시간을 구한다.
        
        long processedTime = currentTime - beginTime;
        
        /*
        // 대부분 실무에서는 debug, info만을 사용 
        logger.trace("Trace 입니다.");
        // 보안상 중요한 자료 - 로그인 과정에서 이사람이 보내준 id와 pwd의 로그
        logger.debug("Debug 입니다.");
        // 다른 사람들이 굳이 봐도 쓸모 없는 것들 - 로그인 성공인지 실패인지, 언제했는지
        logger.info("Info 입니다.");
        logger.warn("Warn 입니다.");
        logger.error("Error 입니다.");
        */
        
        logger.info("요청된 URL : " +request.getRequestURI());
        logger.info("총 처리 시간은 "+processedTime);
        super.afterCompletion(request, response, handler, ex);
    }



}
