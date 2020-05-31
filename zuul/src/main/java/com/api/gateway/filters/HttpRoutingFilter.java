package com.api.gateway.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UrlPathHelper;

import java.net.MalformedURLException;
import java.net.URL;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.*;

@Slf4j
//@Component
public class HttpRoutingFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        String requestURL = ctx.getRequest().getRequestURL().toString();
        //filter URLs which contains "/api".
        return requestURL.contains("/api");
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        String remoteHost = ctx.getRequest().getRemoteHost();
        String requestURL = ctx.getRequest().getRequestURL().toString();
        if (requestURL.contains("/api")) {
            log.info("remoteHost {} requestURL {}", new Object[]{remoteHost, requestURL});
            try {
                URL url = new URL(requestURL);
                String protocol = url.getProtocol();

            } catch (MalformedURLException e) {
                return null;
            }
//            String originatingRequestUri = this.urlPathHelper.getOriginatingRequestUri(ctx.getRequest());
//            final String requestURI = this.urlPathHelper.getPathWithinApplication(ctx.getRequest());
            /*log.info("URI {} original URI {}", new Object[]{requestURI, originatingRequestUri});
            String protocol = requestURL.substring(0, requestURL.indexOf("//") + 2);
            String urlWithoutProtocol = requestURL.substring(requestURL.indexOf("//") + 2);
            String[] split = urlWithoutProtocol.substring(0, urlWithoutProtocol.indexOf("/")).split("\\.");
            String subPath = split[0];
            final String newURL = protocol + "." + split[1] + "." + split[2];
            //Here the main thing is to create a HttpServletRequestWrapper and override the request coming from the actual request
            HttpServletRequestWrapper httpServletRequestWrapper = new HttpServletRequestWrapper(ctx.getRequest()) {
                public String getRequestURI() {
                    if (requestURI != null && !requestURI.equals("/")) {
                        if (!StringUtils.isEmpty(subPath)) {
                            return "/" + subPath + requestURI;
                        } else {
                            return requestURI;
                        }
                    }
                    if (!StringUtils.isEmpty(subPath)) {
                        return "/" + subPath;
                    } else {
                        return "/";
                    }
                }
                public StringBuffer getRequestURL() {
                    return new StringBuffer(newURL);
                }
            };
            ctx.setRequest(httpServletRequestWrapper);
            HttpServletRequest request = ctx.getRequest();
            log.info("PreFilter: " + String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));*/
        }
        return null;
    }
}
