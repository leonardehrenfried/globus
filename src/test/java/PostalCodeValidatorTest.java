import info.lenni.globus.PostalCodeValidator;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

@RunWith(JUnitParamsRunner.class)
public class PostalCodeValidatorTest {

    @Test
    public void shouldInitialialiseRegexes() throws Exception {
        assertThat(PostalCodeValidator.postalCodes.size(), is(158));
    }

    @Test
    @Parameters({"71139", "10407"})
    public void shouldValidateGermanPostalCode(String postalCode) throws Exception {
        assertTrue(PostalCodeValidator.isValid(postalCode, "DE"));
    }

    @Test
    @Parameters({"KA9 4AT", "SW4 8LL"})
    public void shouldValidateBritishPostalCode(String postalCode) throws Exception {
        assertTrue(PostalCodeValidator.isValid(postalCode, "GB"));
    }

    public void shouldInvalidateBritishPostalCode() throws Exception {
        assertFalse(PostalCodeValidator.isValid("KA9", "GB"));
    }

    @Test
    @Parameters({"KA9-4AT", "SW 8LL", "678"})
    public void shouldInvalidateGermanPostalCode(String postalCode) throws Exception {
        assertFalse(PostalCodeValidator.isValid(postalCode, "DE"));
    }
}

