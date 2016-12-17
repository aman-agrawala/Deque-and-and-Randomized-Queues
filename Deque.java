import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    
    private Node first;
    private  Node last;
    private int size;
    
    private class Node
    {
        Item item;
        Node forward;
        Node backward;
    }
       
    public Deque() // create empty deque
    {
        first = null;
        last = first;
        size = 0;
    }
    
    public boolean isEmpty()
    {
        return (first == null && last == null);
    }
    
    public int size()
    {
        return size;
    }
    
    public void addFirst(Item item)
    {
        Node old = first;
        first = new Node();
        first.item = item;
        first.forward = old;
        first.backward = null;
        size++;
        if(size == 1)
        {
            last = first;
        }
    }
    
    public void addLast(Item item)
    {
        Node old = last;
        last = new Node();
        last.item = item;
        last.backward = old;
        last.forward = null;
        size++;
        if(size == 1)
        {
            first = last;
        }
        else
        {
            old.forward = last;
        }
    }
    
    public Item removeFirst()
    {
        Item value = first.item;
        first = first.forward;
        size--;
        return value;
    }
    
    public Item removeLast()
    {
        Item item = last.item;
        last = last.backward;
        size--;
        return item;
    }
    
    public Iterator<Item> iterator()
    {
        return new DequeIterator();
    }
    
    private class DequeIterator implements Iterator<Item>
    {
        private Node current = first;
        
        public boolean hasNext()
        {
            return current != null;
        }
        
        public void remove()
        {
            /* not supported */
        }
        
        public Item next()
        {
            Item item = current.item;
            current = current.forward;
            return item;
        }
    }
    
    public static void main(String[] args)
    {
        Deque<String> test = new Deque<String>();
        test.addLast("to");
        test.addLast("be");
        test.addLast("or");
        test.addLast("not");
        for(String s: test)
        {
            System.out.print(s);
        }
        //String value = test.removeFirst();
        //System.out.print(value);
    }
}