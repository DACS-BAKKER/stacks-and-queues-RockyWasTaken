import edu.princeton.cs.algs4.StdOut;

//Author: Rocky Xia
public class LinkedList<Item> {

    private int size = 0;
    private Node<Item> start;

    public LinkedList(){
        this.start = null;
    }

    public void add(Item item){
        if(start == null){
            start = new Node<Item>(item);
        }
        else {
            Node<Item> temp = start;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = new Node<Item>(item);
        }
        size++;
    }

    public void insert(int index, Item item){
        Node<Item> temp = start;
        if(index == 0){
            start = new Node<Item>(item);
            start.next = temp;
        }
        else {
            int counter = 0;
            while(temp != null) {
                if(counter == index - 1){
                    Node<Item> anotherTemp = temp.next;
                    temp.next = new Node<Item>(item);
                    temp.next.next = anotherTemp;
                    counter++;
                }
                else {
                    temp = temp.next;
                    counter++;
                }
            }
        }
        size++;
    }

    public void remove(int index){
        Node<Item> temp = start;
        int counter = 0;
        while(temp.next != null){
            if(counter == index - 1){
                temp.next = temp.next.next;
                counter++;
            }
            else {
                temp = temp.next;
                counter++;
            }
        }
        size--;
    }

    public boolean contains(Item item){
        if(start.stuff == item){
            return true;
        }
        else {
            Node<Item> temp = start;
            while(temp.next != null){
                if(temp.stuff == item){
                    return true;
                }
                else {
                    temp = temp.next;
                }
            }
        }
        return false;
    }

    public int size(){
        return size;
    }

    public void reverseIterative(){
        Node newStart = start;
        while(newStart.next != null){
            newStart = newStart.next;
        }
        for(int i = 0; i < size() - 1; i++){
            Node end = start;
            while(end.next != null){
                end = end.next;
            }
            Node previous = start;
            while(previous.next.next != null){
                previous = previous.next;
            }
            end.next = previous;
            end = previous;
            previous.next = null;
        }
        start = newStart;
    }

    public void print(){
        Node<Item> temp = start;
        while(temp.next != null){
            StdOut.print(temp.stuff.toString() + " ");
            temp = temp.next;
        }
        StdOut.print(temp.stuff.toString() + " ");
        StdOut.print("\n");
    }

    private class Node<Item> {

        private Item stuff;
        private Node<Item> next;

        public Node(Item stuff){
            this.stuff = stuff;
            this.next = null;
        }
    }

}
