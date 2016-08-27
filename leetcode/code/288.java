public class ValidWordAbbr {

    HashSet<String> set;
    HashMap<String, Integer> setab;
    public ValidWordAbbr(String[] dictionary) {
        set = new HashSet<>();
        setab = new HashMap<>();
        for (String str:dictionary) {
            String s = abbre(str);
            setab.put(s, setab.getOrDefault(s, 0)+(set.contains(str) ? 0:1));
            set.add(str);
        }
    }

    public boolean isUnique(String word) {
        return !setab.containsKey(abbre(word)) || (setab.containsKey(abbre(word)) && set.contains(word) && setab.get(abbre(word)) == 1);
    }
    
    String abbre(String str) {
        return str.length() <=2 ? str:str.charAt(0)+""+(str.length()-2)+""+str.charAt(str.length()-1);
    }
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");