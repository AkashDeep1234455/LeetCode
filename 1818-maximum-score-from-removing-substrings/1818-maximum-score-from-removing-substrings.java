class Solution {
    public int maximumGain(String s, int x, int y) {
         ///x refers to score gained by removing ab and y refers to score gained by removing ba
        int xFirst = 0;
        int yFirst = 0;

        //Stack for handling string removal
        Stack<Character> stringStore = new Stack<>();
        //we gonna remove ab first and then ba
        //ab
        for(int i=0;i<s.length();i++){
            char curr = s.charAt(i);
            if(stringStore.isEmpty()) stringStore.push(curr);
            else if(curr=='b'&&stringStore.peek()=='a'){
                xFirst+=x;
                stringStore.pop();
            }else stringStore.push(curr);
        }
        StringBuilder newString  = new StringBuilder();
        while (!stringStore.isEmpty()) newString.append(stringStore.pop());
        newString = newString.reverse();
        for(int i=0;i<newString.length();i++){
            char curr = newString.charAt(i);
            if(stringStore.isEmpty()) stringStore.push(curr);
            else if(curr=='a'&&stringStore.peek()=='b'){
                xFirst+=y;
                stringStore.pop();
            }else stringStore.push(curr);
        }

        //now we gonna remove ba first and then ab
        stringStore = new Stack<>();
        for(int i=0;i<s.length();i++){
            char curr = s.charAt(i);
            if(stringStore.isEmpty()) stringStore.push(curr);
            else if(curr=='a'&&stringStore.peek()=='b'){
                yFirst+=y;
                stringStore.pop();
            }else stringStore.push(curr);
        }
        newString  = new StringBuilder();
        while (!stringStore.isEmpty()) newString.append(stringStore.pop());
        newString = newString.reverse();
        for(int i=0;i<newString.length();i++){
            char curr = newString.charAt(i);
            if(stringStore.isEmpty()) stringStore.push(curr);
            else if(curr=='b'&&stringStore.peek()=='a'){
                yFirst+=x;
                stringStore.pop();
            }else stringStore.push(curr);
        }
        return Math.max(xFirst,yFirst);
    }
}