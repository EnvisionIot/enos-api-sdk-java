package com.envision.eeop.internal.event;

/**
 * 类型枚举 0 所有告警 1 确认过的告警 2 未被确认的告警
 */
public enum ConfirmType {
	ALL(0), ONLY_CONFIRM(1), ONLY_UNCONFIRM(2);

	private int codeVal;

	private ConfirmType(int codeVal) {
		this.codeVal = codeVal;
	}

	@Override
	public String toString() {
		return String.valueOf(codeVal);
	}
}