package net.chakramod.mod.util;

import java.util.Objects;

public enum ChakraType {
    HEART,
    THROAT,
    THIRD_EYE,
    CROWN,
    SOLAR_PLEXUS,
    SACRAL,
    ROOT,
    NONE;

    public static ChakraType getChakraTypeByString(String s) {
        if (Objects.equals(s, "heart")) {
            return HEART;
        }
        if (Objects.equals(s, "throat")) {
            return THROAT;
        }
        if (Objects.equals(s, "third_eye")) {
            return THIRD_EYE;
        }
        if (Objects.equals(s, "crown")) {
            return CROWN;
        }
        if (Objects.equals(s, "solar_plexus")) {
            return SOLAR_PLEXUS;
        }
        if (Objects.equals(s, "sacral")) {
            return SACRAL;
        }
        if (Objects.equals(s, "root")) {
            return ROOT;
        }
        return NONE;
    }
}
