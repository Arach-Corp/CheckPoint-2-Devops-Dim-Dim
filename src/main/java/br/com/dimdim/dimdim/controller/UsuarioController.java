package br.com.dimdim.dimdim.controller;

import br.com.dimdim.dimdim.controller.dro.RegisterForm;
import br.com.dimdim.dimdim.entities.Usuario;
import br.com.dimdim.dimdim.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public String getUsuarios(Model model, @PageableDefault Pageable pageable) {
        final Page<Usuario> users = usuarioService.findAllUsuarios(pageable);

        int totalPages = users.getTotalPages();
        if (totalPages > 0){
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("registerForm", new RegisterForm());
        model.addAttribute("users", users);
        return "usuarios";
    }

    @PostMapping
    public String postUsuario(RegisterForm form, Model model){
        Usuario usuario = new Usuario();
        usuario.setNome(form.getName());
        usuario.setEmail(form.getEmail());
        usuario.setPassword(form.getPassword());
        usuario.setSaldo(BigDecimal.ZERO);
        usuarioService.register(usuario);
        return "redirect:usuarios";
    }




    @GetMapping("/{id}")
    public String profile(@PathVariable Long id, Model model) {
        Usuario usuario = usuarioService.findById(id);
        if (usuario == null){
            return "404";
        }
        model.addAttribute("user", usuario);
        return "usuario";
    }


    @GetMapping("/{id}/movimentacoes")
    public String modificacoes(@PathVariable Long id, @PageableDefault Pageable pageable) {
        return "usuario";
    }

    @PostMapping("/{id}/movimentacoes")
    public String criarMovimentacao(@PathVariable Long id) {
        return "usuario";
    }

    @GetMapping("/{id}/movimentacoes/{movimentacaoId")
    public String modificacao(@PathVariable Long id, @PathVariable Long movimentacaoId) {
        return "usuario";
    }
}

