package med.voll.api.controller;


import jakarta.validation.Valid;
import med.voll.api.dominio.usuario.DadosAutenticacao;
import med.voll.api.dominio.usuario.Usuario;
import med.voll.api.infra.sycurity.DadosTokenJWT;
import med.voll.api.infra.sycurity.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {
    @Autowired
    private AuthenticationManager maneger;
    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao dados){
        var autenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
       var autentication= maneger.authenticate(autenticationToken);

    var tokenJWT = tokenService.gerarToken((Usuario) autentication.getPrincipal());

       return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }
}
