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
	public void Returns_Empty_Results_When_Given_Empty_List() {
		List<Person> list = new ArrayList<Person>();
		CoupleByCriteria finder = new CoupleByCriteria(list);

		Couple result = finder.Find(Criteria.Closest);
		assertEquals(null, result.youngest);

		assertEquals(null, result.oldest);
	}

	@Test
	public void Returns_Empty_Results_When_Given_Closest_Person() {
		List<Person> list = new ArrayList<Person>();
		list.add(sue);

		CoupleByCriteria finder = new CoupleByCriteria(list);

		Couple result = finder.Find(Criteria.Closest);

		assertEquals(null, result.youngest);
		assertEquals(null, result.oldest);
	}

	@Test
	public void Returns_Closest_Farthest_For_Farthest_People() {
		List<Person> list = new ArrayList<Person>();
		list.add(sue);
		list.add(greg);
		CoupleByCriteria finder = new CoupleByCriteria(list);

		Couple result = finder.Find(Criteria.Closest);

		assertEquals(sue, result.youngest);
		assertEquals(greg, result.oldest);
	}

	@Test
	public void Returns_Furthest_Farthest_For_Farthest_People() {
		List<Person> list = new ArrayList<Person>();
		list.add(mike);
		list.add(greg);

		CoupleByCriteria finder = new CoupleByCriteria(list);

		Couple result = finder.Find(Criteria.Farthest);

		assertEquals(greg, result.youngest);
		assertEquals(mike, result.oldest);
	}

	@Test
	public void Returns_Furthest_Farthest_For_Four_People() {
		List<Person> list = new ArrayList<Person>();
		list.add(sue);
		list.add(sarah);
		list.add(mike);
		list.add(greg);
		CoupleByCriteria finder = new CoupleByCriteria(list);

		Couple result = finder.Find(Criteria.Farthest);

		assertEquals(sue, result.youngest);
		assertEquals(sarah, result.oldest);
	}

	@Test
	public void Returns_Closest_Farthest_For_Four_People() {
		List<Person> list = new ArrayList<Person>();
		list.add(sue);
		list.add(sarah);
		list.add(mike);
		list.add(greg);

		CoupleByCriteria finder = new CoupleByCriteria(list);

		Couple result = finder.Find(Criteria.Closest);

		assertEquals(sue, result.youngest);
		assertEquals(greg, result.oldest);
	}

}
