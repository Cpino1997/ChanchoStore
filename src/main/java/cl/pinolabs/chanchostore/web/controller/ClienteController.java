package cl.pinolabs.chanchostore.web.controller;

import cl.pinolabs.chanchostore.domain.dto.ClienteDTO;
import cl.pinolabs.chanchostore.domain.service.ClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@Controller
@RequestMapping("/cliente")
public class ClienteController {

        private final ClienteService service;
        public ClienteController(ClienteService service) {
            this.service = service;
        }

        @GetMapping("/all")
        public String findAll(Model model){
            model.addAttribute("clientes",
                    service.findAll()
                            .orElse(new ArrayList<ClienteDTO>()));
            return "clientesList";
        }

        @GetMapping("/{idCliente}")
        public String findById(@PathVariable("idCliente") int idCliente, Model model){
            model.addAttribute("cliente",
                    service.findById(idCliente)
                            .orElse(new ClienteDTO()));
            return "cliente";
        }

        @GetMapping("/new")
        public String create(){
            return "newCliente";
        }

        @GetMapping("/edit/{idCliente}")
        public String edit(@PathVariable("idCliente") int idCliente, Model model){
            model.addAttribute("cliente",
                    service.findById(idCliente)
                            .orElse(new ClienteDTO()));

            return "cliente";
        }
        @PostMapping("/save")
        public String save(@ModelAttribute ClienteDTO idCliente){
            service.save(idCliente);
            return "redirect:/cliente/all";
        }
        @GetMapping("/del/{idCliente}")
        public String delete(@PathVariable("idCliente") int idCliente){
            service.delete(idCliente);
            return "redirect:/cliente/all";
        }


}
