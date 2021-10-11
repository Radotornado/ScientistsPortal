package de.uni_passau.fim.scientistsPortal.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Needed, as @Named currently has no eager attribute similar to
 * @ManagedBean(eager = true).
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface Eager {
}
