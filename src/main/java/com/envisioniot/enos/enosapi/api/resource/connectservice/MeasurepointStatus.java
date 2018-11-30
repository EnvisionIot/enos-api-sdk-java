package com.envisioniot.enos.enosapi.api.resource.connectservice;

/**
 * Created by zuoyong.tang on 2018/9/10.
 */
public class MeasurepointStatus {
    private static final long serialVersionUID = 202643448296914505L;

    private String pointId;
    private String ponitName;
    private String dataType;
    private Long time;
    private String value;
//    private String unit;

    public String getPointId() {
        return pointId;
    }

    public void setPointId(String pointId) {
        this.pointId = pointId;
    }

    public String getPonitName() {
        return ponitName;
    }

    public void setPonitName(String ponitName) {
        this.ponitName = ponitName;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

//    public String getUnit() {
//        return unit;
//    }
//
//    public void setUnit(String unit) {
//        this.unit = unit;
//    }
}
