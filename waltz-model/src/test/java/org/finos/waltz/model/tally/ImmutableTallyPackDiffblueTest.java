package org.finos.waltz.model.tally;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.tally.ImmutableTallyPack.Builder;
import org.finos.waltz.model.tally.ImmutableTallyPack.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableTallyPackDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllTallies(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllTallies(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllTallies(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllTallies(Iterable)"})
  void testBuilderAddAllTallies_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder<Object> builderResult = ImmutableTallyPack.builder();

    // Act
    Builder<Object> actualAddAllTalliesResult = builderResult.addAllTallies(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllTalliesResult);
  }

  /**
   * Test Builder {@link Builder#addTallies(Tally)} with {@code element}.
   *
   * <ul>
   *   <li>When {@link ImmutableOrderedTally.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addTallies(Tally)}
   */
  @Test
  @DisplayName(
      "Test Builder addTallies(Tally) with 'element'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addTallies(Tally)"})
  void testBuilderAddTalliesWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder<Object> builderResult = ImmutableTallyPack.builder();

    // Act
    Builder<Object> actualAddTalliesResult =
        builderResult.addTallies(new ImmutableOrderedTally.Json<>());

    // Assert
    assertSame(builderResult, actualAddTalliesResult);
  }

  /**
   * Test Builder {@link Builder#addTallies(Tally[])} with {@code elements}.
   *
   * <ul>
   *   <li>When {@link ImmutableOrderedTally.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addTallies(Tally[])}
   */
  @Test
  @DisplayName(
      "Test Builder addTallies(Tally[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addTallies(Tally[])"})
  void testBuilderAddTalliesWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder<Object> builderResult = ImmutableTallyPack.builder();

    // Act
    Builder<Object> actualAddTalliesResult =
        builderResult.addTallies(new ImmutableOrderedTally.Json<>());

    // Assert
    assertSame(builderResult, actualAddTalliesResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#lastUpdatedAt(LocalDateTime)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableTallyPack Builder.build()",
    "Builder Builder.lastUpdatedAt(LocalDateTime)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder<Object> actualBuilderResult = ImmutableTallyPack.builder();
    ImmutableEntityReference entityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    LocalDateTime lastUpdatedAt = LocalDate.of(1970, 1, 1).atStartOfDay();
    ImmutableTallyPack<Object> actualImmutableTallyPack =
        actualBuilderResult.entityReference(entityReference).lastUpdatedAt(lastUpdatedAt).build();

    // Assert
    assertTrue(actualImmutableTallyPack.tallies().isEmpty());
    assertSame(lastUpdatedAt, actualImmutableTallyPack.lastUpdatedAt());
    assertSame(entityReference, actualImmutableTallyPack.entityReference());
  }

  /**
   * Test Builder {@link Builder#entityReference(EntityReference)}.
   *
   * <p>Method under test: {@link Builder#entityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder entityReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.entityReference(EntityReference)"})
  void testBuilderEntityReference() {
    // Arrange
    Builder<Object> builderResult = ImmutableTallyPack.builder();
    ImmutableEntityReference entityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    Builder<Object> actualEntityReferenceResult = builderResult.entityReference(entityReference);

    // Assert
    assertSame(entityReference, builderResult.build().entityReference());
    assertSame(builderResult, actualEntityReferenceResult);
  }

  /**
   * Test Builder {@link Builder#from(TallyPack)}.
   *
   * <p>Method under test: {@link Builder#from(TallyPack)}
   */
  @Test
  @DisplayName("Test Builder from(TallyPack)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(TallyPack)"})
  void testBuilderFrom() {
    // Arrange
    Builder<Object> builderResult = ImmutableTallyPack.builder();

    Builder<Object> builderResult2 = ImmutableTallyPack.builder();
    ImmutableTallyPack<Object> instance =
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
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .build();

    // Act
    Builder<Object> actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableTallyPack<Object> actualImmutableTallyPack = builderResult.build();
    assertEquals(instance, actualImmutableTallyPack);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(TallyPack)}.
   *
   * <ul>
   *   <li>Then return build tallies size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(TallyPack)}
   */
  @Test
  @DisplayName("Test Builder from(TallyPack); then return build tallies size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(TallyPack)"})
  void testBuilderFrom_thenReturnBuildTalliesSizeIsOne() {
    // Arrange
    Builder<Object> builderResult = ImmutableTallyPack.builder();

    Builder<Object> builderResult2 = ImmutableTallyPack.builder();

    ImmutableOrderedTally.Builder<Object> builderResult3 = ImmutableOrderedTally.builder();
    builderResult2.addTallies(builderResult3.count(10.0d).id("Id").index(1).build());

    // Act and Assert
    List<Tally<Object>> talliesResult =
        builderResult
            .from(
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
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .build())
            .build()
            .tallies();
    assertEquals(1, talliesResult.size());
    Tally<Object> getResult = talliesResult.get(0);
    assertTrue(getResult instanceof ImmutableOrderedTally);
    assertEquals("Id", getResult.id());
    assertEquals(1, ((ImmutableOrderedTally<Object>) getResult).index());
    assertEquals(10.0d, getResult.count());
  }

  /**
   * Test Builder {@link Builder#tallies(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#tallies(Iterable)}
   */
  @Test
  @DisplayName("Test Builder tallies(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.tallies(Iterable)"})
  void testBuilderTallies_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder<Object> builderResult = ImmutableTallyPack.builder();

    // Act
    Builder<Object> actualTalliesResult = builderResult.tallies(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualTalliesResult);
  }

  /**
   * Test {@link ImmutableTallyPack#copyOf(TallyPack)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTallyPack#copyOf(TallyPack)}
   */
  @Test
  @DisplayName("Test copyOf(TallyPack); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableTallyPack ImmutableTallyPack.copyOf(TallyPack)"})
  void testCopyOf_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder<Object> builderResult = ImmutableTallyPack.builder();

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    ImmutableTallyPack<Object> instance =
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
            .lastUpdatedAt(ofResult.atStartOfDay())
            .build();

    // Act
    ImmutableTallyPack<Object> actualCopyOfResult = ImmutableTallyPack.copyOf(instance);

    // Assert
    EntityReference entityReferenceResult = actualCopyOfResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertTrue(actualCopyOfResult.tallies().isEmpty());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableTallyPack#equals(Object)}, and {@link ImmutableTallyPack#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableTallyPack#equals(Object)}
   *   <li>{@link ImmutableTallyPack#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableTallyPack.equals(Object)",
    "int ImmutableTallyPack.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder<Object> builderResult = ImmutableTallyPack.builder();
    ImmutableTallyPack<Object> immutableTallyPack =
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
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .build();

    Builder<Object> builderResult2 = ImmutableTallyPack.builder();
    ImmutableTallyPack<Object> immutableTallyPack2 =
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
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .build();

    // Act and Assert
    assertEquals(immutableTallyPack, immutableTallyPack2);
    assertEquals(immutableTallyPack.hashCode(), immutableTallyPack2.hashCode());
  }

  /**
   * Test {@link ImmutableTallyPack#equals(Object)}, and {@link ImmutableTallyPack#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableTallyPack#equals(Object)}
   *   <li>{@link ImmutableTallyPack#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableTallyPack.equals(Object)",
    "int ImmutableTallyPack.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder<Object> builderResult = ImmutableTallyPack.builder();
    ImmutableTallyPack<Object> immutableTallyPack =
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
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .build();

    // Act and Assert
    assertEquals(immutableTallyPack, immutableTallyPack);
    int expectedHashCodeResult = immutableTallyPack.hashCode();
    assertEquals(expectedHashCodeResult, immutableTallyPack.hashCode());
  }

  /**
   * Test {@link ImmutableTallyPack#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTallyPack#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableTallyPack.equals(Object)",
    "int ImmutableTallyPack.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder<Object> builderResult = ImmutableTallyPack.builder();

    ImmutableOrderedTally.Builder<Object> builderResult2 = ImmutableOrderedTally.builder();
    builderResult.addTallies(builderResult2.count(10.0d).id("Id").index(1).build());
    ImmutableTallyPack<Object> immutableTallyPack =
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
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .build();

    Builder<Object> builderResult3 = ImmutableTallyPack.builder();

    // Act and Assert
    assertNotEquals(
        immutableTallyPack,
        builderResult3
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .build());
  }

  /**
   * Test {@link ImmutableTallyPack#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTallyPack#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableTallyPack.equals(Object)",
    "int ImmutableTallyPack.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder<Object> builderResult = ImmutableTallyPack.builder();
    ImmutableTallyPack<Object> immutableTallyPack =
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
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .build();

    Builder<Object> builderResult2 = ImmutableTallyPack.builder();

    // Act and Assert
    assertNotEquals(
        immutableTallyPack,
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
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .build());
  }

  /**
   * Test {@link ImmutableTallyPack#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTallyPack#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableTallyPack.equals(Object)",
    "int ImmutableTallyPack.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder<Object> builderResult = ImmutableTallyPack.builder();
    ImmutableTallyPack<Object> immutableTallyPack =
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
            .lastUpdatedAt(LocalDate.now().atStartOfDay())
            .build();

    Builder<Object> builderResult2 = ImmutableTallyPack.builder();

    // Act and Assert
    assertNotEquals(
        immutableTallyPack,
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
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .build());
  }

  /**
   * Test {@link ImmutableTallyPack#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTallyPack#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableTallyPack.equals(Object)",
    "int ImmutableTallyPack.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder<Object> builderResult = ImmutableTallyPack.builder();

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
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableTallyPack#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTallyPack#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableTallyPack.equals(Object)",
    "int ImmutableTallyPack.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder<Object> builderResult = ImmutableTallyPack.builder();

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
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .build(),
        "Different type to ImmutableTallyPack");
  }

  /**
   * Test {@link ImmutableTallyPack#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then return tallies Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTallyPack#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given ArrayList(); then return tallies Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableTallyPack ImmutableTallyPack.fromJson(Json)"})
  void testFromJson_givenArrayList_thenReturnTalliesEmpty() {
    // Arrange
    Json<Object> json = new Json<>();
    json.setEntityReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setTallies(new ArrayList<>());
    json.setLastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act
    ImmutableTallyPack<Object> actualFromJsonResult = ImmutableTallyPack.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.tallies().isEmpty());
    EntityReference expectedEntityReferenceResult = json.entityReference;
    assertSame(expectedEntityReferenceResult, actualFromJsonResult.entityReference());
    LocalDateTime expectedLastUpdatedAtResult = json.lastUpdatedAt;
    assertSame(expectedLastUpdatedAtResult, actualFromJsonResult.lastUpdatedAt());
  }

  /**
   * Test {@link ImmutableTallyPack#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return tallies is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTallyPack#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return tallies is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableTallyPack ImmutableTallyPack.fromJson(Json)"})
  void testFromJson_thenReturnTalliesIsArrayList() {
    // Arrange
    ArrayList<Tally<Object>> tallies = new ArrayList<>();

    ImmutableOrderedTally.Builder<Object> builderResult = ImmutableOrderedTally.builder();
    tallies.add(builderResult.count(10.0d).id("Id").index(1).build());

    Json<Object> json = new Json<>();
    json.setEntityReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setTallies(tallies);
    json.setLastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act
    ImmutableTallyPack<Object> actualFromJsonResult = ImmutableTallyPack.fromJson(json);

    // Assert
    assertEquals(tallies, actualFromJsonResult.tallies());
  }

  /**
   * Test {@link ImmutableTallyPack#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return tallies is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTallyPack#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return tallies is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableTallyPack ImmutableTallyPack.fromJson(Json)"})
  void testFromJson_thenReturnTalliesIsArrayList2() {
    // Arrange
    ArrayList<Tally<Object>> tallies = new ArrayList<>();

    ImmutableOrderedTally.Builder<Object> builderResult = ImmutableOrderedTally.builder();
    tallies.add(builderResult.count(10.0d).id("Id").index(1).build());

    ImmutableOrderedTally.Builder<Object> builderResult2 = ImmutableOrderedTally.builder();
    tallies.add(builderResult2.count(10.0d).id("Id").index(1).build());

    Json<Object> json = new Json<>();
    json.setEntityReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setTallies(tallies);
    json.setLastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act
    ImmutableTallyPack<Object> actualFromJsonResult = ImmutableTallyPack.fromJson(json);

    // Assert
    assertEquals(tallies, actualFromJsonResult.tallies());
  }

  /**
   * Test {@link ImmutableTallyPack#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) LastUpdatedAt is {@code null}.
   *   <li>Then return tallies is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTallyPack#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) LastUpdatedAt is 'null'; then return tallies is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableTallyPack ImmutableTallyPack.fromJson(Json)"})
  void testFromJson_whenJsonLastUpdatedAtIsNull_thenReturnTalliesIsArrayList() {
    // Arrange
    ArrayList<Tally<Object>> tallies = new ArrayList<>();

    ImmutableOrderedTally.Builder<Object> builderResult = ImmutableOrderedTally.builder();
    tallies.add(builderResult.count(10.0d).id("Id").index(1).build());

    Json<Object> json = new Json<>();
    json.setEntityReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setTallies(tallies);
    json.setLastUpdatedAt(null);

    // Act
    ImmutableTallyPack<Object> actualFromJsonResult = ImmutableTallyPack.fromJson(json);

    // Assert
    assertEquals(tallies, actualFromJsonResult.tallies());
  }

  /**
   * Test {@link ImmutableTallyPack#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) Tallies is {@code null}.
   *   <li>Then return tallies Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTallyPack#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) Tallies is 'null'; then return tallies Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableTallyPack ImmutableTallyPack.fromJson(Json)"})
  void testFromJson_whenJsonTalliesIsNull_thenReturnTalliesEmpty() {
    // Arrange
    Json<Object> json = new Json<>();
    json.setEntityReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setTallies(null);
    json.setLastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act
    ImmutableTallyPack<Object> actualFromJsonResult = ImmutableTallyPack.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.tallies().isEmpty());
    EntityReference expectedEntityReferenceResult = json.entityReference;
    assertSame(expectedEntityReferenceResult, actualFromJsonResult.entityReference());
    LocalDateTime expectedLastUpdatedAtResult = json.lastUpdatedAt;
    assertSame(expectedLastUpdatedAtResult, actualFromJsonResult.lastUpdatedAt());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableTallyPack#toString()}
   *   <li>{@link ImmutableTallyPack#entityReference()}
   *   <li>{@link ImmutableTallyPack#lastUpdatedAt()}
   *   <li>{@link ImmutableTallyPack#tallies()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityReference ImmutableTallyPack.entityReference()",
    "LocalDateTime ImmutableTallyPack.lastUpdatedAt()",
    "List ImmutableTallyPack.tallies()",
    "String ImmutableTallyPack.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder<Object> builderResult = ImmutableTallyPack.builder();

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    ImmutableTallyPack<Object> immutableTallyPack =
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
            .lastUpdatedAt(ofResult.atStartOfDay())
            .build();

    // Act
    String actualToStringResult = immutableTallyPack.toString();
    EntityReference actualEntityReferenceResult = immutableTallyPack.entityReference();
    LocalDateTime actualLastUpdatedAtResult = immutableTallyPack.lastUpdatedAt();

    // Assert
    assertTrue(actualEntityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("00:00", actualLastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = actualLastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals(
        "TallyPack{entityReference=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}, tallies=[],"
            + " lastUpdatedAt=1970-01-01T00:00}",
        actualToStringResult);
    assertTrue(immutableTallyPack.tallies().isEmpty());
    assertSame(ofResult, toLocalDateResult);
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
    // Arrange
    Json<Object> json = new Json<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> json.entityReference());
  }

  /**
   * Test Json {@link Json#lastUpdatedAt()}.
   *
   * <p>Method under test: {@link Json#lastUpdatedAt()}
   */
  @Test
  @DisplayName("Test Json lastUpdatedAt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime Json.lastUpdatedAt()"})
  void testJsonLastUpdatedAt() {
    // Arrange
    Json<Object> json = new Json<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> json.lastUpdatedAt());
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
    Json<Object> actualJson = new Json<>();

    // Assert
    assertNull(actualJson.lastUpdatedAt);
    assertNull(actualJson.entityReference);
    assertTrue(actualJson.tallies.isEmpty());
  }

  /**
   * Test Json {@link Json#tallies()}.
   *
   * <p>Method under test: {@link Json#tallies()}
   */
  @Test
  @DisplayName("Test Json tallies()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Json.tallies()"})
  void testJsonTallies() {
    // Arrange
    Json<Object> json = new Json<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> json.tallies());
  }

  /**
   * Test {@link ImmutableTallyPack#withEntityReference(EntityReference)}.
   *
   * <p>Method under test: {@link ImmutableTallyPack#withEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test withEntityReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableTallyPack ImmutableTallyPack.withEntityReference(EntityReference)"})
  void testWithEntityReference() {
    // Arrange
    Builder<Object> builderResult = ImmutableTallyPack.builder();
    ImmutableTallyPack<Object> immutableTallyPack =
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
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .build();

    // Act
    ImmutableTallyPack<Object> actualWithEntityReferenceResult =
        immutableTallyPack.withEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableTallyPack, actualWithEntityReferenceResult);
  }

  /**
   * Test {@link ImmutableTallyPack#withLastUpdatedAt(LocalDateTime)}.
   *
   * <p>Method under test: {@link ImmutableTallyPack#withLastUpdatedAt(LocalDateTime)}
   */
  @Test
  @DisplayName("Test withLastUpdatedAt(LocalDateTime)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableTallyPack ImmutableTallyPack.withLastUpdatedAt(LocalDateTime)"})
  void testWithLastUpdatedAt() {
    // Arrange
    Builder<Object> builderResult = ImmutableTallyPack.builder();
    ImmutableTallyPack<Object> immutableTallyPack =
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
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .build();

    // Act
    ImmutableTallyPack<Object> actualWithLastUpdatedAtResult =
        immutableTallyPack.withLastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertEquals(immutableTallyPack, actualWithLastUpdatedAtResult);
  }

  /**
   * Test {@link ImmutableTallyPack#withTallies(Tally[])} with {@code Tally[]}.
   *
   * <p>Method under test: {@link ImmutableTallyPack#withTallies(Tally[])}
   */
  @Test
  @DisplayName("Test withTallies(Tally[]) with 'Tally[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableTallyPack ImmutableTallyPack.withTallies(Tally[])"})
  void testWithTalliesWithTally() {
    // Arrange
    Builder<Object> builderResult = ImmutableTallyPack.builder();

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    ImmutableTallyPack<Object> immutableTallyPack =
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
            .lastUpdatedAt(ofResult.atStartOfDay())
            .build();

    ImmutableOrderedTally.Builder<Object> builderResult2 = ImmutableOrderedTally.builder();

    // Act
    ImmutableTallyPack<Object> actualWithTalliesResult =
        immutableTallyPack.withTallies(builderResult2.count(10.0d).id("Id").index(1).build());

    // Assert
    EntityReference entityReferenceResult = actualWithTalliesResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    List<Tally<Object>> talliesResult = actualWithTalliesResult.tallies();
    assertEquals(1, talliesResult.size());
    Tally<Object> getResult = talliesResult.get(0);
    assertTrue(getResult instanceof ImmutableOrderedTally);
    LocalDateTime lastUpdatedAtResult = actualWithTalliesResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("Id", getResult.id());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1, ((ImmutableOrderedTally<Object>) getResult).index());
    assertEquals(10.0d, getResult.count());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertSame(ofResult, toLocalDateResult);
  }
}
