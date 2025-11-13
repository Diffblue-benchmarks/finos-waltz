package org.finos.waltz.model.attestation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.attestation.ImmutableAttestationRunRecipient.Builder;
import org.finos.waltz.model.attestation.ImmutableAttestationRunRecipient.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAttestationRunRecipientDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAttestationRunRecipient Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualIdResult = ImmutableAttestationRunRecipient.builder().completedCount(3L).id(1L);
    Optional<Long> id = Optional.of(42L);
    ImmutableAttestationRunRecipient actualImmutableAttestationRunRecipient =
        actualIdResult.id(id).pendingCount(3L).userId("42").build();

    // Assert
    assertEquals("42", actualImmutableAttestationRunRecipient.userId());
    assertEquals(3L, actualImmutableAttestationRunRecipient.completedCount());
    assertEquals(3L, actualImmutableAttestationRunRecipient.pendingCount());
    assertEquals(6L, actualImmutableAttestationRunRecipient.totalCount());
  }

  /**
   * Test Builder {@link Builder#completedCount(long)}.
   *
   * <p>Method under test: {@link Builder#completedCount(long)}
   */
  @Test
  @DisplayName("Test Builder completedCount(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.completedCount(long)"})
  void testBuilderCompletedCount() {
    // Arrange
    Builder builderResult = ImmutableAttestationRunRecipient.builder();

    // Act
    Builder actualCompletedCountResult = builderResult.completedCount(3L);

    // Assert
    assertSame(builderResult, actualCompletedCountResult);
  }

  /**
   * Test Builder {@link Builder#from(AttestationRunRecipient)} with {@code
   * AttestationRunRecipient}.
   *
   * <p>Method under test: {@link Builder#from(AttestationRunRecipient)}
   */
  @Test
  @DisplayName("Test Builder from(AttestationRunRecipient) with 'AttestationRunRecipient'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AttestationRunRecipient)"})
  void testBuilderFromWithAttestationRunRecipient() {
    // Arrange
    Builder builderResult = ImmutableAttestationRunRecipient.builder();
    ImmutableAttestationRunRecipient instance =
        ImmutableAttestationRunRecipient.builder()
            .completedCount(3L)
            .id(1L)
            .pendingCount(3L)
            .userId("42")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAttestationRunRecipient actualImmutableAttestationRunRecipient = builderResult.build();
    assertEquals(instance, actualImmutableAttestationRunRecipient);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider() {
    // Arrange
    Builder builderResult = ImmutableAttestationRunRecipient.builder();
    ImmutableAttestationRunRecipient instance =
        ImmutableAttestationRunRecipient.builder()
            .completedCount(3L)
            .id(1L)
            .pendingCount(3L)
            .userId("42")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((IdProvider) instance);

    // Assert
    ImmutableAttestationRunRecipient actualImmutableAttestationRunRecipient = builderResult.build();
    assertEquals(instance, actualImmutableAttestationRunRecipient);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <ul>
   *   <li>Given empty.
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(IdProvider) with 'IdProvider'; given empty; when IdProvider id() return empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenEmpty_whenIdProviderIdReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableAttestationRunRecipient.builder();

    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableAttestationRunRecipient.builder();

    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Test Builder {@link Builder#id(long)} with {@code long}.
   *
   * <p>Method under test: {@link Builder#id(long)}
   */
  @Test
  @DisplayName("Test Builder id(long) with 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.id(long)"})
  void testBuilderIdWithLong() {
    // Arrange
    Builder builderResult = ImmutableAttestationRunRecipient.builder();

    // Act
    Builder actualIdResult = builderResult.id(1L);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#id(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#id(Optional)}
   */
  @Test
  @DisplayName("Test Builder id(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.id(Optional)"})
  void testBuilderIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableAttestationRunRecipient.builder();
    Optional<Long> id = Optional.of(42L);

    // Act
    Builder actualIdResult = builderResult.id(id);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#pendingCount(long)}.
   *
   * <p>Method under test: {@link Builder#pendingCount(long)}
   */
  @Test
  @DisplayName("Test Builder pendingCount(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.pendingCount(long)"})
  void testBuilderPendingCount() {
    // Arrange
    Builder builderResult = ImmutableAttestationRunRecipient.builder();

    // Act
    Builder actualPendingCountResult = builderResult.pendingCount(3L);

    // Assert
    assertSame(builderResult, actualPendingCountResult);
  }

  /**
   * Test Builder {@link Builder#totalCount(long)}.
   *
   * <p>Method under test: {@link Builder#totalCount(long)}
   */
  @Test
  @DisplayName("Test Builder totalCount(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.totalCount(long)"})
  void testBuilderTotalCount() {
    // Arrange
    Builder builderResult = ImmutableAttestationRunRecipient.builder();

    // Act
    Builder actualTotalCountResult = builderResult.totalCount(3L);

    // Assert
    assertSame(builderResult, actualTotalCountResult);
  }

  /**
   * Test Builder {@link Builder#userId(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#userId(String)}
   */
  @Test
  @DisplayName("Test Builder userId(String); when '42'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.userId(String)"})
  void testBuilderUserId_when42_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAttestationRunRecipient.builder();

    // Act
    Builder actualUserIdResult = builderResult.userId("42");

    // Assert
    assertSame(builderResult, actualUserIdResult);
  }

  /**
   * Test {@link ImmutableAttestationRunRecipient#copyOf(AttestationRunRecipient)}.
   *
   * <ul>
   *   <li>Then return userId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationRunRecipient#copyOf(AttestationRunRecipient)}
   */
  @Test
  @DisplayName("Test copyOf(AttestationRunRecipient); then return userId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationRunRecipient ImmutableAttestationRunRecipient.copyOf(AttestationRunRecipient)"
  })
  void testCopyOf_thenReturnUserIdIs42() {
    // Arrange
    ImmutableAttestationRunRecipient instance =
        ImmutableAttestationRunRecipient.builder()
            .completedCount(3L)
            .id(1L)
            .pendingCount(3L)
            .userId("42")
            .build();

    // Act
    ImmutableAttestationRunRecipient actualCopyOfResult =
        ImmutableAttestationRunRecipient.copyOf(instance);

    // Assert
    assertEquals("42", actualCopyOfResult.userId());
    assertEquals(3L, actualCopyOfResult.completedCount());
    assertEquals(3L, actualCopyOfResult.pendingCount());
    assertEquals(6L, actualCopyOfResult.totalCount());
  }

  /**
   * Test {@link ImmutableAttestationRunRecipient#equals(Object)}, and {@link
   * ImmutableAttestationRunRecipient#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAttestationRunRecipient#equals(Object)}
   *   <li>{@link ImmutableAttestationRunRecipient#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationRunRecipient.equals(Object)",
    "int ImmutableAttestationRunRecipient.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableAttestationRunRecipient immutableAttestationRunRecipient =
        ImmutableAttestationRunRecipient.builder()
            .completedCount(3L)
            .id(1L)
            .pendingCount(3L)
            .userId("42")
            .build();
    ImmutableAttestationRunRecipient immutableAttestationRunRecipient2 =
        ImmutableAttestationRunRecipient.builder()
            .completedCount(3L)
            .id(1L)
            .pendingCount(3L)
            .userId("42")
            .build();

    // Act and Assert
    assertEquals(immutableAttestationRunRecipient, immutableAttestationRunRecipient2);
    assertEquals(
        immutableAttestationRunRecipient.hashCode(), immutableAttestationRunRecipient2.hashCode());
  }

  /**
   * Test {@link ImmutableAttestationRunRecipient#equals(Object)}, and {@link
   * ImmutableAttestationRunRecipient#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAttestationRunRecipient#equals(Object)}
   *   <li>{@link ImmutableAttestationRunRecipient#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationRunRecipient.equals(Object)",
    "int ImmutableAttestationRunRecipient.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableAttestationRunRecipient immutableAttestationRunRecipient =
        ImmutableAttestationRunRecipient.builder()
            .completedCount(3L)
            .id(1L)
            .pendingCount(3L)
            .userId("42")
            .build();

    // Act and Assert
    assertEquals(immutableAttestationRunRecipient, immutableAttestationRunRecipient);
    int expectedHashCodeResult = immutableAttestationRunRecipient.hashCode();
    assertEquals(expectedHashCodeResult, immutableAttestationRunRecipient.hashCode());
  }

  /**
   * Test {@link ImmutableAttestationRunRecipient#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationRunRecipient#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationRunRecipient.equals(Object)",
    "int ImmutableAttestationRunRecipient.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableAttestationRunRecipient immutableAttestationRunRecipient =
        ImmutableAttestationRunRecipient.builder()
            .completedCount(1L)
            .id(1L)
            .pendingCount(3L)
            .userId("42")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAttestationRunRecipient,
        ImmutableAttestationRunRecipient.builder()
            .completedCount(3L)
            .id(1L)
            .pendingCount(3L)
            .userId("42")
            .build());
  }

  /**
   * Test {@link ImmutableAttestationRunRecipient#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationRunRecipient#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationRunRecipient.equals(Object)",
    "int ImmutableAttestationRunRecipient.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableAttestationRunRecipient immutableAttestationRunRecipient =
        ImmutableAttestationRunRecipient.builder()
            .completedCount(3L)
            .id(2L)
            .pendingCount(3L)
            .userId("42")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAttestationRunRecipient,
        ImmutableAttestationRunRecipient.builder()
            .completedCount(3L)
            .id(1L)
            .pendingCount(3L)
            .userId("42")
            .build());
  }

  /**
   * Test {@link ImmutableAttestationRunRecipient#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationRunRecipient#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationRunRecipient.equals(Object)",
    "int ImmutableAttestationRunRecipient.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableAttestationRunRecipient immutableAttestationRunRecipient =
        ImmutableAttestationRunRecipient.builder()
            .completedCount(3L)
            .id(1L)
            .pendingCount(1L)
            .userId("42")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAttestationRunRecipient,
        ImmutableAttestationRunRecipient.builder()
            .completedCount(3L)
            .id(1L)
            .pendingCount(3L)
            .userId("42")
            .build());
  }

  /**
   * Test {@link ImmutableAttestationRunRecipient#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationRunRecipient#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationRunRecipient.equals(Object)",
    "int ImmutableAttestationRunRecipient.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableAttestationRunRecipient immutableAttestationRunRecipient =
        ImmutableAttestationRunRecipient.builder()
            .completedCount(3L)
            .id(1L)
            .pendingCount(3L)
            .userId("User Id")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAttestationRunRecipient,
        ImmutableAttestationRunRecipient.builder()
            .completedCount(3L)
            .id(1L)
            .pendingCount(3L)
            .userId("42")
            .build());
  }

  /**
   * Test {@link ImmutableAttestationRunRecipient#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationRunRecipient#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationRunRecipient.equals(Object)",
    "int ImmutableAttestationRunRecipient.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableAttestationRunRecipient.builder()
            .completedCount(3L)
            .id(1L)
            .pendingCount(3L)
            .userId("42")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableAttestationRunRecipient#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationRunRecipient#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationRunRecipient.equals(Object)",
    "int ImmutableAttestationRunRecipient.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableAttestationRunRecipient.builder()
            .completedCount(3L)
            .id(1L)
            .pendingCount(3L)
            .userId("42")
            .build(),
        "Different type to ImmutableAttestationRunRecipient");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAttestationRunRecipient#completedCount()}
   *   <li>{@link ImmutableAttestationRunRecipient#pendingCount()}
   *   <li>{@link ImmutableAttestationRunRecipient#totalCount()}
   *   <li>{@link ImmutableAttestationRunRecipient#userId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long ImmutableAttestationRunRecipient.completedCount()",
    "long ImmutableAttestationRunRecipient.pendingCount()",
    "long ImmutableAttestationRunRecipient.totalCount()",
    "String ImmutableAttestationRunRecipient.userId()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableAttestationRunRecipient immutableAttestationRunRecipient =
        ImmutableAttestationRunRecipient.builder()
            .completedCount(3L)
            .id(1L)
            .pendingCount(3L)
            .userId("42")
            .build();

    // Act
    long actualCompletedCountResult = immutableAttestationRunRecipient.completedCount();
    long actualPendingCountResult = immutableAttestationRunRecipient.pendingCount();
    long actualTotalCountResult = immutableAttestationRunRecipient.totalCount();

    // Assert
    assertEquals("42", immutableAttestationRunRecipient.userId());
    assertEquals(3L, actualCompletedCountResult);
    assertEquals(3L, actualPendingCountResult);
    assertEquals(6L, actualTotalCountResult);
  }

  /**
   * Test {@link ImmutableAttestationRunRecipient#id()}.
   *
   * <p>Method under test: {@link ImmutableAttestationRunRecipient#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableAttestationRunRecipient.id()"})
  void testId() {
    // Arrange and Act
    Optional<Long> actualIdResult =
        ImmutableAttestationRunRecipient.builder()
            .completedCount(3L)
            .id(1L)
            .pendingCount(3L)
            .userId("42")
            .build()
            .id();

    // Assert
    assertEquals(1L, actualIdResult.get().longValue());
    assertTrue(actualIdResult.isPresent());
  }

  /**
   * Test Json {@link Json#completedCount()}.
   *
   * <p>Method under test: {@link Json#completedCount()}
   */
  @Test
  @DisplayName("Test Json completedCount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.completedCount()"})
  void testJsonCompletedCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().completedCount());
  }

  /**
   * Test Json {@link Json#id()}.
   *
   * <p>Method under test: {@link Json#id()}
   */
  @Test
  @DisplayName("Test Json id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.id()"})
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().id());
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
    assertNull(actualJson.userId);
    assertEquals(0L, actualJson.completedCount);
    assertEquals(0L, actualJson.pendingCount);
    assertEquals(0L, actualJson.totalCount);
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.completedCountIsSet);
    assertFalse(actualJson.pendingCountIsSet);
    assertFalse(actualJson.totalCountIsSet);
  }

  /**
   * Test Json {@link Json#pendingCount()}.
   *
   * <p>Method under test: {@link Json#pendingCount()}
   */
  @Test
  @DisplayName("Test Json pendingCount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.pendingCount()"})
  void testJsonPendingCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().pendingCount());
  }

  /**
   * Test Json {@link Json#setCompletedCount(long)}.
   *
   * <p>Method under test: {@link Json#setCompletedCount(long)}
   */
  @Test
  @DisplayName("Test Json setCompletedCount(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setCompletedCount(long)"})
  void testJsonSetCompletedCount() {
    // Arrange
    Json json = new Json();

    // Act
    json.setCompletedCount(3L);

    // Assert
    assertEquals(3L, json.completedCount);
    assertTrue(json.completedCountIsSet);
  }

  /**
   * Test Json {@link Json#setPendingCount(long)}.
   *
   * <p>Method under test: {@link Json#setPendingCount(long)}
   */
  @Test
  @DisplayName("Test Json setPendingCount(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setPendingCount(long)"})
  void testJsonSetPendingCount() {
    // Arrange
    Json json = new Json();

    // Act
    json.setPendingCount(3L);

    // Assert
    assertEquals(3L, json.pendingCount);
    assertTrue(json.pendingCountIsSet);
  }

  /**
   * Test Json {@link Json#setTotalCount(long)}.
   *
   * <p>Method under test: {@link Json#setTotalCount(long)}
   */
  @Test
  @DisplayName("Test Json setTotalCount(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setTotalCount(long)"})
  void testJsonSetTotalCount() {
    // Arrange
    Json json = new Json();

    // Act
    json.setTotalCount(3L);

    // Assert
    assertEquals(3L, json.totalCount);
    assertTrue(json.totalCountIsSet);
  }

  /**
   * Test Json {@link Json#totalCount()}.
   *
   * <p>Method under test: {@link Json#totalCount()}
   */
  @Test
  @DisplayName("Test Json totalCount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.totalCount()"})
  void testJsonTotalCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().totalCount());
  }

  /**
   * Test Json {@link Json#userId()}.
   *
   * <p>Method under test: {@link Json#userId()}
   */
  @Test
  @DisplayName("Test Json userId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.userId()"})
  void testJsonUserId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().userId());
  }

  /**
   * Test {@link ImmutableAttestationRunRecipient#toString()}.
   *
   * <p>Method under test: {@link ImmutableAttestationRunRecipient#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableAttestationRunRecipient.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "AttestationRunRecipient{id=1, pendingCount=3, completedCount=3, totalCount=6, userId=42}",
        ImmutableAttestationRunRecipient.builder()
            .completedCount(3L)
            .id(1L)
            .pendingCount(3L)
            .userId("42")
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableAttestationRunRecipient#withCompletedCount(long)}.
   *
   * <p>Method under test: {@link ImmutableAttestationRunRecipient#withCompletedCount(long)}
   */
  @Test
  @DisplayName("Test withCompletedCount(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationRunRecipient ImmutableAttestationRunRecipient.withCompletedCount(long)"
  })
  void testWithCompletedCount() {
    // Arrange
    ImmutableAttestationRunRecipient immutableAttestationRunRecipient =
        ImmutableAttestationRunRecipient.builder()
            .completedCount(42L)
            .id(1L)
            .pendingCount(3L)
            .userId("42")
            .build();

    // Act
    ImmutableAttestationRunRecipient actualWithCompletedCountResult =
        immutableAttestationRunRecipient.withCompletedCount(42L);

    // Assert
    assertSame(immutableAttestationRunRecipient, actualWithCompletedCountResult);
  }

  /**
   * Test {@link ImmutableAttestationRunRecipient#withCompletedCount(long)}.
   *
   * <ul>
   *   <li>Then return userId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationRunRecipient#withCompletedCount(long)}
   */
  @Test
  @DisplayName("Test withCompletedCount(long); then return userId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationRunRecipient ImmutableAttestationRunRecipient.withCompletedCount(long)"
  })
  void testWithCompletedCount_thenReturnUserIdIs42() {
    // Arrange and Act
    ImmutableAttestationRunRecipient actualWithCompletedCountResult =
        ImmutableAttestationRunRecipient.builder()
            .completedCount(3L)
            .id(1L)
            .pendingCount(3L)
            .userId("42")
            .build()
            .withCompletedCount(42L);

    // Assert
    assertEquals("42", actualWithCompletedCountResult.userId());
    assertEquals(3L, actualWithCompletedCountResult.pendingCount());
    assertEquals(42L, actualWithCompletedCountResult.completedCount());
    assertEquals(6L, actualWithCompletedCountResult.totalCount());
  }

  /**
   * Test {@link ImmutableAttestationRunRecipient#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableAttestationRunRecipient#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationRunRecipient ImmutableAttestationRunRecipient.withId(Optional)"
  })
  void testWithIdWithOptional() {
    // Arrange
    ImmutableAttestationRunRecipient immutableAttestationRunRecipient =
        ImmutableAttestationRunRecipient.builder()
            .completedCount(3L)
            .id(1L)
            .pendingCount(3L)
            .userId("42")
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableAttestationRunRecipient actualWithIdResult =
        immutableAttestationRunRecipient.withId(optional);

    // Assert
    assertSame(immutableAttestationRunRecipient, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableAttestationRunRecipient#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>When of forty-two.
   *   <li>Then return userId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationRunRecipient#withId(Optional)}
   */
  @Test
  @DisplayName(
      "Test withId(Optional) with 'optional'; when of forty-two; then return userId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationRunRecipient ImmutableAttestationRunRecipient.withId(Optional)"
  })
  void testWithIdWithOptional_whenOfFortyTwo_thenReturnUserIdIs42() {
    // Arrange
    ImmutableAttestationRunRecipient immutableAttestationRunRecipient =
        ImmutableAttestationRunRecipient.builder()
            .completedCount(3L)
            .id(1L)
            .pendingCount(3L)
            .userId("42")
            .build();
    Optional<Long> optional = Optional.of(42L);

    // Act
    ImmutableAttestationRunRecipient actualWithIdResult =
        immutableAttestationRunRecipient.withId(optional);

    // Assert
    assertEquals("42", actualWithIdResult.userId());
    assertEquals(3L, actualWithIdResult.completedCount());
    assertEquals(3L, actualWithIdResult.pendingCount());
    assertEquals(6L, actualWithIdResult.totalCount());
  }

  /**
   * Test {@link ImmutableAttestationRunRecipient#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableAttestationRunRecipient#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationRunRecipient ImmutableAttestationRunRecipient.withId(long)"
  })
  void testWithIdWithValue() {
    // Arrange
    ImmutableAttestationRunRecipient immutableAttestationRunRecipient =
        ImmutableAttestationRunRecipient.builder()
            .completedCount(3L)
            .id(1L)
            .pendingCount(3L)
            .userId("42")
            .build();

    // Act
    ImmutableAttestationRunRecipient actualWithIdResult =
        immutableAttestationRunRecipient.withId(1L);

    // Assert
    assertSame(immutableAttestationRunRecipient, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableAttestationRunRecipient#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return userId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationRunRecipient#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'; when forty-two; then return userId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationRunRecipient ImmutableAttestationRunRecipient.withId(long)"
  })
  void testWithIdWithValue_whenFortyTwo_thenReturnUserIdIs42() {
    // Arrange and Act
    ImmutableAttestationRunRecipient actualWithIdResult =
        ImmutableAttestationRunRecipient.builder()
            .completedCount(3L)
            .id(1L)
            .pendingCount(3L)
            .userId("42")
            .build()
            .withId(42L);

    // Assert
    assertEquals("42", actualWithIdResult.userId());
    assertEquals(3L, actualWithIdResult.completedCount());
    assertEquals(3L, actualWithIdResult.pendingCount());
    assertEquals(6L, actualWithIdResult.totalCount());
  }

  /**
   * Test {@link ImmutableAttestationRunRecipient#withPendingCount(long)}.
   *
   * <p>Method under test: {@link ImmutableAttestationRunRecipient#withPendingCount(long)}
   */
  @Test
  @DisplayName("Test withPendingCount(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationRunRecipient ImmutableAttestationRunRecipient.withPendingCount(long)"
  })
  void testWithPendingCount() {
    // Arrange
    ImmutableAttestationRunRecipient immutableAttestationRunRecipient =
        ImmutableAttestationRunRecipient.builder()
            .completedCount(3L)
            .id(1L)
            .pendingCount(42L)
            .userId("42")
            .build();

    // Act
    ImmutableAttestationRunRecipient actualWithPendingCountResult =
        immutableAttestationRunRecipient.withPendingCount(42L);

    // Assert
    assertSame(immutableAttestationRunRecipient, actualWithPendingCountResult);
  }

  /**
   * Test {@link ImmutableAttestationRunRecipient#withPendingCount(long)}.
   *
   * <ul>
   *   <li>Then return userId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationRunRecipient#withPendingCount(long)}
   */
  @Test
  @DisplayName("Test withPendingCount(long); then return userId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationRunRecipient ImmutableAttestationRunRecipient.withPendingCount(long)"
  })
  void testWithPendingCount_thenReturnUserIdIs42() {
    // Arrange and Act
    ImmutableAttestationRunRecipient actualWithPendingCountResult =
        ImmutableAttestationRunRecipient.builder()
            .completedCount(3L)
            .id(1L)
            .pendingCount(3L)
            .userId("42")
            .build()
            .withPendingCount(42L);

    // Assert
    assertEquals("42", actualWithPendingCountResult.userId());
    assertEquals(3L, actualWithPendingCountResult.completedCount());
    assertEquals(42L, actualWithPendingCountResult.pendingCount());
    assertEquals(6L, actualWithPendingCountResult.totalCount());
  }

  /**
   * Test {@link ImmutableAttestationRunRecipient#withTotalCount(long)}.
   *
   * <p>Method under test: {@link ImmutableAttestationRunRecipient#withTotalCount(long)}
   */
  @Test
  @DisplayName("Test withTotalCount(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationRunRecipient ImmutableAttestationRunRecipient.withTotalCount(long)"
  })
  void testWithTotalCount() {
    // Arrange
    ImmutableAttestationRunRecipient immutableAttestationRunRecipient =
        ImmutableAttestationRunRecipient.builder()
            .completedCount(3L)
            .id(1L)
            .pendingCount(3L)
            .userId("42")
            .build();

    // Act
    ImmutableAttestationRunRecipient actualWithTotalCountResult =
        immutableAttestationRunRecipient.withTotalCount(6L);

    // Assert
    assertSame(immutableAttestationRunRecipient, actualWithTotalCountResult);
  }

  /**
   * Test {@link ImmutableAttestationRunRecipient#withTotalCount(long)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return userId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationRunRecipient#withTotalCount(long)}
   */
  @Test
  @DisplayName("Test withTotalCount(long); when forty-two; then return userId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationRunRecipient ImmutableAttestationRunRecipient.withTotalCount(long)"
  })
  void testWithTotalCount_whenFortyTwo_thenReturnUserIdIs42() {
    // Arrange and Act
    ImmutableAttestationRunRecipient actualWithTotalCountResult =
        ImmutableAttestationRunRecipient.builder()
            .completedCount(3L)
            .id(1L)
            .pendingCount(3L)
            .userId("42")
            .build()
            .withTotalCount(42L);

    // Assert
    assertEquals("42", actualWithTotalCountResult.userId());
    assertEquals(3L, actualWithTotalCountResult.completedCount());
    assertEquals(3L, actualWithTotalCountResult.pendingCount());
    assertEquals(42L, actualWithTotalCountResult.totalCount());
  }

  /**
   * Test {@link ImmutableAttestationRunRecipient#withUserId(String)}.
   *
   * <p>Method under test: {@link ImmutableAttestationRunRecipient#withUserId(String)}
   */
  @Test
  @DisplayName("Test withUserId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationRunRecipient ImmutableAttestationRunRecipient.withUserId(String)"
  })
  void testWithUserId() {
    // Arrange
    ImmutableAttestationRunRecipient immutableAttestationRunRecipient =
        ImmutableAttestationRunRecipient.builder()
            .completedCount(3L)
            .id(1L)
            .pendingCount(3L)
            .userId("42")
            .build();

    // Act
    ImmutableAttestationRunRecipient actualWithUserIdResult =
        immutableAttestationRunRecipient.withUserId("42");

    // Assert
    assertSame(immutableAttestationRunRecipient, actualWithUserIdResult);
  }

  /**
   * Test {@link ImmutableAttestationRunRecipient#withUserId(String)}.
   *
   * <ul>
   *   <li>Then return userId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationRunRecipient#withUserId(String)}
   */
  @Test
  @DisplayName("Test withUserId(String); then return userId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationRunRecipient ImmutableAttestationRunRecipient.withUserId(String)"
  })
  void testWithUserId_thenReturnUserIdIs42() {
    // Arrange and Act
    ImmutableAttestationRunRecipient actualWithUserIdResult =
        ImmutableAttestationRunRecipient.builder()
            .completedCount(3L)
            .id(1L)
            .pendingCount(3L)
            .userId("userId")
            .build()
            .withUserId("42");

    // Assert
    assertEquals("42", actualWithUserIdResult.userId());
    assertEquals(3L, actualWithUserIdResult.completedCount());
    assertEquals(3L, actualWithUserIdResult.pendingCount());
    assertEquals(6L, actualWithUserIdResult.totalCount());
  }
}
