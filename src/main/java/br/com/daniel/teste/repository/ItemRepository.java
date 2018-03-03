package br.com.daniel.teste.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.daniel.teste.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
