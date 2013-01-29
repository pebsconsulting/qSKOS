package at.ac.univie.mminf.qskos4j.issues.relations.test;

import at.ac.univie.mminf.qskos4j.issues.relations.SolelyTransitivelyRelatedConcepts;
import at.ac.univie.mminf.qskos4j.util.IssueTestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openrdf.OpenRDFException;

import java.io.IOException;

public class SolelyTransitivelyRelatedConceptsTest extends IssueTestCase {

	private SolelyTransitivelyRelatedConcepts solelyTransitivelyRelatedConcepts;
	
	@Before
	public void setUp() throws OpenRDFException, IOException {
        solelyTransitivelyRelatedConcepts = (SolelyTransitivelyRelatedConcepts) setUpRepository(
                "solitaryTransitiveRelations.rdf",
                new SolelyTransitivelyRelatedConcepts());
	}

	@Test
	public void testSolitaryTransitiveRelationsCount() throws OpenRDFException {
		Assert.assertEquals(4, solelyTransitivelyRelatedConcepts.getResult().getData().size());
	}
	
}