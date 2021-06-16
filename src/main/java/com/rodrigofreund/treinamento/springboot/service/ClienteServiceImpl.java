package com.rodrigofreund.treinamento.springboot.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.rodrigofreund.treinamento.springboot.dto.CadastroClienteDto;
import com.rodrigofreund.treinamento.springboot.dto.out.ClienteDto;
import com.rodrigofreund.treinamento.springboot.exception.ClienteExistenteException;
import com.rodrigofreund.treinamento.springboot.exception.ClienteInexistenteException;
import com.rodrigofreund.treinamento.springboot.mapper.ClienteMapper;
import com.rodrigofreund.treinamento.springboot.repository.ClienteRepository;
import com.rodrigofreund.treinamento.springboot.repository.model.Cliente;
import com.rodrigofreund.treinamento.springboot.repository.model.FiltroCliente;

@Service
public class ClienteServiceImpl implements ClienteService {

    private ClienteRepository clienteRepository;
    private ClienteMapper clienteMapper;

    public ClienteServiceImpl(ClienteRepository clienteRepository, ClienteMapper clienteMapper) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
    }

    @Override
    public Page<ClienteDto> findByCriteria(FiltroCliente filtroCliente, Pageable pageable) {

        Page<Cliente> page = clienteRepository.findAll(new Specification<Cliente>() {
            private static final long serialVersionUID = 7493278212800313692L;

            @Override
            public Predicate toPredicate(Root<Cliente> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if(filtroCliente.pesquisaPorCpf()) {
                    predicates.add(criteriaBuilder.equal(root.get("cpf"), filtroCliente.getCpf()));
                }
                if (filtroCliente.pesquisaPorNome()) {
                    predicates.add(criteriaBuilder.like(root.get("nome"), "%" + filtroCliente.getNome() + "%"));
                }
                if (filtroCliente.pesquisaPorDataNascimento()) {
                    predicates
                            .add(criteriaBuilder.equal(root.get("dataNascimento"), filtroCliente.getDataNascimento()));
                }
                if (filtroCliente.pesquisaPorEstadoCivil()) {
                    predicates.add(criteriaBuilder.equal(root.get("estadoCivil"), filtroCliente.getEstadoCivil()));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        }, pageable);

        return page.map(c -> clienteMapper.convertToClienteDto(c, calcularIdade(c.getDataNascimento())));

    }

    public Page<ClienteDto> buscarTodos(Pageable pageable) {
        Page<Cliente> result = clienteRepository.findAll(pageable);

        Page<ClienteDto> converted = result
                .map(c -> clienteMapper.convertToClienteDto(c, calcularIdade(c.getDataNascimento())));

        return converted;
    }

    private Integer calcularIdade(LocalDate nascimento) {
        return Period.between(nascimento, LocalDate.now()).getYears();
    }

    @Override
    public boolean criarCliente(CadastroClienteDto dadosClienteDto) throws ClienteExistenteException {
        
        if(clienteRepository.existsById(dadosClienteDto.getCpf())) {
            throw new ClienteExistenteException();
        }
            
        clienteRepository.save(clienteMapper.convertToCliente(dadosClienteDto));
        
        return false;
    }

    @Override
    public boolean atualizarCliente(CadastroClienteDto dadosClienteDto) throws ClienteInexistenteException {
        
        if(!clienteRepository.existsById(dadosClienteDto.getCpf())) {
            throw new ClienteInexistenteException();
        }
            
        clienteRepository.save(clienteMapper.convertToCliente(dadosClienteDto));
        
        return false;
    }

}
