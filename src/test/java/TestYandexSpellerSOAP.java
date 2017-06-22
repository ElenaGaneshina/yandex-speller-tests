import core.YandexSpellerSOAP;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.Test;

import static core.YandexSpellerConstants.Languages;
import static core.YandexSpellerConstants.wrongWordUK;

/**
 * Created by yulia-atlasova on 22/06/2017.
 * try to test SOAP via RestAssured
 */
public class TestYandexSpellerSOAP {

    @Test
    public void simpleCall(){
        YandexSpellerSOAP.with().callSOAP()
        .then().statusCode(HttpStatus.SC_OK)
        .body("//error+code", Matchers.equalTo("FAILURE"))
//        .("//word", Matchers.equalTo(wrongWordEn));
        ;
    }


    @Test
    public void useRequestBuilderToChangeParams(){
        YandexSpellerSOAP.with()
                .language(Languages.UK)
                .options("5")
                .text(wrongWordUK).callSOAP();
    }
}
