package com.example.native_CLI_Application;
import com.example.native_CLI_Application.entity.Categorie;
import com.example.native_CLI_Application.entity.Produit;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ShellComponent
public class MyCustomCommand {
    private ProduitRepo produitRepo;

    public MyCustomCommand(ProduitRepo produitRepo) {
        this.produitRepo=produitRepo;
    }
    @ShellMethod(key = "hello")
    public String hello(@ShellOption(defaultValue = "me") String name,
                        @ShellOption(defaultValue = "1") int counter){
        StringBuilder stringBuilder= new StringBuilder();
        for (int i = 0; i < counter; i++) {
            stringBuilder.append("Hello "+name+" iteration "+i+" \n");
        }
        return stringBuilder.toString();
    }
    @ShellMethod(key = "test")
    public String test(){
        return "Test Shell";
    }
    @ShellMethod(key = "add")
    public String add(@ShellOption(defaultValue = "unknown") String name,
                      @ShellOption(defaultValue = "0") double price, @ShellOption(defaultValue = "unknown")Categorie categorie){
        Produit produit = produitRepo.save(Produit.builder()
                .name(name).price(price) .categorie(categorie)
                .build());
        return produit.toString();
    }
    @ShellMethod(key="findById")
    public String find(@ShellOption(defaultValue = "1") Long id){
        Optional<Produit> product = produitRepo.findById(id);
        if (product.isPresent()) return product.get().toString();
        else return "Product not found => "+id;
    }
    @ShellMethod(key="findAll")
    public String findAll() {
        List<Produit> products = produitRepo.findAll();
        if (products.isEmpty()) {
            return "No products found";
        }
        return products.stream()
                .map(Produit::toString)
                .collect(Collectors.joining("\n"));
    }
    @ShellMethod(key = "deleteById")
    public String delete(@ShellOption (defaultValue = "1") Long id){
        produitRepo.deleteById(id);
        return "Deleted produit";
    }
    @ShellMethod(key = "findcat")
    public List<Produit> findProductsByCategory(String categorieName) {
        Categorie categorie;
        try {
            categorie = Categorie.valueOf(categorieName.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid category: " + categorieName);
        }
        return produitRepo.findByCategorie(categorie);
    }
}
