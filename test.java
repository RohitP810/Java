/*BANKING SYSTEM PROJECT 
https://www.javatpoint.com/banking-application-in-java#:~:text=println(%221.-,Display%20all%20account%20details%20%5Cn%202.,print(%22Enter%20account%20no.
*/


/*public class test {

	public static void main(String[] args) {
		int arr[]=new int[5];
		int arr1[]={30,40,50,60,70};
		arr[0]=10;
		arr[1]=20;
		arr[2]=30;
		arr[3]=40;
		arr[4]=50;
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		System.out.println(arr[3]);
		System.out.println(arr[4]);
		System.out.println(arr1[0]);
		System.out.println(arr1[1]);
		System.out.println(arr1[2]);
		System.out.println(arr1[3]);
		System.out.println(arr1[4]);
		for(int i=0;i<arr1.length;i++)
			System.out.println(arr1[i]);		
	}

}*/

/*Write a program to find the average of array elements*/

/*public class test {

	public static void main(String[] args) {
		int arr1[]={30,40,50,60,70},tot=0,avg=0;
		for(int i=0;i<arr1.length;i++)
		{
			tot=tot + arr1[i];	
		}
		avg=tot/arr1.length;
		System.out.println("Avg = "+avg+"%");
}

}*/

/* Write a program to create a Jagged array*/

/*public class test {
public static void main(String[] args) 
{

		int arr[][]=new int[3][];
		arr[0] = new int[3];
		arr[1] = new int[4];
		arr[2] = new int[3];
		arr[0][0]=0;
		arr[0][1]=1;
		arr[0][2]=2;
		arr[1][0]=3;
		arr[1][1]=4;
		arr[1][2]=5;
		arr[1][3]=6;
		arr[2][0]=7;
		arr[2][1]=8;
		//int arr[][]={{0,1,2},{3,4,5,6},{7,8}};
		System.out.println("jagged array");
        	for (int i = 0; i < arr.length; i++) 
		{
            		for (int j = 0; j < arr[i].length; j++)
                		System.out.print(arr[i][j] + " ");
            		System.out.println();
        	}

}
}*/

/*write a program to check if a number is even +ve or even -ve or odd +ve or odd -ve or 0*/

/*public class test {
public static void main(String[] args) 
{

		int a=-20;
		if(a%2==0 && a>0)
		System.out.println("Even & +ve");
		else if(a%2!=0 && a>0)
		System.out.println("Odd & +ve");
		else if(a%2==0 && a<0)
		System.out.println("Even & -ve");
		else if(a%2!=0 && a<0)
		System.out.println("Odd & -ve");
		else
		System.out.println("Number is 0!");
}
}*/


/*Write a prgrm to print n even numbers using for,while and do while loop.*/

/*import java.util.Scanner;

public class test {
public static void main(String[] args) 
{
	Scanner in = new Scanner(System.in);

	System.out.print("Enter the value of n: ");
	int n = in.nextInt();
	int count = 1;
	System.out.println("Using FOR loop");
	for(int i=0; count<=n ; i++)
	{
		if(i%2==0) 
		{
			System.out.println(i);
			count++;
		}
	}
	
	count=1;
	System.out.println("Using WHILE loop");
	int i=0;
	while(count<=n)
	{
		if(i%2==0) 
		{
			System.out.println(i);
			count++;
		}
		i++;
	}
	
	System.out.println("Using DO WHILE loop");
	i=0;
	count=1;
	do
	{
		if(i%2==0) 
		{
			System.out.println(i);
			count++;
		}
		i++;
	}while(count<=n);
}
}*/

/* 
   //Write a program to check if a number is palindrom or not
   //Write a program to check wether the number is prime or not 
   //Write a program to check if the given number is a perfect square
   //Write a program to print the elements of an array on even position
   Write a program to find the smallest element in an array
   //Write a program to print * pattern dynamic rows
*/


/*
//Write a program to print the elements of an array on even position
import java.util.Scanner;
public class test {
public static void main(String[] args) 
{
	Scanner in = new Scanner(System.in);
	System.out.print("Enter total number of elements n: ");
	int n = in.nextInt();
	int arr[]=new int[n];
	for(int i=0;i<n;i++)
	{
		arr[i]=in.nextInt();
	}
	System.out.println("Elements in even position of the given array: ");
	for(int i=0;i<n;i++)
	{
		if(i%2==0)
		{
			System.out.print(arr[i]+" ");
		}
	}
}
}
*/

/*
//Write a program to check wether the number is prime or not 
import java.util.Scanner;
public class test {
public static void main(String[] args) 
{
	Scanner in = new Scanner(System.in);
	System.out.print("Enter the value of n: ");
	int n = in.nextInt();
	boolean flag=false;
	for(int i=2;i<=n/2;i++)
	{
		if(n%i==0)
		{
			flag=true;
			break;
		}
	}
	if(!flag)
		System.out.print("Entered value is a prime number!");
	else
		System.out.print("Entered value is not a prime number!");
	
}
}
*/

/*
//Write a program to check if a number is palindrom or not
import java.util.Scanner;
public class test {
public static void main(String[] args) 
{
	Scanner in = new Scanner(System.in);
	System.out.print("Enter the number: ");
	int n = in.nextInt();
	int r, rev=0,temp;
	temp=n;
	while(n>0)
	{    
	  r=n%10;  //getting remainder  
	  rev=(rev*10)+r;    
	  n=n/10;    
	}    
	if(temp==rev)    
		System.out.println("palindrome");    
	else    
		System.out.println("not palindrome");    
}
}
*/

/*
//Write a program to check if the given number is a perfect square
import java.util.Scanner;
public class test {
public static void main(String[] args) 
{
	Scanner in = new Scanner(System.in);
	System.out.print("Enter the number: ");
	int n = in.nextInt();
	int sr = (int)Math.sqrt(n);
	if((sr * sr)==n)
		System.out.println("Yes");
	else
		System.out.println("No");
}
}
*/


/*
//Write a program to print * pattern dynamic rows
import java.util.Scanner;
public class test {
public static void main(String[] args) 
{
	Scanner in = new Scanner(System.in);
	System.out.print("Enter the number: ");
	int n = in.nextInt();
	int i, j;  
    for(i=0; i<n; i++) 
    { 
    	for(j=2*(n-i); j>=0; j--)  
        {           
            System.out.print(" ");
        } 
        for(j=0; j<=i; j++)
        {       
            System.out.print("* "); 
        }           
        System.out.println(); 
    }  
}
}
*/