class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> map1= new HashMap<>();
       HashMap<Character,Character> map2 = new HashMap<>();
       if(s.length()!=t.length()) return false;
       for(int i=0;i<s.length();i++){
           char schar = s.charAt(i);
           char tchar = t.charAt(i);
           if(map1.containsKey(schar)){
               if(map1.get(schar)!=tchar) return false;
           }else{
               map1.put(schar,tchar);
           }
           if(map2.containsKey(tchar)){
               if(map2.get(tchar)!=schar) return false;
           }else{
               map2.put(tchar,schar);
           }
       }
       return true;
    }
}