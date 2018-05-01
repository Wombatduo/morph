package duo.wombat;

abstract public class AbstractVerb implements Verb {


    private String infinitive;

    public AbstractVerb(String infinitive) {
        this.infinitive = infinitive;
    }

    public String getInfinitive() {
        return this.infinitive;
    }

    public String getSingularPastForm(int person, char genus) {
        return getVerbForm("past", person, genus, "singular");
    }

    public String getSingularPresentForm(int person, char genus) {
        return getVerbForm("present", person, genus, "singular");
    }

    public String getSingularFutureForm(int person, char genus) {
        return getVerbForm("future", person, genus, "singular");
    }

    public String getPluralPastForm(int person, char genus) {
        return getVerbForm("past", person, genus, "plural");
    }

    public String getPluralPresentForm(int person, char genus) {
        return getVerbForm("present", person, genus, "plural");
    }

    public String getPluralFutureForm(int person, char genus) {
        return getVerbForm("future", person, genus, "plural");
    }

}
