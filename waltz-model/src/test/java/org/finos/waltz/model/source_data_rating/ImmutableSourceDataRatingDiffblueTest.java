package org.finos.waltz.model.source_data_rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.rating.RagRating;
import org.finos.waltz.model.source_data_rating.ImmutableSourceDataRating.Builder;
import org.finos.waltz.model.source_data_rating.ImmutableSourceDataRating.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSourceDataRatingDiffblueTest {
  /**
   * Test Builder {@link Builder#accuracy(RagRating)}.
   *
   * <p>Method under test: {@link Builder#accuracy(RagRating)}
   */
  @Test
  @DisplayName("Test Builder accuracy(RagRating)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.accuracy(RagRating)"})
  void testBuilderAccuracy() {
    // Arrange
    Builder builderResult = ImmutableSourceDataRating.builder();

    // Act
    Builder actualAccuracyResult = builderResult.accuracy(RagRating.R);

    // Assert
    assertSame(builderResult, actualAccuracyResult);
  }

  /**
   * Test Builder {@link Builder#authoritativeness(RagRating)}.
   *
   * <p>Method under test: {@link Builder#authoritativeness(RagRating)}
   */
  @Test
  @DisplayName("Test Builder authoritativeness(RagRating)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.authoritativeness(RagRating)"})
  void testBuilderAuthoritativeness() {
    // Arrange
    Builder builderResult = ImmutableSourceDataRating.builder();

    // Act
    Builder actualAuthoritativenessResult = builderResult.authoritativeness(RagRating.R);

    // Assert
    assertSame(builderResult, actualAuthoritativenessResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#lastImportDate(LocalDateTime)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSourceDataRating Builder.build()",
    "Builder Builder.lastImportDate(LocalDateTime)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualLastImportDateResult =
        ImmutableSourceDataRating.builder()
            .accuracy(RagRating.R)
            .authoritativeness(RagRating.R)
            .completeness(RagRating.R)
            .entityKind(EntityKind.ALL)
            .lastImportDate(LocalDate.of(1970, 1, 1).atStartOfDay());
    Optional<? extends LocalDateTime> lastImportDate =
        Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    ImmutableSourceDataRating actualImmutableSourceDataRating =
        actualLastImportDateResult.lastImportDate(lastImportDate).sourceName("Source Name").build();

    // Assert
    assertEquals("Source Name", actualImmutableSourceDataRating.sourceName());
    assertEquals(EntityKind.ALL, actualImmutableSourceDataRating.entityKind());
    assertEquals(RagRating.R, actualImmutableSourceDataRating.accuracy());
    assertEquals(RagRating.R, actualImmutableSourceDataRating.authoritativeness());
    assertEquals(RagRating.R, actualImmutableSourceDataRating.completeness());
  }

  /**
   * Test Builder {@link Builder#completeness(RagRating)}.
   *
   * <p>Method under test: {@link Builder#completeness(RagRating)}
   */
  @Test
  @DisplayName("Test Builder completeness(RagRating)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.completeness(RagRating)"})
  void testBuilderCompleteness() {
    // Arrange
    Builder builderResult = ImmutableSourceDataRating.builder();

    // Act
    Builder actualCompletenessResult = builderResult.completeness(RagRating.R);

    // Assert
    assertSame(builderResult, actualCompletenessResult);
  }

  /**
   * Test Builder {@link Builder#entityKind(EntityKind)}.
   *
   * <p>Method under test: {@link Builder#entityKind(EntityKind)}
   */
  @Test
  @DisplayName("Test Builder entityKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.entityKind(EntityKind)"})
  void testBuilderEntityKind() {
    // Arrange
    Builder builderResult = ImmutableSourceDataRating.builder();

    // Act
    Builder actualEntityKindResult = builderResult.entityKind(EntityKind.ALL);

    // Assert
    assertSame(builderResult, actualEntityKindResult);
  }

  /**
   * Test Builder {@link Builder#from(SourceDataRating)}.
   *
   * <p>Method under test: {@link Builder#from(SourceDataRating)}
   */
  @Test
  @DisplayName("Test Builder from(SourceDataRating)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SourceDataRating)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableSourceDataRating.builder();
    ImmutableSourceDataRating instance =
        ImmutableSourceDataRating.builder()
            .accuracy(RagRating.R)
            .authoritativeness(RagRating.R)
            .completeness(RagRating.R)
            .entityKind(EntityKind.ALL)
            .lastImportDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .sourceName("Source Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableSourceDataRating actualImmutableSourceDataRating = builderResult.build();
    assertEquals(instance, actualImmutableSourceDataRating);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#lastImportDate(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#lastImportDate(Optional)}
   */
  @Test
  @DisplayName("Test Builder lastImportDate(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.lastImportDate(Optional)"})
  void testBuilderLastImportDateWithOptional() {
    // Arrange
    Builder builderResult = ImmutableSourceDataRating.builder();
    Optional<? extends LocalDateTime> lastImportDate =
        Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act
    Builder actualLastImportDateResult = builderResult.lastImportDate(lastImportDate);

    // Assert
    assertSame(builderResult, actualLastImportDateResult);
  }

  /**
   * Test Builder {@link Builder#sourceName(String)}.
   *
   * <ul>
   *   <li>When {@code Source Name}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#sourceName(String)}
   */
  @Test
  @DisplayName("Test Builder sourceName(String); when 'Source Name'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.sourceName(String)"})
  void testBuilderSourceName_whenSourceName_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSourceDataRating.builder();

    // Act
    Builder actualSourceNameResult = builderResult.sourceName("Source Name");

    // Assert
    assertSame(builderResult, actualSourceNameResult);
  }

  /**
   * Test {@link ImmutableSourceDataRating#copyOf(SourceDataRating)}.
   *
   * <ul>
   *   <li>Then return {@code Source Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSourceDataRating#copyOf(SourceDataRating)}
   */
  @Test
  @DisplayName("Test copyOf(SourceDataRating); then return 'Source Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSourceDataRating ImmutableSourceDataRating.copyOf(SourceDataRating)"
  })
  void testCopyOf_thenReturnSourceName() {
    // Arrange
    ImmutableSourceDataRating instance =
        ImmutableSourceDataRating.builder()
            .accuracy(RagRating.R)
            .authoritativeness(RagRating.R)
            .completeness(RagRating.R)
            .entityKind(EntityKind.ALL)
            .lastImportDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .sourceName("Source Name")
            .build();

    // Act
    ImmutableSourceDataRating actualCopyOfResult = ImmutableSourceDataRating.copyOf(instance);

    // Assert
    assertEquals("Source Name", actualCopyOfResult.sourceName());
    assertEquals(EntityKind.ALL, actualCopyOfResult.entityKind());
    assertEquals(RagRating.R, actualCopyOfResult.accuracy());
    assertEquals(RagRating.R, actualCopyOfResult.authoritativeness());
    assertEquals(RagRating.R, actualCopyOfResult.completeness());
  }

  /**
   * Test {@link ImmutableSourceDataRating#equals(Object)}, and {@link
   * ImmutableSourceDataRating#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSourceDataRating#equals(Object)}
   *   <li>{@link ImmutableSourceDataRating#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSourceDataRating.equals(Object)",
    "int ImmutableSourceDataRating.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableSourceDataRating immutableSourceDataRating =
        ImmutableSourceDataRating.builder()
            .accuracy(RagRating.R)
            .authoritativeness(RagRating.R)
            .completeness(RagRating.R)
            .entityKind(EntityKind.ALL)
            .lastImportDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .sourceName("Source Name")
            .build();
    ImmutableSourceDataRating immutableSourceDataRating2 =
        ImmutableSourceDataRating.builder()
            .accuracy(RagRating.R)
            .authoritativeness(RagRating.R)
            .completeness(RagRating.R)
            .entityKind(EntityKind.ALL)
            .lastImportDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .sourceName("Source Name")
            .build();

    // Act and Assert
    assertEquals(immutableSourceDataRating, immutableSourceDataRating2);
    assertEquals(immutableSourceDataRating.hashCode(), immutableSourceDataRating2.hashCode());
  }

  /**
   * Test {@link ImmutableSourceDataRating#equals(Object)}, and {@link
   * ImmutableSourceDataRating#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSourceDataRating#equals(Object)}
   *   <li>{@link ImmutableSourceDataRating#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSourceDataRating.equals(Object)",
    "int ImmutableSourceDataRating.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableSourceDataRating immutableSourceDataRating =
        ImmutableSourceDataRating.builder()
            .accuracy(RagRating.R)
            .authoritativeness(RagRating.R)
            .completeness(RagRating.R)
            .entityKind(EntityKind.ALL)
            .lastImportDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .sourceName("Source Name")
            .build();

    // Act and Assert
    assertEquals(immutableSourceDataRating, immutableSourceDataRating);
    int expectedHashCodeResult = immutableSourceDataRating.hashCode();
    assertEquals(expectedHashCodeResult, immutableSourceDataRating.hashCode());
  }

  /**
   * Test {@link ImmutableSourceDataRating#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSourceDataRating#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSourceDataRating.equals(Object)",
    "int ImmutableSourceDataRating.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableSourceDataRating immutableSourceDataRating =
        ImmutableSourceDataRating.builder()
            .accuracy(RagRating.A)
            .authoritativeness(RagRating.R)
            .completeness(RagRating.R)
            .entityKind(EntityKind.ALL)
            .lastImportDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .sourceName("Source Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableSourceDataRating,
        ImmutableSourceDataRating.builder()
            .accuracy(RagRating.R)
            .authoritativeness(RagRating.R)
            .completeness(RagRating.R)
            .entityKind(EntityKind.ALL)
            .lastImportDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .sourceName("Source Name")
            .build());
  }

  /**
   * Test {@link ImmutableSourceDataRating#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSourceDataRating#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSourceDataRating.equals(Object)",
    "int ImmutableSourceDataRating.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableSourceDataRating immutableSourceDataRating =
        ImmutableSourceDataRating.builder()
            .accuracy(RagRating.R)
            .authoritativeness(RagRating.A)
            .completeness(RagRating.R)
            .entityKind(EntityKind.ALL)
            .lastImportDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .sourceName("Source Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableSourceDataRating,
        ImmutableSourceDataRating.builder()
            .accuracy(RagRating.R)
            .authoritativeness(RagRating.R)
            .completeness(RagRating.R)
            .entityKind(EntityKind.ALL)
            .lastImportDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .sourceName("Source Name")
            .build());
  }

  /**
   * Test {@link ImmutableSourceDataRating#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSourceDataRating#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSourceDataRating.equals(Object)",
    "int ImmutableSourceDataRating.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableSourceDataRating immutableSourceDataRating =
        ImmutableSourceDataRating.builder()
            .accuracy(RagRating.R)
            .authoritativeness(RagRating.R)
            .completeness(RagRating.A)
            .entityKind(EntityKind.ALL)
            .lastImportDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .sourceName("Source Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableSourceDataRating,
        ImmutableSourceDataRating.builder()
            .accuracy(RagRating.R)
            .authoritativeness(RagRating.R)
            .completeness(RagRating.R)
            .entityKind(EntityKind.ALL)
            .lastImportDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .sourceName("Source Name")
            .build());
  }

  /**
   * Test {@link ImmutableSourceDataRating#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSourceDataRating#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSourceDataRating.equals(Object)",
    "int ImmutableSourceDataRating.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableSourceDataRating immutableSourceDataRating =
        ImmutableSourceDataRating.builder()
            .accuracy(RagRating.R)
            .authoritativeness(RagRating.R)
            .completeness(RagRating.R)
            .entityKind(EntityKind.ACTOR)
            .lastImportDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .sourceName("Source Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableSourceDataRating,
        ImmutableSourceDataRating.builder()
            .accuracy(RagRating.R)
            .authoritativeness(RagRating.R)
            .completeness(RagRating.R)
            .entityKind(EntityKind.ALL)
            .lastImportDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .sourceName("Source Name")
            .build());
  }

  /**
   * Test {@link ImmutableSourceDataRating#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSourceDataRating#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSourceDataRating.equals(Object)",
    "int ImmutableSourceDataRating.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ImmutableSourceDataRating immutableSourceDataRating =
        ImmutableSourceDataRating.builder()
            .accuracy(RagRating.R)
            .authoritativeness(RagRating.R)
            .completeness(RagRating.R)
            .entityKind(EntityKind.ALL)
            .lastImportDate(LocalDate.now().atStartOfDay())
            .sourceName("Source Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableSourceDataRating,
        ImmutableSourceDataRating.builder()
            .accuracy(RagRating.R)
            .authoritativeness(RagRating.R)
            .completeness(RagRating.R)
            .entityKind(EntityKind.ALL)
            .lastImportDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .sourceName("Source Name")
            .build());
  }

  /**
   * Test {@link ImmutableSourceDataRating#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSourceDataRating#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSourceDataRating.equals(Object)",
    "int ImmutableSourceDataRating.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ImmutableSourceDataRating immutableSourceDataRating =
        ImmutableSourceDataRating.builder()
            .accuracy(RagRating.R)
            .authoritativeness(RagRating.R)
            .completeness(RagRating.R)
            .entityKind(EntityKind.ALL)
            .lastImportDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .sourceName("accuracy")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableSourceDataRating,
        ImmutableSourceDataRating.builder()
            .accuracy(RagRating.R)
            .authoritativeness(RagRating.R)
            .completeness(RagRating.R)
            .entityKind(EntityKind.ALL)
            .lastImportDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .sourceName("Source Name")
            .build());
  }

  /**
   * Test {@link ImmutableSourceDataRating#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSourceDataRating#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSourceDataRating.equals(Object)",
    "int ImmutableSourceDataRating.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableSourceDataRating.builder()
            .accuracy(RagRating.R)
            .authoritativeness(RagRating.R)
            .completeness(RagRating.R)
            .entityKind(EntityKind.ALL)
            .lastImportDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .sourceName("Source Name")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableSourceDataRating#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSourceDataRating#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSourceDataRating.equals(Object)",
    "int ImmutableSourceDataRating.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableSourceDataRating.builder()
            .accuracy(RagRating.R)
            .authoritativeness(RagRating.R)
            .completeness(RagRating.R)
            .entityKind(EntityKind.ALL)
            .lastImportDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .sourceName("Source Name")
            .build(),
        "Different type to ImmutableSourceDataRating");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSourceDataRating#accuracy()}
   *   <li>{@link ImmutableSourceDataRating#authoritativeness()}
   *   <li>{@link ImmutableSourceDataRating#completeness()}
   *   <li>{@link ImmutableSourceDataRating#entityKind()}
   *   <li>{@link ImmutableSourceDataRating#sourceName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RagRating ImmutableSourceDataRating.accuracy()",
    "RagRating ImmutableSourceDataRating.authoritativeness()",
    "RagRating ImmutableSourceDataRating.completeness()",
    "EntityKind ImmutableSourceDataRating.entityKind()",
    "String ImmutableSourceDataRating.sourceName()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableSourceDataRating immutableSourceDataRating =
        ImmutableSourceDataRating.builder()
            .accuracy(RagRating.R)
            .authoritativeness(RagRating.R)
            .completeness(RagRating.R)
            .entityKind(EntityKind.ALL)
            .lastImportDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .sourceName("Source Name")
            .build();

    // Act
    RagRating actualAccuracyResult = immutableSourceDataRating.accuracy();
    RagRating actualAuthoritativenessResult = immutableSourceDataRating.authoritativeness();
    RagRating actualCompletenessResult = immutableSourceDataRating.completeness();
    EntityKind actualEntityKindResult = immutableSourceDataRating.entityKind();

    // Assert
    assertEquals("Source Name", immutableSourceDataRating.sourceName());
    assertEquals(EntityKind.ALL, actualEntityKindResult);
    assertEquals(RagRating.R, actualAccuracyResult);
    assertEquals(RagRating.R, actualAuthoritativenessResult);
    assertEquals(RagRating.R, actualCompletenessResult);
  }

  /**
   * Test Json {@link Json#accuracy()}.
   *
   * <p>Method under test: {@link Json#accuracy()}
   */
  @Test
  @DisplayName("Test Json accuracy()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RagRating Json.accuracy()"})
  void testJsonAccuracy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().accuracy());
  }

  /**
   * Test Json {@link Json#authoritativeness()}.
   *
   * <p>Method under test: {@link Json#authoritativeness()}
   */
  @Test
  @DisplayName("Test Json authoritativeness()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RagRating Json.authoritativeness()"})
  void testJsonAuthoritativeness() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().authoritativeness());
  }

  /**
   * Test Json {@link Json#completeness()}.
   *
   * <p>Method under test: {@link Json#completeness()}
   */
  @Test
  @DisplayName("Test Json completeness()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RagRating Json.completeness()"})
  void testJsonCompleteness() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().completeness());
  }

  /**
   * Test Json {@link Json#entityKind()}.
   *
   * <p>Method under test: {@link Json#entityKind()}
   */
  @Test
  @DisplayName("Test Json entityKind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind Json.entityKind()"})
  void testJsonEntityKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().entityKind());
  }

  /**
   * Test Json {@link Json#lastImportDate()}.
   *
   * <p>Method under test: {@link Json#lastImportDate()}
   */
  @Test
  @DisplayName("Test Json lastImportDate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.lastImportDate()"})
  void testJsonLastImportDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().lastImportDate());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.<init>()"})
  void testJsonNewJson() {
    // Arrange and Act
    Json actualJson = new Json();

    // Assert
    assertNull(actualJson.sourceName);
    assertNull(actualJson.entityKind);
    assertNull(actualJson.accuracy);
    assertNull(actualJson.authoritativeness);
    assertNull(actualJson.completeness);
    assertFalse(actualJson.lastImportDate.isPresent());
  }

  /**
   * Test Json {@link Json#sourceName()}.
   *
   * <p>Method under test: {@link Json#sourceName()}
   */
  @Test
  @DisplayName("Test Json sourceName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.sourceName()"})
  void testJsonSourceName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().sourceName());
  }

  /**
   * Test {@link ImmutableSourceDataRating#lastImportDate()}.
   *
   * <p>Method under test: {@link ImmutableSourceDataRating#lastImportDate()}
   */
  @Test
  @DisplayName("Test lastImportDate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableSourceDataRating.lastImportDate()"})
  void testLastImportDate() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    Optional<LocalDateTime> actualLastImportDateResult =
        ImmutableSourceDataRating.builder()
            .accuracy(RagRating.R)
            .authoritativeness(RagRating.R)
            .completeness(RagRating.R)
            .entityKind(EntityKind.ALL)
            .lastImportDate(ofResult.atStartOfDay())
            .sourceName("Source Name")
            .build()
            .lastImportDate();

    // Assert
    LocalDateTime getResult = actualLastImportDateResult.get();
    assertEquals("00:00", getResult.toLocalTime().toString());
    LocalDate toLocalDateResult = getResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertTrue(actualLastImportDateResult.isPresent());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableSourceDataRating#toString()}.
   *
   * <p>Method under test: {@link ImmutableSourceDataRating#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableSourceDataRating.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "SourceDataRating{sourceName=Source Name, entityKind=ALL, authoritativeness=R, accuracy=R, completeness=R,"
            + " lastImportDate=1970-01-01T00:00}",
        ImmutableSourceDataRating.builder()
            .accuracy(RagRating.R)
            .authoritativeness(RagRating.R)
            .completeness(RagRating.R)
            .entityKind(EntityKind.ALL)
            .lastImportDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .sourceName("Source Name")
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableSourceDataRating#withAccuracy(RagRating)}.
   *
   * <p>Method under test: {@link ImmutableSourceDataRating#withAccuracy(RagRating)}
   */
  @Test
  @DisplayName("Test withAccuracy(RagRating)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSourceDataRating ImmutableSourceDataRating.withAccuracy(RagRating)"})
  void testWithAccuracy() {
    // Arrange
    ImmutableSourceDataRating immutableSourceDataRating =
        ImmutableSourceDataRating.builder()
            .accuracy(RagRating.R)
            .authoritativeness(RagRating.R)
            .completeness(RagRating.R)
            .entityKind(EntityKind.ALL)
            .lastImportDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .sourceName("Source Name")
            .build();

    // Act
    ImmutableSourceDataRating actualWithAccuracyResult =
        immutableSourceDataRating.withAccuracy(RagRating.R);

    // Assert
    assertSame(immutableSourceDataRating, actualWithAccuracyResult);
  }

  /**
   * Test {@link ImmutableSourceDataRating#withAccuracy(RagRating)}.
   *
   * <ul>
   *   <li>Then return {@code Source Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSourceDataRating#withAccuracy(RagRating)}
   */
  @Test
  @DisplayName("Test withAccuracy(RagRating); then return 'Source Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSourceDataRating ImmutableSourceDataRating.withAccuracy(RagRating)"})
  void testWithAccuracy_thenReturnSourceName() {
    // Arrange and Act
    ImmutableSourceDataRating actualWithAccuracyResult =
        ImmutableSourceDataRating.builder()
            .accuracy(RagRating.A)
            .authoritativeness(RagRating.R)
            .completeness(RagRating.R)
            .entityKind(EntityKind.ALL)
            .lastImportDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .sourceName("Source Name")
            .build()
            .withAccuracy(RagRating.R);

    // Assert
    assertEquals("Source Name", actualWithAccuracyResult.sourceName());
    assertEquals(EntityKind.ALL, actualWithAccuracyResult.entityKind());
    assertEquals(RagRating.R, actualWithAccuracyResult.accuracy());
    assertEquals(RagRating.R, actualWithAccuracyResult.authoritativeness());
    assertEquals(RagRating.R, actualWithAccuracyResult.completeness());
  }

  /**
   * Test {@link ImmutableSourceDataRating#withAuthoritativeness(RagRating)}.
   *
   * <p>Method under test: {@link ImmutableSourceDataRating#withAuthoritativeness(RagRating)}
   */
  @Test
  @DisplayName("Test withAuthoritativeness(RagRating)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSourceDataRating ImmutableSourceDataRating.withAuthoritativeness(RagRating)"
  })
  void testWithAuthoritativeness() {
    // Arrange
    ImmutableSourceDataRating immutableSourceDataRating =
        ImmutableSourceDataRating.builder()
            .accuracy(RagRating.R)
            .authoritativeness(RagRating.R)
            .completeness(RagRating.R)
            .entityKind(EntityKind.ALL)
            .lastImportDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .sourceName("Source Name")
            .build();

    // Act
    ImmutableSourceDataRating actualWithAuthoritativenessResult =
        immutableSourceDataRating.withAuthoritativeness(RagRating.R);

    // Assert
    assertSame(immutableSourceDataRating, actualWithAuthoritativenessResult);
  }

  /**
   * Test {@link ImmutableSourceDataRating#withAuthoritativeness(RagRating)}.
   *
   * <ul>
   *   <li>Then return {@code Source Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSourceDataRating#withAuthoritativeness(RagRating)}
   */
  @Test
  @DisplayName("Test withAuthoritativeness(RagRating); then return 'Source Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSourceDataRating ImmutableSourceDataRating.withAuthoritativeness(RagRating)"
  })
  void testWithAuthoritativeness_thenReturnSourceName() {
    // Arrange and Act
    ImmutableSourceDataRating actualWithAuthoritativenessResult =
        ImmutableSourceDataRating.builder()
            .accuracy(RagRating.R)
            .authoritativeness(RagRating.A)
            .completeness(RagRating.R)
            .entityKind(EntityKind.ALL)
            .lastImportDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .sourceName("Source Name")
            .build()
            .withAuthoritativeness(RagRating.R);

    // Assert
    assertEquals("Source Name", actualWithAuthoritativenessResult.sourceName());
    assertEquals(EntityKind.ALL, actualWithAuthoritativenessResult.entityKind());
    assertEquals(RagRating.R, actualWithAuthoritativenessResult.accuracy());
    assertEquals(RagRating.R, actualWithAuthoritativenessResult.authoritativeness());
    assertEquals(RagRating.R, actualWithAuthoritativenessResult.completeness());
  }

  /**
   * Test {@link ImmutableSourceDataRating#withCompleteness(RagRating)}.
   *
   * <p>Method under test: {@link ImmutableSourceDataRating#withCompleteness(RagRating)}
   */
  @Test
  @DisplayName("Test withCompleteness(RagRating)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSourceDataRating ImmutableSourceDataRating.withCompleteness(RagRating)"
  })
  void testWithCompleteness() {
    // Arrange
    ImmutableSourceDataRating immutableSourceDataRating =
        ImmutableSourceDataRating.builder()
            .accuracy(RagRating.R)
            .authoritativeness(RagRating.R)
            .completeness(RagRating.R)
            .entityKind(EntityKind.ALL)
            .lastImportDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .sourceName("Source Name")
            .build();

    // Act
    ImmutableSourceDataRating actualWithCompletenessResult =
        immutableSourceDataRating.withCompleteness(RagRating.R);

    // Assert
    assertSame(immutableSourceDataRating, actualWithCompletenessResult);
  }

  /**
   * Test {@link ImmutableSourceDataRating#withCompleteness(RagRating)}.
   *
   * <ul>
   *   <li>Then return {@code Source Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSourceDataRating#withCompleteness(RagRating)}
   */
  @Test
  @DisplayName("Test withCompleteness(RagRating); then return 'Source Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSourceDataRating ImmutableSourceDataRating.withCompleteness(RagRating)"
  })
  void testWithCompleteness_thenReturnSourceName() {
    // Arrange and Act
    ImmutableSourceDataRating actualWithCompletenessResult =
        ImmutableSourceDataRating.builder()
            .accuracy(RagRating.R)
            .authoritativeness(RagRating.R)
            .completeness(RagRating.A)
            .entityKind(EntityKind.ALL)
            .lastImportDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .sourceName("Source Name")
            .build()
            .withCompleteness(RagRating.R);

    // Assert
    assertEquals("Source Name", actualWithCompletenessResult.sourceName());
    assertEquals(EntityKind.ALL, actualWithCompletenessResult.entityKind());
    assertEquals(RagRating.R, actualWithCompletenessResult.accuracy());
    assertEquals(RagRating.R, actualWithCompletenessResult.authoritativeness());
    assertEquals(RagRating.R, actualWithCompletenessResult.completeness());
  }

  /**
   * Test {@link ImmutableSourceDataRating#withEntityKind(EntityKind)}.
   *
   * <p>Method under test: {@link ImmutableSourceDataRating#withEntityKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withEntityKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSourceDataRating ImmutableSourceDataRating.withEntityKind(EntityKind)"
  })
  void testWithEntityKind() {
    // Arrange
    ImmutableSourceDataRating immutableSourceDataRating =
        ImmutableSourceDataRating.builder()
            .accuracy(RagRating.R)
            .authoritativeness(RagRating.R)
            .completeness(RagRating.R)
            .entityKind(EntityKind.ALL)
            .lastImportDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .sourceName("Source Name")
            .build();

    // Act
    ImmutableSourceDataRating actualWithEntityKindResult =
        immutableSourceDataRating.withEntityKind(EntityKind.ALL);

    // Assert
    assertSame(immutableSourceDataRating, actualWithEntityKindResult);
  }

  /**
   * Test {@link ImmutableSourceDataRating#withEntityKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then return {@code Source Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSourceDataRating#withEntityKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withEntityKind(EntityKind); then return 'Source Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSourceDataRating ImmutableSourceDataRating.withEntityKind(EntityKind)"
  })
  void testWithEntityKind_thenReturnSourceName() {
    // Arrange and Act
    ImmutableSourceDataRating actualWithEntityKindResult =
        ImmutableSourceDataRating.builder()
            .accuracy(RagRating.R)
            .authoritativeness(RagRating.R)
            .completeness(RagRating.R)
            .entityKind(EntityKind.ACTOR)
            .lastImportDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .sourceName("Source Name")
            .build()
            .withEntityKind(EntityKind.ALL);

    // Assert
    assertEquals("Source Name", actualWithEntityKindResult.sourceName());
    assertEquals(EntityKind.ALL, actualWithEntityKindResult.entityKind());
    assertEquals(RagRating.R, actualWithEntityKindResult.accuracy());
    assertEquals(RagRating.R, actualWithEntityKindResult.authoritativeness());
    assertEquals(RagRating.R, actualWithEntityKindResult.completeness());
  }

  /**
   * Test {@link ImmutableSourceDataRating#withLastImportDate(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableSourceDataRating#withLastImportDate(Optional)}
   */
  @Test
  @DisplayName("Test withLastImportDate(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSourceDataRating ImmutableSourceDataRating.withLastImportDate(Optional)"
  })
  void testWithLastImportDateWithOptional() {
    // Arrange
    ImmutableSourceDataRating immutableSourceDataRating =
        ImmutableSourceDataRating.builder()
            .accuracy(RagRating.R)
            .authoritativeness(RagRating.R)
            .completeness(RagRating.R)
            .entityKind(EntityKind.ALL)
            .lastImportDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .sourceName("Source Name")
            .build();
    Optional<? extends LocalDateTime> optional =
        Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act
    ImmutableSourceDataRating actualWithLastImportDateResult =
        immutableSourceDataRating.withLastImportDate(optional);

    // Assert
    assertEquals(immutableSourceDataRating, actualWithLastImportDateResult);
  }

  /**
   * Test {@link ImmutableSourceDataRating#withLastImportDate(LocalDateTime)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableSourceDataRating#withLastImportDate(LocalDateTime)}
   */
  @Test
  @DisplayName("Test withLastImportDate(LocalDateTime) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSourceDataRating ImmutableSourceDataRating.withLastImportDate(LocalDateTime)"
  })
  void testWithLastImportDateWithValue() {
    // Arrange
    ImmutableSourceDataRating immutableSourceDataRating =
        ImmutableSourceDataRating.builder()
            .accuracy(RagRating.R)
            .authoritativeness(RagRating.R)
            .completeness(RagRating.R)
            .entityKind(EntityKind.ALL)
            .lastImportDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .sourceName("Source Name")
            .build();

    // Act
    ImmutableSourceDataRating actualWithLastImportDateResult =
        immutableSourceDataRating.withLastImportDate(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertEquals(immutableSourceDataRating, actualWithLastImportDateResult);
  }

  /**
   * Test {@link ImmutableSourceDataRating#withSourceName(String)}.
   *
   * <p>Method under test: {@link ImmutableSourceDataRating#withSourceName(String)}
   */
  @Test
  @DisplayName("Test withSourceName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSourceDataRating ImmutableSourceDataRating.withSourceName(String)"})
  void testWithSourceName() {
    // Arrange
    ImmutableSourceDataRating immutableSourceDataRating =
        ImmutableSourceDataRating.builder()
            .accuracy(RagRating.R)
            .authoritativeness(RagRating.R)
            .completeness(RagRating.R)
            .entityKind(EntityKind.ALL)
            .lastImportDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .sourceName("42")
            .build();

    // Act
    ImmutableSourceDataRating actualWithSourceNameResult =
        immutableSourceDataRating.withSourceName("42");

    // Assert
    assertSame(immutableSourceDataRating, actualWithSourceNameResult);
  }

  /**
   * Test {@link ImmutableSourceDataRating#withSourceName(String)}.
   *
   * <ul>
   *   <li>Then return sourceName is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSourceDataRating#withSourceName(String)}
   */
  @Test
  @DisplayName("Test withSourceName(String); then return sourceName is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSourceDataRating ImmutableSourceDataRating.withSourceName(String)"})
  void testWithSourceName_thenReturnSourceNameIs42() {
    // Arrange and Act
    ImmutableSourceDataRating actualWithSourceNameResult =
        ImmutableSourceDataRating.builder()
            .accuracy(RagRating.R)
            .authoritativeness(RagRating.R)
            .completeness(RagRating.R)
            .entityKind(EntityKind.ALL)
            .lastImportDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .sourceName("Source Name")
            .build()
            .withSourceName("42");

    // Assert
    assertEquals("42", actualWithSourceNameResult.sourceName());
    assertEquals(EntityKind.ALL, actualWithSourceNameResult.entityKind());
    assertEquals(RagRating.R, actualWithSourceNameResult.accuracy());
    assertEquals(RagRating.R, actualWithSourceNameResult.authoritativeness());
    assertEquals(RagRating.R, actualWithSourceNameResult.completeness());
  }
}
