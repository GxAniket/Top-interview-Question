class Solution {
    public int calPoints(String[] ops) {

        Stack<Integer> stack = new Stack<>();

        for (String i : ops) {

            if (i.equals("+")) {
                int last = stack.pop();
                int newScore = last + stack.peek();
                stack.push(last);
                stack.push(newScore);
            }
            else if (i.equals("D")) {
                stack.push(2 * stack.peek());
            }
            else if (i.equals("C")) {
                stack.pop();
            }
            else {
                stack.push(Integer.parseInt(i));
            }
        }

        int sum = 0;
        for (int score : stack) {
            sum += score;
        }

        return sum;
    }
}
