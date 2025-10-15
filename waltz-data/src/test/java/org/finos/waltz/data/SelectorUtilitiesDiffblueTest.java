package org.finos.waltz.data;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import org.finos.waltz.data.flow_classification_rule.FlowClassificationRuleDao;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.ImmutableSelectionFilters;
import org.finos.waltz.model.ImmutableSelectionFilters.Builder;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.schema.tables.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SelectorUtilitiesDiffblueTest {
  /**
   * Test {@link SelectorUtilities#ensureScopeIsExact(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@link HierarchyQueryScope#EXACT}.
   *   <li>Then calls {@link IdSelectionOptions#scope()}.
   * </ul>
   *
   * <p>Method under test: {@link SelectorUtilities#ensureScopeIsExact(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test ensureScopeIsExact(IdSelectionOptions); given EXACT; then calls scope()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SelectorUtilities.ensureScopeIsExact(IdSelectionOptions)"})
  void testEnsureScopeIsExact_givenExact_thenCallsScope() {
    // Arrange
    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);

    // Act
    SelectorUtilities.ensureScopeIsExact(idSelectionOptions);

    // Assert
    verify(idSelectionOptions).scope();
  }

  /**
   * Test {@link SelectorUtilities#mkApplicationConditions(Application, IdSelectionOptions)} with
   * {@code appTable}, {@code options}.
   *
   * <p>Method under test: {@link SelectorUtilities#mkApplicationConditions(Application,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test mkApplicationConditions(Application, IdSelectionOptions) with 'appTable', 'options'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.jooq.Condition SelectorUtilities.mkApplicationConditions(Application, IdSelectionOptions)"
  })
  void testMkApplicationConditionsWithAppTableOptions() {
    // Arrange
    Builder builderResult = ImmutableSelectionFilters.builder();
    builderResult.addOmitApplicationKinds(ApplicationKind.IN_HOUSE);
    ImmutableSelectionFilters immutableSelectionFilters = builderResult.build();

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(immutableSelectionFilters);

    // Act
    SelectorUtilities.mkApplicationConditions(FlowClassificationRuleDao.CONSUMER_APP, options);

    // Assert
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).filters();
  }

  /**
   * Test {@link SelectorUtilities#mkApplicationConditions(Application, IdSelectionOptions)} with
   * {@code appTable}, {@code options}.
   *
   * <ul>
   *   <li>Then calls {@link IdSelectionOptions#entityLifecycleStatuses()}.
   * </ul>
   *
   * <p>Method under test: {@link SelectorUtilities#mkApplicationConditions(Application,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test mkApplicationConditions(Application, IdSelectionOptions) with 'appTable', 'options'; then calls entityLifecycleStatuses()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.jooq.Condition SelectorUtilities.mkApplicationConditions(Application, IdSelectionOptions)"
  })
  void testMkApplicationConditionsWithAppTableOptions_thenCallsEntityLifecycleStatuses() {
    // Arrange
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(ImmutableSelectionFilters.builder().build());

    // Act
    SelectorUtilities.mkApplicationConditions(FlowClassificationRuleDao.CONSUMER_APP, options);

    // Assert
    verify(options).entityLifecycleStatuses();
    verify(options).filters();
  }

  /**
   * Test {@link SelectorUtilities#mkApplicationConditions(IdSelectionOptions)} with {@code
   * options}.
   *
   * <p>Method under test: {@link SelectorUtilities#mkApplicationConditions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test mkApplicationConditions(IdSelectionOptions) with 'options'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.jooq.Condition SelectorUtilities.mkApplicationConditions(IdSelectionOptions)"
  })
  void testMkApplicationConditionsWithOptions() {
    // Arrange
    Builder builderResult = ImmutableSelectionFilters.builder();
    builderResult.addOmitApplicationKinds(ApplicationKind.IN_HOUSE);
    ImmutableSelectionFilters immutableSelectionFilters = builderResult.build();

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(immutableSelectionFilters);

    // Act
    SelectorUtilities.mkApplicationConditions(options);

    // Assert
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).filters();
  }

  /**
   * Test {@link SelectorUtilities#mkApplicationConditions(IdSelectionOptions)} with {@code
   * options}.
   *
   * <ul>
   *   <li>Then calls {@link IdSelectionOptions#entityLifecycleStatuses()}.
   * </ul>
   *
   * <p>Method under test: {@link SelectorUtilities#mkApplicationConditions(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test mkApplicationConditions(IdSelectionOptions) with 'options'; then calls entityLifecycleStatuses()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.jooq.Condition SelectorUtilities.mkApplicationConditions(IdSelectionOptions)"
  })
  void testMkApplicationConditionsWithOptions_thenCallsEntityLifecycleStatuses() {
    // Arrange
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(ImmutableSelectionFilters.builder().build());

    // Act
    SelectorUtilities.mkApplicationConditions(options);

    // Assert
    verify(options).entityLifecycleStatuses();
    verify(options).filters();
  }
}
