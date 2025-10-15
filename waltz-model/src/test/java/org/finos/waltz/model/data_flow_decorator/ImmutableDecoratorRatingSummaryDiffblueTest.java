package org.finos.waltz.model.data_flow_decorator;

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
import org.finos.waltz.model.data_flow_decorator.ImmutableDecoratorRatingSummary.Builder;
import org.finos.waltz.model.data_flow_decorator.ImmutableDecoratorRatingSummary.Json;
import org.finos.waltz.model.rating.AuthoritativenessRatingValue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableDecoratorRatingSummaryDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDecoratorRatingSummary Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualCountResult = ImmutableDecoratorRatingSummary.builder().count(3);
    ImmutableEntityReference decoratorEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Builder actualDecoratorEntityReferenceResult =
        actualCountResult.decoratorEntityReference(decoratorEntityReference);
    AuthoritativenessRatingValue rating = AuthoritativenessRatingValue.of("42");
    ImmutableDecoratorRatingSummary actualImmutableDecoratorRatingSummary =
        actualDecoratorEntityReferenceResult.rating(rating).build();

    // Assert
    AuthoritativenessRatingValue ratingResult = actualImmutableDecoratorRatingSummary.rating();
    assertEquals("42", ratingResult.value());
    assertEquals(3, actualImmutableDecoratorRatingSummary.count());
    assertSame(
        decoratorEntityReference, actualImmutableDecoratorRatingSummary.decoratorEntityReference());
    assertSame(rating, ratingResult);
  }

  /**
   * Test Builder {@link Builder#count(int)}.
   *
   * <p>Method under test: {@link Builder#count(int)}
   */
  @Test
  @DisplayName("Test Builder count(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.count(int)"})
  void testBuilderCount() {
    // Arrange
    Builder builderResult = ImmutableDecoratorRatingSummary.builder();

    // Act
    Builder actualCountResult = builderResult.count(3);

    // Assert
    assertSame(builderResult, actualCountResult);
  }

  /**
   * Test Builder {@link Builder#decoratorEntityReference(EntityReference)}.
   *
   * <ul>
   *   <li>When {@link EntityReference}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#decoratorEntityReference(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test Builder decoratorEntityReference(EntityReference); when EntityReference; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.decoratorEntityReference(EntityReference)"})
  void testBuilderDecoratorEntityReference_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDecoratorRatingSummary.builder();

    // Act
    Builder actualDecoratorEntityReferenceResult =
        builderResult.decoratorEntityReference(mock(EntityReference.class));

    // Assert
    assertSame(builderResult, actualDecoratorEntityReferenceResult);
  }

  /**
   * Test Builder {@link Builder#from(DecoratorRatingSummary)}.
   *
   * <p>Method under test: {@link Builder#from(DecoratorRatingSummary)}
   */
  @Test
  @DisplayName("Test Builder from(DecoratorRatingSummary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DecoratorRatingSummary)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableDecoratorRatingSummary.builder();

    Builder countResult = ImmutableDecoratorRatingSummary.builder().count(3);

    Builder decoratorEntityReferenceResult =
        countResult.decoratorEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableDecoratorRatingSummary instance =
        decoratorEntityReferenceResult.rating(AuthoritativenessRatingValue.of("42")).build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableDecoratorRatingSummary actualImmutableDecoratorRatingSummary = builderResult.build();
    assertEquals(instance, actualImmutableDecoratorRatingSummary);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#rating(AuthoritativenessRatingValue)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#rating(AuthoritativenessRatingValue)}
   */
  @Test
  @DisplayName("Test Builder rating(AuthoritativenessRatingValue); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.rating(AuthoritativenessRatingValue)"})
  void testBuilderRating_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDecoratorRatingSummary.builder();

    // Act
    Builder actualRatingResult = builderResult.rating(AuthoritativenessRatingValue.of("42"));

    // Assert
    assertSame(builderResult, actualRatingResult);
  }

  /**
   * Test {@link ImmutableDecoratorRatingSummary#copyOf(DecoratorRatingSummary)}.
   *
   * <ul>
   *   <li>Then decoratorEntityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDecoratorRatingSummary#copyOf(DecoratorRatingSummary)}
   */
  @Test
  @DisplayName(
      "Test copyOf(DecoratorRatingSummary); then decoratorEntityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDecoratorRatingSummary ImmutableDecoratorRatingSummary.copyOf(DecoratorRatingSummary)"
  })
  void testCopyOf_thenDecoratorEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder countResult = ImmutableDecoratorRatingSummary.builder().count(3);

    Builder decoratorEntityReferenceResult =
        countResult.decoratorEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    AuthoritativenessRatingValue rating = AuthoritativenessRatingValue.of("42");
    ImmutableDecoratorRatingSummary instance =
        decoratorEntityReferenceResult.rating(rating).build();

    // Act
    ImmutableDecoratorRatingSummary actualCopyOfResult =
        ImmutableDecoratorRatingSummary.copyOf(instance);

    // Assert
    EntityReference decoratorEntityReferenceResult2 = actualCopyOfResult.decoratorEntityReference();
    assertTrue(decoratorEntityReferenceResult2 instanceof ImmutableEntityReference);
    AuthoritativenessRatingValue ratingResult = actualCopyOfResult.rating();
    assertEquals("42", ratingResult.value());
    assertEquals(
        "The characteristics of someone or something",
        decoratorEntityReferenceResult2.description());
    assertEquals(1L, decoratorEntityReferenceResult2.id());
    assertEquals(3, actualCopyOfResult.count());
    assertEquals(EntityKind.ALL, decoratorEntityReferenceResult2.kind());
    assertEquals(
        EntityLifecycleStatus.ACTIVE, decoratorEntityReferenceResult2.entityLifecycleStatus());
    assertSame(rating, ratingResult);
  }

  /**
   * Test {@link ImmutableDecoratorRatingSummary#equals(Object)}, and {@link
   * ImmutableDecoratorRatingSummary#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableDecoratorRatingSummary#equals(Object)}
   *   <li>{@link ImmutableDecoratorRatingSummary#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDecoratorRatingSummary.equals(Object)",
    "int ImmutableDecoratorRatingSummary.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder countResult = ImmutableDecoratorRatingSummary.builder().count(3);

    Builder decoratorEntityReferenceResult =
        countResult.decoratorEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableDecoratorRatingSummary immutableDecoratorRatingSummary =
        decoratorEntityReferenceResult.rating(AuthoritativenessRatingValue.of("42")).build();

    Builder countResult2 = ImmutableDecoratorRatingSummary.builder().count(3);

    Builder decoratorEntityReferenceResult2 =
        countResult2.decoratorEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableDecoratorRatingSummary immutableDecoratorRatingSummary2 =
        decoratorEntityReferenceResult2.rating(AuthoritativenessRatingValue.of("42")).build();

    // Act and Assert
    assertEquals(immutableDecoratorRatingSummary, immutableDecoratorRatingSummary2);
    assertEquals(
        immutableDecoratorRatingSummary.hashCode(), immutableDecoratorRatingSummary2.hashCode());
  }

  /**
   * Test {@link ImmutableDecoratorRatingSummary#equals(Object)}, and {@link
   * ImmutableDecoratorRatingSummary#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableDecoratorRatingSummary#equals(Object)}
   *   <li>{@link ImmutableDecoratorRatingSummary#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDecoratorRatingSummary.equals(Object)",
    "int ImmutableDecoratorRatingSummary.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder countResult = ImmutableDecoratorRatingSummary.builder().count(3);

    Builder decoratorEntityReferenceResult =
        countResult.decoratorEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableDecoratorRatingSummary immutableDecoratorRatingSummary =
        decoratorEntityReferenceResult.rating(AuthoritativenessRatingValue.of("42")).build();

    // Act and Assert
    assertEquals(immutableDecoratorRatingSummary, immutableDecoratorRatingSummary);
    int expectedHashCodeResult = immutableDecoratorRatingSummary.hashCode();
    assertEquals(expectedHashCodeResult, immutableDecoratorRatingSummary.hashCode());
  }

  /**
   * Test {@link ImmutableDecoratorRatingSummary#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDecoratorRatingSummary#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDecoratorRatingSummary.equals(Object)",
    "int ImmutableDecoratorRatingSummary.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder countResult = ImmutableDecoratorRatingSummary.builder().count(1);

    Builder decoratorEntityReferenceResult =
        countResult.decoratorEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableDecoratorRatingSummary immutableDecoratorRatingSummary =
        decoratorEntityReferenceResult.rating(AuthoritativenessRatingValue.of("42")).build();

    Builder countResult2 = ImmutableDecoratorRatingSummary.builder().count(3);

    Builder decoratorEntityReferenceResult2 =
        countResult2.decoratorEntityReference(
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
        immutableDecoratorRatingSummary,
        decoratorEntityReferenceResult2.rating(AuthoritativenessRatingValue.of("42")).build());
  }

  /**
   * Test {@link ImmutableDecoratorRatingSummary#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDecoratorRatingSummary#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDecoratorRatingSummary.equals(Object)",
    "int ImmutableDecoratorRatingSummary.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder countResult = ImmutableDecoratorRatingSummary.builder().count(3);

    Builder decoratorEntityReferenceResult =
        countResult.decoratorEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableDecoratorRatingSummary immutableDecoratorRatingSummary =
        decoratorEntityReferenceResult.rating(AuthoritativenessRatingValue.of("42")).build();

    Builder countResult2 = ImmutableDecoratorRatingSummary.builder().count(3);

    Builder decoratorEntityReferenceResult2 =
        countResult2.decoratorEntityReference(
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
        immutableDecoratorRatingSummary,
        decoratorEntityReferenceResult2.rating(AuthoritativenessRatingValue.of("42")).build());
  }

  /**
   * Test {@link ImmutableDecoratorRatingSummary#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDecoratorRatingSummary#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDecoratorRatingSummary.equals(Object)",
    "int ImmutableDecoratorRatingSummary.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder countResult = ImmutableDecoratorRatingSummary.builder().count(3);

    Builder decoratorEntityReferenceResult =
        countResult.decoratorEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableDecoratorRatingSummary immutableDecoratorRatingSummary =
        decoratorEntityReferenceResult.rating(AuthoritativenessRatingValue.of("Value")).build();

    Builder countResult2 = ImmutableDecoratorRatingSummary.builder().count(3);

    Builder decoratorEntityReferenceResult2 =
        countResult2.decoratorEntityReference(
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
        immutableDecoratorRatingSummary,
        decoratorEntityReferenceResult2.rating(AuthoritativenessRatingValue.of("42")).build());
  }

  /**
   * Test {@link ImmutableDecoratorRatingSummary#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDecoratorRatingSummary#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDecoratorRatingSummary.equals(Object)",
    "int ImmutableDecoratorRatingSummary.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder countResult = ImmutableDecoratorRatingSummary.builder().count(3);

    Builder decoratorEntityReferenceResult =
        countResult.decoratorEntityReference(
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
        decoratorEntityReferenceResult.rating(AuthoritativenessRatingValue.of("42")).build(), null);
  }

  /**
   * Test {@link ImmutableDecoratorRatingSummary#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDecoratorRatingSummary#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDecoratorRatingSummary.equals(Object)",
    "int ImmutableDecoratorRatingSummary.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder countResult = ImmutableDecoratorRatingSummary.builder().count(3);

    Builder decoratorEntityReferenceResult =
        countResult.decoratorEntityReference(
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
        decoratorEntityReferenceResult.rating(AuthoritativenessRatingValue.of("42")).build(),
        "Different type to ImmutableDecoratorRatingSummary");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableDecoratorRatingSummary#toString()}
   *   <li>{@link ImmutableDecoratorRatingSummary#count()}
   *   <li>{@link ImmutableDecoratorRatingSummary#decoratorEntityReference()}
   *   <li>{@link ImmutableDecoratorRatingSummary#rating()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ImmutableDecoratorRatingSummary.count()",
    "EntityReference ImmutableDecoratorRatingSummary.decoratorEntityReference()",
    "AuthoritativenessRatingValue ImmutableDecoratorRatingSummary.rating()",
    "String ImmutableDecoratorRatingSummary.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder countResult = ImmutableDecoratorRatingSummary.builder().count(3);

    Builder decoratorEntityReferenceResult =
        countResult.decoratorEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    AuthoritativenessRatingValue rating = AuthoritativenessRatingValue.of("42");
    ImmutableDecoratorRatingSummary immutableDecoratorRatingSummary =
        decoratorEntityReferenceResult.rating(rating).build();

    // Act
    String actualToStringResult = immutableDecoratorRatingSummary.toString();
    int actualCountResult = immutableDecoratorRatingSummary.count();
    EntityReference actualDecoratorEntityReferenceResult =
        immutableDecoratorRatingSummary.decoratorEntityReference();
    AuthoritativenessRatingValue actualRatingResult = immutableDecoratorRatingSummary.rating();

    // Assert
    assertTrue(actualDecoratorEntityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("42", actualRatingResult.value());
    assertEquals(
        "DecoratorRatingSummary{decoratorEntityReference=EntityReference{kind=ALL, id=1, entityLifecycleStatus"
            + "=ACTIVE}, rating=42, count=3}",
        actualToStringResult);
    assertEquals(3, actualCountResult);
    assertSame(rating, actualRatingResult);
  }

  /**
   * Test Json {@link Json#count()}.
   *
   * <p>Method under test: {@link Json#count()}
   */
  @Test
  @DisplayName("Test Json count()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Json.count()"})
  void testJsonCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().count());
  }

  /**
   * Test Json {@link Json#decoratorEntityReference()}.
   *
   * <p>Method under test: {@link Json#decoratorEntityReference()}
   */
  @Test
  @DisplayName("Test Json decoratorEntityReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.decoratorEntityReference()"})
  void testJsonDecoratorEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().decoratorEntityReference());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setDecoratorEntityReference(EntityReference)}
   *   <li>{@link Json#setRating(AuthoritativenessRatingValue)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setDecoratorEntityReference(EntityReference)",
    "void Json.setRating(AuthoritativenessRatingValue)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setDecoratorEntityReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    actualJson.setRating(AuthoritativenessRatingValue.of("42"));

    // Assert
    assertEquals("42", actualJson.rating.value());
  }

  /**
   * Test Json {@link Json#rating()}.
   *
   * <p>Method under test: {@link Json#rating()}
   */
  @Test
  @DisplayName("Test Json rating()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AuthoritativenessRatingValue Json.rating()"})
  void testJsonRating() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().rating());
  }

  /**
   * Test Json {@link Json#setCount(int)}.
   *
   * <p>Method under test: {@link Json#setCount(int)}
   */
  @Test
  @DisplayName("Test Json setCount(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setCount(int)"})
  void testJsonSetCount() {
    // Arrange
    Json json = new Json();

    // Act
    json.setCount(3);

    // Assert
    assertEquals(3, json.count);
    assertTrue(json.countIsSet);
  }

  /**
   * Test {@link ImmutableDecoratorRatingSummary#withCount(int)}.
   *
   * <p>Method under test: {@link ImmutableDecoratorRatingSummary#withCount(int)}
   */
  @Test
  @DisplayName("Test withCount(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDecoratorRatingSummary ImmutableDecoratorRatingSummary.withCount(int)"
  })
  void testWithCount() {
    // Arrange
    Builder countResult = ImmutableDecoratorRatingSummary.builder().count(42);

    Builder decoratorEntityReferenceResult =
        countResult.decoratorEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableDecoratorRatingSummary immutableDecoratorRatingSummary =
        decoratorEntityReferenceResult.rating(AuthoritativenessRatingValue.of("42")).build();

    // Act
    ImmutableDecoratorRatingSummary actualWithCountResult =
        immutableDecoratorRatingSummary.withCount(42);

    // Assert
    assertSame(immutableDecoratorRatingSummary, actualWithCountResult);
  }

  /**
   * Test {@link ImmutableDecoratorRatingSummary#withCount(int)}.
   *
   * <ul>
   *   <li>Then decoratorEntityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDecoratorRatingSummary#withCount(int)}
   */
  @Test
  @DisplayName("Test withCount(int); then decoratorEntityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDecoratorRatingSummary ImmutableDecoratorRatingSummary.withCount(int)"
  })
  void testWithCount_thenDecoratorEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder countResult = ImmutableDecoratorRatingSummary.builder().count(3);

    Builder decoratorEntityReferenceResult =
        countResult.decoratorEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    AuthoritativenessRatingValue rating = AuthoritativenessRatingValue.of("42");

    // Act
    ImmutableDecoratorRatingSummary actualWithCountResult =
        decoratorEntityReferenceResult.rating(rating).build().withCount(42);

    // Assert
    EntityReference decoratorEntityReferenceResult2 =
        actualWithCountResult.decoratorEntityReference();
    assertTrue(decoratorEntityReferenceResult2 instanceof ImmutableEntityReference);
    AuthoritativenessRatingValue ratingResult = actualWithCountResult.rating();
    assertEquals("42", ratingResult.value());
    assertEquals(
        "The characteristics of someone or something",
        decoratorEntityReferenceResult2.description());
    assertEquals(1L, decoratorEntityReferenceResult2.id());
    assertEquals(42, actualWithCountResult.count());
    assertEquals(EntityKind.ALL, decoratorEntityReferenceResult2.kind());
    assertEquals(
        EntityLifecycleStatus.ACTIVE, decoratorEntityReferenceResult2.entityLifecycleStatus());
    assertSame(rating, ratingResult);
  }

  /**
   * Test {@link ImmutableDecoratorRatingSummary#withDecoratorEntityReference(EntityReference)}.
   *
   * <p>Method under test: {@link
   * ImmutableDecoratorRatingSummary#withDecoratorEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test withDecoratorEntityReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDecoratorRatingSummary ImmutableDecoratorRatingSummary.withDecoratorEntityReference(EntityReference)"
  })
  void testWithDecoratorEntityReference() {
    // Arrange
    Builder countResult = ImmutableDecoratorRatingSummary.builder().count(3);

    Builder decoratorEntityReferenceResult =
        countResult.decoratorEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableDecoratorRatingSummary immutableDecoratorRatingSummary =
        decoratorEntityReferenceResult.rating(AuthoritativenessRatingValue.of("42")).build();

    // Act
    ImmutableDecoratorRatingSummary actualWithDecoratorEntityReferenceResult =
        immutableDecoratorRatingSummary.withDecoratorEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableDecoratorRatingSummary, actualWithDecoratorEntityReferenceResult);
  }

  /**
   * Test {@link ImmutableDecoratorRatingSummary#withRating(AuthoritativenessRatingValue)}.
   *
   * <p>Method under test: {@link
   * ImmutableDecoratorRatingSummary#withRating(AuthoritativenessRatingValue)}
   */
  @Test
  @DisplayName("Test withRating(AuthoritativenessRatingValue)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDecoratorRatingSummary ImmutableDecoratorRatingSummary.withRating(AuthoritativenessRatingValue)"
  })
  void testWithRating() {
    // Arrange
    Builder countResult = ImmutableDecoratorRatingSummary.builder().count(3);

    Builder decoratorEntityReferenceResult =
        countResult.decoratorEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableDecoratorRatingSummary immutableDecoratorRatingSummary =
        decoratorEntityReferenceResult.rating(AuthoritativenessRatingValue.of("42")).build();

    // Act
    ImmutableDecoratorRatingSummary actualWithRatingResult =
        immutableDecoratorRatingSummary.withRating(AuthoritativenessRatingValue.of("42"));

    // Assert
    assertEquals(immutableDecoratorRatingSummary, actualWithRatingResult);
  }
}
