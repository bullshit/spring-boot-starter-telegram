package io.github.drednote.telegram.updatehandler.controller;

import io.github.drednote.telegram.core.request.TelegramRequestMapping;
import java.lang.reflect.Method;
import org.springframework.lang.NonNull;

/**
 * The {@code ControllerRegistrar} functional interface represents a mechanism for registering
 * controller methods with their corresponding Telegram request mappings. Implementing classes can
 * use this interface to manage the association between controller methods and their mapping
 * information.
 * <p>
 * When a controller method is detected as being annotated with {@link TelegramRequest}, an
 * implementation of this interface can be used to associate the method with its mapping details.
 * This allows for efficient handling of incoming Telegram update requests, ensuring that the
 * appropriate method is invoked for the received update.
 *
 * @see TelegramRequestMapping
 * @see TelegramController
 * @see TelegramRequest
 */
@FunctionalInterface
public interface ControllerRegistrar {

  /**
   * Registers a controller method along with its corresponding mapping information.
   *
   * @param bean The controller object, not null
   * @param method The method to be registered, not null
   * @param info The mapping information associated with the method, not null
   */
  void register(@NonNull Object bean, @NonNull Method method, @NonNull TelegramRequestMapping info);
}
