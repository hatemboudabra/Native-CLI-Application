package com.example.native_CLI_Application;

import com.example.native_CLI_Application.entity.Categorie;
import com.example.native_CLI_Application.entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProduitRepo extends JpaRepository<Produit,Long> {
    public List<Produit> findByCategorie(Categorie categorie);
}
