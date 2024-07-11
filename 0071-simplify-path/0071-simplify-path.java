class Solution {
    public String simplifyPath(String path) {
          Stack<StringBuilder> simplifiedPath = new Stack<>();
        simplifiedPath.push(new StringBuilder("/"));
        StringBuilder input = new StringBuilder();
        for(int i=1;i<path.length();i++){
            char curr = path.charAt(i);
            if(curr=='/'||i==path.length()-1){
                if(curr!='/'&&i==path.length()-1) input.append(curr);
                if(input.length()==0) continue;
                else if(input.toString().equals(".")){
                    input = new StringBuilder();
                }else if(input.toString().equals("..")){
                    input = new StringBuilder();
                    if(simplifiedPath.size()>1) {
                        simplifiedPath.pop();
                        simplifiedPath.pop();
                    }
                }else{
                    simplifiedPath.push(input);
                    simplifiedPath.push(new StringBuilder("/"));
                    input = new StringBuilder();
                }
            }else{
                input.append(curr);
            }
        }
        if(simplifiedPath.size()>1) simplifiedPath.pop();
        input = new StringBuilder();
        while(!simplifiedPath.isEmpty()){
            input.insert(0,simplifiedPath.pop());
        }
        return input.toString();
    }
}