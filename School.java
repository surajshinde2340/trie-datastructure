public class Trie {
    int i;
}

public class School {
    public static class Trie {
        Trie[] node = new Trie[26];
        boolean eow = false;

        public static boolean atte(String ptr) {
            Trie curr = root;
            boolean result = true;
            int i = 0;
            while (i < ptr.length()) {
                int idx = ptr.charAt(i)-'a';
                if (curr.node[idx] != null) {
                    curr = curr.node[idx];
                    if(i==ptr.length()-1){
                       if( curr.eow != true){
                        result = false;
                       }
                    }
                    i++;
                } else if (curr.node[idx] == null) {
                    result = false;
                    break;

                }

            }

            return result ;
        }

        Trie() {
            int i = 0;
            while (i < 26) {
                node[i] = null;

                i++;
            }
        }

    }

    static Trie root = new Trie();

    public static void insert(String str) {
        Trie curr = root;
        int i = 0;
        int c = 0;
        // int idx = str.charAt(i) - 'a';
        while (i < str.length()) {
            int idx = str.charAt(i) - 'a';
            if (curr.node[idx] == null) {
                curr.node[idx] = new Trie();
                curr = curr.node[idx];

                i++;
            } else if (curr.node[idx] != null) {
                curr = curr.node[idx];
                i++;
            }

        }
        curr.eow = true;

    }

    public static void print2(){
    int rank= 0, level = 0; int i = 0;
    Trie curr = root;
    while(curr.eow==false){
    if(curr.node[i]!=null){

    System.out.println("char is "+(char)(i+97)+" rank is "+(i+1)+" level is "
    +(level+1));
    System.out.println();
    curr = curr.node[i];
    level++;
    i= 0;
    }else{

    i++;
    if(i>26){
    break;
    }
    }

    }

    }
    public static String ans = " ";

    public static void callPrint() {
        for (int i = 0; i < 26; i++) {
            print(i);
        }
    }

    public static void print(int i) {
        int j = 0;
        Trie prev = root;
        Trie curr = root;
        while (curr.eow == false) {
            if (curr.node[i] != null) {
                ans = ans + (char) (i + 97);
                j = i;
                prev = curr;
                curr = curr.node[i];
                i = 0;
            } else {
                i++;
                if (i >= 26) {
                    System.out.println(" " + ans);
                    ans = " ";
                    break;
                }
            }

        }

    }

    public static void main(String[] args) {
        Trie sp = new Trie();

        insert("surajj");
        insert("pranayjjj");
        insert("lokesh");
        insert("suyash");
        String arr[] = {"surajj","pranayjjj","lokesh","suyash"};
        for(int i = 0; i<4; i++){
           
            if( sp.atte(arr[i])){
                System.out.println("present string "+arr[i]);
            }else{
                System.out.println("String is note present "+arr[i]);
            }
        }
      

        // System.out.println('s'-'a');

    }

}
