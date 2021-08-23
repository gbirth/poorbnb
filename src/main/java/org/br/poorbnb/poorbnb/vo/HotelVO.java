package org.br.poorbnb.poorbnb.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.br.poorbnb.poorbnb.model.Hotel;
import org.br.poorbnb.poorbnb.model.Usuario;
import org.br.poorbnb.poorbnb.util.ValidationUtils;
import org.springframework.util.StringUtils;

import javax.management.AttributeNotFoundException;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
@NoArgsConstructor
public class HotelVO {

    @NotEmpty
    private String endereco;
    @NotEmpty
    private String nomeHotel;
    @NotEmpty
    private String telefone;
    @NotNull
    private Usuario idUsuario;
    private String telefoneOpcional;
    private String desativadoSN;

    public HotelVO(
                   final String endereco,
                   final String nomeHotel,
                   final String telefone,
                   final String telefoneOpcional,
                   final String desativadoSN,
                   final Usuario idUsuario
    ) throws AttributeNotFoundException {

        this.endereco = tornarMinusculo(endereco);
        this.nomeHotel = tornarMaiusculo(nomeHotel);
        this.telefone = validadorTelefone(telefone);
        this.telefoneOpcional = validadorTelefone(telefoneOpcional);
        this.desativadoSN = ValidationUtils.simOuNao(desativadoSN);
        this.idUsuario = idUsuario;
    }

    private String tornarMinusculo(final String texto) {
        return StringUtils.hasText(texto) ? texto.toLowerCase() : "";
    }

    private String tornarMaiusculo(final String texto) {
        return StringUtils.hasText(texto) ? texto.toUpperCase() : "";
    }

    private String validadorTelefone(final String telefone) throws AttributeNotFoundException {
        final String EXPREG = "/\\(?([0-9]{3})\\)?([ .-]?)([0-9]{3})\\2([0-9]{4})/";
        final Matcher matcher = obterExpressaoRegular(EXPREG, telefone);

        if (!StringUtils.hasText(telefone)
            || !matcher.matches()
            || telefone.length() < 8) {
            throw new AttributeNotFoundException(
                    String.format("O telefone %s não está no padrão correto", telefone)
            );
        }
        return telefone.stripTrailing();
    }

    private Matcher obterExpressaoRegular(final String regex, final String text) {
        final Pattern compile = Pattern.compile(regex);
        return compile.matcher(text);
    }

    public Hotel paraEntidade() {
        return new Hotel(this);
    }
}
