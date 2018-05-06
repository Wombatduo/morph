package duo.wombat;


import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.*;


public class VerbMorpherTest extends VerbMorpher {

    private static final String PERSON = "1";
    private static final String GENUS = "m";
    private static final String NUM = "singular";
    private static final String TENSE = "past";
    private static final String[] PARAMS = {"EN", PERSON, GENUS, NUM, TENSE};

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();


    @Before
    public void setup(){
    }

    @Test
    public void checkNoEceptionThenAllPArametrsAreCorrect() throws Exception {
        assertTrue(paramsAreCorrect(TENSE, PERSON, GENUS, NUM));
    }

    @Test
    public void checkNoEceptionThenArrayOfParametersIsCorrect() throws Exception {
        assertTrue(paramsAreCorrect(PARAMS));
    }

    @Test
    public void checkEceptionThenNumberIsWrong() throws Exception {
        String wrong_num = "singilar";

        expectedEx.expect(WrongParameterException.class);
        expectedEx.expectMessage("Number is wrong");
        paramsAreCorrect(TENSE, PERSON, GENUS, wrong_num);
    }

    @Test
    public void checkEceptionThenTenseIsWrong() throws Exception {
        String wrong_tense = "passt";

        expectedEx.expect(WrongParameterException.class);
        expectedEx.expectMessage("Tense is wrong");
        paramsAreCorrect(wrong_tense, PERSON, GENUS, NUM);
    }

    @Test
    public void checkEceptionThenPersonIsWrong() throws Exception {
        String wrong_person = "5";

      //  expectedEx.expect(WrongParameterException.class);
        expectedEx.expectMessage("Person is wrong");
        paramsAreCorrect(TENSE, wrong_person, GENUS, NUM);
    }

    @Test
    public void checkEceptionThenGenusIsWrong() throws Exception {
        String wrong_genus = "cf";

        expectedEx.expect(WrongParameterException.class);
        expectedEx.expectMessage("Genus is wrong");
        paramsAreCorrect(TENSE, PERSON, wrong_genus, NUM);
    }
}
