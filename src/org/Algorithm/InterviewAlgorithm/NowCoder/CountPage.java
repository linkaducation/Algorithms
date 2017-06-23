package org.Algorithm.InterviewAlgorithm.NowCoder;

import java.util.Scanner;

/**
 * Created by Ellen on 2017/6/23.
 */
public class CountPage {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(sc.hasNextInt()){
			int n=sc.nextInt();
			int arr[]=new int[10];
			for(int i=0;i<10;i++){
				arr[i]=0;
			}
			count(n,arr);
			for(int i=0;i<9;i++){
				System.out.print(arr[i]+" ");
			}
			System.out.print(arr[9]);
		}


	}
	public static void count(int n,int arr[]){
		int i=1;

		while(n/i!=0){
			int before=n/(i*10);
			int after=n%i;
			int current=(n/i)%10;
			if(current==0){
				arr[0]+=(before-1)*i+after+1;
			}else{
				arr[0]+=before*i;
			}
			for(int index=1;index<10;index++){
				if(index<current){
					arr[index]+=(1+before)*i;
				}else if(index==current){
					arr[index]+=before*i+after+1;
				}else{
					arr[index]+=before*i;
				}
			}
			i=i*10;
		}

	}
}
