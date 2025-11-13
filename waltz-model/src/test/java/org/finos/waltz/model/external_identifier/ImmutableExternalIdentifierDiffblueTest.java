package org.finos.waltz.model.external_identifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.WaltzEntity;
import org.finos.waltz.model.external_identifier.ImmutableExternalIdentifier.Builder;
import org.finos.waltz.model.external_identifier.ImmutableExternalIdentifier.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableExternalIdentifierDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableExternalIdentifier Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableExternalIdentifier.builder();
    ImmutableEntityReference entityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ImmutableExternalIdentifier actualImmutableExternalIdentifier =
        actualBuilderResult
            .entityReference(entityReference)
            .externalId("42")
            .system("System")
            .build();

    // Assert
    assertEquals("42", actualImmutableExternalIdentifier.externalId());
    assertEquals("System", actualImmutableExternalIdentifier.system());
    assertSame(entityReference, actualImmutableExternalIdentifier.entityReference());
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
    Builder builderResult = ImmutableExternalIdentifier.builder();

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
   * Test Builder {@link Builder#externalId(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#externalId(String)}
   */
  @Test
  @DisplayName("Test Builder externalId(String); when '42'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.externalId(String)"})
  void testBuilderExternalId_when42_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableExternalIdentifier.builder();

    // Act
    Builder actualExternalIdResult = builderResult.externalId("42");

    // Assert
    assertSame(builderResult, actualExternalIdResult);
  }

  /**
   * Test Builder {@link Builder#from(ExternalIdentifier)} with {@code ExternalIdentifier}.
   *
   * <p>Method under test: {@link Builder#from(ExternalIdentifier)}
   */
  @Test
  @DisplayName("Test Builder from(ExternalIdentifier) with 'ExternalIdentifier'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ExternalIdentifier)"})
  void testBuilderFromWithExternalIdentifier() {
    // Arrange
    Builder builderResult = ImmutableExternalIdentifier.builder();

    Builder builderResult2 = ImmutableExternalIdentifier.builder();
    ImmutableExternalIdentifier instance =
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .externalId("42")
            .system("System")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableExternalIdentifier actualImmutableExternalIdentifier = builderResult.build();
    assertEquals(instance, actualImmutableExternalIdentifier);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(WaltzEntity)} with {@code WaltzEntity}.
   *
   * <p>Method under test: {@link Builder#from(WaltzEntity)}
   */
  @Test
  @DisplayName("Test Builder from(WaltzEntity) with 'WaltzEntity'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(WaltzEntity)"})
  void testBuilderFromWithWaltzEntity() {
    // Arrange
    Builder builderResult = ImmutableExternalIdentifier.builder();

    Builder builderResult2 = ImmutableExternalIdentifier.builder();
    ImmutableExternalIdentifier instance =
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .externalId("42")
            .system("System")
            .build();

    // Act and Assert
    ImmutableExternalIdentifier actualImmutableExternalIdentifier =
        builderResult.from((WaltzEntity) instance).build();
    assertEquals(instance, actualImmutableExternalIdentifier);
    ImmutableExternalIdentifier actualImmutableExternalIdentifier2 = builderResult.build();
    assertEquals(instance, actualImmutableExternalIdentifier2);
  }

  /**
   * Test Builder {@link Builder#from(WaltzEntity)} with {@code WaltzEntity}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(WaltzEntity)}
   */
  @Test
  @DisplayName("Test Builder from(WaltzEntity) with 'WaltzEntity'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(WaltzEntity)"})
  void testBuilderFromWithWaltzEntity_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableExternalIdentifier.builder();

    WaltzEntity instance = mock(WaltzEntity.class);
    when(instance.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).entityReference();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(WaltzEntity)} with {@code WaltzEntity}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(WaltzEntity)}
   */
  @Test
  @DisplayName(
      "Test Builder from(WaltzEntity) with 'WaltzEntity'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(WaltzEntity)"})
  void testBuilderFromWithWaltzEntity_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableExternalIdentifier.builder();

    WaltzEntity instance = mock(WaltzEntity.class);
    when(instance.entityReference()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).entityReference();
  }

  /**
   * Test Builder {@link Builder#system(String)}.
   *
   * <ul>
   *   <li>When {@code System}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#system(String)}
   */
  @Test
  @DisplayName("Test Builder system(String); when 'System'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.system(String)"})
  void testBuilderSystem_whenSystem_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableExternalIdentifier.builder();

    // Act
    Builder actualSystemResult = builderResult.system("System");

    // Assert
    assertSame(builderResult, actualSystemResult);
  }

  /**
   * Test {@link ImmutableExternalIdentifier#copyOf(ExternalIdentifier)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableExternalIdentifier#copyOf(ExternalIdentifier)}
   */
  @Test
  @DisplayName(
      "Test copyOf(ExternalIdentifier); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableExternalIdentifier ImmutableExternalIdentifier.copyOf(ExternalIdentifier)"
  })
  void testCopyOf_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableExternalIdentifier.builder();
    ImmutableExternalIdentifier instance =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .externalId("42")
            .system("System")
            .build();

    // Act
    ImmutableExternalIdentifier actualCopyOfResult = ImmutableExternalIdentifier.copyOf(instance);

    // Assert
    EntityReference entityReferenceResult = actualCopyOfResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("42", actualCopyOfResult.externalId());
    assertEquals("System", actualCopyOfResult.system());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableExternalIdentifier#equals(Object)}, and {@link
   * ImmutableExternalIdentifier#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableExternalIdentifier#equals(Object)}
   *   <li>{@link ImmutableExternalIdentifier#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableExternalIdentifier.equals(Object)",
    "int ImmutableExternalIdentifier.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableExternalIdentifier.builder();
    ImmutableExternalIdentifier immutableExternalIdentifier =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .externalId("42")
            .system("System")
            .build();

    Builder builderResult2 = ImmutableExternalIdentifier.builder();
    ImmutableExternalIdentifier immutableExternalIdentifier2 =
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .externalId("42")
            .system("System")
            .build();

    // Act and Assert
    assertEquals(immutableExternalIdentifier, immutableExternalIdentifier2);
    assertEquals(immutableExternalIdentifier.hashCode(), immutableExternalIdentifier2.hashCode());
  }

  /**
   * Test {@link ImmutableExternalIdentifier#equals(Object)}, and {@link
   * ImmutableExternalIdentifier#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableExternalIdentifier#equals(Object)}
   *   <li>{@link ImmutableExternalIdentifier#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableExternalIdentifier.equals(Object)",
    "int ImmutableExternalIdentifier.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableExternalIdentifier.builder();
    ImmutableExternalIdentifier immutableExternalIdentifier =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .externalId("42")
            .system("System")
            .build();

    // Act and Assert
    assertEquals(immutableExternalIdentifier, immutableExternalIdentifier);
    int expectedHashCodeResult = immutableExternalIdentifier.hashCode();
    assertEquals(expectedHashCodeResult, immutableExternalIdentifier.hashCode());
  }

  /**
   * Test {@link ImmutableExternalIdentifier#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableExternalIdentifier#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableExternalIdentifier.equals(Object)",
    "int ImmutableExternalIdentifier.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableExternalIdentifier.builder();
    ImmutableExternalIdentifier immutableExternalIdentifier =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .externalId("42")
            .system("System")
            .build();

    Builder builderResult2 = ImmutableExternalIdentifier.builder();

    // Act and Assert
    assertNotEquals(
        immutableExternalIdentifier,
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .externalId("42")
            .system("System")
            .build());
  }

  /**
   * Test {@link ImmutableExternalIdentifier#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableExternalIdentifier#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableExternalIdentifier.equals(Object)",
    "int ImmutableExternalIdentifier.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableExternalIdentifier.builder();
    ImmutableExternalIdentifier immutableExternalIdentifier =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .externalId("System")
            .system("System")
            .build();

    Builder builderResult2 = ImmutableExternalIdentifier.builder();

    // Act and Assert
    assertNotEquals(
        immutableExternalIdentifier,
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .externalId("42")
            .system("System")
            .build());
  }

  /**
   * Test {@link ImmutableExternalIdentifier#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableExternalIdentifier#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableExternalIdentifier.equals(Object)",
    "int ImmutableExternalIdentifier.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableExternalIdentifier.builder();
    ImmutableExternalIdentifier immutableExternalIdentifier =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .externalId("42")
            .system("42")
            .build();

    Builder builderResult2 = ImmutableExternalIdentifier.builder();

    // Act and Assert
    assertNotEquals(
        immutableExternalIdentifier,
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .externalId("42")
            .system("System")
            .build());
  }

  /**
   * Test {@link ImmutableExternalIdentifier#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableExternalIdentifier#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableExternalIdentifier.equals(Object)",
    "int ImmutableExternalIdentifier.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableExternalIdentifier.builder();

    // Act and Assert
    assertNotEquals(
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .externalId("42")
            .system("System")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableExternalIdentifier#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableExternalIdentifier#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableExternalIdentifier.equals(Object)",
    "int ImmutableExternalIdentifier.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableExternalIdentifier.builder();

    // Act and Assert
    assertNotEquals(
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .externalId("42")
            .system("System")
            .build(),
        "Different type to ImmutableExternalIdentifier");
  }

  /**
   * Test {@link ImmutableExternalIdentifier#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return externalId is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableExternalIdentifier#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return externalId is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableExternalIdentifier ImmutableExternalIdentifier.fromJson(Json)"})
  void testFromJson_thenReturnExternalIdIsJson() {
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
    json.setSystem("Json");
    json.setExternalId("Json");

    // Act
    ImmutableExternalIdentifier actualFromJsonResult = ImmutableExternalIdentifier.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.externalId());
    assertEquals("Json", actualFromJsonResult.system());
    EntityReference expectedEntityReferenceResult = json.entityReference;
    assertSame(expectedEntityReferenceResult, actualFromJsonResult.entityReference());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableExternalIdentifier#toString()}
   *   <li>{@link ImmutableExternalIdentifier#entityReference()}
   *   <li>{@link ImmutableExternalIdentifier#externalId()}
   *   <li>{@link ImmutableExternalIdentifier#system()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityReference ImmutableExternalIdentifier.entityReference()",
    "String ImmutableExternalIdentifier.externalId()",
    "String ImmutableExternalIdentifier.system()",
    "String ImmutableExternalIdentifier.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableExternalIdentifier.builder();
    ImmutableExternalIdentifier immutableExternalIdentifier =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .externalId("42")
            .system("System")
            .build();

    // Act
    String actualToStringResult = immutableExternalIdentifier.toString();
    EntityReference actualEntityReferenceResult = immutableExternalIdentifier.entityReference();
    String actualExternalIdResult = immutableExternalIdentifier.externalId();

    // Assert
    assertTrue(actualEntityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("42", actualExternalIdResult);
    assertEquals(
        "ExternalIdentifier{entityReference=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE},"
            + " system=System, externalId=42}",
        actualToStringResult);
    assertEquals("System", immutableExternalIdentifier.system());
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
   * Test Json {@link Json#externalId()}.
   *
   * <p>Method under test: {@link Json#externalId()}
   */
  @Test
  @DisplayName("Test Json externalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.externalId()"})
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().externalId());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setEntityReference(EntityReference)}
   *   <li>{@link Json#setExternalId(String)}
   *   <li>{@link Json#setSystem(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setEntityReference(EntityReference)",
    "void Json.setExternalId(String)",
    "void Json.setSystem(String)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setEntityReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    actualJson.setExternalId("42");
    actualJson.setSystem("System");

    // Assert
    EntityReference entityReference = actualJson.entityReference;
    assertTrue(entityReference instanceof ImmutableEntityReference);
    assertEquals("42", actualJson.externalId);
    assertEquals("System", actualJson.system);
    assertEquals("The characteristics of someone or something", entityReference.description());
    assertEquals(1L, entityReference.id());
    assertEquals(EntityKind.ALL, entityReference.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReference.entityLifecycleStatus());
  }

  /**
   * Test Json {@link Json#system()}.
   *
   * <p>Method under test: {@link Json#system()}
   */
  @Test
  @DisplayName("Test Json system()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.system()"})
  void testJsonSystem() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().system());
  }

  /**
   * Test {@link ImmutableExternalIdentifier#withEntityReference(EntityReference)}.
   *
   * <p>Method under test: {@link ImmutableExternalIdentifier#withEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test withEntityReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableExternalIdentifier ImmutableExternalIdentifier.withEntityReference(EntityReference)"
  })
  void testWithEntityReference() {
    // Arrange
    Builder builderResult = ImmutableExternalIdentifier.builder();
    ImmutableExternalIdentifier immutableExternalIdentifier =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .externalId("42")
            .system("System")
            .build();

    // Act
    ImmutableExternalIdentifier actualWithEntityReferenceResult =
        immutableExternalIdentifier.withEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableExternalIdentifier, actualWithEntityReferenceResult);
  }

  /**
   * Test {@link ImmutableExternalIdentifier#withExternalId(String)}.
   *
   * <p>Method under test: {@link ImmutableExternalIdentifier#withExternalId(String)}
   */
  @Test
  @DisplayName("Test withExternalId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableExternalIdentifier ImmutableExternalIdentifier.withExternalId(String)"
  })
  void testWithExternalId() {
    // Arrange
    Builder builderResult = ImmutableExternalIdentifier.builder();
    ImmutableExternalIdentifier immutableExternalIdentifier =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .externalId("0123456789ABCDEF")
            .system("System")
            .build();

    // Act
    ImmutableExternalIdentifier actualWithExternalIdResult =
        immutableExternalIdentifier.withExternalId("0123456789ABCDEF");

    // Assert
    assertSame(immutableExternalIdentifier, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableExternalIdentifier#withExternalId(String)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableExternalIdentifier#withExternalId(String)}
   */
  @Test
  @DisplayName("Test withExternalId(String); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableExternalIdentifier ImmutableExternalIdentifier.withExternalId(String)"
  })
  void testWithExternalId_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableExternalIdentifier.builder();

    // Act
    ImmutableExternalIdentifier actualWithExternalIdResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .externalId("42")
            .system("System")
            .build()
            .withExternalId("0123456789ABCDEF");

    // Assert
    EntityReference entityReferenceResult = actualWithExternalIdResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("0123456789ABCDEF", actualWithExternalIdResult.externalId());
    assertEquals("System", actualWithExternalIdResult.system());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableExternalIdentifier#withSystem(String)}.
   *
   * <p>Method under test: {@link ImmutableExternalIdentifier#withSystem(String)}
   */
  @Test
  @DisplayName("Test withSystem(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableExternalIdentifier ImmutableExternalIdentifier.withSystem(String)"})
  void testWithSystem() {
    // Arrange
    Builder builderResult = ImmutableExternalIdentifier.builder();
    ImmutableExternalIdentifier immutableExternalIdentifier =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .externalId("42")
            .system("42")
            .build();

    // Act
    ImmutableExternalIdentifier actualWithSystemResult =
        immutableExternalIdentifier.withSystem("42");

    // Assert
    assertSame(immutableExternalIdentifier, actualWithSystemResult);
  }

  /**
   * Test {@link ImmutableExternalIdentifier#withSystem(String)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableExternalIdentifier#withSystem(String)}
   */
  @Test
  @DisplayName("Test withSystem(String); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableExternalIdentifier ImmutableExternalIdentifier.withSystem(String)"})
  void testWithSystem_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableExternalIdentifier.builder();

    // Act
    ImmutableExternalIdentifier actualWithSystemResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .externalId("42")
            .system("System")
            .build()
            .withSystem("42");

    // Assert
    EntityReference entityReferenceResult = actualWithSystemResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("42", actualWithSystemResult.externalId());
    assertEquals("42", actualWithSystemResult.system());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
  }
}
