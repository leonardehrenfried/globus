import info.lenni.Countries;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CountriesTest {

    @Test
    public void shouldPutGermanyInCountryList(){
        Map<String, String> countries = Countries.get("de");
        assertThat(countries.get("DE"), is("Deutschland"));
    }


}
