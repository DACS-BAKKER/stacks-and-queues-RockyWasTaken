import edu.princeton.cs.algs4.StdOut;

//Author: Rocky Xia
public class TwoStackProblem {

    public static void main(String args[]){
        StdOut.print(solveTwoStack("((1+2)*5)"));
    }


    public static double solveTwoStack(String operation){
        int start;
        Stack<Double> operand = new Stack<Double>();
        Stack<Character> operator = new Stack<Character>();
        for(int i = 0; i < operation.length(); i++){
            if(operation.charAt(i) == ')'){
                char sign = operator.pop();
                double result;
                if(sign == '+'){
                    result = operand.pop() + operand.pop();
                    operand.push(result);
                }
                else if(sign == '-'){
                    double second = operand.pop();
                    result = operand.pop() - second;
                    operand.push(result);
                }
                else if(sign == '*'){
                    result = operand.pop() * operand.pop();
                    operand.push(result);
                }
                else if(sign == '/'){
                    double second = operand.pop();
                    result = operand.pop() / second;
                    operand.push(result);
                }
            }
            else if(operation.charAt(i) == '+' || operation.charAt(i) == '-' || operation.charAt(i) == '*' || operation.charAt(i) == '/'){
                operator.push(operation.charAt(i));
            }
            else if(operation.charAt(i) != '('){
                start = i;
                if(operation.charAt(i + 1) == '+' || operation.charAt(i + 1) == '-' || operation.charAt(i + 1) == '*' || operation.charAt(i + 1) == '/' || operation.charAt(i + 1) == ')'){
                    operand.push(Double.valueOf(operation.substring(start, i + 1)));
                }
            }
        }
        return operand.pop();
    }

}
