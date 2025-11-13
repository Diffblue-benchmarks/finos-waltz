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
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.attestation.ImmutableAttestationInstanceRecipient.Builder;
import org.finos.waltz.model.attestation.ImmutableAttestationInstanceRecipient.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAttestationInstanceRecipientDiffblueTest {
  /**
   * Test Builder {@link Builder#attestationInstance(AttestationInstance)}.
   *
   * <ul>
   *   <li>When {@link ImmutableAttestationInstance.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#attestationInstance(AttestationInstance)}
   */
  @Test
  @DisplayName(
      "Test Builder attestationInstance(AttestationInstance); when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.attestationInstance(AttestationInstance)"})
  void testBuilderAttestationInstance_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAttestationInstanceRecipient.builder();

    // Act
    Builder actualAttestationInstanceResult =
        builderResult.attestationInstance(new ImmutableAttestationInstance.Json());

    // Assert
    assertSame(builderResult, actualAttestationInstanceResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAttestationInstanceRecipient Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableAttestationInstanceRecipient.builder();
    ImmutableAttestationInstance.Builder idResult =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);
    ImmutableAttestationInstance attestationInstance =
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
    Builder actualIdResult = actualBuilderResult.attestationInstance(attestationInstance).id(1L);
    Optional<Long> id = Optional.of(42L);
    ImmutableAttestationInstanceRecipient actualImmutableAttestationInstanceRecipient =
        actualIdResult.id(id).userId("42").build();

    // Assert
    assertEquals("42", actualImmutableAttestationInstanceRecipient.userId());
    assertSame(
        attestationInstance, actualImmutableAttestationInstanceRecipient.attestationInstance());
  }

  /**
   * Test Builder {@link Builder#from(AttestationInstanceRecipient)} with {@code
   * AttestationInstanceRecipient}.
   *
   * <p>Method under test: {@link Builder#from(AttestationInstanceRecipient)}
   */
  @Test
  @DisplayName(
      "Test Builder from(AttestationInstanceRecipient) with 'AttestationInstanceRecipient'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AttestationInstanceRecipient)"})
  void testBuilderFromWithAttestationInstanceRecipient() {
    // Arrange
    Builder builderResult = ImmutableAttestationInstanceRecipient.builder();

    Builder builderResult2 = ImmutableAttestationInstanceRecipient.builder();

    ImmutableAttestationInstance.Builder idResult =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);
    ImmutableAttestationInstanceRecipient instance =
        builderResult2
            .attestationInstance(
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
                    .build())
            .id(1L)
            .userId("42")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAttestationInstanceRecipient actualImmutableAttestationInstanceRecipient =
        builderResult.build();
    assertEquals(instance, actualImmutableAttestationInstanceRecipient);
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
    Builder builderResult = ImmutableAttestationInstanceRecipient.builder();

    Builder builderResult2 = ImmutableAttestationInstanceRecipient.builder();

    ImmutableAttestationInstance.Builder idResult =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);
    ImmutableAttestationInstanceRecipient instance =
        builderResult2
            .attestationInstance(
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
                    .build())
            .id(1L)
            .userId("42")
            .build();

    // Act and Assert
    ImmutableAttestationInstanceRecipient actualImmutableAttestationInstanceRecipient =
        builderResult.from((IdProvider) instance).build();
    assertEquals(instance, actualImmutableAttestationInstanceRecipient);
    ImmutableAttestationInstanceRecipient actualImmutableAttestationInstanceRecipient2 =
        builderResult.build();
    assertEquals(instance, actualImmutableAttestationInstanceRecipient2);
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
    Builder builderResult = ImmutableAttestationInstanceRecipient.builder();

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
    Builder builderResult = ImmutableAttestationInstanceRecipient.builder();

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
    Builder builderResult = ImmutableAttestationInstanceRecipient.builder();

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
    Builder builderResult = ImmutableAttestationInstanceRecipient.builder();
    Optional<Long> id = Optional.of(42L);

    // Act
    Builder actualIdResult = builderResult.id(id);

    // Assert
    assertSame(builderResult, actualIdResult);
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
    Builder builderResult = ImmutableAttestationInstanceRecipient.builder();

    // Act
    Builder actualUserIdResult = builderResult.userId("42");

    // Assert
    assertSame(builderResult, actualUserIdResult);
  }

  /**
   * Test {@link ImmutableAttestationInstanceRecipient#copyOf(AttestationInstanceRecipient)}.
   *
   * <ul>
   *   <li>Then attestationInstance parentEntity return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableAttestationInstanceRecipient#copyOf(AttestationInstanceRecipient)}
   */
  @Test
  @DisplayName(
      "Test copyOf(AttestationInstanceRecipient); then attestationInstance parentEntity return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationInstanceRecipient ImmutableAttestationInstanceRecipient.copyOf(AttestationInstanceRecipient)"
  })
  void testCopyOf_thenAttestationInstanceParentEntityReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableAttestationInstanceRecipient.builder();

    ImmutableAttestationInstance.Builder idResult =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);
    ImmutableAttestationInstanceRecipient instance =
        builderResult
            .attestationInstance(
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
                    .build())
            .id(1L)
            .userId("42")
            .build();

    // Act
    ImmutableAttestationInstanceRecipient actualCopyOfResult =
        ImmutableAttestationInstanceRecipient.copyOf(instance);

    // Assert
    AttestationInstance attestationInstanceResult = actualCopyOfResult.attestationInstance();
    EntityReference parentEntityResult = attestationInstanceResult.parentEntity();
    assertTrue(parentEntityResult instanceof ImmutableEntityReference);
    assertTrue(attestationInstanceResult instanceof ImmutableAttestationInstance);
    assertEquals("42", actualCopyOfResult.userId());
    assertEquals("The characteristics of someone or something", parentEntityResult.description());
    assertEquals(1L, attestationInstanceResult.attestationRunId().longValue());
    assertEquals(1L, attestationInstanceResult.attestedEntityId().longValue());
    assertEquals(1L, parentEntityResult.id());
    assertEquals(EntityKind.ALL, parentEntityResult.kind());
    assertEquals(EntityKind.ALL, attestationInstanceResult.attestedEntityKind());
    assertEquals(EntityLifecycleStatus.ACTIVE, parentEntityResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableAttestationInstanceRecipient#equals(Object)}, and {@link
   * ImmutableAttestationInstanceRecipient#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAttestationInstanceRecipient#equals(Object)}
   *   <li>{@link ImmutableAttestationInstanceRecipient#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationInstanceRecipient.equals(Object)",
    "int ImmutableAttestationInstanceRecipient.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableAttestationInstanceRecipient.builder();

    ImmutableAttestationInstance.Builder idResult =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);
    ImmutableAttestationInstanceRecipient immutableAttestationInstanceRecipient =
        builderResult
            .attestationInstance(
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
                    .build())
            .id(1L)
            .userId("42")
            .build();

    Builder builderResult2 = ImmutableAttestationInstanceRecipient.builder();

    ImmutableAttestationInstance.Builder idResult2 =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);
    ImmutableAttestationInstanceRecipient immutableAttestationInstanceRecipient2 =
        builderResult2
            .attestationInstance(
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
                    .build())
            .id(1L)
            .userId("42")
            .build();

    // Act and Assert
    assertEquals(immutableAttestationInstanceRecipient, immutableAttestationInstanceRecipient2);
    assertEquals(
        immutableAttestationInstanceRecipient.hashCode(),
        immutableAttestationInstanceRecipient2.hashCode());
  }

  /**
   * Test {@link ImmutableAttestationInstanceRecipient#equals(Object)}, and {@link
   * ImmutableAttestationInstanceRecipient#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAttestationInstanceRecipient#equals(Object)}
   *   <li>{@link ImmutableAttestationInstanceRecipient#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationInstanceRecipient.equals(Object)",
    "int ImmutableAttestationInstanceRecipient.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableAttestationInstanceRecipient.builder();

    ImmutableAttestationInstance.Builder idResult =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);
    ImmutableAttestationInstanceRecipient immutableAttestationInstanceRecipient =
        builderResult
            .attestationInstance(
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
                    .build())
            .id(1L)
            .userId("42")
            .build();

    // Act and Assert
    assertEquals(immutableAttestationInstanceRecipient, immutableAttestationInstanceRecipient);
    int expectedHashCodeResult = immutableAttestationInstanceRecipient.hashCode();
    assertEquals(expectedHashCodeResult, immutableAttestationInstanceRecipient.hashCode());
  }

  /**
   * Test {@link ImmutableAttestationInstanceRecipient#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationInstanceRecipient#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationInstanceRecipient.equals(Object)",
    "int ImmutableAttestationInstanceRecipient.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableAttestationInstanceRecipient.builder();

    ImmutableAttestationInstance.Builder idResult =
        ImmutableAttestationInstance.builder()
            .attestationRunId(2L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);
    ImmutableAttestationInstanceRecipient immutableAttestationInstanceRecipient =
        builderResult
            .attestationInstance(
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
                    .build())
            .id(1L)
            .userId("42")
            .build();

    Builder builderResult2 = ImmutableAttestationInstanceRecipient.builder();

    ImmutableAttestationInstance.Builder idResult2 =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);

    // Act and Assert
    assertNotEquals(
        immutableAttestationInstanceRecipient,
        builderResult2
            .attestationInstance(
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
                    .build())
            .id(1L)
            .userId("42")
            .build());
  }

  /**
   * Test {@link ImmutableAttestationInstanceRecipient#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationInstanceRecipient#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationInstanceRecipient.equals(Object)",
    "int ImmutableAttestationInstanceRecipient.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableAttestationInstanceRecipient.builder();

    ImmutableAttestationInstance.Builder idResult =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);
    ImmutableAttestationInstanceRecipient immutableAttestationInstanceRecipient =
        builderResult
            .attestationInstance(
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
                    .build())
            .id(2L)
            .userId("42")
            .build();

    Builder builderResult2 = ImmutableAttestationInstanceRecipient.builder();

    ImmutableAttestationInstance.Builder idResult2 =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);

    // Act and Assert
    assertNotEquals(
        immutableAttestationInstanceRecipient,
        builderResult2
            .attestationInstance(
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
                    .build())
            .id(1L)
            .userId("42")
            .build());
  }

  /**
   * Test {@link ImmutableAttestationInstanceRecipient#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationInstanceRecipient#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationInstanceRecipient.equals(Object)",
    "int ImmutableAttestationInstanceRecipient.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableAttestationInstanceRecipient.builder();

    ImmutableAttestationInstance.Builder idResult =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);
    ImmutableAttestationInstanceRecipient immutableAttestationInstanceRecipient =
        builderResult
            .attestationInstance(
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
                    .build())
            .id(1L)
            .userId("User Id")
            .build();

    Builder builderResult2 = ImmutableAttestationInstanceRecipient.builder();

    ImmutableAttestationInstance.Builder idResult2 =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);

    // Act and Assert
    assertNotEquals(
        immutableAttestationInstanceRecipient,
        builderResult2
            .attestationInstance(
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
                    .build())
            .id(1L)
            .userId("42")
            .build());
  }

  /**
   * Test {@link ImmutableAttestationInstanceRecipient#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationInstanceRecipient#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationInstanceRecipient.equals(Object)",
    "int ImmutableAttestationInstanceRecipient.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableAttestationInstanceRecipient.builder();

    ImmutableAttestationInstance.Builder idResult =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);

    // Act and Assert
    assertNotEquals(
        builderResult
            .attestationInstance(
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
                    .build())
            .id(1L)
            .userId("42")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableAttestationInstanceRecipient#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationInstanceRecipient#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationInstanceRecipient.equals(Object)",
    "int ImmutableAttestationInstanceRecipient.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableAttestationInstanceRecipient.builder();

    ImmutableAttestationInstance.Builder idResult =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);

    // Act and Assert
    assertNotEquals(
        builderResult
            .attestationInstance(
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
                    .build())
            .id(1L)
            .userId("42")
            .build(),
        "Different type to ImmutableAttestationInstanceRecipient");
  }

  /**
   * Test {@link ImmutableAttestationInstanceRecipient#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) Id is {@code null}.
   *   <li>Then return userId is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationInstanceRecipient#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) Id is 'null'; then return userId is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationInstanceRecipient ImmutableAttestationInstanceRecipient.fromJson(Json)"
  })
  void testFromJson_givenNull_whenJsonIdIsNull_thenReturnUserIdIsJson() {
    // Arrange
    Json json = new Json();
    json.setId(null);
    ImmutableAttestationInstance.Json attestationInstance = new ImmutableAttestationInstance.Json();
    json.setAttestationInstance(attestationInstance);
    json.setUserId("Json");

    // Act
    ImmutableAttestationInstanceRecipient actualFromJsonResult =
        ImmutableAttestationInstanceRecipient.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.userId());
    assertSame(attestationInstance, actualFromJsonResult.attestationInstance());
  }

  /**
   * Test {@link ImmutableAttestationInstanceRecipient#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given of forty-two.
   *   <li>When {@link Json} (default constructor) Id is of forty-two.
   *   <li>Then return userId is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationInstanceRecipient#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given of forty-two; when Json (default constructor) Id is of forty-two; then return userId is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationInstanceRecipient ImmutableAttestationInstanceRecipient.fromJson(Json)"
  })
  void testFromJson_givenOfFortyTwo_whenJsonIdIsOfFortyTwo_thenReturnUserIdIsJson() {
    // Arrange
    Json json = new Json();
    Optional<Long> id = Optional.of(42L);
    json.setId(id);
    ImmutableAttestationInstance.Json attestationInstance = new ImmutableAttestationInstance.Json();
    json.setAttestationInstance(attestationInstance);
    json.setUserId("Json");

    // Act
    ImmutableAttestationInstanceRecipient actualFromJsonResult =
        ImmutableAttestationInstanceRecipient.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.userId());
    assertSame(attestationInstance, actualFromJsonResult.attestationInstance());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAttestationInstanceRecipient#attestationInstance()}
   *   <li>{@link ImmutableAttestationInstanceRecipient#userId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AttestationInstance ImmutableAttestationInstanceRecipient.attestationInstance()",
    "String ImmutableAttestationInstanceRecipient.userId()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableAttestationInstanceRecipient.builder();

    ImmutableAttestationInstance.Builder idResult =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);
    ImmutableAttestationInstanceRecipient immutableAttestationInstanceRecipient =
        builderResult
            .attestationInstance(
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
                    .build())
            .id(1L)
            .userId("42")
            .build();

    // Act
    AttestationInstance actualAttestationInstanceResult =
        immutableAttestationInstanceRecipient.attestationInstance();

    // Assert
    assertTrue(actualAttestationInstanceResult instanceof ImmutableAttestationInstance);
    assertEquals("42", immutableAttestationInstanceRecipient.userId());
  }

  /**
   * Test {@link ImmutableAttestationInstanceRecipient#id()}.
   *
   * <p>Method under test: {@link ImmutableAttestationInstanceRecipient#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableAttestationInstanceRecipient.id()"})
  void testId() {
    // Arrange
    Builder builderResult = ImmutableAttestationInstanceRecipient.builder();

    ImmutableAttestationInstance.Builder idResult =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);

    // Act
    Optional<Long> actualIdResult =
        builderResult
            .attestationInstance(
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
                    .build())
            .id(1L)
            .userId("42")
            .build()
            .id();

    // Assert
    assertEquals(1L, actualIdResult.get().longValue());
    assertTrue(actualIdResult.isPresent());
  }

  /**
   * Test Json {@link Json#attestationInstance()}.
   *
   * <p>Method under test: {@link Json#attestationInstance()}
   */
  @Test
  @DisplayName("Test Json attestationInstance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AttestationInstance Json.attestationInstance()"})
  void testJsonAttestationInstance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().attestationInstance());
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
    assertNull(actualJson.attestationInstance);
    assertFalse(actualJson.id.isPresent());
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
   * Test {@link ImmutableAttestationInstanceRecipient#toString()}.
   *
   * <p>Method under test: {@link ImmutableAttestationInstanceRecipient#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableAttestationInstanceRecipient.toString()"})
  void testToString() {
    // Arrange
    Builder builderResult = ImmutableAttestationInstanceRecipient.builder();

    ImmutableAttestationInstance.Builder idResult =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);

    // Act and Assert
    assertEquals(
        "AttestationInstanceRecipient{id=1, attestationInstance=AttestationInstance{id=1, attestationRunId=1,"
            + " parentEntity=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}, attestedAt=1970-01-01T00:00,"
            + " attestedBy=Attested By, attestedEntityKind=ALL, attestedEntityId=1}, userId=42}",
        builderResult
            .attestationInstance(
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
                    .build())
            .id(1L)
            .userId("42")
            .build()
            .toString());
  }

  /**
   * Test {@link
   * ImmutableAttestationInstanceRecipient#withAttestationInstance(AttestationInstance)}.
   *
   * <p>Method under test: {@link
   * ImmutableAttestationInstanceRecipient#withAttestationInstance(AttestationInstance)}
   */
  @Test
  @DisplayName("Test withAttestationInstance(AttestationInstance)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationInstanceRecipient ImmutableAttestationInstanceRecipient.withAttestationInstance(AttestationInstance)"
  })
  void testWithAttestationInstance() {
    // Arrange
    Builder builderResult = ImmutableAttestationInstanceRecipient.builder();

    ImmutableAttestationInstance.Builder idResult =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);
    ImmutableAttestationInstanceRecipient immutableAttestationInstanceRecipient =
        builderResult
            .attestationInstance(
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
                    .build())
            .id(1L)
            .userId("42")
            .build();

    ImmutableAttestationInstance.Builder idResult2 =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);

    // Act
    ImmutableAttestationInstanceRecipient actualWithAttestationInstanceResult =
        immutableAttestationInstanceRecipient.withAttestationInstance(
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

    // Assert
    assertEquals(immutableAttestationInstanceRecipient, actualWithAttestationInstanceResult);
  }

  /**
   * Test {@link ImmutableAttestationInstanceRecipient#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableAttestationInstanceRecipient#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationInstanceRecipient ImmutableAttestationInstanceRecipient.withId(Optional)"
  })
  void testWithIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableAttestationInstanceRecipient.builder();

    ImmutableAttestationInstance.Builder idResult =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);
    ImmutableAttestationInstanceRecipient immutableAttestationInstanceRecipient =
        builderResult
            .attestationInstance(
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
                    .build())
            .id(1L)
            .userId("42")
            .build();
    Optional<Long> optional = Optional.of(42L);

    // Act
    ImmutableAttestationInstanceRecipient actualWithIdResult =
        immutableAttestationInstanceRecipient.withId(optional);

    // Assert
    AttestationInstance attestationInstanceResult = actualWithIdResult.attestationInstance();
    EntityReference parentEntityResult = attestationInstanceResult.parentEntity();
    assertTrue(parentEntityResult instanceof ImmutableEntityReference);
    assertTrue(attestationInstanceResult instanceof ImmutableAttestationInstance);
    assertEquals("42", actualWithIdResult.userId());
    assertEquals("The characteristics of someone or something", parentEntityResult.description());
    assertEquals(1L, attestationInstanceResult.attestationRunId().longValue());
    assertEquals(1L, attestationInstanceResult.attestedEntityId().longValue());
    assertEquals(1L, parentEntityResult.id());
    assertEquals(EntityKind.ALL, parentEntityResult.kind());
    assertEquals(EntityKind.ALL, attestationInstanceResult.attestedEntityKind());
    assertEquals(EntityLifecycleStatus.ACTIVE, parentEntityResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableAttestationInstanceRecipient#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableAttestationInstanceRecipient#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationInstanceRecipient ImmutableAttestationInstanceRecipient.withId(Optional)"
  })
  void testWithIdWithOptional2() {
    // Arrange
    Builder builderResult = ImmutableAttestationInstanceRecipient.builder();

    ImmutableAttestationInstance.Builder idResult =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);
    ImmutableAttestationInstanceRecipient immutableAttestationInstanceRecipient =
        builderResult
            .attestationInstance(
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
                    .build())
            .id(1L)
            .userId("42")
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableAttestationInstanceRecipient actualWithIdResult =
        immutableAttestationInstanceRecipient.withId(optional);

    // Assert
    assertSame(immutableAttestationInstanceRecipient, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableAttestationInstanceRecipient#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableAttestationInstanceRecipient#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationInstanceRecipient ImmutableAttestationInstanceRecipient.withId(long)"
  })
  void testWithIdWithValue() {
    // Arrange
    Builder builderResult = ImmutableAttestationInstanceRecipient.builder();

    ImmutableAttestationInstance.Builder idResult =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);

    // Act
    ImmutableAttestationInstanceRecipient actualWithIdResult =
        builderResult
            .attestationInstance(
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
                    .build())
            .id(1L)
            .userId("42")
            .build()
            .withId(42L);

    // Assert
    AttestationInstance attestationInstanceResult = actualWithIdResult.attestationInstance();
    EntityReference parentEntityResult = attestationInstanceResult.parentEntity();
    assertTrue(parentEntityResult instanceof ImmutableEntityReference);
    assertTrue(attestationInstanceResult instanceof ImmutableAttestationInstance);
    assertEquals("42", actualWithIdResult.userId());
    assertEquals("The characteristics of someone or something", parentEntityResult.description());
    assertEquals(1L, attestationInstanceResult.attestationRunId().longValue());
    assertEquals(1L, attestationInstanceResult.attestedEntityId().longValue());
    assertEquals(1L, parentEntityResult.id());
    assertEquals(EntityKind.ALL, parentEntityResult.kind());
    assertEquals(EntityKind.ALL, attestationInstanceResult.attestedEntityKind());
    assertEquals(EntityLifecycleStatus.ACTIVE, parentEntityResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableAttestationInstanceRecipient#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableAttestationInstanceRecipient#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationInstanceRecipient ImmutableAttestationInstanceRecipient.withId(long)"
  })
  void testWithIdWithValue2() {
    // Arrange
    Builder builderResult = ImmutableAttestationInstanceRecipient.builder();

    ImmutableAttestationInstance.Builder idResult =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);
    ImmutableAttestationInstanceRecipient immutableAttestationInstanceRecipient =
        builderResult
            .attestationInstance(
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
                    .build())
            .id(1L)
            .userId("42")
            .build();

    // Act
    ImmutableAttestationInstanceRecipient actualWithIdResult =
        immutableAttestationInstanceRecipient.withId(1L);

    // Assert
    assertSame(immutableAttestationInstanceRecipient, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableAttestationInstanceRecipient#withUserId(String)}.
   *
   * <p>Method under test: {@link ImmutableAttestationInstanceRecipient#withUserId(String)}
   */
  @Test
  @DisplayName("Test withUserId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationInstanceRecipient ImmutableAttestationInstanceRecipient.withUserId(String)"
  })
  void testWithUserId() {
    // Arrange
    Builder builderResult = ImmutableAttestationInstanceRecipient.builder();

    ImmutableAttestationInstance.Builder idResult =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);
    ImmutableAttestationInstanceRecipient immutableAttestationInstanceRecipient =
        builderResult
            .attestationInstance(
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
                    .build())
            .id(1L)
            .userId("42")
            .build();

    // Act
    ImmutableAttestationInstanceRecipient actualWithUserIdResult =
        immutableAttestationInstanceRecipient.withUserId("42");

    // Assert
    assertSame(immutableAttestationInstanceRecipient, actualWithUserIdResult);
  }

  /**
   * Test {@link ImmutableAttestationInstanceRecipient#withUserId(String)}.
   *
   * <ul>
   *   <li>Then attestationInstance parentEntity return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationInstanceRecipient#withUserId(String)}
   */
  @Test
  @DisplayName(
      "Test withUserId(String); then attestationInstance parentEntity return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationInstanceRecipient ImmutableAttestationInstanceRecipient.withUserId(String)"
  })
  void testWithUserId_thenAttestationInstanceParentEntityReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableAttestationInstanceRecipient.builder();

    ImmutableAttestationInstance.Builder idResult =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);

    // Act
    ImmutableAttestationInstanceRecipient actualWithUserIdResult =
        builderResult
            .attestationInstance(
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
                    .build())
            .id(1L)
            .userId("userId")
            .build()
            .withUserId("42");

    // Assert
    AttestationInstance attestationInstanceResult = actualWithUserIdResult.attestationInstance();
    EntityReference parentEntityResult = attestationInstanceResult.parentEntity();
    assertTrue(parentEntityResult instanceof ImmutableEntityReference);
    assertTrue(attestationInstanceResult instanceof ImmutableAttestationInstance);
    assertEquals("42", actualWithUserIdResult.userId());
    assertEquals("The characteristics of someone or something", parentEntityResult.description());
    assertEquals(1L, attestationInstanceResult.attestationRunId().longValue());
    assertEquals(1L, attestationInstanceResult.attestedEntityId().longValue());
    assertEquals(1L, parentEntityResult.id());
    assertEquals(EntityKind.ALL, parentEntityResult.kind());
    assertEquals(EntityKind.ALL, attestationInstanceResult.attestedEntityKind());
    assertEquals(EntityLifecycleStatus.ACTIVE, parentEntityResult.entityLifecycleStatus());
  }
}
