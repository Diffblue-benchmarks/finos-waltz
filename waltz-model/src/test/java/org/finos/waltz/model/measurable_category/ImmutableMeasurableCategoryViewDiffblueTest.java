package org.finos.waltz.model.measurable_category;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.measurable_category.ImmutableMeasurableCategoryView.Builder;
import org.finos.waltz.model.measurable_category.ImmutableMeasurableCategoryView.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableMeasurableCategoryViewDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMeasurableCategoryView Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableMeasurableCategoryView.builder();
    ImmutableMeasurableCategory category =
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
            .build();
    ImmutableMeasurableCategoryView actualImmutableMeasurableCategoryView =
        actualBuilderResult.category(category).ratingCount(3L).build();

    // Assert
    assertEquals(3L, actualImmutableMeasurableCategoryView.ratingCount().longValue());
    assertSame(category, actualImmutableMeasurableCategoryView.category());
  }

  /**
   * Test Builder {@link Builder#category(MeasurableCategory)}.
   *
   * <ul>
   *   <li>When {@link ImmutableMeasurableCategory.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#category(MeasurableCategory)}
   */
  @Test
  @DisplayName(
      "Test Builder category(MeasurableCategory); when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.category(MeasurableCategory)"})
  void testBuilderCategory_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategoryView.builder();

    // Act
    Builder actualCategoryResult = builderResult.category(new ImmutableMeasurableCategory.Json());

    // Assert
    assertSame(builderResult, actualCategoryResult);
  }

  /**
   * Test Builder {@link Builder#from(MeasurableCategoryView)}.
   *
   * <p>Method under test: {@link Builder#from(MeasurableCategoryView)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableCategoryView)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(MeasurableCategoryView)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategoryView.builder();

    Builder builderResult2 = ImmutableMeasurableCategoryView.builder();
    ImmutableMeasurableCategoryView instance =
        builderResult2
            .category(
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
                    .build())
            .ratingCount(3L)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableMeasurableCategoryView actualImmutableMeasurableCategoryView = builderResult.build();
    assertEquals(instance, actualImmutableMeasurableCategoryView);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#ratingCount(Long)}.
   *
   * <p>Method under test: {@link Builder#ratingCount(Long)}
   */
  @Test
  @DisplayName("Test Builder ratingCount(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.ratingCount(Long)"})
  void testBuilderRatingCount() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategoryView.builder();

    // Act
    Builder actualRatingCountResult = builderResult.ratingCount(3L);

    // Assert
    assertSame(builderResult, actualRatingCountResult);
  }

  /**
   * Test {@link ImmutableMeasurableCategoryView#copyOf(MeasurableCategoryView)}.
   *
   * <ul>
   *   <li>Then category return {@link ImmutableMeasurableCategory}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableCategoryView#copyOf(MeasurableCategoryView)}
   */
  @Test
  @DisplayName(
      "Test copyOf(MeasurableCategoryView); then category return ImmutableMeasurableCategory")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableCategoryView ImmutableMeasurableCategoryView.copyOf(MeasurableCategoryView)"
  })
  void testCopyOf_thenCategoryReturnImmutableMeasurableCategory() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategoryView.builder();
    ImmutableMeasurableCategoryView instance =
        builderResult
            .category(
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
                    .build())
            .ratingCount(3L)
            .build();

    // Act
    ImmutableMeasurableCategoryView actualCopyOfResult =
        ImmutableMeasurableCategoryView.copyOf(instance);

    // Assert
    MeasurableCategory categoryResult = actualCopyOfResult.category();
    assertTrue(categoryResult instanceof ImmutableMeasurableCategory);
    assertEquals("2020-03-01", categoryResult.lastUpdatedBy());
    assertEquals("Icon", categoryResult.icon());
    assertEquals("Name", categoryResult.name());
    assertEquals("Rating Editor Role", categoryResult.ratingEditorRole());
    assertEquals("The characteristics of someone or something", categoryResult.description());
    assertEquals(0, categoryResult.position());
    assertEquals(1L, categoryResult.ratingSchemeId());
    assertEquals(3L, actualCopyOfResult.ratingCount().longValue());
    assertEquals(EntityKind.ALL, categoryResult.kind());
    assertFalse(categoryResult.editable());
    assertFalse(categoryResult.isDeprecated());
    assertTrue(categoryResult.allowPrimaryRatings());
  }

  /**
   * Test {@link ImmutableMeasurableCategoryView#equals(Object)}, and {@link
   * ImmutableMeasurableCategoryView#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableMeasurableCategoryView#equals(Object)}
   *   <li>{@link ImmutableMeasurableCategoryView#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableCategoryView.equals(Object)",
    "int ImmutableMeasurableCategoryView.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategoryView.builder();
    ImmutableMeasurableCategoryView immutableMeasurableCategoryView =
        builderResult
            .category(
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
                    .build())
            .ratingCount(3L)
            .build();

    Builder builderResult2 = ImmutableMeasurableCategoryView.builder();
    ImmutableMeasurableCategoryView immutableMeasurableCategoryView2 =
        builderResult2
            .category(
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
                    .build())
            .ratingCount(3L)
            .build();

    // Act and Assert
    assertEquals(immutableMeasurableCategoryView, immutableMeasurableCategoryView2);
    assertEquals(
        immutableMeasurableCategoryView.hashCode(), immutableMeasurableCategoryView2.hashCode());
  }

  /**
   * Test {@link ImmutableMeasurableCategoryView#equals(Object)}, and {@link
   * ImmutableMeasurableCategoryView#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableMeasurableCategoryView#equals(Object)}
   *   <li>{@link ImmutableMeasurableCategoryView#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableCategoryView.equals(Object)",
    "int ImmutableMeasurableCategoryView.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategoryView.builder();
    ImmutableMeasurableCategoryView immutableMeasurableCategoryView =
        builderResult
            .category(
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
                    .build())
            .ratingCount(3L)
            .build();

    // Act and Assert
    assertEquals(immutableMeasurableCategoryView, immutableMeasurableCategoryView);
    int expectedHashCodeResult = immutableMeasurableCategoryView.hashCode();
    assertEquals(expectedHashCodeResult, immutableMeasurableCategoryView.hashCode());
  }

  /**
   * Test {@link ImmutableMeasurableCategoryView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableCategoryView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableCategoryView.equals(Object)",
    "int ImmutableMeasurableCategoryView.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategoryView.builder();
    ImmutableMeasurableCategoryView immutableMeasurableCategoryView =
        builderResult
            .category(
                ImmutableMeasurableCategory.builder()
                    .allowPrimaryRatings(false)
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
                    .build())
            .ratingCount(3L)
            .build();

    Builder builderResult2 = ImmutableMeasurableCategoryView.builder();

    // Act and Assert
    assertNotEquals(
        immutableMeasurableCategoryView,
        builderResult2
            .category(
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
                    .build())
            .ratingCount(3L)
            .build());
  }

  /**
   * Test {@link ImmutableMeasurableCategoryView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableCategoryView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableCategoryView.equals(Object)",
    "int ImmutableMeasurableCategoryView.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategoryView.builder();
    ImmutableMeasurableCategoryView immutableMeasurableCategoryView =
        builderResult
            .category(
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
                    .build())
            .ratingCount(1L)
            .build();

    Builder builderResult2 = ImmutableMeasurableCategoryView.builder();

    // Act and Assert
    assertNotEquals(
        immutableMeasurableCategoryView,
        builderResult2
            .category(
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
                    .build())
            .ratingCount(3L)
            .build());
  }

  /**
   * Test {@link ImmutableMeasurableCategoryView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableCategoryView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableCategoryView.equals(Object)",
    "int ImmutableMeasurableCategoryView.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategoryView.builder();

    // Act and Assert
    assertNotEquals(
        builderResult
            .category(
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
                    .build())
            .ratingCount(3L)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableMeasurableCategoryView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableCategoryView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableCategoryView.equals(Object)",
    "int ImmutableMeasurableCategoryView.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategoryView.builder();

    // Act and Assert
    assertNotEquals(
        builderResult
            .category(
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
                    .build())
            .ratingCount(3L)
            .build(),
        "Different type to ImmutableMeasurableCategoryView");
  }

  /**
   * Test {@link ImmutableMeasurableCategoryView#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link ImmutableMeasurableCategory.Json} (default constructor).
   *   <li>When {@link Json} (default constructor) Category is {@link
   *       ImmutableMeasurableCategory.Json} (default constructor).
   *   <li>Then category return {@link ImmutableMeasurableCategory.Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableCategoryView#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given Json (default constructor); when Json (default constructor) Category is Json (default constructor); then category return Json")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableCategoryView ImmutableMeasurableCategoryView.fromJson(Json)"
  })
  void testFromJson_givenJson_whenJsonCategoryIsJson_thenCategoryReturnJson() {
    // Arrange
    Json json = new Json();
    ImmutableMeasurableCategory.Json category = new ImmutableMeasurableCategory.Json();
    json.setCategory(category);
    json.setRatingCount(1L);

    // Act
    ImmutableMeasurableCategoryView actualFromJsonResult =
        ImmutableMeasurableCategoryView.fromJson(json);

    // Assert
    MeasurableCategory categoryResult = actualFromJsonResult.category();
    assertTrue(categoryResult instanceof ImmutableMeasurableCategory.Json);
    assertEquals(1L, actualFromJsonResult.ratingCount().longValue());
    assertSame(category, categoryResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableMeasurableCategoryView#toString()}
   *   <li>{@link ImmutableMeasurableCategoryView#category()}
   *   <li>{@link ImmutableMeasurableCategoryView#ratingCount()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MeasurableCategory ImmutableMeasurableCategoryView.category()",
    "Long ImmutableMeasurableCategoryView.ratingCount()",
    "String ImmutableMeasurableCategoryView.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategoryView.builder();
    ImmutableMeasurableCategoryView immutableMeasurableCategoryView =
        builderResult
            .category(
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
                    .build())
            .ratingCount(3L)
            .build();

    // Act
    String actualToStringResult = immutableMeasurableCategoryView.toString();
    MeasurableCategory actualCategoryResult = immutableMeasurableCategoryView.category();

    // Assert
    assertTrue(actualCategoryResult instanceof ImmutableMeasurableCategory);
    assertEquals(
        "MeasurableCategoryView{category=MeasurableCategory{id=1, name=Name, externalId=42, lastUpdatedAt=1970"
            + "-01-01T00:00, lastUpdatedBy=2020-03-01, icon=Icon, position=0, kind=ALL, editable=false, isDeprecated=false,"
            + " ratingEditorRole=Rating Editor Role, ratingSchemeId=1, constrainingAssessmentDefinitionId=1,"
            + " allowPrimaryRatings=true}, ratingCount=3}",
        actualToStringResult);
    assertEquals(3L, immutableMeasurableCategoryView.ratingCount().longValue());
  }

  /**
   * Test Json {@link Json#category()}.
   *
   * <p>Method under test: {@link Json#category()}
   */
  @Test
  @DisplayName("Test Json category()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MeasurableCategory Json.category()"})
  void testJsonCategory() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().category());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setCategory(MeasurableCategory)}
   *   <li>{@link Json#setRatingCount(Long)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setCategory(MeasurableCategory)",
    "void Json.setRatingCount(Long)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setCategory(
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
            .build());
    actualJson.setRatingCount(3L);

    // Assert
    assertEquals(3L, actualJson.ratingCount.longValue());
  }

  /**
   * Test Json {@link Json#ratingCount()}.
   *
   * <p>Method under test: {@link Json#ratingCount()}
   */
  @Test
  @DisplayName("Test Json ratingCount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long Json.ratingCount()"})
  void testJsonRatingCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().ratingCount());
  }

  /**
   * Test {@link ImmutableMeasurableCategoryView#withCategory(MeasurableCategory)}.
   *
   * <p>Method under test: {@link ImmutableMeasurableCategoryView#withCategory(MeasurableCategory)}
   */
  @Test
  @DisplayName("Test withCategory(MeasurableCategory)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableCategoryView ImmutableMeasurableCategoryView.withCategory(MeasurableCategory)"
  })
  void testWithCategory() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategoryView.builder();
    ImmutableMeasurableCategoryView immutableMeasurableCategoryView =
        builderResult
            .category(
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
                    .build())
            .ratingCount(3L)
            .build();

    // Act
    ImmutableMeasurableCategoryView actualWithCategoryResult =
        immutableMeasurableCategoryView.withCategory(
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
                .build());

    // Assert
    assertEquals(immutableMeasurableCategoryView, actualWithCategoryResult);
  }

  /**
   * Test {@link ImmutableMeasurableCategoryView#withRatingCount(Long)}.
   *
   * <p>Method under test: {@link ImmutableMeasurableCategoryView#withRatingCount(Long)}
   */
  @Test
  @DisplayName("Test withRatingCount(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableCategoryView ImmutableMeasurableCategoryView.withRatingCount(Long)"
  })
  void testWithRatingCount() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategoryView.builder();
    ImmutableMeasurableCategoryView immutableMeasurableCategoryView =
        builderResult
            .category(
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
                    .build())
            .ratingCount(3L)
            .build();

    // Act
    ImmutableMeasurableCategoryView actualWithRatingCountResult =
        immutableMeasurableCategoryView.withRatingCount(3L);

    // Assert
    assertSame(immutableMeasurableCategoryView, actualWithRatingCountResult);
  }

  /**
   * Test {@link ImmutableMeasurableCategoryView#withRatingCount(Long)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then category return {@link ImmutableMeasurableCategory}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableCategoryView#withRatingCount(Long)}
   */
  @Test
  @DisplayName(
      "Test withRatingCount(Long); when forty-two; then category return ImmutableMeasurableCategory")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableCategoryView ImmutableMeasurableCategoryView.withRatingCount(Long)"
  })
  void testWithRatingCount_whenFortyTwo_thenCategoryReturnImmutableMeasurableCategory() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategoryView.builder();

    // Act
    ImmutableMeasurableCategoryView actualWithRatingCountResult =
        builderResult
            .category(
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
                    .build())
            .ratingCount(3L)
            .build()
            .withRatingCount(42L);

    // Assert
    MeasurableCategory categoryResult = actualWithRatingCountResult.category();
    assertTrue(categoryResult instanceof ImmutableMeasurableCategory);
    assertEquals("2020-03-01", categoryResult.lastUpdatedBy());
    assertEquals("Icon", categoryResult.icon());
    assertEquals("Name", categoryResult.name());
    assertEquals("Rating Editor Role", categoryResult.ratingEditorRole());
    assertEquals("The characteristics of someone or something", categoryResult.description());
    assertEquals(0, categoryResult.position());
    assertEquals(1L, categoryResult.ratingSchemeId());
    assertEquals(42L, actualWithRatingCountResult.ratingCount().longValue());
    assertEquals(EntityKind.ALL, categoryResult.kind());
    assertFalse(categoryResult.editable());
    assertFalse(categoryResult.isDeprecated());
    assertTrue(categoryResult.allowPrimaryRatings());
  }
}
