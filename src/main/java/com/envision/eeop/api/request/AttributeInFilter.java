package com.envision.eeop.api.request;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class define the filter operation IN
 * @author zhensheng.cai
 * @date 2018/2/22
 */
public class AttributeInFilter extends AppointedFilter{

    private static final long serialVersionUID = -833365542542957033L;
    public static Gson gson = new Gson();


    public static final String OPERATOR = "@@in";

    public AttributeInFilter(Map<String ,Object> filter) {
        super();
        put(OPERATOR, filter);

    }


    public AttributeInFilter(String fieldname, List<String> values) {
        super();
        Map<String, Object> spec = new HashMap<>();
        spec.put(fieldname,  values);
        put(OPERATOR, spec);
    }

    public AttributeInFilter append(String fieldname, List<String>values ){
        Map<String, Object> spec = new HashMap<>();
        spec.put(fieldname,  values);
        put(OPERATOR, spec);
        return this;
    }

    public Map<String ,List<String >> getInValues() {
        Map<String, Object> spec = get(OPERATOR);
        Map<String, List<String>> vals = new HashMap<>();
        for (Map.Entry<String, Object> entry : spec.entrySet()) {
            if(entry.getValue() instanceof List) {
                vals.put(entry.getKey(), (List<String>) entry.getValue());
            }
            else {
                //ignore
            }
        }
        return vals;
    }

    public static void main(String[] args) {
        try{
            List<String> array = new ArrayList<>();
            array.add("haha12");
            array.add("haha123");
            AttributeInFilter in = new AttributeInFilter("haha", array);
            System.out.println(in);
            Map<String, List<String>> values = in.getInValues();
            System.out.println(values);

            String locfilterstr = "{\"@@near\": {\"longitude\": \"116.4885009\", \"latitude\" : \"39.98400216\", \"maxDistance\": \"20000\"}}";
            HashMap<String, Map<String, Object>> locFilterMap = gson.fromJson(locfilterstr, new TypeToken<HashMap<String, Map<String, String>>>() {
            }.getType());
            Map<String, Object> param = locFilterMap.get(LocBaseNearFilter.OPERATOR);
            LocBaseNearFilter locFilter = new LocBaseNearFilter(
                    Double.parseDouble((String)param.get(LocBaseNearFilter.KEY_LONGITUDE))
                    ,Double.parseDouble((String)param.get(LocBaseNearFilter.KEY_LATITUDE))
                    ,Double.parseDouble((String)param.get(LocBaseNearFilter.KEY_MAX_DISTANCE)) ) ;

            System.out.println(locFilter);

            String inFilterStr = "{\"@@in\": {\"mdmId\": [\"d1ef4335-bd79-4d9f-b0ed-84f4807c9466\",\"6672df31-b178-4470-a328-39a211e19d83\",\"6672df31-b178-4470-a328-39a211e19d83-invalid\"] } }";

            HashMap<String, Map<String, Object>> inFilterMap = gson.fromJson(inFilterStr, new TypeToken<HashMap<String, Map<String, Object>>>() {
            }.getType());
            AttributeInFilter inFilter = new AttributeInFilter(inFilterMap.get(OPERATOR));
            System.out.println(inFilter);

            String dupFilterStr = "[{\"@@near\": {\"longitude\": \"116.4885009\", \"latitude\" : \"39.98400216\", \"maxDistance\": \"20000\"},\"@@in\": {\"mdmId\": [\"d1ef4335-bd79-4d9f-b0ed-84f4807c9466\",\"6672df31-b178-4470-a328-39a211e19d83\",\"6672df31-b178-4470-a328-39a211e19d83-invalid\"] } }]";
            List<AppointedFilter> appointFilterList = gson.fromJson(dupFilterStr, new TypeToken<List<AppointedFilter>>() {
            }.getType());
            AppointedFilter appointedFilter = appointFilterList.get(0);
            System.out.println(appointedFilter);

            LocBaseNearFilter locBaseNearFilter = new LocBaseNearFilter(appointedFilter.get(LocBaseNearFilter.OPERATOR));

            System.out.println(locBaseNearFilter);

            AttributeInFilter attributeInFilter = new AttributeInFilter(appointedFilter.get(OPERATOR));
            System.out.println(attributeInFilter);


        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
