package org.finos.waltz.jobs.example;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.jooq.DSLContext;
import org.jooq.TransactionalRunnable;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GenericTaxonomyLoaderDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private GenericTaxonomyLoader genericTaxonomyLoader;

  /**
   * Test {@link GenericTaxonomyLoader#go(GenericTaxonomyLoadConfig)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#transaction(TransactionalRunnable)} does
   *       nothing.
   *   <li>Then calls {@link GenericTaxonomyLoadConfig#resourcePath()}.
   * </ul>
   *
   * <p>Method under test: {@link GenericTaxonomyLoader#go(GenericTaxonomyLoadConfig)}
   */
  @Test
  @DisplayName(
      "Test go(GenericTaxonomyLoadConfig); given DSLContext transaction(TransactionalRunnable) does nothing; then calls resourcePath()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GenericTaxonomyLoader.go(GenericTaxonomyLoadConfig)"})
  void testGo_givenDSLContextTransactionDoesNothing_thenCallsResourcePath() throws IOException {
    // Arrange
    doNothing().when(dSLContext).transaction(Mockito.<TransactionalRunnable>any());

    GenericTaxonomyLoadConfig config = mock(GenericTaxonomyLoadConfig.class);
    when(config.resourcePath()).thenReturn("/");

    // Act
    genericTaxonomyLoader.go(config);

    // Assert
    verify(config).resourcePath();
    verify(dSLContext).transaction(isA(TransactionalRunnable.class));
  }

  /**
   * Test {@link GenericTaxonomyLoader#go(GenericTaxonomyLoadConfig)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext} {@link
   *       DefaultDSLContext#transaction(TransactionalRunnable)} does nothing.
   *   <li>Then calls {@link DefaultDSLContext#transaction(TransactionalRunnable)}.
   * </ul>
   *
   * <p>Method under test: {@link GenericTaxonomyLoader#go(GenericTaxonomyLoadConfig)}
   */
  @Test
  @DisplayName(
      "Test go(GenericTaxonomyLoadConfig); given DefaultDSLContext transaction(TransactionalRunnable) does nothing; then calls transaction(TransactionalRunnable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GenericTaxonomyLoader.go(GenericTaxonomyLoadConfig)"})
  void testGo_givenDefaultDSLContextTransactionDoesNothing_thenCallsTransaction()
      throws IOException {
    // Arrange
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    doNothing().when(dsl).transaction(Mockito.<TransactionalRunnable>any());
    GenericTaxonomyLoader genericTaxonomyLoader = new GenericTaxonomyLoader(dsl);

    // Act
    genericTaxonomyLoader.go(
        ImmutableGenericTaxonomyLoadConfig.builder()
            .descriptionOffset(1)
            .maxLevels(3)
            .ratingSchemeId(1L)
            .resourcePath("")
            .taxonomyDescription("Taxonomy Description")
            .taxonomyExternalId("42")
            .taxonomyName("Taxonomy Name")
            .build());

    // Assert
    verify(dsl).transaction(isA(TransactionalRunnable.class));
  }
}
