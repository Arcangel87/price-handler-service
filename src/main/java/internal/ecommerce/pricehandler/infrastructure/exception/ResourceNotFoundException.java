package internal.ecommerce.pricehandler.infrastructure.exception;

public class ResourceNotFoundException extends RuntimeException {

/**
 * Custom exception thrown when a requested resource is not found.
 * Extends {@link RuntimeException} to provide a specific exception type
 * for resource not found scenarios.
 */
  public ResourceNotFoundException(String message) {
    super(message);
  }
}