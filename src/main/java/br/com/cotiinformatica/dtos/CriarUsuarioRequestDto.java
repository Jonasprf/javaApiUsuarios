package br.com.cotiinformatica.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CriarUsuarioRequestDto {

	@Size(min = 8, max = 150, message = "por favor informe de 8 a 150 caracteres.")
	@NotEmpty(message = "por favor , informa o nome do usuario")
	private String nome;

	@Email(message = "Por favor, informe um endereço de email válido.")
	@NotEmpty(message = "por favor , informa o email do usuario")
	private String email;

	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#\\$%\\^&\\*])(?=\\S+$).{8,}$",
			message = "Por favor, informe a senha com letras minúsculas, maiúsculas, números, símbolos e pelo menos 8 caracteres.")
	@NotEmpty(message = "por favor , informa a senha do usuario")
	private String senha;

}
