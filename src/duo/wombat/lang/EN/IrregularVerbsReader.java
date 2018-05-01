package duo.wombat.lang.EN;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class IrregularVerbsReader {

    private ArrayList<EnglishIrregularVerb> irregularVerbs = new ArrayList<>();

    public ArrayList<EnglishIrregularVerb> getVerbsList() {
        return irregularVerbs;
    }

    public void read(String filename) {
        try {
            BufferedReader buf = new BufferedReader(new FileReader(filename));
            String lineJustFetched = null;
            String[] forms;

            while (true) {
                lineJustFetched = buf.readLine();
                if (lineJustFetched == null) {
                    break;
                } else {
                    forms = lineJustFetched.split("\t");
                    if (forms.length == 3) {
                        EnglishIrregularVerb irVerb = new EnglishIrregularVerb(forms[0], forms[1], forms[2]);
                        irregularVerbs.add(irVerb);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
