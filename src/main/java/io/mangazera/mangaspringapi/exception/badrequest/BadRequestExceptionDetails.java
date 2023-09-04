package io.mangazera.mangaspringapi.exception.badrequest;

import io.mangazera.mangaspringapi.exception.ExceptionDetails;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class BadRequestExceptionDetails extends ExceptionDetails {
}
