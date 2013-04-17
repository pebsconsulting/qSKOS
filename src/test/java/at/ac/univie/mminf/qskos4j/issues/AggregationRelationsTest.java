package at.ac.univie.mminf.qskos4j.issues;

import at.ac.univie.mminf.qskos4j.issues.count.AggregationRelations;
import at.ac.univie.mminf.qskos4j.util.vocab.RepositoryBuilder;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openrdf.OpenRDFException;
import org.openrdf.repository.RepositoryConnection;

import java.io.IOException;

/**
 * Created by christian
 * Date: 26.01.13
 * Time: 14:47
 */
public class AggregationRelationsTest {

    private AggregationRelations aggregationRelations;
    private RepositoryConnection repCon;

    @Before
    public void setUp() throws OpenRDFException, IOException {
        repCon = new RepositoryBuilder().setUpFromTestResource("aggregations.rdf").getConnection();
        aggregationRelations = new AggregationRelations(repCon);
    }

    @Test
    public void testAggregationRelationsCount() throws OpenRDFException
    {
        //System.out.println(repCon.getStatements(null, null, null, true).asList());

        Assert.assertEquals(5, aggregationRelations.getPreparedData().longValue());
    }

}
