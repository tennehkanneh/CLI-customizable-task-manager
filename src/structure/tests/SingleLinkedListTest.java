package src.structure.tests;

import src.structure.generic.SingleLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;

public class SingleLinkedListTest {
	private SingleLinkedList<Integer> emptyList;
    private SingleLinkedList<Integer> oneElementList;
	private SingleLinkedList<Integer> twoElementList;
	private SingleLinkedList<Integer> threeElementList;

    private static final Integer ELEMENT_A = 1;
	private static final Integer ELEMENT_B = 2;
	private static final Integer ELEMENT_C = 3;
	private static final Integer ELEMENT_X = -1;
	private static final Integer ELEMENT_Z = -2;

   
    @BeforeEach
    void setUp() {
        emptyList = new SingleLinkedList<>();

        oneElementList = new SingleLinkedList<>();
        oneElementList.add(ELEMENT_A);

		twoElementList = oneElementList;
        twoElementList.add(ELEMENT_B);

		threeElementList = twoElementList;
        threeElementList.add(ELEMENT_C);
    }


    /////////////////////////////////
	//XXX Tests for 0-element list
	/////////////////////////////////
	@Test
    void test_isEmpty_state() {
        assertTrue(emptyList.isEmpty(), "FAILED: isEmpty() on emptyList");
        assertEquals(0, emptyList.size(), "FAILED: size() on emptyList");
        assertEquals("[]", emptyList.toString(), "FAILED: toString() on emptyList");
    }

    @Test
    void test_addToFront_emptyList() {
		emptyList.addToFront(ELEMENT_A);

        assertFalse(emptyList.isEmpty(), "FAILED: isEmpty() for addToFront() on emptyList");
        assertEquals(1, emptyList.size(), "FAILED: size() for addToFront() on emptyList");
		assertEquals(ELEMENT_A, emptyList.first(), "FAILED: first() for addToFront() on emptyList");
		assertEquals(ELEMENT_A, emptyList.last(), "FAILED: last() for addToFront() on emptyList");
		assertEquals("[A]", emptyList.toString(), "FAILED: toString() for addToFront() on emptyList");
    }

	@Test
    void test_addToRear_emptyList() {
        emptyList.addToRear(ELEMENT_A);

		assertFalse(emptyList.isEmpty(), "FAILED: isEmpty() for addToRear() on emptyList");
        assertEquals(1, emptyList.size(), "FAILED: size() for addToRear() on emptyList");
		assertEquals(ELEMENT_A, emptyList.first(), "FAILED: first() for addToRear() on emptyList");
		assertEquals(ELEMENT_A, emptyList.last(), "FAILED: last() for addToRear() on emptyList");
		assertEquals("[A]", emptyList.toString(), "FAILED: toString() for addToRear() on emptyList");
    }

	@Test
    void test_addToAfter_emptyList() {
       assertThrows(NoSuchElementException.class, () -> emptyList.addAfter(ELEMENT_X, ELEMENT_Z));
    }

	@Test
    void test_addElement_emptyList() {
        emptyList.add(ELEMENT_A);

		assertFalse(emptyList.isEmpty(), "FAILED: isEmpty() for add() on emptyList");
        assertEquals(1, emptyList.size(), "FAILED: size() for add() on emptyList");
		assertEquals(ELEMENT_A, emptyList.first(), "FAILED: first() for add() on emptyList");
		assertEquals(ELEMENT_A, emptyList.last(), "FAILED: last() for add() on emptyList");
		assertEquals("[A]", emptyList.toString(), "FAILED: toString() for add() on emptyList");
    }

	@Test
    void test_addNeg1_emptyList() {
        assertThrows(IndexOutOfBoundsException.class, () -> emptyList.add(-1, ELEMENT_X));
    }

	 @Test
    void test_add0_emptyList() {
        emptyList.add(0, ELEMENT_A);

		assertFalse(emptyList.isEmpty(), "FAILED: isEmpty() for add() on emptyList");
        assertEquals(1, emptyList.size(), "FAILED: size() for add() on emptyList");
		assertEquals(ELEMENT_A, emptyList.first(), "FAILED: first() for add() on emptyList");
		assertEquals(ELEMENT_A, emptyList.last(), "FAILED: last() for add() on emptyList");
		assertEquals("[A]", emptyList.toString(), "FAILED: toString() for add() on emptyList");
    }

	@Test
    void test_add1_emptyList() {
       assertThrows(IndexOutOfBoundsException.class, () -> emptyList.add(1, ELEMENT_X));
    }

    @Test
    void test_removeFirst_emptyList() {
       assertThrows(NoSuchElementException.class, () -> emptyList.removeFirst());
    }

	@Test
    void test_removeLast_emptyList() {
       assertThrows(NoSuchElementException.class, () -> emptyList.removeLast());
    }

    @Test
    void test_removeElement_emptyList() {
        assertThrows(NoSuchElementException.class, () -> emptyList.remove(ELEMENT_X));
    }

    @Test
    void test_removeNeg1_emptyList() {
        assertThrows(IndexOutOfBoundsException.class, () -> emptyList.remove(-1));
    }

	@Test
    void test_remove0_emptyList() {
        assertThrows(IndexOutOfBoundsException.class, () -> emptyList.remove(0));
    }

	@Test
    void test_setNeg1_emptyList() {
        assertThrows(IndexOutOfBoundsException.class, () -> emptyList.set(-1, ELEMENT_X));
    }

	@Test
    void test_set0_emptyList() {
        assertThrows(IndexOutOfBoundsException.class, () -> emptyList.set(0, ELEMENT_X));
    }

	@Test
    void test_getNeg1_emptyList() {
        assertThrows(IndexOutOfBoundsException.class, () -> emptyList.get(-1));
    }

	@Test
    void test_get0_emptyList() {
        assertThrows(IndexOutOfBoundsException.class, () -> emptyList.get(0));
    }

    @Test
    void test_indexOf_emptyList() {
		assertEquals(-1, emptyList.indexOf(ELEMENT_X), "FAILED: indexOf() on emptyList");
    }

	 @Test
    void test_first_emptyList() {
        assertThrows(NoSuchElementException.class, () -> emptyList.first());
    }

    @Test
    void test_last_emptyList() {
        assertThrows(NoSuchElementException.class, () -> emptyList.last());
    }

	@Test
    void test_contains_emptyList() {
        assertEquals(false, emptyList.contains(ELEMENT_X), "FAILED: contains() emptyList");
    }


    //////////////////////////////////
	//XXX Tests for 1-element list
	//////////////////////////////////
	@Test
    void singleElmentList() {
		assertThrows(NoException.class, () -> emptyList.addToFront(ELEMENT_X));
        assertThrows(NoException.class, () -> emptyList.addToRear(ELEMENT_X));
        assertThrows(NoException.class, () -> emptyList.addAfter(oneElmentList.first(), ELEMENT_X));
		assertThrows(NoException.class, () -> emptyList.addAfter(ELEMENT_X, ELEMENT_Z));
        assertThrows(NoException.class, () -> emptyList.add(ELEMENT_X));
        assertThrows(IndexOutOfBoundsException.class, () -> emptyList.add(-1, ELEMENT_X));
        assertThrows(NoException.class, () -> emptyList.add(0, ELEMENT_X));
		assertThrows(NoException.class, () -> emptyList.add(1, ELEMENT_X));
        assertThrows(IndexOutOfBoundsException.class, () -> emptyList.add(2, ELEMENT_X));
        assertEquals(emptyList.first(), () -> emptyList.removeFirst());
        assertEquals(emptyList.last(), () -> emptyList.removeLast());
        assertThrows(emptyList.last(), () -> emptyList.remove(emptyList.first()));
		assertThrows(NoSuchElementException.class, () -> emptyList.remove(ELEMENT_X));
        assertThrows(IndexOutOfBoundsException.class, () -> emptyList.remove(-1));
        assertThrows(emptyList.last(), () -> emptyList.remove(0));
		assertThrows(IndexOutOfBoundsException.class, () -> emptyList.remove(1));
        assertThrows(IndexOutOfBoundsException.class, () -> emptyList.set(-1, ELEMENT_X));
        assertThrows(NoException.class, () -> emptyList.set(0, ELEMENT_X));
		assertThrows(IndexOutOfBoundsException.class, () -> emptyList.set(1, ELEMENT_X));
        assertThrows(IndexOutOfBoundsException.class, () -> emptyList.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> emptyList.get(0));
		assertThrows(IndexOutOfBoundsException.class, () -> emptyList.get(1));
		assertEquals(0, () -> emptyList.indexOf(emptyList.last()));
        assertEquals(-1, () -> emptyList.indexOf(ELEMENT_X));
        assertThrows(emptyList.last(), () -> emptyList.first());
        assertThrows(emptyList.first(), () -> emptyList.last());
        assertEquals(true, () -> emptlyList.contains(emptyList.last()));
		assertEquals(false, () -> emptyList.contains(ELEMENT_X));
		assertEquals(false, () -> emptlyList.isEmpty());
		assertEquals(1, () -> emptlyList.size());
		assertEquals("[A]", () -> emptlyList.toString());
    }

