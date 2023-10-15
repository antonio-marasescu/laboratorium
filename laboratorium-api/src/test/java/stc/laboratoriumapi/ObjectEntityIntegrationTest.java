package stc.laboratoriumapi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import stc.laboratoriumapi.dto.objectEntity.ObjectEntityDto;
import stc.laboratoriumapi.integration.base.IntegrationTestBase;
import stc.laboratoriumapi.integration.constants.TypeReferencesConstants;
import stc.laboratoriumapi.integration.constants.UrlConstants;
import stc.laboratoriumapi.integration.constants.UtilConstants;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class ObjectEntityIntegrationTest extends IntegrationTestBase {

	@Test
	public void retrieveAllObjectEntities() throws Exception {
		List<ObjectEntityDto> response = this.get(UrlConstants.WORLDS_URL, UtilConstants.EMPTY_PARAMS,
		                                          TypeReferencesConstants.ObjectEntityDtoRef);

		assertEquals(response.size(), 2);
	}

}
