package dat3.security;


import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerControllerAdvice {

  @ExceptionHandler(OAuth2AuthenticationException.class )
  public void print(){
    System.out.println("UPPPS");
  }
}
