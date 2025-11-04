package org.finos.waltz.data;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashSet;
import org.finos.waltz.data.flow_classification_rule.FlowClassificationRuleDao;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.SelectionFilters;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.schema.tables.Application;
import org.junit.jupiter.api.Test;

class SelectorUtilitiesDiffblueTest {
  /**
   * Method under test:
   * {@link SelectorUtilities#ensureScopeIsExact(IdSelectionOptions)}
   */
  @Test
  void testEnsureScopeIsExact() {
    // Arrange
    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);

    // Act
    SelectorUtilities.ensureScopeIsExact(idSelectionOptions);

    // Assert that nothing has changed
    verify(idSelectionOptions).scope();
  }

  /**
   * Method under test:
   * {@link SelectorUtilities#mkApplicationConditions(IdSelectionOptions)}
   */
  @Test
  void testMkApplicationConditions() {
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
   * Method under test:
   * {@link SelectorUtilities#mkApplicationConditions(IdSelectionOptions)}
   */
  @Test
  void testMkApplicationConditions2() {
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

  /**
   * Method under test:
   * {@link SelectorUtilities#mkApplicationConditions(Application, IdSelectionOptions)}
   */
  @Test
  void testMkApplicationConditions3() {
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
   * Method under test:
   * {@link SelectorUtilities#mkApplicationConditions(Application, IdSelectionOptions)}
   */
  @Test
  void testMkApplicationConditions4() {
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
}
