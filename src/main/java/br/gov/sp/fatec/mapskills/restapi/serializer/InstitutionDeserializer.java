package br.gov.sp.fatec.mapskills.restapi.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import br.gov.sp.fatec.mapskills.domain.institution.Institution;
import br.gov.sp.fatec.mapskills.domain.institution.Mentor;
import br.gov.sp.fatec.mapskills.restapi.wrapper.InstitutionDetailsWrapper;

public class InstitutionDeserializer extends JsonDeserializer<InstitutionDetailsWrapper> {

	@Override
	public InstitutionDetailsWrapper deserialize(final JsonParser jsonParser, final DeserializationContext arg1)
			throws IOException {
		
		final ObjectCodec oc = jsonParser.getCodec();
        final JsonNode node = oc.readTree(jsonParser);

        final Mentor mentor = new Mentor(node.get("mentor").get("name").asText(), node.get("code").asText(),
        		node.get("mentor").get("username").asText(), node.get("mentor").get("password").asText());
        
		final Institution institution =  new Institution(node.get("code").asText(), node.get("cnpj").asText(),
				node.get("company").asText(), node.get("city").asText(), mentor);
		
		return new InstitutionDetailsWrapper(institution);
	}

}
