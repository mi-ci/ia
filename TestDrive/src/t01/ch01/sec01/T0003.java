package t01.ch01.sec01;

public class T0003 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] array2 = {
				
				{95,86},
				{83,92,96},
				{78,83,93,87,88}
				
		};
		
		//합계와 평균
		
       int sum = 0;
				
		for(int i=0; i < array2.length; i++) {  // 행의길이 반복
			
			for(int j = 0; j < array2[i].length; j++ ) {  //열의길이 반복
				sum = array2[i][j];
			  }
		   }
				
				System.out.println(array2[0].length +"~~");
			
				System.out.println("합계 " + sum);
				
			int count = array2[0].length +array2[1].length + array2[2].length;
			System.out.println("합계 " +sum );
			
			double avg = sum/(double) count;
			
			System.out.println("평균은 " + avg);
			
			
			}
				
	}
