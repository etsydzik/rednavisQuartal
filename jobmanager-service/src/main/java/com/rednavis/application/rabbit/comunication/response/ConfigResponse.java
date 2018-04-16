package com.rednavis.application.rabbit.comunication.response;

/**
 * This class describes the result of adding new tenant configuration to repository .
 *
 * @autor Arthur Kushner
 */
@Deprecated
public class ConfigResponse extends ServiceQueueResponse {

    private String tenantId;

    private String result;

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
