package at.ac.univie.mminf.qskos4j.issues.labels.util;

import org.openrdf.model.Literal;
import org.openrdf.model.Resource;

public class LabeledResource {

	private Literal literal;
	private LabelType labelType;
    private Resource resource;
	
	public LabeledResource(Resource resource, Literal literal, LabelType labelType)
	{
        this.resource = resource;
		this.literal = literal;
		this.labelType = labelType;
	}

	public Literal getLiteral() {
		return literal;
	}

    public Resource getResource() {
        return resource;
    }

    public LabelType getLabelType() {
        return labelType;
    }

	@Override
	public String toString() {
		return resource +" ("+ literal +", "+ labelType +")";
	}

    @Override
    public int hashCode() {
        return resource.hashCode() * literal.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof LabeledResource)) {
            return false;
        }

        LabeledResource other = (LabeledResource) obj;
        return resource.equals(other.resource) && literal.equals(other.literal) && labelType.equals(other.labelType);
    }
}