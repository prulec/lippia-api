package services;

import com.crowdar.api.rest.MethodsService;

public class BaseService extends MethodsService {
    public static final ThreadLocal<String> API_KEY = new ThreadLocal<>();
    public static final ThreadLocal<String> WORKSPACE_ID = new ThreadLocal<>();
    public static final ThreadLocal<String> USER_ID = new ThreadLocal<>();
    public static final ThreadLocal<String> PROJECT_ID = new ThreadLocal<>();
    public static final ThreadLocal<String> TIMESTAMP = new ThreadLocal<>();
}
