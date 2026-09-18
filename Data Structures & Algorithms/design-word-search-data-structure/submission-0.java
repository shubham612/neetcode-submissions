class WordDictionary {
    class TrieNode{
        boolean isEnd = false;
        TrieNode[] children = new TrieNode[26];
    }
    private TrieNode root;
    public WordDictionary() {
       root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for(int i=0;i<word.length();i++){
            int index = word.charAt(i)-'a';
            if(curr.children[index]==null){
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
       return dfs(word,0,root);
    }

    private boolean dfs(String word,int index,TrieNode node){
        if(node==null){
            return false;
        }

        if(index==word.length()){
            return node.isEnd;
        }

        char ch = word.charAt(index);

        if(ch=='.'){
            for(int i=0;i<26;i++){
                if(dfs(word,index+1,node.children[i])){
                    return true;
                }
            }
            return false;
        }else{
            return dfs(word,index+1,node.children[ch-'a']);
        }
    }
}
