package com.envision.eeop.internal.event;

public enum Column {

	SITE_ID("site_id", DataType.STRING, true, false, false), 
	ID("id", DataType.BIGINT, true, false, false), 
	GLOBAL_ID("global_id", DataType.STRING, true, false, false), 
	WARN_TYPE("warn_type", DataType.STRING, true, false, false), 
	CHILD_WARN_TYPE("child_warn_type", DataType.STRING, true, false, false), 
	LEVEL("level", DataType.STRING, true, false, false), 
	WARN_GROUP("warn_group", DataType.STRING, true, false, false), 
	CODE("code", DataType.STRING, true, false, false), 
	CODE_DESC("code_desc",DataType.STRING,false,true,true),
	DEVICE_ID("device_id", DataType.STRING, true, false, false), 
	POINT_ID("point_id", DataType.STRING, true, false, false), 
	OCCUR_TIME_UTC("occur_time_utc", DataType.TIME, true, false,false), 
	OCCUR_TIME("occur_time", DataType.TIME, true, false,false),
	END_TIME_UTC("end_time_utc", DataType.TIME, true, false,false), 
	END_TIME("end_time", DataType.TIME, true, false,false),
	INSERT_TIME_UTC("insert_time_utc", DataType.TIME, true, false,false), 
	OP_PERSON("op_person", DataType.STRING, true, false,false),
	CONFIRM_PERSON("confirm_person", DataType.STRING, true, false,false),
	CONFIRM_VALUE("confirm_value", DataType.BIGINT, true, false,false),
	VALUE("value", DataType.STRING, true, false,false),
	CONFIRM_TIME("confirm_time", DataType.TIME, true, false, false),
	CONTENT("content", DataType.STRING, false, true, false),
	INT_PARA_1("int_para_1", DataType.BIGINT, true, false, false), 
	FLOAT_PARA_1("float_para_1", DataType.DOUBLE, true, false, false), 
	STR_PARA_1("str_para_1", DataType.STRING, true, false, false), 
	SR_STATUS("sr_status", DataType.STRING, true, false, false), 
	CATEGORY("category", DataType.STRING, true, false, false), 
	TAG("tag", DataType.STRING, true, false, false), 
	INFO("info",DataType.STRING,false,true,false),
	
	//STAR("*", DataType.BIGINT,true,false,false)

	;

	public enum DataType {
		BIGINT, DOUBLE, STRING, TIME

	}

	private final String name;

	private final DataType type;
	private final boolean is_index;
	private final boolean is_full;
	private final boolean is_language;

	private Column(String name, DataType type, boolean is_index, boolean is_full, boolean is_language) {
		this.name = name;
		this.is_index = is_index;
		this.is_full = is_full;
		this.type = type;
		this.is_language = is_language;
	}

	public String getName(String language) {
		if (is_language) {
			return new StringBuilder(name).append("_").append(language).toString();
		}

		return name;
	}
	
	public String getName(){
		return name;
	}

	public boolean isIndex() {
		return is_index;
	}

	public boolean isFullIndex() {
		return is_full;
	}

	public boolean isLanguage() {
		return is_language;
	}

	public DataType getDataType() {
		return type;
	}
	
	public boolean isNumber(){
		return type==DataType.BIGINT  || type==DataType.DOUBLE;
	}

	public String parse(String str) {

		switch (type) {
		case BIGINT:
			return str;

		case DOUBLE:
			return str;

		case STRING:
		case TIME:
			return "\'" + str + "\'";
		default:
			return str;

		}

	}

}
