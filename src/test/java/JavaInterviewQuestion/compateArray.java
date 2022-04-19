package JavaInterviewQuestion;

import java.util.ArrayList;

public class compateArray {

	//compare the same indexes of 2 different arrays and create another array
	public static void main(String[] args) {
		
		
		int a[] = {1,4,5,7};
		int b[]= {6,4,3,7};
		
		ArrayList<Integer>al=new ArrayList<Integer>();
		
		for(int i=0;i<a.length;i++)
		{
			if(a[i]==b[i])
			{
				al.add(a[i]);
			//	al.add(b[i]);
			}

		}

		Object[] c = al.toArray();
		for(Object obj:c)
		{
			System.out.println(obj);
		}
		
	}

}
