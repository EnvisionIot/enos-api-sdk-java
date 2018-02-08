package com.envision.eeop.api.domain;

public class CloudedgeErrorCode {

	/**
	 * cloudedge不存在
	 */
	public static final int APP_IS_NOT_EXIST = -1;
	/**
	 * cloudedge未创建好
	 */
	public static final int APP_IS_NOT_READY = -2;

	/**
	 * 无权限
	 */
	public static final int APP_NO_PRIVILEDGE = -3;

	/**
	 * cloudedge容量不足
	 */
	public static final int APP_NO_CAPACITY = -4;

	/**
	 * cloudedge无collector信息，该错误用于前端页面校验
	 */
	public static final int APP_NO_COLLECTOR = -10;

	/**
	 * cloudedge无端口信息，该错误用于前端页面校验
	 */
	public static final int APP_NO_SERVER_PORT = -11;

	/**
	 * 设备重复添加
	 */
	public static final int DEVICE_DUP_ATTATCHED = -20;
	/**
	 * 添加设备不匹配cloudedge指定设备模板
	 */
	public static final int DEVICE_NOT_MATCH_APP_TEMPLATE = -21;

	/**
	 * 添加设备不匹配cloudedge指定端口
	 */
	public static final int DEVICE_NOT_MATCH_APP_PORT = -22;

	/**
	 * 添加设备未指定合法的主数据id
	 */
	public static final int DEVICE_INVALID_CIM = -23;

	/**
	 * 添加设备未指定合法的设备模板id
	 */
	public static final int DEVICE_INVALID_TEMPLATE = -24;
	/**
	 * 参数无namespace
	 */
	public static final int PARAM_NO_NAMESPACE = -30;

	/**
	 * 参数无auth信息
	 */
	public static final int PARAM_NO_AUTH = -31;
	/**
	 * 参数无cloudedge app id
	 */
	public static final int PARAM_NO_APP_ID = -32;

	/**
	 * 系统DB错误
	 */
	public static final int SYS_DB_ERROR = -100;

	/**
	 * 系统错误，凡是"SYS_"开头错误，都是系统报错
	 */
	public static final int SYS_OTHER_ERROR = -199;
}
