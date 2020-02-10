package com.produtos.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST Produtos")
@CrossOrigin(origins = "*")
public class ProdutoResource {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@GetMapping(value="/produtos")
	@ApiOperation(value="Retorna uma lista de produtos")
	public List<Produto> listaProduto(){
		return produtoRepository.findAll();
	}
	
	@GetMapping(value="/produto/{id}")
	@ApiOperation(value="Retorna um produto pelo ID")
	public Produto listaProdutoUnico(@PathVariable(value="id") long id) {
		return produtoRepository.findById(id);
	}
	
	@PostMapping(value="/produto")
	@ApiOperation(value="Adiciona um produto")
	public Produto salvaProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
	
	@DeleteMapping(value="/produto/delete/{id}")
	@ApiOperation(value="Deleta um produto")
	public void deletaProduto(@PathVariable(value="id") long id) {
		produtoRepository.delete(produtoRepository.findById(id));
	}
	
	@PutMapping(value="/produto/altera/{id}")
	@ApiOperation(value="Altera um produto")
	public Produto alteraProduto(@RequestBody Produto produto, @PathVariable(value="id") long id) {
		Produto produtoNovo = produtoRepository.findById(id);
		return produtoRepository.save(produtoNovo);
	}

}
