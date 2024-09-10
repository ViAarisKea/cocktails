package cocktails.controller;

import cocktails.model.Cocktail;
import cocktails.model.Ingredient;
import cocktails.service.CocktailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
public class CocktailController {

    private final CocktailService cocktailService;

    public CocktailController(CocktailService cocktailService) {
        this.cocktailService = cocktailService;
    }

    @GetMapping("/")
    public String getAllCocktails(Model model){
        model.addAttribute("cocktails", cocktailService.findAllCocktails());
        return "cocktails";
    }

    @GetMapping("/search")
    public String searchForIngredient(Model model, @RequestParam String ingredient){
        List<Cocktail> foundCocktails = cocktailService.findCocktailsByIngredient(ingredient);
        model.addAttribute("cocktails", foundCocktails);
        return "cocktails";
    }


}
