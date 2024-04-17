/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
     static char alphabet[] = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    public static void LeafNodes(TreeNode root,ArrayList<TreeNode>leafnodes){
        if(root==null) return;
        if(root.left==null&&root.right==null){
            leafnodes.add(root);
            return;
        }
        LeafNodes(root.left,leafnodes);
        LeafNodes(root.right,leafnodes);
    }

    public static boolean leafToRootPath(TreeNode root,TreeNode leaf,ArrayList<Integer>path){
        if(root==null) return false ;
        if(root==leaf){
            path.add(root.val);
            return true;
        }
        boolean left= leafToRootPath(root.left,leaf,path);
        boolean right =leafToRootPath(root.right,leaf,path);
        if(left||right){
            path.add(root.val);
            return true;
        }
        return false;
    }
    public static boolean shorterprefixCheck(String main,String check){
          HashMap<Character,Boolean> presence = new HashMap<>();
        for(int i=0;i<check.length();i++){
            presence.put(check.charAt(i),true);
        }
        for(int i=0;i<main.length();i++){
            if(!presence.containsKey(main.charAt(i))) return false;
        }
        ///lexographic check
        for(int i=0;i<check.length();i++){
            char curr = check.charAt(i);
            char mainChar= main.charAt(i);
            if(curr>mainChar) return false;
        }

        return true;
    }

    public static boolean compareIsNewAns(String curr,String newOne){
       int minLength = Math.min(curr.length(), newOne.length());
    for (int i = 0; i < minLength; i++) {
        if (curr.charAt(i) > newOne.charAt(i)) {
            return true;
        }
        if (curr.charAt(i) < newOne.charAt(i)) {
            return false;
        }
        }
    return curr.length() < newOne.length(); 
    }
    public static int findDepth(TreeNode root){
        if(root==null) return 0;
        int depth1 =1+ findDepth(root.left);
        int depth2 = 1+findDepth(root.right);
        return Math.max(depth2,depth1);
    }
    public String smallestFromLeaf(TreeNode root) {
         int depth = findDepth(root);
            ArrayList<TreeNode> leafnodes =new ArrayList<>();
            LeafNodes(root,leafnodes);
            ArrayList<String> largepath= new ArrayList<>();
            int largePathmin = Integer.MAX_VALUE;
            int shortPathMin = Integer.MAX_VALUE;
            ArrayList<String> shortPath = new ArrayList<>();
            for(int i=0;i<leafnodes.size();i++){
                ArrayList<Integer> path = new ArrayList<>();
                leafToRootPath(root,leafnodes.get(i),path);
                StringBuilder pathName = new StringBuilder();
                for(int j=0;j<path.size();j++){
                    pathName.append(alphabet[path.get(j)]);
                }
                if(pathName.length()==depth){
                    if(pathName.charAt(0)<largePathmin) largePathmin = pathName.charAt(0);
                    largepath.add(pathName.toString());
                }
                else{
                    if(pathName.charAt(0)<shortPathMin) shortPathMin = pathName.charAt(0);
                    shortPath.add(pathName.toString());
                }
            }

            if(shortPathMin<largePathmin){
                String currOutput = shortPath.get(0);
                for (int i = 1; i < shortPath.size(); i++) {
                    String newPath = shortPath.get(i);
                    if (compareIsNewAns(currOutput, newPath)) {
                        currOutput = newPath;
                    }
                }
                for (int i = 0; i < shortPath.size(); i++) {
                    if (shorterprefixCheck(currOutput, shortPath.get(i))) {
                        currOutput = shortPath.get(i);
                    }
                }
                return currOutput;
            }else {
                String currOutput = largepath.get(0);
                for (int i = 1; i < largepath.size(); i++) {
                    String newPath = largepath.get(i);
                    if (compareIsNewAns(currOutput, newPath)) {
                        currOutput = newPath;
                    }
                }
                for (int i = 1; i < shortPath.size(); i++) {
                    String newPath = shortPath.get(i);
                    if (compareIsNewAns(currOutput, newPath)) {
                        currOutput = newPath;
                    }
                }
                for (int i = 0; i < shortPath.size(); i++) {
                    if (shorterprefixCheck(currOutput, shortPath.get(i))) {
                        currOutput = shortPath.get(i);
                    }
                }
                return currOutput.toString();
            }
    }
}