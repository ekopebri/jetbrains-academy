package numbers;

import java.util.List;
import java.util.Locale;

public enum NumberProperty {
    EVEN,
    ODD,
    BUZZ,
    DUCK,
    PALINDROMIC,
    GAPFUL,
    SPY,
    SQUARE,
    SUNNY,
    JUMPING,
    HAPPY,
    SAD;

    final static String[] wrongPairs = {
            "even odd",
            "duck spy",
            "sunny square",
            "ODD odd",
            "EVEN even",
            "SUNNY sunny",
            "SQUARE square",
            "DUCK duck",
            "SPY spy",
            "EVEN ODD",
            "DUCK SPY",
            "SUNNY SQUARE",
    };

    public static NumberProperty contains(String name) {
        NumberProperty result = null;
        for (NumberProperty prop : values()) {
            if (prop.name().equalsIgnoreCase(name)) {
                result = prop;
                break;
            }
        }

        return result;
    }

    public static void printAvailableProperties() {
        System.out.print("Available properties: [");
        int cnt=0;
        int length = values().length;
        for (NumberProperty prop : values()) {
            System.out.print(prop.name());
            if(++cnt<length) System.out.print(", ");
        }
        System.out.println("]");
    }

    public static boolean isWrong(List<String> filters) {
        int countPair = 0;
        for (String pair: NumberProperty.wrongPairs) {
            for (String filter : filters) {
                if (filter.contains("-")) {
                    filter = filter.replace("-", "").toUpperCase(Locale.ROOT);
                    if (pair.contains(filter)) {
                        countPair++;
                    }
                } else {
                    if (pair.contains(filter)) {
                        countPair++;
                    }
                }
            }
            if (countPair > 1) {
                break;
            }
            countPair = 0;
        }

        return countPair > 1;
    }

}
