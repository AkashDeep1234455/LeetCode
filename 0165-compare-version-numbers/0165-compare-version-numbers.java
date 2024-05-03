class Solution {
    public int compareVersion(String version1, String version2) {
        int pointer1 = 0;
        int pointer2= 0;
        StringBuilder first = new StringBuilder();
        StringBuilder second = new StringBuilder();
        boolean firtstTime = false;
        boolean secondTime  = false;
        while (pointer1<version1.length()+1||pointer2<version2.length()+1) {
            char one='\0',two='\0';
            if (pointer1<version1.length()) one= version1.charAt(pointer1);
            if(pointer2<version2.length()) two = version2.charAt(pointer2);
            if(one=='.'||pointer1>=version1.length()) firtstTime = true;
            if(two=='.'||pointer2>=version2.length()) secondTime = true;
            if(!firtstTime) {
                first.append(one);
                pointer1++;
            }
            if(!secondTime) {
                second.append(two);
                pointer2++;
            }
            if(firtstTime&&secondTime) {
                int firstInt = Integer.parseInt(first.toString());
                int secondInt = Integer.parseInt(second.toString());
                if (firstInt > secondInt) return 1;
                if (secondInt > firstInt) return -1;
                firtstTime = false;
                secondTime = false;
                if(pointer1<version1.length()) {
                    first = new StringBuilder();
                }
                if(pointer1>=version1.length()) {
                    first =new StringBuilder();
                    first.append('0');
                }
                if(pointer2>=version2.length()) {
                    second =new StringBuilder();
                    second.append('0');
                }
                if(pointer2<version2.length()) {
                    second = new StringBuilder();
                }
                pointer1++;
                pointer2++;
            }

        }
        return 0;
    }
}