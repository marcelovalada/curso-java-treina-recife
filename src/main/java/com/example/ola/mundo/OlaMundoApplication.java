package com.example.ola.mundo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Usuario;

@SpringBootApplication
@RestController
public class OlaMundoApplication {

	public static void main(String[] args) {
		SpringApplication.run(OlaMundoApplication.class, args);
	}

	//página raiz! Pegando com método get
	@GetMapping("/")
	public String digaOla(){
		return "Ola mundo!";
	}

	// primeira forma de passar parametros! Através da URL com o método get
	//passamos chave(parametros) e o valor
	@GetMapping("/dale")
	public String digaDale(
		@RequestParam(name = "nome") String nome,//é obrigatório colocar o nome
		@RequestParam(name = "sobrenome") String sobrenome,//é obrigatório colocar o sobrenome
		@RequestParam(name = "estado", defaultValue = "PE") String estado,//é obrigatório, mas se não passar ele coloca como padrão o PE
		@RequestParam(name = "idade", required = false) Integer idade//não é obrigatório
	){
		return "Dale " + nome + " " + sobrenome + " de " + estado;
	}

	//Segunda forma de passar parametros também é pela url! Só passamos o valor! método get tb!
	@GetMapping("/Ola/{topico}/{subtopico}")
	public String digaDale2(
		@PathVariable(value = "topico") String nome,
		//Se colocou na rota, é obrigatório! não tem defaultValue nem required
		@PathVariable(value = "subtopico") String sobrenome) {
		return "Ola " + nome + " " + sobrenome;
		//@PathVariable(value = "topico") String qlqCoisa) {
		//return "Dale " + qlqCoisa;
	}

	//terceira forma é passando os parametros pelo body
	@PostMapping("/login")
	//@GetMapping("/login")
	public String fazerLogin(@RequestBody Usuario usuario){
		return "Usuario " + usuario.getEmail() + " fez login com senha: " + usuario.getSenha();
	}

}
