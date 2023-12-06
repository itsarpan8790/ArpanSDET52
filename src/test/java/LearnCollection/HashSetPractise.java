package LearnCollection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import org.apache.commons.collections4.iterators.ArrayListIterator;

public class HashSetPractise {
	public static void main(String[] args) {
		HashSet<Object> hs = new HashSet<Object>();
		hs.add("Arpan");
		hs.add(20);
		hs.add(null);
		hs.add(null);
		hs.add(null);
		hs.add("Duplicate1");
		hs.add("Duplicate2");
		hs.add("Duplicate1");
		hs.add("Duplicate2");
		hs.add(50);
		hs.add("Arpan");
		System.out.println("Printing Hashset Directly---> "+hs);

		ArrayList<Object> al = new ArrayList<Object>();
		al.add(10);
		al.add(10);
		al.add(null);
		al.add(null);

		System.out.println("ArrayList Directly Printing----> " + al);

		System.out.println("Printing through Iterator");
		Iterator<Object> it = al.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
