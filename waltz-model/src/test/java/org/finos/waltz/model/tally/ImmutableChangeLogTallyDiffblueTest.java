package org.finos.waltz.model.tally;

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
import org.finos.waltz.model.tally.ImmutableChangeLogTally.Builder;
import org.finos.waltz.model.tally.ImmutableChangeLogTally.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableChangeLogTallyDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#childKind(EntityKind)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableChangeLogTally Builder.build()",
    "Builder Builder.childKind(EntityKind)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualCountResult =
        ImmutableChangeLogTally.builder().childKind(EntityKind.ALL).count(3L);
    ImmutableEntityReference ref =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ImmutableChangeLogTally actualImmutableChangeLogTally = actualCountResult.ref(ref).build();

    // Assert
    assertEquals(3L, actualImmutableChangeLogTally.count());
    assertEquals(EntityKind.ALL, actualImmutableChangeLogTally.childKind());
    assertSame(ref, actualImmutableChangeLogTally.ref());
  }

  /**
   * Test Builder {@link Builder#count(long)}.
   *
   * <p>Method under test: {@link Builder#count(long)}
   */
  @Test
  @DisplayName("Test Builder count(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.count(long)"})
  void testBuilderCount() {
    // Arrange
    Builder builderResult = ImmutableChangeLogTally.builder();

    // Act
    Builder actualCountResult = builderResult.count(3L);

    // Assert
    assertSame(builderResult, actualCountResult);
  }

  /**
   * Test Builder {@link Builder#from(ChangeLogTally)}.
   *
   * <p>Method under test: {@link Builder#from(ChangeLogTally)}
   */
  @Test
  @DisplayName("Test Builder from(ChangeLogTally)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ChangeLogTally)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableChangeLogTally.builder();

    Builder countResult = ImmutableChangeLogTally.builder().childKind(EntityKind.ALL).count(3L);
    ImmutableChangeLogTally instance =
        countResult
            .ref(
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
    ImmutableChangeLogTally actualImmutableChangeLogTally = builderResult.build();
    assertEquals(instance, actualImmutableChangeLogTally);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ChangeLogTally)}.
   *
   * <p>Method under test: {@link Builder#from(ChangeLogTally)}
   */
  @Test
  @DisplayName("Test Builder from(ChangeLogTally)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ChangeLogTally)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableChangeLogTally.builder();

    Builder countResult = ImmutableChangeLogTally.builder().childKind(null).count(3L);
    ImmutableChangeLogTally instance =
        countResult
            .ref(
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
    ImmutableChangeLogTally actualImmutableChangeLogTally = builderResult.build();
    assertEquals(instance, actualImmutableChangeLogTally);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#ref(EntityReference)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#ref(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder ref(EntityReference); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.ref(EntityReference)"})
  void testBuilderRef_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableChangeLogTally.builder();

    // Act
    Builder actualRefResult =
        builderResult.ref(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertSame(builderResult, actualRefResult);
  }

  /**
   * Test {@link ImmutableChangeLogTally#copyOf(ChangeLogTally)}.
   *
   * <ul>
   *   <li>Then ref return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeLogTally#copyOf(ChangeLogTally)}
   */
  @Test
  @DisplayName("Test copyOf(ChangeLogTally); then ref return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeLogTally ImmutableChangeLogTally.copyOf(ChangeLogTally)"})
  void testCopyOf_thenRefReturnImmutableEntityReference() {
    // Arrange
    Builder countResult = ImmutableChangeLogTally.builder().childKind(EntityKind.ALL).count(3L);
    ImmutableChangeLogTally instance =
        countResult
            .ref(
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
    ImmutableChangeLogTally actualCopyOfResult = ImmutableChangeLogTally.copyOf(instance);

    // Assert
    EntityReference refResult = actualCopyOfResult.ref();
    assertTrue(refResult instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", refResult.description());
    assertEquals(1L, refResult.id());
    assertEquals(3L, actualCopyOfResult.count());
    assertEquals(EntityKind.ALL, refResult.kind());
    assertEquals(EntityKind.ALL, actualCopyOfResult.childKind());
    assertEquals(EntityLifecycleStatus.ACTIVE, refResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableChangeLogTally#equals(Object)}, and {@link
   * ImmutableChangeLogTally#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableChangeLogTally#equals(Object)}
   *   <li>{@link ImmutableChangeLogTally#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeLogTally.equals(Object)",
    "int ImmutableChangeLogTally.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder countResult = ImmutableChangeLogTally.builder().childKind(EntityKind.ALL).count(3L);
    ImmutableChangeLogTally immutableChangeLogTally =
        countResult
            .ref(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder countResult2 = ImmutableChangeLogTally.builder().childKind(EntityKind.ALL).count(3L);
    ImmutableChangeLogTally immutableChangeLogTally2 =
        countResult2
            .ref(
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
    assertEquals(immutableChangeLogTally, immutableChangeLogTally2);
    assertEquals(immutableChangeLogTally.hashCode(), immutableChangeLogTally2.hashCode());
  }

  /**
   * Test {@link ImmutableChangeLogTally#equals(Object)}, and {@link
   * ImmutableChangeLogTally#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableChangeLogTally#equals(Object)}
   *   <li>{@link ImmutableChangeLogTally#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeLogTally.equals(Object)",
    "int ImmutableChangeLogTally.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder countResult = ImmutableChangeLogTally.builder().childKind(EntityKind.ALL).count(3L);
    ImmutableChangeLogTally immutableChangeLogTally =
        countResult
            .ref(
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
    assertEquals(immutableChangeLogTally, immutableChangeLogTally);
    int expectedHashCodeResult = immutableChangeLogTally.hashCode();
    assertEquals(expectedHashCodeResult, immutableChangeLogTally.hashCode());
  }

  /**
   * Test {@link ImmutableChangeLogTally#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeLogTally#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeLogTally.equals(Object)",
    "int ImmutableChangeLogTally.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder countResult = ImmutableChangeLogTally.builder().childKind(EntityKind.ACTOR).count(3L);
    ImmutableChangeLogTally immutableChangeLogTally =
        countResult
            .ref(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder countResult2 = ImmutableChangeLogTally.builder().childKind(EntityKind.ALL).count(3L);

    // Act and Assert
    assertNotEquals(
        immutableChangeLogTally,
        countResult2
            .ref(
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
   * Test {@link ImmutableChangeLogTally#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeLogTally#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeLogTally.equals(Object)",
    "int ImmutableChangeLogTally.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder countResult = ImmutableChangeLogTally.builder().childKind(EntityKind.ALL).count(1L);
    ImmutableChangeLogTally immutableChangeLogTally =
        countResult
            .ref(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder countResult2 = ImmutableChangeLogTally.builder().childKind(EntityKind.ALL).count(3L);

    // Act and Assert
    assertNotEquals(
        immutableChangeLogTally,
        countResult2
            .ref(
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
   * Test {@link ImmutableChangeLogTally#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeLogTally#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeLogTally.equals(Object)",
    "int ImmutableChangeLogTally.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder countResult = ImmutableChangeLogTally.builder().childKind(EntityKind.ALL).count(3L);
    ImmutableChangeLogTally immutableChangeLogTally =
        countResult
            .ref(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder countResult2 = ImmutableChangeLogTally.builder().childKind(EntityKind.ALL).count(3L);

    // Act and Assert
    assertNotEquals(
        immutableChangeLogTally,
        countResult2
            .ref(
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
   * Test {@link ImmutableChangeLogTally#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeLogTally#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeLogTally.equals(Object)",
    "int ImmutableChangeLogTally.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder countResult = ImmutableChangeLogTally.builder().childKind(EntityKind.ALL).count(3L);

    // Act and Assert
    assertNotEquals(
        countResult
            .ref(
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
   * Test {@link ImmutableChangeLogTally#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeLogTally#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeLogTally.equals(Object)",
    "int ImmutableChangeLogTally.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder countResult = ImmutableChangeLogTally.builder().childKind(EntityKind.ALL).count(3L);

    // Act and Assert
    assertNotEquals(
        countResult
            .ref(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build(),
        "Different type to ImmutableChangeLogTally");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableChangeLogTally#toString()}
   *   <li>{@link ImmutableChangeLogTally#childKind()}
   *   <li>{@link ImmutableChangeLogTally#count()}
   *   <li>{@link ImmutableChangeLogTally#ref()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityKind ImmutableChangeLogTally.childKind()",
    "long ImmutableChangeLogTally.count()",
    "EntityReference ImmutableChangeLogTally.ref()",
    "String ImmutableChangeLogTally.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder countResult = ImmutableChangeLogTally.builder().childKind(EntityKind.ALL).count(3L);
    ImmutableChangeLogTally immutableChangeLogTally =
        countResult
            .ref(
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
    String actualToStringResult = immutableChangeLogTally.toString();
    EntityKind actualChildKindResult = immutableChangeLogTally.childKind();
    long actualCountResult = immutableChangeLogTally.count();

    // Assert
    assertTrue(immutableChangeLogTally.ref() instanceof ImmutableEntityReference);
    assertEquals(
        "ChangeLogTally{ref=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}, childKind=ALL,"
            + " count=3}",
        actualToStringResult);
    assertEquals(3L, actualCountResult);
    assertEquals(EntityKind.ALL, actualChildKindResult);
  }

  /**
   * Test Json {@link Json#childKind()}.
   *
   * <p>Method under test: {@link Json#childKind()}
   */
  @Test
  @DisplayName("Test Json childKind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind Json.childKind()"})
  void testJsonChildKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().childKind());
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
  @MethodsUnderTest({"long Json.count()"})
  void testJsonCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().count());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setChildKind(EntityKind)}
   *   <li>{@link Json#setRef(EntityReference)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setChildKind(EntityKind)",
    "void Json.setRef(EntityReference)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setChildKind(EntityKind.ALL);
    actualJson.setRef(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    // Assert
    EntityReference entityReference = actualJson.ref;
    assertTrue(entityReference instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", entityReference.description());
    assertEquals(0L, actualJson.count);
    assertEquals(1L, entityReference.id());
    assertEquals(EntityKind.ALL, entityReference.kind());
    assertEquals(EntityKind.ALL, actualJson.childKind);
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReference.entityLifecycleStatus());
    assertFalse(actualJson.countIsSet);
  }

  /**
   * Test Json {@link Json#ref()}.
   *
   * <p>Method under test: {@link Json#ref()}
   */
  @Test
  @DisplayName("Test Json ref()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.ref()"})
  void testJsonRef() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().ref());
  }

  /**
   * Test Json {@link Json#setCount(long)}.
   *
   * <p>Method under test: {@link Json#setCount(long)}
   */
  @Test
  @DisplayName("Test Json setCount(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setCount(long)"})
  void testJsonSetCount() {
    // Arrange
    Json json = new Json();

    // Act
    json.setCount(3L);

    // Assert
    assertEquals(3L, json.count);
    assertTrue(json.countIsSet);
  }

  /**
   * Test {@link ImmutableChangeLogTally#withChildKind(EntityKind)}.
   *
   * <p>Method under test: {@link ImmutableChangeLogTally#withChildKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withChildKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeLogTally ImmutableChangeLogTally.withChildKind(EntityKind)"})
  void testWithChildKind() {
    // Arrange
    Builder countResult = ImmutableChangeLogTally.builder().childKind(EntityKind.ALL).count(3L);
    ImmutableChangeLogTally immutableChangeLogTally =
        countResult
            .ref(
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
    ImmutableChangeLogTally actualWithChildKindResult =
        immutableChangeLogTally.withChildKind(EntityKind.ALL);

    // Assert
    assertSame(immutableChangeLogTally, actualWithChildKindResult);
  }

  /**
   * Test {@link ImmutableChangeLogTally#withChildKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then ref return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeLogTally#withChildKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withChildKind(EntityKind); then ref return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeLogTally ImmutableChangeLogTally.withChildKind(EntityKind)"})
  void testWithChildKind_thenRefReturnImmutableEntityReference() {
    // Arrange
    Builder countResult = ImmutableChangeLogTally.builder().childKind(EntityKind.ACTOR).count(3L);

    // Act
    ImmutableChangeLogTally actualWithChildKindResult =
        countResult
            .ref(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build()
            .withChildKind(EntityKind.ALL);

    // Assert
    EntityReference refResult = actualWithChildKindResult.ref();
    assertTrue(refResult instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", refResult.description());
    assertEquals(1L, refResult.id());
    assertEquals(3L, actualWithChildKindResult.count());
    assertEquals(EntityKind.ALL, refResult.kind());
    assertEquals(EntityKind.ALL, actualWithChildKindResult.childKind());
    assertEquals(EntityLifecycleStatus.ACTIVE, refResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableChangeLogTally#withCount(long)}.
   *
   * <p>Method under test: {@link ImmutableChangeLogTally#withCount(long)}
   */
  @Test
  @DisplayName("Test withCount(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeLogTally ImmutableChangeLogTally.withCount(long)"})
  void testWithCount() {
    // Arrange
    Builder countResult = ImmutableChangeLogTally.builder().childKind(EntityKind.ALL).count(42L);
    ImmutableChangeLogTally immutableChangeLogTally =
        countResult
            .ref(
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
    ImmutableChangeLogTally actualWithCountResult = immutableChangeLogTally.withCount(42L);

    // Assert
    assertSame(immutableChangeLogTally, actualWithCountResult);
  }

  /**
   * Test {@link ImmutableChangeLogTally#withCount(long)}.
   *
   * <ul>
   *   <li>Then ref return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeLogTally#withCount(long)}
   */
  @Test
  @DisplayName("Test withCount(long); then ref return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeLogTally ImmutableChangeLogTally.withCount(long)"})
  void testWithCount_thenRefReturnImmutableEntityReference() {
    // Arrange
    Builder countResult = ImmutableChangeLogTally.builder().childKind(EntityKind.ALL).count(3L);

    // Act
    ImmutableChangeLogTally actualWithCountResult =
        countResult
            .ref(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build()
            .withCount(42L);

    // Assert
    EntityReference refResult = actualWithCountResult.ref();
    assertTrue(refResult instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", refResult.description());
    assertEquals(1L, refResult.id());
    assertEquals(42L, actualWithCountResult.count());
    assertEquals(EntityKind.ALL, refResult.kind());
    assertEquals(EntityKind.ALL, actualWithCountResult.childKind());
    assertEquals(EntityLifecycleStatus.ACTIVE, refResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableChangeLogTally#withRef(EntityReference)}.
   *
   * <p>Method under test: {@link ImmutableChangeLogTally#withRef(EntityReference)}
   */
  @Test
  @DisplayName("Test withRef(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeLogTally ImmutableChangeLogTally.withRef(EntityReference)"})
  void testWithRef() {
    // Arrange
    Builder countResult = ImmutableChangeLogTally.builder().childKind(EntityKind.ALL).count(3L);
    ImmutableChangeLogTally immutableChangeLogTally =
        countResult
            .ref(
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
    ImmutableChangeLogTally actualWithRefResult =
        immutableChangeLogTally.withRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableChangeLogTally, actualWithRefResult);
  }
}
