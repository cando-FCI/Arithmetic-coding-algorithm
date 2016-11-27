package arithmetic.coding.pkgِِ;

import java.util.*;

public class Compression {

    String Data;
    ArrayList<Node> list = new ArrayList<Node>();
    char[] msgChar;
    ArrayList<Character> characters = new ArrayList<Character>();
    double Value = 0;
    Map<Character, Node> probability;

    public Compression() {
        this.probability = new HashMap();
        Data = "";
        Value = 0;
    }

    public Compression(String d) {
        this.probability = new HashMap();
        Data = d;
        msgChar = Data.toCharArray();
        no_Dublicate();
        calc_fre();
    }

    public void no_Dublicate() {
        msgChar = Data.toCharArray();
        for (int i = 0; i < msgChar.length; i++) {
            if (!(characters.contains(msgChar[i]))) {
                characters.add(msgChar[i]);
            }
        }

    }

    public void calc_fre() {
        double fre = 0, l = 0;
        Node n;
        for (int i = 0; i < characters.size(); i++) {
            double count = 0;
            char checker = characters.get(i);
            for (int x = 0; x < msgChar.length; x++) {
                if (checker == msgChar[x]) {
                    count++;
                }
            }
            fre += count / Data.length();
            n = new Node(checker, l, fre);
            list.add(n);
            System.out.println("><" + checker + " " + l + " " + fre);
            l = fre;
            probability.put(checker, n);
        }
    }

    public void fill_List() {
        Node n;
        for (int t = 0; t < msgChar.length - 1; t++) {
            double U = probability.get(msgChar[t]).Upper, L = probability.get(msgChar[t]).lower, R = U - L;
            double l = L, hi = 0, u = 0;
            for (int x = 0; x < list.size(); x++) {
                Node N = new Node();
                list.get(x).lower = L + R * probability.get(list.get(x).symbol).lower;
                list.get(x).Upper = L + R * probability.get(list.get(x).symbol).Upper;

            }
            list.get(list.size() - 1).Upper = U;
            list.get(0).lower = L;
          //  funprint();
            System.out.println("");
        }
        int c = characters.indexOf(Data.charAt(Data.length() - 1));
        Value = (list.get(c).lower + list.get(c).Upper) / 2.0;

    }

    public void funprint() {

        for (Node n : list) {
            System.out.println(n.symbol + " " + n.lower + " " + n.Upper);
            if (n.symbol.equals(Data.charAt(3))) {
                // Value = (n.lower + n.Upper) / 2.0;
            }
        }
        System.out.println(" Value " + Value);
    }

}
/*  hi = probability.get(characters.get(x));

 u = L + (R * hi);
 n = new Node(characters.get(x), l, u, R);
 l = u;*/
