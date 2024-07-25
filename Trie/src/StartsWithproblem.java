public class StartsWithproblem
{
    static class  Node
    {
        Node [] children = new Node[26];
        Boolean eow = false;
        
        Node()
        {
            for(int i=0; i<26; i++)
                children[i] = null;
            
        }

    }

    public static Node root = new Node();
    public static void insert(String word)
    {

        Node curr = root;
        for(int i=0; i<word.length(); i++)
        {
            int idx = (int) word.charAt(i)-'a';

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
            int idx = (int) word.charAt(i)-'a';
            if(curr.children[idx] == null)
                return false;
            

            curr = curr.children[idx];
        }

        return curr.eow == true;
    }

    public static Boolean startsWith(String key)
    {
        Node curr = root;
        for(int i=0; i<key.length(); i++)
        {
            int idx = (int) key.charAt(i)-'a';

            if(curr.children[idx] == null)
                return false;

            curr = curr.children[idx];
        }
        return true;
    }

    public static void main(String[] args)
    {
        String words[] = {"apple", "app", "mango", "man", "woman"};
        String prefix = "ap", prefix2 = "moon";

        for(int i=0; i<words.length; i++)
            insert(words[i]);

        System.out.println(startsWith(prefix));
        System.out.println(startsWith(prefix2));
    }

}
