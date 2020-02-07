package com.produtos.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;

@RestController
@RequestMapping(value="/api")
public class ProdutoResource {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@GetMapping(value="/produtos")
	public List<Produto> listaProduto(){
		return produtoRepository.findAll();
	}
	
	@GetMapping(value="/produto/{id}")
	public Produto listaProdutoUnico(@PathVariable(value="id") long id) {
		return produtoRepository.findById(id);
	}
	
	@PostMapping(value="/produto")
	public Produto salvaProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
	
	@DeleteMapping(value="/produto/delete/{id}")
	public void deletaProduto(@PathVariable(value="id") long id) {
		produtoRepository.delete(produtoRepository.findById(id));
	}
	
	@PutMapping(value="/produto/altera/{id}")
	public Produto alteraProduto(@RequestBody Produto produto, @PathVariable(value="id") long id) {
		Produto produtoNovo = produtoRepository.findById(id);
		return produtoRepository.save(produtoNovo);
	}

}
