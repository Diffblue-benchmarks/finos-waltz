package org.finos.waltz.model.legal_entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.legal_entity.ImmutableLegalEntityRelationshipAssessmentInfo.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableLegalEntityRelationshipAssessmentInfoDiffblueTest {
  /**
   * Test Builder {@link Builder#definitionRef(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#definitionRef(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder definitionRef(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.definitionRef(EntityReference)"})
  void testBuilderDefinitionRef_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationshipAssessmentInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.definitionRef(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#from(LegalEntityRelationshipAssessmentInfo)}.
   * <p>
   * Method under test: {@link Builder#from(LegalEntityRelationshipAssessmentInfo)}
   */
  @Test
  @DisplayName("Test Builder from(LegalEntityRelationshipAssessmentInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(LegalEntityRelationshipAssessmentInfo)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationshipAssessmentInfo.builder();
    LegalEntityRelationshipAssessmentInfo instance = mock(LegalEntityRelationshipAssessmentInfo.class);
    when(instance.relationshipId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).relationshipId();
  }

  /**
   * Test Builder {@link Builder#from(LegalEntityRelationshipAssessmentInfo)}.
   * <p>
   * Method under test: {@link Builder#from(LegalEntityRelationshipAssessmentInfo)}
   */
  @Test
  @DisplayName("Test Builder from(LegalEntityRelationshipAssessmentInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(LegalEntityRelationshipAssessmentInfo)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationshipAssessmentInfo.builder();
    LegalEntityRelationshipAssessmentInfo instance = mock(LegalEntityRelationshipAssessmentInfo.class);
    when(instance.ratingId()).thenThrow(new IllegalStateException("instance"));
    when(instance.relationshipId()).thenReturn(1L);
    when(instance.definitionRef()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).definitionRef();
    verify(instance).ratingId();
    verify(instance).relationshipId();
  }

  /**
   * Test Builder {@link Builder#from(LegalEntityRelationshipAssessmentInfo)}.
   * <ul>
   *   <li>Then builder build ratingId longValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(LegalEntityRelationshipAssessmentInfo)}
   */
  @Test
  @DisplayName("Test Builder from(LegalEntityRelationshipAssessmentInfo); then builder build ratingId longValue is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(LegalEntityRelationshipAssessmentInfo)"})
  void testBuilderFrom_thenBuilderBuildRatingIdLongValueIsOne() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationshipAssessmentInfo.builder();
    LegalEntityRelationshipAssessmentInfo instance = mock(LegalEntityRelationshipAssessmentInfo.class);
    when(instance.ratingId()).thenReturn(1L);
    when(instance.relationshipId()).thenReturn(1L);
    when(instance.definitionRef()).thenReturn(mock(EntityReference.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).definitionRef();
    verify(instance).ratingId();
    verify(instance).relationshipId();
    ImmutableLegalEntityRelationshipAssessmentInfo buildResult = builderResult.build();
    assertEquals(1L, buildResult.ratingId().longValue());
    assertEquals(1L, buildResult.relationshipId().longValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#ratingId(Long)}.
   * <p>
   * Method under test: {@link Builder#ratingId(Long)}
   */
  @Test
  @DisplayName("Test Builder ratingId(Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.ratingId(Long)"})
  void testBuilderRatingId() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationshipAssessmentInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ratingId(1L));
  }

  /**
   * Test Builder {@link Builder#relationshipId(Long)}.
   * <p>
   * Method under test: {@link Builder#relationshipId(Long)}
   */
  @Test
  @DisplayName("Test Builder relationshipId(Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.relationshipId(Long)"})
  void testBuilderRelationshipId() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationshipAssessmentInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.relationshipId(1L));
  }
}
