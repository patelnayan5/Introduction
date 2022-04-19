package JavaInterviewQuestion;


//create method which accepts array and returns sum of all the elements in array
//print 5 multiplication table without using multiply operator
public class sumOfElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] a = {1,2,3,4,5};
		int sum = sumArray(a);
		System.out.println(sum);
		
		int result = multiply(5,10);
		System.out.println(result);

	}

	public static int multiply(int i, int j) 
	{
		// TODO Auto-generated method stub
		int k=1;
		int sum=0;
		while(k<=j)
		{
			sum = sum + i;
			k++;
		}
		
		
		return sum;
	}
	

	public static int sumArray(int[] a) 
	{
		int sum = 0;
		
		for(int i=0;i<a.length;i++)
		{
			//System.out.println(a[i]);
			sum = sum + a[i];
		}
		return sum;
	}

}
