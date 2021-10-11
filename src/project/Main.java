package project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  public static void main(String[] args) throws IOException {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());
      StringTokenizer st2 = new StringTokenizer(br.readLine());
      int forest[] = new int[N];
      int high = 0;
      for(int i = 0 ; st2.hasMoreTokens() ; i++){
          forest[i] = Integer.parseInt(st2.nextToken());
          high = Math.max(high, forest[i]);
      }
      // 입력
      
      int low = 0;
      int maxHeight = 0;
      while(low <= high){
          int mid = (low+high)/2;
          int height = mid;
          long sum = 0;
          for(int i = 0; i < N ; i++){
              sum += Math.max(forest[i] - height, 0);
          }

          if(sum < M)
              high = mid-1;
          else {
              maxHeight = height;
              low = mid+1;
          }
      }

      System.out.println(maxHeight);
  }
}