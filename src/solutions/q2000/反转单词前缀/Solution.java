package solutions.q2000.反转单词前缀;

public class Solution {
    public String reversePrefix(String word, char ch) {
        int i = word.indexOf(ch);
        if(i<0){
            return word;
        }
        StringBuilder sb = new StringBuilder(word.substring(0, i + 1));
        sb.reverse();
        if(i+1 == word.length()){
            return sb.toString();
        }
        return sb.append(word.substring(i+1)).toString();

    }
}
