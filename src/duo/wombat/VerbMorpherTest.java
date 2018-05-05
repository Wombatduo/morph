package duo.wombat;


import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class VerbMorpherTest extends VerbMorpher {


    @Rule
    public ExpectedException expectedEx = ExpectedException.none();


    @Before
    public void setup(){

    }

    @Test
    public void checkEceptionThenNumberIsWrong() throws Exception {
        int person  = 1;
        String genus = "m";
        String wrong_num = "singilar";
        String tense = "past";
        String inf = "go";

        expectedEx.expect(WrongParameterException.class);
        expectedEx.expectMessage("Number is wrong");

        checkParams(tense, person, genus, wrong_num);
    }

    private void checkParams(String tense, int person, String genus, String num) throws WrongParameterException {
        String message = "Number is wrong";
        WrongParameterException e = new WrongParameterException(message);
        throw e;
    }

    class WrongParameterException extends Exception{

        public WrongParameterException(String message) {
            super(message);
        }

    }

}
