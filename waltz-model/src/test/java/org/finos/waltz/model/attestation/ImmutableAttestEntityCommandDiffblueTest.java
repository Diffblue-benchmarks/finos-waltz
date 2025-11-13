package org.finos.waltz.model.attestation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.attestation.ImmutableAttestEntityCommand.Builder;
import org.finos.waltz.model.attestation.ImmutableAttestEntityCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAttestEntityCommandDiffblueTest {
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
    Builder builderResult = ImmutableAttestEntityCommand.builder();

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
   *   <li>{@link Builder#attestedEntityId(Long)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Builder Builder.attestedEntityId(Long)",
    "ImmutableAttestEntityCommand Builder.build()"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualAttestedEntityKindResult =
        ImmutableAttestEntityCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference entityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ImmutableAttestEntityCommand actualImmutableAttestEntityCommand =
        actualAttestedEntityKindResult.entityReference(entityReference).build();

    // Assert
    assertEquals(1L, actualImmutableAttestEntityCommand.attestedEntityId().longValue());
    assertEquals(EntityKind.ALL, actualImmutableAttestEntityCommand.attestedEntityKind());
    assertSame(entityReference, actualImmutableAttestEntityCommand.entityReference());
  }

  /**
   * Test Builder {@link Builder#entityReference(EntityReference)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#entityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder entityReference(EntityReference); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.entityReference(EntityReference)"})
  void testBuilderEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAttestEntityCommand.builder();

    // Act
    Builder actualEntityReferenceResult =
        builderResult.entityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertSame(builderResult, actualEntityReferenceResult);
  }

  /**
   * Test Builder {@link Builder#from(AttestEntityCommand)}.
   *
   * <p>Method under test: {@link Builder#from(AttestEntityCommand)}
   */
  @Test
  @DisplayName("Test Builder from(AttestEntityCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AttestEntityCommand)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableAttestEntityCommand.builder();

    Builder attestedEntityKindResult =
        ImmutableAttestEntityCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL);
    ImmutableAttestEntityCommand instance =
        attestedEntityKindResult
            .entityReference(
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
    ImmutableAttestEntityCommand actualImmutableAttestEntityCommand = builderResult.build();
    assertEquals(instance, actualImmutableAttestEntityCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AttestEntityCommand)}.
   *
   * <p>Method under test: {@link Builder#from(AttestEntityCommand)}
   */
  @Test
  @DisplayName("Test Builder from(AttestEntityCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AttestEntityCommand)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableAttestEntityCommand.builder();

    Builder attestedEntityKindResult =
        ImmutableAttestEntityCommand.builder()
            .attestedEntityId(null)
            .attestedEntityKind(EntityKind.ALL);
    ImmutableAttestEntityCommand instance =
        attestedEntityKindResult
            .entityReference(
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
    ImmutableAttestEntityCommand actualImmutableAttestEntityCommand = builderResult.build();
    assertEquals(instance, actualImmutableAttestEntityCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test {@link ImmutableAttestEntityCommand#copyOf(AttestEntityCommand)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestEntityCommand#copyOf(AttestEntityCommand)}
   */
  @Test
  @DisplayName(
      "Test copyOf(AttestEntityCommand); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestEntityCommand ImmutableAttestEntityCommand.copyOf(AttestEntityCommand)"
  })
  void testCopyOf_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder attestedEntityKindResult =
        ImmutableAttestEntityCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL);
    ImmutableAttestEntityCommand instance =
        attestedEntityKindResult
            .entityReference(
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
    ImmutableAttestEntityCommand actualCopyOfResult = ImmutableAttestEntityCommand.copyOf(instance);

    // Assert
    EntityReference entityReferenceResult = actualCopyOfResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, actualCopyOfResult.attestedEntityId().longValue());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityKind.ALL, actualCopyOfResult.attestedEntityKind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableAttestEntityCommand#equals(Object)}, and {@link
   * ImmutableAttestEntityCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAttestEntityCommand#equals(Object)}
   *   <li>{@link ImmutableAttestEntityCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestEntityCommand.equals(Object)",
    "int ImmutableAttestEntityCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder attestedEntityKindResult =
        ImmutableAttestEntityCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL);
    ImmutableAttestEntityCommand immutableAttestEntityCommand =
        attestedEntityKindResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder attestedEntityKindResult2 =
        ImmutableAttestEntityCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL);
    ImmutableAttestEntityCommand immutableAttestEntityCommand2 =
        attestedEntityKindResult2
            .entityReference(
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
    assertEquals(immutableAttestEntityCommand, immutableAttestEntityCommand2);
    assertEquals(immutableAttestEntityCommand.hashCode(), immutableAttestEntityCommand2.hashCode());
  }

  /**
   * Test {@link ImmutableAttestEntityCommand#equals(Object)}, and {@link
   * ImmutableAttestEntityCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAttestEntityCommand#equals(Object)}
   *   <li>{@link ImmutableAttestEntityCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestEntityCommand.equals(Object)",
    "int ImmutableAttestEntityCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder attestedEntityKindResult =
        ImmutableAttestEntityCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL);
    ImmutableAttestEntityCommand immutableAttestEntityCommand =
        attestedEntityKindResult
            .entityReference(
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
    assertEquals(immutableAttestEntityCommand, immutableAttestEntityCommand);
    int expectedHashCodeResult = immutableAttestEntityCommand.hashCode();
    assertEquals(expectedHashCodeResult, immutableAttestEntityCommand.hashCode());
  }

  /**
   * Test {@link ImmutableAttestEntityCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestEntityCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestEntityCommand.equals(Object)",
    "int ImmutableAttestEntityCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder attestedEntityKindResult =
        ImmutableAttestEntityCommand.builder()
            .attestedEntityId(2L)
            .attestedEntityKind(EntityKind.ALL);
    ImmutableAttestEntityCommand immutableAttestEntityCommand =
        attestedEntityKindResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder attestedEntityKindResult2 =
        ImmutableAttestEntityCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL);

    // Act and Assert
    assertNotEquals(
        immutableAttestEntityCommand,
        attestedEntityKindResult2
            .entityReference(
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
   * Test {@link ImmutableAttestEntityCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestEntityCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestEntityCommand.equals(Object)",
    "int ImmutableAttestEntityCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder attestedEntityKindResult =
        ImmutableAttestEntityCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ACTOR);
    ImmutableAttestEntityCommand immutableAttestEntityCommand =
        attestedEntityKindResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder attestedEntityKindResult2 =
        ImmutableAttestEntityCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL);

    // Act and Assert
    assertNotEquals(
        immutableAttestEntityCommand,
        attestedEntityKindResult2
            .entityReference(
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
   * Test {@link ImmutableAttestEntityCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestEntityCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestEntityCommand.equals(Object)",
    "int ImmutableAttestEntityCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder attestedEntityKindResult =
        ImmutableAttestEntityCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL);
    ImmutableAttestEntityCommand immutableAttestEntityCommand =
        attestedEntityKindResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder attestedEntityKindResult2 =
        ImmutableAttestEntityCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL);

    // Act and Assert
    assertNotEquals(
        immutableAttestEntityCommand,
        attestedEntityKindResult2
            .entityReference(
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
   * Test {@link ImmutableAttestEntityCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestEntityCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestEntityCommand.equals(Object)",
    "int ImmutableAttestEntityCommand.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder attestedEntityKindResult =
        ImmutableAttestEntityCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL);

    // Act and Assert
    assertNotEquals(
        attestedEntityKindResult
            .entityReference(
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
   * Test {@link ImmutableAttestEntityCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestEntityCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestEntityCommand.equals(Object)",
    "int ImmutableAttestEntityCommand.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder attestedEntityKindResult =
        ImmutableAttestEntityCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL);

    // Act and Assert
    assertNotEquals(
        attestedEntityKindResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build(),
        "Different type to ImmutableAttestEntityCommand");
  }

  /**
   * Test {@link ImmutableAttestEntityCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return attestedEntityId longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestEntityCommand#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return attestedEntityId longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAttestEntityCommand ImmutableAttestEntityCommand.fromJson(Json)"})
  void testFromJson_thenReturnAttestedEntityIdLongValueIsOne() {
    // Arrange
    Json json = new Json();
    json.setEntityReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setAttestedEntityKind(EntityKind.ALL);
    json.setAttestedEntityId(1L);

    // Act
    ImmutableAttestEntityCommand actualFromJsonResult = ImmutableAttestEntityCommand.fromJson(json);

    // Assert
    assertEquals(1L, actualFromJsonResult.attestedEntityId().longValue());
    assertEquals(EntityKind.ALL, actualFromJsonResult.attestedEntityKind());
    EntityReference expectedEntityReferenceResult = json.entityReference;
    assertSame(expectedEntityReferenceResult, actualFromJsonResult.entityReference());
  }

  /**
   * Test {@link ImmutableAttestEntityCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) AttestedEntityId is {@code null}.
   *   <li>Then return attestedEntityId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestEntityCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) AttestedEntityId is 'null'; then return attestedEntityId is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAttestEntityCommand ImmutableAttestEntityCommand.fromJson(Json)"})
  void testFromJson_whenJsonAttestedEntityIdIsNull_thenReturnAttestedEntityIdIsNull() {
    // Arrange
    Json json = new Json();
    json.setEntityReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setAttestedEntityKind(EntityKind.ALL);
    json.setAttestedEntityId(null);

    // Act
    ImmutableAttestEntityCommand actualFromJsonResult = ImmutableAttestEntityCommand.fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.attestedEntityId());
    assertEquals(EntityKind.ALL, actualFromJsonResult.attestedEntityKind());
    EntityReference expectedEntityReferenceResult = json.entityReference;
    assertSame(expectedEntityReferenceResult, actualFromJsonResult.entityReference());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAttestEntityCommand#toString()}
   *   <li>{@link ImmutableAttestEntityCommand#attestedEntityId()}
   *   <li>{@link ImmutableAttestEntityCommand#attestedEntityKind()}
   *   <li>{@link ImmutableAttestEntityCommand#entityReference()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long ImmutableAttestEntityCommand.attestedEntityId()",
    "EntityKind ImmutableAttestEntityCommand.attestedEntityKind()",
    "EntityReference ImmutableAttestEntityCommand.entityReference()",
    "String ImmutableAttestEntityCommand.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder attestedEntityKindResult =
        ImmutableAttestEntityCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL);
    ImmutableAttestEntityCommand immutableAttestEntityCommand =
        attestedEntityKindResult
            .entityReference(
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
    String actualToStringResult = immutableAttestEntityCommand.toString();
    Long actualAttestedEntityIdResult = immutableAttestEntityCommand.attestedEntityId();
    EntityKind actualAttestedEntityKindResult = immutableAttestEntityCommand.attestedEntityKind();

    // Assert
    assertTrue(immutableAttestEntityCommand.entityReference() instanceof ImmutableEntityReference);
    assertEquals(
        "AttestEntityCommand{entityReference=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE},"
            + " attestedEntityKind=ALL, attestedEntityId=1}",
        actualToStringResult);
    assertEquals(1L, actualAttestedEntityIdResult.longValue());
    assertEquals(EntityKind.ALL, actualAttestedEntityKindResult);
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
   * Test Json {@link Json#entityReference()}.
   *
   * <p>Method under test: {@link Json#entityReference()}
   */
  @Test
  @DisplayName("Test Json entityReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.entityReference()"})
  void testJsonEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().entityReference());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setAttestedEntityId(Long)}
   *   <li>{@link Json#setAttestedEntityKind(EntityKind)}
   *   <li>{@link Json#setEntityReference(EntityReference)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setAttestedEntityId(Long)",
    "void Json.setAttestedEntityKind(EntityKind)",
    "void Json.setEntityReference(EntityReference)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setAttestedEntityId(1L);
    actualJson.setAttestedEntityKind(EntityKind.ALL);
    actualJson.setEntityReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    // Assert
    assertEquals(1L, actualJson.attestedEntityId.longValue());
  }

  /**
   * Test {@link ImmutableAttestEntityCommand#withAttestedEntityId(Long)}.
   *
   * <p>Method under test: {@link ImmutableAttestEntityCommand#withAttestedEntityId(Long)}
   */
  @Test
  @DisplayName("Test withAttestedEntityId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestEntityCommand ImmutableAttestEntityCommand.withAttestedEntityId(Long)"
  })
  void testWithAttestedEntityId() {
    // Arrange
    Builder attestedEntityKindResult =
        ImmutableAttestEntityCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL);
    ImmutableAttestEntityCommand immutableAttestEntityCommand =
        attestedEntityKindResult
            .entityReference(
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
    ImmutableAttestEntityCommand actualWithAttestedEntityIdResult =
        immutableAttestEntityCommand.withAttestedEntityId(1L);

    // Assert
    assertSame(immutableAttestEntityCommand, actualWithAttestedEntityIdResult);
  }

  /**
   * Test {@link ImmutableAttestEntityCommand#withAttestedEntityId(Long)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestEntityCommand#withAttestedEntityId(Long)}
   */
  @Test
  @DisplayName(
      "Test withAttestedEntityId(Long); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestEntityCommand ImmutableAttestEntityCommand.withAttestedEntityId(Long)"
  })
  void testWithAttestedEntityId_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder attestedEntityKindResult =
        ImmutableAttestEntityCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL);

    // Act
    ImmutableAttestEntityCommand actualWithAttestedEntityIdResult =
        attestedEntityKindResult
            .entityReference(
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
    EntityReference entityReferenceResult = actualWithAttestedEntityIdResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(42L, actualWithAttestedEntityIdResult.attestedEntityId().longValue());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityKind.ALL, actualWithAttestedEntityIdResult.attestedEntityKind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableAttestEntityCommand#withAttestedEntityKind(EntityKind)}.
   *
   * <p>Method under test: {@link ImmutableAttestEntityCommand#withAttestedEntityKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withAttestedEntityKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestEntityCommand ImmutableAttestEntityCommand.withAttestedEntityKind(EntityKind)"
  })
  void testWithAttestedEntityKind() {
    // Arrange
    Builder attestedEntityKindResult =
        ImmutableAttestEntityCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL);
    ImmutableAttestEntityCommand immutableAttestEntityCommand =
        attestedEntityKindResult
            .entityReference(
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
    ImmutableAttestEntityCommand actualWithAttestedEntityKindResult =
        immutableAttestEntityCommand.withAttestedEntityKind(EntityKind.ALL);

    // Assert
    assertSame(immutableAttestEntityCommand, actualWithAttestedEntityKindResult);
  }

  /**
   * Test {@link ImmutableAttestEntityCommand#withAttestedEntityKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestEntityCommand#withAttestedEntityKind(EntityKind)}
   */
  @Test
  @DisplayName(
      "Test withAttestedEntityKind(EntityKind); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestEntityCommand ImmutableAttestEntityCommand.withAttestedEntityKind(EntityKind)"
  })
  void testWithAttestedEntityKind_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder attestedEntityKindResult =
        ImmutableAttestEntityCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ACTOR);

    // Act
    ImmutableAttestEntityCommand actualWithAttestedEntityKindResult =
        attestedEntityKindResult
            .entityReference(
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
    EntityReference entityReferenceResult = actualWithAttestedEntityKindResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, actualWithAttestedEntityKindResult.attestedEntityId().longValue());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityKind.ALL, actualWithAttestedEntityKindResult.attestedEntityKind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableAttestEntityCommand#withEntityReference(EntityReference)}.
   *
   * <p>Method under test: {@link ImmutableAttestEntityCommand#withEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test withEntityReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestEntityCommand ImmutableAttestEntityCommand.withEntityReference(EntityReference)"
  })
  void testWithEntityReference() {
    // Arrange
    Builder attestedEntityKindResult =
        ImmutableAttestEntityCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL);
    ImmutableAttestEntityCommand immutableAttestEntityCommand =
        attestedEntityKindResult
            .entityReference(
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
    ImmutableAttestEntityCommand actualWithEntityReferenceResult =
        immutableAttestEntityCommand.withEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableAttestEntityCommand, actualWithEntityReferenceResult);
  }
}
