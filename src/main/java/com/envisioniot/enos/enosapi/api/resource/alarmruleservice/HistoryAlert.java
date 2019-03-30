package com.envisioniot.enos.enosapi.api.resource.alarmruleservice;

public class HistoryAlert extends BaseEvent
{
    private static final long serialVersionUID = 1L;

    private Long recoverTime;
    private Long recoverLocalTime;
    private String recoverReason;

    public Long getRecoverTime()
    {
        return recoverTime;
    }
    public void setRecoverTime(Long recoverTime)
    {
        this.recoverTime = recoverTime;
    }
    public String getRecoverReason()
    {
        return recoverReason;
    }
    public void setRecoverReason(String recoverReason)
    {
        this.recoverReason = recoverReason;
    }

    public Long getRecoverLocalTime()
    {
        return recoverLocalTime;
    }
    public void setRecoverLocalTime(Long recoverLocalTime)
    {
        this.recoverLocalTime = recoverLocalTime;
    }

    @Override
    public String toString() {
        return new StringBuilder(super.toString())
                .append("HistoryEvent{")
                .append("recoverTime=").append(recoverTime)
                .append(", recoverLocalTime=").append(recoverLocalTime)
                .append(", recoverReason='").append(recoverReason).append('\'')
                .append('}')
                .toString();
    }
}
