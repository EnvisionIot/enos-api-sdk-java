package com.envisioniot.enos.enosapi.api.resource.alarmruleservice;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * tsl string internationalization
 * @author hongjie.shan
 * @date 2018/10/17
 */
public class StringI18n implements Serializable {

    private static final long serialVersionUID = 4153783337475744157L;

    private String defaultValue = null;

    private Map<String, String> i18nValue = new HashMap<>();

    public StringI18n() {
    }

    public StringI18n(String defaultValue) {
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
     *               such as Locale.US.toString(), Locale.SIMPLIFIED_CHINESE.toString(), etc
     * @return
     */
    public String getLocalizedValue(String locale){
        return i18nValue.get(locale);
    }

    /**
     * put localized value
     * @param locale a string representation of LOCALE.
     *               You can use Locale.XXXXX.toString() to get string representation of the locale,
     *               such as Locale.US.toString(), Locale.SIMPLIFIED_CHINESE.toString(), etc
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
        //to json string manually, not necessary to include json library
        StringBuffer sb = new StringBuffer("{");
        boolean hasItem = false;
        if(defaultValue!=null){
            sb.append("\"default\":\""+defaultValue+"\",");
            hasItem = true;
        }
        if(i18nValue!=null) {
            for (Entry<String, String> key : i18nValue.entrySet()) {
                sb.append("\"" + key.getKey() + "\":\"" + key.getValue() + "\",");
                hasItem = true;
            }
        }
        if(hasItem){
            sb.deleteCharAt(sb.length()-1);
        }

        sb.append("}");

        return sb.toString();
    }
}
