package algorithm;
import java.util.ArrayList;
import java.util.List;

public class CoupleByCriteria {
	private final List<Person> people;

	public CoupleByCriteria(List<Person> people) {
		this.people = people;
	}

	public Couple Find(Criteria criteria) {
		List<Couple> coupleCombinations = new ArrayList<Couple>();

		for (int i = 0; i < people.size() - 1; i++) {
			for (int j = i + 1; j < people.size(); j++) {
				Couple couple = new Couple();
				if (people.get(i).birthDate().getTime() < people.get(j).birthDate().getTime()) {
					couple.youngest = people.get(i);
					couple.oldest = people.get(j);
				} else {
					couple.youngest = people.get(j);
					couple.oldest = people.get(i);
				}
				couple.distance = couple.oldest.birthDate().getTime() - couple.youngest.birthDate().getTime();
				coupleCombinations.add(couple);
			}
		}

		if (coupleCombinations.size() < 1) {
			return new Couple();
		}

		Couple answer = coupleCombinations.get(0);
		for (Couple potentialResult : coupleCombinations) {
			switch (criteria) {
				case Closest :
					if (potentialResult.distance < answer.distance) {
						answer = potentialResult;
					}
					break;

				case Farthest :
					if (potentialResult.distance > answer.distance) {
						answer = potentialResult;
					}
					break;
			}
		}

		return answer;
	}

}
