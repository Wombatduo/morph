package duo.wombat.lang.EN;

import duo.wombat.AbstractVerb;
import duo.wombat.Verb;

import java.util.Arrays;
import java.util.List;

public class EnglishVerb extends AbstractVerb implements Verb {

    private static List<String> irregularConsonantPlusYEndings
            = Arrays.asList("BY", "CY", "DY", "FY", "GY", "HY", "JY", "KY",
            "LY", "MY", "NY", "PU", "QY", "RY", "SY", "TY", "VY", "WY", "XY", "ZY");

    private String language = "EN";

    public EnglishVerb(String infinitive) {
        super(infinitive);
    }

    public String getVerbForm(String tense, int person, char genus, String number) {
        String form = null;
        switch (tense) {
            case "present":
                form = getVerbPresentForm(getInfinitive(), person, number);
                break;
            case "past":
                form = getVerbPastForm(getInfinitive(), number);
                break;
            case "future":
                form = getVerbFutureForm(getInfinitive(), number);
                break;
            default:
                form = getInfinitive();
                break;
        }
        return form;
    }

    private String getVerbPastForm(String form, String number) {
        String fourLetterEnding =
                form.length() > 3 ?
                        form.substring(form.length() - 4, form.length()).toUpperCase() : form.toUpperCase();
        String threeLetterEnding =
                form.length() > 2 ?
                        form.substring(form.length() - 3, form.length()).toUpperCase() : form.toUpperCase();
        String twoLetterEnding =
                form.length() > 1 ?
                        form.substring(form.length() - 2, form.length()).toUpperCase() : form.toUpperCase();

        if (form.toUpperCase().equals("BE"))
            form = "was / were";
        else if (form.toUpperCase().equals("DO"))
            form = "did";
        else if (form.toUpperCase().equals("GO"))
            form = "went";
        else if (form.toUpperCase().equals("SEE"))
            form = "saw";
        else if (form.toUpperCase().equals("LIE"))
            form = "lay";
        else if (form.toUpperCase().equals("HAVE"))
            form = "had";
        else if (form.toUpperCase().equals("LEAVE"))
            form = "left";
        else if (form.toUpperCase().equals("BEGIN"))
            form = "began";
        else if (form.toUpperCase().equals("SPIN"))
            form = "spun";
        else if (form.toUpperCase().equals("WIN"))
            form = "won";
        else if (form.toUpperCase().equals("RUN"))
            form = "ran";
        else if (form.toUpperCase().equals("HEAR"))
            form = "heard";
        else if (form.toUpperCase().equals("EAT"))
            form = "ate";
        else if (form.toUpperCase().equals("LIGHT"))
            form = "lit";
        else if (form.toUpperCase().equals("TEACH"))
            form = "taught";
        else if (form.toUpperCase().equals("BRING"))
            form = "brought";
        else if (form.toUpperCase().equals("THINK"))
            form = "thought";
        else if (form.toUpperCase().equals("FIGHT"))
            form = "fought";
        else if (form.toUpperCase().equals("BUY"))
            form = "bought";
        else if (fourLetterEnding.equals("DEAL") || fourLetterEnding.equals("MEAN"))
            form += "t";
        else if (fourLetterEnding.equals("LEAD") || threeLetterEnding.equals("EED"))
            form = form.substring(0, form.length() - 3) + "ed";
        else if (fourLetterEnding.equals("RBID"))
            form = form.substring(0, form.length() - 3) + "bade";
        else if (fourLetterEnding.equals("UILD") || threeLetterEnding.equals("END"))
            form = form.substring(0, form.length() - 1) + "t";
        else if (fourLetterEnding.equals("HOLD"))
            form = form.substring(0, form.length() - 3) + "eld";
        else if (threeLetterEnding.equals("AND"))
            form = form.substring(0, form.length() - 3) + "ood";
        else if (threeLetterEnding.equals("IND"))
            form = form.substring(0, form.length() - 3) + "ound";
        else if (fourLetterEnding.equals("RIDE"))
            form = form.substring(0, form.length() - 3) + "ode";
        else if (fourLetterEnding.equals("HINE"))
            form = form.substring(0, form.length() - 3) + "one";
        else if (threeLetterEnding.equals("IDE"))
            form = form.substring(0, form.length() - 3) + "id";
        else if (fourLetterEnding.equals("RITE"))
            form = form.substring(0, form.length() - 3) + "ote";
        else if (fourLetterEnding.equals("RIVE"))
            form = form.substring(0, form.length() - 3) + "ove";
        else if (threeLetterEnding.equals("ITE"))
            form = form.substring(0, form.length() - 3) + "it";
        else if (fourLetterEnding.equals("MAKE"))
            form = form.substring(0, form.length() - 3) + "ade";
        else if (fourLetterEnding.equals("WAKE"))
            form = form.substring(0, form.length() - 3) + "oke";
        else if (threeLetterEnding.equals("AKE"))
            form = form.substring(0, form.length() - 3) + "ook";
        else if (threeLetterEnding.equals("DIG"))
            form = form.substring(0, form.length() - 2) + "ug";
        else if (fourLetterEnding.equals("RIKE"))
            form = form.substring(0, form.length() - 3) + "uck";
        else if (fourLetterEnding.equals("COME"))
            form = form.substring(0, form.length() - 3) + "ame";
        else if (fourLetterEnding.equals("RISE"))
            form = form.substring(0, form.length() - 3) + "ose";
        else if (fourLetterEnding.equals("LOSE"))
            form = form.substring(0, form.length() - 3) + "ost";
        else if (fourLetterEnding.equals("OOSE"))
            form = form.substring(0, form.length() - 3) + "se";
        else if (fourLetterEnding.equals("GIVE"))
            form = form.substring(0, form.length() - 3) + "ave";
        else if (fourLetterEnding.equals("SWIM"))
            form = form.substring(0, form.length() - 3) + "wam";
        else if (fourLetterEnding.equals("MEAN"))
            form = form.substring(0, form.length() - 3) + "eant";
        else if (fourLetterEnding.equals("RING") || fourLetterEnding.equals("SING"))
            form = form.substring(0, form.length() - 3) + "ang";
        else if (fourLetterEnding.equals("HANG") || threeLetterEnding.equals("ING"))
            form = form.substring(0, form.length() - 3) + "ung";
        else if (threeLetterEnding.equals("EAK"))
            form = form.substring(0, form.length() - 3) + "oke";
        else if (threeLetterEnding.equals("EAL"))
            form = form.substring(0, form.length() - 3) + "ole";
        else if (threeLetterEnding.equals("EEL"))
            form = form.substring(0, form.length() - 3) + "elt";
        else if (threeLetterEnding.equals("ALL"))
            form = form.substring(0, form.length() - 3) + "ell";
        else if (threeLetterEnding.equals("ELL"))
            form = form.substring(0, form.length() - 3) + "old";
        else if (threeLetterEnding.equals("ICK"))
            form = form.substring(0, form.length() - 3) + "uck";
        else if (threeLetterEnding.equals("INK"))
            form = form.substring(0, form.length() - 3) + "ank";
        else if (threeLetterEnding.equals("EEP"))
            form = form.substring(0, form.length() - 3) + "ept";
        else if (threeLetterEnding.equals("EET"))
            form = form.substring(0, form.length() - 3) + "et";
        else if (threeLetterEnding.equals("GET"))
            form = form.substring(0, form.length() - 3) + "got";
        else if (threeLetterEnding.equals("EAR"))
            form = form.substring(0, form.length() - 3) + "ore";
        else if (threeLetterEnding.equals("SIT"))
            form = form.substring(0, form.length() - 3) + "sat";
        else if (threeLetterEnding.equals("OOT"))
            form = form.substring(0, form.length() - 3) + "ot";
        else if (threeLetterEnding.equals("FLY"))
            form = form.substring(0, form.length() - 1) + "ew";
        else if (twoLetterEnding.equals("AY"))
            form = form.substring(0, form.length() - 1) + "id";
        else if ((twoLetterEnding.equals("AW") ||
                twoLetterEnding.equals("OW")) &&
                !fourLetterEnding.equals("SHOW"))
            form = form.substring(0, form.length() - 2) + "ew";
        else if (fourLetterEnding.equals("EEZE"))
            form = form.substring(0, form.length() - 4) + "oze";
        else if (fourLetterEnding.equals("ATCH"))
            form = form.substring(0, form.length() - 4) + "aught";
        else if (fourLetterEnding.equals("READ") ||
                fourLetterEnding.equals("BEAT") ||
                fourLetterEnding.equals("QUIT") ||
                fourLetterEnding.equals("HURT") ||
                fourLetterEnding.equals("CAST") ||
                fourLetterEnding.equals("COST") ||
                fourLetterEnding.equals("SHUT") ||
                fourLetterEnding.equals("BET") ||
                fourLetterEnding.equals("LET") ||
                fourLetterEnding.equals("SET") ||
                fourLetterEnding.equals("LIT") ||
                fourLetterEnding.equals("HIT") ||
                fourLetterEnding.equals("CUT") ||
                fourLetterEnding.equals("PUT"))
            ;
        else if (form.endsWith("e"))
            form += "d";
        else
            form += "ed";
        return form;
    }

    private String getVerbPresentForm(String infinitive, int person, String number) {
        if (person == 3 && number.equals("singular")) {
            if (isIrregularVerb(infinitive)) {
                for (String ending : irregularConsonantPlusYEndings) {
                    if (infinitive.toUpperCase().endsWith(ending))
                        infinitive = infinitive.substring(0, infinitive.length() - 1) + "i";
                }
                infinitive += 'e';
            }
            if (infinitive.endsWith("i"))
                infinitive += "e";
            infinitive += "s";
        }
        return infinitive;
    }

    private String getVerbFutureForm(String infinitive, String number) {
        infinitive = "will " + infinitive;
        return infinitive;
    }

    public boolean isIrregularVerb(String infinitive) {

        List<String> irregularCommonEndings = Arrays.asList("O", "SS", "CH", "SH", "X", "Z");

        for (String ending : irregularCommonEndings) {
            if (infinitive.toUpperCase().endsWith(ending)) return true;
        }
        for (String ending : irregularConsonantPlusYEndings) {
            if (infinitive.toUpperCase().endsWith(ending)) return true;
        }

        return false;
    }

}
