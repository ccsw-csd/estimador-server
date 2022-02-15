package com.capgemini.ccsw.estimador.config.security;

import java.util.Collection;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

/**
 * An authentication object
 *
 */
public class JsonWebTokenAuthentication extends AbstractAuthenticationToken {

  private static final long serialVersionUID = 1L;

  private String principal;

  /**
   * The constructor.
   *
   * @param details
   * @param jsonWebToken the web token JSON as {@link String}
   *
   */
  public JsonWebTokenAuthentication(UserInfoAppDto details, Collection<? extends GrantedAuthority> authorities,
      String jsonWebToken) {

    super(authorities);
    super.setDetails(details);
    setPrincipal(jsonWebToken);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Object getCredentials() {

    return "";
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Object getPrincipal() {

    return this.principal;
  }

  /**
   * @param principal new value of {@link #getPrincipal}.
   */
  public void setPrincipal(String principal) {

    this.principal = principal;
  }

}
