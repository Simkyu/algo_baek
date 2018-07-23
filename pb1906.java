package algo_baek;
import java.util.Scanner;

// 메모리 제한 128MB, 제한시간 1초
public class pb1906 {
	public static void main(String args[]) {
	
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int S = scan.nextInt();

		// 숫자배열, 부분합 배열
		int[] arr = new int[N];
		int[] arr_sum = new int[N];
				

		arr[0] = scan.nextInt();
		arr_sum[0] = arr[0];
		
		// 부분합 배열 초기화
		for(int i =1; i <N; i++) {
			arr[i] = scan.nextInt();
			arr_sum[i] = arr_sum[i-1] + arr[i];
		}
		
		// 최소의 길이를 최대의 길이로 초기화함.
		int min_length = N;
		
		// 시간 초과한 이유 : minlength보다 길이가 작지 않다면 확인할 필요없음.
		// 처음 : S보다 크면 -> min_length보다 작은지 확인
		// 수정 : min_length보다 작으면 -> S보다 큰지 확인, break를 넣어서 쓸모없는 반복문 횟수 줄임 : 5000ms -> 1600ms
		for(int j = 0; j < N ; j++) {
			if( j < min_length) {
				if(arr_sum[j] >= S) {
					min_length = j+1;
                    break;
				}
			} else{
                break;
            }
		}
		
		for(int i = 1; i < N ; i++) {
			for(int j = i; j < N ; j++) {
				if( j-(i-1) < min_length) {
					if((arr_sum[j]-arr_sum[i-1]) >= S) {
						min_length = j-(i-1);
                        break;
					}
				} else{
                    break;
                }
			}
		}
		
		// 처음 틀린이유 : 조건에 해당하는 값이 없을때의 조건을 넣지 않았음 => 추가함
		// 조건에 해당하지 않고 그대로 반복문 통과시 min_length를 0으로 설정.
		if(min_length ==N) {
			min_length=0;
		}
		System.out.println(min_length);
	}
}
