package arithmetic.coding.pkgِِ;

import java.util.*;

public class Decompression {
    
    double Value = 0;
    int length = 0;
    Map<Character, Node> probability;
    ArrayList<Node> list = new ArrayList<Node>();
    
    public Decompression(Map<Character, Node> probability, int value, int length) {
        this.probability = probability;
        this.Value = value;
        this.length = length;
        for (Map.Entry<Character, Node> entry : probability.entrySet()) {
            Character key = entry.getKey();
            Node v = entry.getValue();
            list.add(v);
        }
    }
    
    public void decomprission() {
        double Code=Value;
        double L=0,U=0,R=0;
        for (int i = 0; i < length; i++) {
            
            int t = 0;
            
            for (t = 0; t < list.size(); t++) {
                if (list.get(t).lower <= Code && list.get(t).Upper >= Code) {
                    System.out.println(list.get(t).symbol);
                   Code = (Code-list.get(t).lower)/ (list.get(t).Upper - list.get(t).lower);
                   L=list.get(t).lower;
                   U=list.get(t).Upper;
                   R=U-L;
                    break;
                }
            } 
             for (int x = 0; x < list.size(); x++) {
                 list.get(x).lower = L + R * probability.get(list.get(x).symbol).lower;
                list.get(x).Upper = L + R * probability.get(list.get(x).symbol).Upper;

            }
            list.get(list.size() - 1).Upper = U;
            list.get(0).lower = L;
        }
    }
}
