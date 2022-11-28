------------------
Merge sort
------------------

## Description

Given `n` values to sort:

- ***Divide*** the list into `n` sublists, each containing a ***single element***
- Each of the n sublists is ***sorted***, since there is only one value in the sublist
- ***Merge*** two adjacent sorted sublists into a single sorted sublist
- Continue increasing (doubling) the size of the sorted sublists until
one sublists is the entire list

## Algorithm

[I used the version of merge sort described in wikipedia](https://en.wikipedia.org/wiki/Merge_sort)

- There are two variants described:
	- top down and bottom up

- I implemented and will discuss the bottom up version in detail
- We will briefly discuss the top down version later on below

- Both use two copies of the array, the ***original array*** and a ***copy to do work with***
- When merging two sorted sublists, the sorted sublists are merged into the copy of the array
- Then the copy of the array is copied back into the original array for bottom up
	- **Note:** top down does not need to copy back to the original version

## Example

The bottom up implementation does the following:

- Let's say we have an array with `10` values
1. We first merge the sorted subarrays of size 1
	- [0:0] & [1:1]
	- [2:2] & [3:3]
	- [4:4] & [5:5]
	- [6:6] & [7:7]
	- [8:8] & [9:9]
2. We then merge the sorted subarrays of size 2
	- [0:1] & [2:3]
	- [4:5] & [6:7]
	- [8:9] & [10:9] (obviously [10:9] is not valid, so it is ignored)

3. We then merge the sorted subarrays of size 4
	- [0:3] & [4:7]
	- [8:9] & [10:9]
4. We then merge the sorted subarrays of size 8
	- [0:7] & [8:9]

At this point we are done, since the first sorted subarray of size 16 contains the entire array

[Here is an animation to showcase a concrete example of mergesort in action.](https://en.wikipedia.org/wiki/Merge_sort#/media/File:Merge-sort-example-300px.gif)

## Helper Methods

- There are three methods utilized to implement Merge Sort

1. The main method, `BottomUpMergeSort`
	- This method breaks the array into the sorted subarrays and calls `BottomUpMerge` to merge two contiguous sorted subarrays
	- It also copies the copy of the original array back into the the original array
2. The method that merges two contiguous sorted parts of an array, `BottomUpMerge`
3. The method that copies an array, `CopyArray`

- **Note:** The pseudo code that follows was derived from the bottom up implementation of merge sort [described on wikipedia.](https://en.wikipedia.org/wiki/Merge_sort)


### Pseudo code for `BottomUpMergeSort`


``` java
void BottomUpMergeSort(int[] origArray)
{
	//PSEUDO - Instantiate int[] workArray
	//PSEUDO - Use copyArray to copy origArray to workArray

	for(int width = 1; width < origArray.length; width = 2 * width)
	{ 
		for(int i = 0; i < origArray.length; i = i+(2*width))
		{
			// merge subarrays X and Y, where:
				//X = origArray[i:min(i+width, origArray.length)-1] and
				//Y = origArray[min(i+width, origArray.length):min(i+(2*width), origArray.length)-1]
			int end_idx_sub_array_X = min(i+width, origArray.length);
			int end_idx_sub_array_Y = min(i+(2*width), origArray.length);

			//Note - we are dividing origArray into two adjacent, already sorted subarrays and have
			//bottomUpMerge merge them into a single contiguous sorted subarray
			bottomUpMerge(origArray, i, end_idx_sub_array_X, end_idx_sub_array_Y, workArray);
		}
		
		//PSEUDO - Use copyArray to copy workArray to origArray
	}
}
```

### Pseudo code for `BottomUpMerge`

``` java

//Note: left, right, and end defines two adjacent sorted subarrays:
	//namely arrayA[left:right-1] and arrayA[right:end-1],
//that are sorted into one contiguous sorted subarray:
	//namely, arrayB[left:end-1].
void BottomUpMerge(int[] arrayA, int left, int right, int end, int[] arrayB)
{
	set i = left, j = right

	for( int k = left; k < end; k++ )
	{ 
		//Note: This if statement works as desired with careful consideration. 
		// We are heavily relying on lazy evaluation here.

			// Case 1: If i < right is true and j >= end is false.
			// This means we have not fully merged the left sublist 
			// nor the right sublist yet.
			// So, the arrayA[i] <= arrayA[j] is evaluated, and 
			// dictates which element from either sublist we are going to grab next.

			// Case 2: If i < right is true and j >= end is true.
			// This means that we have fully merged the right sublist, 
			// but have not yet fully merged the left sublist.
			// So, we fall into the if block to copy elements remaining 
			// in the left sublist that still need to be merged. 
			// Note that the arrayA[i] <= arrayA[j] is not executed here 
			// due to lazy evaluation.

			// Case 3: If i < right is false, and j >= end is false.
			// This means that we have fully merged the left sublist, 
			// but have not yet fully merged the right sublist.
			// So, we fall into the else block to copy elements remaining 
			// in the right sublist that still need to be merged.
			// Note that the arrayA[i] <= arrayA[j] is not executed here 
			// due to lazy evaluation.

			// Case 4: If i < right is false, and j >= end is true.
			// This means that we have fully merged both 
			// the left and right sublists, which means we are done.
			// In reality, this case will never occur during execution, 
			// because the for loop goes from k = left to k < end.
			// No matter what complicated order the merge occurs in, 
			// i and j will not both be incremented to the point
			// where this case can occur.

		if( (i < right) and ((j >= end) or (arrayA[i] <= arrayA[j])) )
		{
			//Copy the next element from the left sublist into arrayB.

			//Note - we only arrive here if arrayA[i] <= arrayA[j] or we have already copied
			//all of the right sublist to arrayB
			arrayB[k] = arrayA[i]
			i = i+1
		}
		else
		{
			//Copy the next element from the right sublist into arrayB.

			//Note - we only arrive here if arrayA[i] > arrayA[j] or we have already copied 
			//all of the left sublist to arrayB
			arrayB[k] = arrayA[j]
			j = j+1
		}
	}
}
```

### Brief note about the `copyArray` method

- This is trivial so we don't bother to show the pseduo code here. 
- Just copy the elements from one array into the other, dictated by the order they are passed in via arguments.

## Time Complexity Analysis for Merge Sort 

- **Claim:** Bottom up merge sort has algorithmic efficiency of `O(n log n)`
- **Argument goes something like this:** From a very high level, merge sort breaks an array of size `n` into sorted subarrays of size `1, 2, 4, 8, …, n/4, n/2, n` and merges adjacent pairs of the subarrays

- To merge two adjacent subarrays of size `n/8`, for example: 
	- We need approximately `2 x (n/8)` comparisons to merge them
	- And we need to merge `4` pairs of them
	- So we have approximately `4 x 2 x (n/8)` = `n` comparisons to merge all of the adjacent pairs of subarrays of size `n/8`
- Thus we have approximately `n` comparisons for all of the merges of adjacent subarrays of size 1, 2, 4, 8, 16, …, n/4, n/2, n 
	- And we have to merge log2 n of them
	- Giving us `O(n log2 n)` = `O(n log n)`
- **Note:** In cs 375 you will see why `O(n log2 n)` and `O(n log n)` are equivalent and a much more detailed analysis of the algorithmic performance of merge sort

## Extra Credit Opportunity for Program Assignment 08

- You can do the following for ***10 extra credit points*** for program 8
	- **Note:** The 10 points will either be used to cancel out 10 lost points of program 8 or 10 points lost in previous programming assignments
	- Add a row to the bottom of the left and right button panels
	- Implement ***bottom up*** merge sort
	- Add “merge sort ints” button and label to the left button panel
		- Call your implementation of merge sort
	- Add “search merge sorted ints” button and label to the right button panel
		- Use your implementation of binary search to search the merge sorted `int[]`

## Brief Details on the top down version of Merge Sort

- The main difference between the top down and bottom up versions of merge sort are that the ***top down version uses
recursion*** and the bottom version does not.
	- The method that merges two adjacent sorted sublists are identical (other than the variable names for `left`, `right`, and `end` of the two sublists)

- For the top down version of merge sort we have two methods that are not used in the bottom up version
1. `TopDownMergeSort`
	- Make a copy of the array to sort
	- Calls `TopDownSplitMerge`
2. `TopDownSplitMerge`
	- Makes two recursive calls to itself, one call with the ***bottom half*** of the array and the second call with the ***upper half*** of the array
	- Merges the two sorted halves of the array

- The top down version of merge sort does the following
	- Makes a copy of the array to sort, and then calls `TopDownSplitSort` with the two arrays and the indices of the `first` and `last+1` index to process
- `TopDownSplitSort` does the following
	- If there is only one element in the range to sort, return, since it is already sorted
	- Make two recursive calls to `TopDownSplitSort`, one for the ***lower half*** of the subarray and one for the ***upper half*** of the subarray
	- Merge the two sorted subarrays into a single sorted subarray

### Pseudo code for TopDownMergeSort

``` java
void TopDownMergeSort(int[] origArray)
{
	// PSEUDO - Instantiate int[] workArray
	// PSEUDO - Use copyArray to copy origArray to workArray
	TopDownSplitMerge(workArray, 0, origArray.length, origArray)
}
```
- **Note:** `0` and `origArray.length` specify to `TopDownSplitMerge` to sort the entire array

### Pseudo code for TopDownSplitMerge

``` java
void TopDownSplitMerge(int[] arrayA, int begin, int end, int[] arrayB)
{
	If( (end - begin) <= 1 ) return
	
	middle = (begin+end)/2

	//Recursively split the original Array into two sub arrays.
	//Note that each of these will recursively split into more sub arrays within their calls.
	TopDownSplitMerge(arrayB, begin, middle, arrayA)
	TopDownSplitMerge(arrayB, middle, end, arrayA)
	
	//Same method that we already discussed, with the elegant lazy evaluation.
	BottomUpMerge(arrayA, begin, middle, end, arrayB) 
}
```

### Subtleties to note for Top Down Merge Sort

- The subarray to sort has indices [begin:end-1]
- The recursive calls to `TopDownSplitMerge` swap `arrayA` and `arrayB`, so that they are always using the current good copy of the array
- The call to `BottomUpMerge` swaps `arrayA` and `arrayB` from the two recursive calls to TopDownSplitMerge to also be using the current good copy of the array
