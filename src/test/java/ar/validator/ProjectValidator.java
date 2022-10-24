package ar.validator;

import api.model.Project.ProjectResponse;
import com.crowdar.api.rest.APIManager;
import org.testng.Assert;
import services.BaseService;
import services.ProjectItemService;

public class ProjectValidator {

    public static void validate() {
        ProjectResponse project = (ProjectResponse) APIManager.getLastResponse().getResponse();
        Assert.assertEquals(project.getName(), ProjectItemService.PROJECT_NAME.get() + " " + BaseService.TIMESTAMP.get(), "El Name no es el esperado");
        undoChange();
    }

    private static void undoChange() {
        ProjectItemService.put("request/project/rq_put", Boolean.TRUE);
    }

}
