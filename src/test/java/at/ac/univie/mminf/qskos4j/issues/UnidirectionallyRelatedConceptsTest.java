package at.ac.univie.mminf.qskos4j.issues;

import at.ac.univie.mminf.qskos4j.issues.relations.UnidirectionallyRelatedConcepts;
import at.ac.univie.mminf.qskos4j.util.IssueTestCase;
import at.ac.univie.mminf.qskos4j.util.Pair;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openrdf.OpenRDFException;
import org.openrdf.model.Resource;

import java.io.IOException;
import java.util.Map;

public class UnidirectionallyRelatedConceptsTest extends IssueTestCase {

    private UnidirectionallyRelatedConcepts unidirectionallyRelatedConcepts;

    @Before
    public void setUp() throws OpenRDFException, IOException {
        unidirectionallyRelatedConcepts = new UnidirectionallyRelatedConcepts(setUpRepository("omittedInverseRelations.rdf"));
    }

    @Test
    public void testMissingInverseRelationsCount() throws OpenRDFException {
        Map<Pair<Resource>, String> missingRelations = unidirectionallyRelatedConcepts.getResult().getData();
        Assert.assertEquals(8, missingRelations.size());
    }
}