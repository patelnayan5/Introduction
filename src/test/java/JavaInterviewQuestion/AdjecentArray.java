package JavaInterviewQuestion;

public class AdjecentArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] a = {1,4,8,15,17};//3,4,7,2
		int diff = 0;
		for (int i=0;i<a.length-1;i++)
		{
			if(a[i+1]-a[i]>diff)
				//for i=0,4-1=3 #value of a[1]=4
				//for i=1,8-4=4
				//for i=2,15-8=7
			{
				diff = a[i+1]-a[i];
			}
			
		}

		System.out.println(diff);
	}

}
