package duo.wombat;

import duo.wombat.lang.EN.EnglishIrregularVerb;
import duo.wombat.lang.EN.IrregularVerbsReader;

import java.util.ArrayList;
import java.util.Collections;

public class IrregularVerbsPrinter {


    public static void main(String[] args) {

        if (args.length>0 ) {
            IrregularVerbsReader irr = new IrregularVerbsReader();
            irr.read(args[0]);

            ArrayList<EnglishIrregularVerb> irvl = irr.getVerbsList();

            Collections.sort(irvl, EnglishIrregularVerb.EndingComparator);

            for (EnglishIrregularVerb irv : irvl) {
                System.out.println(irv.toString());
            }
        }

    }
}
