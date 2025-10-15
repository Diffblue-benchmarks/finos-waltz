package org.finos.waltz.model.entity_relationship;

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
import org.finos.waltz.model.entity_relationship.ImmutableEntityRelationshipKey.Builder;
import org.finos.waltz.model.entity_relationship.ImmutableEntityRelationshipKey.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableEntityRelationshipKeyDiffblueTest {
  /**
   * Test Builder {@link Builder#a(EntityReference)}.
   *
   * <ul>
   *   <li>When {@link EntityReference}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#a(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder a(EntityReference); when EntityReference; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.a(EntityReference)"})
  void testBuilderA_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableEntityRelationshipKey.builder();

    // Act
    Builder actualAResult = builderResult.a(mock(EntityReference.class));

    // Assert
    assertSame(builderResult, actualAResult);
  }

  /**
   * Test Builder {@link Builder#b(EntityReference)}.
   *
   * <ul>
   *   <li>When {@link EntityReference}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#b(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder b(EntityReference); when EntityReference; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.b(EntityReference)"})
  void testBuilderB_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableEntityRelationshipKey.builder();

    // Act
    Builder actualBResult = builderResult.b(mock(EntityReference.class));

    // Assert
    assertSame(builderResult, actualBResult);
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
  @MethodsUnderTest({"ImmutableEntityRelationshipKey Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableEntityRelationshipKey.builder();
    ImmutableEntityReference a =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Builder actualAResult = actualBuilderResult.a(a);
    ImmutableEntityReference b =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ImmutableEntityRelationshipKey actualImmutableEntityRelationshipKey =
        actualAResult.b(b).relationshipKind("Relationship Kind").build();

    // Assert
    assertEquals("Relationship Kind", actualImmutableEntityRelationshipKey.relationshipKind());
    assertSame(a, actualImmutableEntityRelationshipKey.a());
    assertSame(b, actualImmutableEntityRelationshipKey.b());
  }

  /**
   * Test Builder {@link Builder#from(EntityRelationshipKey)}.
   *
   * <p>Method under test: {@link Builder#from(EntityRelationshipKey)}
   */
  @Test
  @DisplayName("Test Builder from(EntityRelationshipKey)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityRelationshipKey)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableEntityRelationshipKey.builder();

    Builder builderResult2 = ImmutableEntityRelationshipKey.builder();

    Builder aResult =
        builderResult2.a(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableEntityRelationshipKey instance =
        aResult
            .b(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .relationshipKind("Relationship Kind")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableEntityRelationshipKey actualImmutableEntityRelationshipKey = builderResult.build();
    assertEquals(instance, actualImmutableEntityRelationshipKey);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#relationshipKind(String)}.
   *
   * <ul>
   *   <li>When {@code Relationship Kind}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#relationshipKind(String)}
   */
  @Test
  @DisplayName(
      "Test Builder relationshipKind(String); when 'Relationship Kind'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.relationshipKind(String)"})
  void testBuilderRelationshipKind_whenRelationshipKind_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableEntityRelationshipKey.builder();

    // Act
    Builder actualRelationshipKindResult = builderResult.relationshipKind("Relationship Kind");

    // Assert
    assertSame(builderResult, actualRelationshipKindResult);
  }

  /**
   * Test {@link ImmutableEntityRelationshipKey#copyOf(EntityRelationshipKey)}.
   *
   * <ul>
   *   <li>Then a return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityRelationshipKey#copyOf(EntityRelationshipKey)}
   */
  @Test
  @DisplayName("Test copyOf(EntityRelationshipKey); then a return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityRelationshipKey ImmutableEntityRelationshipKey.copyOf(EntityRelationshipKey)"
  })
  void testCopyOf_thenAReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableEntityRelationshipKey.builder();

    Builder aResult =
        builderResult.a(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableEntityRelationshipKey instance =
        aResult
            .b(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .relationshipKind("Relationship Kind")
            .build();

    // Act
    ImmutableEntityRelationshipKey actualCopyOfResult =
        ImmutableEntityRelationshipKey.copyOf(instance);

    // Assert
    EntityReference aResult2 = actualCopyOfResult.a();
    assertTrue(aResult2 instanceof ImmutableEntityReference);
    EntityReference bResult = actualCopyOfResult.b();
    assertTrue(bResult instanceof ImmutableEntityReference);
    assertEquals("Relationship Kind", actualCopyOfResult.relationshipKind());
    assertEquals("The characteristics of someone or something", aResult2.description());
    assertEquals(1L, aResult2.id());
    assertEquals(EntityKind.ALL, aResult2.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, aResult2.entityLifecycleStatus());
    assertEquals(aResult2, bResult);
  }

  /**
   * Test {@link ImmutableEntityRelationshipKey#equals(Object)}, and {@link
   * ImmutableEntityRelationshipKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableEntityRelationshipKey#equals(Object)}
   *   <li>{@link ImmutableEntityRelationshipKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityRelationshipKey.equals(Object)",
    "int ImmutableEntityRelationshipKey.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableEntityRelationshipKey.builder();

    Builder aResult =
        builderResult.a(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableEntityRelationshipKey immutableEntityRelationshipKey =
        aResult
            .b(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .relationshipKind("Relationship Kind")
            .build();

    Builder builderResult2 = ImmutableEntityRelationshipKey.builder();

    Builder aResult2 =
        builderResult2.a(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableEntityRelationshipKey immutableEntityRelationshipKey2 =
        aResult2
            .b(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .relationshipKind("Relationship Kind")
            .build();

    // Act and Assert
    assertEquals(immutableEntityRelationshipKey, immutableEntityRelationshipKey2);
    assertEquals(
        immutableEntityRelationshipKey.hashCode(), immutableEntityRelationshipKey2.hashCode());
  }

  /**
   * Test {@link ImmutableEntityRelationshipKey#equals(Object)}, and {@link
   * ImmutableEntityRelationshipKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableEntityRelationshipKey#equals(Object)}
   *   <li>{@link ImmutableEntityRelationshipKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityRelationshipKey.equals(Object)",
    "int ImmutableEntityRelationshipKey.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableEntityRelationshipKey.builder();

    Builder aResult =
        builderResult.a(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableEntityRelationshipKey immutableEntityRelationshipKey =
        aResult
            .b(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .relationshipKind("Relationship Kind")
            .build();

    // Act and Assert
    assertEquals(immutableEntityRelationshipKey, immutableEntityRelationshipKey);
    int expectedHashCodeResult = immutableEntityRelationshipKey.hashCode();
    assertEquals(expectedHashCodeResult, immutableEntityRelationshipKey.hashCode());
  }

  /**
   * Test {@link ImmutableEntityRelationshipKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityRelationshipKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityRelationshipKey.equals(Object)",
    "int ImmutableEntityRelationshipKey.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableEntityRelationshipKey.builder();

    Builder aResult =
        builderResult.a(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableEntityRelationshipKey immutableEntityRelationshipKey =
        aResult
            .b(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .relationshipKind("Relationship Kind")
            .build();

    Builder builderResult2 = ImmutableEntityRelationshipKey.builder();

    Builder aResult2 =
        builderResult2.a(
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
        immutableEntityRelationshipKey,
        aResult2
            .b(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .relationshipKind("Relationship Kind")
            .build());
  }

  /**
   * Test {@link ImmutableEntityRelationshipKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityRelationshipKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityRelationshipKey.equals(Object)",
    "int ImmutableEntityRelationshipKey.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableEntityRelationshipKey.builder();

    Builder aResult =
        builderResult.a(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableEntityRelationshipKey immutableEntityRelationshipKey =
        aResult
            .b(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .relationshipKind("Relationship Kind")
            .build();

    Builder builderResult2 = ImmutableEntityRelationshipKey.builder();

    Builder aResult2 =
        builderResult2.a(
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
        immutableEntityRelationshipKey,
        aResult2
            .b(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .relationshipKind("Relationship Kind")
            .build());
  }

  /**
   * Test {@link ImmutableEntityRelationshipKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityRelationshipKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityRelationshipKey.equals(Object)",
    "int ImmutableEntityRelationshipKey.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableEntityRelationshipKey.builder();

    Builder aResult =
        builderResult.a(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableEntityRelationshipKey immutableEntityRelationshipKey =
        aResult
            .b(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .relationshipKind("a")
            .build();

    Builder builderResult2 = ImmutableEntityRelationshipKey.builder();

    Builder aResult2 =
        builderResult2.a(
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
        immutableEntityRelationshipKey,
        aResult2
            .b(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .relationshipKind("Relationship Kind")
            .build());
  }

  /**
   * Test {@link ImmutableEntityRelationshipKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityRelationshipKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityRelationshipKey.equals(Object)",
    "int ImmutableEntityRelationshipKey.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableEntityRelationshipKey.builder();

    Builder aResult =
        builderResult.a(
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
        aResult
            .b(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .relationshipKind("Relationship Kind")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableEntityRelationshipKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityRelationshipKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityRelationshipKey.equals(Object)",
    "int ImmutableEntityRelationshipKey.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableEntityRelationshipKey.builder();

    Builder aResult =
        builderResult.a(
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
        aResult
            .b(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .relationshipKind("Relationship Kind")
            .build(),
        "Different type to ImmutableEntityRelationshipKey");
  }

  /**
   * Test {@link ImmutableEntityRelationshipKey#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code Json}.
   *   <li>Then return relationshipKind is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityRelationshipKey#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given 'Json'; then return relationshipKind is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityRelationshipKey ImmutableEntityRelationshipKey.fromJson(Json)"
  })
  void testFromJson_givenJson_thenReturnRelationshipKindIsJson() {
    // Arrange
    Json json = new Json();
    json.setA(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setB(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setRelationshipKind("Json");

    // Act
    ImmutableEntityRelationshipKey actualFromJsonResult =
        ImmutableEntityRelationshipKey.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.relationshipKind());
    EntityReference expectedAResult = json.a;
    assertSame(expectedAResult, actualFromJsonResult.a());
    EntityReference expectedBResult = json.b;
    assertSame(expectedBResult, actualFromJsonResult.b());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableEntityRelationshipKey#toString()}
   *   <li>{@link ImmutableEntityRelationshipKey#a()}
   *   <li>{@link ImmutableEntityRelationshipKey#b()}
   *   <li>{@link ImmutableEntityRelationshipKey#relationshipKind()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityReference ImmutableEntityRelationshipKey.a()",
    "EntityReference ImmutableEntityRelationshipKey.b()",
    "String ImmutableEntityRelationshipKey.relationshipKind()",
    "String ImmutableEntityRelationshipKey.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableEntityRelationshipKey.builder();

    Builder aResult =
        builderResult.a(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableEntityRelationshipKey immutableEntityRelationshipKey =
        aResult
            .b(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .relationshipKind("Relationship Kind")
            .build();

    // Act
    String actualToStringResult = immutableEntityRelationshipKey.toString();
    EntityReference actualAResult = immutableEntityRelationshipKey.a();
    EntityReference actualBResult = immutableEntityRelationshipKey.b();

    // Assert
    assertTrue(actualAResult instanceof ImmutableEntityReference);
    assertTrue(actualBResult instanceof ImmutableEntityReference);
    assertEquals(
        "EntityRelationshipKey{a=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}, b=EntityReference"
            + "{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}, relationshipKind=Relationship Kind}",
        actualToStringResult);
    assertEquals("Relationship Kind", immutableEntityRelationshipKey.relationshipKind());
    assertEquals(actualAResult, actualBResult);
  }

  /**
   * Test Json {@link Json#a()}.
   *
   * <p>Method under test: {@link Json#a()}
   */
  @Test
  @DisplayName("Test Json a()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.a()"})
  void testJsonA() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().a());
  }

  /**
   * Test Json {@link Json#b()}.
   *
   * <p>Method under test: {@link Json#b()}
   */
  @Test
  @DisplayName("Test Json b()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.b()"})
  void testJsonB() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().b());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setA(EntityReference)}
   *   <li>{@link Json#setB(EntityReference)}
   *   <li>{@link Json#setRelationshipKind(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setA(EntityReference)",
    "void Json.setB(EntityReference)",
    "void Json.setRelationshipKind(String)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    ImmutableEntityReference a =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    actualJson.setA(a);
    actualJson.setB(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    actualJson.setRelationshipKind("Relationship Kind");

    // Assert
    EntityReference entityReference = actualJson.a;
    assertTrue(entityReference instanceof ImmutableEntityReference);
    EntityReference entityReference2 = actualJson.b;
    assertTrue(entityReference2 instanceof ImmutableEntityReference);
    assertEquals("Relationship Kind", actualJson.relationshipKind);
    assertEquals("The characteristics of someone or something", entityReference.description());
    assertEquals(1L, entityReference.id());
    assertEquals(EntityKind.ALL, entityReference.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReference.entityLifecycleStatus());
    assertEquals(a, entityReference2);
  }

  /**
   * Test Json {@link Json#relationshipKind()}.
   *
   * <p>Method under test: {@link Json#relationshipKind()}
   */
  @Test
  @DisplayName("Test Json relationshipKind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.relationshipKind()"})
  void testJsonRelationshipKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().relationshipKind());
  }

  /**
   * Test {@link ImmutableEntityRelationshipKey#withA(EntityReference)}.
   *
   * <p>Method under test: {@link ImmutableEntityRelationshipKey#withA(EntityReference)}
   */
  @Test
  @DisplayName("Test withA(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityRelationshipKey ImmutableEntityRelationshipKey.withA(EntityReference)"
  })
  void testWithA() {
    // Arrange
    Builder builderResult = ImmutableEntityRelationshipKey.builder();

    Builder aResult =
        builderResult.a(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableEntityRelationshipKey immutableEntityRelationshipKey =
        aResult
            .b(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .relationshipKind("Relationship Kind")
            .build();

    // Act
    ImmutableEntityRelationshipKey actualWithAResult =
        immutableEntityRelationshipKey.withA(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableEntityRelationshipKey, actualWithAResult);
  }

  /**
   * Test {@link ImmutableEntityRelationshipKey#withB(EntityReference)}.
   *
   * <p>Method under test: {@link ImmutableEntityRelationshipKey#withB(EntityReference)}
   */
  @Test
  @DisplayName("Test withB(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityRelationshipKey ImmutableEntityRelationshipKey.withB(EntityReference)"
  })
  void testWithB() {
    // Arrange
    Builder builderResult = ImmutableEntityRelationshipKey.builder();

    Builder aResult =
        builderResult.a(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableEntityRelationshipKey immutableEntityRelationshipKey =
        aResult
            .b(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .relationshipKind("Relationship Kind")
            .build();

    // Act
    ImmutableEntityRelationshipKey actualWithBResult =
        immutableEntityRelationshipKey.withB(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableEntityRelationshipKey, actualWithBResult);
  }

  /**
   * Test {@link ImmutableEntityRelationshipKey#withRelationshipKind(String)}.
   *
   * <p>Method under test: {@link ImmutableEntityRelationshipKey#withRelationshipKind(String)}
   */
  @Test
  @DisplayName("Test withRelationshipKind(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityRelationshipKey ImmutableEntityRelationshipKey.withRelationshipKind(String)"
  })
  void testWithRelationshipKind() {
    // Arrange
    Builder builderResult = ImmutableEntityRelationshipKey.builder();

    Builder aResult =
        builderResult.a(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableEntityRelationshipKey immutableEntityRelationshipKey =
        aResult
            .b(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .relationshipKind("42")
            .build();

    // Act
    ImmutableEntityRelationshipKey actualWithRelationshipKindResult =
        immutableEntityRelationshipKey.withRelationshipKind("42");

    // Assert
    assertSame(immutableEntityRelationshipKey, actualWithRelationshipKindResult);
  }

  /**
   * Test {@link ImmutableEntityRelationshipKey#withRelationshipKind(String)}.
   *
   * <ul>
   *   <li>Then a return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityRelationshipKey#withRelationshipKind(String)}
   */
  @Test
  @DisplayName("Test withRelationshipKind(String); then a return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityRelationshipKey ImmutableEntityRelationshipKey.withRelationshipKind(String)"
  })
  void testWithRelationshipKind_thenAReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableEntityRelationshipKey.builder();

    Builder aResult =
        builderResult.a(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    ImmutableEntityRelationshipKey actualWithRelationshipKindResult =
        aResult
            .b(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .relationshipKind("Relationship Kind")
            .build()
            .withRelationshipKind("42");

    // Assert
    EntityReference aResult2 = actualWithRelationshipKindResult.a();
    assertTrue(aResult2 instanceof ImmutableEntityReference);
    EntityReference bResult = actualWithRelationshipKindResult.b();
    assertTrue(bResult instanceof ImmutableEntityReference);
    assertEquals("42", actualWithRelationshipKindResult.relationshipKind());
    assertEquals("The characteristics of someone or something", aResult2.description());
    assertEquals(1L, aResult2.id());
    assertEquals(EntityKind.ALL, aResult2.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, aResult2.entityLifecycleStatus());
    assertEquals(aResult2, bResult);
  }
}
