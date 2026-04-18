// Given a pattern and a string s, find if s follows the same pattern.

// Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s. Specifically:

// Each letter in pattern maps to exactly one unique word in s.
// Each unique word in s maps to exactly one letter in pattern.
// No two letters map to the same word, and no two words map to the same letter.
 

// Example 1:

// Input: pattern = "abba", s = "dog cat cat dog"

// Output: true

// Explanation:

// The bijection can be established as:

// 'a' maps to "dog".
// 'b' maps to "cat".
// Example 2:

// Input: pattern = "abba", s = "dog cat cat fish"

// Output: false

// Example 3:

// Input: pattern = "aaaa", s = "dog cat cat dog"

// Output: false


//code 
class Solution {
    public boolean wordPattern(String pattern, String s) {

        String[] words = s.split(" ");

        if(pattern.length() != words.length)
            return false;

        HashMap<Character, String> map = new HashMap<>();
        HashMap<String, Character> reverse = new HashMap<>();

        for(int i = 0; i < pattern.length(); i++){

            char ch = pattern.charAt(i);
            String word = words[i];

            if(map.containsKey(ch)){
                if(!map.get(ch).equals(word))
                    return false;
            } 
            else{

                if(reverse.containsKey(word))
                    return false;

                map.put(ch, word);
                reverse.put(word, ch);
            }
        }

        return true;
    }
}

// Even Shorter Interview Trick Solution (Very Popular)

class Solution {
    public boolean wordPattern(String pattern, String s) {

        String[] words = s.split(" ");
        if(pattern.length() != words.length) return false;

        HashMap<Object,Integer> map = new HashMap<>();

        for(Integer i = 0; i < words.length; i++)
            if(map.put(pattern.charAt(i), i) != map.put(words[i], i))
                return false;

        return true;
    }
}
