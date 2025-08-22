package com.jd.genie.agent.llm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * LLM 配置类
 */
// @Data
// @Builder
// @NoArgsConstructor
// @AllArgsConstructor
public class LLMSettings {
    /**
     * 模型名称
     */
    private String model;

    /**
     * 最大生成 token 数量
     */
    private int maxTokens;

    /**
     * 温度参数
     */
    private double temperature;

    /**
     * API 类型（openai 或 azure）
     */
    private String apiType;

    /**
     * API 密钥
     */
    private String apiKey;

    /**
     * API 版本（仅适用于 Azure）
     */
    private String apiVersion;

    /**
     * 基础 URL
     */
    private String baseUrl;

    /**
     * 接口 URL
     */
    private String interfaceUrl;

    /**
     * FunctionCall类型
     */
    private String functionCallType;

    /**
     * 最大输入 token 数量
     */
    private int maxInputTokens;

    /**
     * 额外参数
     */
    private Map<String, Object> extParams;


    public LLMSettings() {
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMaxTokens() {
        return maxTokens;
    }

    public void setMaxTokens(int maxTokens) {
        this.maxTokens = maxTokens;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public String getApiType() {
        return apiType;
    }

    public void setApiType(String apiType) {
        this.apiType = apiType;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getInterfaceUrl() {
        return interfaceUrl;
    }

    public void setInterfaceUrl(String interfaceUrl) {
        this.interfaceUrl = interfaceUrl;
    }

    public String getFunctionCallType() {
        return functionCallType;
    }

    public void setFunctionCallType(String functionCallType) {
        this.functionCallType = functionCallType;
    }

    public int getMaxInputTokens() {
        return maxInputTokens;
    }

    public void setMaxInputTokens(int maxInputTokens) {
        this.maxInputTokens = maxInputTokens;
    }

    public Map<String, Object> getExtParams() {
        return extParams;
    }

    public void setExtParams(Map<String, Object> extParams) {
        this.extParams = extParams;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((model == null) ? 0 : model.hashCode());
        result = prime * result + maxTokens;
        long temp;
        temp = Double.doubleToLongBits(temperature);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((apiType == null) ? 0 : apiType.hashCode());
        result = prime * result + ((apiKey == null) ? 0 : apiKey.hashCode());
        result = prime * result + ((apiVersion == null) ? 0 : apiVersion.hashCode());
        result = prime * result + ((baseUrl == null) ? 0 : baseUrl.hashCode());
        result = prime * result + ((interfaceUrl == null) ? 0 : interfaceUrl.hashCode());
        result = prime * result + ((functionCallType == null) ? 0 : functionCallType.hashCode());
        result = prime * result + maxInputTokens;
        result = prime * result + ((extParams == null) ? 0 : extParams.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        LLMSettings other = (LLMSettings) obj;
        if (model == null) {
            if (other.model != null)
                return false;
        } else if (!model.equals(other.model))
            return false;
        if (maxTokens != other.maxTokens)
            return false;
        if (Double.doubleToLongBits(temperature) != Double.doubleToLongBits(other.temperature))
            return false;
        if (apiType == null) {
            if (other.apiType != null)
                return false;
        } else if (!apiType.equals(other.apiType))
            return false;
        if (apiKey == null) {
            if (other.apiKey != null)
                return false;
        } else if (!apiKey.equals(other.apiKey))
            return false;
        if (apiVersion == null) {
            if (other.apiVersion != null)
                return false;
        } else if (!apiVersion.equals(other.apiVersion))
            return false;
        if (baseUrl == null) {
            if (other.baseUrl != null)
                return false;
        } else if (!baseUrl.equals(other.baseUrl))
            return false;
        if (interfaceUrl == null) {
            if (other.interfaceUrl != null)
                return false;
        } else if (!interfaceUrl.equals(other.interfaceUrl))
            return false;
        if (functionCallType == null) {
            if (other.functionCallType != null)
                return false;
        } else if (!functionCallType.equals(other.functionCallType))
            return false;
        if (maxInputTokens != other.maxInputTokens)
            return false;
        if (extParams == null) {
            if (other.extParams != null)
                return false;
        } else if (!extParams.equals(other.extParams))
            return false;
        return true;
    }

    
    

}