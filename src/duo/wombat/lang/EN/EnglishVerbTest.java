package duo.wombat.lang.EN;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.*;

public class EnglishVerbTest {

    private static IrregularVerbsReader iVtable;
    private EnglishVerb engVerb;
    private ArrayList<EnglishIrregularVerb> irvList;

    @Before
    public void setup(){
        iVtable = new IrregularVerbsReader();
        iVtable.read("/Users/LaburenkoAV/IdeaProjects/morph/src/irregular_verbs.txt");
        irvList = iVtable.getVerbsList();
        Collections.sort(irvList, EnglishIrregularVerb.EndingComparator);
    }

    @Test
    public void checkIrregularVerbsPastForm(){
        for (EnglishIrregularVerb v : irvList){
            assertPastVerbForm(v.getInfinitive(), "1mS", v.getPastSimple());
        }
    }

    @Test
    public void testWaitShouldBeWaitedIn_Past_3rdPersonPlural() {
        assertPastVerbForm("wait", "3mP", "waited");
    }

    @Test
    public void testWaitShouldBeWaitedIn_Past_1stdPersonPlural() {
        assertPastVerbForm("live", "1mP", "lived");
    }

    @Test
    public void testTravelShouldBeTravelsIn_Present_3rdPersonPlural() {
        assertPresentVerbForm("travel", "3mP", "travel");
    }

    @Test
    public void testDolShouldBeWillDolIn_Future_3rdPersonPlural() {
        assertFutureVerbForm("do", "3mP", "will do");
    }

    @Test
    public void testLookShouldBeLookIn_Present_1stPersonSingular() {
        assertPresentVerbForm("look", "1mS", "look");
    }

    @Test
    public void testTravelShouldBeTravelIn_Present_1stPersonSingular() {
        assertPresentVerbForm("travel", "1mS", "travel");
    }

    @Test
    public void testTravelShouldBeTravelIn_Present_2ndPersonSingular() {
        assertPresentVerbForm("travel", "2mS", "travel");
    }

    @Test
    public void testTravelShouldBeTravelsIn_Present_3rdPersonSingular() {
        assertPresentVerbForm("travel", "3mS", "travels");
    }

    @Test
    public void testGoShouldBeGoesIn_Present_3rdPersonSingular() {
        assertPresentVerbForm("go", "3mS", "goes");
    }

    @Test
    public void testKissShouldBeKissesIn_Present_3rdPersonSingular() {
        assertPresentVerbForm("kiss", "3mS", "kisses");
    }

    @Test
    public void testSayShouldBeSaysIn_Present_3rdPersonSingular() {
        assertPresentVerbForm("say", "3mS", "says");
    }

    @Test
    public void testHurryShouldBeHurriesIn_Present_3rdPersonSingular() {
        assertPresentVerbForm("hurry", "3mS", "hurries");
    }

    private void assertPastVerbForm(String infinitive, String form, String expected) {
        assertVerbForm("past", infinitive, form, expected);
    }

    private void assertPresentVerbForm(String infinitive, String form, String expected) {
        assertVerbForm("present", infinitive, form, expected);
    }

    private void assertFutureVerbForm(String infinitive, String form, String expected) {
        assertVerbForm("future", infinitive, form, expected);
    }

    private void assertVerbForm(String tense, String infinitive, String form, String expected) {
        engVerb = new EnglishVerb(infinitive);
        int person = Integer.parseInt(form.substring(0, 1));
        char genus = form.charAt(1);
        String number = form.charAt(2) == 'S' ? "singular" : "plural";
        assertEquals(expected, engVerb.getVerbForm(tense, person, genus, number));
    }
}
