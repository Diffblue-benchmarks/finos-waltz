package org.finos.waltz.service.workflow;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Set;
import org.finos.waltz.data.GenericSelector;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.service.workflow.ImmutableContextVariableDeclaration.Builder;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ContextPopulatorDiffblueTest {
  /**
   * Test {@link ContextPopulator#populateContext(Set, GenericSelector)}.
   *
   * <p>Method under test: {@link ContextPopulator#populateContext(Set, GenericSelector)}
   */
  @Test
  @DisplayName("Test populateContext(Set, GenericSelector)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ContextPopulator.populateContext(Set, GenericSelector)"})
  void testPopulateContext() {
    // Arrange
    ContextPopulator contextPopulator =
        new ContextPopulator(new DefaultDSLContext(SQLDialect.SQL99));

    HashSet<ContextVariableDeclaration> declarations = new HashSet<>();

    Builder nameResult = ImmutableContextVariableDeclaration.builder().name("java.lang.String");
    declarations.add(
        nameResult
            .ref(
                ImmutableContextVariableReference.builder()
                    .externalId("42")
                    .kind(EntityKind.ALL)
                    .build())
            .build());

    Builder nameResult2 = ImmutableContextVariableDeclaration.builder().name("Name");
    declarations.add(
        nameResult2
            .ref(
                ImmutableContextVariableReference.builder()
                    .externalId("42")
                    .kind(EntityKind.ALL)
                    .build())
            .build());

    // Act and Assert
    assertTrue(contextPopulator.populateContext(declarations, null).isEmpty());
  }

  /**
   * Test {@link ContextPopulator#populateContext(Set, GenericSelector)}.
   *
   * <ul>
   *   <li>Given builder name {@code Name} ref builder externalId {@code 42} kind {@code ALL} build
   *       build.
   * </ul>
   *
   * <p>Method under test: {@link ContextPopulator#populateContext(Set, GenericSelector)}
   */
  @Test
  @DisplayName(
      "Test populateContext(Set, GenericSelector); given builder name 'Name' ref builder externalId '42' kind 'ALL' build build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ContextPopulator.populateContext(Set, GenericSelector)"})
  void testPopulateContext_givenBuilderNameNameRefBuilderExternalId42KindAllBuildBuild() {
    // Arrange
    ContextPopulator contextPopulator =
        new ContextPopulator(new DefaultDSLContext(SQLDialect.SQL99));

    HashSet<ContextVariableDeclaration> declarations = new HashSet<>();

    Builder nameResult = ImmutableContextVariableDeclaration.builder().name("Name");
    declarations.add(
        nameResult
            .ref(
                ImmutableContextVariableReference.builder()
                    .externalId("42")
                    .kind(EntityKind.ALL)
                    .build())
            .build());

    // Act and Assert
    assertTrue(contextPopulator.populateContext(declarations, null).isEmpty());
  }

  /**
   * Test {@link ContextPopulator#populateContext(Set, GenericSelector)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ContextPopulator#populateContext(Set, GenericSelector)}
   */
  @Test
  @DisplayName("Test populateContext(Set, GenericSelector); when HashSet(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ContextPopulator.populateContext(Set, GenericSelector)"})
  void testPopulateContext_whenHashSet_thenReturnEmpty() {
    // Arrange
    ContextPopulator contextPopulator =
        new ContextPopulator(new DefaultDSLContext(SQLDialect.SQL99));

    // Act and Assert
    assertTrue(contextPopulator.populateContext(new HashSet<>(), null).isEmpty());
  }
}
