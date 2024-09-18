package com.iesjuanbosco.ejemploweb.controller;

import com.iesjuanbosco.ejemploweb.entity.Producto;
import com.iesjuanbosco.ejemploweb.repository.ProductoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller //Anotacion que le indica a Spring que esta clase es un controlador

public class ProductoController {

    //Para acceder al repositorio creamos una propiedad y le asignamos el constructor
    private ProductoRepository productoRepository;
    public ProductoController(ProductoRepository repository){
        this.productoRepository=repository;
    }

    //******ASI  NO SE HACE**************

    @GetMapping("/productos2")    //Anotacion que indica la URL localhost:8080/productos2 mediante GET
    @ResponseBody       //Anotacion que indica que no pase por el motor de plantillas thymelead sino que vpy a decolver el html directamente
    public String index(){
        List<Producto> productos=this.productoRepository.findAll();
        StringBuilder HTML = new StringBuilder("<html><body>");

        productos.forEach(producto-> {
            HTML.append("<p>" +producto.getTitulo() + "</p>");
        });
        HTML.append("</body></html>");
        return HTML.toString();
    }
    //**********************************


    /* Con la anotacion GetMapping le indicamos a Spring que el siguiente metodo
    se va a ejecutar cuando el ususario acceda a la url -> GET http://localhost/productos*/

    @GetMapping("/productos")
    public String findAll(Model model){
        List<Producto> productos=this.productoRepository.findAll();
        //Pasamos los datos a la vista
        model.addAttribute("producto",productos);
        return "producto-list";
    }
    /*La diferencia entre post y get es que get lo uso cuando quiero que me de algo y
     post lo uso cuando quiero introducirle algo*/

    @GetMapping("/productos/add")
    public String add(){
        List<Producto> productos = new ArrayList<Producto>();
        Producto p1= new Producto(null, "Producto 1", 20, 45.5);
        Producto p2= new Producto(null, "Producto 2", 50, 5.5);
        Producto p3= new Producto(null, "Producto 3", 10, 50.5);
        Producto p4= new Producto(null, "Producto 4", 30, 28.0);
        productos.add(p1);
        productos.add(p2);
        productos.add(p3);
        productos.add(p4);

        //Guardamos todos los productos en la base de datps utilizando el oobjeto productoRepository
        this.productoRepository.saveAll(productos);

        //Redirige al controlador /productos
        return "redirect:/productos";
    }
}
