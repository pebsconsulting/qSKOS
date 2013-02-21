package at.ac.univie.mminf.qskos4j.issues.pp;

import at.ac.univie.mminf.qskos4j.issues.Issue;
import at.ac.univie.mminf.qskos4j.report.Report;
import org.openrdf.repository.Repository;
import org.openrdf.repository.RepositoryException;

public abstract class RepairableIssue<T extends Report<?>> extends Issue<T> {

    protected RepairableIssue(
        Repository repository,
        String id,
        String name,
        String description,
        IssueType type)
    {
        super(repository, id, name, description, type);
    }

    public void repair() throws RepairFailedException, RepositoryException
    {
        invokeRepair();
        reset();
    }

    protected abstract void invokeRepair() throws RepairFailedException, RepositoryException;

}