package io.cloudslang.content.datetime.actions;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.*;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by stcu on 29.04.2016.
 */
public class ParseDateTest {
    private final ParseDate parseDate = new ParseDate();
    private final String RETURN_CODE = "returnCode";
    private final String RETURN_RESULT = "returnResult";

    @Test
    public void testExecuteAllValid() {
        String date = "2001-07-04T12:08:56.235+0700";
        String dateFormat = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
        String dateLocaleLang = "en";
        String dateLocaleCountry = "US";
        String outFormat = "yyyy-MM-dd";
        String outLocaleLang = "fr";
        String outLocaleCountry = "FR";

        final Map<String, String> result = parseDate.execute(date, dateFormat, dateLocaleLang, dateLocaleCountry,
                outFormat, outLocaleLang, outLocaleCountry);
        assertFalse(result.get(RETURN_RESULT).isEmpty());
        assertEquals("0", result.get(RETURN_CODE));
    }

    @Test
    public void testExecuteDateFormatValid() {
        String date = "2001-07-04T12:08:56.235+0700";
        String dateFormat = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
        String outFormat = "yyyy-MM-dd";

        final Map<String, String> result = parseDate.execute(date, dateFormat, null, null,
                outFormat, null, null);
        assertEquals("0", result.get(RETURN_CODE));
        assertEquals("2001-07-04", result.get(RETURN_RESULT));
    }

    @Test
    public void testExecuteUnixValid() {
        String date = "1462254848";
        String dateFormat = "unix";
        String outFormat = "yyyy-MM-dd";
        String outLocaleLang = "en";
        String outLocaleCountry = "US";

        final Map<String, String> result = parseDate.execute(date, dateFormat, null, null,
                outFormat, outLocaleLang, outLocaleCountry);
        assertEquals("0", result.get(RETURN_CODE));
        assertTrue(result.get(RETURN_RESULT).contains("2016-05-03"));
    }

    @Test
    public void testExecuteUnixFailed() {
        String date = "2001-07-04T12:08:56.235+0700";
        String dateFormat = "unix";

        final Map<String, String> result = parseDate.execute(date, dateFormat, null, null,
                null, null, null);
        assertEquals("-1", result.get(RETURN_CODE));
    }

    @Test
    public void testDateFormatFailed() {
        String date = "2001-07-04T12:08:56.235+0700";
        String dateFormat = "222";

        final Map<String, String> result = parseDate.execute(date, dateFormat, null, null,
                null, null, null);
        assertFalse(result.get(RETURN_RESULT).isEmpty());
        assertEquals("-1", result.get(RETURN_CODE));
    }

    @Test
    public void testSimpleDateFormatValid() {
        String date = "Wed, Jul 4, '01";
        String dateFormat = "EEE, MMM d, ''yy";
        String dateLocaleLang = "en";
        String dateLocaleCountry = "US";
        String outFormat = "yyyy-MM-dd";
        String outLocaleLang = "fr";
        String outLocaleCountry = "FR";

        final Map<String, String> result = parseDate.execute(date, dateFormat, dateLocaleLang, dateLocaleCountry,
                outFormat, outLocaleLang, outLocaleCountry);
        assertFalse(result.get(RETURN_RESULT).isEmpty());
        assertEquals("0", result.get(RETURN_CODE));
    }

    @Test
    public void testDateNull() {
        String date = null;
        String dateFormat = "EEE, MMM d, ''yy";
        String dateLocaleLang = "en";
        String dateLocaleCountry = "US";
        String outFormat = "yyyy-MM-dd";
        String outLocaleLang = "fr";
        String outLocaleCountry = "FR";

        final Map<String, String> result = parseDate.execute(date, dateFormat, dateLocaleLang, dateLocaleCountry,
                outFormat, outLocaleLang, outLocaleCountry);
        assertFalse(result.get(RETURN_RESULT).isEmpty());
        assertEquals("-1", result.get(RETURN_CODE));
    }

    @Test
    public void testGetCurrentDateValid() {
        GetCurrentDateTime currentDateTime = new GetCurrentDateTime();
        String date = currentDateTime.execute("en", "US").get(RETURN_RESULT);
        String dateFormat = "";
        String dateLocaleLang = "";
        String dateLocaleCountry = "";
        String outFormat = "";
        String outLocaleLang = "fr";
        String outLocaleCountry = "FR";

        final Map<String, String> result = parseDate.execute(date, dateFormat, dateLocaleLang, dateLocaleCountry,
                outFormat, outLocaleLang, outLocaleCountry);

        assertFalse(result.get(RETURN_RESULT).isEmpty());
        assertEquals("0", result.get(RETURN_CODE));
    }

    @Test
    public void testFormatsNullValid() {
        String date = "2001-07-04T12:08:56.235+0700";
        String dateFormat = "";
        String dateLocaleLang = "en";
        String dateLocaleCountry = "US";
        String outFormat = "";
        String outLocaleLang = "fr";
        String outLocaleCountry = "FR";

        final Map<String, String> result = parseDate.execute(date, dateFormat, dateLocaleLang, dateLocaleCountry,
                outFormat, outLocaleLang, outLocaleCountry);

        assertFalse(result.get(RETURN_RESULT).isEmpty());
        assertEquals("0", result.get(RETURN_CODE));
    }

    @Test
    public void testUnixBug() {
        String date = "1000";
        String dateFormat = "S";
        String dateLocaleLang = "en";
        String dateLocaleCountry = "US";
        String outFormat = "HH:mm:ss";
        String outLocaleLang = "en";
        String outLocaleCountry = "US";

        final Map<String, String> result = parseDate.execute(date, dateFormat, dateLocaleLang, dateLocaleCountry,
                outFormat, outLocaleLang, outLocaleCountry);

        assertFalse(result.get(RETURN_RESULT).isEmpty());
        assertEquals("00:00:01", result.get(RETURN_RESULT));

        assertEquals("0", result.get(RETURN_CODE));
    }


}
