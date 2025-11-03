package org.finos.waltz.data.logical_flow;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.IdSelectionOptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LogicalFlowDecoratorIdSelectorFactoryDiffblueTest {
  /**
   * Test {@link LogicalFlowDecoratorIdSelectorFactory#apply(IdSelectionOptions)} with {@code IdSelectionOptions}.
   * <p>
   * Method under test: {@link LogicalFlowDecoratorIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test apply(IdSelectionOptions) with 'IdSelectionOptions'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.Select LogicalFlowDecoratorIdSelectorFactory.apply(IdSelectionOptions)"})
  void testApplyWithIdSelectionOptions() {
    // Arrange
    LogicalFlowDecoratorIdSelectorFactory logicalFlowDecoratorIdSelectorFactory = new LogicalFlowDecoratorIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenThrow(new UnsupportedOperationException("options cannot be null"));
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference()).thenReturn(entityReference);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> logicalFlowDecoratorIdSelectorFactory.apply(options));
    verify(entityReference).kind();
    verify(options).entityReference();
  }

  /**
   * Test {@link LogicalFlowDecoratorIdSelectorFactory#apply(IdSelectionOptions)} with {@code IdSelectionOptions}.
   * <p>
   * Method under test: {@link LogicalFlowDecoratorIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test apply(IdSelectionOptions) with 'IdSelectionOptions'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.Select LogicalFlowDecoratorIdSelectorFactory.apply(IdSelectionOptions)"})
  void testApplyWithIdSelectionOptions2() {
    // Arrange
    LogicalFlowDecoratorIdSelectorFactory logicalFlowDecoratorIdSelectorFactory = new LogicalFlowDecoratorIdSelectorFactory();
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference()).thenThrow(new UnsupportedOperationException("options cannot be null"));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> logicalFlowDecoratorIdSelectorFactory.apply(options));
    verify(options).entityReference();
  }

  /**
   * Test {@link LogicalFlowDecoratorIdSelectorFactory#apply(IdSelectionOptions)} with {@code IdSelectionOptions}.
   * <ul>
   *   <li>Given {@link EntityReference} {@link EntityReference#kind()} return {@code ALL}.</li>
   *   <li>Then calls {@link EntityReference#kind()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LogicalFlowDecoratorIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test apply(IdSelectionOptions) with 'IdSelectionOptions'; given EntityReference kind() return 'ALL'; then calls kind()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.Select LogicalFlowDecoratorIdSelectorFactory.apply(IdSelectionOptions)"})
  void testApplyWithIdSelectionOptions_givenEntityReferenceKindReturnAll_thenCallsKind() {
    // Arrange
    LogicalFlowDecoratorIdSelectorFactory logicalFlowDecoratorIdSelectorFactory = new LogicalFlowDecoratorIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference()).thenReturn(entityReference);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> logicalFlowDecoratorIdSelectorFactory.apply(options));
    verify(entityReference).kind();
    verify(options).entityReference();
  }
}
