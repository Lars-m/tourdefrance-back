package dat3.security;

import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.authorization.event.AuthorizationDeniedEvent;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.server.resource.BearerTokenAuthenticationToken;
import org.springframework.stereotype.Component;


@Component
public class FailureEvents {
  @EventListener
  public void onFailure(AuthenticationFailureBadCredentialsEvent badCredentials) {
    System.out.println("------------------------------------------------------------");
    System.out.println("------------------------------------------------------------");
    System.out.println("------------------------------------------------------------");
    System.out.println("------------------------------------------------------------");
    System.out.println("------------------------------------------------------------");
    if (badCredentials.getAuthentication() instanceof BearerTokenAuthenticationToken) {
      System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
      System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
      System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
      System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
    }
  }

  public void onFailure(AuthorizationDeniedEvent badCredentials) {
    System.out.println("AuthorizationDeniedEvent");
    System.out.println("AuthorizationDeniedEvent");
    System.out.println("AuthorizationDeniedEvent");
    System.out.println("AuthorizationDeniedEvent");
  }
  @EventListener
  public void onFailure(OAuth2AuthenticationException ex) {
    System.out.println("------------------------------------------------------------");
    System.out.println("------------------------------------------------------------");
    System.out.println("------------------------------------------------------------");
    System.out.println("------------------------------------------------------------");
    System.out.println("------------------------------------------------------------");

  }
}
