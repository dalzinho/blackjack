package blackjack.deck;

import org.apache.commons.lang.StringUtils;

public class EnumUtil {

    public static String prettify(Enum<?> e) {
        return StringUtils.capitalize(e.toString().toLowerCase());
    }
}
