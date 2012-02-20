package at.ac.univie.mminf.qskos4j.util.vocab;


public enum SparqlPrefix {
	SKOS("skos", "http://www.w3.org/2004/02/skos/core#"),
	RDF("rdf", org.openrdf.model.vocabulary.RDF.NAMESPACE),
	RDFS("rdfs", org.openrdf.model.vocabulary.RDFS.NAMESPACE),
	OWL("owl", org.openrdf.model.vocabulary.OWL.NAMESPACE);

	private String abbrv, nameSpace;
	
	private SparqlPrefix(String abbrv, String nameSpace) {
		this.abbrv = abbrv;
		this.nameSpace = nameSpace;
	}
	
	@Override
	public String toString() {
		return "PREFIX " +abbrv+ ":<" +nameSpace+ ">";
	}
	
	public String getNameSpace() {
		return nameSpace;
	}
}
