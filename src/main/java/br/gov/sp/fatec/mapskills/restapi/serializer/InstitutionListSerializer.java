package br.gov.sp.fatec.mapskills.restapi.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import br.gov.sp.fatec.mapskills.restapi.wrapper.InstitutionListWrapper;

public class InstitutionListSerializer extends JsonSerializer<InstitutionListWrapper> {

	@Override
	public void serialize(InstitutionListWrapper institutionListWrapper, JsonGenerator generator, SerializerProvider arg2)
			throws IOException {
		// TODO Auto-generated method stub
		
	}

}
