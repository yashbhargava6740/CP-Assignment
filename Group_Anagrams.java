
/* 
Empty Input:
Input: []
Output: []

Single Empty String:
Input: [""]
Output: [[""]]

Multiple Empty Strings:
Input: ["", "", ""]
Output: [["", "", ""]]


Single Character Strings:
Input: ["a", "b", "c"]
Output: [["a"], ["b"], ["c"]]

Single Anagram Group:
Input: ["abc", "bca", "cab"]
Output: [["abc", "bca", "cab"]]

Multiple Anagram Groups:
Input: ["eat", "tea", "tan", "ate", "nat", "bat"]
Output: [["eat", "tea", "ate"], ["tan", "nat"], ["bat"]]

Strings with Different Lengths:
Input: ["a", "ab", "ba", "abc", "cab", "bca"]
Output: [["a"], ["ab", "ba"], ["abc", "cab", "bca"]]

Strings with Duplicates:
Input: ["ab", "ba", "ab", "ba"]
Output: [["ab", "ba", "ab", "ba"]]

Large Number of Strings:
Input: [String with 1 character] * 1000
Output: [[All 1000 strings grouped together]]

Strings with Special Characters:
Input: ["a!b", "b!a", "!ab"]
Output: [["a!b", "b!a", "!ab"]] 
*/

/* Given an array of strings strs, group the anagrams together. You can return the answer in any order.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once. */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Group_Anagrams {
    private static String sort(String st) {
        char[] arr = new char[26];
        char[] st_arr = st.toCharArray();
        for(int i = 0; i < st_arr.length; i++) {
            arr[st_arr[i]-'a']++;
        }   
        return String.valueOf(arr);
    }
    private static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> hm = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();
        for(int i = 0; i < strs.length; i++) {
            String sorted = sort(strs[i]);
            if(hm.containsKey(sorted)) hm.get(sorted).add(strs[i]);
            else {
                hm.put(sorted, new ArrayList<>());
                hm.get(sorted).add(strs[i]);
            }
        }
        for (List<String> ele: hm.values()) {
            ans.add(ele);
        }
        return ans; 
    }
        
    public static void main(String[] args) {
        String[] strs = new String[10000];
        for (int i = 0; i < 10000; i++) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < 100; j++) {
            sb.append((char)('a' + (i % 26)));
        }
        strs[i] = sb.toString();
    }
    System.out.println(groupAnagrams(strs));
    }
}

