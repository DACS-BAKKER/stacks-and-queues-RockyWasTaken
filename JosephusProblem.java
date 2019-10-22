import edu.princeton.cs.algs4.StdOut;

//Author: Rocky Xia
public class JosephusProblem {

    public static void main(String[] args){
        StdOut.print(solveProblem(100, 17));
    }

    public static int solveProblem(int total, int skip){
        int counter = 0;
        Queue<Integer> queue = new Queue<Integer>();
        for(int i = 0; i < total; i++){
            queue.enqueue(i);
        }
        while(queue.size() > 1){
            if(counter == skip){
                queue.dequeue();
                counter = 0;
            }
            else {
                queue.enqueue(queue.dequeue());
                counter++;
            }
        }
        return queue.dequeue();
    }
}
