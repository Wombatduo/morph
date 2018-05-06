package duo.wombat;

import duo.wombat.lang.EN.EnglishVerb;

import java.util.Arrays;
import java.util.List;

public class VerbMorpher {

    public static List<String> tenses = Arrays.asList("past", "present", "future");
    public static List<String> numbers = Arrays.asList("singular", "plural");
    public static List<String> persons = Arrays.asList("1", "2", "3");
    public static List<String> genuses = Arrays.asList("m", "f", "t");


    public static void main(String[] args) {

        String answer;

        try {
            paramsAreCorrect(args);
        } catch (Exception e) {
            answer = "Неправильный вызов." + e.getMessage();
        }

        if (args.length < 6) {
            answer = "Неправильный вызов." +
                    "\nУкажате 6 аргументов: язык, лицо, род, число, время, инфинитив";
        } else {
            if (args[0].equals("EN")) {
                Verb engVerb = new EnglishVerb(args[5]);
                answer = engVerb.getVerbForm(
                        args[4],
                        Integer.parseInt(args[1]),
                        args[2].charAt(0),
                        args[3]
                );
            } else answer = "Неправильный вызов." +
                    "\nЯзык " + args[0] + " не поддерживается.";
        }

        System.out.println(answer);
    }

    protected static boolean paramsAreCorrect(String[] args) throws WrongParameterException {
        return paramsAreCorrect( args[4], args[1], args[2],  args[3]);
    }

    protected static boolean paramsAreCorrect(String tense, String person, String genus, String number)
// TODO Избавиться от этой формы функции
//    String tense;
//    String person;
//    String genus;
//    String number;

            throws WrongParameterException {
        if (!tenses.contains(tense)) {
            throwWrongParameterExceptionWithMessage("Tense is wrong");
        } else if (!numbers.contains(number)) {
            throwWrongParameterExceptionWithMessage("Number is wrong");
        } else if (!genuses.contains(extract(genus))) {
            throwWrongParameterExceptionWithMessage("Genus is wrong");
        } else if (!persons.contains(person)) {
            throwWrongParameterExceptionWithMessage("Person is wrong");
        }
        return true;
    }

    private static String extract(String genus) {
        return genus.substring(0, 1).toLowerCase();
    }

    private static void throwWrongParameterExceptionWithMessage(String message) throws WrongParameterException {
        WrongParameterException e = new WrongParameterException(message);
        throw e;
    }

}
