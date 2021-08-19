import java.util.ArrayList;
import java.util.Scanner;

public class BeautifulPath {

    static ArrayList<Integer> [] graph;
    static int [] letter;
    static int [] visited;
    static int [][] mem; 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("v : ");
        int v = sc.nextInt();

        System.out.print("e : ");
        int e = sc.nextInt();

        System.out.print("s : ");
        String s = sc.next();
        int [] x = new int[e];
        int [] y = new int[e];
        graph = new ArrayList[v+1];
        letter = new int[v+1];
        visited = new int[v+1];
        mem = new int[v+1][26];

        for(int i = 0; i <= v; i++){
            graph[i] = new ArrayList<Integer>();
        }

        System.out.print("x : ");
        for (int i = 0; i < e; i++) {
            x[i] = sc.nextInt();
        }

        System.out.print("y : ");
        for (int i = 0; i < e; i++) {
            y[i] = sc.nextInt();
        }

        for (int i = 0; i < e; i++) {
            int from = x[i];
            int to = y[i];
            graph[from].add(to);
        }

        for (int i = 1; i <= v; i++) {
            letter[i] = s.charAt(i - 1) - 'a';
        }

        for (int i = 1; i <= v; i++) {
            if(visited[i] == 0 && dfs(i)){
                System.out.println("-1");
                System.exit(0);
            }
        }

        int answer = 0;
        for (int i = 0; i <= v; i++) {
            for (int j = 0; j < 26; j++) {
                answer = Math.max(answer, mem[i][j]);
            }
        }

        System.out.println(answer);

        // for (int i = 0; i < letter.length; i++) {
        //     System.out.print(letter[i]);
        // }

        // for (int i = 0; i < x.length; i++) {
        //     System.out.print(x[i] + " -> ");
        //     System.out.println(graph[x[i]]);
        // }

        // System.out.println(graph.length);


    }

    public static boolean dfs(int vertex){
        visited[vertex] = 1;
        for(int to: graph[vertex]){
            if(visited[to] == 1){
                return true;
            }
            if(visited[to] == 0 && dfs(to)){
                return true;
            }
            for (int i = 0; i < 26; i++) {
                mem[vertex][i] = Math.max(mem[vertex][i], mem[to][i]);
            }
        }

        mem[vertex][letter[vertex]]++;
        visited[vertex] = 2;
        return false;

    }
}
