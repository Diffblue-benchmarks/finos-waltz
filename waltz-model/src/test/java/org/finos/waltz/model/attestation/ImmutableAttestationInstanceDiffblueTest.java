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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.attestation.ImmutableAttestationInstance.Builder;
import org.finos.waltz.model.attestation.ImmutableAttestationInstance.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAttestationInstanceDiffblueTest {
  /**
   * Test {@link ImmutableAttestationInstance#attestedAt()}.
   *
   * <p>Method under test: {@link ImmutableAttestationInstance#attestedAt()}
   */
  @Test
  @DisplayName("Test attestedAt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableAttestationInstance.attestedAt()"})
  void testAttestedAt() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder idResult =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(ofResult.atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);

    // Act
    Optional<LocalDateTime> actualAttestedAtResult =
        idResult
            .parentEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build()
            .attestedAt();

    // Assert
    LocalDateTime getResult = actualAttestedAtResult.get();
    assertEquals("00:00", getResult.toLocalTime().toString());
    LocalDate toLocalDateResult = getResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertTrue(actualAttestedAtResult.isPresent());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableAttestationInstance#attestedBy()}.
   *
   * <p>Method under test: {@link ImmutableAttestationInstance#attestedBy()}
   */
  @Test
  @DisplayName("Test attestedBy()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableAttestationInstance.attestedBy()"})
  void testAttestedBy() {
    // Arrange
    Builder idResult =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);

    // Act
    Optional<String> actualAttestedByResult =
        idResult
            .parentEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build()
            .attestedBy();

    // Assert
    assertEquals("Attested By", actualAttestedByResult.get());
    assertTrue(actualAttestedByResult.isPresent());
  }

  /**
   * Test Builder {@link Builder#attestationRunId(Long)}.
   *
   * <p>Method under test: {@link Builder#attestationRunId(Long)}
   */
  @Test
  @DisplayName("Test Builder attestationRunId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.attestationRunId(Long)"})
  void testBuilderAttestationRunId() {
    // Arrange
    Builder builderResult = ImmutableAttestationInstance.builder();

    // Act
    Builder actualAttestationRunIdResult = builderResult.attestationRunId(1L);

    // Assert
    assertSame(builderResult, actualAttestationRunIdResult);
  }

  /**
   * Test Builder {@link Builder#attestedAt(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#attestedAt(Optional)}
   */
  @Test
  @DisplayName("Test Builder attestedAt(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.attestedAt(Optional)"})
  void testBuilderAttestedAtWithOptional() {
    // Arrange
    Builder builderResult = ImmutableAttestationInstance.builder();
    Optional<? extends LocalDateTime> attestedAt =
        Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act
    Builder actualAttestedAtResult = builderResult.attestedAt(attestedAt);

    // Assert
    assertSame(builderResult, actualAttestedAtResult);
  }

  /**
   * Test Builder {@link Builder#attestedBy(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#attestedBy(Optional)}
   */
  @Test
  @DisplayName("Test Builder attestedBy(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.attestedBy(Optional)"})
  void testBuilderAttestedByWithOptional() {
    // Arrange
    Builder builderResult = ImmutableAttestationInstance.builder();
    Optional<String> attestedBy = Optional.of("42");

    // Act
    Builder actualAttestedByResult = builderResult.attestedBy(attestedBy);

    // Assert
    assertSame(builderResult, actualAttestedByResult);
  }

  /**
   * Test Builder {@link Builder#attestedEntityKind(EntityKind)}.
   *
   * <p>Method under test: {@link Builder#attestedEntityKind(EntityKind)}
   */
  @Test
  @DisplayName("Test Builder attestedEntityKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.attestedEntityKind(EntityKind)"})
  void testBuilderAttestedEntityKind() {
    // Arrange
    Builder builderResult = ImmutableAttestationInstance.builder();

    // Act
    Builder actualAttestedEntityKindResult = builderResult.attestedEntityKind(EntityKind.ALL);

    // Assert
    assertSame(builderResult, actualAttestedEntityKindResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#attestedAt(LocalDateTime)}
   *   <li>{@link Builder#attestedBy(String)}
   *   <li>{@link Builder#attestedEntityId(Long)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Builder Builder.attestedAt(LocalDateTime)",
    "Builder Builder.attestedBy(String)",
    "Builder Builder.attestedEntityId(Long)",
    "ImmutableAttestationInstance Builder.build()"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualAttestedAtResult =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    Optional<? extends LocalDateTime> attestedAt =
        Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    Builder actualAttestedByResult =
        actualAttestedAtResult.attestedAt(attestedAt).attestedBy("Attested By");
    Optional<String> attestedBy = Optional.of("42");
    Builder actualIdResult =
        actualAttestedByResult
            .attestedBy(attestedBy)
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);
    Optional<Long> id = Optional.of(42L);
    Builder actualIdResult2 = actualIdResult.id(id);
    ImmutableEntityReference parentEntity =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ImmutableAttestationInstance actualImmutableAttestationInstance =
        actualIdResult2.parentEntity(parentEntity).build();

    // Assert
    assertEquals(1L, actualImmutableAttestationInstance.attestationRunId().longValue());
    assertEquals(1L, actualImmutableAttestationInstance.attestedEntityId().longValue());
    assertEquals(EntityKind.ALL, actualImmutableAttestationInstance.attestedEntityKind());
    assertSame(parentEntity, actualImmutableAttestationInstance.parentEntity());
  }

  /**
   * Test Builder {@link Builder#from(AttestationInstance)} with {@code AttestationInstance}.
   *
   * <p>Method under test: {@link Builder#from(AttestationInstance)}
   */
  @Test
  @DisplayName("Test Builder from(AttestationInstance) with 'AttestationInstance'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AttestationInstance)"})
  void testBuilderFromWithAttestationInstance() {
    // Arrange
    Builder builderResult = ImmutableAttestationInstance.builder();

    Builder idResult =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);
    ImmutableAttestationInstance instance =
        idResult
            .parentEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAttestationInstance actualImmutableAttestationInstance = builderResult.build();
    assertEquals(instance, actualImmutableAttestationInstance);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AttestationInstance)} with {@code AttestationInstance}.
   *
   * <p>Method under test: {@link Builder#from(AttestationInstance)}
   */
  @Test
  @DisplayName("Test Builder from(AttestationInstance) with 'AttestationInstance'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AttestationInstance)"})
  void testBuilderFromWithAttestationInstance2() {
    // Arrange
    Builder builderResult = ImmutableAttestationInstance.builder();

    Builder idResult =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(null)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);
    ImmutableAttestationInstance instance =
        idResult
            .parentEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAttestationInstance actualImmutableAttestationInstance = builderResult.build();
    assertEquals(instance, actualImmutableAttestationInstance);
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
    Builder builderResult = ImmutableAttestationInstance.builder();

    Builder idResult =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);
    ImmutableAttestationInstance instance =
        idResult
            .parentEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act and Assert
    ImmutableAttestationInstance actualImmutableAttestationInstance =
        builderResult.from((IdProvider) instance).build();
    assertEquals(instance, actualImmutableAttestationInstance);
    ImmutableAttestationInstance actualImmutableAttestationInstance2 = builderResult.build();
    assertEquals(instance, actualImmutableAttestationInstance2);
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
  void testBuilderFromWithIdProvider2() {
    // Arrange
    Builder builderResult = ImmutableAttestationInstance.builder();

    Builder idResult =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(null)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);
    ImmutableAttestationInstance instance =
        idResult
            .parentEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act and Assert
    ImmutableAttestationInstance actualImmutableAttestationInstance =
        builderResult.from((IdProvider) instance).build();
    assertEquals(instance, actualImmutableAttestationInstance);
    ImmutableAttestationInstance actualImmutableAttestationInstance2 = builderResult.build();
    assertEquals(instance, actualImmutableAttestationInstance2);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <ul>
   *   <li>Given empty.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; given empty; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenEmpty_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAttestationInstance.builder();

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
    Builder builderResult = ImmutableAttestationInstance.builder();

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
    Builder builderResult = ImmutableAttestationInstance.builder();

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
    Builder builderResult = ImmutableAttestationInstance.builder();
    Optional<Long> id = Optional.of(42L);

    // Act
    Builder actualIdResult = builderResult.id(id);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#parentEntity(EntityReference)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#parentEntity(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder parentEntity(EntityReference); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.parentEntity(EntityReference)"})
  void testBuilderParentEntity_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAttestationInstance.builder();

    // Act
    Builder actualParentEntityResult =
        builderResult.parentEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertSame(builderResult, actualParentEntityResult);
  }

  /**
   * Test {@link ImmutableAttestationInstance#copyOf(AttestationInstance)}.
   *
   * <ul>
   *   <li>Then parentEntity return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationInstance#copyOf(AttestationInstance)}
   */
  @Test
  @DisplayName(
      "Test copyOf(AttestationInstance); then parentEntity return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationInstance ImmutableAttestationInstance.copyOf(AttestationInstance)"
  })
  void testCopyOf_thenParentEntityReturnImmutableEntityReference() {
    // Arrange
    Builder idResult =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);
    ImmutableAttestationInstance instance =
        idResult
            .parentEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    ImmutableAttestationInstance actualCopyOfResult = ImmutableAttestationInstance.copyOf(instance);

    // Assert
    EntityReference parentEntityResult = actualCopyOfResult.parentEntity();
    assertTrue(parentEntityResult instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", parentEntityResult.description());
    assertEquals(1L, actualCopyOfResult.attestationRunId().longValue());
    assertEquals(1L, actualCopyOfResult.attestedEntityId().longValue());
    assertEquals(1L, parentEntityResult.id());
    assertEquals(EntityKind.ALL, parentEntityResult.kind());
    assertEquals(EntityKind.ALL, actualCopyOfResult.attestedEntityKind());
    assertEquals(EntityLifecycleStatus.ACTIVE, parentEntityResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableAttestationInstance#equals(Object)}, and {@link
   * ImmutableAttestationInstance#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAttestationInstance#equals(Object)}
   *   <li>{@link ImmutableAttestationInstance#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationInstance.equals(Object)",
    "int ImmutableAttestationInstance.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder idResult =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);
    ImmutableAttestationInstance immutableAttestationInstance =
        idResult
            .parentEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder idResult2 =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);
    ImmutableAttestationInstance immutableAttestationInstance2 =
        idResult2
            .parentEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableAttestationInstance, immutableAttestationInstance2);
    assertEquals(immutableAttestationInstance.hashCode(), immutableAttestationInstance2.hashCode());
  }

  /**
   * Test {@link ImmutableAttestationInstance#equals(Object)}, and {@link
   * ImmutableAttestationInstance#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAttestationInstance#equals(Object)}
   *   <li>{@link ImmutableAttestationInstance#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationInstance.equals(Object)",
    "int ImmutableAttestationInstance.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder idResult =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);
    ImmutableAttestationInstance immutableAttestationInstance =
        idResult
            .parentEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableAttestationInstance, immutableAttestationInstance);
    int expectedHashCodeResult = immutableAttestationInstance.hashCode();
    assertEquals(expectedHashCodeResult, immutableAttestationInstance.hashCode());
  }

  /**
   * Test {@link ImmutableAttestationInstance#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationInstance#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationInstance.equals(Object)",
    "int ImmutableAttestationInstance.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder idResult =
        ImmutableAttestationInstance.builder()
            .attestationRunId(2L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);
    ImmutableAttestationInstance immutableAttestationInstance =
        idResult
            .parentEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder idResult2 =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);

    // Act and Assert
    assertNotEquals(
        immutableAttestationInstance,
        idResult2
            .parentEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableAttestationInstance#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationInstance#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationInstance.equals(Object)",
    "int ImmutableAttestationInstance.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder idResult =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.now().atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);
    ImmutableAttestationInstance immutableAttestationInstance =
        idResult
            .parentEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder idResult2 =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);

    // Act and Assert
    assertNotEquals(
        immutableAttestationInstance,
        idResult2
            .parentEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableAttestationInstance#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationInstance#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationInstance.equals(Object)",
    "int ImmutableAttestationInstance.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder idResult =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("attestationRunId")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);
    ImmutableAttestationInstance immutableAttestationInstance =
        idResult
            .parentEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder idResult2 =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);

    // Act and Assert
    assertNotEquals(
        immutableAttestationInstance,
        idResult2
            .parentEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableAttestationInstance#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationInstance#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationInstance.equals(Object)",
    "int ImmutableAttestationInstance.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder idResult =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(2L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);
    ImmutableAttestationInstance immutableAttestationInstance =
        idResult
            .parentEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder idResult2 =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);

    // Act and Assert
    assertNotEquals(
        immutableAttestationInstance,
        idResult2
            .parentEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableAttestationInstance#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationInstance#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationInstance.equals(Object)",
    "int ImmutableAttestationInstance.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder idResult =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ACTOR)
            .id(1L);
    ImmutableAttestationInstance immutableAttestationInstance =
        idResult
            .parentEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder idResult2 =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);

    // Act and Assert
    assertNotEquals(
        immutableAttestationInstance,
        idResult2
            .parentEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableAttestationInstance#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationInstance#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationInstance.equals(Object)",
    "int ImmutableAttestationInstance.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Builder idResult =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(2L);
    ImmutableAttestationInstance immutableAttestationInstance =
        idResult
            .parentEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder idResult2 =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);

    // Act and Assert
    assertNotEquals(
        immutableAttestationInstance,
        idResult2
            .parentEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableAttestationInstance#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationInstance#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationInstance.equals(Object)",
    "int ImmutableAttestationInstance.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    Builder idResult =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);
    ImmutableAttestationInstance immutableAttestationInstance =
        idResult
            .parentEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder idResult2 =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);

    // Act and Assert
    assertNotEquals(
        immutableAttestationInstance,
        idResult2
            .parentEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableAttestationInstance#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationInstance#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationInstance.equals(Object)",
    "int ImmutableAttestationInstance.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder idResult =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);

    // Act and Assert
    assertNotEquals(
        idResult
            .parentEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableAttestationInstance#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationInstance#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationInstance.equals(Object)",
    "int ImmutableAttestationInstance.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder idResult =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);

    // Act and Assert
    assertNotEquals(
        idResult
            .parentEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build(),
        "Different type to ImmutableAttestationInstance");
  }

  /**
   * Test {@link ImmutableAttestationInstance#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return attestedEntityId longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationInstance#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return attestedEntityId longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAttestationInstance ImmutableAttestationInstance.fromJson(Json)"})
  void testFromJson_thenReturnAttestedEntityIdLongValueIsOne() {
    // Arrange
    Json json = new Json();
    Optional<Long> id = Optional.of(42L);
    json.setId(id);
    json.setAttestationRunId(1L);
    json.setParentEntity(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    Optional<LocalDateTime> attestedAt = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    json.setAttestedAt(attestedAt);
    Optional<String> attestedBy = Optional.of("42");
    json.setAttestedBy(attestedBy);
    json.setAttestedEntityKind(EntityKind.ALL);
    json.setAttestedEntityId(1L);

    // Act
    ImmutableAttestationInstance actualFromJsonResult = ImmutableAttestationInstance.fromJson(json);

    // Assert
    assertEquals(1L, actualFromJsonResult.attestationRunId().longValue());
    assertEquals(1L, actualFromJsonResult.attestedEntityId().longValue());
    assertEquals(EntityKind.ALL, actualFromJsonResult.attestedEntityKind());
    EntityReference expectedParentEntityResult = json.parentEntity;
    assertSame(expectedParentEntityResult, actualFromJsonResult.parentEntity());
  }

  /**
   * Test {@link ImmutableAttestationInstance#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) AttestedAt is {@code null}.
   *   <li>Then return attestedEntityId longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationInstance#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) AttestedAt is 'null'; then return attestedEntityId longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAttestationInstance ImmutableAttestationInstance.fromJson(Json)"})
  void testFromJson_whenJsonAttestedAtIsNull_thenReturnAttestedEntityIdLongValueIsOne() {
    // Arrange
    Json json = new Json();
    Optional<Long> id = Optional.of(42L);
    json.setId(id);
    json.setAttestationRunId(1L);
    json.setParentEntity(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setAttestedAt(null);
    Optional<String> attestedBy = Optional.of("42");
    json.setAttestedBy(attestedBy);
    json.setAttestedEntityKind(EntityKind.ALL);
    json.setAttestedEntityId(1L);

    // Act
    ImmutableAttestationInstance actualFromJsonResult = ImmutableAttestationInstance.fromJson(json);

    // Assert
    assertEquals(1L, actualFromJsonResult.attestationRunId().longValue());
    assertEquals(1L, actualFromJsonResult.attestedEntityId().longValue());
    assertEquals(EntityKind.ALL, actualFromJsonResult.attestedEntityKind());
    EntityReference expectedParentEntityResult = json.parentEntity;
    assertSame(expectedParentEntityResult, actualFromJsonResult.parentEntity());
  }

  /**
   * Test {@link ImmutableAttestationInstance#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) AttestedBy is {@code null}.
   *   <li>Then return attestedEntityId longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationInstance#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) AttestedBy is 'null'; then return attestedEntityId longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAttestationInstance ImmutableAttestationInstance.fromJson(Json)"})
  void testFromJson_whenJsonAttestedByIsNull_thenReturnAttestedEntityIdLongValueIsOne() {
    // Arrange
    Json json = new Json();
    Optional<Long> id = Optional.of(42L);
    json.setId(id);
    json.setAttestationRunId(1L);
    json.setParentEntity(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    Optional<LocalDateTime> attestedAt = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    json.setAttestedAt(attestedAt);
    json.setAttestedBy(null);
    json.setAttestedEntityKind(EntityKind.ALL);
    json.setAttestedEntityId(1L);

    // Act
    ImmutableAttestationInstance actualFromJsonResult = ImmutableAttestationInstance.fromJson(json);

    // Assert
    assertEquals(1L, actualFromJsonResult.attestationRunId().longValue());
    assertEquals(1L, actualFromJsonResult.attestedEntityId().longValue());
    assertEquals(EntityKind.ALL, actualFromJsonResult.attestedEntityKind());
    EntityReference expectedParentEntityResult = json.parentEntity;
    assertSame(expectedParentEntityResult, actualFromJsonResult.parentEntity());
  }

  /**
   * Test {@link ImmutableAttestationInstance#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) AttestedEntityId is {@code null}.
   *   <li>Then return attestedEntityId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationInstance#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) AttestedEntityId is 'null'; then return attestedEntityId is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAttestationInstance ImmutableAttestationInstance.fromJson(Json)"})
  void testFromJson_whenJsonAttestedEntityIdIsNull_thenReturnAttestedEntityIdIsNull() {
    // Arrange
    Json json = new Json();
    Optional<Long> id = Optional.of(42L);
    json.setId(id);
    json.setAttestationRunId(1L);
    json.setParentEntity(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    Optional<LocalDateTime> attestedAt = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    json.setAttestedAt(attestedAt);
    Optional<String> attestedBy = Optional.of("42");
    json.setAttestedBy(attestedBy);
    json.setAttestedEntityKind(EntityKind.ALL);
    json.setAttestedEntityId(null);

    // Act
    ImmutableAttestationInstance actualFromJsonResult = ImmutableAttestationInstance.fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.attestedEntityId());
    assertEquals(1L, actualFromJsonResult.attestationRunId().longValue());
    assertEquals(EntityKind.ALL, actualFromJsonResult.attestedEntityKind());
    EntityReference expectedParentEntityResult = json.parentEntity;
    assertSame(expectedParentEntityResult, actualFromJsonResult.parentEntity());
  }

  /**
   * Test {@link ImmutableAttestationInstance#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) Id is {@code null}.
   *   <li>Then return attestedEntityId longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationInstance#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) Id is 'null'; then return attestedEntityId longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAttestationInstance ImmutableAttestationInstance.fromJson(Json)"})
  void testFromJson_whenJsonIdIsNull_thenReturnAttestedEntityIdLongValueIsOne() {
    // Arrange
    Json json = new Json();
    json.setId(null);
    json.setAttestationRunId(1L);
    json.setParentEntity(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    Optional<LocalDateTime> attestedAt = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    json.setAttestedAt(attestedAt);
    Optional<String> attestedBy = Optional.of("42");
    json.setAttestedBy(attestedBy);
    json.setAttestedEntityKind(EntityKind.ALL);
    json.setAttestedEntityId(1L);

    // Act
    ImmutableAttestationInstance actualFromJsonResult = ImmutableAttestationInstance.fromJson(json);

    // Assert
    assertEquals(1L, actualFromJsonResult.attestationRunId().longValue());
    assertEquals(1L, actualFromJsonResult.attestedEntityId().longValue());
    assertEquals(EntityKind.ALL, actualFromJsonResult.attestedEntityKind());
    EntityReference expectedParentEntityResult = json.parentEntity;
    assertSame(expectedParentEntityResult, actualFromJsonResult.parentEntity());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAttestationInstance#attestationRunId()}
   *   <li>{@link ImmutableAttestationInstance#attestedEntityId()}
   *   <li>{@link ImmutableAttestationInstance#attestedEntityKind()}
   *   <li>{@link ImmutableAttestationInstance#parentEntity()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long ImmutableAttestationInstance.attestationRunId()",
    "Long ImmutableAttestationInstance.attestedEntityId()",
    "EntityKind ImmutableAttestationInstance.attestedEntityKind()",
    "EntityReference ImmutableAttestationInstance.parentEntity()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder idResult =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);
    ImmutableAttestationInstance immutableAttestationInstance =
        idResult
            .parentEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    Long actualAttestationRunIdResult = immutableAttestationInstance.attestationRunId();
    Long actualAttestedEntityIdResult = immutableAttestationInstance.attestedEntityId();
    EntityKind actualAttestedEntityKindResult = immutableAttestationInstance.attestedEntityKind();

    // Assert
    assertTrue(immutableAttestationInstance.parentEntity() instanceof ImmutableEntityReference);
    assertEquals(1L, actualAttestationRunIdResult.longValue());
    assertEquals(1L, actualAttestedEntityIdResult.longValue());
    assertEquals(EntityKind.ALL, actualAttestedEntityKindResult);
  }

  /**
   * Test {@link ImmutableAttestationInstance#id()}.
   *
   * <p>Method under test: {@link ImmutableAttestationInstance#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableAttestationInstance.id()"})
  void testId() {
    // Arrange
    Builder idResult =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);

    // Act
    Optional<Long> actualIdResult =
        idResult
            .parentEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build()
            .id();

    // Assert
    assertEquals(1L, actualIdResult.get().longValue());
    assertTrue(actualIdResult.isPresent());
  }

  /**
   * Test Json {@link Json#attestationRunId()}.
   *
   * <p>Method under test: {@link Json#attestationRunId()}
   */
  @Test
  @DisplayName("Test Json attestationRunId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long Json.attestationRunId()"})
  void testJsonAttestationRunId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().attestationRunId());
  }

  /**
   * Test Json {@link Json#attestedAt()}.
   *
   * <p>Method under test: {@link Json#attestedAt()}
   */
  @Test
  @DisplayName("Test Json attestedAt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.attestedAt()"})
  void testJsonAttestedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().attestedAt());
  }

  /**
   * Test Json {@link Json#attestedBy()}.
   *
   * <p>Method under test: {@link Json#attestedBy()}
   */
  @Test
  @DisplayName("Test Json attestedBy()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.attestedBy()"})
  void testJsonAttestedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().attestedBy());
  }

  /**
   * Test Json {@link Json#attestedEntityId()}.
   *
   * <p>Method under test: {@link Json#attestedEntityId()}
   */
  @Test
  @DisplayName("Test Json attestedEntityId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long Json.attestedEntityId()"})
  void testJsonAttestedEntityId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().attestedEntityId());
  }

  /**
   * Test Json {@link Json#attestedEntityKind()}.
   *
   * <p>Method under test: {@link Json#attestedEntityKind()}
   */
  @Test
  @DisplayName("Test Json attestedEntityKind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind Json.attestedEntityKind()"})
  void testJsonAttestedEntityKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().attestedEntityKind());
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
    assertNull(actualJson.attestationRunId);
    assertNull(actualJson.attestedEntityId);
    assertNull(actualJson.attestedEntityKind);
    assertNull(actualJson.parentEntity);
    assertFalse(actualJson.attestedAt.isPresent());
    assertFalse(actualJson.attestedBy.isPresent());
    assertFalse(actualJson.id.isPresent());
  }

  /**
   * Test Json {@link Json#parentEntity()}.
   *
   * <p>Method under test: {@link Json#parentEntity()}
   */
  @Test
  @DisplayName("Test Json parentEntity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.parentEntity()"})
  void testJsonParentEntity() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().parentEntity());
  }

  /**
   * Test {@link ImmutableAttestationInstance#toString()}.
   *
   * <p>Method under test: {@link ImmutableAttestationInstance#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableAttestationInstance.toString()"})
  void testToString() {
    // Arrange
    Builder idResult =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);

    // Act and Assert
    assertEquals(
        "AttestationInstance{id=1, attestationRunId=1, parentEntity=EntityReference{kind=ALL, id=1, entityLif"
            + "ecycleStatus=ACTIVE}, attestedAt=1970-01-01T00:00, attestedBy=Attested By, attestedEntityKind=ALL,"
            + " attestedEntityId=1}",
        idResult
            .parentEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableAttestationInstance#toString()}.
   *
   * <p>Method under test: {@link ImmutableAttestationInstance#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableAttestationInstance.toString()"})
  void testToString2() {
    // Arrange
    Builder idResult =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(null)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);

    // Act and Assert
    assertEquals(
        "AttestationInstance{id=1, attestationRunId=1, parentEntity=EntityReference{kind=ALL, id=1, entityLif"
            + "ecycleStatus=ACTIVE}, attestedAt=1970-01-01T00:00, attestedBy=Attested By, attestedEntityKind=ALL}",
        idResult
            .parentEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableAttestationInstance#withAttestationRunId(Long)}.
   *
   * <p>Method under test: {@link ImmutableAttestationInstance#withAttestationRunId(Long)}
   */
  @Test
  @DisplayName("Test withAttestationRunId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationInstance ImmutableAttestationInstance.withAttestationRunId(Long)"
  })
  void testWithAttestationRunId() {
    // Arrange
    Builder idResult =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);
    ImmutableAttestationInstance immutableAttestationInstance =
        idResult
            .parentEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    ImmutableAttestationInstance actualWithAttestationRunIdResult =
        immutableAttestationInstance.withAttestationRunId(1L);

    // Assert
    assertSame(immutableAttestationInstance, actualWithAttestationRunIdResult);
  }

  /**
   * Test {@link ImmutableAttestationInstance#withAttestationRunId(Long)}.
   *
   * <ul>
   *   <li>Then parentEntity return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationInstance#withAttestationRunId(Long)}
   */
  @Test
  @DisplayName("Test withAttestationRunId(Long); then parentEntity return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationInstance ImmutableAttestationInstance.withAttestationRunId(Long)"
  })
  void testWithAttestationRunId_thenParentEntityReturnImmutableEntityReference() {
    // Arrange
    Builder idResult =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);

    // Act
    ImmutableAttestationInstance actualWithAttestationRunIdResult =
        idResult
            .parentEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build()
            .withAttestationRunId(42L);

    // Assert
    EntityReference parentEntityResult = actualWithAttestationRunIdResult.parentEntity();
    assertTrue(parentEntityResult instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", parentEntityResult.description());
    assertEquals(1L, actualWithAttestationRunIdResult.attestedEntityId().longValue());
    assertEquals(1L, parentEntityResult.id());
    assertEquals(42L, actualWithAttestationRunIdResult.attestationRunId().longValue());
    assertEquals(EntityKind.ALL, parentEntityResult.kind());
    assertEquals(EntityKind.ALL, actualWithAttestationRunIdResult.attestedEntityKind());
    assertEquals(EntityLifecycleStatus.ACTIVE, parentEntityResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableAttestationInstance#withAttestedAt(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableAttestationInstance#withAttestedAt(Optional)}
   */
  @Test
  @DisplayName("Test withAttestedAt(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationInstance ImmutableAttestationInstance.withAttestedAt(Optional)"
  })
  void testWithAttestedAtWithOptional() {
    // Arrange
    Builder idResult =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);
    ImmutableAttestationInstance immutableAttestationInstance =
        idResult
            .parentEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();
    Optional<? extends LocalDateTime> optional =
        Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act
    ImmutableAttestationInstance actualWithAttestedAtResult =
        immutableAttestationInstance.withAttestedAt(optional);

    // Assert
    assertEquals(immutableAttestationInstance, actualWithAttestedAtResult);
  }

  /**
   * Test {@link ImmutableAttestationInstance#withAttestedAt(LocalDateTime)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableAttestationInstance#withAttestedAt(LocalDateTime)}
   */
  @Test
  @DisplayName("Test withAttestedAt(LocalDateTime) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationInstance ImmutableAttestationInstance.withAttestedAt(LocalDateTime)"
  })
  void testWithAttestedAtWithValue() {
    // Arrange
    Builder idResult =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);
    ImmutableAttestationInstance immutableAttestationInstance =
        idResult
            .parentEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    ImmutableAttestationInstance actualWithAttestedAtResult =
        immutableAttestationInstance.withAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertEquals(immutableAttestationInstance, actualWithAttestedAtResult);
  }

  /**
   * Test {@link ImmutableAttestationInstance#withAttestedBy(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableAttestationInstance#withAttestedBy(Optional)}
   */
  @Test
  @DisplayName("Test withAttestedBy(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationInstance ImmutableAttestationInstance.withAttestedBy(Optional)"
  })
  void testWithAttestedByWithOptional() {
    // Arrange
    Builder idResult =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("42")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);
    ImmutableAttestationInstance immutableAttestationInstance =
        idResult
            .parentEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableAttestationInstance actualWithAttestedByResult =
        immutableAttestationInstance.withAttestedBy(optional);

    // Assert
    assertSame(immutableAttestationInstance, actualWithAttestedByResult);
  }

  /**
   * Test {@link ImmutableAttestationInstance#withAttestedBy(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then parentEntity return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationInstance#withAttestedBy(Optional)}
   */
  @Test
  @DisplayName(
      "Test withAttestedBy(Optional) with 'optional'; then parentEntity return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationInstance ImmutableAttestationInstance.withAttestedBy(Optional)"
  })
  void testWithAttestedByWithOptional_thenParentEntityReturnImmutableEntityReference() {
    // Arrange
    Builder idResult =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);
    ImmutableAttestationInstance immutableAttestationInstance =
        idResult
            .parentEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableAttestationInstance actualWithAttestedByResult =
        immutableAttestationInstance.withAttestedBy(optional);

    // Assert
    EntityReference parentEntityResult = actualWithAttestedByResult.parentEntity();
    assertTrue(parentEntityResult instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", parentEntityResult.description());
    assertEquals(1L, actualWithAttestedByResult.attestationRunId().longValue());
    assertEquals(1L, actualWithAttestedByResult.attestedEntityId().longValue());
    assertEquals(1L, parentEntityResult.id());
    assertEquals(EntityKind.ALL, parentEntityResult.kind());
    assertEquals(EntityKind.ALL, actualWithAttestedByResult.attestedEntityKind());
    assertEquals(EntityLifecycleStatus.ACTIVE, parentEntityResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableAttestationInstance#withAttestedBy(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableAttestationInstance#withAttestedBy(String)}
   */
  @Test
  @DisplayName("Test withAttestedBy(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationInstance ImmutableAttestationInstance.withAttestedBy(String)"
  })
  void testWithAttestedByWithValue() {
    // Arrange
    Builder idResult =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("42")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);
    ImmutableAttestationInstance immutableAttestationInstance =
        idResult
            .parentEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    ImmutableAttestationInstance actualWithAttestedByResult =
        immutableAttestationInstance.withAttestedBy("42");

    // Assert
    assertSame(immutableAttestationInstance, actualWithAttestedByResult);
  }

  /**
   * Test {@link ImmutableAttestationInstance#withAttestedBy(String)} with {@code value}.
   *
   * <ul>
   *   <li>Then parentEntity return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationInstance#withAttestedBy(String)}
   */
  @Test
  @DisplayName(
      "Test withAttestedBy(String) with 'value'; then parentEntity return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationInstance ImmutableAttestationInstance.withAttestedBy(String)"
  })
  void testWithAttestedByWithValue_thenParentEntityReturnImmutableEntityReference() {
    // Arrange
    Builder idResult =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);

    // Act
    ImmutableAttestationInstance actualWithAttestedByResult =
        idResult
            .parentEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build()
            .withAttestedBy("42");

    // Assert
    EntityReference parentEntityResult = actualWithAttestedByResult.parentEntity();
    assertTrue(parentEntityResult instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", parentEntityResult.description());
    assertEquals(1L, actualWithAttestedByResult.attestationRunId().longValue());
    assertEquals(1L, actualWithAttestedByResult.attestedEntityId().longValue());
    assertEquals(1L, parentEntityResult.id());
    assertEquals(EntityKind.ALL, parentEntityResult.kind());
    assertEquals(EntityKind.ALL, actualWithAttestedByResult.attestedEntityKind());
    assertEquals(EntityLifecycleStatus.ACTIVE, parentEntityResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableAttestationInstance#withAttestedEntityId(Long)}.
   *
   * <p>Method under test: {@link ImmutableAttestationInstance#withAttestedEntityId(Long)}
   */
  @Test
  @DisplayName("Test withAttestedEntityId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationInstance ImmutableAttestationInstance.withAttestedEntityId(Long)"
  })
  void testWithAttestedEntityId() {
    // Arrange
    Builder idResult =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);
    ImmutableAttestationInstance immutableAttestationInstance =
        idResult
            .parentEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    ImmutableAttestationInstance actualWithAttestedEntityIdResult =
        immutableAttestationInstance.withAttestedEntityId(1L);

    // Assert
    assertSame(immutableAttestationInstance, actualWithAttestedEntityIdResult);
  }

  /**
   * Test {@link ImmutableAttestationInstance#withAttestedEntityId(Long)}.
   *
   * <ul>
   *   <li>Then parentEntity return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationInstance#withAttestedEntityId(Long)}
   */
  @Test
  @DisplayName("Test withAttestedEntityId(Long); then parentEntity return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationInstance ImmutableAttestationInstance.withAttestedEntityId(Long)"
  })
  void testWithAttestedEntityId_thenParentEntityReturnImmutableEntityReference() {
    // Arrange
    Builder idResult =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);

    // Act
    ImmutableAttestationInstance actualWithAttestedEntityIdResult =
        idResult
            .parentEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build()
            .withAttestedEntityId(42L);

    // Assert
    EntityReference parentEntityResult = actualWithAttestedEntityIdResult.parentEntity();
    assertTrue(parentEntityResult instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", parentEntityResult.description());
    assertEquals(1L, actualWithAttestedEntityIdResult.attestationRunId().longValue());
    assertEquals(1L, parentEntityResult.id());
    assertEquals(42L, actualWithAttestedEntityIdResult.attestedEntityId().longValue());
    assertEquals(EntityKind.ALL, parentEntityResult.kind());
    assertEquals(EntityKind.ALL, actualWithAttestedEntityIdResult.attestedEntityKind());
    assertEquals(EntityLifecycleStatus.ACTIVE, parentEntityResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableAttestationInstance#withAttestedEntityKind(EntityKind)}.
   *
   * <p>Method under test: {@link ImmutableAttestationInstance#withAttestedEntityKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withAttestedEntityKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationInstance ImmutableAttestationInstance.withAttestedEntityKind(EntityKind)"
  })
  void testWithAttestedEntityKind() {
    // Arrange
    Builder idResult =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);
    ImmutableAttestationInstance immutableAttestationInstance =
        idResult
            .parentEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    ImmutableAttestationInstance actualWithAttestedEntityKindResult =
        immutableAttestationInstance.withAttestedEntityKind(EntityKind.ALL);

    // Assert
    assertSame(immutableAttestationInstance, actualWithAttestedEntityKindResult);
  }

  /**
   * Test {@link ImmutableAttestationInstance#withAttestedEntityKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then parentEntity return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationInstance#withAttestedEntityKind(EntityKind)}
   */
  @Test
  @DisplayName(
      "Test withAttestedEntityKind(EntityKind); then parentEntity return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationInstance ImmutableAttestationInstance.withAttestedEntityKind(EntityKind)"
  })
  void testWithAttestedEntityKind_thenParentEntityReturnImmutableEntityReference() {
    // Arrange
    Builder idResult =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ACTOR)
            .id(1L);

    // Act
    ImmutableAttestationInstance actualWithAttestedEntityKindResult =
        idResult
            .parentEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build()
            .withAttestedEntityKind(EntityKind.ALL);

    // Assert
    EntityReference parentEntityResult = actualWithAttestedEntityKindResult.parentEntity();
    assertTrue(parentEntityResult instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", parentEntityResult.description());
    assertEquals(1L, actualWithAttestedEntityKindResult.attestationRunId().longValue());
    assertEquals(1L, actualWithAttestedEntityKindResult.attestedEntityId().longValue());
    assertEquals(1L, parentEntityResult.id());
    assertEquals(EntityKind.ALL, parentEntityResult.kind());
    assertEquals(EntityKind.ALL, actualWithAttestedEntityKindResult.attestedEntityKind());
    assertEquals(EntityLifecycleStatus.ACTIVE, parentEntityResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableAttestationInstance#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableAttestationInstance#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAttestationInstance ImmutableAttestationInstance.withId(Optional)"})
  void testWithIdWithOptional() {
    // Arrange
    Builder idResult =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);
    ImmutableAttestationInstance immutableAttestationInstance =
        idResult
            .parentEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableAttestationInstance actualWithIdResult = immutableAttestationInstance.withId(optional);

    // Assert
    assertSame(immutableAttestationInstance, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableAttestationInstance#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then parentEntity return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationInstance#withId(Optional)}
   */
  @Test
  @DisplayName(
      "Test withId(Optional) with 'optional'; then parentEntity return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAttestationInstance ImmutableAttestationInstance.withId(Optional)"})
  void testWithIdWithOptional_thenParentEntityReturnImmutableEntityReference() {
    // Arrange
    Builder idResult =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);
    ImmutableAttestationInstance immutableAttestationInstance =
        idResult
            .parentEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();
    Optional<Long> optional = Optional.of(42L);

    // Act
    ImmutableAttestationInstance actualWithIdResult = immutableAttestationInstance.withId(optional);

    // Assert
    EntityReference parentEntityResult = actualWithIdResult.parentEntity();
    assertTrue(parentEntityResult instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", parentEntityResult.description());
    assertEquals(1L, actualWithIdResult.attestationRunId().longValue());
    assertEquals(1L, actualWithIdResult.attestedEntityId().longValue());
    assertEquals(1L, parentEntityResult.id());
    assertEquals(EntityKind.ALL, parentEntityResult.kind());
    assertEquals(EntityKind.ALL, actualWithIdResult.attestedEntityKind());
    assertEquals(EntityLifecycleStatus.ACTIVE, parentEntityResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableAttestationInstance#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableAttestationInstance#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAttestationInstance ImmutableAttestationInstance.withId(long)"})
  void testWithIdWithValue() {
    // Arrange
    Builder idResult =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);
    ImmutableAttestationInstance immutableAttestationInstance =
        idResult
            .parentEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    ImmutableAttestationInstance actualWithIdResult = immutableAttestationInstance.withId(1L);

    // Assert
    assertSame(immutableAttestationInstance, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableAttestationInstance#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then parentEntity return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationInstance#withId(long)}
   */
  @Test
  @DisplayName(
      "Test withId(long) with 'value'; when forty-two; then parentEntity return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAttestationInstance ImmutableAttestationInstance.withId(long)"})
  void testWithIdWithValue_whenFortyTwo_thenParentEntityReturnImmutableEntityReference() {
    // Arrange
    Builder idResult =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);

    // Act
    ImmutableAttestationInstance actualWithIdResult =
        idResult
            .parentEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build()
            .withId(42L);

    // Assert
    EntityReference parentEntityResult = actualWithIdResult.parentEntity();
    assertTrue(parentEntityResult instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", parentEntityResult.description());
    assertEquals(1L, actualWithIdResult.attestationRunId().longValue());
    assertEquals(1L, actualWithIdResult.attestedEntityId().longValue());
    assertEquals(1L, parentEntityResult.id());
    assertEquals(EntityKind.ALL, parentEntityResult.kind());
    assertEquals(EntityKind.ALL, actualWithIdResult.attestedEntityKind());
    assertEquals(EntityLifecycleStatus.ACTIVE, parentEntityResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableAttestationInstance#withParentEntity(EntityReference)}.
   *
   * <p>Method under test: {@link ImmutableAttestationInstance#withParentEntity(EntityReference)}
   */
  @Test
  @DisplayName("Test withParentEntity(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationInstance ImmutableAttestationInstance.withParentEntity(EntityReference)"
  })
  void testWithParentEntity() {
    // Arrange
    Builder idResult =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);
    ImmutableAttestationInstance immutableAttestationInstance =
        idResult
            .parentEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    ImmutableAttestationInstance actualWithParentEntityResult =
        immutableAttestationInstance.withParentEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableAttestationInstance, actualWithParentEntityResult);
  }
}
