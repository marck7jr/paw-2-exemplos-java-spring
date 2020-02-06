package br.ufmt.webii.dweb2.dao;

import org.springframework.data.repository.CrudRepository;
import br.ufmt.webii.dweb2.models.Cliente;

public interface ClienteDAO extends CrudRepository<Cliente, Integer> {

}