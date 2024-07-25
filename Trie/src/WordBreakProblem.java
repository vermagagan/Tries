public class WordBreakProblem
{
    static class Node
    {
        Node [] children= new Node[26];
        Boolean eow = false;

        public Node()
        {
            for(int i=0; i<26; i++)
                children[i] = null;
        }
        
    }
    public static Node root=new Node();

    public static void insert(String word)
    {
        Node curr=root;

        for(int level=0; level<word.length(); level++)
        {
            int idx = (int)word.charAt(level)-'a';
            if(curr.children[idx] == null)
                curr.children[idx] = new Node();

            curr = curr.children[idx];
        }
        curr.eow = true;
    }
    public static Boolean search(String word)
    {
        Node curr = root;
        for(int i=0; i<word.length(); i++)
        {
            int idx = (int)word.charAt(i)-'a';
            if(curr.children[idx] == null)
                return false;
            
            curr = curr.children[idx];
        }
        return curr.eow == true;
    }
    public static Boolean wordBreak(String key)
    {
        if(key.length() == 0)
            return true;

        for(int i=1; i<=key.length(); i++)
        {
            if(search(key.substring(0, i) )&& wordBreak(key.substring(i)))
                return true;
        }
        return false;
    }

    public static void main(String[] args)
    {
        String dict[] = {"i", "like", "sam", "samsung", "mobile", "ice"};
        String key = "ilikesam";

        //Creating trie for dictionary
        for(int i=0; i<dict.length; i++)
            insert(dict[i]);

        System.out.println(wordBreak(key));
    }
}
