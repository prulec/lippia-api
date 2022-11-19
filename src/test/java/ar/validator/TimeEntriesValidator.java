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
        TimeEntriesService.get("request/timeEntries/get_byid_rq", Boolean.TRUE);
        TimeEntryResponse responseToGet = (TimeEntryResponse) APIManager.getLastResponse().getResponse();
        Assert.assertEquals(responseToPost.getId(), responseToGet.getId());
        TimeEntriesService.delete("request/timeEntries/delete_rq");
    }

    public static void validateEntryModification() {
        TimeEntriesService.get("request/timeEntries/get_byid_rq", Boolean.TRUE);
        TimeEntryResponse responseToGet = (TimeEntryResponse) APIManager.getLastResponse().getResponse();
        Assert.assertTrue(responseToGet.getTimeInterval().getStart().matches("2019-06-12T12:50:14.*Z"));
        Assert.assertTrue(responseToGet.getTimeInterval().getEnd().matches("2019-06-12T15:50:14.*Z"));
        Assert.assertEquals(responseToGet.getDescription(), "POST desde Lippia modificado");
        TimeEntriesService.delete("request/timeEntries/delete_rq");
    }

    public static void validateEntryDeletion() {
        TimeEntriesService.get("request/timeEntries/get_byid_rq", Boolean.TRUE);
        int statusCodeResponseToGet = APIManager.getLastResponse().getStatusCode();
        Assert.assertEquals(statusCodeResponseToGet, 400);
    }
}
