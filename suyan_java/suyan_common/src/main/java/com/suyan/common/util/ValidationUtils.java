
package com.suyan.common.util;

import com.suyan.common.result.ValidationResult;
import org.apache.commons.collections4.CollectionUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.groups.Default;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ValidationUtils {
    private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    public ValidationUtils() {
    }

    public static <T> ValidationResult validateEntity(T obj) {
        ValidationResult result = new ValidationResult();
        Set<ConstraintViolation<T>> set = validator.validate(obj, new Class[]{Default.class});
        if (CollectionUtils.isNotEmpty(set)) {
            result.setHasErrors(true);
            Map<String, String> errorMsg = new HashMap();
            Iterator i$ = set.iterator();

            while (i$.hasNext()) {
                ConstraintViolation<T> cv = (ConstraintViolation) i$.next();
                errorMsg.put(cv.getPropertyPath().toString(), cv.getMessage());
            }

            result.setErrorMsg(errorMsg);
        }

        return result;
    }

    public static <T> ValidationResult validateProperty(T obj, String propertyName) {
        ValidationResult result = new ValidationResult();
        Set<ConstraintViolation<T>> set = validator.validateProperty(obj, propertyName, new Class[]{Default.class});
        if (CollectionUtils.isNotEmpty(set)) {
            result.setHasErrors(true);
            Map<String, String> errorMsg = new HashMap();
            Iterator i$ = set.iterator();

            while (i$.hasNext()) {
                ConstraintViolation<T> cv = (ConstraintViolation) i$.next();
                errorMsg.put(propertyName, cv.getMessage());
            }

            result.setErrorMsg(errorMsg);
        }

        return result;
    }
}
