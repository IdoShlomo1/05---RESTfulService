package johnbryce;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CatsController {

	private static ArrayList<Cat> allCats = new ArrayList<>();
	private static int idGenerator = 1;
	
	static {
		allCats.add(new Cat(idGenerator++, "Mitsi", 4));
		allCats.add(new Cat(idGenerator++, "Kitsi", 5));
		allCats.add(new Cat(idGenerator++, "Pitsi", 6));
		allCats.add(new Cat(idGenerator++, "Kipi", 6));
		allCats.add(new Cat(idGenerator++, "Pini", 6));
		allCats.add(new Cat(idGenerator++, "Lutra", 6));
		allCats.add(new Cat(idGenerator++, "Shmuli", 6));
		allCats.add(new Cat(idGenerator++, "Garfild", 6));
	}

	@GetMapping("cats") // "cats" = Route
	public ArrayList<Cat> getAllCats() {
		return allCats;
	}
	
	@GetMapping("cats/{id}") // "cats" = Route
	public Cat geCattById(@PathVariable("id") int id) {		
		return allCats.stream().filter(c->c.getId() == id).findFirst().get();
	}
}



