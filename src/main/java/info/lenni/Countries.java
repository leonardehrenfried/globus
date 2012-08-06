package info.lenni;


import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;

public class Countries {

    public static Map<String, String> get(String lang){
        Locale[] locales = Locale.getAvailableLocales();
        Map<String, String> countries = new HashMap<>();

        for (Locale locale : locales) {
            try{
                String iso = locale.getCountry();
                String code = locale.getCountry();
                Locale inLocal = Locale.forLanguageTag(lang);
                String name = locale.getDisplayCountry(inLocal);
                if (!"".equals(iso) && !"".equals(code) && !"".equals(name)) {
                    countries.put(iso, name);
                }
            }
            catch (MissingResourceException ignored){}
        }
        return countries;
    }
}
