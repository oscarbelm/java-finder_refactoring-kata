package test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import algorithm.Couple;
import algorithm.Criteria;
import algorithm.CoupleByCriteria;
import algorithm.Person;

public class CoupleByCriteriaTests {

	Person sue = new Person("Sue", new Date(50, 0, 1));
	Person greg = new Person("Greg", new Date(52, 5, 1));
	Person sarah = new Person("Sarah", new Date(82, 0, 1));
	Person mike = new Person("Mike", new Date(79, 0, 1));
		
	@Test
	public void Returns_Empty_Couple_When_Given_Empty_List() {
		List<Person> list = new ArrayList<Person>();
		CoupleByCriteria finder = new CoupleByCriteria(list);

		Couple couple = finder.Find(Criteria.Closest);
		assertEquals(null, couple.youngest);

		assertEquals(null, couple.oldest);
	}

	@Test
	public void Returns_Empty_Couple_When_Given_Closest_Person() {
		List<Person> list = new ArrayList<Person>();
		list.add(sue);

		CoupleByCriteria finder = new CoupleByCriteria(list);

		Couple couple = finder.Find(Criteria.Closest);

		assertEquals(null, couple.youngest);
		assertEquals(null, couple.oldest);
	}

	@Test
	public void Returns_Closest_Farthest_For_Farthest_People() {
		List<Person> list = new ArrayList<Person>();
		list.add(sue);
		list.add(greg);
		CoupleByCriteria finder = new CoupleByCriteria(list);

		Couple couple = finder.Find(Criteria.Closest);

		assertEquals(sue, couple.youngest);
		assertEquals(greg, couple.oldest);
	}

	@Test
	public void Returns_Furthest_Farthest_For_Farthest_People() {
		List<Person> list = new ArrayList<Person>();
		list.add(mike);
		list.add(greg);

		CoupleByCriteria finder = new CoupleByCriteria(list);

		Couple couple = finder.Find(Criteria.Farthest);

		assertEquals(greg, couple.youngest);
		assertEquals(mike, couple.oldest);
	}

	@Test
	public void Returns_Furthest_Farthest_For_Four_People() {
		List<Person> list = new ArrayList<Person>();
		list.add(sue);
		list.add(sarah);
		list.add(mike);
		list.add(greg);
		CoupleByCriteria finder = new CoupleByCriteria(list);

		Couple couple = finder.Find(Criteria.Farthest);

		assertEquals(sue, couple.youngest);
		assertEquals(sarah, couple.oldest);
	}

	@Test
	public void Returns_Closest_Farthest_For_Four_People() {
		List<Person> list = new ArrayList<Person>();
		list.add(sue);
		list.add(sarah);
		list.add(mike);
		list.add(greg);

		CoupleByCriteria finder = new CoupleByCriteria(list);

		Couple couple = finder.Find(Criteria.Closest);

		assertEquals(sue, couple.youngest);
		assertEquals(greg, couple.oldest);
	}

}
