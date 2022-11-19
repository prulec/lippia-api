package ar.steps;

import ar.validator.TimeEntriesValidator;
import com.crowdar.core.PageSteps;
import io.cucumber.java.en.Then;

public class TimeEntriesSteps extends PageSteps {

    @Then("I get in response all the time entries for the user")
    public void validateAllTimeEntries () {
        TimeEntriesValidator.validateAllTimeEntries();
    }

    @Then("I get in response the new time entry data")
    public void validateNewTimeEntryData() {
        TimeEntriesValidator.validateNewEntryInsertion();
    }
}
