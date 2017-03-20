package br.gov.sp.fatec.mapskills.test.integration;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationServiceException;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;

import br.gov.sp.fatec.mapskills.domain.institution.InstitutionService;
import br.gov.sp.fatec.mapskills.domain.user.User;
import br.gov.sp.fatec.mapskills.test.config.AbstractApplicationTest;

public class AuthenticationTest extends AbstractApplicationTest {
		
	@Autowired
	private InstitutionService institutionService;
		
	@Before
	public void setUp() {
		super.setUpContext();
	}
	/**
	 * sempre depois de realizar um teste, ira limpar os
	 * registros do banco em memoria.
	 */
	@After
	public void down() {
		super.cleanTables(institutionService);
	}
	
	@Test
	public void login() throws Exception {
		institutionService.saveStudent(getOneStudent());
		
		mockMvc.perform(post("/login")
			.param("username", "aluno@fatec.sp.gov.br")
			.param("password", "mudar@123")
			.contentType(MediaType.APPLICATION_FORM_URLENCODED))
			.andExpect(status().isOk());
	}
	
	@Test
	public void jwtReturn() throws Exception {
		institutionService.saveStudent(getOneStudent());
		
		super.mockMvcPerformLogin("aluno@fatec.sp.gov.br", "mudar@123")
			.andReturn()
			.getResponse()
			.containsHeader(AUTHORIZATION);
	}
	
	@Test
	public void jwtUnauthorized() throws Exception {
		super.mockMvcPerformLogin("aluno@fatec.sp.gov.br", "mudar@123")
			.andExpect(status().isUnauthorized());
	}
	
	@Test
	public void jwtVerify() throws Exception {
		
		institutionService.saveStudent(getOneStudent());		
		
		final String token = super.mockMvcPerformLogin("aluno@fatec.sp.gov.br", "mudar@123")
									.andReturn()
									.getResponse()
									.getHeader(AUTHORIZATION);
		assertNotNull(token);
	}
	
	@Test
	public void jwtException() throws Exception {
		mockMvc.perform(get("/student/game/3")
				.header(AUTHORIZATION, generateJwt(getOneStudent()))
				.accept(MediaType.parseMediaType(JSON_UTF8_MEDIA_TYPE)))
				.andExpect(status().isForbidden());
	}
	
	/**
	 * metodo que gera um token modficado, para que na verifucacao
	 * do jwt ocorra uma exception.
	 * 
	 * @param user
	 * @return String do token
	 * @throws JOSEException
	 */
	private String generateJwt(final User user) throws JOSEException {
		final long FIVE_HOURS_IN_MILLISECONDS = 60000 * 300;
	    final JWSSigner signer = new MACSigner("9SyECk96oDsTmXfogIieDI0cD/8FpnojlYSUJT5U9I/FGVmBz5oskmjOR8cbXTvoPjX+Pq/T/b1PqpHX0lYm0oCBjXWICA==");
		final long now = System.currentTimeMillis();
		final JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
				.subject(user.getName())
				.claim("username", user.getUsername())
				.claim("profile", user.getProfile())
				.issueTime(new Date(now))
				.issuer("ssh:any.fatec.sp.gov.br")
				.expirationTime(new Date(now + FIVE_HOURS_IN_MILLISECONDS))
				.notBeforeTime(new Date(now))
				.build();

        final SignedJWT signedJWT = new SignedJWT(new JWSHeader(JWSAlgorithm.HS256), claimsSet);

        try {
            signedJWT.sign(signer);
        } catch (final JOSEException e) {
            throw new AuthenticationServiceException("The given JWT could not be signed.");
        }
        return String.format("Bearer %s", signedJWT.serialize());
	}

}
