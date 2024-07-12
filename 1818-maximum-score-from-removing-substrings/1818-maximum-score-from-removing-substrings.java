class Solution {
    public int maximumGain(String s, int x, int y) {
         if (x < y) {
            int temp = x;
            x = y;
            y = temp;
            s = new StringBuilder(s).reverse().toString();
        }

        // x refers to the score gained by removing "ab" and y refers to the score gained by removing "ba"
        int score = 0;

        // Stack for handling string removal
        Stack<Character> stack = new Stack<>();

        // First pass to remove "ab" or "ba" depending on x and y
        for (char curr : s.toCharArray()) {
            if (!stack.isEmpty() && curr == 'b' && stack.peek() == 'a') {
                score += x;
                stack.pop();
            } else {
                stack.push(curr);
            }
        }

        // Create the new string after removing "ab" or "ba"
        StringBuilder remainingString = new StringBuilder();
        while (!stack.isEmpty()) {
            remainingString.append(stack.pop());
        }
        remainingString.reverse();

        // Clear the stack before the second pass
        stack.clear();

        // Second pass to remove "ba" or "ab" in the remaining string
        for (char curr : remainingString.toString().toCharArray()) {
            if (!stack.isEmpty() && curr == 'a' && stack.peek() == 'b') {
                score += y;
                stack.pop();
            } else {
                stack.push(curr);
            }
        }

        return score;
    }
}