package io.github.drednote.telegram.exception;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.stereotype.Component;

/**
 * The {@code TelegramAdvice} annotation is annotation that marks a class as providing advice
 * related to Telegram exception handling.
 * <p>
 * This annotation worked in pair with {@link TelegramExceptionHandler}. The class should be marked
 * with {@code TelegramAdvice} and methods of this class, should be marked with {@code
 * TelegramExceptionHandler}
 *
 * <p>This annotation is used to identify classes that contain advice specifically designed for
 * handling exceptions in a Telegram-related context
 *
 * @author Ivan Galushko
 *
 * @see TelegramExceptionHandler
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface TelegramAdvice {

}
