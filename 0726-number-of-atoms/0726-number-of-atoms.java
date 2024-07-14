class Solution {
    public String countOfAtoms(String formula) {
          HashMap<StringBuilder,Integer> elementCount = new HashMap<>();
        Stack<StringBuilder> countRunner = new Stack<>();

        ///loop to find count of atoms
        for(int i=0;i<formula.length();i++){
            char curr = formula.charAt(i);
            StringBuilder inputVal = new StringBuilder();
            inputVal.append(curr);
            if(Character.isUpperCase(curr)){
                while (i+1<formula.length()&&Character.isLowerCase(formula.charAt(i+1))){
                    i++;
                    inputVal.append(formula.charAt(i));
                }
                countRunner.add(inputVal);
                elementCount.put(inputVal,elementCount.getOrDefault(inputVal,0)+1);
            }else if(Character.isDigit(curr)){
                while (i+1<formula.length()&&Character.isDigit(formula.charAt(i+1))){
                    i++;
                    inputVal.append(formula.charAt(i));
                }
                int num = Integer.parseInt(inputVal.toString());
                if(countRunner.peek().toString().equals(")")){
                    Stack<StringBuilder> tempStack = new Stack<>();
                    countRunner.pop();
                    while (!countRunner.peek().toString().equals("(")){
                        StringBuilder popped = countRunner.pop();
                        elementCount.put(popped,elementCount.get(popped)*num);
                        tempStack.push(popped);
                    }
                    countRunner.pop();
                    while (!tempStack.isEmpty()){
                        countRunner.push(tempStack.pop());
                    }
                }else{
                    StringBuilder poppedOne = countRunner.pop();
                    elementCount.put(poppedOne,elementCount.getOrDefault(poppedOne,1)*num);
                    countRunner.push(poppedOne);
                }
            }else{
                countRunner.push(inputVal);
            }
        }
        HashMap<String,Integer> map = new HashMap<>();
        for(StringBuilder key:elementCount.keySet()){
            map.put(key.toString(),map.getOrDefault(key.toString(),0)+elementCount.get(key));
        }
        List<String> elementNameList = new ArrayList<>();
        elementNameList.addAll(map.keySet());
        Collections.sort(elementNameList);
        StringBuilder output = new StringBuilder();
        for(int i=0;i<elementNameList.size();i++){
            String curr = elementNameList.get(i);
            output.append(curr);
            if(map.get(curr)!=1)  output.append(map.get(curr));
        }
        return output.toString();
    }
}