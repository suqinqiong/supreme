package com.objcom.supreme.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 自定义全局过滤器
 */
@Component
public class LoginGlobalFilter implements GlobalFilter, Ordered {

    /**
     * 过滤拦截
     * @param exchange
     * @param chain
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //获取请求参数token
        String token = exchange.getRequest().getQueryParams().getFirst("token");
        //如果没有传入token
        if (StringUtils.isEmpty(token)) {
            //设置返回状态码-400 参数异常
            exchange.getResponse().setStatusCode(HttpStatus.BAD_REQUEST);
            //结束请求
            return exchange.getResponse().setComplete();
        }
        //传入了token，放行
        return chain.filter(exchange);
    }

    /**
     * 定义过滤器执行顺序
     * 返回值越小，越靠前执行
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
