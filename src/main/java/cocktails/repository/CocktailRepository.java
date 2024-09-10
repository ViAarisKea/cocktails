package cocktails.repository;

import cocktails.model.Cocktail;
import cocktails.model.Ingredient;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class CocktailRepository {

    private final List<Cocktail> cocktails;

    public CocktailRepository() {
        cocktails = Arrays.asList(new Cocktail("Bloody Mary",
                        Arrays.asList(new Ingredient("vodka"), new Ingredient("tomato juice"))),
                new Cocktail("Mojito",
                        Arrays.asList(new Ingredient("rum"), new Ingredient("mint"), new Ingredient("lime"))),
                new Cocktail("Pina Colada",
                        Arrays.asList(new Ingredient("rum"), new Ingredient("ananas juice"))),
                new Cocktail("Mai Tai",
                        Arrays.asList(new Ingredient("rum"), new Ingredient("lime"), new Ingredient("almond sirup")))

        );
    }

    public List<Cocktail> findAll() {
        return cocktails;
    }

    public List<Cocktail> findCocktailsByIngredient(String ingredient) {
        List<Cocktail> foundCocktails = new ArrayList<>();
        for(Cocktail cocktail : cocktails){
            for(Ingredient in : cocktail.getIngredients()){
                if(in.getName().toLowerCase().contains(ingredient.toLowerCase())){
                    foundCocktails.add(cocktail);
                }
            }
        }
        return foundCocktails;
    }
}
