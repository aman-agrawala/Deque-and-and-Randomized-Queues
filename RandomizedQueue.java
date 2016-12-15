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
        if N == q.length();
        {
            resize(2*q.length());
        }
        s[N++] = item;
    }
    
    public Item dequeue()
    {
        int rand = StdRandom.uniform(N);
        Item value = q[--N];
        q[N] = null;
        if(N > 0 && N == q.length/4)
        {
            resize(s.length/2);
        }
        return item;
    }
    
    public Item sample()
    {
        int rand = StdRandom.uniform(N);
        Item value = q[N-1];
        if(N > 0 && N == q.length/4)
        {
            resize(s.length/2);
        }
        return item;
    }
    
    public Iterator<Item> iterator()
    {
        return new RandomIterator();
    }
    
    private class RandomIterator<Item> implements Iterator<Item>
    {
        private int currLoc = 0;
        private int covered = 0;
        
        public boolean hasNext()
        {
            return covered != q.length();
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
            return Item;
        }
    }
}