    @Test
    void testSingleElementListInitialState() {
        assertFalse(oneElementList.isEmpty(), "List should not be empty.");
        assertEquals(1, oneElementList.size(), "Size should be 1.");
        assertEquals(ELEMENT_A, oneElementList.first(), "First element should be ELEMENT_A.");
    }

    @Test
    void testAddToRearOnSingleElementList() {
        Integer newElement = 2;
        oneElementList.addToRear(newElement);
        assertEquals(2, oneElementList.size(), "Size should be 2 after adding to rear.");
        assertEquals(newElement, oneElementList.last(), "The new element should be the last one.");
    }
    
    @Test
    void testRemoveFirstOnSingleElementList() {
        Integer removedElement = oneElementList.removeFirst();
        assertEquals(ELEMENT_A, removedElement, "removeFirst should return the correct element.");
        assertTrue(oneElementList.isEmpty(), "List should be empty after removing the only element.");
        assertEquals(0, oneElementList.size(), "Size should be 0.");
    }
    
    @Test
    void testRemoveLastOnSingleElementList() {
        Integer removedElement = oneElementList.removeLast();
        assertEquals(ELEMENT_A, removedElement, "removeLast should return the correct element.");
        assertTrue(oneElementList.isEmpty(), "List should be empty after removing the only element.");
        assertEquals(0, oneElementList.size(), "Size should be 0.");
    }
    
    @Test
    void testRemoveByIndexOnSingleElementList() {
        Integer removedElement = oneElementList.remove(0);
        assertEquals(ELEMENT_A, removedElement, "remove(0) should return the correct element.");
        assertTrue(oneElementList.isEmpty(), "List should be empty after removing the only element.");
        assertEquals(0, oneElementList.size(), "Size should be 0.");
    }
    
    @Test
    void testSetOnSingleElementList() {
        Integer newElement = 99;
        oneElementList.set(0, newElement);
        assertEquals(newElement, oneElementList.first(), "set(0, newElement) should update the first element.");
        assertEquals(1, oneElementList.size(), "Size should remain 1.");
    }

    @Test
    void testGetOnSingleElementList() {
        assertEquals(ELEMENT_A, oneElementList.get(0), "get(0) should return the correct element.");
    }
    
    @Test
    void testIndexOfOnSingleElementList() {
        assertEquals(0, oneElementList.indexOf(ELEMENT_A), "indexOf should find ELEMENT_A at index 0.");
        assertEquals(-1, oneElementList.indexOf(ELEMENT_X), "indexOf should return -1 for a non-existent element.");
    }

    

	/////////////////////////////////
	//XXX Tests for 2-element list
	/////////////////////////////////
	@Test
    void twoElementList() {
		assertThrows(NoException.class, () -> emptyList.addToFront(ELEMENT_X));
        assertThrows(NoException.class, () -> emptyList.addToRear(ELEMENT_X));
        assertThrows(NoException.class, () -> emptyList.addAfter(oneElmentList.first(), ELEMENT_X));
		assertThrows(NoException.class, () -> emptyList.addAfter(ELEMENT_X, ELEMENT_Z));
        assertThrows(NoException.class, () -> emptyList.add(ELEMENT_X));
        assertThrows(IndexOutOfBoundsException.class, () -> emptyList.add(-1, ELEMENT_X));
        assertThrows(NoException.class, () -> emptyList.add(0, ELEMENT_X));
		assertThrows(NoException.class, () -> emptyList.add(1, ELEMENT_X));
        assertThrows(IndexOutOfBoundsException.class, () -> emptyList.add(2, ELEMENT_X));
        assertEquals(emptyList.first(), () -> emptyList.removeFirst());
        assertEquals(emptyList.last(), () -> emptyList.removeLast());
        assertThrows(emptyList.last(), () -> emptyList.remove(emptyList.first()));
		assertThrows(NoSuchElementException.class, () -> emptyList.remove(ELEMENT_X));
        assertThrows(IndexOutOfBoundsException.class, () -> emptyList.remove(-1));
        assertThrows(emptyList.last(), () -> emptyList.remove(0));
		assertThrows(IndexOutOfBoundsException.class, () -> emptyList.remove(1));
        assertThrows(IndexOutOfBoundsException.class, () -> emptyList.set(-1, ELEMENT_X));
        assertThrows(NoException.class, () -> emptyList.set(0, ELEMENT_X));
		assertThrows(IndexOutOfBoundsException.class, () -> emptyList.set(1, ELEMENT_X));
        assertThrows(IndexOutOfBoundsException.class, () -> emptyList.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> emptyList.get(0));
		assertThrows(IndexOutOfBoundsException.class, () -> emptyList.get(1));
		assertEquals(0, () -> emptyList.indexOf(emptyList.last()));
        assertEquals(-1, () -> emptyList.indexOf(ELEMENT_X));
        assertThrows(emptyList.last(), () -> emptyList.first());
        assertThrows(emptyList.first(), () -> emptyList.last());
        assertEquals(true, () -> emptlyList.contains(emptyList.last()));
		assertEquals(false, () -> emptyList.contains(ELEMENT_X));
		assertEquals(false, () -> emptlyList.isEmpty());
		assertEquals(1, () -> emptlyList.size());
		assertEquals("[A]", () -> emptlyList.toString());
    }

