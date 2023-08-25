package br.com.fiap.soat.techChallenge.usecases;
import br.com.fiap.soat.techChallenge.entities.Produto;
import br.com.fiap.soat.techChallenge.interfaces.gateways.ProdutoGatewayPort;
import br.com.fiap.soat.techChallenge.interfaces.usecases.ObterProdutosPorCategoriaUseCasePort;

import java.util.List;

public class ObterProdutosPorCategoriaUseCase implements ObterProdutosPorCategoriaUseCasePort {
    private final ProdutoGatewayPort produtoGatewayPort;

    public ObterProdutosPorCategoriaUseCase(ProdutoGatewayPort produtoGatewayPort) {

        this.produtoGatewayPort = produtoGatewayPort;
    }

    @Override
    public List<Produto> execute(Produto.TipoDeProduto categoria) {
        return produtoGatewayPort.obterProdutosPor(categoria);
    }
}