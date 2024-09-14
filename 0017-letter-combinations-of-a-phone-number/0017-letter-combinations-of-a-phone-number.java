class Solution {
    static String letter[] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};


    public static void helper(List<String> out,String digits,int index,StringBuilder str){
        if(index == digits.length()) {
            out.add(str.toString());
            return;
        }
        int ind = digits.charAt(index)-'0';
        String inp = letter[ind];
        for(int i=0;i<inp.length();i++){
            str.append(inp.charAt(i));
            helper(out,digits,index+1,str);
            str.deleteCharAt(str.length() - 1);
        }

        
    }
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0) return new ArrayList<>();
        List<String> out = new ArrayList<>();
        helper(out,digits,0,new StringBuilder());
        return out;
    }
}