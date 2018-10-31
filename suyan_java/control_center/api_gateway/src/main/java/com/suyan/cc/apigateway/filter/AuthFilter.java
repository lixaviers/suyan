package com.suyan.cc.apigateway.filter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * 权限拦截
 */
@Component
public class AuthFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return PRE_DECORATION_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    private AntPathMatcher pathMatcher = new AntPathMatcher();

    @Override
    public Object run() {

        Map<String, String> ignoreUrls = new HashMap<>();
        ignoreUrls.put("/user/oauth/token", "/user/oauth/token");
        ignoreUrls.put("/urms/resource/nav", "/urms/resource/nav");
        ignoreUrls.put("/urms/user/getUserInfo", "/urms/user/getUserInfo");
        ignoreUrls.put("/user/oauth/refresh_token", "/user/oauth/refresh_token");
        ignoreUrls.put("/user/user/logout", "/user/user/logout");

        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        if (ignoreUrls.get(request.getRequestURI()) != null) {
            return null;
        }

        RestTemplate restTemplate = new RestTemplate();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        headers.add("Authorization", request.getHeader("Authorization"));
        HttpEntity<String> requestEntity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> exchange = restTemplate.exchange("http://127.0.0.1:60000/user/getResourceUrl", HttpMethod.GET, requestEntity, String.class, new HashMap<>());

        JSONObject jsonObject = JSON.parseObject(exchange.getBody());
        Object dataMap = jsonObject.get("dataMap");
        if (dataMap != null) {
            jsonObject = JSON.parseObject(dataMap.toString());

            if (jsonObject.getBoolean("isAdmin")) {
                return null;
            }

            JSONArray urlList = jsonObject.getJSONArray("urlList");

            if (urlList != null) {
                for (Object url : urlList) {
                    if (pathMatcher.match(url.toString(), request.getRequestURI())) {
                         return null;
                    }
                }
            }
        }

        requestContext.setSendZuulResponse(false);
        requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());

        return null;
    }
}
