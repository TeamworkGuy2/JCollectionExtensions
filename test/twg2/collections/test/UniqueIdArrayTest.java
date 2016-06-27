package twg2.collections.test;

import org.junit.Assert;
import org.junit.Test;

import twg2.collections.primitiveCollections.IntList;
import twg2.collections.uniqueCollection.UniqueIdArray;

public class UniqueIdArrayTest {


	@Test
	public void uniqueIdArrayTest() {
		UniqueIdArray unique = new UniqueIdArray();
		int count = 5;
		IntList ids = UniqueIdGeneratorTest.generateAndCheckIds(unique, count);

		Assert.assertTrue(unique.size() == count);
		Assert.assertTrue(ids.toArray().length == count);

		for(int i = 0; i < count; i++) {
			Assert.assertTrue(unique.deleteId(i));
		}
		ids.clear();

		Assert.assertTrue(unique.size() == 0);
	}

}
