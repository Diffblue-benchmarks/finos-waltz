package org.finos.waltz.model.measurable_rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.measurable_rating.ImmutablePrimaryRatingViewItem.Builder;
import org.finos.waltz.model.measurable_rating.ImmutablePrimaryRatingViewItem.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutablePrimaryRatingViewItemDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePrimaryRatingViewItem Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutablePrimaryRatingViewItem.builder();
    ImmutableEntityReference measurable =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Builder actualMeasurableResult = actualBuilderResult.measurable(measurable);
    ImmutableEntityReference measurableCategory =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ImmutablePrimaryRatingViewItem actualImmutablePrimaryRatingViewItem =
        actualMeasurableResult
            .measurableCategory(measurableCategory)
            .ratingColor("Rating Color")
            .ratingDescription("Rating Description")
            .ratingName("Rating Name")
            .build();

    // Assert
    assertEquals("Rating Color", actualImmutablePrimaryRatingViewItem.ratingColor());
    assertEquals("Rating Description", actualImmutablePrimaryRatingViewItem.ratingDescription());
    assertEquals("Rating Name", actualImmutablePrimaryRatingViewItem.ratingName());
    assertSame(measurable, actualImmutablePrimaryRatingViewItem.measurable());
    assertSame(measurableCategory, actualImmutablePrimaryRatingViewItem.measurableCategory());
  }

  /**
   * Test Builder {@link Builder#from(PrimaryRatingViewItem)}.
   *
   * <p>Method under test: {@link Builder#from(PrimaryRatingViewItem)}
   */
  @Test
  @DisplayName("Test Builder from(PrimaryRatingViewItem)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(PrimaryRatingViewItem)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutablePrimaryRatingViewItem.builder();

    Builder builderResult2 = ImmutablePrimaryRatingViewItem.builder();

    Builder measurableResult =
        builderResult2.measurable(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePrimaryRatingViewItem instance =
        measurableResult
            .measurableCategory(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .ratingColor("Rating Color")
            .ratingDescription("Rating Description")
            .ratingName("Rating Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutablePrimaryRatingViewItem actualImmutablePrimaryRatingViewItem = builderResult.build();
    assertEquals(instance, actualImmutablePrimaryRatingViewItem);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#measurableCategory(EntityReference)}.
   *
   * <ul>
   *   <li>When {@link EntityReference}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#measurableCategory(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test Builder measurableCategory(EntityReference); when EntityReference; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.measurableCategory(EntityReference)"})
  void testBuilderMeasurableCategory_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePrimaryRatingViewItem.builder();

    // Act
    Builder actualMeasurableCategoryResult =
        builderResult.measurableCategory(mock(EntityReference.class));

    // Assert
    assertSame(builderResult, actualMeasurableCategoryResult);
  }

  /**
   * Test Builder {@link Builder#measurable(EntityReference)}.
   *
   * <ul>
   *   <li>When {@link EntityReference}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#measurable(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test Builder measurable(EntityReference); when EntityReference; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.measurable(EntityReference)"})
  void testBuilderMeasurable_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePrimaryRatingViewItem.builder();

    // Act
    Builder actualMeasurableResult = builderResult.measurable(mock(EntityReference.class));

    // Assert
    assertSame(builderResult, actualMeasurableResult);
  }

  /**
   * Test Builder {@link Builder#ratingColor(String)}.
   *
   * <ul>
   *   <li>When {@code Rating Color}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#ratingColor(String)}
   */
  @Test
  @DisplayName("Test Builder ratingColor(String); when 'Rating Color'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.ratingColor(String)"})
  void testBuilderRatingColor_whenRatingColor_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePrimaryRatingViewItem.builder();

    // Act
    Builder actualRatingColorResult = builderResult.ratingColor("Rating Color");

    // Assert
    assertSame(builderResult, actualRatingColorResult);
  }

  /**
   * Test Builder {@link Builder#ratingDescription(String)}.
   *
   * <ul>
   *   <li>When {@code Rating Description}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#ratingDescription(String)}
   */
  @Test
  @DisplayName(
      "Test Builder ratingDescription(String); when 'Rating Description'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.ratingDescription(String)"})
  void testBuilderRatingDescription_whenRatingDescription_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePrimaryRatingViewItem.builder();

    // Act
    Builder actualRatingDescriptionResult = builderResult.ratingDescription("Rating Description");

    // Assert
    assertSame(builderResult, actualRatingDescriptionResult);
  }

  /**
   * Test Builder {@link Builder#ratingName(String)}.
   *
   * <ul>
   *   <li>When {@code Rating Name}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#ratingName(String)}
   */
  @Test
  @DisplayName("Test Builder ratingName(String); when 'Rating Name'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.ratingName(String)"})
  void testBuilderRatingName_whenRatingName_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePrimaryRatingViewItem.builder();

    // Act
    Builder actualRatingNameResult = builderResult.ratingName("Rating Name");

    // Assert
    assertSame(builderResult, actualRatingNameResult);
  }

  /**
   * Test {@link ImmutablePrimaryRatingViewItem#copyOf(PrimaryRatingViewItem)}.
   *
   * <ul>
   *   <li>Then measurable return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePrimaryRatingViewItem#copyOf(PrimaryRatingViewItem)}
   */
  @Test
  @DisplayName(
      "Test copyOf(PrimaryRatingViewItem); then measurable return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePrimaryRatingViewItem ImmutablePrimaryRatingViewItem.copyOf(PrimaryRatingViewItem)"
  })
  void testCopyOf_thenMeasurableReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutablePrimaryRatingViewItem.builder();

    Builder measurableResult =
        builderResult.measurable(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePrimaryRatingViewItem instance =
        measurableResult
            .measurableCategory(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .ratingColor("Rating Color")
            .ratingDescription("Rating Description")
            .ratingName("Rating Name")
            .build();

    // Act
    ImmutablePrimaryRatingViewItem actualCopyOfResult =
        ImmutablePrimaryRatingViewItem.copyOf(instance);

    // Assert
    EntityReference measurableResult2 = actualCopyOfResult.measurable();
    assertTrue(measurableResult2 instanceof ImmutableEntityReference);
    EntityReference measurableCategoryResult = actualCopyOfResult.measurableCategory();
    assertTrue(measurableCategoryResult instanceof ImmutableEntityReference);
    assertEquals("Rating Color", actualCopyOfResult.ratingColor());
    assertEquals("Rating Description", actualCopyOfResult.ratingDescription());
    assertEquals("Rating Name", actualCopyOfResult.ratingName());
    assertEquals("The characteristics of someone or something", measurableResult2.description());
    assertEquals(1L, measurableResult2.id());
    assertEquals(EntityKind.ALL, measurableResult2.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, measurableResult2.entityLifecycleStatus());
    assertEquals(measurableResult2, measurableCategoryResult);
  }

  /**
   * Test {@link ImmutablePrimaryRatingViewItem#equals(Object)}, and {@link
   * ImmutablePrimaryRatingViewItem#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePrimaryRatingViewItem#equals(Object)}
   *   <li>{@link ImmutablePrimaryRatingViewItem#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePrimaryRatingViewItem.equals(Object)",
    "int ImmutablePrimaryRatingViewItem.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutablePrimaryRatingViewItem.builder();

    Builder measurableResult =
        builderResult.measurable(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePrimaryRatingViewItem immutablePrimaryRatingViewItem =
        measurableResult
            .measurableCategory(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .ratingColor("Rating Color")
            .ratingDescription("Rating Description")
            .ratingName("Rating Name")
            .build();

    Builder builderResult2 = ImmutablePrimaryRatingViewItem.builder();

    Builder measurableResult2 =
        builderResult2.measurable(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePrimaryRatingViewItem immutablePrimaryRatingViewItem2 =
        measurableResult2
            .measurableCategory(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .ratingColor("Rating Color")
            .ratingDescription("Rating Description")
            .ratingName("Rating Name")
            .build();

    // Act and Assert
    assertEquals(immutablePrimaryRatingViewItem, immutablePrimaryRatingViewItem2);
    assertEquals(
        immutablePrimaryRatingViewItem.hashCode(), immutablePrimaryRatingViewItem2.hashCode());
  }

  /**
   * Test {@link ImmutablePrimaryRatingViewItem#equals(Object)}, and {@link
   * ImmutablePrimaryRatingViewItem#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePrimaryRatingViewItem#equals(Object)}
   *   <li>{@link ImmutablePrimaryRatingViewItem#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePrimaryRatingViewItem.equals(Object)",
    "int ImmutablePrimaryRatingViewItem.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutablePrimaryRatingViewItem.builder();

    Builder measurableResult =
        builderResult.measurable(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePrimaryRatingViewItem immutablePrimaryRatingViewItem =
        measurableResult
            .measurableCategory(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .ratingColor("Rating Color")
            .ratingDescription("Rating Description")
            .ratingName("Rating Name")
            .build();

    // Act and Assert
    assertEquals(immutablePrimaryRatingViewItem, immutablePrimaryRatingViewItem);
    int expectedHashCodeResult = immutablePrimaryRatingViewItem.hashCode();
    assertEquals(expectedHashCodeResult, immutablePrimaryRatingViewItem.hashCode());
  }

  /**
   * Test {@link ImmutablePrimaryRatingViewItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePrimaryRatingViewItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePrimaryRatingViewItem.equals(Object)",
    "int ImmutablePrimaryRatingViewItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutablePrimaryRatingViewItem.builder();

    Builder measurableResult =
        builderResult.measurable(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePrimaryRatingViewItem immutablePrimaryRatingViewItem =
        measurableResult
            .measurableCategory(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .ratingColor("Rating Color")
            .ratingDescription("Rating Description")
            .ratingName("Rating Name")
            .build();

    Builder builderResult2 = ImmutablePrimaryRatingViewItem.builder();

    Builder measurableResult2 =
        builderResult2.measurable(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertNotEquals(
        immutablePrimaryRatingViewItem,
        measurableResult2
            .measurableCategory(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .ratingColor("Rating Color")
            .ratingDescription("Rating Description")
            .ratingName("Rating Name")
            .build());
  }

  /**
   * Test {@link ImmutablePrimaryRatingViewItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePrimaryRatingViewItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePrimaryRatingViewItem.equals(Object)",
    "int ImmutablePrimaryRatingViewItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutablePrimaryRatingViewItem.builder();

    Builder measurableResult =
        builderResult.measurable(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePrimaryRatingViewItem immutablePrimaryRatingViewItem =
        measurableResult
            .measurableCategory(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .ratingColor("Rating Color")
            .ratingDescription("Rating Description")
            .ratingName("Rating Name")
            .build();

    Builder builderResult2 = ImmutablePrimaryRatingViewItem.builder();

    Builder measurableResult2 =
        builderResult2.measurable(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertNotEquals(
        immutablePrimaryRatingViewItem,
        measurableResult2
            .measurableCategory(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .ratingColor("Rating Color")
            .ratingDescription("Rating Description")
            .ratingName("Rating Name")
            .build());
  }

  /**
   * Test {@link ImmutablePrimaryRatingViewItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePrimaryRatingViewItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePrimaryRatingViewItem.equals(Object)",
    "int ImmutablePrimaryRatingViewItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutablePrimaryRatingViewItem.builder();

    Builder measurableResult =
        builderResult.measurable(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePrimaryRatingViewItem immutablePrimaryRatingViewItem =
        measurableResult
            .measurableCategory(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .ratingColor("Rating Name")
            .ratingDescription("Rating Description")
            .ratingName("Rating Name")
            .build();

    Builder builderResult2 = ImmutablePrimaryRatingViewItem.builder();

    Builder measurableResult2 =
        builderResult2.measurable(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertNotEquals(
        immutablePrimaryRatingViewItem,
        measurableResult2
            .measurableCategory(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .ratingColor("Rating Color")
            .ratingDescription("Rating Description")
            .ratingName("Rating Name")
            .build());
  }

  /**
   * Test {@link ImmutablePrimaryRatingViewItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePrimaryRatingViewItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePrimaryRatingViewItem.equals(Object)",
    "int ImmutablePrimaryRatingViewItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder builderResult = ImmutablePrimaryRatingViewItem.builder();

    Builder measurableResult =
        builderResult.measurable(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePrimaryRatingViewItem immutablePrimaryRatingViewItem =
        measurableResult
            .measurableCategory(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .ratingColor("Rating Color")
            .ratingDescription("Rating Name")
            .ratingName("Rating Name")
            .build();

    Builder builderResult2 = ImmutablePrimaryRatingViewItem.builder();

    Builder measurableResult2 =
        builderResult2.measurable(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertNotEquals(
        immutablePrimaryRatingViewItem,
        measurableResult2
            .measurableCategory(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .ratingColor("Rating Color")
            .ratingDescription("Rating Description")
            .ratingName("Rating Name")
            .build());
  }

  /**
   * Test {@link ImmutablePrimaryRatingViewItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePrimaryRatingViewItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePrimaryRatingViewItem.equals(Object)",
    "int ImmutablePrimaryRatingViewItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder builderResult = ImmutablePrimaryRatingViewItem.builder();

    Builder measurableResult =
        builderResult.measurable(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePrimaryRatingViewItem immutablePrimaryRatingViewItem =
        measurableResult
            .measurableCategory(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .ratingColor("Rating Color")
            .ratingDescription("Rating Description")
            .ratingName("Rating Description")
            .build();

    Builder builderResult2 = ImmutablePrimaryRatingViewItem.builder();

    Builder measurableResult2 =
        builderResult2.measurable(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertNotEquals(
        immutablePrimaryRatingViewItem,
        measurableResult2
            .measurableCategory(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .ratingColor("Rating Color")
            .ratingDescription("Rating Description")
            .ratingName("Rating Name")
            .build());
  }

  /**
   * Test {@link ImmutablePrimaryRatingViewItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePrimaryRatingViewItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePrimaryRatingViewItem.equals(Object)",
    "int ImmutablePrimaryRatingViewItem.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutablePrimaryRatingViewItem.builder();

    Builder measurableResult =
        builderResult.measurable(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertNotEquals(
        measurableResult
            .measurableCategory(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .ratingColor("Rating Color")
            .ratingDescription("Rating Description")
            .ratingName("Rating Name")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutablePrimaryRatingViewItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePrimaryRatingViewItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePrimaryRatingViewItem.equals(Object)",
    "int ImmutablePrimaryRatingViewItem.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutablePrimaryRatingViewItem.builder();

    Builder measurableResult =
        builderResult.measurable(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertNotEquals(
        measurableResult
            .measurableCategory(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .ratingColor("Rating Color")
            .ratingDescription("Rating Description")
            .ratingName("Rating Name")
            .build(),
        "Different type to ImmutablePrimaryRatingViewItem");
  }

  /**
   * Test {@link ImmutablePrimaryRatingViewItem#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return ratingColor is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePrimaryRatingViewItem#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return ratingColor is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePrimaryRatingViewItem ImmutablePrimaryRatingViewItem.fromJson(Json)"
  })
  void testFromJson_thenReturnRatingColorIsJson() {
    // Arrange
    Json json = new Json();
    json.setMeasurableCategory(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setMeasurable(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setRatingName("Json");
    json.setRatingDescription("Json");
    json.setRatingColor("Json");

    // Act
    ImmutablePrimaryRatingViewItem actualFromJsonResult =
        ImmutablePrimaryRatingViewItem.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.ratingColor());
    assertEquals("Json", actualFromJsonResult.ratingDescription());
    assertEquals("Json", actualFromJsonResult.ratingName());
    EntityReference expectedMeasurableResult = json.measurable;
    assertSame(expectedMeasurableResult, actualFromJsonResult.measurable());
    EntityReference expectedMeasurableCategoryResult = json.measurableCategory;
    assertSame(expectedMeasurableCategoryResult, actualFromJsonResult.measurableCategory());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePrimaryRatingViewItem#toString()}
   *   <li>{@link ImmutablePrimaryRatingViewItem#measurable()}
   *   <li>{@link ImmutablePrimaryRatingViewItem#measurableCategory()}
   *   <li>{@link ImmutablePrimaryRatingViewItem#ratingColor()}
   *   <li>{@link ImmutablePrimaryRatingViewItem#ratingDescription()}
   *   <li>{@link ImmutablePrimaryRatingViewItem#ratingName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityReference ImmutablePrimaryRatingViewItem.measurable()",
    "EntityReference ImmutablePrimaryRatingViewItem.measurableCategory()",
    "String ImmutablePrimaryRatingViewItem.ratingColor()",
    "String ImmutablePrimaryRatingViewItem.ratingDescription()",
    "String ImmutablePrimaryRatingViewItem.ratingName()",
    "String ImmutablePrimaryRatingViewItem.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutablePrimaryRatingViewItem.builder();

    Builder measurableResult =
        builderResult.measurable(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePrimaryRatingViewItem immutablePrimaryRatingViewItem =
        measurableResult
            .measurableCategory(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .ratingColor("Rating Color")
            .ratingDescription("Rating Description")
            .ratingName("Rating Name")
            .build();

    // Act
    String actualToStringResult = immutablePrimaryRatingViewItem.toString();
    EntityReference actualMeasurableResult = immutablePrimaryRatingViewItem.measurable();
    EntityReference actualMeasurableCategoryResult =
        immutablePrimaryRatingViewItem.measurableCategory();
    String actualRatingColorResult = immutablePrimaryRatingViewItem.ratingColor();
    String actualRatingDescriptionResult = immutablePrimaryRatingViewItem.ratingDescription();

    // Assert
    assertTrue(actualMeasurableResult instanceof ImmutableEntityReference);
    assertTrue(actualMeasurableCategoryResult instanceof ImmutableEntityReference);
    assertEquals(
        "PrimaryRatingViewItem{measurableCategory=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE},"
            + " measurable=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}, ratingName=Rating Name,"
            + " ratingDescription=Rating Description, ratingColor=Rating Color}",
        actualToStringResult);
    assertEquals("Rating Color", actualRatingColorResult);
    assertEquals("Rating Description", actualRatingDescriptionResult);
    assertEquals("Rating Name", immutablePrimaryRatingViewItem.ratingName());
    assertEquals(actualMeasurableResult, actualMeasurableCategoryResult);
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setMeasurable(EntityReference)}
   *   <li>{@link Json#setMeasurableCategory(EntityReference)}
   *   <li>{@link Json#setRatingColor(String)}
   *   <li>{@link Json#setRatingDescription(String)}
   *   <li>{@link Json#setRatingName(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setMeasurable(EntityReference)",
    "void Json.setMeasurableCategory(EntityReference)",
    "void Json.setRatingColor(String)",
    "void Json.setRatingDescription(String)",
    "void Json.setRatingName(String)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    ImmutableEntityReference measurable =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    actualJson.setMeasurable(measurable);
    actualJson.setMeasurableCategory(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    actualJson.setRatingColor("Rating Color");
    actualJson.setRatingDescription("Rating Description");
    actualJson.setRatingName("Rating Name");

    // Assert
    EntityReference entityReference = actualJson.measurable;
    assertTrue(entityReference instanceof ImmutableEntityReference);
    EntityReference entityReference2 = actualJson.measurableCategory;
    assertTrue(entityReference2 instanceof ImmutableEntityReference);
    assertEquals("Rating Color", actualJson.ratingColor);
    assertEquals("Rating Description", actualJson.ratingDescription);
    assertEquals("Rating Name", actualJson.ratingName);
    assertEquals("The characteristics of someone or something", entityReference.description());
    assertEquals(1L, entityReference.id());
    assertEquals(EntityKind.ALL, entityReference.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReference.entityLifecycleStatus());
    assertEquals(measurable, entityReference2);
  }

  /**
   * Test Json {@link Json#measurable()}.
   *
   * <p>Method under test: {@link Json#measurable()}
   */
  @Test
  @DisplayName("Test Json measurable()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.measurable()"})
  void testJsonMeasurable() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().measurable());
  }

  /**
   * Test Json {@link Json#measurableCategory()}.
   *
   * <p>Method under test: {@link Json#measurableCategory()}
   */
  @Test
  @DisplayName("Test Json measurableCategory()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.measurableCategory()"})
  void testJsonMeasurableCategory() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().measurableCategory());
  }

  /**
   * Test Json {@link Json#ratingColor()}.
   *
   * <p>Method under test: {@link Json#ratingColor()}
   */
  @Test
  @DisplayName("Test Json ratingColor()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.ratingColor()"})
  void testJsonRatingColor() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().ratingColor());
  }

  /**
   * Test Json {@link Json#ratingDescription()}.
   *
   * <p>Method under test: {@link Json#ratingDescription()}
   */
  @Test
  @DisplayName("Test Json ratingDescription()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.ratingDescription()"})
  void testJsonRatingDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().ratingDescription());
  }

  /**
   * Test Json {@link Json#ratingName()}.
   *
   * <p>Method under test: {@link Json#ratingName()}
   */
  @Test
  @DisplayName("Test Json ratingName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.ratingName()"})
  void testJsonRatingName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().ratingName());
  }

  /**
   * Test {@link ImmutablePrimaryRatingViewItem#withMeasurable(EntityReference)}.
   *
   * <p>Method under test: {@link ImmutablePrimaryRatingViewItem#withMeasurable(EntityReference)}
   */
  @Test
  @DisplayName("Test withMeasurable(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePrimaryRatingViewItem ImmutablePrimaryRatingViewItem.withMeasurable(EntityReference)"
  })
  void testWithMeasurable() {
    // Arrange
    Builder builderResult = ImmutablePrimaryRatingViewItem.builder();

    Builder measurableResult =
        builderResult.measurable(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePrimaryRatingViewItem immutablePrimaryRatingViewItem =
        measurableResult
            .measurableCategory(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .ratingColor("Rating Color")
            .ratingDescription("Rating Description")
            .ratingName("Rating Name")
            .build();

    // Act
    ImmutablePrimaryRatingViewItem actualWithMeasurableResult =
        immutablePrimaryRatingViewItem.withMeasurable(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutablePrimaryRatingViewItem, actualWithMeasurableResult);
  }

  /**
   * Test {@link ImmutablePrimaryRatingViewItem#withMeasurableCategory(EntityReference)}.
   *
   * <p>Method under test: {@link
   * ImmutablePrimaryRatingViewItem#withMeasurableCategory(EntityReference)}
   */
  @Test
  @DisplayName("Test withMeasurableCategory(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePrimaryRatingViewItem ImmutablePrimaryRatingViewItem.withMeasurableCategory(EntityReference)"
  })
  void testWithMeasurableCategory() {
    // Arrange
    Builder builderResult = ImmutablePrimaryRatingViewItem.builder();

    Builder measurableResult =
        builderResult.measurable(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePrimaryRatingViewItem immutablePrimaryRatingViewItem =
        measurableResult
            .measurableCategory(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .ratingColor("Rating Color")
            .ratingDescription("Rating Description")
            .ratingName("Rating Name")
            .build();

    // Act
    ImmutablePrimaryRatingViewItem actualWithMeasurableCategoryResult =
        immutablePrimaryRatingViewItem.withMeasurableCategory(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutablePrimaryRatingViewItem, actualWithMeasurableCategoryResult);
  }

  /**
   * Test {@link ImmutablePrimaryRatingViewItem#withRatingColor(String)}.
   *
   * <p>Method under test: {@link ImmutablePrimaryRatingViewItem#withRatingColor(String)}
   */
  @Test
  @DisplayName("Test withRatingColor(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePrimaryRatingViewItem ImmutablePrimaryRatingViewItem.withRatingColor(String)"
  })
  void testWithRatingColor() {
    // Arrange
    Builder builderResult = ImmutablePrimaryRatingViewItem.builder();

    Builder measurableResult =
        builderResult.measurable(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePrimaryRatingViewItem immutablePrimaryRatingViewItem =
        measurableResult
            .measurableCategory(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .ratingColor("42")
            .ratingDescription("Rating Description")
            .ratingName("Rating Name")
            .build();

    // Act
    ImmutablePrimaryRatingViewItem actualWithRatingColorResult =
        immutablePrimaryRatingViewItem.withRatingColor("42");

    // Assert
    assertSame(immutablePrimaryRatingViewItem, actualWithRatingColorResult);
  }

  /**
   * Test {@link ImmutablePrimaryRatingViewItem#withRatingColor(String)}.
   *
   * <ul>
   *   <li>Then measurable return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePrimaryRatingViewItem#withRatingColor(String)}
   */
  @Test
  @DisplayName("Test withRatingColor(String); then measurable return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePrimaryRatingViewItem ImmutablePrimaryRatingViewItem.withRatingColor(String)"
  })
  void testWithRatingColor_thenMeasurableReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutablePrimaryRatingViewItem.builder();

    Builder measurableResult =
        builderResult.measurable(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    ImmutablePrimaryRatingViewItem actualWithRatingColorResult =
        measurableResult
            .measurableCategory(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .ratingColor("Rating Color")
            .ratingDescription("Rating Description")
            .ratingName("Rating Name")
            .build()
            .withRatingColor("42");

    // Assert
    EntityReference measurableResult2 = actualWithRatingColorResult.measurable();
    assertTrue(measurableResult2 instanceof ImmutableEntityReference);
    EntityReference measurableCategoryResult = actualWithRatingColorResult.measurableCategory();
    assertTrue(measurableCategoryResult instanceof ImmutableEntityReference);
    assertEquals("42", actualWithRatingColorResult.ratingColor());
    assertEquals("Rating Description", actualWithRatingColorResult.ratingDescription());
    assertEquals("Rating Name", actualWithRatingColorResult.ratingName());
    assertEquals("The characteristics of someone or something", measurableResult2.description());
    assertEquals(1L, measurableResult2.id());
    assertEquals(EntityKind.ALL, measurableResult2.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, measurableResult2.entityLifecycleStatus());
    assertEquals(measurableResult2, measurableCategoryResult);
  }

  /**
   * Test {@link ImmutablePrimaryRatingViewItem#withRatingDescription(String)}.
   *
   * <p>Method under test: {@link ImmutablePrimaryRatingViewItem#withRatingDescription(String)}
   */
  @Test
  @DisplayName("Test withRatingDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePrimaryRatingViewItem ImmutablePrimaryRatingViewItem.withRatingDescription(String)"
  })
  void testWithRatingDescription() {
    // Arrange
    Builder builderResult = ImmutablePrimaryRatingViewItem.builder();

    Builder measurableResult =
        builderResult.measurable(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePrimaryRatingViewItem immutablePrimaryRatingViewItem =
        measurableResult
            .measurableCategory(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .ratingColor("Rating Color")
            .ratingDescription("42")
            .ratingName("Rating Name")
            .build();

    // Act
    ImmutablePrimaryRatingViewItem actualWithRatingDescriptionResult =
        immutablePrimaryRatingViewItem.withRatingDescription("42");

    // Assert
    assertSame(immutablePrimaryRatingViewItem, actualWithRatingDescriptionResult);
  }

  /**
   * Test {@link ImmutablePrimaryRatingViewItem#withRatingDescription(String)}.
   *
   * <ul>
   *   <li>Then measurable return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePrimaryRatingViewItem#withRatingDescription(String)}
   */
  @Test
  @DisplayName(
      "Test withRatingDescription(String); then measurable return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePrimaryRatingViewItem ImmutablePrimaryRatingViewItem.withRatingDescription(String)"
  })
  void testWithRatingDescription_thenMeasurableReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutablePrimaryRatingViewItem.builder();

    Builder measurableResult =
        builderResult.measurable(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    ImmutablePrimaryRatingViewItem actualWithRatingDescriptionResult =
        measurableResult
            .measurableCategory(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .ratingColor("Rating Color")
            .ratingDescription("Rating Description")
            .ratingName("Rating Name")
            .build()
            .withRatingDescription("42");

    // Assert
    EntityReference measurableResult2 = actualWithRatingDescriptionResult.measurable();
    assertTrue(measurableResult2 instanceof ImmutableEntityReference);
    EntityReference measurableCategoryResult =
        actualWithRatingDescriptionResult.measurableCategory();
    assertTrue(measurableCategoryResult instanceof ImmutableEntityReference);
    assertEquals("42", actualWithRatingDescriptionResult.ratingDescription());
    assertEquals("Rating Color", actualWithRatingDescriptionResult.ratingColor());
    assertEquals("Rating Name", actualWithRatingDescriptionResult.ratingName());
    assertEquals("The characteristics of someone or something", measurableResult2.description());
    assertEquals(1L, measurableResult2.id());
    assertEquals(EntityKind.ALL, measurableResult2.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, measurableResult2.entityLifecycleStatus());
    assertEquals(measurableResult2, measurableCategoryResult);
  }

  /**
   * Test {@link ImmutablePrimaryRatingViewItem#withRatingName(String)}.
   *
   * <p>Method under test: {@link ImmutablePrimaryRatingViewItem#withRatingName(String)}
   */
  @Test
  @DisplayName("Test withRatingName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePrimaryRatingViewItem ImmutablePrimaryRatingViewItem.withRatingName(String)"
  })
  void testWithRatingName() {
    // Arrange
    Builder builderResult = ImmutablePrimaryRatingViewItem.builder();

    Builder measurableResult =
        builderResult.measurable(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePrimaryRatingViewItem immutablePrimaryRatingViewItem =
        measurableResult
            .measurableCategory(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .ratingColor("Rating Color")
            .ratingDescription("Rating Description")
            .ratingName("42")
            .build();

    // Act
    ImmutablePrimaryRatingViewItem actualWithRatingNameResult =
        immutablePrimaryRatingViewItem.withRatingName("42");

    // Assert
    assertSame(immutablePrimaryRatingViewItem, actualWithRatingNameResult);
  }

  /**
   * Test {@link ImmutablePrimaryRatingViewItem#withRatingName(String)}.
   *
   * <ul>
   *   <li>Then measurable return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePrimaryRatingViewItem#withRatingName(String)}
   */
  @Test
  @DisplayName("Test withRatingName(String); then measurable return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePrimaryRatingViewItem ImmutablePrimaryRatingViewItem.withRatingName(String)"
  })
  void testWithRatingName_thenMeasurableReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutablePrimaryRatingViewItem.builder();

    Builder measurableResult =
        builderResult.measurable(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    ImmutablePrimaryRatingViewItem actualWithRatingNameResult =
        measurableResult
            .measurableCategory(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .ratingColor("Rating Color")
            .ratingDescription("Rating Description")
            .ratingName("Rating Name")
            .build()
            .withRatingName("42");

    // Assert
    EntityReference measurableResult2 = actualWithRatingNameResult.measurable();
    assertTrue(measurableResult2 instanceof ImmutableEntityReference);
    EntityReference measurableCategoryResult = actualWithRatingNameResult.measurableCategory();
    assertTrue(measurableCategoryResult instanceof ImmutableEntityReference);
    assertEquals("42", actualWithRatingNameResult.ratingName());
    assertEquals("Rating Color", actualWithRatingNameResult.ratingColor());
    assertEquals("Rating Description", actualWithRatingNameResult.ratingDescription());
    assertEquals("The characteristics of someone or something", measurableResult2.description());
    assertEquals(1L, measurableResult2.id());
    assertEquals(EntityKind.ALL, measurableResult2.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, measurableResult2.entityLifecycleStatus());
    assertEquals(measurableResult2, measurableCategoryResult);
  }
}
