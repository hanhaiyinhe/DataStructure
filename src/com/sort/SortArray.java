package com.sort;

public class SortArray<E> {

	
	public <E extends Comparable<? super E>> void selectionSort(E[] array) {
		// TODO Auto-generated method stub
		int min=0;
		E tmp=null;
		System.out.print("selectionSort: ");
		printArray(array);
		for(int i=0;i<array.length;i++){	
			min=i;
			for(int j=i+1;j<array.length;j++){
				if(array[j].compareTo(array[min])<0){
					min=j;
				}
			}
			tmp=array[min];
			array[min]=array[i];
			array[i]=tmp;
			System.out.print((i+1)+": ");
			printArray(array);
		}
	}

	
	public <E extends Comparable<? super E>> void insertSort(E[] array) {
		// TODO Auto-generated method stub
		System.out.print("insertSort: ");
		printArray(array);
		E e=null;
		int j=0;
		for(int i=1;i<array.length;i++){
			j=i;
			e=array[i];
			if(array[j-1].compareTo(e)>0){
				while(j>0 && array[j-1].compareTo(e)>0)
				{
					array[j]=array[j-1];
					j--;
				}
			}
			array[j]=e;
			System.out.print((i+1)+": ");
			printArray(array);
		}
		
	}

	
	public <E extends Comparable<? super E>> void BubbleSort(E[] array) {
		// TODO Auto-generated method stub
		System.out.print("BubbleSort: ");
		printArray(array);
		boolean flag=false;
		E tmp=null;
		for(int i=0;i<array.length;i++){
			flag=false;
			for(int j=0;j<array.length-i-1;j++){
				if(array[j].compareTo(array[j+1])>0){
					flag=true;
					tmp=array[j];
					array[j]=array[j+1];
					array[j+1]=tmp;
				}
			}
			System.out.print((i+1)+": ");
			printArray(array);
			if(flag==false)
				break;
		}
	}

	
	public <E extends Comparable<? super E>> void mergeSort(E[] array) {
		// TODO Auto-generated method stub
		System.out.print("mergeSort:");
		printArray(array);
		mergeTwoSort(array,0,array.length-1);
	}
	
	private <E extends Comparable<? super E>> void merge(E[] array,int low,int high,int mid){		
		E[] newArr=(E[])new Comparable<?>[high-low+1];
		int i=0;
		int t1=low;
		int t2=mid+1;

		while((t1<=mid)&&(t2<=high)){
			if(array[t1].compareTo(array[t2])<0){
				newArr[i]=array[t1];
				t1++;
				
			}
			else{
				newArr[i]=array[t2];
				t2++;
			}
			i++;
		}
		while(t1<=mid){
			newArr[i]=array[t1];
			t1++;
			i++;
		}
		while(t2<=high){
			newArr[i]=array[t2];
			t2++;
			i++;
		}
		
		for(int j=0;j<newArr.length;j++){
			array[low+j]=newArr[j];
		}
	} 
	
	private <E extends Comparable<? super E>> void mergeTwoSort(E[] array,int low,int high){
		if(low<high){
			int mid=(low+high)/2;
			mergeTwoSort(array,low,mid);
			mergeTwoSort(array,mid+1,high);
			merge(array,low,high,mid);
			printArray(array);
		}
	}

	
	public <E extends Comparable<? super E>> void quickSort(E[] array) {
		// TODO Auto-generated method stub
		System.out.print("quickSort :");
		quick(array,0,array.length-1);
	}
	
	private <E extends Comparable<? super E>> void quick(E[] array,int low,int high){
		int i=0,j=0;
		E e=null;
		if(low>=high)
			return;
		i=low;
		j=high;
		e=array[i];
		while(i<j){
			while(i<j && array[j].compareTo(e)>0)
				j--;
			if(i<j)
				array[i++]=array[j];
			while(i<j && array[i].compareTo(e)<0)
				i++;
			if(i<j)
				array[j--]=array[i];
			
		}
		array[i]=e;
		printArray(array);
		quick(array,low,i-1);
		quick(array,i+1,high);
		
	}

	
	public <E extends Comparable<? super E>> void shellSort(E[] array) {
		// TODO Auto-generated method stub
		System.out.print("shellSort :");
		printArray(array);
		E tmp=null;
		int dk=0,i=0,j=0;
		int len=array.length;
		for(dk=len/2;dk>=1;dk=dk/2){
			for(i=dk;i<len;i++){
				if(array[i].compareTo(array[i-dk])<0){
					tmp=array[i];
					for(j=i-dk;j>=0 && (tmp.compareTo(array[j])<0);j=j-dk){
						array[j+dk]=array[j];
					}
					array[j+dk]=tmp;
				}
			}
			printArray(array);
		}
	}

	
	public <E extends Comparable<? super E>> void maxHeapSort(E[] array) {
		// TODO Auto-generated method stub
		System.out.print("maxHeapSort:");
		if(array==null||array.length==0)
			return;
		printArray(array);
		buildMaxHeap(array);
		E tmp=null;
		for(int i=array.length-1;i>0;i--){
			tmp=array[i];
			array[i]=array[0];
			array[0]=tmp;
			adjustDown(array,0,i);
			printArray(array);
		}
		
	}
	
	private <E extends Comparable<? super E>> void buildMaxHeap(E[] array){
		int len=array.length;
		for(int i=len/2;i>=0;i--){
			adjustDown(array,i,len);
		}
	}
	
	private <E extends Comparable<? super E>> void adjustDown(E[] array,int k,int len){
		E tmp=array[k];
		for(int i=2*k+1;i<len;i=i*2){
			if(i<len-1&&(array[i].compareTo(array[i+1]))<0){
				i++;
			}
			if(tmp.compareTo(array[i])>=0)
				break;
			else{
				array[k]=array[i];
				k=i;
			}
			array[k]=tmp;
		}
	}
	
	public void printArray(Object[] array){
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}
	
}
