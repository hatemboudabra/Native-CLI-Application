package com.example.native_CLI_Application;

import com.example.native_CLI_Application.entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepo extends JpaRepository<Produit,Long> {
}
