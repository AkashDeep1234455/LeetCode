class Solution {
    public List<String> commonChars(String[] words) {
        ArrayList<Character> list = new ArrayList<>();
        for(int i=0;i<words[0].length();i++){
            list.add(words[0].charAt(i));
        }
        for(int i=1;i<words.length;i++){
            String curr = words[i];
            ArrayList<Character> newStack = new ArrayList<>();
            for(int j=0;j<curr.length();j++){
                char c = curr.charAt(j);
                if(list.contains(c)){
                    newStack.add(c);
                    int index = list.indexOf(c);
                    list.remove(index);
                }
            }
            list= new ArrayList<>();
           for(Character element:newStack){
               list.add(element);
           }
        }
        List<String> output = new ArrayList<>();
        for(int i=0;i<list.size();i++){
            char c = list.get(i);
            String curr= ""+c;
            output.add(curr);
        }
        return output;
    }
}