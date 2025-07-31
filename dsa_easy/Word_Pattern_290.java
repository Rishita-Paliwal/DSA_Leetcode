class Solution {
    public boolean wordPattern(String pattern, String s) {
        String strs[]= s.split(" ");
        if(strs.length!= pattern.length()){
            return false;
        }
        Map<Character,String> map1 = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();
        for(int i=0;i<pattern.length();i++){
            char singleChar = pattern.charAt(i);
            String word = strs[i];
            if(map1.containsKey(singleChar)){
                String mapWord= map1.get(singleChar);
                if(!mapWord.equals(word)){
                    return false;
                }
            }
            else{
                map1.put(singleChar,word);

            }
            if(map2.containsKey(word)){
                Character pt = map2.get(word);
                if(!pt.equals(singleChar)){
                    return false;
                }
            }
            else{
                map2.put(word, singleChar);
            }
        }
        return true;
    }
}