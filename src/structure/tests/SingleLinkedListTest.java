package src.structure.tests;

import src.structure.generic.SingleLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;

public class SingleLinkedListTest {
	private SingleLinkedList<Integer> emptyList;
    private SingleLinkedList<Integer> singleElementList;
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

        singleElementList = new SingleLinkedList<>();
        singleElementList.add(ELEMENT_A);

		twoElementList = singleElementList;
        twoElementList.add(ELEMENT_B);

		threeElementList = twoElementList;
        threeElementList.add(ELEMENT_C);
    }


    /********************************************************************************************************************************************
	 * TESTS FOR 0-ELEMENT LIST
	 ********************************************************************************************************************************************/

	@Test
    void test_emptyList_state() {
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
		assertEquals("[1]", emptyList.toString(), "FAILED: toString() for addToFront() on emptyList");
    }

	@Test
    void test_addToRear_emptyList() {
        emptyList.addToRear(ELEMENT_A);

		assertFalse(emptyList.isEmpty(), "FAILED: isEmpty() for addToRear() on emptyList");
        assertEquals(1, emptyList.size(), "FAILED: size() for addToRear() on emptyList");
		assertEquals(ELEMENT_A, emptyList.first(), "FAILED: first() for addToRear() on emptyList");
		assertEquals(ELEMENT_A, emptyList.last(), "FAILED: last() for addToRear() on emptyList");
		assertEquals("[1]", emptyList.toString(), "FAILED: toString() for addToRear() on emptyList");
    }

	@Test
    void test_addAfter_emptyList() {
       assertThrows(NoSuchElementException.class, () -> emptyList.addAfter(ELEMENT_X, ELEMENT_Z));
    }

	@Test
    void test_addElement_emptyList() {
        emptyList.add(ELEMENT_A);

		assertFalse(emptyList.isEmpty(), "FAILED: isEmpty() for add() on emptyList");
        assertEquals(1, emptyList.size(), "FAILED: size() for add() on emptyList");
		assertEquals(ELEMENT_A, emptyList.first(), "FAILED: first() for add() on emptyList");
		assertEquals(ELEMENT_A, emptyList.last(), "FAILED: last() for add() on emptyList");
		assertEquals("[1]", emptyList.toString(), "FAILED: toString() for add() on emptyList");
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
		assertEquals("[1]", emptyList.toString(), "FAILED: toString() for add() on emptyList");
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
    void test_removeX_emptyList() {
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
    void test_indexOfX_emptyList() {
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
    void test_containsX_emptyList() {
        assertEquals(false, emptyList.contains(ELEMENT_X), "FAILED: contains() emptyList");
    }


    /********************************************************************************************************************************************
	 * TESTS FOR 1-ELEMENT LIST
	 ********************************************************************************************************************************************/

    @Test
    void test_singleElementList_state() {
        assertFalse(singleElementList.isEmpty(), "FAILED: isEmpty() on singleElementList");
        assertEquals(1, singleElementList.size(), "FAILED: size() on singleElementList");
		assertEquals(ELEMENT_A, singleElementList.first(), "FAILED: first() on singleElementList");
		assertEquals(ELEMENT_A, singleElementList.last(), "FAILED: last() on singleElementList");
        assertEquals("[1]", singleElementList.toString(), "FAILED: toString() on singleElementList");
    }

    @Test
    void test_addToFront_singleElementList() {
		singleElementList.addToFront(ELEMENT_B);

        assertFalse(singleElementList.isEmpty(), "FAILED: isEmpty() for addToFront() on singleElementList");
        assertEquals(2, singleElementList.size(), "FAILED: size() for addToFront() on singleElementList");
		assertEquals(ELEMENT_B, singleElementList.first(), "FAILED: first() for addToFront() on singleElementList");
		assertEquals(ELEMENT_A, singleElementList.last(), "FAILED: last() for addToFront() on singleElementList");
		assertEquals("[2, 1]", singleElementList.toString(), "FAILED: toString() for addToFront() on singleElementList");
    }

	@Test
    void test_addToRear_singleElementList() {
        singleElementList.addToRear(ELEMENT_B);

		assertFalse(singleElementList.isEmpty(), "FAILED: isEmpty() for addToRear() on singleElementList");
        assertEquals(2, singleElementList.size(), "FAILED: size() for addToRear() on emptyList");
		assertEquals(ELEMENT_A, singleElementList.first(), "FAILED: first() for addToRear() on singleElementList");
		assertEquals(ELEMENT_B, singleElementList.last(), "FAILED: last() for addToRear() on singleElementList");
		assertEquals("[1, 2]", singleElementList.toString(), "FAILED: toString() for addToRear() on singleElementList");
    }

	@Test
    void test_addAfter_singleElementList() {
		singleElementList.add(ELEMENT_B, ELEMENT_A);

		assertFalse(singleElementList.isEmpty(), "FAILED: isEmpty() for addAfter() on singleElementList");
        assertEquals(2, singleElementList.size(), "FAILED: size() for addAfter() on emptyList");
		assertEquals(ELEMENT_A, singleElementList.first(), "FAILED: first() for addAfter() on singleElementList");
		assertEquals(ELEMENT_B, singleElementList.last(), "FAILED: last() for addAfter() on singleElementList");
		assertEquals("[1, 2]", singleElementList.toString(), "FAILED: toString() for addAfter() on singleElementList");
    }

	@Test
    void test_addAfterX_singleElementList() {
       assertThrows(NoSuchElementException.class, () -> singleElementList.addAfter(ELEMENT_X, ELEMENT_Z));
    }

	@Test
    void test_addElement_singleElementList() {
        singleElementList.add(ELEMENT_B);

		assertFalse(singleElementList.isEmpty(), "FAILED: isEmpty() for add() on singleElementList");
        assertEquals(2, singleElementList.size(), "FAILED: size() for add() on emptyList");
		assertEquals(ELEMENT_A, singleElementList.first(), "FAILED: first() for add() on singleElementList");
		assertEquals(ELEMENT_B, singleElementList.last(), "FAILED: last() for add() on singleElementList");
		assertEquals("[1, 2]", singleElementList.toString(), "FAILED: toString() for add() on singleElementList");
    }

	@Test
    void test_addNeg1_singleElementList() {
        assertThrows(IndexOutOfBoundsException.class, () -> singleElementList.add(-1, ELEMENT_X));
    }

	 @Test
    void test_add0_singleElementList() {
        singleElementList.add(0, ELEMENT_B);

		assertFalse(singleElementList.isEmpty(), "FAILED: isEmpty() for add() on singleElementList");
        assertEquals(2, singleElementList.size(), "FAILED: size() for add() on singleElementList");
		assertEquals(ELEMENT_B, singleElementList.first(), "FAILED: first() for add() on singleElementList");
		assertEquals(ELEMENT_A, singleElementList.last(), "FAILED: last() for add() on singleElementList");
		assertEquals("[2, 1]", singleElementList.toString(), "FAILED: toString() for add() on singleElementList");
    }

	@Test
    void test_add1_singleElementList() {
       singleElementList.add(1, ELEMENT_B);
	   
	   assertFalse(singleElementList.isEmpty(), "FAILED: isEmpty() for add() on singleElementList");
	   assertEquals(2, singleElementList.size(), "FAILED: size() for add() on singleElementList");
	   assertEquals(ELEMENT_A, singleElementList.first(), "FAILED: first() for add() on singleElementList");
	   assertEquals(ELEMENT_B, singleElementList.last(), "FAILED: last() for add() on singleElementList");
	   assertEquals("[1, 2]", singleElementList.toString(), "FAILED: toString() for add() on singleElementList");
    }

	@Test
    void test_add2_singleElementList() {
        assertThrows(IndexOutOfBoundsException.class, () -> singleElementList.add(2, ELEMENT_X));
    }

    @Test
    void test_removeFirst_singleElementList() {
       assertEquals(ELEMENT_A, singleElementList.removeFirst(), "FAILED: removeFirst() on singleElementList");

	   assertTrue(singleElementList.isEmpty(), "FAILED: isEmpty() for removeFirst() on singleElementList");
	   assertEquals(0, singleElementList.size(), "FAILED: size() for removeFirst() on singleElementList");
	   assertEquals("[]", singleElementList.toString(), "FAILED: toString() for removeFirst() on singleElementList");
    }

	@Test
    void test_removeLast_singleElementList() {
       assertEquals(ELEMENT_A, singleElementList.removeLast(), "FAILED: removeLast() on singleElementList");

	   assertTrue(singleElementList.isEmpty(), "FAILED: isEmpty() for removeLast() on singleElementList");
	   assertEquals(0, singleElementList.size(), "FAILED: size() for removeLast() on singleElementList");
	   assertEquals("[]", singleElementList.toString(), "FAILED: toString() for removeLast() on singleElementList");
    }

    @Test
    void test_removeA_singleElementList() {
        assertEquals(ELEMENT_A, singleElementList.remove(ELEMENT_A), "FAILED: remove() on singleElementList");

		assertTrue(singleElementList.isEmpty(), "FAILED: isEmpty() for remove() on singleElementList");
		assertEquals(0, singleElementList.size(), "FAILED: size() for remove() on singleElementList");
		assertEquals("[]", singleElementList.toString(), "FAILED: toString() for remove() on singleElementList");
    }

	@Test
    void test_removeX_singleElementList() {
        assertThrows(NoSuchElementException.class, () -> singleElementList.remove(ELEMENT_X));
    }

    @Test
    void test_removeNeg1_singleElementList() {
        assertThrows(IndexOutOfBoundsException.class, () -> singleElementList.remove(-1));
    }

	@Test
    void test_remove0_singleElementList() {
		assertEquals(ELEMENT_A, singleElementList.remove(0), "FAILED: remove() on singleElementList");
		
		assertTrue(singleElementList.isEmpty(), "FAILED: isEmpty() for remove() on singleElementList");
		assertEquals(0, singleElementList.size(), "FAILED: size() for remove() on singleElementList");
		assertEquals("[]", singleElementList.toString(), "FAILED: toString() for remove() on singleElementList");
    }

	@Test
    void test_remove1_singleElementList() {
        assertThrows(IndexOutOfBoundsException.class, () -> singleElementList.remove(1));
    }

	@Test
    void test_setNeg1_singleElementList() {
        assertThrows(IndexOutOfBoundsException.class, () -> singleElementList.set(-1, ELEMENT_X));
    }

	@Test
    void test_set0_singleElementList() {
        singleElementList.set(0, ELEMENT_B);

		assertFalse(singleElementList.isEmpty(), "FAILED: isEmpty() for set() on singleElementList");
        assertEquals(1, singleElementList.size(), "FAILED: size() for set() on singleElementList");
		assertEquals(ELEMENT_B, singleElementList.first(), "FAILED: first() for set() on singleElementList");
		assertEquals(ELEMENT_B, singleElementList.last(), "FAILED: last() for set() on singleElementList");
		assertEquals("[2]", singleElementList.toString(), "FAILED: toString() for set() on singleElementList");
    }

	@Test
    void test_set1_singleElementList() {
        assertThrows(IndexOutOfBoundsException.class, () -> singleElementList.set(1, ELEMENT_X));
    }

	@Test
    void test_getNeg1_singleElementList() {
        assertThrows(IndexOutOfBoundsException.class, () -> singleElementList.get(-1));
    }

	@Test
    void test_get0_singleElementList() {
        assertEquals(ELEMENT_A, twoElementList.get(0));

		assertFalse(singleElementList.isEmpty(), "FAILED: isEmpty() for get() on singleElementList");
        assertEquals(1, singleElementList.size(), "FAILED: size() for get() on singleElementList");
		assertEquals(ELEMENT_A, singleElementList.first(), "FAILED: first() for get() on singleElementList");
		assertEquals(ELEMENT_A, singleElementList.last(), "FAILED: last() for get() on singleElementList");
        assertEquals("[1]", singleElementList.toString(), "FAILED: toString() for get() on singleElementList");
    }

	@Test
    void test_get1_singleElementList() {
        assertThrows(IndexOutOfBoundsException.class, () -> singleElementList.get(1));
    }

    @Test
    void test_indexOfA_singleElementList() {
		assertEquals(0, emptyList.indexOf(ELEMENT_A), "FAILED: indexOf() on singleElementList");

		assertFalse(singleElementList.isEmpty(), "FAILED: isEmpty() for indexOf() on singleElementList");
        assertEquals(1, singleElementList.size(), "FAILED: size() for indexOf() on singleElementList");
		assertEquals(ELEMENT_A, singleElementList.first(), "FAILED: first() for indexOf() on singleElementList");
		assertEquals(ELEMENT_A, singleElementList.last(), "FAILED: last() for indexOf() on singleElementList");
        assertEquals("[1]", singleElementList.toString(), "FAILED: toString() for indexOf() on singleElementList");
    }

	@Test
    void test_indexOfX_singleElementList() {
		assertEquals(-1, emptyList.indexOf(ELEMENT_X), "FAILED: indexOf() on singleElementList");
    }

	@Test
    void test_containsA_singleElementList() {
        assertEquals(emptyList.contains(ELEMENT_A), "FAILED: contains() singleElementList");

		assertFalse(singleElementList.isEmpty(), "FAILED: isEmpty() for contains() on singleElementList");
        assertEquals(1, singleElementList.size(), "FAILED: size() for contains() on singleElementList");
		assertEquals(ELEMENT_A, singleElementList.first(), "FAILED: first() for contains() on singleElementList");
		assertEquals(ELEMENT_A, singleElementList.last(), "FAILED: last() for contains() on singleElementList");
        assertEquals("[1]", singleElementList.toString(), "FAILED: toString() for contains() on singleElementList");
    }

	@Test
    void test_containsX_singleElementList() {
        assertEquals(false, emptyList.contains(ELEMENT_X), "FAILED: contains() singleElementList");
    }


	/********************************************************************************************************************************************
	 * TESTS FOR 2-ELEMENT LIST
	 ********************************************************************************************************************************************/

	@Test
    void test_twoElementList_state() {
        assertFalse(twoElementList.isEmpty(), "FAILED: isEmpty() on twoElementList");
        assertEquals(2, twoElementList.size(), "FAILED: size() on twoElementList");
		assertEquals(ELEMENT_A, twoElementList.first(), "FAILED: first() on twoElementList");
		assertEquals(ELEMENT_B, twoElementList.last(), "FAILED: last() on twoElementList");
        assertEquals("[1, 2]", twoElementList.toString(), "FAILED: toString() on twoElementList");
    }

    @Test
    void test_addToFront_twoElementList() {
		twoElementList.addToFront(ELEMENT_C);

        assertFalse(twoElementList.isEmpty(), "FAILED: isEmpty() for addToFront() on twoElementList");
        assertEquals(3, twoElementList.size(), "FAILED: size() for addToFront() on twoElementList");
		assertEquals(ELEMENT_C, twoElementList.first(), "FAILED: first() for addToFront() on twoElementList");
		assertEquals(ELEMENT_B, twoElementList.last(), "FAILED: last() for addToFront() on twoElementList");
		assertEquals("[3, 1, 2]", twoElementList.toString(), "FAILED: toString() for addToFront() on twoElementList");
    }

	@Test
    void test_addToRear_twoElementList() {
        twoElementList.addToRear(ELEMENT_C);

		assertFalse(twoElementList.isEmpty(), "FAILED: isEmpty() for addToRear() on twoElementList");
        assertEquals(3, twoElementList.size(), "FAILED: size() for addToRear() on emptyList");
		assertEquals(ELEMENT_A, twoElementList.first(), "FAILED: first() for addToRear() on twoElementList");
		assertEquals(ELEMENT_C, twoElementList.last(), "FAILED: last() for addToRear() on twoElementList");
		assertEquals("[1, 2, 3]", twoElementList.toString(), "FAILED: toString() for addToRear() on twoElementList");
    }

	@Test
    void test_addAfterA_twoElementList() {
		twoElementList.add(ELEMENT_C, ELEMENT_A);

		assertFalse(twoElementList.isEmpty(), "FAILED: isEmpty() for addAfter() on twoElementList");
        assertEquals(3, twoElementList.size(), "FAILED: size() for addAfter() on emptyList");
		assertEquals(ELEMENT_A, twoElementList.first(), "FAILED: first() for addAfter() on twoElementList");
		assertEquals(ELEMENT_B, twoElementList.last(), "FAILED: last() for addAfter() on twoElementList");
		assertEquals("[1, 3, 2]", twoElementList.toString(), "FAILED: toString() for addAfter() on twoElementList");
    }

	@Test
    void test_addAfterB_twoElementList() {
		twoElementList.add(ELEMENT_C, ELEMENT_B);

		assertFalse(twoElementList.isEmpty(), "FAILED: isEmpty() for addAfter() on twoElementList");
        assertEquals(3, twoElementList.size(), "FAILED: size() for addAfter() on emptyList");
		assertEquals(ELEMENT_A, twoElementList.first(), "FAILED: first() for addAfter() on twoElementList");
		assertEquals(ELEMENT_C, twoElementList.last(), "FAILED: last() for addAfter() on twoElementList");
		assertEquals("[1, 2, 3]", twoElementList.toString(), "FAILED: toString() for addAfter() on twoElementList");
    }

	@Test
    void test_addAfterX_twoElementList() {
       assertThrows(NoSuchElementException.class, () -> emptyList.addAfter(ELEMENT_X, ELEMENT_Z));
    }

	@Test
    void test_addElement_twoElementList() {
        twoElementList.add(ELEMENT_C);

		assertFalse(twoElementList.isEmpty(), "FAILED: isEmpty() for add() on twoElementList");
        assertEquals(3, twoElementList.size(), "FAILED: size() for add() on emptyList");
		assertEquals(ELEMENT_A, twoElementList.first(), "FAILED: first() for add() on twoElementList");
		assertEquals(ELEMENT_C, twoElementList.last(), "FAILED: last() for add() on twoElementList");
		assertEquals("[1, 2, 3]", twoElementList.toString(), "FAILED: toString() for add() on twoElementList");
    }

	@Test
    void test_addNeg1_twoElementList() {
        assertThrows(IndexOutOfBoundsException.class, () -> twoElementList.add(-1, ELEMENT_X));
    }

	@Test
    void test_add0_twoElementList() {
        twoElementList.add(0, ELEMENT_C);

		assertFalse(twoElementList.isEmpty(), "FAILED: isEmpty() for add() on twoElementList");
        assertEquals(3, twoElementList.size(), "FAILED: size() for add() on twoElementList");
		assertEquals(ELEMENT_C, twoElementList.first(), "FAILED: first() for add() on twoElementList");
		assertEquals(ELEMENT_B, twoElementList.last(), "FAILED: last() for add() on twoElementList");
		assertEquals("[3, 1, 2]", twoElementList.toString(), "FAILED: toString() for add() on twoElementList");
    }

	@Test
    void test_add1_twoElementList() {
       twoElementList.add(1, ELEMENT_C);
	   
	   assertFalse(twoElementList.isEmpty(), "FAILED: isEmpty() for add() on twoElementList");
	   assertEquals(3, twoElementList.size(), "FAILED: size() for add() on twoElementList");
	   assertEquals(ELEMENT_A, twoElementList.first(), "FAILED: first() for add() on twoElementList");
	   assertEquals(ELEMENT_B, twoElementList.last(), "FAILED: last() for add() on twoElementList");
	   assertEquals("[1, 3, 2]", twoElementList.toString(), "FAILED: toString() for add() on twoElementList");
    }

	@Test
    void test_add2_twoElementList() {
       twoElementList.add(2, ELEMENT_C);
	   
	   assertFalse(twoElementList.isEmpty(), "FAILED: isEmpty() for add() on twoElementList");
	   assertEquals(3, twoElementList.size(), "FAILED: size() for add() on twoElementList");
	   assertEquals(ELEMENT_A, twoElementList.first(), "FAILED: first() for add() on twoElementList");
	   assertEquals(ELEMENT_C, twoElementList.last(), "FAILED: last() for add() on twoElementList");
	   assertEquals("[1, 2, 3]", twoElementList.toString(), "FAILED: toString() for add() on twoElementList");
    }

	@Test
    void test_add3_twoElementList() {
        assertThrows(IndexOutOfBoundsException.class, () -> twoElementList.add(3, ELEMENT_X));
    }

    @Test
    void test_removeFirst_twoElementList() {
       assertEquals(ELEMENT_A, twoElementList.removeFirst(), "FAILED: removeFirst() on twoElementList");

	   assertFalse(twoElementList.isEmpty(), "FAILED: isEmpty() for removeFirst() on twoElementList");
	   assertEquals(1, twoElementList.size(), "FAILED: size() for removeFirst() on twoElementList");
	   assertEquals(ELEMENT_B, twoElementList.first(), "FAILED: first() for removeFirst() on twoElementList");
	   assertEquals(ELEMENT_B, twoElementList.last(), "FAILED: last() for removeFirst() on twoElementList");
	   assertEquals("[B]", twoElementList.toString(), "FAILED: toString() for removeFirst() on twoElementList");
    }

	@Test
    void test_removeLast_twoElementList() {
       assertEquals(ELEMENT_B, twoElementList.removeLast(), "FAILED: removeLast() on twoElementList");

	   assertFalse(twoElementList.isEmpty(), "FAILED: isEmpty() for removeLast() on twoElementList");
	   assertEquals(1, twoElementList.size(), "FAILED: size() for removeLast() on twoElementList");
       assertEquals(ELEMENT_A, twoElementList.first(), "FAILED: first() for removeLast() on twoElementList");
	   assertEquals(ELEMENT_A, twoElementList.last(), "FAILED: last() for removeLast() on twoElementList");
	   assertEquals("[A]", twoElementList.toString(), "FAILED: toString() for removeLast() on twoElementList");
    }

    @Test
    void test_removeA_twoElementList() {
        assertEquals(ELEMENT_A, twoElementList.remove(ELEMENT_A), "FAILED: remove() on twoElementList");

		assertTrue(twoElementList.isEmpty(), "FAILED: isEmpty() for remove() on twoElementList");
		assertEquals(1, twoElementList.size(), "FAILED: size() for remove() on twoElementList");
        assertEquals(ELEMENT_B, twoElementList.first(), "FAILED: first() for remove() on twoElementList");
        assertEquals(ELEMENT_B, twoElementList.last(), "FAILED: last() for remove() on twoElementList");
		assertEquals("[B]", twoElementList.toString(), "FAILED: toString() for remove() on twoElementList");
    }

	@Test
    void test_removeB_twoElementList() {
        assertEquals(ELEMENT_B, twoElementList.remove(ELEMENT_B), "FAILED: remove() on twoElementList");

		assertTrue(twoElementList.isEmpty(), "FAILED: isEmpty() for remove() on twoElementList");
		assertEquals(1, twoElementList.size(), "FAILED: size() for remove() on twoElementList");
        assertEquals(ELEMENT_A, twoElementList.first(), "FAILED: first() for remove() on twoElementList");
        assertEquals(ELEMENT_A, twoElementList.last(), "FAILED: last() for remove() on twoElementList");
		assertEquals("[A]", twoElementList.toString(), "FAILED: toString() for remove() on twoElementList");
    }

	@Test
    void test_removeX_twoElementList() {
        assertThrows(NoSuchElementException.class, () -> twoElementList.remove(ELEMENT_X));
    }

    @Test
    void test_removeNeg1_twoElementList() {
        assertThrows(IndexOutOfBoundsException.class, () -> twoElementList.remove(-1));
    }

	@Test
    void test_remove0_twoElementList() {
		assertEquals(ELEMENT_A, twoElementList.remove(0), "FAILED: remove() on twoElementList");
		
		assertTrue(twoElementList.isEmpty(), "FAILED: isEmpty() for remove() on twoElementList");
		assertEquals(1, twoElementList.size(), "FAILED: size() for remove() on twoElementList");
        assertEquals(ELEMENT_B, twoElementList.first(), "FAILED: first() for remove() on twoElementList");
        assertEquals(ELEMENT_B, twoElementList.last(), "FAILED: last() for remove() on twoElementList");
		assertEquals("[B]", twoElementList.toString(), "FAILED: toString() for remove() on twoElementList");
    }

	@Test
    void test_remove1_twoElementList() {
		assertEquals(ELEMENT_B, twoElementList.remove(1), "FAILED: remove() on twoElementList");
		
		assertTrue(twoElementList.isEmpty(), "FAILED: isEmpty() for remove() on twoElementList");
		assertEquals(1, twoElementList.size(), "FAILED: size() for remove() on twoElementList");
        assertEquals(ELEMENT_A, twoElementList.first(), "FAILED: first() for remove() on twoElementList");
        assertEquals(ELEMENT_A, twoElementList.last(), "FAILED: last() for remove() on twoElementList");
		assertEquals("[A]", twoElementList.toString(), "FAILED: toString() for remove() on twoElementList");
    }

	@Test
    void test_remove2_twoElementList() {
        assertThrows(IndexOutOfBoundsException.class, () -> twoElementList.remove(2));
    }

	@Test
    void test_setNeg1_twoElementList() {
        assertThrows(IndexOutOfBoundsException.class, () -> twoElementList.set(-1, ELEMENT_X));
    }

	@Test
    void test_set0_twoElementList() {
        twoElementList.set(0, ELEMENT_C);

		assertFalse(twoElementList.isEmpty(), "FAILED: isEmpty() for set() on twoElementList");
        assertEquals(2, twoElementList.size(), "FAILED: size() for set() on twoElementList");
		assertEquals(ELEMENT_C, twoElementList.first(), "FAILED: first() for set() on twoElementList");
		assertEquals(ELEMENT_B, twoElementList.last(), "FAILED: last() for set() on twoElementList");
		assertEquals("[3, 2]", twoElementList.toString(), "FAILED: toString() for set() on twoElementList");
    }

	@Test
    void test_set1_twoElementList() {
        twoElementList.set(1, ELEMENT_C);

		assertFalse(twoElementList.isEmpty(), "FAILED: isEmpty() for set() on twoElementList");
        assertEquals(2, twoElementList.size(), "FAILED: size() for set() on twoElementList");
		assertEquals(ELEMENT_B, twoElementList.first(), "FAILED: first() for set() on twoElementList");
		assertEquals(ELEMENT_C, twoElementList.last(), "FAILED: last() for set() on twoElementList");
		assertEquals("[1, 3]", twoElementList.toString(), "FAILED: toString() for set() on twoElementList");
    }

	@Test
    void test_set2_twoElementList() {
        assertThrows(IndexOutOfBoundsException.class, () -> twoElementList.set(1, ELEMENT_X));
    }

	@Test
    void test_getNeg1_twoElementList() {
        assertThrows(IndexOutOfBoundsException.class, () -> twoElementList.get(-1));
    }

	@Test
    void test_get0_twoElementList() {
        assertEquals(ELEMENT_A, twoElementList.get(0));

		assertFalse(twoElementList.isEmpty(), "FAILED: isEmpty() for get() on twoElementList");
        assertEquals(2, twoElementList.size(), "FAILED: size() for get() on twoElementList");
		assertEquals(ELEMENT_A, twoElementList.first(), "FAILED: first() for get() on twoElementList");
		assertEquals(ELEMENT_B, twoElementList.last(), "FAILED: last() for get() on twoElementList");
        assertEquals("[1, 2]", twoElementList.toString(), "FAILED: toString() for get() on twoElementList");
    }

	@Test
    void test_get1_twoElementList() {
        assertEquals(ELEMENT_B, twoElementList.get(1));

		assertFalse(twoElementList.isEmpty(), "FAILED: isEmpty() for get() on twoElementList");
        assertEquals(2, twoElementList.size(), "FAILED: size() for get() on twoElementList");
		assertEquals(ELEMENT_A, twoElementList.first(), "FAILED: first() for get() on twoElementList");
		assertEquals(ELEMENT_B, twoElementList.last(), "FAILED: last() for get() on twoElementList");
        assertEquals("[1, 2]", twoElementList.toString(), "FAILED: toString() for get() on twoElementList");
    }

	@Test
    void test_get2_twoElementList() {
        assertThrows(IndexOutOfBoundsException.class, () -> twoElementList.get(1));
    }

    @Test
    void test_indexOfA_twoElementList() {
		assertEquals(0, emptyList.indexOf(ELEMENT_A), "FAILED: indexOf() on twoElementList");

		assertFalse(twoElementList.isEmpty(), "FAILED: isEmpty() for indexOf() on twoElementList");
        assertEquals(1, twoElementList.size(), "FAILED: size() for indexOf() on twoElementList");
		assertEquals(ELEMENT_A, twoElementList.first(), "FAILED: first() for indexOf() on twoElementList");
		assertEquals(ELEMENT_B, twoElementList.last(), "FAILED: last() for indexOf() on twoElementList");
        assertEquals("[1, 2]", twoElementList.toString(), "FAILED: toString() for indexOf() on twoElementList");
    }

	@Test
    void test_indexOfB_twoElementList() {
		assertEquals(1, emptyList.indexOf(ELEMENT_A), "FAILED: indexOf() on twoElementList");

		assertFalse(twoElementList.isEmpty(), "FAILED: isEmpty() for indexOf() on twoElementList");
        assertEquals(1, twoElementList.size(), "FAILED: size() for indexOf() on twoElementList");
		assertEquals(ELEMENT_A, twoElementList.first(), "FAILED: first() for indexOf() on twoElementList");
		assertEquals(ELEMENT_A, twoElementList.last(), "FAILED: last() for indexOf() on twoElementList");
        assertEquals("[1]", twoElementList.toString(), "FAILED: toString() for indexOf() on twoElementList");
    }

	@Test
    void test_indexOfX_twoElementList() {
		assertEquals(-1, emptyList.indexOf(ELEMENT_X), "FAILED: indexOf() on twoElementList");
    }

	@Test
    void test_containsA_twoElementList() {
        assertEquals(emptyList.contains(ELEMENT_A), "FAILED: contains() twoElementList");

		assertFalse(twoElementList.isEmpty(), "FAILED: isEmpty() for contains() on twoElementList");
        assertEquals(2, twoElementList.size(), "FAILED: size() for contains() on twoElementList");
		assertEquals(ELEMENT_A, twoElementList.first(), "FAILED: first() for contains() on twoElementList");
		assertEquals(ELEMENT_B, twoElementList.last(), "FAILED: last() for contains() on twoElementList");
        assertEquals("[1, 2]", twoElementList.toString(), "FAILED: toString() for contains() on twoElementList");
    }

	@Test
    void test_containsB_twoElementList() {
        assertEquals(emptyList.contains(ELEMENT_B), "FAILED: contains() twoElementList");

		assertFalse(twoElementList.isEmpty(), "FAILED: isEmpty() for contains() on twoElementList");
        assertEquals(2, twoElementList.size(), "FAILED: size() for contains() on twoElementList");
		assertEquals(ELEMENT_A, twoElementList.first(), "FAILED: first() for contains() on twoElementList");
		assertEquals(ELEMENT_B, twoElementList.last(), "FAILED: last() for contains() on twoElementList");
        assertEquals("[1, 2]", twoElementList.toString(), "FAILED: toString() for contains() on twoElementList");
    }

	@Test
    void test_containsX_twoElementList() {
        assertEquals(false, emptyList.contains(ELEMENT_X), "FAILED: contains() twoElementList");
    }


    /********************************************************************************************************************************************
	 * TESTS FOR 3-ELEMENT LIST
	 ********************************************************************************************************************************************/

}