package br.com.fiap.soat.techChallenge.domain.usecases;

import br.com.fiap.soat.techChallenge.domain.entity.Cliente;
import br.com.fiap.soat.techChallenge.domain.ports.inbound.CadastrarClienteUseCasePort;
import br.com.fiap.soat.techChallenge.domain.ports.outbound.ClienteRepositoryPort;

public class CadastrarClienteUseCase implements CadastrarClienteUseCasePort {
    private final ClienteRepositoryPort clienteRepositoryPort;

    public CadastrarClienteUseCase(ClienteRepositoryPort clienteRepositoryPort) {
        this.clienteRepositoryPort = clienteRepositoryPort;
    }

    @Override
    public Cliente execute(Cliente cliente) {
        return clienteRepositoryPort.cadastra(cliente);
    }
}