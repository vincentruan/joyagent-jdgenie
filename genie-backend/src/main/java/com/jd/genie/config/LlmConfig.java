package com.jd.genie.config;

import com.jd.genie.agent.llm.LLMSettings;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import java.util.HashMap;
import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "llm")
public class LlmConfig {
    
    /**
     * Default LLM configuration
     */
    private LLMSettings defaultConfig = new LLMSettings();
    
    /**
     * Named LLM configurations
     */
    private Map<String, LLMSettings> settings = new HashMap<>();
    
    /**
     * Get LLM settings by model name, fallback to default if not found
     */
    public LLMSettings getSettings(String modelName) {
        return settings.getOrDefault(modelName, defaultConfig);
    }

    public LLMSettings getDefaultConfig() {
        return defaultConfig;
    }

    public void setDefaultConfig(LLMSettings defaultConfig) {
        this.defaultConfig = defaultConfig;
    }

    public void setDefault(LLMSettings defaultConfig) {
        this.defaultConfig = defaultConfig;
    }

    public Map<String, LLMSettings> getSettings() {
        return settings;
    }

    public void setSettings(Map<String, LLMSettings> settings) {
        this.settings = settings;
    }

}