    //////////////////////////////////
	//XXX Tests for 3-element list
	//////////////////////////////////
	@Test
    void threeElementList() {
		assertThrows(NoException.class, () -> emptyList.addToFront(ELEMENT_X));
        assertThrows(NoException.class, () -> emptyList.addToRear(ELEMENT_X));
        assertThrows(NoException.class, () -> emptyList.addAfter(oneElmentList.first(), ELEMENT_X));
		assertThrows(NoException.class, () -> emptyList.addAfter(ELEMENT_X, ELEMENT_Z));
        assertThrows(NoException.class, () -> emptyList.add(ELEMENT_X));
        assertThrows(IndexOutOfBoundsException.class, () -> emptyList.add(-1, ELEMENT_X));
        assertThrows(NoException.class, () -> emptyList.add(0, ELEMENT_X));
		assertThrows(NoException.class, () -> emptyList.add(1, ELEMENT_X));
        assertThrows(IndexOutOfBoundsException.class, () -> emptyList.add(2, ELEMENT_X));
        assertEquals(emptyList.first(), () -> emptyList.removeFirst());
        assertEquals(emptyList.last(), () -> emptyList.removeLast());
        assertThrows(emptyList.last(), () -> emptyList.remove(emptyList.first()));
		assertThrows(NoSuchElementException.class, () -> emptyList.remove(ELEMENT_X));
        assertThrows(IndexOutOfBoundsException.class, () -> emptyList.remove(-1));
        assertThrows(emptyList.last(), () -> emptyList.remove(0));
		assertThrows(IndexOutOfBoundsException.class, () -> emptyList.remove(1));
        assertThrows(IndexOutOfBoundsException.class, () -> emptyList.set(-1, ELEMENT_X));
        assertThrows(NoException.class, () -> emptyList.set(0, ELEMENT_X));
		assertThrows(IndexOutOfBoundsException.class, () -> emptyList.set(1, ELEMENT_X));
        assertThrows(IndexOutOfBoundsException.class, () -> emptyList.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> emptyList.get(0));
		assertThrows(IndexOutOfBoundsException.class, () -> emptyList.get(1));
		assertEquals(0, () -> emptyList.indexOf(emptyList.last()));
        assertEquals(-1, () -> emptyList.indexOf(ELEMENT_X));
        assertThrows(emptyList.last(), () -> emptyList.first());
        assertThrows(emptyList.first(), () -> emptyList.last());
        assertEquals(true, () -> emptlyList.contains(emptyList.last()));
		assertEquals(false, () -> emptyList.contains(ELEMENT_X));
		assertEquals(false, () -> emptlyList.isEmpty());
		assertEquals(1, () -> emptlyList.size());
		assertEquals("[A]", () -> emptlyList.toString());
    }
   
	

