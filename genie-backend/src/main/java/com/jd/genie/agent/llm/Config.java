package com.jd.genie.agent.llm;

import com.jd.genie.agent.util.SpringContextHolder;
import com.jd.genie.config.GenieConfig;
import com.jd.genie.config.LlmConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;

import java.util.Objects;


/**
 * 配置工具类
 */
@Slf4j
public class Config {
    /**
     * 获取 LLM 配置
     */
    public static LLMSettings getLLMConfig(String modelName) {
        ApplicationContext applicationContext = SpringContextHolder.getApplicationContext();
        GenieConfig genieConfig = applicationContext.getBean(GenieConfig.class);
        LlmConfig llmConfig = applicationContext.getBean(LlmConfig.class);
        
        if (Objects.nonNull(genieConfig.getLlmSettingsMap()) && !genieConfig.getLlmSettingsMap().isEmpty()) {
            return genieConfig.getLlmSettingsMap().getOrDefault(modelName, llmConfig.getDefaultConfig());
        }
        return llmConfig.getDefaultConfig();
    }
}