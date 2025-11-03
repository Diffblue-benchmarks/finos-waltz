package org.finos.waltz.service.survey;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SurveyInstanceIdSelectorFactoryDiffblueTest {
  /**
   * Test {@link SurveyInstanceIdSelectorFactory#apply(IdSelectionOptions)} with {@code IdSelectionOptions}.
   * <p>
   * Method under test: {@link SurveyInstanceIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test apply(IdSelectionOptions) with 'IdSelectionOptions'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.Select SurveyInstanceIdSelectorFactory.apply(IdSelectionOptions)"})
  void testApplyWithIdSelectionOptions() {
    // Arrange
    SurveyInstanceIdSelectorFactory surveyInstanceIdSelectorFactory = new SurveyInstanceIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenThrow(new IllegalArgumentException("options cannot be null"));
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference()).thenReturn(entityReference);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> surveyInstanceIdSelectorFactory.apply(options));
    verify(entityReference).kind();
    verify(options).entityReference();
  }

  /**
   * Test {@link SurveyInstanceIdSelectorFactory#apply(IdSelectionOptions)} with {@code IdSelectionOptions}.
   * <p>
   * Method under test: {@link SurveyInstanceIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test apply(IdSelectionOptions) with 'IdSelectionOptions'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.Select SurveyInstanceIdSelectorFactory.apply(IdSelectionOptions)"})
  void testApplyWithIdSelectionOptions2() {
    // Arrange
    SurveyInstanceIdSelectorFactory surveyInstanceIdSelectorFactory = new SurveyInstanceIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenThrow(new IllegalArgumentException("options cannot be null"));
    when(entityReference.kind()).thenReturn(EntityKind.APPLICATION);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference()).thenReturn(entityReference);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> surveyInstanceIdSelectorFactory.apply(options));
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options).entityReference();
    verify(options).scope();
  }

  /**
   * Test {@link SurveyInstanceIdSelectorFactory#apply(IdSelectionOptions)} with {@code IdSelectionOptions}.
   * <ul>
   *   <li>Given {@link EntityReference} {@link EntityReference#id()} return one.</li>
   *   <li>Then calls {@link EntityReference#id()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SurveyInstanceIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test apply(IdSelectionOptions) with 'IdSelectionOptions'; given EntityReference id() return one; then calls id()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.Select SurveyInstanceIdSelectorFactory.apply(IdSelectionOptions)"})
  void testApplyWithIdSelectionOptions_givenEntityReferenceIdReturnOne_thenCallsId() {
    // Arrange
    SurveyInstanceIdSelectorFactory surveyInstanceIdSelectorFactory = new SurveyInstanceIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APPLICATION);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    surveyInstanceIdSelectorFactory.apply(options);

    // Assert
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options).entityReference();
    verify(options).scope();
  }

  /**
   * Test {@link SurveyInstanceIdSelectorFactory#apply(IdSelectionOptions)} with {@code IdSelectionOptions}.
   * <ul>
   *   <li>Given {@link EntityReference} {@link EntityReference#kind()} return {@code ALL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SurveyInstanceIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test apply(IdSelectionOptions) with 'IdSelectionOptions'; given EntityReference kind() return 'ALL'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.Select SurveyInstanceIdSelectorFactory.apply(IdSelectionOptions)"})
  void testApplyWithIdSelectionOptions_givenEntityReferenceKindReturnAll() {
    // Arrange
    SurveyInstanceIdSelectorFactory surveyInstanceIdSelectorFactory = new SurveyInstanceIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference()).thenReturn(entityReference);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> surveyInstanceIdSelectorFactory.apply(options));
    verify(entityReference, atLeast(1)).kind();
    verify(options).entityReference();
  }

  /**
   * Test new {@link SurveyInstanceIdSelectorFactory} (default constructor).
   * <ul>
   *   <li>Then calls {@link EntityReference#id()}.</li>
   * </ul>
   * <p>
   * Method under test: default or parameterless constructor of {@link SurveyInstanceIdSelectorFactory}
   */
  @Test
  @DisplayName("Test new SurveyInstanceIdSelectorFactory (default constructor); then calls id()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SurveyInstanceIdSelectorFactory.<init>()"})
  void testNewSurveyInstanceIdSelectorFactory_thenCallsId() {
    // Arrange and Act
    SurveyInstanceIdSelectorFactory actualSurveyInstanceIdSelectorFactory = new SurveyInstanceIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APPLICATION);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference()).thenReturn(entityReference);
    actualSurveyInstanceIdSelectorFactory.apply(options);

    // Assert
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options).entityReference();
    verify(options).scope();
  }
}
