class LRUCache {
    int capacity;
    HashMap<Integer,Integer> map;
    LinkedList<Integer> recentlyUsed;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        recentlyUsed = new LinkedList<>();
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
        int index = recentlyUsed.indexOf(key);
        recentlyUsed.remove(index);
        recentlyUsed.add(key);
        return map.get(key);
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.put(key,value);
            int index = recentlyUsed.indexOf(key);
            recentlyUsed.remove(index);
            recentlyUsed.add(key);
        }else {
            if(map.size() >= capacity){
                int leastRecentlyUsedKey = recentlyUsed.removeFirst();
                map.remove(leastRecentlyUsedKey);
            }
            map.put(key,value);
            recentlyUsed.add(key);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */