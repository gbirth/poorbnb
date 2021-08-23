package org.br.poorbnb.poorbnb.util;
import org.springframework.util.StringUtils;
import javax.management.AttributeNotFoundException;
import java.util.Arrays;

public final class ValidationUtils {

    private enum DESATIVADO {
        S, N
    }

    private ValidationUtils() { }

    public static String simOuNao(final String texto) throws AttributeNotFoundException {

        if (!StringUtils.hasText(texto)) {
            return ValidationUtils.DESATIVADO.N.name();
        }

        return Arrays.asList(ValidationUtils.DESATIVADO.values())
                .stream()
                .map(ValidationUtils.DESATIVADO::name)
                .filter(valor -> valor.equals(valor))
                .findFirst()
                .orElseThrow(AttributeNotFoundException::new);

    }
}
