package org.finos.waltz.model.process_diagram;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.process_diagram.ImmutableProcessDiagramEntity.Builder;
import org.finos.waltz.model.process_diagram.ImmutableProcessDiagramEntity.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableProcessDiagramEntityDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableProcessDiagramEntity Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualDiagramIdResult = ImmutableProcessDiagramEntity.builder().diagramId(1L);
    ImmutableEntityReference entityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ImmutableProcessDiagramEntity actualImmutableProcessDiagramEntity =
        actualDiagramIdResult.entityReference(entityReference).build();

    // Assert
    assertEquals(1L, actualImmutableProcessDiagramEntity.diagramId().longValue());
    assertFalse(actualImmutableProcessDiagramEntity.isNotable());
    assertSame(entityReference, actualImmutableProcessDiagramEntity.entityReference());
  }

  /**
   * Test Builder {@link Builder#diagramId(Long)}.
   *
   * <p>Method under test: {@link Builder#diagramId(Long)}
   */
  @Test
  @DisplayName("Test Builder diagramId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.diagramId(Long)"})
  void testBuilderDiagramId() {
    // Arrange
    Builder builderResult = ImmutableProcessDiagramEntity.builder();

    // Act
    Builder actualDiagramIdResult = builderResult.diagramId(1L);

    // Assert
    assertSame(builderResult, actualDiagramIdResult);
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
    Builder builderResult = ImmutableProcessDiagramEntity.builder();

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
   * Test Builder {@link Builder#from(ProcessDiagramEntity)}.
   *
   * <p>Method under test: {@link Builder#from(ProcessDiagramEntity)}
   */
  @Test
  @DisplayName("Test Builder from(ProcessDiagramEntity)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ProcessDiagramEntity)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableProcessDiagramEntity.builder();

    Builder diagramIdResult = ImmutableProcessDiagramEntity.builder().diagramId(1L);
    ImmutableProcessDiagramEntity instance =
        diagramIdResult
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
    ImmutableProcessDiagramEntity actualImmutableProcessDiagramEntity = builderResult.build();
    assertEquals(instance, actualImmutableProcessDiagramEntity);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#isNotable(boolean)}.
   *
   * <p>Method under test: {@link Builder#isNotable(boolean)}
   */
  @Test
  @DisplayName("Test Builder isNotable(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.isNotable(boolean)"})
  void testBuilderIsNotable() {
    // Arrange
    Builder builderResult = ImmutableProcessDiagramEntity.builder();

    // Act
    Builder actualIsNotableResult = builderResult.isNotable(true);

    // Assert
    assertSame(builderResult, actualIsNotableResult);
  }

  /**
   * Test {@link ImmutableProcessDiagramEntity#copyOf(ProcessDiagramEntity)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableProcessDiagramEntity#copyOf(ProcessDiagramEntity)}
   */
  @Test
  @DisplayName(
      "Test copyOf(ProcessDiagramEntity); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableProcessDiagramEntity ImmutableProcessDiagramEntity.copyOf(ProcessDiagramEntity)"
  })
  void testCopyOf_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder diagramIdResult = ImmutableProcessDiagramEntity.builder().diagramId(1L);
    ImmutableProcessDiagramEntity instance =
        diagramIdResult
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
    ImmutableProcessDiagramEntity actualCopyOfResult =
        ImmutableProcessDiagramEntity.copyOf(instance);

    // Assert
    EntityReference entityReferenceResult = actualCopyOfResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, actualCopyOfResult.diagramId().longValue());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertFalse(actualCopyOfResult.isNotable());
  }

  /**
   * Test {@link ImmutableProcessDiagramEntity#equals(Object)}, and {@link
   * ImmutableProcessDiagramEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableProcessDiagramEntity#equals(Object)}
   *   <li>{@link ImmutableProcessDiagramEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableProcessDiagramEntity.equals(Object)",
    "int ImmutableProcessDiagramEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder diagramIdResult = ImmutableProcessDiagramEntity.builder().diagramId(1L);
    ImmutableProcessDiagramEntity immutableProcessDiagramEntity =
        diagramIdResult
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

    Builder diagramIdResult2 = ImmutableProcessDiagramEntity.builder().diagramId(1L);
    ImmutableProcessDiagramEntity immutableProcessDiagramEntity2 =
        diagramIdResult2
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
    assertEquals(immutableProcessDiagramEntity, immutableProcessDiagramEntity2);
    assertEquals(
        immutableProcessDiagramEntity.hashCode(), immutableProcessDiagramEntity2.hashCode());
  }

  /**
   * Test {@link ImmutableProcessDiagramEntity#equals(Object)}, and {@link
   * ImmutableProcessDiagramEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableProcessDiagramEntity#equals(Object)}
   *   <li>{@link ImmutableProcessDiagramEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableProcessDiagramEntity.equals(Object)",
    "int ImmutableProcessDiagramEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder diagramIdResult = ImmutableProcessDiagramEntity.builder().diagramId(1L);
    ImmutableProcessDiagramEntity immutableProcessDiagramEntity =
        diagramIdResult
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
    assertEquals(immutableProcessDiagramEntity, immutableProcessDiagramEntity);
    int expectedHashCodeResult = immutableProcessDiagramEntity.hashCode();
    assertEquals(expectedHashCodeResult, immutableProcessDiagramEntity.hashCode());
  }

  /**
   * Test {@link ImmutableProcessDiagramEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableProcessDiagramEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableProcessDiagramEntity.equals(Object)",
    "int ImmutableProcessDiagramEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder diagramIdResult = ImmutableProcessDiagramEntity.builder().diagramId(2L);
    ImmutableProcessDiagramEntity immutableProcessDiagramEntity =
        diagramIdResult
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

    Builder diagramIdResult2 = ImmutableProcessDiagramEntity.builder().diagramId(1L);

    // Act and Assert
    assertNotEquals(
        immutableProcessDiagramEntity,
        diagramIdResult2
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
   * Test {@link ImmutableProcessDiagramEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableProcessDiagramEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableProcessDiagramEntity.equals(Object)",
    "int ImmutableProcessDiagramEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder diagramIdResult = ImmutableProcessDiagramEntity.builder().diagramId(1L);
    ImmutableProcessDiagramEntity immutableProcessDiagramEntity =
        diagramIdResult
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

    Builder diagramIdResult2 = ImmutableProcessDiagramEntity.builder().diagramId(1L);

    // Act and Assert
    assertNotEquals(
        immutableProcessDiagramEntity,
        diagramIdResult2
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
   * Test {@link ImmutableProcessDiagramEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableProcessDiagramEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableProcessDiagramEntity.equals(Object)",
    "int ImmutableProcessDiagramEntity.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder diagramIdResult = ImmutableProcessDiagramEntity.builder().diagramId(1L);

    // Act and Assert
    assertNotEquals(
        diagramIdResult
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
   * Test {@link ImmutableProcessDiagramEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableProcessDiagramEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableProcessDiagramEntity.equals(Object)",
    "int ImmutableProcessDiagramEntity.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder diagramIdResult = ImmutableProcessDiagramEntity.builder().diagramId(1L);

    // Act and Assert
    assertNotEquals(
        diagramIdResult
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
        "Different type to ImmutableProcessDiagramEntity");
  }

  /**
   * Test {@link ImmutableProcessDiagramEntity#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return diagramId longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableProcessDiagramEntity#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return diagramId longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableProcessDiagramEntity ImmutableProcessDiagramEntity.fromJson(Json)"})
  void testFromJson_thenReturnDiagramIdLongValueIsOne() {
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
    json.setDiagramId(1L);

    // Act
    ImmutableProcessDiagramEntity actualFromJsonResult =
        ImmutableProcessDiagramEntity.fromJson(json);

    // Assert
    assertEquals(1L, actualFromJsonResult.diagramId().longValue());
    assertFalse(actualFromJsonResult.isNotable());
    EntityReference expectedEntityReferenceResult = json.entityReference;
    assertSame(expectedEntityReferenceResult, actualFromJsonResult.entityReference());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableProcessDiagramEntity#toString()}
   *   <li>{@link ImmutableProcessDiagramEntity#diagramId()}
   *   <li>{@link ImmutableProcessDiagramEntity#entityReference()}
   *   <li>{@link ImmutableProcessDiagramEntity#isNotable()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long ImmutableProcessDiagramEntity.diagramId()",
    "EntityReference ImmutableProcessDiagramEntity.entityReference()",
    "boolean ImmutableProcessDiagramEntity.isNotable()",
    "String ImmutableProcessDiagramEntity.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder diagramIdResult = ImmutableProcessDiagramEntity.builder().diagramId(1L);
    ImmutableProcessDiagramEntity immutableProcessDiagramEntity =
        diagramIdResult
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
    String actualToStringResult = immutableProcessDiagramEntity.toString();
    Long actualDiagramIdResult = immutableProcessDiagramEntity.diagramId();
    EntityReference actualEntityReferenceResult = immutableProcessDiagramEntity.entityReference();
    boolean actualIsNotableResult = immutableProcessDiagramEntity.isNotable();

    // Assert
    assertTrue(actualEntityReferenceResult instanceof ImmutableEntityReference);
    assertEquals(
        "ProcessDiagramEntity{diagramId=1, entityReference=EntityReference{kind=ALL, id=1, entityLifecycleStatus"
            + "=ACTIVE}, isNotable=false}",
        actualToStringResult);
    assertEquals(1L, actualDiagramIdResult.longValue());
    assertFalse(actualIsNotableResult);
  }

  /**
   * Test Json {@link Json#diagramId()}.
   *
   * <p>Method under test: {@link Json#diagramId()}
   */
  @Test
  @DisplayName("Test Json diagramId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long Json.diagramId()"})
  void testJsonDiagramId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().diagramId());
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
   *   <li>{@link Json#setDiagramId(Long)}
   *   <li>{@link Json#setEntityReference(EntityReference)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setDiagramId(Long)",
    "void Json.setEntityReference(EntityReference)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setDiagramId(1L);
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
    assertEquals(1L, actualJson.diagramId.longValue());
  }

  /**
   * Test Json {@link Json#isNotable()}.
   *
   * <p>Method under test: {@link Json#isNotable()}
   */
  @Test
  @DisplayName("Test Json isNotable()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Json.isNotable()"})
  void testJsonIsNotable() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().isNotable());
  }

  /**
   * Test Json {@link Json#setIsNotable(boolean)}.
   *
   * <p>Method under test: {@link Json#setIsNotable(boolean)}
   */
  @Test
  @DisplayName("Test Json setIsNotable(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setIsNotable(boolean)"})
  void testJsonSetIsNotable() {
    // Arrange
    Json json = new Json();

    // Act
    json.setIsNotable(true);

    // Assert
    assertTrue(json.isNotable);
    assertTrue(json.isNotableIsSet);
  }

  /**
   * Test {@link ImmutableProcessDiagramEntity#withDiagramId(Long)}.
   *
   * <p>Method under test: {@link ImmutableProcessDiagramEntity#withDiagramId(Long)}
   */
  @Test
  @DisplayName("Test withDiagramId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableProcessDiagramEntity ImmutableProcessDiagramEntity.withDiagramId(Long)"
  })
  void testWithDiagramId() {
    // Arrange
    Builder diagramIdResult = ImmutableProcessDiagramEntity.builder().diagramId(1L);
    ImmutableProcessDiagramEntity immutableProcessDiagramEntity =
        diagramIdResult
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
    ImmutableProcessDiagramEntity actualWithDiagramIdResult =
        immutableProcessDiagramEntity.withDiagramId(1L);

    // Assert
    assertSame(immutableProcessDiagramEntity, actualWithDiagramIdResult);
  }

  /**
   * Test {@link ImmutableProcessDiagramEntity#withDiagramId(Long)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableProcessDiagramEntity#withDiagramId(Long)}
   */
  @Test
  @DisplayName(
      "Test withDiagramId(Long); when forty-two; then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableProcessDiagramEntity ImmutableProcessDiagramEntity.withDiagramId(Long)"
  })
  void testWithDiagramId_whenFortyTwo_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder diagramIdResult = ImmutableProcessDiagramEntity.builder().diagramId(1L);

    // Act
    ImmutableProcessDiagramEntity actualWithDiagramIdResult =
        diagramIdResult
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
            .withDiagramId(42L);

    // Assert
    EntityReference entityReferenceResult = actualWithDiagramIdResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(42L, actualWithDiagramIdResult.diagramId().longValue());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertFalse(actualWithDiagramIdResult.isNotable());
  }

  /**
   * Test {@link ImmutableProcessDiagramEntity#withEntityReference(EntityReference)}.
   *
   * <p>Method under test: {@link
   * ImmutableProcessDiagramEntity#withEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test withEntityReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableProcessDiagramEntity ImmutableProcessDiagramEntity.withEntityReference(EntityReference)"
  })
  void testWithEntityReference() {
    // Arrange
    Builder diagramIdResult = ImmutableProcessDiagramEntity.builder().diagramId(1L);
    ImmutableProcessDiagramEntity immutableProcessDiagramEntity =
        diagramIdResult
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
    ImmutableProcessDiagramEntity actualWithEntityReferenceResult =
        immutableProcessDiagramEntity.withEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableProcessDiagramEntity, actualWithEntityReferenceResult);
  }

  /**
   * Test {@link ImmutableProcessDiagramEntity#withIsNotable(boolean)}.
   *
   * <p>Method under test: {@link ImmutableProcessDiagramEntity#withIsNotable(boolean)}
   */
  @Test
  @DisplayName("Test withIsNotable(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableProcessDiagramEntity ImmutableProcessDiagramEntity.withIsNotable(boolean)"
  })
  void testWithIsNotable() {
    // Arrange
    Builder diagramIdResult = ImmutableProcessDiagramEntity.builder().diagramId(1L);
    ImmutableProcessDiagramEntity immutableProcessDiagramEntity =
        diagramIdResult
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
    ImmutableProcessDiagramEntity actualWithIsNotableResult =
        immutableProcessDiagramEntity.withIsNotable(false);

    // Assert
    assertSame(immutableProcessDiagramEntity, actualWithIsNotableResult);
  }

  /**
   * Test {@link ImmutableProcessDiagramEntity#withIsNotable(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableProcessDiagramEntity#withIsNotable(boolean)}
   */
  @Test
  @DisplayName(
      "Test withIsNotable(boolean); when 'true'; then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableProcessDiagramEntity ImmutableProcessDiagramEntity.withIsNotable(boolean)"
  })
  void testWithIsNotable_whenTrue_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder diagramIdResult = ImmutableProcessDiagramEntity.builder().diagramId(1L);

    // Act
    ImmutableProcessDiagramEntity actualWithIsNotableResult =
        diagramIdResult
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
            .withIsNotable(true);

    // Assert
    EntityReference entityReferenceResult = actualWithIsNotableResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, actualWithIsNotableResult.diagramId().longValue());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertTrue(actualWithIsNotableResult.isNotable());
  }
}
