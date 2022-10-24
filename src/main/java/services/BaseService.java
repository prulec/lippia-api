package services;

import com.crowdar.api.rest.MethodsService;
import com.google.gson.JsonArray;

public class BaseService extends MethodsService {

    public static final ThreadLocal<String> API_KEY = new ThreadLocal<String>();

    public static final ThreadLocal<String> WORKSPACE_ID = new ThreadLocal<>();

    public static final ThreadLocal<String> PROJECT_ID = new ThreadLocal<>();

    public static final ThreadLocal<String> TIMESTAMP = new ThreadLocal<>();
}
