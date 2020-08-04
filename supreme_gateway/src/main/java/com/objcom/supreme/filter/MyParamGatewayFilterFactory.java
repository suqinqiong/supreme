package com.objcom.supreme.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

/**
 * 自定义局部过滤器
 * 注意点：{
 * 类名必须是：前缀+GatewayFilterFactory
 * 必须有构造函数
 * 必须有个内部类：Config
 * 处理当前排序方法：shortcutFieldOrder
 * 处理过滤器逻辑：apply
 * }
 */
@Component
public class MyParamGatewayFilterFactory extends AbstractGatewayFilterFactory<MyParamGatewayFilterFactory.Config> {
    /**
     * 定义需要处理的参数
     */
    public static final String PARAM_NAME = "name";

    /**
     * 处理过程
     *
     * @return
     */
    @Override
    public GatewayFilter apply(MyParamGatewayFilterFactory.Config config) {
        return new GatewayFilter() {
            @Override
            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
                String name = exchange.getRequest().getQueryParams().getFirst("name");
                if (!StringUtils.isEmpty(name)) {
                    System.out.println("名字参数：" + name);
                }
                return chain.filter(exchange);
            }
        };
    }

    /**
     * 构造函数
     */
    public MyParamGatewayFilterFactory() {
        super(Config.class);
    }

    /**
     * 处理字段的排序
     *
     * @return
     */
    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList(PARAM_NAME);
    }

    /**
     * 需要处理的参数
     * name：和处理的参数名字保持一致
     */
    public static class Config {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}