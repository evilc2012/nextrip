package com.nextrip.exception.handler;

import org.slf4j.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

/**
 * Created by EvilC on 2016/4/25.
 */
public class NextripHandlerExceptionResolver extends SimpleMappingExceptionResolver {

    private static final Logger logger = LoggerFactory.getLogger(NextripHandlerExceptionResolver.class);

    protected ModelAndView doResolveException(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse, Object o, Exception e) {
        httpServletRequest.setAttribute("ex", e);
        logger.error("", e);
        return super.doResolveException(httpServletRequest, httpServletResponse, o, e);
    }

}
