package br.com.fiap.soat.techChallenge.api;

import br.com.fiap.soat.techChallenge.api.requests.PedidoRequest;
import br.com.fiap.soat.techChallenge.controllers.PedidoController;
import br.com.fiap.soat.techChallenge.entities.StatusDoPedido;
import br.com.fiap.soat.techChallenge.presenters.PedidoPresenter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class PedidoApi {

    private final PedidoController pedidoController;

    public PedidoApi(PedidoController pedidoController) {
        this.pedidoController = pedidoController;
    }

    @PostMapping("/pedidos")
    public ResponseEntity<PedidoPresenter> fazerCheckoutPedido(@RequestBody PedidoRequest pedidoRequest) {
        return ResponseEntity.ok(pedidoController.fazerCheckoutPedido(pedidoRequest.toDomain()));
    }

    @GetMapping("/pedidos")
    public ResponseEntity<List<PedidoPresenter>> obterPedidos(@RequestParam(name = "status", required = false) StatusDoPedido[] statuses) {
        List<PedidoPresenter> pedidos;

        if (statuses != null && statuses.length > 0) {
            pedidos = pedidoController.obterPedidosPorStatus(statuses);
        } else {
            pedidos = pedidoController.obterTodosPedidos();
        }

        return ResponseEntity.ok(pedidos);
    }

    @PutMapping("/pedidos/{pedidoId}/{statusDoPedido}")
    public ResponseEntity<PedidoPresenter> atualizarStatusPedido(@PathVariable UUID pedidoId, @PathVariable StatusDoPedido statusDoPedido) {
        return ResponseEntity.ok(pedidoController.atualizarStatusPedido(pedidoId, statusDoPedido));
    }
}

