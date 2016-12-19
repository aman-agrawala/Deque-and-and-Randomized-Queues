import java.util.Iterator;
import java.util.NoSuchElementException;
import java.lang.NullPointerException;
import java.lang.UnsupportedOperationException;


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
        return (size == 0);
    }
    
    public int size()
    {
        return size;
    }
    
    public void addFirst(Item item)
    {
        if(item == null)
        {
            throw new NullPointerException();
        }
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
        else
        {
            old.backward = first;
        }
    }
    
    public void addLast(Item item)
    {
        if(item == null)
        {
            throw new NullPointerException();
        }
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
        if(size() == 0)
        {
            throw new NoSuchElementException();
        }
        Item value = first.item;
        first = first.forward;
        if(first != null)
        {
            first.backward = null;
        }
        size--;
        if(size() == 0)
        {
            last = null;
        }
        return value;
    }
    
    public Item removeLast()
    {
        if(size() == 0)
        {
            throw new NoSuchElementException();
        }
        Item item = last.item;
        last = last.backward;
        if(last != null)
        {
            last.forward = null;   
        }
        size--;
        if(size() == 0)
        {
            first = null;
        }
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
            throw new UnsupportedOperationException();
        }
        
        public Item next()
        {
            try
            {
                Node attempt = current.forward;
            }
            catch(NullPointerException e)
            {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.forward;
            return item;
        }
    }
    
    public static void main(String[] args)
    {
        Deque<String> test = new Deque<String>();
        test.addFirst("to");
        test.addFirst("be");
        test.removeLast();
        test.removeLast();
        test.removeLast();
        
//        test.addLast("not");
//        for(String s: test)
//        {
//            System.out.print(s);
//        }
//        Iterator<String> i = test.iterator();
//        while (i.hasNext())
//        {
//            String s = i.next();
//            StdOut.println(s);
//        }
//        i.next();
        //String value = test.removeFirst();
        //System.out.print(value);
        
//        Deque<Integer> test10 = new Deque<Integer>();
//        test10.addFirst(1);
//        test10.addLast(2);
//        test10.addFirst(3);
//        test10.addFirst(4);
//        test10.removeFirst();
//        test10.addLast(6);
//        test10.removeFirst();
//        test10.addFirst(8);
//        test10.removeLast();
//        for(Integer s: test10)
//        {
//            System.out.print(s);
//        }
    }
}