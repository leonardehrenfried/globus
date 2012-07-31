import info.lenni.globus.PostalCodeValidator;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class PostalCodeValidatorTest {

    @Test
    public void shouldInitialialiseRegexes() throws Exception {
        assertThat(PostalCodeValidator.postalCodes.size(), is(158));
    }

}

