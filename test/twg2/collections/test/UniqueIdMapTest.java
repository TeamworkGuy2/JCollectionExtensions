package twg2.collections.test;

import org.junit.Assert;
import org.junit.Test;

import twg2.collections.primitiveCollections.IntArrayList;
import twg2.collections.primitiveCollections.IntList;
import twg2.collections.uniqueCollection.UniqueIdMap;

/**
 * @author TeamworkGuy2
 * @since 2014-12-17
 */
public final class UniqueIdMapTest {


	@Test
	public void uniqueIdMapTest() {
		UniqueIdMap<String> unique = new UniqueIdMap<>();
		String[] values = { "thum", "val", "are", "cal", "wev" };
		IntList ids = addAndValidateIdValues(unique, values);
		int count = ids.size();

		Assert.assertTrue(unique.size() == count);
		Assert.assertTrue(ids.toArray().length == count);

		for(int i = 0; i < count; i++) {
			Assert.assertTrue(unique.deleteId(ids.get(i)).equals(values[i]));
		}
		ids.clear();

		Assert.assertTrue(unique.size() == 0);

		String[] values2 = { "a", "b" };
		ids = addAndValidateIdValues(unique, values2);

		Assert.assertTrue(unique.size() == values2.length);
	}


	public static <T1> IntList addAndValidateIdValues(UniqueIdMap<T1> uniqueMap, T1[] values) {
		IntArrayList ids = new IntArrayList();
		for(int i = 0, size = values.length; i < size; i++) {
			int id = uniqueMap.createId(values[i]);
			Assert.assertTrue("contains newly added ID", id > -1);
			Assert.assertEquals("contains newly added value '" + values[i] + "'", values[i], uniqueMap.get(id));
			ids.add(id);
		}
		return ids;
	}

}
