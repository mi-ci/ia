package t01.ch01.sec01;

public class T0003 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] array2 = {
				
				{95,86},
				{83,92,96},
				{78,83,93,87,88}
				
		};
		
		//�հ�� ���
		
       int sum = 0;
				
		for(int i=0; i < array2.length; i++) {  // ���Ǳ��� �ݺ�
			
			for(int j = 0; j < array2[i].length; j++ ) {  //���Ǳ��� �ݺ�
				sum = array2[i][j];
			  }
		   }
				
				System.out.println(array2[0].length +"~~");
			
				System.out.println("�հ� " + sum);
				
			int count = array2[0].length +array2[1].length + array2[2].length;
			System.out.println("�հ� " +sum );
			
			double avg = sum/(double) count;
			
			System.out.println("����� " + avg);
			
			
			}
				
	}