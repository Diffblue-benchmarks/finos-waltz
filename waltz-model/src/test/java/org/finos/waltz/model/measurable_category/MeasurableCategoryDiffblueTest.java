package org.finos.waltz.model.measurable_category;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MeasurableCategoryDiffblueTest {
  /**
   * Test {@link MeasurableCategory#kind()}.
   *
   * <p>Method under test: {@link MeasurableCategory#kind()}
   */
  @Test
  @DisplayName("Test kind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind MeasurableCategory.kind()"})
  void testKind() {
    // Arrange, Act and Assert
    assertEquals(
        EntityKind.ALL,
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build()
            .kind());
  }

  /**
   * Test {@link MeasurableCategory#editable()}.
   *
   * <p>Method under test: {@link MeasurableCategory#editable()}
   */
  @Test
  @DisplayName("Test editable()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableCategory.editable()"})
  void testEditable() {
    // Arrange, Act and Assert
    assertFalse(
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build()
            .editable());
  }

  /**
   * Test {@link MeasurableCategory#isDeprecated()}.
   *
   * <p>Method under test: {@link MeasurableCategory#isDeprecated()}
   */
  @Test
  @DisplayName("Test isDeprecated()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableCategory.isDeprecated()"})
  void testIsDeprecated() {
    // Arrange, Act and Assert
    assertFalse(
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build()
            .isDeprecated());
  }

  /**
   * Test {@link MeasurableCategory#ratingEditorRole()}.
   *
   * <p>Method under test: {@link MeasurableCategory#ratingEditorRole()}
   */
  @Test
  @DisplayName("Test ratingEditorRole()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String MeasurableCategory.ratingEditorRole()"})
  void testRatingEditorRole() {
    // Arrange, Act and Assert
    assertEquals(
        "Rating Editor Role",
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build()
            .ratingEditorRole());
  }

  /**
   * Test {@link MeasurableCategory#entityReference()}.
   *
   * <ul>
   *   <li>Then return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableCategory#entityReference()}
   */
  @Test
  @DisplayName("Test entityReference(); then return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference MeasurableCategory.entityReference()"})
  void testEntityReference_thenReturnImmutableEntityReference() {
    // Arrange and Act
    EntityReference actualEntityReferenceResult =
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build()
            .entityReference();

    // Assert
    assertTrue(actualEntityReferenceResult instanceof ImmutableEntityReference);
    assertEquals(
        "The characteristics of someone or something", actualEntityReferenceResult.description());
    assertEquals(1L, actualEntityReferenceResult.id());
    assertEquals(EntityKind.MEASURABLE_CATEGORY, actualEntityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualEntityReferenceResult.entityLifecycleStatus());
  }
}
