package org.finos.waltz.jobs.tools.resolvers;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ResolverDiffblueTest {
  /**
   * Method under test: {@link Resolver#normalize(String)}
   */
  @Test
  void testNormalize() {
    // Arrange
    Resolver<Long> resolver = mock(Resolver.class);
    when(resolver.normalize(Mockito.<String>any())).thenReturn("Normalize");

    // Act
    resolver.normalize("Name");

    // Assert
    verify(resolver).normalize(eq("Name"));
  }
}
