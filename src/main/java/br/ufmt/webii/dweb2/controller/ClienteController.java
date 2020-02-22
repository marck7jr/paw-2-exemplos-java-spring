package br.ufmt.webii.dweb2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufmt.webii.dweb2.dao.ClienteDAO;
import br.ufmt.webii.dweb2.dao.EstadoDAO;
import br.ufmt.webii.dweb2.models.Cliente;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

    private Cliente cliente = new Cliente();

    @Autowired
    private ClienteDAO dao;

    @Autowired
    private EstadoDAO estadoDao;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("cliente", cliente);
        model.addAttribute("lista", dao.findAll());
        model.addAttribute("estados", estadoDao.findAll());

        return "cliente";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute("cliente") Cliente novo) {
        dao.save(novo);
        return "redirect:/cliente";
    }

    @GetMapping("/editar/{id}")
    public String editar(@ModelAttribute("id") int pk, Model model) {
        Cliente edit = dao.findById(pk).get();
        model.addAttribute("cliente", edit);
        model.addAttribute("lista", dao.findAll());
        model.addAttribute("estados", estadoDao.findAll());

        return "cliente";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@ModelAttribute("id") int pk) {
        dao.deleteById(pk);
        return "redirect:/cliente";
    }
}