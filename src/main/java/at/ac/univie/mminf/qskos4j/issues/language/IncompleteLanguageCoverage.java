package at.ac.univie.mminf.qskos4j.issues.language;

import at.ac.univie.mminf.qskos4j.issues.Issue;
import at.ac.univie.mminf.qskos4j.issues.language.util.LanguageCoverage;
import at.ac.univie.mminf.qskos4j.util.IssueDescriptor;
import org.eclipse.rdf4j.RDF4JException;
import org.eclipse.rdf4j.model.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Finds all concepts with incomplete language coverage (<a href="https://github.com/cmader/qSKOS/wiki/Quality-Issues#wiki-Incomplete_Language_Coverage">Incomplete Language Coverage</a>
 */
public class IncompleteLanguageCoverage extends Issue<IncompleteLangCovResult> {

	private Map<Resource, Collection<String>> incompleteLanguageCoverage;
    private LanguageCoverage languageCoverage;
	private Set<String> distinctLanguages;

    public IncompleteLanguageCoverage(LanguageCoverage languageCoverage) {
        super(new IssueDescriptor.Builder(
            "ilc",
            "Incomplete Language Coverage",
            "Finds concepts lacking description in languages that are present for other concepts",
            IssueDescriptor.IssueType.ANALYTICAL)
				.weblink("https://github.com/cmader/qSKOS/wiki/Quality-Issues#incomplete-language-coverage")
				.dependentIssue(languageCoverage)
				.build()
        );

        this.languageCoverage = languageCoverage;
    }

    @Override
    protected IncompleteLangCovResult invoke() throws RDF4JException {
		incompleteLanguageCoverage = new HashMap<>();

        findDistinctLanguages();
		generateIncompleteLanguageCoverageMap();
		
		return new IncompleteLangCovResult(incompleteLanguageCoverage);
	}

    private void findDistinctLanguages() throws RDF4JException {
        distinctLanguages = new HashSet<>();
        for (Collection<String> languages : languageCoverage.getResult().getData().values()) {
            distinctLanguages.addAll(languages);
        }
    }

	private void generateIncompleteLanguageCoverageMap() throws RDF4JException {
		incompleteLanguageCoverage = new HashMap<>();

        Map<Resource, Collection<String>> langCovData = languageCoverage.getResult().getData();

		for (Resource resource : langCovData.keySet()) {
			Collection<String> coveredLanguages = langCovData.get(resource);
			Collection<String> notCoveredLanguages = getNotCoveredLanguages(coveredLanguages);
			if (!notCoveredLanguages.isEmpty()) {
				incompleteLanguageCoverage.put(resource, notCoveredLanguages);
			}
		}
	}
	
	private Collection<String> getNotCoveredLanguages(Collection<String> coveredLanguages) {
		Set<String> ret = new HashSet<String>(distinctLanguages);
		ret.removeAll(coveredLanguages);
		return ret;
	}

}
