package br.com.fiap.soat.techChallenge.adapter.inbound;

import br.com.fiap.soat.techChallenge.adapter.inbound.request.PedidoRequest;
import br.com.fiap.soat.techChallenge.adapter.inbound.response.PedidoResponse;
import br.com.fiap.soat.techChallenge.core.domain.Pedido;
import br.com.fiap.soat.techChallenge.core.ports.inbound.FazerPedidoUseCasePort;
import br.com.fiap.soat.techChallenge.core.ports.inbound.ObterPedidosUseCasePort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PedidoController {

    private final FazerPedidoUseCasePort fazerPedidoUseCasePort;
    private final ObterPedidosUseCasePort obterPedidosUseCasePort;

    public PedidoController(FazerPedidoUseCasePort fazerPedidoUseCasePort, ObterPedidosUseCasePort obterPedidosUseCasePort) {
        this.fazerPedidoUseCasePort = fazerPedidoUseCasePort;
        this.obterPedidosUseCasePort = obterPedidosUseCasePort;
    }

    @PostMapping("/pedidos")
    public ResponseEntity<PedidoResponse> fazerPedido(@RequestBody PedidoRequest pedidoRequest) {
        Pedido pedido = fazerPedidoUseCasePort.execute(pedidoRequest.toDomain());
        PedidoResponse response = PedidoResponse.fromDomain(pedido);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/pedidos")
    public ResponseEntity<List<PedidoResponse>> obterPedidos() {
        List<Pedido> pedidos = obterPedidosUseCasePort.execute();
        List<PedidoResponse> response = pedidos.stream().map(PedidoResponse::fromDomain).collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }
}