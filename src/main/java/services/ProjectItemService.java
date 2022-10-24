package services;

import api.model.Project.ProjectResponse;
import com.crowdar.api.rest.Response;

import java.util.HashMap;
import java.util.Map;

public class ProjectItemService extends BaseService {

    public static final ThreadLocal<String> PROJECT_NAME = new ThreadLocal<>();
    public static final ThreadLocal<String> PROJECT_CLIENTID = new ThreadLocal<>();
    public static final ThreadLocal<Boolean> PROJECT_ISPUBLIC = new ThreadLocal<>();
    public static final ThreadLocal<Integer> PROJECT_HOURLYRATE_AMOUNT = new ThreadLocal<>();
    public static final ThreadLocal<String> PROJECT_COLOR = new ThreadLocal<>();
    public static final ThreadLocal<String> PROJECT_NOTE = new ThreadLocal<>();
    public static final ThreadLocal<Boolean> PROJECT_BILLABLE = new ThreadLocal<>();
    public static final ThreadLocal<Boolean> PROJECT_ARCHIVED = new ThreadLocal<>();


    public static Response get(String jsonName) {
        return get(jsonName, ProjectResponse.class, setParams());
    }

    private static Map<String,String> setParams(){
        Map<String,String> params = new HashMap<>();
        params.put("api-key", API_KEY.get());
        params.put("workspaceId", WORKSPACE_ID.get());
        params.put("projectId", PROJECT_ID.get());
        return params;
    }

    public static Response put(String jsonName) {
        return put(jsonName, ProjectResponse.class, setParamsPut(setParams(), Boolean.FALSE));
    }

    public static Response put(String jsonName, boolean origName) {
        return put(jsonName, ProjectResponse.class, setParamsPut(setParams(), origName));
    }

    private static Map<String,String> setParamsPut(Map<String,String> params, boolean origName) {
        if (origName) {
            params.put("name", PROJECT_NAME.get());
        } else {
            params.put("name", PROJECT_NAME.get() + " " + TIMESTAMP.get());
        }
        params.put("clientId", PROJECT_CLIENTID.get());
        params.put("isPublic", PROJECT_ISPUBLIC.get().toString());
        params.put("hourlyRate_amount", PROJECT_HOURLYRATE_AMOUNT.get().toString());
        params.put("color", PROJECT_COLOR.get());
        params.put("note", PROJECT_NOTE.get());
        params.put("billable", PROJECT_BILLABLE.get().toString());
        params.put("archived", PROJECT_ARCHIVED.get().toString());
        return params;
    }

}
