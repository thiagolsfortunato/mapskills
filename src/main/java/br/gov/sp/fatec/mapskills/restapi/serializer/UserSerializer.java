package br.gov.sp.fatec.mapskills.restapi.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import br.gov.sp.fatec.mapskills.restapi.wrapper.UserWrapper;

public class UserSerializer extends JsonSerializer<UserWrapper> {

	@Override
	public void serialize(final UserWrapper arg0, final JsonGenerator arg1, final SerializerProvider arg2)
			throws IOException {
		// TODO Auto-generated method stub
		
	}

}
