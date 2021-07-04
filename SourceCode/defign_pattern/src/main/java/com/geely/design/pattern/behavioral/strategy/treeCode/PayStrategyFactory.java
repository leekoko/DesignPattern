package com.geely.design.pattern.behavioral.strategy.treeCode;

import java.util.HashMap;
import java.util.Map;

public class PayStrategyFactory {
    private static final Map<String, PayStrategy> strategies = new HashMap<>();
    static {
        strategies.put("ALI", new AliPayStrategy());
        strategies.put("UNION", new UnionPayStrategy());
        strategies.put("WECHAT", new WechatPayStrategy());
    }

    public static PayStrategy getStrategy(String type){
        if(type == null || type.isEmpty()){
            throw new IllegalArgumentException("type is null");
        }
        return strategies.get(type);
    }
}
