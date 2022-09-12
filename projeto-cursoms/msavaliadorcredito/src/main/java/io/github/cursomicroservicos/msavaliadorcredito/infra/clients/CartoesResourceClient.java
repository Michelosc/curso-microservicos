package io.github.cursomicroservicos.msavaliadorcredito.infra.clients;

import io.github.cursomicroservicos.msavaliadorcredito.domain.model.Cartao;
import io.github.cursomicroservicos.msavaliadorcredito.domain.model.CartaoCLiente;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "mscartoes", path = "/cartoes")
public interface CartoesResourceClient {

    @GetMapping(params = "cpf")
    ResponseEntity<List<CartaoCLiente>> getCartoesByCliente(@RequestParam("cpf") String cpf);

    @GetMapping(params = "renda")
    ResponseEntity<List<Cartao>> getCartaoRendaAte(@RequestParam("renda") Long renda);
}
