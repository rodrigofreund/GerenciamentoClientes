package com.rodrigofreund.treinamento.springboot.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.rodrigofreund.treinamento.springboot.dto.CadastroClienteDto;
import com.rodrigofreund.treinamento.springboot.dto.FiltroCliente;
import com.rodrigofreund.treinamento.springboot.dto.out.ClienteDto;
import com.rodrigofreund.treinamento.springboot.exception.ClienteExistenteException;
import com.rodrigofreund.treinamento.springboot.exception.ClienteInexistenteException;
import com.rodrigofreund.treinamento.springboot.mapper.ClienteMapper;
import com.rodrigofreund.treinamento.springboot.repository.ClienteRepository;
import com.rodrigofreund.treinamento.springboot.repository.model.Cliente;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    @Override
    public Page<ClienteDto> findByCriteria(FiltroCliente filtroCliente, Pageable pageable) {

        Page<Cliente> page = clienteRepository.findAll(new Specification<Cliente>() {
            private static final long serialVersionUID = 7493278212800313692L;

            @Override
            public Predicate toPredicate(Root<Cliente> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (filtroCliente.pesquisaPorCpf()) {
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

        return page.map(c -> clienteMapper.convertToClienteDto(c));

    }

    @Override
    public ClienteDto criarCliente(CadastroClienteDto dadosClienteDto) throws ClienteExistenteException {

        if (clienteRepository.existsById(dadosClienteDto.getCpf())) {
            throw new ClienteExistenteException();
        }

        //Tratar caso  ocorre erro ao salvar
        Cliente cliente = clienteRepository.save(clienteMapper.convertToCliente(dadosClienteDto));

        return clienteMapper.convertToClienteDto(cliente);
    }

    @Override
    public ClienteDto atualizarCliente(CadastroClienteDto dadosClienteDto) throws ClienteInexistenteException {

        Cliente clienteAnterior = clienteRepository.findById(dadosClienteDto.getCpf())
                .orElseThrow(ClienteInexistenteException::new);

        BeanUtils.copyProperties(dadosClienteDto, clienteAnterior);
        
        Cliente cliente = clienteRepository.save(clienteAnterior);

        return clienteMapper.convertToClienteDto(cliente);

    }

}
