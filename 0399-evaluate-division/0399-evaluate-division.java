class Solution {
    private HashSet<String> valid = new HashSet<>();
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String,HashMap<String,Double>> graph = new HashMap<>();
        int index = 0;
        for(List<String> equation:equations){
            String first = equation.get(0);
            String second = equation.get(1);
            valid.add(first);
            valid.add(second);
            graph.computeIfAbsent(first, k -> new HashMap<>()).put(second, values[index]);
            graph.computeIfAbsent(second, k -> new HashMap<>()).put(first, 1.0 / values[index]);

            index++;
        }
        double[] output = new double[queries.size()];
        int index2 = 0;
        for(List<String> query:queries){
            String first = query.get(0);
            String second = query.get(1);
            if(!valid.contains(first)||!valid.contains(second)){
                output[index2] = -1.0;
                 index2++;
                continue;
            }
            HashSet<String> visited = new HashSet<>();
            double result = helper(first,second,graph,visited);
            output[index2] = result;
            index2++;
        }

        return output;
    }

    public double helper(String first,String second, HashMap<String,HashMap<String,Double>> graph,HashSet<String>visited){
        if(first.equals(second)) return 1.0;
        visited.add(first);
        HashMap<String,Double> map = graph.get(first);
        if(map==null) return -1.0;
        for(String key:map.keySet()){
            if(!visited.contains(key)){
            double result = helper(key,second,graph,visited);
            if(result!=-1.0){
                return map.get(key)*result;
            }
            }
        }
        return -1.0;
    }
}