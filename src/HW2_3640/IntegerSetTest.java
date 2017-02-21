package HW2_3640;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;



	@RunWith(value = Parameterized.class)
	public class IntegerSetTest {
		//instantiate Integer arrays pertaining to text file inputs 	 
		private static Integer[] list1;
		private static Integer unique[];
		private static Integer[] list2;
		private static Integer[] unique2;
		private static Integer[] intersection;
		private static Integer[] union;
		private static IntegerSet integerTest;
		//instantiate sets for testing methods 
		IntegerSet testingSet;
		IntegerSet testingSet2;
		IntegerSet testingSet3; 
		IntegerSet testingSet4;
		
		//constructor handles 2d array. 
		//set rows to their proper text file input line
		public IntegerSetTest (Integer[][] input) { 
	    
		this.list1 = input[0]; 
		this.unique = input[1];
		this.list2 = input[2];
		this.unique2 = input[3];
		this.intersection = input[4];
		this.union = input[5];
		} 	
		
	@Parameterized.Parameters
	public static Collection<Object[]> intersectionTests() throws IOException {
		// instantiate 10 2d arrays for each set
		Integer array1[][] = new Integer[6][];
		Integer array2[][] = new Integer[6][];
		Integer array3[][] = new Integer[6][];
		Integer array4[][] = new Integer[6][];
		Integer array5[][] = new Integer[6][];
		Integer array6[][] = new Integer[6][];
		Integer array7[][] = new Integer[6][];
		Integer array8[][] = new Integer[6][];
		Integer array9[][] = new Integer[6][];
		Integer array10[][] = new Integer[6][];
		   
		// read text file    
		BufferedReader br = new BufferedReader(new FileReader("test_input.txt"));
		int counter=0; // row counter 
		String line = null;
		int row=0;
	      do {
	    	  while ((line= br.readLine()) !=null) { // while file is not null
	    		  // if line is empty set row back to zero and increase counter 
	    		  if (line.isEmpty()) {
	    		  
	    			  row=0;
	    			  counter++; 
	    			  break;  
	    		  }
	    		   
	    		 String[] values = line.split(","); // read file values
				 Integer[] intValues = new Integer[values.length];
	    		  
				 // parse strings to int values 
				 for (int i=0; i<intValues.length; i++) {
					 
					 intValues[i] = Integer.parseInt(values[i]);
					 
				 } 
				  // store first set of values in first array
				 if (counter==0){  
					 array1[row]=intValues;
					
				 }// store second set of values in 2nd array 
				 else if (counter==1) {
					 
					 array2[row]=intValues;
					
				 }// store third set of values in 3rd array 
				 else if (counter==2) {
					 
					 array3[row]=intValues;
					  
				 }// store forth set of values in 4th array 
				 else if (counter==3) {
	 
					 array4[row]=intValues;
					
				 }// store fifth set of values in 5th array 
				 else if (counter==4) {
	 
					 array5[row]=intValues;
					
				 }// store sixth set of values in 5th array  
				 else if (counter==5) {
					 
					 array6[row]=intValues;
					
				 }// store seventh set of values in 6th array 
				 else if (counter==6) {
	 
					 array7[row]=intValues;
					
				 }// store eighth set of values in 7th array 
				 else if (counter==7) {
	 
					 array8[row]=intValues;
					
				 }// store ninth set of values in 8th array 
				 else if (counter==8) {
	 
					 array9[row]=intValues;
					
				 }
				 else// store tenth set of values in 10th array    
					 array10[row]=intValues;
				
				row++; // increment row 
	    	  }  
	      }while(line !=null); 
		    
			  
			return Arrays.asList(new Object[][] { // create an object array that						
				{array1},{array2},{array3},{array4}, // 10 sets of data 
				{array5},{array6},{array7},
				{array8},{array9},{array10},
			});   
		}  
	  
		
	@Before
	public void setUp() {
		testingSet= new IntegerSet();
		testingSet2 = new IntegerSet();
		testingSet3 = new IntegerSet(); 
		testingSet4 = new IntegerSet();
		
	}
	
	
	
		//union of sets results in a null pointer exception
		@Test(expected = NullPointerException.class)
		public void testIntersectionWithNullInput() {
			testingSet = new IntegerSet(null);
			testingSet2= new IntegerSet(null); 
			
			// union of 2 null sets 
			testingSet3= testingSet.intersection(testingSet, testingSet2);
		}
	 
		@Test
		public void testExist() {
			testingSet = new IntegerSet(list1);
			// create array equal to IntegerSet object 
			Integer array[] = testingSet.toArray(); 
			// test if the first element in each set exists 			
			assertEquals(testingSet.exists(array[0]), true); 
		}       
		  
		@Test 
		public void testIsEmpty() {   
	    // create set with no data in it  
		testingSet= new IntegerSet();
		assertTrue(testingSet.isEmpty());  // empty list = true 
		assertFalse(!testingSet.isEmpty());// !empty list = false
		}
		 
		@Test
		public void testUnion() {
			// 2 sets, one = to the first list and one = to the second list  
			testingSet = new IntegerSet(list1);
			testingSet2= new IntegerSet(list2);
			// 3rd set =to the union of the two lists 
			testingSet3= new IntegerSet(union);
			// 4th set equal to the union of sets 1 and 2 
			testingSet4= testingSet.union(testingSet, testingSet2);
			// sets 3 and 4 should be equal
			// assertEquals method is deprecated 
			assertArrayEquals(testingSet3.toArray(),testingSet4.toArray());
			  
		}
		
		@Test 
		public void testCreateSetFromArray() {
			// create an arrat of values
			Integer [] array = { 1, 2, 3, 4, 5, 6,7};
			// set = to the array of values 
			testingSet2 = new IntegerSet(array);
			// set created from the array is = to the array 
			assertArrayEquals(testingSet2.toArray(), array);   
		} 
		  
		@Test(expected = NullPointerException.class)
		public void testCreateSetFromNull() {
			// create set =  to null, will cause NullPointerException 
			testingSet = new IntegerSet(null);  
		}
		 
		@Test
		public void testDeleteAll() {
			// create set, insert data, and delete the data
			testingSet = new IntegerSet(); 
			testingSet.insertAll(list1); 
			testingSet.deleteAll();
			// after data is deleted set should be empty 
			assertTrue(testingSet.isEmpty());
		}
		
		@Test
		public void testDeleteElement() { 
			// create set, insert data and delete the first element in the set 
			testingSet= new IntegerSet(list1);
			Integer array[] = testingSet.toArray(); 
			testingSet.deleteElement(0);
			// check to see if the first element in the set still exists
			// should result to false 
			assertEquals(testingSet.exists(array[0]), false);  
		}   
		  
		 
		@Test 
		public void testinsertAll() {
			// create set insert all list1 data 
			// insertAll should make list of unique elements in ascending order
			testingSet = new IntegerSet();
			testingSet.insertAll(list1);
			// create set = to unique values in list 
			testingSet2 = new IntegerSet(unique);  
			// 2 set should be equal 
			// assertEquals for these parameters is a deprecated method 
			assertArrayEquals(testingSet.toArray(), testingSet2.toArray()); 
												   
		}
		
		@Test(expected = NullPointerException.class)
		public void testAllNull() {
			// create set insert null values
			testingSet = new IntegerSet();
			testingSet.insertAll(null);
			// check if set is null 
 			assertNull(testingSet);
		} 
		  
		  
		@Test
		public void testIntersection() {
			// create 2 sets, one for each list 
			testingSet = new IntegerSet(list1);
			testingSet2= new IntegerSet(list2);
			// create 3rdset = to the intersection list 
			testingSet3= new IntegerSet(intersection);
			// create 4th set =to the intersection of set1 and set2
			testingSet4= testingSet.intersection(testingSet, testingSet2);
			//  sets 3 and set 4 should be equal 
			// assertEquals for these parameters is a deprecated method 
			assertArrayEquals(testingSet3.toArray(),testingSet4.toArray());	 
		}  
		
		@Test(expected = NullPointerException.class)
		public void testUnionWithNullInput() {
			// create 2 null sets 
			testingSet = new IntegerSet(null);
			testingSet2= new IntegerSet(null); 
			// union of 2 sets should result in null value 
			testingSet3= testingSet.union(testingSet, testingSet2);
			
		} 
	}

