package com.rodrigofreund.treinamento.springboot.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.rodrigofreund.treinamento.springboot.repository.model.Cliente;

@Repository
public interface ClienteRepository
        extends PagingAndSortingRepository<Cliente, Long>, JpaSpecificationExecutor<Cliente> {

}
