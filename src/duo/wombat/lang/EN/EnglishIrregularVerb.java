package duo.wombat.lang.EN;

import java.util.Comparator;

public class EnglishIrregularVerb implements Comparable {

    private String infinitive;
    public String pastSimple;
    public String pastParticiple;

    EnglishIrregularVerb(String infinitive, String pastSimple, String pastParticiple) {
        this.infinitive = infinitive;
        this.pastSimple = pastSimple;
        this.pastParticiple = pastParticiple;
    }

    public String getInfinitive() {
        return this.infinitive;
    }

    public String getPastSimple() {
        return this.pastSimple;
    }

    public String getPastParticiple() {
        return this.pastParticiple;
    }

    public static Comparator<EnglishIrregularVerb> EndingComparator
            = new Comparator<EnglishIrregularVerb>() {

        @Override
        public int compare(EnglishIrregularVerb o1, EnglishIrregularVerb o2) {
            String verbEnding1 = new StringBuilder(o1.getInfinitive()).reverse().toString();
            String verbEnding2 = new StringBuilder(o2.getInfinitive()).reverse().toString();
            return verbEnding1.compareTo(verbEnding2);
        }
    };

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(this.getInfinitive());
        sb.append(" (").append(this.pastSimple).append(", ").append(this.pastParticiple).append(")");
        return sb.toString();
    }

    @Override
    public int compareTo(Object o) {
        return this.getInfinitive().compareTo(o.toString());
    }
}
