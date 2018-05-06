package duo.wombat;


import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.*;


public class    VerbMorpherTest extends VerbMorpher {

    String person ;
    String genus;
    String num;
    String tense;

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();


    @Before
    public void setup(){
        person  = "1";
        genus = "m";
        num = "singular";
        tense = "past";
    }

    @Test
    public void checkNoEceptionThenAllPArametrsAreCorrect() throws Exception {
        assertTrue(paramsAreCorrect(tense, person, genus, num));
    }

    @Test
    public void checkEceptionThenNumberIsWrong() throws Exception {
        String wrong_num = "singilar";

        expectedEx.expect(WrongParameterException.class);
        expectedEx.expectMessage("Number is wrong");
        paramsAreCorrect(tense, person, genus, wrong_num);
    }

    @Test
    public void checkEceptionThenTenseIsWrong() throws Exception {
        String wrong_tense = "passt";

        expectedEx.expect(WrongParameterException.class);
        expectedEx.expectMessage("Tense is wrong");
        paramsAreCorrect(wrong_tense, person, genus, num);
    }

    @Test
    public void checkEceptionThenPersonIsWrong() throws Exception {
        String wrong_person = "5";

      //  expectedEx.expect(WrongParameterException.class);
        expectedEx.expectMessage("Person is wrong");
        paramsAreCorrect(tense, wrong_person, genus, num);
    }

    @Test
    public void checkEceptionThenGenusIsWrong() throws Exception {
        String wrong_genus = "cf";

        expectedEx.expect(WrongParameterException.class);
        expectedEx.expectMessage("Genus is wrong");
        paramsAreCorrect(tense, person, wrong_genus, num);
    }
}
