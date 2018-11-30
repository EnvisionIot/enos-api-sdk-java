package com.envision.eeop.api.response;

import java.util.Map;

import com.envision.eeop.api.EnvisionResponse;
import com.google.gson.annotations.SerializedName;

/**
 * MQTT client status response
 * @author jieyuan.shen
 */
public class MqttClientStatusGetResponse extends EnvisionResponse
{
    private static final long serialVersionUID = 1636479139276657649L;

    // MQTT client status
    public static String MQTT_CLIENT_ALIVE = "mqttClientAlive";
    public static String NOT_ALIVE = "0";
    public static String ALIVE = "1";

    @SerializedName("data")
    private Map<String/*client ID*/, Map<String,String>> mqttClientStatus;

    public Map<String/*client ID*/, Map<String,String>> getMqttClientStatus()
    {
        return mqttClientStatus;
    }

    public void setMqttClientStatus(Map<String, Map<String,String>> mqttClientStatus)
    {
        this.mqttClientStatus = mqttClientStatus;
    }

    public boolean isMqttClientAlive(String clientId)
    {
        return mqttClientStatus.containsKey(clientId) && 
               mqttClientStatus.get(clientId).containsKey(MQTT_CLIENT_ALIVE) &&
               mqttClientStatus.get(clientId).get(MQTT_CLIENT_ALIVE).equals(ALIVE);
    }

    @Override
    public String toString()
    {
        return "MqttClientStatusGetResponse [mqttClientStatus=" + mqttClientStatus + "]";
    }
}
