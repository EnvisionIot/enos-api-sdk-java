package com.envisioniot.enos.enosapi.api.resource.assetservice;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * tsl string internationalization
 * @author hongjie.shan
 * @date 2018/10/17
 */
public class TSLStringI18n implements Serializable {

    private static final long serialVersionUID = 4153783337475744157L;

    private String defaultValue = null;

    private Map<String, String> i18nValue = new HashMap<>();

    public TSLStringI18n() {
    }

    public TSLStringI18n(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    /**
     * get localized value by locale
     * @param locale a string representation of LOCALE.
     *               You can use Locale.XXXXX.toString() to get string representation of the locale,
     *               such as Locale.ENGLISH.toString(), Locale.SIMPLIFIED_CHINESE.toString(), etc
     * @return
     */
    public String getLocalizedValue(String locale){
        return i18nValue.get(locale);
    }

    /**
     * put localized value
     * @param locale a string representation of LOCALE.
     *               You can use Locale.XXXXX.toString() to get string representation of the locale,
     *               such as Locale.ENGLISH.toString(), Locale.SIMPLIFIED_CHINESE.toString(), etc
     * @param localizedValue
     * @return
     */
    public void setLocalizedValue(String locale, String localizedValue){
        this.i18nValue.put(locale,localizedValue);
    }

    public Map<String, String> getI18nValue() {
        return i18nValue;
    }

    public void setI18nValue(Map<String, String> i18nValue) {
        this.i18nValue = i18nValue;
    }

    @Override
    public String toString()
    {
        return "TSLStringI18n [defaultValue=" + defaultValue + "]";
    }
}
