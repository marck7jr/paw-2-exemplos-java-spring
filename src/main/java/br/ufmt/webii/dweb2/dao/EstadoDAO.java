package br.ufmt.webii.dweb2.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.ufmt.webii.dweb2.models.Estado;

@Repository
public interface EstadoDAO extends CrudRepository<Estado, Integer> {

}