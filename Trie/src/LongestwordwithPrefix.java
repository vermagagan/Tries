public class LongestwordwithPrefix
{
    static class Node
    {
        Node [] children = new Node[26];
        Boolean eow = false;

        public Node()
        {
            for(int i=0; i<26; i++)
                children[i] = null;
        }
    }
    public static Node root=new Node();
    public static String ans="";

    public static void insert(String word)
    {

        Node curr=root;
        int level;
        for(level = 0;level<word.length()-1; level++)
        {
            int idx = (int) word.charAt(level)-'a';
            if(curr.children[idx] == null)
                curr.children[idx] = new Node();
            
            curr = curr.children[idx];
        }
        curr.eow = true;

    }
    public static Boolean search(String word)
    {

        Node curr = root;
        for(int level = 0; level<word.length(); level++)
        {
            int idx = (int)word.charAt(level)-'a';
            if(curr.children[idx] == null)
                return false;
            
            curr = curr.children[idx];
        }
        return curr.eow == true;

    }

    public static void longestWord(Node root, StringBuilder st)
    {
        if(root == null)
            return;

        for(int i=0; i<26; i++)
        {
            if(root.children[i] != null && root.children[i].eow == true)
            {
                char ch=(char) (i+'a');

                st.append(ch);

                if(st.length() > ans.length())
                    ans = st.toString();

                longestWord(root.children[i], st);
                st.deleteCharAt(st.length()-1);
            }
        }
    }

    public static void main(String[] args)
    {
        String words[] = {"a", "banana", "ap", "app", "app1", "apply", "apple"};

        for(int i=0; i<words.length; i++)
            insert(words[i]);

        longestWord(root, new StringBuilder(""));
        System.out.println(ans);
    }
}
