import info.lenni.PostalCodes;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

@RunWith(JUnitParamsRunner.class)
public class PostalCodesTest {

    @Test
    public void shouldInitialialiseRegexes() throws Exception {
        assertThat(PostalCodes.postalCodes.size(), is(158));
    }

    @Test
    @Parameters({"71139", "10407"})
    public void shouldValidateGermanPostalCode(String postalCode) throws Exception {
        assertTrue(PostalCodes.isValid(postalCode, "DE"));
    }

    @Test
    //http://www.doogal.co.uk/PostcodeGenerator.php
    @Parameters({"KA9 4AT", "SW4 8LL", "DA11 8AQ", "SL3 0AX", "CV6 4DZ"})
    public void shouldValidateBritishPostalCode(String postalCode) throws Exception {
        assertTrue(PostalCodes.isValid(postalCode, "GB"));
    }

    @Test
    @Parameters({"KA9-4AT", "SW 8LL", "678"})
    public void shouldInvalidateBritishPostalCode(String postalCode) throws Exception {
        assertFalse(PostalCodes.isValid(postalCode, "GB"));
    }
}

