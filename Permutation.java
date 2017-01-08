import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.NoSuchElementException;

public class Permutation 
{
    public static void main(String[] args)
    {
        int N = Integer.parseInt(args[0]);
        RandomizedQueue<String> sub = new RandomizedQueue<String>();
   
        try
        {
            String values = StdIn.readString();
            while(values != null)
            {
                sub.enqueue(values);
                values = StdIn.readString();
            }
        }
        catch(NoSuchElementException e)
        {
            
        }
        
        while(N>0)
        {
            N--;
            StdOut.println(sub.dequeue());
        }
    }
}