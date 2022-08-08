package cl.pinolabs.chanchostore.web.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class InicioController {

    Log logger = LogFactory.getLog(InicioController.class);
    @GetMapping
    public String inicio(){
        logger.info("Cargado y listo uwu");
        return "index";
    }

    @GetMapping("/test")
    public String test(){
        logger.info("pruebas");
        return "test";
    }

}
