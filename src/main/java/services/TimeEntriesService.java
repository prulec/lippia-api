package services;

import api.model.TimeEntry.TimeEntryResponse;
import com.crowdar.api.rest.Response;

import java.util.HashMap;
import java.util.Map;

public class TimeEntriesService extends BaseService {

    public static final ThreadLocal<String> TIMEENTRY_ID = new ThreadLocal<>();

    public static Response get(String jsonName) {
        return get(jsonName, TimeEntryResponse[].class, setParamsWithUserId());
    }
    public static Response get(String jsonName, Boolean useTimeEntryId) {
        if (useTimeEntryId) {
            return get(jsonName, TimeEntryResponse.class, setParamsWithTimeEntryId());
        } else {
            return get(jsonName);
        }
    }

    public static Response post(String jsonName) {
        return post(jsonName, TimeEntryResponse.class, setParamsWithUserId());
    }

    public static Response put(String jsonName) {
        return put(jsonName, TimeEntryResponse.class, setParamsWithTimeEntryId());
    }

    public static Response delete(String jsonName) {
        return delete(jsonName, TimeEntryResponse.class, setParamsWithTimeEntryId());
    }

    private static Map<String,String> setParams(){
        Map<String,String> params = new HashMap<>();
        params.put("api-key", BaseService.API_KEY.get());
        params.put("workspace-id", BaseService.WORKSPACE_ID.get());
        return params;
    }
    private static Map<String,String> setParamsWithUserId(){
        Map<String,String> params = setParams();
        params.put("user-id", BaseService.USER_ID.get());
        return params;
    }
    private static Map<String,String> setParamsWithTimeEntryId(){
        Map<String,String> params = setParams();
        params.put("time-entry-id", TIMEENTRY_ID.get());
        return params;
    }
}
