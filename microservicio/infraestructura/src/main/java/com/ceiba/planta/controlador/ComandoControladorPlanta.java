package com.ceiba.planta.controlador;



import com.ceiba.ComandoRespuesta;
import com.ceiba.planta.comando.ComandoPlanta;
import com.ceiba.planta.comando.manejador.ManejadorCrearPlanta;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apiPlanta")
@CrossOrigin(origins = "http://localhost:4200")
public class ComandoControladorPlanta {

    private final ManejadorCrearPlanta manejadorCrearPlanta;

    public ComandoControladorPlanta(ManejadorCrearPlanta manejadorCrearPlanta) {
        this.manejadorCrearPlanta = manejadorCrearPlanta;
    }
//    @Autowired
//    public ComandoControladorPlanta(ManejadorCrearPlanta manejadorCrearPlanta) {
//        this.manejadorCrearPlanta = manejadorCrearPlanta;
//    }

//    @Autowired
//    private RepositorioPlantaMysql servicioPlanta;

//    @GetMapping({"/planta/{id}"})
//    public Planta buscarTodos(@PathVariable("id") int idPlanta) {
//        return servicioPlanta.buscarPlantaPorID(idPlanta);
//    }
//
    @PostMapping("/planta")
    public ComandoRespuesta<Integer> crear(@RequestBody ComandoPlanta comandoPlanta) {
        return manejadorCrearPlanta.ejecutar(comandoPlanta);
    }


//    @Autowired
//    private RepositorioPlanta servicioPlanta;
//
//    @GetMapping("/index")
//    public List<Planta> buscarTodos(){
//        System.out.println("Entro al controlador = " );
//        return servicioPlanta.buscarTodos();
//    }
//
//    @PostMapping("/planta")
//    public Planta guardar(@RequestBody Planta planta){
//        servicioPlanta.guardar(planta);
//        return planta;
//    }

}
