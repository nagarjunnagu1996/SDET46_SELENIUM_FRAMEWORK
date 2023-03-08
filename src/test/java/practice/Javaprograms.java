package practice;

public class Javaprograms
{
public static void main(String[] args)
{
int st[]= {1,2,43,421,432,543,876,654};
 int largest=st[0];
 for(int i=0;i<st.length;i++)
 {
	 if(largest<st[i])
	 {
		 largest=st[i];
		
	 }
 }
 System.out.println(largest);
}
}
