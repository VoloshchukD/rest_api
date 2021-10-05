package com.epam.esm.service.util;

import java.util.Locale;
import java.util.ResourceBundle;

public final class ExceptionMessageConstants {

    public static final String CERTIFICATE_CODE = "01";

    public static final String TAG_CODE = "02";

    public static final String CERTIFICATE_ID_NOT_PRESENT_MESSAGE_NAME = "message.certificate-id-empty";

    public static final String TAG_ID_NOT_PRESENT_MESSAGE_NAME = "message.tag-id-empty";

    public static final String SOURCE_NAME = "local";

    public static String getMessageForLocale(String messageKey) {
        return ResourceBundle.getBundle(SOURCE_NAME, Locale.getDefault()).getString(messageKey);
    }

    private ExceptionMessageConstants() {
    }

}
