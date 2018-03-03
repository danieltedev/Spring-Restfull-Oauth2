package br.com.daniel.teste.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.daniel.teste.model.Item;
import br.com.daniel.teste.repository.ItemRepository;

@RestController
public class ItemResource {

	@Autowired
	private ItemRepository itemRepository;
	
	@GetMapping("/item")
	public List<Item> listar() {
		return this.itemRepository.findAll();
	}
}
