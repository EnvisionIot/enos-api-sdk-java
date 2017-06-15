package com.envision.eeop.event;

import java.io.Serializable;
import java.sql.Timestamp;

public class Event implements Serializable {
	private static final long serialVersionUID = 1L;

	private String childWarnType;
	private Integer id;
	private String category;
	private String tag;
	private String info;
	private String srStatus;

	/**
	 * 告警组
	 **/
	private String warnGroup;
	/**
	 * 告警级别
	 **/
	private String level;
	/**
	 * 告警类型
	 **/
	private String warnType;
	/**
	 * 场站主数据ID
	 **/
	private String siteId;
	/**
	 * yx_alias,yc_alias,ld_alias,machine_alias,fac_alias,cb_alias,tr_alias,dev_alias,machine_alias,ied_alias,wtg_alias
	 **/
	private String pointId;

	/**
	 * 设备主数据ID
	 */
	private String deviceId;

	///// 发生时间 /////

	/**
	 * 告警时间(occur_time sc_starttime nodestamp time_str)
	 **/
	private Timestamp occurTime;
	/**
	 * 告警时间UTC(occur_time_utc nodestamp_utc)
	 **/
	private Timestamp occurTimeUtc;

	///// 发生原因 /////

	/**
	 * 确认人
	 **/
	private String opPerson;
	/**
	 * yx_val,yc_lock_val,val,yk_mode,yt_val_new,sc_id,warn_order
	 **/
	private String value;

	///// 标识位 /////

	/**
	 * 状态(status,sourceflag)
	 **/
	private String code;

	private Float floatPara1;

	private Integer intPara1;

	private String strPara1;

	private String codeDesc;

	///// 内容 /////

	/**
	 * 内容(bookmark,content,warn_text)
	 **/
	private String content;

	//// 确认详情 /////

	/**
	 * 确认人
	 **/
	private String confirmPerson;
	/**
	 * 确认告警时间
	 **/
	private Timestamp confirmTime;

	/**
	 * 全局标识Id
	 */
	private String globalId;
	/**
	 * 入库时间utc
	 */
	private Timestamp insertTimeUtc;

	private Timestamp endTime;

	private Timestamp endTimeUtc;
	/**
	 * 确认值
	 */
	private Integer confirmValue;

	private Long func1;
	private Long func2;
	private Long func3;
	private Long func4;

	public String getChildWarnType() {
		return childWarnType;
	}

	public Long getFunc1() {
		return func1;
	}

	public void setFunc1(Long func1) {
		this.func1 = func1;
	}

	public Long getFunc2() {
		return func2;
	}

	public void setFunc2(Long func2) {
		this.func2 = func2;
	}

	public Long getFunc3() {
		return func3;
	}

	public void setFunc3(Long func3) {
		this.func3 = func3;
	}

	public Long getFunc4() {
		return func4;
	}

	public void setFunc4(Long func4) {
		this.func4 = func4;
	}

	public void setChildWarnType(String childWarnType) {
		this.childWarnType = childWarnType;
	}

	public String getWarnGroup() {
		return warnGroup;
	}

	public void setWarnGroup(String warnGroup) {
		this.warnGroup = warnGroup;
	}

	public String getWarnType() {
		return warnType;
	}

	public void setWarnType(String warnType) {
		this.warnType = warnType;
	}

	public String getSiteId() {
		return siteId;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	public String getPointId() {
		return pointId;
	}

	public void setPointId(String pointId) {
		this.pointId = pointId;
	}

	public Timestamp getOccurTime() {
		return occurTime;
	}

	public void setOccurTime(Timestamp occurTime) {
		this.occurTime = occurTime;
	}

	public Timestamp getOccurTimeUtc() {
		return occurTimeUtc;
	}

	public void setOccurTimeUtc(Timestamp occurTimeUtc) {
		this.occurTimeUtc = occurTimeUtc;
	}

	public String getOpPerson() {
		return opPerson;
	}

	public void setOpPerson(String opPerson) {
		this.opPerson = opPerson;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Float getFloatPara1() {
		return floatPara1;
	}

	public void setFloatPara1(Float floatPara1) {
		this.floatPara1 = floatPara1;
	}

	public Integer getIntPara1() {
		return intPara1;
	}

	public void setIntPara1(Integer intPara1) {
		this.intPara1 = intPara1;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getConfirmPerson() {
		return confirmPerson;
	}

	public void setConfirmPerson(String confirmPerson) {
		this.confirmPerson = confirmPerson;
	}

	public Timestamp getConfirmTime() {
		return confirmTime;
	}

	public void setConfirmTime(Timestamp confirmTime) {
		this.confirmTime = confirmTime;
	}

	public Timestamp getInsertTimeUtc() {
		return insertTimeUtc;
	}

	public void setInsertTimeUtc(Timestamp insertTimeUtc) {
		this.insertTimeUtc = insertTimeUtc;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public Timestamp getEndTimeUtc() {
		return endTimeUtc;
	}

	public void setEndTimeUtc(Timestamp endTimeUtc) {
		this.endTimeUtc = endTimeUtc;
	}

	public Integer getConfirmValue() {
		return confirmValue;
	}

	public void setConfirmValue(Integer confirmValue) {
		this.confirmValue = confirmValue;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getGlobalId() {
		return globalId;
	}

	public void setGlobalId(String globalId) {
		this.globalId = globalId;
	}

	public String getStrPara1() {
		return strPara1;
	}

	public void setStrPara1(String strPara1) {
		this.strPara1 = strPara1;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCodeDesc() {
		return codeDesc;
	}

	public void setCodeDesc(String codeDesc) {
		this.codeDesc = codeDesc;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getSrStatus() {
		return srStatus;
	}

	public void setSrStatus(String srStatus) {
		this.srStatus = srStatus;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Event [childWarnType=" + childWarnType + ", id=" + id + ", category=" + category + ", tag=" + tag
				+ ", info=" + info + ", srStatus=" + srStatus + ", warnGroup=" + warnGroup + ", level=" + level
				+ ", warnType=" + warnType + ", siteId=" + siteId + ", pointId=" + pointId + ", deviceId=" + deviceId
				+ ", occurTime=" + occurTime + ", occurTimeUtc=" + occurTimeUtc + ", opPerson=" + opPerson + ", value="
				+ value + ", code=" + code + ", floatPara1=" + floatPara1 + ", intPara1=" + intPara1 + ", strPara1="
				+ strPara1 + ", codeDesc=" + codeDesc + ", content=" + content + ", confirmPerson=" + confirmPerson
				+ ", confirmTime=" + confirmTime + ", globalId=" + globalId + ", insertTimeUtc=" + insertTimeUtc
				+ ", endTime=" + endTime + ", endTimeUtc=" + endTimeUtc + ", confirmValue=" + confirmValue + ", func1="
				+ func1 + ", func2=" + func2 + ", func3=" + func3 + ", func4=" + func4 + "]";
	}

}