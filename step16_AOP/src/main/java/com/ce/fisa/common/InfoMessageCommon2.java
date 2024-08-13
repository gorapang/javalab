package com.ce.fisa.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.apache.log4j.Logger;

//step02: 4가지 한번에 적용하는 기술: around
//공통 로직으로만 구성된 클래스
@Component //스프링빈 등록
@Aspect //공통 기능
public class InfoMessageCommon2 {

    private static final Logger logger = Logger.getLogger(InfoMessageCommon2.class);

    @Around("within(com.ce.fisa.biz.*)")
    public Object around(ProceedingJoinPoint point) {

        logger.info("어서오세요~~"); //전처리 (Before)
        Object buyReturnValue = null;

        try {
            /*
            ProceedingJoinPoint proceed()
            - biz 메소드의 전처리, 후처리, 리턴값 공통 처리, 예외 공통처리 모두 가능
            - 반환 타입은 Object
            - biz 메소드는 반환값이 있을수도, 없을수도 있다
            - biz 메소드 반환값이 없을 경우: null, 있을 경우: 반환값 반환
             */

            //주의사항: biz 메소드의 반환값이 존재할 경우 반드시 return해야 함 (buyReturnValue)
            buyReturnValue = point.proceed(); //사용자에 의해 호출된 biz 메소드 실제 실행하는 메소드

            logger.info(buyReturnValue + " & 공통"); // return 후처리

            logger.info("~~가세요"); // non-return 후처리

        } catch (Throwable e) { // Object > Throwable > Exception
            logger.error("biz의 예외 발생 시 공통 처리 로직 *****", e); //예외 처리
        }

        return buyReturnValue;
    }

}
