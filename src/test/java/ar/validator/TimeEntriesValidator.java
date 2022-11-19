package ar.validator;

import api.model.TimeEntry.TimeEntryResponse;
import com.crowdar.api.rest.APIManager;
import org.testng.Assert;
import services.TimeEntriesService;

public class TimeEntriesValidator {

    public static void validateAllTimeEntries() {
        TimeEntryResponse[] timeEntries = (TimeEntryResponse[]) APIManager.getLastResponse().getResponse();
        Assert.assertTrue(timeEntries.length > 0, "No entries found!");
    }

    public static void validateNewEntryInsertion() {
        TimeEntryResponse responseToPost = (TimeEntryResponse) APIManager.getLastResponse().getResponse();
        TimeEntriesService.TIMEENTRY_ID.set(responseToPost.getId());
        TimeEntriesService.get();
        TimeEntryResponse responseToGet = (TimeEntryResponse) APIManager.getLastResponse().getResponse();
        Assert.assertEquals(responseToPost.getId(), responseToGet.getId());
        TimeEntriesService.delete();
    }
}
