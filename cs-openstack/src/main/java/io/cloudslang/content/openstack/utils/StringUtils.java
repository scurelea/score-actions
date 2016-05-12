package io.cloudslang.content.openstack.utils;

import io.cloudslang.content.openstack.constants.ExceptionMessages;
import io.cloudslang.content.openstack.exceptions.CustomException;
import org.apache.commons.lang3.exception.ExceptionUtils;

import java.util.Locale;

public class StringUtils {
    public static String toRequiredString(String value, String inputName) throws CustomException {
        if (isBlank(value)) {
            throw new CustomException(String.format(ExceptionMessages.INPUT_EMPTY, inputName));
        }

        return value;
    }

    public static String toString(String value, String defaultValue) {
        if (isBlank(value)) {
            return defaultValue;
        }

        return value;
    }

    public static Integer toRequiredInt(String value, String inputName) throws CustomException {
        if (isBlank(value)) {
            throw new CustomException(String.format(ExceptionMessages.INPUT_EMPTY, inputName));
        }

        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new CustomException(String.format(ExceptionMessages.INPUT_NOT_NUMBER, inputName));
        }
    }

    public static Integer toInt(String value, Integer defaultValue, String inputName) throws CustomException {
        if (isBlank(value)) {
            return defaultValue;
        }

        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new CustomException(String.format(ExceptionMessages.INPUT_NOT_NUMBER, inputName));
        }
    }

    public static Boolean toBoolean(String value, Boolean defaultValue, String inputName) throws CustomException {
        if (isBlank(value)) {
            return defaultValue;
        }

        switch (value.toLowerCase(Locale.ENGLISH)) {
            case "true":
                return true;
            case "false":
                return false;
            default:
                throw new CustomException(String.format(ExceptionMessages.INPUT_NOT_BOOLEAN, inputName));
        }
    }

    public static <T extends Enum<T>> T toRequiredEnum(String value, Class<T> tClass, String inputName) throws CustomException {
        if (isBlank(value)) {
            throw new CustomException(String.format(ExceptionMessages.INPUT_EMPTY, inputName));
        }

        try {
            return T.valueOf(tClass, value);
        } catch (Exception e) {
            throw new CustomException(String.format(ExceptionMessages.INPUT_NOT_ENUM, inputName));
        }
    }

    public static <T extends Enum<T>> T toEnum(String value, Class<T> tClass, T defaultValue, String inputName) throws CustomException {
        if (isBlank(value)) {
            return defaultValue;
        }

        try {
            return T.valueOf(tClass, value);
        } catch (Exception e) {
            throw new CustomException(String.format(ExceptionMessages.INPUT_NOT_ENUM, inputName));
        }
    }

    public static String getStackTraceAsString(Throwable t) {
        return ExceptionUtils.getStackTrace(t);
    }

    public static boolean isBlank(String value) {
        if (value == null) {
            return true;
        }
        for (int i = 0; i < value.length(); i++) {
            if (!Character.isWhitespace(value.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNotBlank(String value) {
        return !isBlank(value);
    }
}
