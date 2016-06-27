package twg2.collections.test;

import org.junit.Assert;
import org.junit.Test;

import twg2.collections.primitiveCollections.IntArrayList;
import twg2.collections.primitiveCollections.IntList;
import twg2.collections.uniqueCollection.UniqueIdGenerator;
import twg2.collections.uniqueCollection.UniqueIds;

public class UniqueIdGeneratorTest {


	@Test
	public void uniqueIdGeneratorTest() {
		UniqueIdGenerator unique = new UniqueIdGenerator();
		int count = 5;
		IntList ids = generateAndCheckIds(unique, count);

		Assert.assertTrue(unique.size() == count);
		Assert.assertTrue(ids.toArray().length == count);

		deleteIds(unique, count);
		ids.clear();
		Assert.assertTrue(unique.size() == 0);

		ids = generateAndCheckIds(unique, 3);
		deleteIds(unique, ids);
		Assert.assertTrue(unique.size() == 0);
	}


	public static IntList generateAndCheckIds(UniqueIds uniqueGen, int count) {
		IntArrayList ids = new IntArrayList();
		for(int i = 0; i < count; i++) {
			int id = uniqueGen.createId();
			Assert.assertTrue("contains newly added ID", uniqueGen.containsId(id));
			Assert.assertTrue(id > -1);
			ids.add(id);
		}
		return ids;
	}


	public static void deleteIds(UniqueIds uniqueSet, int count) {
		for(int i = 0; i < count; i++) {
			Assert.assertTrue(uniqueSet.deleteId(i));
		}
	}


	public static void deleteIds(UniqueIds uniqueSet, IntList ids) {
		for(int i = 0, size = ids.size(); i < size; i++) {
			int id = ids.get(i);
			Assert.assertTrue(uniqueSet.deleteId(id));
		}
	}

}
