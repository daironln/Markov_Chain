import java.util.*;

public class Markov_Chain {

    protected final int order;
    protected static Map<String, List<Character>> n_gram = new HashMap<>();
    protected String txt;
    String resut = "";

    public Markov_Chain(int order, String txt) {
        this.order = order;
        this.txt = txt;

        Init_NGram();
    }

    public void Init_NGram() {
        for (int i = 0; i < txt.length() - order; i++) {
            String ngram = txt.substring(i, i + order);

            if (!n_gram.containsKey(ngram))
                n_gram.put(ngram, new ArrayList<>());

            n_gram.get(ngram).add(txt.charAt(i + order));

        }
    }

    public void Markov(int length) {
        List<Character> posibilidades;

        String sigLeter = "";

        int sigPos = 0;
        Random r = new Random();

        String ngramActual = txt.substring(0, order);

        resut = ngramActual;

        for (int i = 0; i < length; i++) {

            posibilidades = new ArrayList<>(n_gram.get(ngramActual));
            sigPos = r.nextInt(posibilidades.size());
            sigLeter = posibilidades.get(sigPos).toString();

            resut += sigLeter;

            int initPos = resut.length() - order;
            int finPos = resut.length();

            ngramActual = resut.substring(initPos, finPos);
        }
    }

    public String Get_Result() {
        return resut;
    }

    public String Get_txt() {
        return txt;
    }

    public int Get_order() {
        return order;
    }

    public void DebugKEY_VALUE() {
        for (String key : n_gram.keySet()) {
            String s = "";
            for (int i = 0; i < n_gram.get(key).size(); i++) {
                s += n_gram.get(key).get(i).toString();
            }
            System.out.println(key + " :" + s);
        }
    }

    public Map<String, List<Character>> Get_Ngram() {
        return n_gram;
    }
}
