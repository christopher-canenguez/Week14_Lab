import java.util.*; 
import java.util.Scanner; 

public class Problem02 
{
    
    public static void main (String[] args)
    {
        Stack<String> ops = new Stack<String>();
        
        Stack<Double> vals = new Stack<Double>();
        
        Scanner scnr = new Scanner("( ( 1 + sqrt ( 5 ) ) / 2.0 )");
        
        while (scnr.hasNext())
        {
            String s = scnr.next();
            
            if (s.equals("("))
            {
                // Empty
            }
            
            else if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("**") || s.equals("sqrt"))
            {
                ops.push(s);
            }
            
            else if (s.equals(")"))
            {
                String op = ops.pop();
                
                double v = vals.pop();
                
                if (op.equals("+"))
                {
                    v = vals.pop() + v;
                    
                    vals.push(v);
                }
                
                else if (op.equals("-"))
                {
                    v = vals.pop() - v;
                    
                    vals.push(v);
                }
                
                else if (op.equals("*"))
                {
                    v = v * vals.pop();
                    
                    vals.push(v);
                }
                
                else if (op.equals("/"))
                {
                    v = vals.pop() / v;
                    
                    vals.push(v);
                }
                
                else if (op.equals("**"))
                {
                    v = Math.pow(vals.pop(), v);
                    
                    vals.push(v);
                }
                
                else if (op.equals("sqrt"))
                {
                    v = Math.sqrt(v);
                    
                    vals.push(v);
                }
            }
            
            else
            {
                vals.push(Double.parseDouble(s));
            }
        }
        System.out.println(vals.pop());
    }
               
}
