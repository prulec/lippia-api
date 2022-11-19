package ar.steps;

import ar.validator.WorkspaceValidator;
import com.crowdar.core.PageSteps;
import com.crowdar.core.PropertyManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import services.BaseService;

public class WorkspaceSteps extends PageSteps {

    @Given("Mi cuenta creada en clockify y mi X-Api-Key generada")
    @And("I have the account in Clockify with the X-Api-Key created")
    public void miCuentaCreadaEnClockifyYMiXApiKeyGenerada() {
        BaseService.API_KEY.set(PropertyManager.getProperty("api-key"));
    }

    @And("I have the User Id")
    public void iHaveTheUserId() {
        BaseService.USER_ID.set(PropertyManager.getProperty("user-id"));
    }

    @Then("Obtengo los datos de mi Workspace")
    public void obtengoLosDatosDeMiWorkspace() {
        WorkspaceValidator.validate();
    }

    @Given("X-Api-Key invalido")
    public void xApiKeyInvalido() {
        BaseService.API_KEY.set("NDRmZWUwYzEtOTZhMS00NDk5LWJkZWI");
    }
}
