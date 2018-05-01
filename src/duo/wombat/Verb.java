package duo.wombat;

public interface Verb {

    String getVerbForm(String tense, int person, char genus, String number);

    boolean isIrregularVerb(String infinitive);



}
