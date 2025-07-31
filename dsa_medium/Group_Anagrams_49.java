class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
      Map<String,List<String>> map = new HashMap<>();
      for(String word:strs){
        int countArr[] = new int[26];
        for(char c:word.toCharArray()){
            countArr[c-'a']++;

        }
        StringBuilder sb = new StringBuilder();
        for(int k : countArr){
            sb.append(k).append('#');
        }
        String key = sb.toString();
        map.computeIfAbsent(key, k->new ArrayList<>()).add(word);
      } 
      return new ArrayList<>(map.values()); 
    }
}