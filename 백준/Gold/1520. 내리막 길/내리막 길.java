import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
    M*N 지도
    상하좌우 이동 가능
    현재 칸보다 낮은 지점으로만 이동 (같은 높이도 안됨)
    
 */
public class Main {
    static int[][] map, dp;
    static int M,N;
    static int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        dp = new int[M][N];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        dfs(0,0);
        System.out.println(dp[0][0]);
    }

    static int dfs(int x, int y){
        if(x==M-1 && y==N-1){ // 도착
            return 1;
        }
        if(dp[x][y] != -1) {
            return dp[x][y];
        }
        dp[x][y] = 0;
        for(int i=0; i<4; i++){
            int nx = x + deltas[i][0];
            int ny = y + deltas[i][1];
            if(nx>=0 && nx<M && ny>=0 && ny<N){
                if(map[x][y] > map[nx][ny]){
                    dp[x][y] += dfs(nx,ny);
                }
            }
        }
        return dp[x][y];
    }
}