package cl.pinolabs.chanchostore.web.restcontroller;

import cl.pinolabs.chanchostore.domain.dto.ClienteDTO;
import cl.pinolabs.chanchostore.domain.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ciente")
public class ClienteRestController {
    private final ClienteService service;

    public ClienteRestController(ClienteService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ClienteDTO>> findAll(){
        return service.findAll()
                .map(clientes -> new ResponseEntity<>(clientes, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/{idCliente}")
    public ResponseEntity<ClienteDTO> findById(@PathVariable("idCliente") int idCliente){
        return service.findById(idCliente)
                .map(clienteDTO -> new ResponseEntity<>(clienteDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<ClienteDTO> save(@RequestBody ClienteDTO clienteDTO){
        return new ResponseEntity<>(service.save(clienteDTO), HttpStatus.OK);
    }
    @DeleteMapping("/del/{idCliente}")
    public ResponseEntity delete(@PathVariable("idCliente") int idCliente){
        if (service.delete(idCliente)){
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
