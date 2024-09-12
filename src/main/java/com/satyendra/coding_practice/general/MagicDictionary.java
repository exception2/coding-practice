package general;

public class MagicDictionary {

    public static void main(String[] args) {
        MagicDictionary magicDictionary = new MagicDictionary();
        magicDictionary.buildDict(new String[]{"hello","hallo","leetcode"});
        System.out.println(magicDictionary.search("hello"));
        System.out.println(magicDictionary.search("hhllo"));
        System.out.println(magicDictionary.search("hell"));
        System.out.println(magicDictionary.search("leetcoded"));
    }
    Trie root = null;
    public MagicDictionary() {
        root = new Trie();
    }

    public void buildDict(String[] dictionary) {
        for(String s : dictionary) {
            Trie node = root;
            for(int i =0 ;i < s.length();i++) {
                int index = s.charAt(i) - 'a';
                if(node.childs[index] == null) {
                    node.childs[index] = new Trie();
                }
                node = node.childs[index];
            }
            node.isLast = true;
        }
    }

    public boolean search(String searchWord) {
        Trie node = root;

        return searchUtil(searchWord, 0, searchWord.length(), node, 0);
    }

    private boolean searchUtil(String s, int index, int n, Trie node, int mismatch) {
        if(index == n) {
            return node.isLast && mismatch == 1;
        } else if(mismatch>=2) {
            return false;
        }
        boolean res = false;
        for(int j = 0 ; j < 26;j++) {
            if(node.childs[j] != null) {
                if(j == s.charAt(index) - 'a') {
                    res |= searchUtil(s, index+1, n, node.childs[j], mismatch);
                } else if(mismatch==0) {
                    res |= searchUtil(s, index+1, n, node.childs[j], mismatch + 1);
                }
            }
        }
        return res;
    }
    //h -> e, f

    static class Trie {
        Trie[] childs;
        boolean isLast;
        Trie() {
            this.childs = new Trie[26];
            this.isLast = false;
        }
    }

}
