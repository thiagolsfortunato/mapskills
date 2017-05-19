/*
 * @(#)ResponseHeaderAuthenticationListener.java 1.0 27/01/2017
 *
 * Copyright (c) 2017, Fatec Jessen Vidal. All rights reserved.
 * Fatec Jessen Vidal proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.authentication;

import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.stereotype.Component;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
/**
 * 
 * A classe {@link ResponseHeaderAuthenticationListener}
 *
 * @author Marcelo
 * @version 1.0 27/01/2017
 */
@Component
public class ResponseHeaderAuthenticationListener implements AuthenticationListener {
	
	private static final Logger LOGGER = Logger.getLogger(ResponseHeaderAuthenticationListener.class.getName());
	private static final long FIVE_HOURS_IN_MILLISECONDS = 60000L * 300L;
    private final JWSSigner signer;
    
    @Autowired
    public ResponseHeaderAuthenticationListener(@Value("${jwt.secret}") final String secret) throws JOSEException {
        super();
        this.signer = new MACSigner(secret);
    }

	@Override
	public void onAuthenticationSuccess(final AuthenticationEvent event) throws IOException, ServletException {
		final long now = System.currentTimeMillis();
		final JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
				.subject(event.getUsername())
				.claim("username", event.getUserDomain().getUsername())
				.claim("profile", event.getUserDomain().getProfile())
				.issueTime(new Date(now))
				.issuer("ssh:mapskills.fatec.sp.gov.br")
				.expirationTime(new Date(now + FIVE_HOURS_IN_MILLISECONDS))
				.notBeforeTime(new Date(now))
				.build();

        final SignedJWT signedJWT = new SignedJWT(new JWSHeader(JWSAlgorithm.HS256), claimsSet);

        try {
            signedJWT.sign(signer);
        } catch (final JOSEException e) {
        	LOGGER.log(Level.SEVERE, e.getMessage(), e);
            throw new AuthenticationServiceException("The given JWT could not be signed.");
        }

        final HttpServletResponse resp = event.getResponse();
        resp.setHeader("Authorization", String.format("Bearer %s", signedJWT.serialize()));
	}

}
