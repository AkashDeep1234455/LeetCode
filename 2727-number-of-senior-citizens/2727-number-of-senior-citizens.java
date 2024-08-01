class Solution {
    public int countSeniors(String[] details) {
        int output = 0;
        int n = details.length;
        for(int i=0;i<n;i++){
            String curr = details[i];
            StringBuilder c = new StringBuilder();
            for(int j=11;j<13;j++){
                c.append(curr.charAt(j));
            }
            int age = Integer.parseInt(c.toString());
            if(age>60) output++;
        }
        return output;
    }
}