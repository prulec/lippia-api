package services;

import api.model.Project.ProjectResponse;
import com.crowdar.api.rest.APIManager;
import com.crowdar.api.rest.Response;

import java.util.HashMap;
import java.util.Map;

public class ProjectService extends BaseService {


    public static Response get(String jsonName) {
        return get(jsonName, ProjectResponse[].class, setParams());
    }

    public static Response get(String jsonName, Map<String,String> params) {
        return get(jsonName, ProjectResponse[].class, params);
    }

    private static Map<String,String> setParams(){
        Map<String,String> params = new HashMap<>();
        params.put("api-key", BaseService.API_KEY.get());
        params.put("workspaceId", BaseService.WORKSPACE_ID.get());
        return params;
    }

    public static String getProjectId() {
        ProjectResponse[] projects = (ProjectResponse[]) APIManager.getLastResponse().getResponse();
        System.out.println(projects[projects.length-1].getId());
        return projects[projects.length-1].getId();
    }
}
