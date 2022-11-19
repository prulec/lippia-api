package ar.steps;

import api.model.Project.ProjectResponse;
import ar.validator.ProjectValidator;
import com.crowdar.api.rest.APIManager;
import com.crowdar.core.PageSteps;
import com.crowdar.core.PropertyManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import services.BaseService;
import services.ProjectItemService;
import services.ProjectService;

public class ProjectSteps extends PageSteps {

    @Given("I have the Workspace Id")
    @And("un workspaceId")
    public void unWorkspaceId() {
        BaseService.WORKSPACE_ID.set(PropertyManager.getProperty("workspace-id"));
    }

    @And("se obtuvo un Project ID")
    public void seObtuvoUnProjectID() {
        String projectId = ProjectService.getProjectId();
        BaseService.PROJECT_ID.set(projectId);
    }

    @And("un Project ID inexistente")
    public void unProjectIDInexistente() {
        BaseService.PROJECT_ID.set("fffffff");
    }

    @And("un timestamp del momento actual para concatenar al Name a modificar")
    public void unTimestampDelMomentoActual() {
        BaseService.TIMESTAMP.set(Long.toString(System.currentTimeMillis()));
    }

    @And("se obtuvo los datos del Project")
    public void seObtuvoLosDatosDelProject() {
        ProjectResponse[] projects = (ProjectResponse[]) APIManager.getLastResponse().getResponse();
        BaseService.PROJECT_ID.set(projects[0].getId());
        ProjectItemService.PROJECT_NAME.set(projects[0].getName());
        ProjectItemService.PROJECT_CLIENTID.set(projects[0].getClientId());
        ProjectItemService.PROJECT_ISPUBLIC.set(projects[0].isPublico());
        ProjectItemService.PROJECT_HOURLYRATE_AMOUNT.set(projects[0].getHourlyRate().getAmount());
        ProjectItemService.PROJECT_COLOR.set(projects[0].getColor());
        ProjectItemService.PROJECT_NOTE.set(projects[0].getNote());
        ProjectItemService.PROJECT_BILLABLE.set(projects[0].isBillable());
        ProjectItemService.PROJECT_ARCHIVED.set(projects[0].isArchived());
    }

    @And("se valida que el Name fue modificado correctamente")
    public void seValidaQueElNameFueModificadoCorrectamente() {
        ProjectValidator.validate();
    }
}
