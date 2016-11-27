package arithmetic.coding.pkgِِ;

public class Node {
public Character symbol;
 public double lower;
 public double Upper;
 public double Range;

 public Node() {
 this.symbol = ' ';
 this.lower = 0;
 this.Upper = 0;
 this.Range = 0;
 }

 public Node(Character symbol, double lower, double Upper ) {
 this.symbol = symbol;
 this.lower = lower;
 this.Upper = Upper;
 }
  
}
 
