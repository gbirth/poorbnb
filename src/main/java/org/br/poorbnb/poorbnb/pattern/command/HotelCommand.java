package org.br.poorbnb.poorbnb.pattern.command;

import org.br.poorbnb.poorbnb.constant.HotelConstants;
import org.br.poorbnb.poorbnb.model.Hotel;
import org.br.poorbnb.poorbnb.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class HotelCommand {

    public HotelCommand() {
        super();
    }

    public Map<Condition, Handler> getCommanderOfHotel(Hotel hotel) {

        final Map<Condition, Handler> map = new HashMap<>();
        /* Ficara desse jeito até os serviços ficarem prontos, mas a ideia é que
            o handler seja um meio de se executar alguma ação proveniente de um serviço
            não padronizada para todas as condições
         */
        map.put((r) -> r >= HotelConstants.FOUR_AND_HALF,
                () -> System.out.println("deve conceber desconto"));
        map.put((r) -> r >= HotelConstants.THREE && r < HotelConstants.FOUR_AND_HALF,
                () -> System.out.println("Deve manter a precificacao"));
        map.put((r) -> r >= HotelConstants.ONE && r < HotelConstants.THREE,
                () -> System.out.println("será menos privilegiado na pesquisa"));
        map.put((r) -> r < HotelConstants.ONE, () -> System.out.println("sei la"));

        return map;
    }

}
