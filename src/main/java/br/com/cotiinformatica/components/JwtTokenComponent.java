package br.com.cotiinformatica.components;

import java.util.Date;
import org.springframework.stereotype.Component;
import br.com.cotiinformatica.entities.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenComponent {
	/*
	 * Método para gerar os TOKENS JWT para os usuários autenticados
	 */
	public String generateToken(Usuario usuario) {

		// capturar a data atual do sistema
		var dataAtual = new Date();

		// gerando o token
		return Jwts.builder().setSubject(usuario.getEmail()) // identificação do usuário
				.setNotBefore(dataAtual) // data de geração do token
				.setExpiration(new Date(dataAtual.getTime() + 900000)) // tempo de expiração em 15min
				.signWith(SignatureAlgorithm.HS256, "b9e80864-d132-460a-a273-f302cedde365b9e80864-d132-460a-a273-f302cedde365") // assinatura do TOKEN
				.compact();
	}
}
