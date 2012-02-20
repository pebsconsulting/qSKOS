package at.ac.univie.mminf.qskos4j;

import java.util.Map;

import junit.framework.Assert;

import org.junit.Test;
import org.openrdf.model.URI;

import at.ac.univie.mminf.qskos4j.util.Pair;

public class OmittedInverseRelationsTest extends QSkosTestCase {

	@Test
	public void testMissingInverseRelationsCount() {
		Map<Pair<URI>, String> missingRelations = qSkosOmittedInverseRelations.findOmittedInverseRelations();
		Assert.assertEquals(6, missingRelations.size());
	}
	
}
