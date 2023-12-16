package com.apsrtc.busmanagement.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = NoOverlapValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface NoOverlap {

    String message() default "Bus schedules overlap";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}