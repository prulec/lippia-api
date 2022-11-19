package ar.steps;

import api.model.TimeEntry.TimeEntryResponse;
import ar.validator.TimeEntriesValidator;
import com.crowdar.api.rest.APIManager;
import com.crowdar.core.PageSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import services.TimeEntriesService;

public class TimeEntriesSteps extends PageSteps {

    @Then("I get in response all the time entries for the user")
    public void validateAllTimeEntries () {
        TimeEntriesValidator.validateAllTimeEntries();
    }

    @Then("I validate that the new time entry was saved correctly")
    public void validateNewTimeEntryData() {
        TimeEntriesValidator.validateNewEntryInsertion();
    }

    @And("I have the Time Entry Id")
    public void iHaveTheTimeEntryId() {
        TimeEntriesService.post("request/timeEntries/post_new_tomodify_rq");
        TimeEntryResponse timeEntry = (TimeEntryResponse) APIManager.getLastResponse().getResponse();
        TimeEntriesService.TIMEENTRY_ID.set(timeEntry.getId());
    }

    @Then("I validate that the time entry was modified correctly")
    public void iValidateThatTheTimeEntryWasModifiedCorrectly() {
        TimeEntriesValidator.validateEntryModification();
    }

    @Then("I validate that the time entry was deleted correctly")
    public void iValidateThatTheTimeEntryWasDeletedCorrectly() {
        TimeEntriesValidator.validateEntryDeletion();
    }
}
