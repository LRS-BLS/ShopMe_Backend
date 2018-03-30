package com.intive.shopme.util.validation.validation;

import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class LinkInTextValidator implements ConstraintValidator<LinkInTextCheck, String>{

    private UrlValidator urlValidator;

    private static final String HTTP = "http";
    private static final String HTTPS = "https";
    private static final String FTP = "ftp";
    private static final String FILE = "file";

    private static final String URL_REGEX = "((https?|ftp|file)://)?(www\\.)?[-a-zA-Z0-9+&@#/%?=~_|!:,.;]" +
            "*[-a-zA-Z0-9+&@#/%=~_|]\\.(pl|com|eu|de|uk|info|mail|biz|org|edu|net|pro|tk)";
    private static final Pattern URL_PATTERN = Pattern.compile(URL_REGEX, Pattern.CASE_INSENSITIVE);

    @Override
    public void initialize(LinkInTextCheck constraintAnnotation) {
        String[] schemas = {HTTP, HTTPS, FTP, FILE};
        urlValidator = new UrlValidator(schemas);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Matcher m = URL_PATTERN.matcher(value);

        if(m.find()) {
            String urlToValid = (m.group().substring(0, 4).contains("www.")) ? HTTP + "://" + m.group() : m.group();
            System.out.println(urlValidator.isValid(urlToValid));
            return urlValidator.isValid(urlToValid);
        } else return true;
    }
}
