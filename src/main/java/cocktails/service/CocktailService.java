package cocktails.service;

import cocktails.model.Cocktail;
import cocktails.repository.CocktailRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CocktailService {

    private final CocktailRepository cocktailRepository;

    public CocktailService(CocktailRepository cocktailRepository) {
        this.cocktailRepository = cocktailRepository;
    }


    public List<Cocktail> findCocktailsByIngredient(String ingredient) {
       return cocktailRepository.findCocktailsByIngredient(ingredient);
    }

    public List<Cocktail> findAllCocktails() {
        return cocktailRepository.findAll();
    }
}