    /** Scenario #02: [] -> addToFront(A) -> [A] 
	 * @return [A] after addToFront(A)
	 */
	private IndexedUnsortedList<Integer> emptyList_addToFrontA_A() {
		IndexedUnsortedList<Integer> list = newList();
		list.addToFront(ELEMENT_A);
		return list;
	}
    
	
	/** Run all tests on scenarios resulting in a single element list
	 * @param scenario lambda reference to scenario builder method
	 * @param scenarioName name of the scenario being tested
	 * @param contents elements expected in the list after scenario has been set up
	 * @param contentsString contains character labels corresponding to values in contents
	 */
	private void testSingleElementList(Scenario<Integer> scenario, String scenarioName, Integer[] contents, String contentsString) {
		System.out.printf("\nSCENARIO: %s\n\n", scenarioName);
		try {
			// IndexedUnsortedList
			printTest(scenarioName + "_testAddToFront", testAddToFront(scenario.build(), ELEMENT_X, Result.NoException));
			printTest(scenarioName + "_testAddToRear", testAddToRear(scenario.build(), ELEMENT_X, Result.NoException));
			printTest(scenarioName + "_testAddAfter" + contentsString.charAt(0), testAddAfter(scenario.build(), contents[0], ELEMENT_X, Result.NoException));
			printTest(scenarioName + "_testAddAfterX", testAddAfter(scenario.build(), ELEMENT_X, ELEMENT_Z, Result.NoSuchElement));
			printTest(scenarioName + "_testAddAfterXA", testAddAfter(scenario.build(), ELEMENT_X, ELEMENT_A, Result.NoSuchElement));
			printTest(scenarioName + "_testAdd", testAdd(scenario.build(), ELEMENT_X, Result.NoException));
			printTest(scenarioName + "_testAddAtIndexNeg1", testAddAtIndex(scenario.build(), -1, ELEMENT_X, Result.IndexOutOfBounds));
			printTest(scenarioName + "_testAddAtIndex0", testAddAtIndex(scenario.build(), 0, ELEMENT_X, Result.NoException));
			printTest(scenarioName + "_testAddAtIndex1", testAddAtIndex(scenario.build(), 1, ELEMENT_X, Result.NoException));
			printTest(scenarioName + "_testAddAtIndex2", testAddAtIndex(scenario.build(), 2, ELEMENT_X, Result.IndexOutOfBounds));
			printTest(scenarioName + "_testRemoveFirst", testRemoveFirst(scenario.build(), contents[0], Result.MatchingValue));
			printTest(scenarioName + "_testRemoveLast", testRemoveLast(scenario.build(), contents[0], Result.MatchingValue));
			printTest(scenarioName + "_testRemove" + contentsString.charAt(0), testRemoveElement(scenario.build(), contents[0], Result.MatchingValue));
			printTest(scenarioName + "_testRemoveX", testRemoveElement(scenario.build(), ELEMENT_X, Result.NoSuchElement));
			printTest(scenarioName + "_testRemoveNeg1", testRemoveIndex(scenario.build(), -1, null, Result.IndexOutOfBounds));
			printTest(scenarioName + "_testRemove0", testRemoveIndex(scenario.build(), 0, contents[0], Result.MatchingValue));
			printTest(scenarioName + "_testRemove1", testRemoveIndex(scenario.build(), 1, null, Result.IndexOutOfBounds));
			printTest(scenarioName + "_testSetNeg1", testSet(scenario.build(), -1, ELEMENT_X, Result.IndexOutOfBounds));
			printTest(scenarioName + "_testSet0", testSet(scenario.build(), 0, ELEMENT_X, Result.NoException));
			printTest(scenarioName + "_testSet1", testSet(scenario.build(), 1, ELEMENT_X, Result.IndexOutOfBounds));
			printTest(scenarioName + "_testGetNeg1", testGet(scenario.build(), -1, null, Result.IndexOutOfBounds));
			printTest(scenarioName + "_testGet0", testGet(scenario.build(), 0, contents[0], Result.MatchingValue));
			printTest(scenarioName + "_testGet1", testGet(scenario.build(), 1, null, Result.IndexOutOfBounds));
			printTest(scenarioName + "_testIndexOf" + contentsString.charAt(0), testIndexOf(scenario.build(), contents[0], 0));
			printTest(scenarioName + "_testIndexOfX", testIndexOf(scenario.build(), ELEMENT_X, -1));
			printTest(scenarioName + "_testFirst", testFirst(scenario.build(), contents[0], Result.MatchingValue));
			printTest(scenarioName + "_testLast", testLast(scenario.build(), contents[0], Result.MatchingValue));
			printTest(scenarioName + "_testContains" + contentsString.charAt(0), testContains(scenario.build(), contents[0], Result.True));
			printTest(scenarioName + "_testContainsX", testContains(scenario.build(), ELEMENT_X, Result.False));
			printTest(scenarioName + "_testIsEmpty", testIsEmpty(scenario.build(), Result.False));
			printTest(scenarioName + "_testSize", testSize(scenario.build(), 1));
			printTest(scenarioName + "_testToString", testToString(scenario.build(), Result.ValidString));
	}
	private Scenario<Integer> emptyList_addToFrontA_A = () -> emptyList_addToFrontA_A();

	/** Scenario #03: [] -> addToRear(A) -> [A] 
	 * @return [A] after addToRear(A)
	 */
	private IndexedUnsortedList<Integer> emptyList_addToRearA_A() {
		IndexedUnsortedList<Integer> list = newList();
		list.addToRear(ELEMENT_A);
		return list;
	}
	private Scenario<Integer> emptyList_addToRearA_A = () -> emptyList_addToRearA_A();
	 
	/** Scenario #04: [] -> add(A) -> [A] 
	 * @return [A] after add(A)
	 */
	private IndexedUnsortedList<Integer> emptyList_addA_A() {
		IndexedUnsortedList<Integer> list = newList();
		list.add(ELEMENT_A);
		return list;
	}
	private Scenario<Integer> emptyList_addA_A = () -> emptyList_addA_A();
	/** Scenario #05: [] -> add(0, A) -> [A] 
	 * @return [A] after add(0, A)
	 */
	private IndexedUnsortedList<Integer> emptyList_add0A_A() {
		IndexedUnsortedList<Integer> list = newList();
		list.add(0,ELEMENT_A);
		return list;
	}
	private Scenario<Integer> emptyList_add0A_A = () -> emptyList_add0A_A();

	/** Scenario #06: [A] -> addToFront(B) -> [B,A] 
	 * @return [B,A] after addToFront(B)
	 */
	private IndexedUnsortedList<Integer> A_addToFrontB_BA() {
		IndexedUnsortedList<Integer> list = emptyList_addToFrontA_A(); 
		list.addToFront(ELEMENT_B);
		return list;
	}
    
	
	/** Run all tests on scenarios resulting in a two-element list
	 * @param scenario lambda reference to scenario builder method
	 * @param scenarioName name of the scenario being tested
	 * @param contents elements expected in the list after scenario has been set up
	 * @param contentsString contains character labels corresponding to values in contents 
	 */
	private void testTwoElementList(Scenario<Integer> scenario, String scenarioName, Integer[] contents, String contentsString) {
		System.out.printf("\nSCENARIO: %s\n\n", scenarioName);
		try {
			//TODO: tests for scenarios ending in a 2-element list
			printTest(scenarioName + "_testAddToFront", testAddToFront(scenario.build(), ELEMENT_X, Result.NoException));
			printTest(scenarioName + "_testAddToRear", testAddToRear(scenario.build(), ELEMENT_X, Result.NoException));
			printTest(scenarioName + "_testAddAfter" + contentsString.charAt(0), testAddAfter(scenario.build(), contents[0], ELEMENT_X, Result.NoException));
			printTest(scenarioName + "_testAddAfterX", testAddAfter(scenario.build(), ELEMENT_X, ELEMENT_Z, Result.NoSuchElement));
			printTest(scenarioName + "_testAddAfterXA", testAddAfter(scenario.build(), ELEMENT_X, ELEMENT_A, Result.NoSuchElement));
			printTest(scenarioName + "_testAddAfterXB", testAddAfter(scenario.build(), ELEMENT_X, ELEMENT_B, Result.NoSuchElement));
			printTest(scenarioName + "_testAdd", testAdd(scenario.build(), ELEMENT_X, Result.NoException));
			printTest(scenarioName + "_testAddAtIndexNeg1", testAddAtIndex(scenario.build(), -1, ELEMENT_X, Result.IndexOutOfBounds));
			printTest(scenarioName + "_testAddAtIndex0", testAddAtIndex(scenario.build(), 0, ELEMENT_X, Result.NoException));
			printTest(scenarioName + "_testAddAtIndex1", testAddAtIndex(scenario.build(), 1, ELEMENT_X, Result.NoException));
			printTest(scenarioName + "_testAddAtIndex2", testAddAtIndex(scenario.build(), 2, ELEMENT_X, Result.NoException));
			printTest(scenarioName + "_testAddAtIndex3", testAddAtIndex(scenario.build(), 3, ELEMENT_X, Result.IndexOutOfBounds));
			printTest(scenarioName + "_testRemoveFirst", testRemoveFirst(scenario.build(), contents[0], Result.MatchingValue));
			printTest(scenarioName + "_testRemoveLast", testRemoveLast(scenario.build(), contents[1], Result.MatchingValue));
			printTest(scenarioName + "_testRemove" + contentsString.charAt(0), testRemoveElement(scenario.build(), contents[0], Result.MatchingValue));
			printTest(scenarioName + "_testRemoveX", testRemoveElement(scenario.build(), ELEMENT_X, Result.NoSuchElement));
			printTest(scenarioName + "_testRemoveNeg1", testRemoveIndex(scenario.build(), -1, null, Result.IndexOutOfBounds));
			printTest(scenarioName + "_testRemove0", testRemoveIndex(scenario.build(), 0, contents[0], Result.MatchingValue));
			printTest(scenarioName + "_testRemove1", testRemoveIndex(scenario.build(), 1, contents[1], Result.MatchingValue));
			printTest(scenarioName + "_testRemove2", testRemoveIndex(scenario.build(), 2, null, Result.IndexOutOfBounds));
			printTest(scenarioName + "_testSetNeg1", testSet(scenario.build(), -1, ELEMENT_X, Result.IndexOutOfBounds));
			printTest(scenarioName + "_testSet0", testSet(scenario.build(), 0, ELEMENT_X, Result.NoException));
			printTest(scenarioName + "_testSet1", testSet(scenario.build(), 1, ELEMENT_X, Result.NoException));
			printTest(scenarioName + "_testSet2", testSet(scenario.build(), 2, ELEMENT_X, Result.IndexOutOfBounds));
			printTest(scenarioName + "_testGetNeg1", testGet(scenario.build(), -1, null, Result.IndexOutOfBounds));
			printTest(scenarioName + "_testGet0", testGet(scenario.build(), 0, contents[0], Result.MatchingValue));
			printTest(scenarioName + "_testGet1", testGet(scenario.build(), 1, contents[1], Result.MatchingValue));
			printTest(scenarioName + "_testGet2", testGet(scenario.build(), 2, null, Result.IndexOutOfBounds));
			printTest(scenarioName + "_testIndexOf" + contentsString.charAt(0), testIndexOf(scenario.build(), contents[0], 0));
			printTest(scenarioName + "_testIndexOfX", testIndexOf(scenario.build(), ELEMENT_X, -1));
			if (scenarioName == "A_addToFrontB_BA" || scenarioName == "A_addA_0B") {
				printTest(scenarioName + "_testIndexOfA", testIndexOf(scenario.build(), ELEMENT_A, 1));
				printTest(scenarioName + "_testIndexOfB", testIndexOf(scenario.build(), ELEMENT_B, 0));
			} else if (scenarioName == "ABC_removeFirst_BC" || scenarioName == "ABC_nextRemove_BC") {
				printTest(scenarioName + "_testIndexOfB", testIndexOf(scenario.build(), ELEMENT_B, 0));
				printTest(scenarioName + "_testIndexOfC", testIndexOf(scenario.build(), ELEMENT_C, 1));
			} else if (scenarioName == "ABC_listIterator2PreviousRemove_AC" || scenarioName == "ABC_remove1_AC" || scenarioName == "ABC_nextNextRemove_AC" || scenarioName == "ABC_listIterator1NextRemove_AC") {
				printTest(scenarioName + "_testIndexOfA", testIndexOf(scenario.build(), ELEMENT_A, 0));
				printTest(scenarioName + "_testIndexOfC", testIndexOf(scenario.build(), ELEMENT_C, 1));
			} else {
				printTest(scenarioName + "_testIndexOfA", testIndexOf(scenario.build(), ELEMENT_A, 0));
				printTest(scenarioName + "_testIndexOfB", testIndexOf(scenario.build(), ELEMENT_B, 1));
			}
			printTest(scenarioName + "_testFirst", testFirst(scenario.build(), contents[0], Result.MatchingValue));
			printTest(scenarioName + "_testLast", testLast(scenario.build(), contents[1], Result.MatchingValue));
			printTest(scenarioName + "_testContains" + contentsString.charAt(0), testContains(scenario.build(), contents[0], Result.True));
			printTest(scenarioName + "_testContainsX", testContains(scenario.build(), ELEMENT_X, Result.False));
			printTest(scenarioName + "_testIsEmpty", testIsEmpty(scenario.build(), Result.False));
			printTest(scenarioName + "_testSize", testSize(scenario.build(), 2));
			printTest(scenarioName + "_testToString", testToString(scenario.build(), Result.ValidString));

	}
	private Scenario<Integer> A_addToFrontB_BA = () -> A_addToFrontB_BA();

	/** Scenario #07: [A] -> addToRear(B) -> [A,B]
	 * @return [A,B] after addToRear(B)
	 */
	private IndexedUnsortedList<Integer> A_addToRearB_AB() {
		IndexedUnsortedList<Integer> list = emptyList_addToFrontA_A(); 
		list.addToRear(ELEMENT_B);
		return list;
	}
	private Scenario<Integer> A_addToRearB_AB = () -> A_addToRearB_AB();

	/** Scenario #10: [A] -> add(0,B) -> [B,A]
	 * @return [B,A] after add(0,B)
	 */
	private IndexedUnsortedList<Integer> A_addA_0B() {
		IndexedUnsortedList<Integer> list = emptyList_addToFrontA_A(); 
		list.add(0, ELEMENT_B);
		return list;
	}
	private Scenario<Integer> A_addA_0B = () -> A_addA_0B();

	/** Scenario #12: [A] -> removeFirst() -> []
	 * @return [] after removeFirst()
	 */
	private IndexedUnsortedList<Integer> A_removeFirst_emptyList() {
		IndexedUnsortedList<Integer> list = emptyList_addToFrontA_A(); 
		list.removeFirst();
		return list;
	}
	private Scenario<Integer> A_removeFirst_emptyList = () -> A_removeFirst_emptyList();


	/** Scenario #13: [A] -> removeLast() -> [] 
	 * @return [] after removeLast()
	 */
	private IndexedUnsortedList<Integer> A_removeLast_emptyList() {
		IndexedUnsortedList<Integer> list = emptyList_addToFrontA_A(); 
		list.removeLast();
		return list;
	}
	private Scenario<Integer> A_removeLast_emptyList = () -> A_removeLast_emptyList();


	/** Scenario #14: [A] -> remove(A) -> []
	 * @return [] after remove(A)
	 */
	private IndexedUnsortedList<Integer> A_removeA_emptyList() {
		IndexedUnsortedList<Integer> list = emptyList_addToFrontA_A(); 
		list.remove(ELEMENT_A);
		return list;
	}
	private Scenario<Integer> A_removeA_emptyList = () -> A_removeA_emptyList();


	/** Scenario #15: [A] -> remove(0) -> [] 
	 * @return [] after remove(0)
	 */
	private IndexedUnsortedList<Integer> A_remove0_emptyList() {
		IndexedUnsortedList<Integer> list = emptyList_addToFrontA_A(); 
		list.remove(0);
		return list;
	}
	private Scenario<Integer> A_remove0_emptyList = () -> A_remove0_emptyList();
	 
	/** Scenario #16: [A] -> set(0,B) -> [B] 
	 * @return [B] after set(0,B)
	 */
	private IndexedUnsortedList<Integer> A_set0B_B () {
		IndexedUnsortedList<Integer> list = emptyList_addToFrontA_A();
		list.set(0, ELEMENT_B);
		return list;
	}
	private Scenario<Integer> A_set0B_B = () -> A_set0B_B();
	 
	/** Scenario #17: [A,B] -> addToFront(C) -> [C,A,B] 
	 * @return [C,A,B] after addToFront(C)
	 */
	private IndexedUnsortedList<Integer> AB_addToFrontC_CAB() {
		IndexedUnsortedList<Integer> list = A_addToRearB_AB(); 
		list.addToFront(ELEMENT_C);
		return list;
	}
	private Scenario<Integer> AB_addToFrontC_CAB = () -> AB_addToFrontC_CAB();
	 
	/** Scenario #20: [A,B] -> addAfter(C,B) -> [A,B,C] 
	 * @return [A,B,C] after addAfter(C,B)
	 */
	private IndexedUnsortedList<Integer> AB_addAfterCB_ABC() {
		IndexedUnsortedList<Integer> list = A_addToRearB_AB(); 
		list.addAfter(ELEMENT_C, ELEMENT_B);
		return list;
	}
	private Scenario<Integer> AB_addAfterCB_ABC = () -> AB_addAfterCB_ABC();
	 
	/** Scenario #23: [A,B] -> add(1,C) -> [A,C,B] 
	 * @return [A,C,B] after add(1,C)
	 */
	private IndexedUnsortedList<Integer> AB_addAt1C_ACB() {
        IndexedUnsortedList<Integer> list = A_addToRearB_AB();
        list.add(1, ELEMENT_C);
        return list;
	}
	private Scenario<Integer> AB_addAt1C_ACB = () -> AB_addAt1C_ACB();
	 
	/** Scenario #25: [A,B] -> removeFirst() -> [B]
	 * @return [B] after removeFirst()
	 */
	private IndexedUnsortedList<Integer> AB_removeFirst_B() {
		IndexedUnsortedList<Integer> list = A_addToRearB_AB(); 
		list.removeFirst();
		return list;
	}
	private Scenario<Integer> AB_removeFirst_B = () -> AB_removeFirst_B();
	 
	/** Scenario #26: [A,B] -> removeLast() -> [A]
	 * @return [A] after removeLast()
	 */
	private IndexedUnsortedList<Integer> AB_removeLast_A() {
		IndexedUnsortedList<Integer> list = A_addToRearB_AB(); 
		list.removeLast();
		return list;
	}
	private Scenario<Integer> AB_removeLast_A = () -> AB_removeLast_A();
	 
	/** Scenario #27: [A,B] -> remove(A) -> [B]
	 * @return [B] after remove(A)
	 */
	private IndexedUnsortedList<Integer> AB_removeA_B() {
		IndexedUnsortedList<Integer> list = A_addToRearB_AB(); 
		list.remove(ELEMENT_A);
		return list;
	}
	private Scenario<Integer> AB_removeA_B = () -> AB_removeA_B();
	 
	/** Scenario #28: [A,B] -> remove(B) -> [A]
	 * @return [A] after remove(B)
	 */
	private IndexedUnsortedList<Integer> AB_removeB_A() {
		IndexedUnsortedList<Integer> list = A_addToRearB_AB(); 
		list.remove(ELEMENT_B);
		return list;
	}
	private Scenario<Integer> AB_removeB_A = () -> AB_removeB_A();
	 
	/** Scenario #29: [A,B] -> remove(0) -> [B]
	 * @return [B] after remove(0)
	 */
	private IndexedUnsortedList<Integer> AB_remove0_B() {
		IndexedUnsortedList<Integer> list = A_addToRearB_AB();
		list.remove(0);
		return list;
	}
	private Scenario<Integer> AB_remove0_B = () -> AB_remove0_B();
	 
	/** Scenario #30: [A,B] -> remove(1) -> [A]
	 * @return [A] after remove(1)
	 */
	private IndexedUnsortedList<Integer> AB_remove1_A() {
        IndexedUnsortedList<Integer> list = A_addToRearB_AB();
        list.remove(1);
        return list;
    }
    private Scenario<Integer> AB_remove1_A = () -> AB_remove1_A();
	 
	/** Scenario #33: [A,B,C] -> removeFirst() -> [B,C]
	 * @return [B,C] after removeFirst()
	 */
	private IndexedUnsortedList<Integer> ABC_removeFirst_BC(){
        IndexedUnsortedList<Integer> list = AB_addAfterCB_ABC();
        list.removeFirst();
        return list;
	}
    
	
	/** Run all tests on scenarios resulting in a three-element list
	 * @param scenario lambda reference to scenario builder method
	 * @param scenarioName name of the scenario being tested
	 * @param contents elements expected in the list after scenario has been set up
	 * @param contentsString contains character labels corresponding to values in contents 
	 */
	private void testThreeElementList(Scenario<Integer> scenario, String scenarioName, Integer[] contents, String contentsString) {
		System.out.printf("\nSCENARIO: %s\n\n", scenarioName);
		try {
			// IndexedUnsortedList
			printTest(scenarioName + "_testAddToFront", testAddToFront(scenario.build(), ELEMENT_X, Result.NoException));
			printTest(scenarioName + "_testAddToRear", testAddToRear(scenario.build(), ELEMENT_X, Result.NoException));
			printTest(scenarioName + "_testAddAfter" + contentsString.charAt(0), testAddAfter(scenario.build(), contents[0], ELEMENT_X, Result.NoException));			printTest(scenarioName + "_testAddAfterX", testAddAfter(scenario.build(), ELEMENT_X, ELEMENT_Z, Result.NoSuchElement));
			printTest(scenarioName + "_testAddAfterA", testAddAfter(scenario.build(), ELEMENT_X, ELEMENT_A, Result.NoSuchElement));
			printTest(scenarioName + "_testAddAfterB", testAddAfter(scenario.build(), ELEMENT_X, ELEMENT_B, Result.NoSuchElement));
			printTest(scenarioName + "_testAddAfterC", testAddAfter(scenario.build(), ELEMENT_X, ELEMENT_C, Result.NoSuchElement));
			printTest(scenarioName + "_testAdd", testAdd(scenario.build(), ELEMENT_X, Result.NoException));
			printTest(scenarioName + "_testAddAtIndexNeg1", testAddAtIndex(scenario.build(), -1, ELEMENT_X, Result.IndexOutOfBounds));
			printTest(scenarioName + "_testAddAtIndex0", testAddAtIndex(scenario.build(), 0, ELEMENT_X, Result.NoException));
			printTest(scenarioName + "_testAddAtIndex1", testAddAtIndex(scenario.build(), 1, ELEMENT_X, Result.NoException));
			printTest(scenarioName + "_testAddAtIndex2", testAddAtIndex(scenario.build(), 2, ELEMENT_X, Result.NoException));
			printTest(scenarioName + "_testAddAtIndex3", testAddAtIndex(scenario.build(), 3, ELEMENT_X, Result.NoException));
			printTest(scenarioName + "_testAddAtIndex4", testAddAtIndex(scenario.build(), 4, ELEMENT_X, Result.IndexOutOfBounds));
			printTest(scenarioName + "_testRemoveFirst", testRemoveFirst(scenario.build(), contents[0], Result.MatchingValue));
			printTest(scenarioName + "_testRemoveLast", testRemoveLast(scenario.build(), contents[2], Result.MatchingValue));
			printTest(scenarioName + "_testRemove" + contentsString.charAt(0), testRemoveElement(scenario.build(), contents[0], Result.MatchingValue));
			printTest(scenarioName + "_testRemoveX", testRemoveElement(scenario.build(), ELEMENT_X, Result.NoSuchElement));
			if (scenarioName == "AB_addToFront_CAB") {
				printTest(scenarioName + "_testRemoveA", testRemoveElement(scenario.build(), ELEMENT_A, Result.MatchingValue));
				printTest(scenarioName + "_testRemoveB", testRemoveElement(scenario.build(), ELEMENT_B, Result.MatchingValue));
				printTest(scenarioName + "_testRemoveC", testRemoveElement(scenario.build(), ELEMENT_C, Result.MatchingValue));
			} else if (scenarioName == "AB_addAt1C_ACB" || scenarioName == "AB_listIteratorNextAddC_ACB" || scenarioName == "AB_listIterator2PreviousAddC_ACB"){
				printTest(scenarioName + "_testRemoveA", testRemoveElement(scenario.build(), ELEMENT_A, Result.MatchingValue));
				printTest(scenarioName + "_testRemoveC", testRemoveElement(scenario.build(), ELEMENT_C, Result.MatchingValue));
				printTest(scenarioName + "_testRemoveB", testRemoveElement(scenario.build(), ELEMENT_B, Result.MatchingValue));
			} else if (scenarioName == "ABC_listIterator1NextSetD_ADC" || scenarioName == "ABC_listIterator2PreviousSetD_ADC") {
				printTest(scenarioName + "_testRemoveA", testRemoveElement(scenario.build(), ELEMENT_A, Result.MatchingValue));
				printTest(scenarioName + "_testRemoveC", testRemoveElement(scenario.build(), ELEMENT_C, Result.MatchingValue));
			} else {
				printTest(scenarioName + "_testRemoveB", testRemoveElement(scenario.build(), ELEMENT_B, Result.MatchingValue));
				printTest(scenarioName + "_testRemoveC", testRemoveElement(scenario.build(), ELEMENT_C, Result.MatchingValue));
			}
			printTest(scenarioName + "_testRemoveC", testRemoveElement(scenario.build(), ELEMENT_C, Result.MatchingValue));
			printTest(scenarioName + "_testRemoveNeg1", testRemoveIndex(scenario.build(), -1, null, Result.IndexOutOfBounds));
			printTest(scenarioName + "_testRemove0", testRemoveIndex(scenario.build(), 0, contents[0], Result.MatchingValue));
			printTest(scenarioName + "_testRemove1", testRemoveIndex(scenario.build(), 1, contents[1], Result.MatchingValue));
			printTest(scenarioName + "_testRemove2", testRemoveIndex(scenario.build(), 2, contents[2], Result.MatchingValue));
			printTest(scenarioName + "_testRemove3", testRemoveIndex(scenario.build(), 3, null, Result.IndexOutOfBounds));
			printTest(scenarioName + "_testSetNeg1", testSet(scenario.build(), -1, ELEMENT_X, Result.IndexOutOfBounds));
			printTest(scenarioName + "_testSet0", testSet(scenario.build(), 0, ELEMENT_X, Result.NoException));
			printTest(scenarioName + "_testSet1", testSet(scenario.build(), 1, ELEMENT_X, Result.NoException));
			printTest(scenarioName + "_testSet2", testSet(scenario.build(), 2, ELEMENT_X, Result.NoException));
			printTest(scenarioName + "_testSet3", testSet(scenario.build(), 3, ELEMENT_X, Result.IndexOutOfBounds));
			printTest(scenarioName + "_testGetNeg1", testGet(scenario.build(), -1, null, Result.IndexOutOfBounds));
			printTest(scenarioName + "_testGet0", testGet(scenario.build(), 0, contents[0], Result.MatchingValue));
			printTest(scenarioName + "_testGet1", testGet(scenario.build(), 1, contents[1], Result.MatchingValue));
			printTest(scenarioName + "_testGet2", testGet(scenario.build(), 2, contents[2], Result.MatchingValue));
			printTest(scenarioName + "_testGet3", testGet(scenario.build(), 3, null, Result.IndexOutOfBounds));
			printTest(scenarioName + "_testIndexOf" + contentsString.charAt(0), testIndexOf(scenario.build(), contents[0], 0));
			printTest(scenarioName + "_testIndexOfX", testIndexOf(scenario.build(), ELEMENT_X, -1));
			if (scenarioName == "AB_addToFront_CAB") {
				printTest(scenarioName + "_testIndexOfA", testIndexOf(scenario.build(), ELEMENT_A, 1));
				printTest(scenarioName + "_testIndexOfB", testIndexOf(scenario.build(), ELEMENT_B, 2));
				printTest(scenarioName + "_testIndexOfC", testIndexOf(scenario.build(), ELEMENT_C, 0));
			} else if (scenarioName == "AB_addAt1C_ACB" || scenarioName == "AB_listIteratorNextAddC_ACB" || scenarioName == "AB_listIterator2PreviousAddC_ACB"){
				printTest(scenarioName + "_testIndexOfA", testIndexOf(scenario.build(), ELEMENT_A, 0));
				printTest(scenarioName + "_testIndexOfC", testIndexOf(scenario.build(), ELEMENT_C, 1));
				printTest(scenarioName + "_testIndexOfB", testIndexOf(scenario.build(), ELEMENT_B, 2));
			} else if (scenarioName == "ABC_listIterator1NextSetD_ADC" || scenarioName == "ABC_listIterator2PreviousSetD_ADC") {
				printTest(scenarioName + "_testIndexOfA", testIndexOf(scenario.build(), ELEMENT_A, 0));
				printTest(scenarioName + "_testIndexOfC", testIndexOf(scenario.build(), ELEMENT_C, 2));
				printTest(scenarioName + "_testIndexOfD", testIndexOf(scenario.build(), ELEMENT_D, 1));
				printTest(scenarioName + "_testIndexOfB", testIndexOf(scenario.build(), ELEMENT_B, -1));
				printTest(scenarioName + "_testRemoveB", testRemoveElement(scenario.build(), ELEMENT_B, Result.NoSuchElement));
			} else {
				printTest(scenarioName + "_testIndexOfA", testIndexOf(scenario.build(), ELEMENT_A, 0));
				printTest(scenarioName + "_testIndexOfB", testIndexOf(scenario.build(), ELEMENT_B, 1));
				printTest(scenarioName + "_testIndexOfC", testIndexOf(scenario.build(), ELEMENT_C, 2));
			}
			printTest(scenarioName + "_testFirst", testFirst(scenario.build(), contents[0], Result.MatchingValue));
			printTest(scenarioName + "_testLast", testLast(scenario.build(), contents[2], Result.MatchingValue));
			printTest(scenarioName + "_testContains" + contentsString.charAt(0), testContains(scenario.build(), contents[0], Result.True));
			printTest(scenarioName + "_testContainsX", testContains(scenario.build(), ELEMENT_X, Result.False));
			if (scenarioName == "AB_addToFront_CAB") {
				printTest(scenarioName + "_testContainsA", testContains(scenario.build(), ELEMENT_A, Result.True));
				printTest(scenarioName + "_testContainsB", testContains(scenario.build(), ELEMENT_B, Result.True));
				printTest(scenarioName + "_testContainsC", testContains(scenario.build(), ELEMENT_C, Result.True));
			} else if (scenarioName == "AB_addAt1C_ACB" || scenarioName == "AB_listIteratorNextAddC_ACB" || scenarioName == "AB_listIterator2PreviousAddC_ACB"){
				printTest(scenarioName + "_testContainsA", testContains(scenario.build(), ELEMENT_A, Result.True));
				printTest(scenarioName + "_testContainsC", testContains(scenario.build(), ELEMENT_C, Result.True));
				printTest(scenarioName + "_testContainsB", testContains(scenario.build(), ELEMENT_B, Result.True));
			} else if (scenarioName == "ABC_listIterator1NextSetD_ADC" || scenarioName == "ABC_listIterator2PreviousSetD_ADC") {
				printTest(scenarioName + "_testIndexOfA", testIndexOf(scenario.build(), ELEMENT_A, 0));
				printTest(scenarioName + "_testContainsC", testContains(scenario.build(), ELEMENT_C, Result.True));
				printTest(scenarioName + "_testIndexOfD", testIndexOf(scenario.build(), ELEMENT_D, 1));
			} else {
				printTest(scenarioName + "_testContainsA", testContains(scenario.build(), ELEMENT_A, Result.True));
				printTest(scenarioName + "_testContainsB", testContains(scenario.build(), ELEMENT_B, Result.True));
				printTest(scenarioName + "_testContainsC", testContains(scenario.build(), ELEMENT_C, Result.True));
			}
			printTest(scenarioName + "_testIsEmpty", testIsEmpty(scenario.build(), Result.False));
			printTest(scenarioName + "_testSize", testSize(scenario.build(), 3));
			printTest(scenarioName + "_testToString", testToString(scenario.build(), Result.ValidString));
    }
     private Scenario<Integer> ABC_removeFirst_BC = () -> ABC_removeFirst_BC();
	 
	/** Scenario #37: [A,B,C] -> remove(C) -> [A,B]
	 * @return [A,B] after remove(C)
	 */
	private IndexedUnsortedList<Integer> ABC_removeC_AB() {
        IndexedUnsortedList<Integer> list = AB_addAfterCB_ABC(); 
        list.remove(ELEMENT_C);
        return list;
	}
	private Scenario<Integer> ABC_removeC_AB = () -> ABC_removeC_AB();
	 
	/** Scenario #39: [A,B,C] -> remove(1) -> [A,C]
	 * @return [A,C] after remove(1)
	 */
	private IndexedUnsortedList<Integer> ABC_remove1_AC() {
		IndexedUnsortedList<Integer> list = AB_addAfterCB_ABC(); 
		list.remove(1);
		return list;
	}
	private Scenario<Integer> ABC_remove1_AC = () -> ABC_remove1_AC();
	 
	/** Scenario #44: [A] -> iterator, next(), remove() -> []
	 * @return [] after iterator, next(), remove()
	 */
	private IndexedUnsortedList<Integer> A_nextRemove_emptyList() {
		IndexedUnsortedList<Integer> list = emptyList_addToFrontA_A();
		Iterator<Integer> iterator = list.listIterator();
		iterator.next();
		iterator.remove();
		return list;
		}
		private Scenario<Integer> A_nextRemove_emptyList = () -> A_nextRemove_emptyList();
	 
	/** Scenario #45: [A,B] -> iterator, next(), remove() -> [B]
	 * @return [B] after iterator, next(), remove()
	 */
	private IndexedUnsortedList<Integer> AB_nextRemove_B() {
		IndexedUnsortedList<Integer> list = A_addToRearB_AB();
		Iterator<Integer> iterator = list.listIterator();
		iterator.next();
		iterator.remove();
		return list;
		}
		private Scenario<Integer> AB_nextRemove_B = () -> AB_nextRemove_B();
	 
	/** Scenario #46: [A,B] -> iterator, next(), next(), remove() -> [A]
	 * @return [A] after iterator, next(), next(), remove()
	 */
	private IndexedUnsortedList<Integer> AB_nextNextRemove_A() {
		IndexedUnsortedList<Integer> list = A_addToRearB_AB();
		Iterator<Integer> iterator = list.listIterator();
		iterator.next();
		iterator.next();
		iterator.remove();
		return list;
		}
		private Scenario<Integer> AB_nextNextRemove_A = () -> AB_nextNextRemove_A();
	 
	/** Scenario #47: [A,B] -> iterator, next(), remove(), next(), remove() -> []
	 * @return [] after iterator, next(), remove(), next(), remove()
	 */
	private IndexedUnsortedList<Integer> AB_nextRemoveNextRemove_emptyList() {
		IndexedUnsortedList<Integer> list = A_addToRearB_AB();
		Iterator<Integer> iterator = list.listIterator();
		iterator.next();
		iterator.remove();
		iterator.next();
		iterator.remove();
		return list;
		}
		private Scenario<Integer> AB_nextRemoveNextRemove_emptyList = () -> AB_nextRemoveNextRemove_emptyList();
	 
	/** Scenario #48: [A,B,C] -> iterator, next(), remove() -> [B,C]
	 * @return [B,C] after iterator, next(), remove()
	 */
	private IndexedUnsortedList<Integer> ABC_nextRemove_BC() {
		IndexedUnsortedList<Integer> list = AB_addAfterCB_ABC();
		Iterator<Integer> iterator = list.listIterator();
		iterator.next();
		iterator.remove();
		return list;
		}
		private Scenario<Integer> ABC_nextRemove_BC = () -> ABC_nextRemove_BC();
	 
	/** Scenario #49: [A,B,C] -> iterator, next(), next(), remove() -> [A,C]
	 * @return [A,C] after iterator, next(), next(), remove()
	 */
	private IndexedUnsortedList<Integer> ABC_nextNextRemove_AC() {
		IndexedUnsortedList<Integer> list = AB_addAfterCB_ABC();
		Iterator<Integer> iterator = list.listIterator();
		iterator.next();
		iterator.next();
		iterator.remove();
		return list;
		}
		private Scenario<Integer> ABC_nextNextRemove_AC = () -> ABC_nextNextRemove_AC();
	 
	/** Scenario #50: [A,B,C] -> iterator, next(), next(), next(), remove() -> [A,B]
	 * @return [A,B] after iterator, next(), next(), next(), remove()
	 */
	private IndexedUnsortedList<Integer> ABC_nextNextNextRemove_AB() {
		IndexedUnsortedList<Integer> list = AB_addAfterCB_ABC();
		Iterator<Integer> iterator = list.listIterator();
		iterator.next();
		iterator.next();
		iterator.next();
		iterator.remove();
		return list;
		}
		private Scenario<Integer> ABC_nextNextNextRemove_AB = () -> ABC_nextNextNextRemove_AB();
	 
	/** Scenario #51: [A,B,C] -> iterator, next(), remove(), next(), remove() -> [C]
	 * @return [C] after iterator, next(), remove(), next(), remove()
	 */
	private IndexedUnsortedList<Integer> ABC_nextRemoveNextRemove_C() {
		IndexedUnsortedList<Integer> list = AB_addAfterCB_ABC();
		Iterator<Integer> iterator = list.listIterator();
		iterator.next();
		iterator.remove();
		iterator.next();
		iterator.remove();
		return list;
	}
	private Scenario<Integer> ABC_nextRemoveNextREmove_C  = () -> ABC_nextRemoveNextRemove_C();

	 	/** Scenario #52: [A,B,C] -> iterator, next(), remove(), next(), next(), remove() -> [B]
	 * @return [B] after iterator, next(), remove(), next(), next(), remove()
	 */
	private IndexedUnsortedList<Integer> ABC_nextRemoveNextNextNextRemove_B() {
		IndexedUnsortedList<Integer> list = AB_addAfterCB_ABC();
		Iterator<Integer> iterator = list.listIterator();
		iterator.next();
		iterator.remove();
		iterator.next();
		iterator.next();
		iterator.remove();
		return list;
	}
	private Scenario<Integer> ABC_nextRemoveNextNextNextRemove_B  = () -> ABC_nextRemoveNextNextNextRemove_B();

	 	/** Scenario #53: [A,B,C] -> iterator, next(), next(), remove(), next(), remove() -> [A]
	 * @return [A] after iterator, next(), next(), remove(), next(), remove()
	 */
	private IndexedUnsortedList<Integer> ABC_nextNextRemoveNextRemove_A() {
		IndexedUnsortedList<Integer> list = AB_addAfterCB_ABC();
		Iterator<Integer> iterator = list.listIterator();
		iterator.next();
		iterator.next();
		iterator.remove();
		iterator.next();
		iterator.remove();
		return list;
	}
	private Scenario<Integer> ABC_nextNextRemoveNextRemove_A  = () -> ABC_nextNextRemoveNextRemove_A();

	 
	/** Scenario #54: [A,B,C] -> iterator, next(), remove(), next(), remove(), next(), remove() -> []
	 * @return [] after iterator, next(), remove(), next(), remove(), next(), remove()
	 */
	private IndexedUnsortedList<Integer> ABC_nextRemoveNextRemoveNextRemove_emptyList() {
		IndexedUnsortedList<Integer> list = AB_addAfterCB_ABC();
		Iterator<Integer> iterator = list.listIterator();
		iterator.next();
		iterator.remove();
		iterator.next();
		iterator.remove();
		iterator.next();
		iterator.remove();
		return list;
	}
	private Scenario<Integer> ABC_nextRemoveNextRemoveNextRemove_emptyList  = () -> ABC_nextRemoveNextRemoveNextRemove_emptyList();

	/////////////////////////////////
	//XXX ListIterator Senarios
	/////////////////////////////////

	/*Scenario #57: [A,B] -> list-iterator(1),next(),remove() -> [A]
	 * @return 
	 */
    private IndexedUnsortedList<Integer> AB_listIterator1NextRemove_A() {
        IndexedUnsortedList<Integer> list = A_addToRearB_AB();
        ListIterator<Integer> iterator = list.listIterator(1);
        iterator.next();
        iterator.remove();
        return list;
    }
    private Scenario<Integer> AB_listIterator1NextRemove_A = () -> AB_listIterator1NextRemove_A();

    /* Scenario 60: [A,B,C] -> list-iterator(1),next(),remove() -> [A,C]
	 * @return 
	 */
    private IndexedUnsortedList<Integer> ABC_listIterator1NextRemove_AC() {
        IndexedUnsortedList<Integer> list = AB_addAfterCB_ABC();
        ListIterator<Integer> iterator = list.listIterator(1);
        iterator.next();
        iterator.remove();
        return list;
    }
    private Scenario<Integer> ABC_listIterator1NextRemove_AC = () -> ABC_listIterator1NextRemove_AC();
	
	/** Scenario #66: [A] -> list-iterator(1), previous(), remove() -> []
     * @return [] after iterator, previous(), remove(), 
	 */
  	private IndexedUnsortedList<Integer> A_listIterator1PreviousRemove_emptyList() {
		IndexedUnsortedList<Integer> list = emptyList_add0A_A();
		ListIterator<Integer> iterator = list.listIterator(1);
		iterator.previous();
		iterator.remove();
		return list;
	}
  	private Scenario<Integer> A_listIterator1PreviousRemove_emptyList = () -> A_listIterator1PreviousRemove_emptyList();
	
	/** Scenario #71: [A,B,C] -> list-iterator(2),previous(),remove() -> [A,C]
	 * @return [] after iterator, next(), remove(), next(), remove(), next(), remove()
	 */
	private IndexedUnsortedList<Integer> ABC_listIterator2PreviousRemove_AC() {
		IndexedUnsortedList<Integer> list = AB_addAfterCB_ABC();
		ListIterator<Integer> iterator = list.listIterator(2);
		iterator.previous();
		iterator.remove();
		return list;
	}
	private Scenario<Integer> ABC_listIterator2PreviousRemove_AC = () -> ABC_listIterator2PreviousRemove_AC();

	/** Scenario #87: [A,B] -> list-iterator(0),next(),add(C) -> [A,C,B]
     * @return [A,C,B] after iterator, previous(), remove(), 
	 */
	private IndexedUnsortedList<Integer> AB_listIteratorNextAddC_ACB() {
		IndexedUnsortedList<Integer> list = A_addToRearB_AB();
		ListIterator<Integer> iterator = list.listIterator();
		iterator.next();
		iterator.add(ELEMENT_C);
		return list;
	}
  	

	/*Scenario # 90 [A,B] -> list-iterator(2), previous(), add(C) -> [A,C,B]
 	 * 
	 */
	private IndexedUnsortedList<Integer> AB_listIterator2PreviousAddC_ACB() {
		IndexedUnsortedList<Integer> list = A_addToRearB_AB();
		ListIterator<Integer> iterator = list.listIterator(2);
		iterator.previous();
		iterator.add(ELEMENT_C);
		return list;
	}


	/*Scenario # 96 [A,B,C] -> list-iterator(1), next(), set(D) -> [A,D,C]
	 * 
	 */
	private IndexedUnsortedList<Integer> ABC_listIterator1NextSetD_ADC() {
		IndexedUnsortedList<Integer> list = AB_addAfterCB_ABC();
		ListIterator<Integer> iterator = list.listIterator(1);
		iterator.next();
		iterator.set(ELEMENT_D);
		return list;
	}


	/** Scenario #99: [A,B,C] -> list-iterator(2),previous(),set(D) -> [A,D,C]
	 * @return [] after iterator, next(), remove(), next(), remove(), next(), remove()
	 */
	private IndexedUnsortedList<Integer> ABC_listIterator2PreviousSetD_ADC() {
		IndexedUnsortedList<Integer> list = AB_addAfterCB_ABC();
		ListIterator<Integer> iterator = list.listIterator(2);
		iterator.previous();
		iterator.set(ELEMENT_D);
		return list;
	}
	


}