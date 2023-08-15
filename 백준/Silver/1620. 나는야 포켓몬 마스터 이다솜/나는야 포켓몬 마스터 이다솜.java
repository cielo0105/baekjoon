import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String,String> map = new HashMap<>();
        String name;
        for(int i=1; i<=N; i++){
            name = br.readLine();
            map.put(String.valueOf(i),name);
            map.put(name,String.valueOf(i));
        }
        for(int i=0; i<M; i++){
            sb.append(map.get(br.readLine())).append("\n");
        }
        System.out.println(sb);
    }

}