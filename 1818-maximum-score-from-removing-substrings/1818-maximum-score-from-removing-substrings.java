class Solution {
    public int maximumGain(String s, int x, int y) {
         ///x refers to score gained by removing ab and y refers to score gained by removing ba
        int xFirst = 0;
        int yFirst = 0;

        //Stack for handling string removal
        //this will handle x first
        Stack<Character> stringStoreX = new Stack<>();
        //this will handle y first
        Stack<Character> stringStoreY = new Stack<>();
        //we gonna remove ab first and then ba
        //ab
        for(int i=0;i<s.length();i++){
            char curr = s.charAt(i);
            ///work for stringStoreX
            if(stringStoreX.isEmpty()) stringStoreX.push(curr);
            else if(curr=='b'&&stringStoreX.peek()=='a'){
                xFirst+=x;
                stringStoreX.pop();
            }else stringStoreX.push(curr);

            ///work for stringStoreY
            if(stringStoreY.isEmpty()) stringStoreY.push(curr);
            else if(curr=='a'&&stringStoreY.peek()=='b'){
                yFirst+=y;
                stringStoreY.pop();
            }else stringStoreY.push(curr);
        }
        StringBuilder newStringX  = new StringBuilder();
        StringBuilder newStringY  = new StringBuilder();
        while (!stringStoreX.isEmpty()) newStringX.append(stringStoreX.pop());
        while (!stringStoreY.isEmpty()) newStringY.append(stringStoreY.pop());
        newStringX = newStringX.reverse();
        newStringY = newStringY.reverse();
        for(int i=0;i<newStringX.length();i++){
            char curr = newStringX.charAt(i);
            if(stringStoreX.isEmpty()) stringStoreX.push(curr);
            else if(curr=='a'&&stringStoreX.peek()=='b'){
                xFirst+=y;
                stringStoreX.pop();
            }else stringStoreX.push(curr);
        }
        for(int i=0;i<newStringY.length();i++){
            char curr = newStringY.charAt(i);
            if(stringStoreY.isEmpty()) stringStoreY.push(curr);
            else if(curr=='b'&&stringStoreY.peek()=='a'){
                yFirst+=x;
                stringStoreY.pop();
            }else stringStoreY.push(curr);
        }
        return Math.max(xFirst,yFirst);
    }
}