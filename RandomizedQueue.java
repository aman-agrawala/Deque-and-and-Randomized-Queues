import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item>
{
    private Item[] q;
    private int N = 0;
        
    public RandomizedQueue()
    {
        q = (Item[]) new Object[10];
    }
    
    public boolean isEmpty()
    {
        return N == 0;
    }
    
    public int size()
    {
        return N;
    }
    
    private void resize(int capacity)
    {
        Item[] copy = (Item[]) new Object[capacity];
        for(int i = 0; i < N; i++)
        {
            copy[i] = q[i];
        }
        q = copy;
    }
    
    public void enqueue(Item item)
    {
        if( N == q.length)
        {
            resize(2*q.length);
        }
        q[N++] = item;
    }
    
    public Item dequeue()
    {
        int rand = StdRandom.uniform(N);
        Item value = q[rand];
        q[rand] = null;
        N--;
        if(N > 0 && N == q.length/4)
        {
            resize(q.length/2);
        }
        return value;
    }
    
    public Item sample()
    {
        int rand = StdRandom.uniform(N);
        Item value = q[rand];
        if(N > 0 && N == q.length/4)
        {
            resize(q.length/2);
        }
        return value;
    }
    
    public Iterator<Item> iterator()
    {
        return new RandomIterator();
    }
    
    private class RandomIterator implements Iterator<Item>
    {
        private int currLoc = 0;
        private int covered = 0;
        
        public boolean hasNext()
        {
            return covered != q.length;
        }
        
        public void remove()
        {
            /* not supported */
        }
        
        public Item next()
        {
            currLoc = StdRandom.uniform(N);
            Item currentItem = q[currLoc];
            covered++;
            return currentItem;
        }
    }
    
    public static void main(String[] args)
    {
        RandomizedQueue<String> test = new RandomizedQueue<String>();
        test.enqueue("to");
        test.enqueue("be");
        test.enqueue("or");
        test.enqueue("not");
        System.out.print(test.sample());
    }
}