package dp;

import java.util.*;

public class WordBreak {
    public static void main(String[] args) {
        System.out.println(wordBreak("catskicatcats", new ArrayList<>(Arrays.asList("cats","cat","dog","ski"))));
    }

    static Map<String, Boolean> dpMap;
    public static boolean wordBreak(String s, List<String> wordDict) {
        dpMap = new HashMap<>();
        return findWordBreak(s, wordDict);
    }
    public static boolean findWordBreak(String s, List<String> wordDict) {
        if (s.length() == 0) {
            return true;
        }
        if(dpMap.containsKey(s)) {
            return dpMap.get(s);
        }
        for (int i = 0; i < wordDict.size(); i++) {
            String cloneS = "" + s;
            if (cloneS.startsWith(wordDict.get(i))) {
                cloneS = cloneS.replaceFirst(wordDict.get(i), "");
                if (findWordBreak(cloneS, wordDict)) {
                    dpMap.put(cloneS, true);
                    return true;
                }
            }
        }
        dpMap.put(s, false);
        return false;
    }
}
