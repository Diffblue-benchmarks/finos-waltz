package org.finos.waltz.data;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import org.finos.waltz.data.flow_classification_rule.FlowClassificationRuleDao;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.SelectionFilters;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.schema.tables.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SelectorUtilitiesDiffblueTest {
  /**
   * Test {@link SelectorUtilities#ensureScopeIsExact(IdSelectionOptions)}.
   * <ul>
   *   <li>Given {@code EXACT}.</li>
   *   <li>Then calls {@link IdSelectionOptions#scope()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SelectorUtilities#ensureScopeIsExact(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test ensureScopeIsExact(IdSelectionOptions); given 'EXACT'; then calls scope()")
  @Tag("MaintainedByDiffblue")
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
   * Test {@link SelectorUtilities#mkApplicationConditions(Application, IdSelectionOptions)} with {@code appTable}, {@code options}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code IN_HOUSE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SelectorUtilities#mkApplicationConditions(Application, IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test mkApplicationConditions(Application, IdSelectionOptions) with 'appTable', 'options'; given HashSet() add 'IN_HOUSE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.Condition SelectorUtilities.mkApplicationConditions(Application, IdSelectionOptions)"})
  void testMkApplicationConditionsWithAppTableOptions_givenHashSetAddInHouse() {
    // Arrange
    HashSet<ApplicationKind> applicationKindSet = new HashSet<>();
    applicationKindSet.add(ApplicationKind.IN_HOUSE);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(applicationKindSet);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(selectionFilters);

    // Act
    SelectorUtilities.mkApplicationConditions(FlowClassificationRuleDao.CONSUMER_APP, options);

    // Assert
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).filters();
    verify(selectionFilters, atLeast(1)).omitApplicationKinds();
  }

  /**
   * Test {@link SelectorUtilities#mkApplicationConditions(Application, IdSelectionOptions)} with {@code appTable}, {@code options}.
   * <ul>
   *   <li>Then calls {@link IdSelectionOptions#entityLifecycleStatuses()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SelectorUtilities#mkApplicationConditions(Application, IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test mkApplicationConditions(Application, IdSelectionOptions) with 'appTable', 'options'; then calls entityLifecycleStatuses()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.Condition SelectorUtilities.mkApplicationConditions(Application, IdSelectionOptions)"})
  void testMkApplicationConditionsWithAppTableOptions_thenCallsEntityLifecycleStatuses() {
    // Arrange
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(selectionFilters);

    // Act
    SelectorUtilities.mkApplicationConditions(FlowClassificationRuleDao.CONSUMER_APP, options);

    // Assert
    verify(options).entityLifecycleStatuses();
    verify(options).filters();
    verify(selectionFilters).omitApplicationKinds();
  }

  /**
   * Test {@link SelectorUtilities#mkApplicationConditions(IdSelectionOptions)} with {@code options}.
   * <p>
   * Method under test: {@link SelectorUtilities#mkApplicationConditions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test mkApplicationConditions(IdSelectionOptions) with 'options'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.Condition SelectorUtilities.mkApplicationConditions(IdSelectionOptions)"})
  void testMkApplicationConditionsWithOptions() {
    // Arrange
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(selectionFilters);

    // Act
    SelectorUtilities.mkApplicationConditions(options);

    // Assert
    verify(options).entityLifecycleStatuses();
    verify(options).filters();
    verify(selectionFilters).omitApplicationKinds();
  }

  /**
   * Test {@link SelectorUtilities#mkApplicationConditions(IdSelectionOptions)} with {@code options}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code IN_HOUSE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SelectorUtilities#mkApplicationConditions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test mkApplicationConditions(IdSelectionOptions) with 'options'; given HashSet() add 'IN_HOUSE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.Condition SelectorUtilities.mkApplicationConditions(IdSelectionOptions)"})
  void testMkApplicationConditionsWithOptions_givenHashSetAddInHouse() {
    // Arrange
    HashSet<ApplicationKind> applicationKindSet = new HashSet<>();
    applicationKindSet.add(ApplicationKind.IN_HOUSE);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(applicationKindSet);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(selectionFilters);

    // Act
    SelectorUtilities.mkApplicationConditions(options);

    // Assert
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).filters();
    verify(selectionFilters, atLeast(1)).omitApplicationKinds();
  }
}
