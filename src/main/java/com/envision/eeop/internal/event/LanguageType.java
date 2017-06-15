package com.envision.eeop.internal.event;

import java.util.HashMap;
import java.util.Map;

public enum LanguageType {
	ZH_CN("zh"), EN_US("en");

	private final static Map<String, LanguageType> maps = new HashMap<String, LanguageType>();
	static {
		for (LanguageType e : LanguageType.values()) {
			maps.put(e.toString(), e);
		}
	}

	private String codeVal;

	private LanguageType(String codeVal) {
		this.codeVal = codeVal;
	}

	@Override
	public String toString() {
		return codeVal;
	}

	public static LanguageType parse(String code) {
		LanguageType o = maps.get(code);
		if (o == null) {
			return ZH_CN;
		}

		return o;
	}

}