package duo.wombat;

import duo.wombat.lang.EN.EnglishVerb;

public class VerbMorpher {

    public static void main(String[] args) {

        String answer;

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

}
