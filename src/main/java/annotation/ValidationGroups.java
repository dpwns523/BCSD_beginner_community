package annotation;

import javax.validation.groups.Default;

/*
    Used with the @validated Spring annotation
 */
public final class ValidationGroups {
    private ValidationGroups() {}

    public interface join extends Default {};
    public interface board extends Default {};
    public interface comment extends Default {};
}
