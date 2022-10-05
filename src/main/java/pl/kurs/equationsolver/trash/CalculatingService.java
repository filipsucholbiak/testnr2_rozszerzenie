package pl.kurs.equationsolver.trash;

public class CalculatingService {

//    public static List<String> infixToPostfixConvert(String input) {
//
//        int priority = 0;
//        String postfixBuffer = "";
//        Stack<Character> stack = new Stack<Character>();
//        List<String> postfixArray = new ArrayList<String>();
//
//        for (int i = 0; i < input.length(); i++) {
//            char ch = input.charAt(i);
//            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
//
//                if (postfixBuffer.length() > 0) {
//                    postfixArray.add(postfixBuffer);
//                }
//                postfixBuffer = "";
//                if (stack.size() <= 0)
//                    stack.push(ch);
//                else {
//                    Character chTop = (Character) stack.peek();
//                    if (chTop == '*' || chTop == '/')
//                        priority = 1;
//                    else
//                        priority = 0;
//                    if (priority == 1) {
//                        if (ch == '+' || ch == '-') {
//                            postfixArray.add(String.valueOf(stack.pop()));
//                            i--;
//                        } else { // Same
//                            postfixArray.add(String.valueOf(stack.pop()));
//                            i--;
//                        }
//                    } else {
//                        if (ch == '+' || ch == '-') {
//                            postfixArray.add(String.valueOf(stack.pop()));
//                            stack.push(ch);
//                        } else
//                            stack.push(ch);
//                    }
//                }
//            } else {
//                postfixBuffer += ch;
//            }
//        }
//        postfixArray.add(postfixBuffer);
//        int len = stack.size();
//        for (int j = 0; j < len; j++)
//            postfixArray.add(stack.pop().toString());
//
//        return postfixArray;
//    }
//
//    public void calculate(Calculator cal, List<String> postFix) throws InvalidEquationFormatException, UnknownOperatorException {
//
//        Stack<BigDecimal> stack = new Stack<BigDecimal>();
//
//        for ( int i = 0; i < postFix.size(); i++ ) {
//
//            String next = postFix.get(i);
//
//            if (next.equals("+") || next.equals("-") || next.equals("*")
//                    || next.equals("/")) {
////                SolvingEvent solvingEvent = new SolvingEvent(
////                        Timestamp.from(Instant.now()),
////                        next.charAt(0),
////                        stack.pop(),
////                        stack.pop(),
////                        cal);
////                solvingEventSaveExecutorService.submitAndExecute(
////                        new SolvingEventSaverRunnable(solvingEventService ,solvingEvent)
////                );
//
//                Invoker invoker = new Invoker();
//                invoker.compute(solvingEvent);
//                stack.push(cal.getCurrent());
//            } else if ( false ){
//
//            }
//            else
//            {
//                stack.push(new BigDecimal(next.trim()));
//            }
//        }
//    }

    //  ----------------

//    SolvingEvent solvingEvent = new SolvingEvent(Timestamp.from(Instant.now()),expression);
//    // Create operandStack to store operands
//    Stack<Integer> operandStack = new Stack<>();
//        solvingEventSaveExecutorService.submitAndExecute(
//                new SolvingEventSaverRunnable(solvingEventService ,solvingEvent)
//        );
//
//    // Create operatorStack to store operators
//    Stack<Character> operatorStack = new Stack<>();
//
//    // Insert blanks around (, ), +, -, /, and *
//    expression = insertBlanks(expression);
//
//    // Extract operands and operators
//    String[] tokens = expression.split(" ");
//
//    // Phase 1: Scan tokens
//        for (String token: tokens) {
//        if (token.length() == 0) // Blank space
//            continue; // Back to the for loop to extract the next token
//        else if (token.charAt(0) == '+' || token.charAt(0) == '-') {
//            // Process all +, -, *, / in the top of the operator stack
//            while (!operatorStack.isEmpty() &&
//                    (operatorStack.peek() == '+' ||
//                            operatorStack.peek() == '-' ||
//                            operatorStack.peek() == '*' ||
//                            operatorStack.peek() == '/')) {
//                processAnOperator(operandStack, operatorStack);
//            }
//
//            // Push the + or - operator into the operator stack
//            operatorStack.push(token.charAt(0));
//        }
//        else if (token.charAt(0) == '*' || token.charAt(0) == '/') {
//            // Process all *, / in the top of the operator stack
//            while (!operatorStack.isEmpty() &&
//                    (operatorStack.peek() == '*' ||
//                            operatorStack.peek() == '/')) {
//                processAnOperator(operandStack, operatorStack);
//            }
//
//            // Push the * or / operator into the operator stack
//            operatorStack.push(token.charAt(0));
//        }
//        else if (token.trim().charAt(0) == '(') {
//            operatorStack.push('('); // Push '(' to stack
//        }
//        else if (token.trim().charAt(0) == ')') {
//            // Process all the operators in the stack until seeing '('
//            while (operatorStack.peek() != '(') {
//                processAnOperator(operandStack, operatorStack);
//            }
//
//            operatorStack.pop(); // Pop the '(' symbol from the stack
//        }
//        else { // An operand scanned
//            // Push an operand to the stack
//            operandStack.push(Integer.valueOf(token));
//        }
//    }
//
//    // Phase 2: process all the remaining operators in the stack
//        while (!operatorStack.isEmpty()) {
//        processAnOperator(operandStack, operatorStack);
//    }
//
//    // Return the result
//        return operandStack.pop();
//
//}
//
//    /** Process one operator: Take an operator from operatorStack and
//     *  apply it on the operands in the operandStack */
//    public static void processAnOperator(
//            Stack<Integer> operandStack, Stack<Character> operatorStack) {
//        char op = operatorStack.pop();
//        int op1 = operandStack.pop();
//        int op2 = operandStack.pop();
//        if (op == '+')
//            operandStack.push(op2 + op1);
//        else if (op == '-')
//            operandStack.push(op2 - op1);
//        else if (op == '*')
//            operandStack.push(op2 * op1);
//        else if (op == '/')
//            operandStack.push(op2 / op1);
//    }
//
//    public static String insertBlanks(String s) {
//        String result = "";
//
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == '(' || s.charAt(i) == ')' ||
//                    s.charAt(i) == '+' || s.charAt(i) == '-' ||
//                    s.charAt(i) == '*' || s.charAt(i) == '/')
//                result += " " + s.charAt(i) + " ";
//            else
//                result += s.charAt(i);
//        }
//
//        return result;
//    }
}
