package com.lectures;

public class Test {

	static ListNode head = null;
	
	public static void main(String[] args) {
		
//		System.out.println(findMedianSortedArrays(new Integer[]{1,2},new Integer[]{3,4}));
//		System.out.println(findMedianSortedArraysUnMerged(new Integer[]{1,2},new Integer[]{3,4}));
		
//		reverse(123);
		
		
//		ListNode l1 = new ListNode(1);
//		l1.next = new ListNode(4);
//		l1.next.next = new ListNode(5);
//		
//		ListNode l2 = new ListNode(1);
//		l2.next = new ListNode(3);
//		l2.next.next = new ListNode(4);
//		
//		ListNode l3 = new ListNode(2);
//		l3.next = new ListNode(6);
//		mergeKLists(new ListNode[] {l1,l2,l3});
		
//		longestPalindrome("bb");
		
		convert("PAYPALISHIRING",3);
	}
	
	public static String convert(String s, int numRows) {
        StringBuffer[] sb = new StringBuffer[numRows];
        int index = 0;
        int currRow = 0;
        while(index<s.length()) {
            sb[currRow].append(s.charAt(index));
            currRow++;
            if(currRow==numRows) {
                currRow = 0;
            }
            index++;
        }
        for(int i = 1; i< sb.length;i++) {
           sb[0].append(sb[i]);
        }
        return sb[0].toString();
    }
	
	static Boolean[][] resArr = null;
    
    public static String longestPalindrome(String s) {
        int n = s.length();
        if(n<2) {
            return s;
        }
        resArr = new Boolean[n][n];
        int start=0,length=0;
        for(int i=0;i<n;i++) {
            for(int j=i;j<n;j++) {
                if(isPallendrome(s, i, j) && ((j-i)>length)) {
                    length = j-i;
                    start = i;
                }
            }
        }
        return s.substring(start, start+length+1);
    }
    
    private static Boolean isPallendrome(String s, int i, int j) {
        if(resArr[i][j]!=null) {
            return resArr[i][j];
        }
        if(j>(i+1)) {
            resArr[i][j] = s.charAt(i)==s.charAt(j) && isPallendrome(s,i+1,j-1);
        } else {
            resArr[i][j] = s.charAt(i)==s.charAt(j);
        }
        return resArr[i][j];
    }
	
	static class ListNode {
		      int val;
		      ListNode next;
		      ListNode() {}
		      ListNode(int val) { this.val = val; }
		      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
		  }
	
	public static ListNode mergeKLists(ListNode[] lists) {
        merge(lists);
        return head;
    }
    
    public static void merge(ListNode[] lists) {
        ListNode smallest = null;
        int n = 0;
        for(int i=0; i<lists.length; i++) {
            if(lists[i]!=null && (smallest==null || lists[i].val<smallest.val)) {
                smallest = new ListNode(lists[i].val);
                n = i;
            }
        }
        if(smallest==null) {
            return;
        }
        lists[n]=lists[n].next;
        add(smallest);
        merge(lists);
    }

    public static void add(ListNode n) {
        if(head==null) {
            head=new ListNode(n.val);
            return;
        }
        ListNode iter = head;
        while(iter.next!=null) {
            iter=iter.next;
        }
        iter.next = new ListNode(n.val);
    }
	
	public static int reverse(int x) {
        int result = 0;
        while (x!=0) {
            int r = x%10;
            int newResult = (result*10)+r;
            
            // We r simply re tracing the prev step and if it does not yield the same initial values, it means the value has rolled over due tothe size limit of int
            if (((newResult-r)/10)!=result) {  
                return 0;
            }
            result = newResult;
            x/=10;
        }
        return x<0?(result*-1):result;
    }
	
	public static double findMedianSortedArraysUnMerged(Integer[] nums1, Integer[] nums2) {
		int c1 = ((nums1.length-1)/2), c2 = ((nums2.length-1)/2);
	    while (c1>=0 && c2>=0 && c1<nums1.length && c2<nums2.length ) {
	        if(nums1[c1]<nums2[c2+1] && nums2[c2]<nums1[c1+1]) {
	            break;
	        } else if (nums1[c1]>nums2[c2+1]) {
	            c1--;
	        } else if (nums2[c2]>nums1[c1+1]) {
	            c2++;
	        }
	    }
	    if((nums1.length+nums2.length)%2==0) {
	        int v1 = nums1[c1]>=nums2[c2]?nums1[c1]:nums2[c2];
	        int v2 = nums1[c1+1]<=nums2[c2+1]?nums1[c1+1]:nums2[c2+1];
	        return (v1+v2)/2;
	    } else {
	        return nums1[c1]>=nums2[c2]?nums1[c1]:nums2[c2];   
	    }
	}
	
	public static double findMedianSortedArrays(Integer[] nums1, Integer[] nums2) {
        int n1 = nums1.length,n2=nums2.length,i=0,j=0,k=0;
        Integer[] mergedArray = new Integer[n1+n2];
        while (i<n1 && j<n2) {
            if(nums1[i]>nums2[j]) {
                mergedArray[k++] = nums2[j++];
            } else {
                mergedArray[k++] = nums1[i++];
            }
        }
        while (i<n1) {
            mergedArray[k++] = nums1[i++];
        }
        while (j<n2) {
            mergedArray[k++] = nums2[j++];
        }
        if(k%2==0) {
            return (mergedArray[k/2]+mergedArray[(k/2)-1])/2;
        } else {
            return mergedArray[k/2];
        }
    }

}
