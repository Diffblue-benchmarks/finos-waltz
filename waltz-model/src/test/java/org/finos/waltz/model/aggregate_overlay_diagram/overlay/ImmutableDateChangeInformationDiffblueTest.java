package org.finos.waltz.model.aggregate_overlay_diagram.overlay;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import org.finos.waltz.model.ChangeDirection;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.Quarter;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableDateChangeInformation.Builder;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableDateChangeInformation.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableDateChangeInformationDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllChanges(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllChanges(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllChanges(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllChanges(Iterable)"})
  void testBuilderAddAllChanges_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDateChangeInformation.builder();

    // Act
    Builder actualAddAllChangesResult = builderResult.addAllChanges(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllChangesResult);
  }

  /**
   * Test Builder {@link Builder#addChanges(AppChangeEntry)} with {@code element}.
   *
   * <ul>
   *   <li>When {@link ImmutableAppChangeEntry.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addChanges(AppChangeEntry)}
   */
  @Test
  @DisplayName(
      "Test Builder addChanges(AppChangeEntry) with 'element'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addChanges(AppChangeEntry)"})
  void testBuilderAddChangesWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDateChangeInformation.builder();

    // Act
    Builder actualAddChangesResult = builderResult.addChanges(new ImmutableAppChangeEntry.Json());

    // Assert
    assertSame(builderResult, actualAddChangesResult);
  }

  /**
   * Test Builder {@link Builder#addChanges(AppChangeEntry[])} with {@code elements}.
   *
   * <ul>
   *   <li>When {@link ImmutableAppChangeEntry.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addChanges(AppChangeEntry[])}
   */
  @Test
  @DisplayName(
      "Test Builder addChanges(AppChangeEntry[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addChanges(AppChangeEntry[])"})
  void testBuilderAddChangesWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDateChangeInformation.builder();

    // Act
    Builder actualAddChangesResult = builderResult.addChanges(new ImmutableAppChangeEntry.Json());

    // Assert
    assertSame(builderResult, actualAddChangesResult);
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
  @MethodsUnderTest({"ImmutableDateChangeInformation Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableDateChangeInformation.builder();
    ImmutableQuarterDetail quarter = ImmutableQuarterDetail.builder().quarter(1).year(1).build();
    ImmutableDateChangeInformation actualImmutableDateChangeInformation =
        actualBuilderResult.quarter(quarter).build();

    // Assert
    assertEquals(0, actualImmutableDateChangeInformation.count());
    assertTrue(actualImmutableDateChangeInformation.changes().isEmpty());
    assertSame(quarter, actualImmutableDateChangeInformation.quarter());
  }

  /**
   * Test Builder {@link Builder#changes(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#changes(Iterable)}
   */
  @Test
  @DisplayName("Test Builder changes(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.changes(Iterable)"})
  void testBuilderChanges_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDateChangeInformation.builder();

    // Act
    Builder actualChangesResult = builderResult.changes(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualChangesResult);
  }

  /**
   * Test Builder {@link Builder#from(DateChangeInformation)}.
   *
   * <p>Method under test: {@link Builder#from(DateChangeInformation)}
   */
  @Test
  @DisplayName("Test Builder from(DateChangeInformation)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DateChangeInformation)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableDateChangeInformation.builder();

    Builder builderResult2 = ImmutableDateChangeInformation.builder();
    ImmutableDateChangeInformation instance =
        builderResult2.quarter(ImmutableQuarterDetail.builder().quarter(1).year(1).build()).build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableDateChangeInformation actualImmutableDateChangeInformation = builderResult.build();
    assertEquals(instance, actualImmutableDateChangeInformation);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(DateChangeInformation)}.
   *
   * <p>Method under test: {@link Builder#from(DateChangeInformation)}
   */
  @Test
  @DisplayName("Test Builder from(DateChangeInformation)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DateChangeInformation)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableDateChangeInformation.builder();

    Builder builderResult2 = ImmutableDateChangeInformation.builder();

    ImmutableAppChangeEntry.Builder builderResult3 = ImmutableAppChangeEntry.builder();
    builderResult2.addChanges(
        builderResult3
            .appRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeDirection(ChangeDirection.INBOUND)
            .date(LocalDate.of(1970, 1, 1))
            .build());
    ImmutableDateChangeInformation instance =
        builderResult2.quarter(ImmutableQuarterDetail.builder().quarter(1).year(1).build()).build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableDateChangeInformation actualImmutableDateChangeInformation = builderResult.build();
    assertEquals(instance, actualImmutableDateChangeInformation);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#quarter(QuarterDetail)}.
   *
   * <ul>
   *   <li>When {@link ImmutableQuarterDetail.Json} (default constructor).
   *   <li>Then builder build count is zero.
   * </ul>
   *
   * <p>Method under test: {@link Builder#quarter(QuarterDetail)}
   */
  @Test
  @DisplayName(
      "Test Builder quarter(QuarterDetail); when Json (default constructor); then builder build count is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.quarter(QuarterDetail)"})
  void testBuilderQuarter_whenJson_thenBuilderBuildCountIsZero() {
    // Arrange
    Builder builderResult = ImmutableDateChangeInformation.builder();
    ImmutableQuarterDetail.Json quarter = new ImmutableQuarterDetail.Json();

    // Act
    Builder actualQuarterResult = builderResult.quarter(quarter);

    // Assert
    ImmutableDateChangeInformation immutableDateChangeInformation = builderResult.build();
    assertEquals(0, immutableDateChangeInformation.count());
    assertSame(quarter, immutableDateChangeInformation.quarter());
    assertSame(builderResult, actualQuarterResult);
  }

  /**
   * Test {@link ImmutableDateChangeInformation#copyOf(DateChangeInformation)}.
   *
   * <ul>
   *   <li>Then quarter return {@link ImmutableQuarterDetail}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDateChangeInformation#copyOf(DateChangeInformation)}
   */
  @Test
  @DisplayName("Test copyOf(DateChangeInformation); then quarter return ImmutableQuarterDetail")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDateChangeInformation ImmutableDateChangeInformation.copyOf(DateChangeInformation)"
  })
  void testCopyOf_thenQuarterReturnImmutableQuarterDetail() {
    // Arrange
    Builder builderResult = ImmutableDateChangeInformation.builder();
    ImmutableDateChangeInformation instance =
        builderResult.quarter(ImmutableQuarterDetail.builder().quarter(1).year(1).build()).build();

    // Act
    ImmutableDateChangeInformation actualCopyOfResult =
        ImmutableDateChangeInformation.copyOf(instance);

    // Assert
    QuarterDetail quarterResult = actualCopyOfResult.quarter();
    assertTrue(quarterResult instanceof ImmutableQuarterDetail);
    assertEquals(0, actualCopyOfResult.count());
    assertEquals(1, quarterResult.quarter());
    assertEquals(1, quarterResult.year());
    assertEquals(Quarter.Q1, quarterResult.quarterName());
    assertTrue(actualCopyOfResult.changes().isEmpty());
  }

  /**
   * Test {@link ImmutableDateChangeInformation#equals(Object)}, and {@link
   * ImmutableDateChangeInformation#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableDateChangeInformation#equals(Object)}
   *   <li>{@link ImmutableDateChangeInformation#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDateChangeInformation.equals(Object)",
    "int ImmutableDateChangeInformation.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableDateChangeInformation.builder();
    ImmutableDateChangeInformation immutableDateChangeInformation =
        builderResult.quarter(ImmutableQuarterDetail.builder().quarter(1).year(1).build()).build();

    Builder builderResult2 = ImmutableDateChangeInformation.builder();
    ImmutableDateChangeInformation immutableDateChangeInformation2 =
        builderResult2.quarter(ImmutableQuarterDetail.builder().quarter(1).year(1).build()).build();

    // Act and Assert
    assertEquals(immutableDateChangeInformation, immutableDateChangeInformation2);
    assertEquals(
        immutableDateChangeInformation.hashCode(), immutableDateChangeInformation2.hashCode());
  }

  /**
   * Test {@link ImmutableDateChangeInformation#equals(Object)}, and {@link
   * ImmutableDateChangeInformation#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableDateChangeInformation#equals(Object)}
   *   <li>{@link ImmutableDateChangeInformation#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDateChangeInformation.equals(Object)",
    "int ImmutableDateChangeInformation.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableDateChangeInformation.builder();
    ImmutableDateChangeInformation immutableDateChangeInformation =
        builderResult.quarter(ImmutableQuarterDetail.builder().quarter(1).year(1).build()).build();

    // Act and Assert
    assertEquals(immutableDateChangeInformation, immutableDateChangeInformation);
    int expectedHashCodeResult = immutableDateChangeInformation.hashCode();
    assertEquals(expectedHashCodeResult, immutableDateChangeInformation.hashCode());
  }

  /**
   * Test {@link ImmutableDateChangeInformation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDateChangeInformation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDateChangeInformation.equals(Object)",
    "int ImmutableDateChangeInformation.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableDateChangeInformation.builder();

    ImmutableAppChangeEntry.Builder builderResult2 = ImmutableAppChangeEntry.builder();
    builderResult.addChanges(
        builderResult2
            .appRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeDirection(ChangeDirection.INBOUND)
            .date(LocalDate.of(1970, 1, 1))
            .build());
    ImmutableDateChangeInformation immutableDateChangeInformation =
        builderResult.quarter(ImmutableQuarterDetail.builder().quarter(1).year(1).build()).build();

    Builder builderResult3 = ImmutableDateChangeInformation.builder();

    // Act and Assert
    assertNotEquals(
        immutableDateChangeInformation,
        builderResult3
            .quarter(ImmutableQuarterDetail.builder().quarter(1).year(1).build())
            .build());
  }

  /**
   * Test {@link ImmutableDateChangeInformation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDateChangeInformation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDateChangeInformation.equals(Object)",
    "int ImmutableDateChangeInformation.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableDateChangeInformation.builder();
    ImmutableDateChangeInformation immutableDateChangeInformation =
        builderResult
            .quarter(ImmutableQuarterDetail.builder().quarter(1).year(-8095).build())
            .build();

    Builder builderResult2 = ImmutableDateChangeInformation.builder();

    // Act and Assert
    assertNotEquals(
        immutableDateChangeInformation,
        builderResult2
            .quarter(ImmutableQuarterDetail.builder().quarter(1).year(1).build())
            .build());
  }

  /**
   * Test {@link ImmutableDateChangeInformation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDateChangeInformation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDateChangeInformation.equals(Object)",
    "int ImmutableDateChangeInformation.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableDateChangeInformation.builder();

    ImmutableAppChangeEntry.Builder builderResult2 = ImmutableAppChangeEntry.builder();
    builderResult.addChanges(
        builderResult2
            .appRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeDirection(ChangeDirection.INBOUND)
            .date(LocalDate.of(1970, 1, 1))
            .build());
    ImmutableDateChangeInformation immutableDateChangeInformation =
        builderResult.quarter(ImmutableQuarterDetail.builder().quarter(1).year(1).build()).build();

    Builder builderResult3 = ImmutableDateChangeInformation.builder();

    ImmutableAppChangeEntry.Builder builderResult4 = ImmutableAppChangeEntry.builder();
    builderResult3.addChanges(
        builderResult4
            .appRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeDirection(ChangeDirection.INBOUND)
            .date(LocalDate.of(1970, 1, 1))
            .build());

    // Act and Assert
    assertNotEquals(
        immutableDateChangeInformation,
        builderResult3
            .quarter(ImmutableQuarterDetail.builder().quarter(1).year(1).build())
            .build());
  }

  /**
   * Test {@link ImmutableDateChangeInformation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDateChangeInformation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDateChangeInformation.equals(Object)",
    "int ImmutableDateChangeInformation.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableDateChangeInformation.builder();

    // Act and Assert
    assertNotEquals(
        builderResult.quarter(ImmutableQuarterDetail.builder().quarter(1).year(1).build()).build(),
        null);
  }

  /**
   * Test {@link ImmutableDateChangeInformation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDateChangeInformation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDateChangeInformation.equals(Object)",
    "int ImmutableDateChangeInformation.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableDateChangeInformation.builder();

    // Act and Assert
    assertNotEquals(
        builderResult.quarter(ImmutableQuarterDetail.builder().quarter(1).year(1).build()).build(),
        "Different type to ImmutableDateChangeInformation");
  }

  /**
   * Test {@link ImmutableDateChangeInformation#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   *   <li>When {@link Json} (default constructor) Changes is {@link HashSet#HashSet()}.
   *   <li>Then return count is zero.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDateChangeInformation#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given HashSet(); when Json (default constructor) Changes is HashSet(); then return count is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDateChangeInformation ImmutableDateChangeInformation.fromJson(Json)"
  })
  void testFromJson_givenHashSet_whenJsonChangesIsHashSet_thenReturnCountIsZero() {
    // Arrange
    Json json = new Json();
    ImmutableQuarterDetail.Json quarter = new ImmutableQuarterDetail.Json();
    json.setQuarter(quarter);
    json.setChanges(new HashSet<>());

    // Act
    ImmutableDateChangeInformation actualFromJsonResult =
        ImmutableDateChangeInformation.fromJson(json);

    // Assert
    assertEquals(0, actualFromJsonResult.count());
    assertTrue(actualFromJsonResult.changes().isEmpty());
    assertSame(quarter, actualFromJsonResult.quarter());
  }

  /**
   * Test {@link ImmutableDateChangeInformation#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link ImmutableQuarterDetail.Json} (default constructor).
   *   <li>When {@link Json} (default constructor) Changes is {@code null}.
   *   <li>Then return count is zero.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDateChangeInformation#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given Json (default constructor); when Json (default constructor) Changes is 'null'; then return count is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDateChangeInformation ImmutableDateChangeInformation.fromJson(Json)"
  })
  void testFromJson_givenJson_whenJsonChangesIsNull_thenReturnCountIsZero() {
    // Arrange
    Json json = new Json();
    ImmutableQuarterDetail.Json quarter = new ImmutableQuarterDetail.Json();
    json.setQuarter(quarter);
    json.setChanges(null);

    // Act
    ImmutableDateChangeInformation actualFromJsonResult =
        ImmutableDateChangeInformation.fromJson(json);

    // Assert
    assertEquals(0, actualFromJsonResult.count());
    assertTrue(actualFromJsonResult.changes().isEmpty());
    assertSame(quarter, actualFromJsonResult.quarter());
  }

  /**
   * Test {@link ImmutableDateChangeInformation#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@link ImmutableAppChangeEntry.Json}
   *       (default constructor).
   *   <li>Then return changes size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDateChangeInformation#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given LinkedHashSet() add Json (default constructor); then return changes size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDateChangeInformation ImmutableDateChangeInformation.fromJson(Json)"
  })
  void testFromJson_givenLinkedHashSetAddJson_thenReturnChangesSizeIsOne() {
    // Arrange
    LinkedHashSet<AppChangeEntry> changes = new LinkedHashSet<>();
    changes.add(new ImmutableAppChangeEntry.Json());

    Json json = new Json();
    json.setQuarter(new ImmutableQuarterDetail.Json());
    json.setChanges(changes);

    // Act
    ImmutableDateChangeInformation actualFromJsonResult =
        ImmutableDateChangeInformation.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.changes().size());
    assertEquals(1, actualFromJsonResult.count());
  }

  /**
   * Test {@link ImmutableDateChangeInformation#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return count is two.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDateChangeInformation#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return count is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDateChangeInformation ImmutableDateChangeInformation.fromJson(Json)"
  })
  void testFromJson_thenReturnCountIsTwo() {
    // Arrange
    LinkedHashSet<AppChangeEntry> changes = new LinkedHashSet<>();

    ImmutableAppChangeEntry.Builder builderResult = ImmutableAppChangeEntry.builder();
    changes.add(
        builderResult
            .appRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeDirection(ChangeDirection.INBOUND)
            .date(LocalDate.of(1970, 1, 1))
            .build());
    changes.add(new ImmutableAppChangeEntry.Json());

    Json json = new Json();
    json.setQuarter(new ImmutableQuarterDetail.Json());
    json.setChanges(changes);

    // Act
    ImmutableDateChangeInformation actualFromJsonResult =
        ImmutableDateChangeInformation.fromJson(json);

    // Assert
    assertEquals(2, actualFromJsonResult.count());
    assertEquals(changes, actualFromJsonResult.changes());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableDateChangeInformation#toString()}
   *   <li>{@link ImmutableDateChangeInformation#changes()}
   *   <li>{@link ImmutableDateChangeInformation#count()}
   *   <li>{@link ImmutableDateChangeInformation#quarter()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ImmutableDateChangeInformation.changes()",
    "int ImmutableDateChangeInformation.count()",
    "QuarterDetail ImmutableDateChangeInformation.quarter()",
    "java.lang.String ImmutableDateChangeInformation.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableDateChangeInformation.builder();
    ImmutableDateChangeInformation immutableDateChangeInformation =
        builderResult.quarter(ImmutableQuarterDetail.builder().quarter(1).year(1).build()).build();

    // Act
    immutableDateChangeInformation.toString();
    Set<AppChangeEntry> actualChangesResult = immutableDateChangeInformation.changes();
    int actualCountResult = immutableDateChangeInformation.count();

    // Assert
    assertTrue(immutableDateChangeInformation.quarter() instanceof ImmutableQuarterDetail);
    assertEquals(0, actualCountResult);
    assertTrue(actualChangesResult.isEmpty());
  }

  /**
   * Test Json {@link Json#changes()}.
   *
   * <p>Method under test: {@link Json#changes()}
   */
  @Test
  @DisplayName("Test Json changes()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.changes()"})
  void testJsonChanges() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().changes());
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
    assertNull(actualJson.quarter);
    assertTrue(actualJson.changes.isEmpty());
  }

  /**
   * Test Json {@link Json#quarter()}.
   *
   * <p>Method under test: {@link Json#quarter()}
   */
  @Test
  @DisplayName("Test Json quarter()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"QuarterDetail Json.quarter()"})
  void testJsonQuarter() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().quarter());
  }

  /**
   * Test {@link ImmutableDateChangeInformation#withChanges(AppChangeEntry[])} with {@code
   * AppChangeEntry[]}.
   *
   * <p>Method under test: {@link ImmutableDateChangeInformation#withChanges(AppChangeEntry[])}
   */
  @Test
  @DisplayName("Test withChanges(AppChangeEntry[]) with 'AppChangeEntry[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDateChangeInformation ImmutableDateChangeInformation.withChanges(AppChangeEntry[])"
  })
  void testWithChangesWithAppChangeEntry() {
    // Arrange
    Builder builderResult = ImmutableDateChangeInformation.builder();
    ImmutableDateChangeInformation immutableDateChangeInformation =
        builderResult.quarter(ImmutableQuarterDetail.builder().quarter(1).year(1).build()).build();

    ImmutableAppChangeEntry.Builder builderResult2 = ImmutableAppChangeEntry.builder();

    // Act
    ImmutableDateChangeInformation actualWithChangesResult =
        immutableDateChangeInformation.withChanges(
            builderResult2
                .appRef(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .changeDirection(ChangeDirection.INBOUND)
                .date(LocalDate.of(1970, 1, 1))
                .build());

    // Assert
    QuarterDetail quarterResult = actualWithChangesResult.quarter();
    assertTrue(quarterResult instanceof ImmutableQuarterDetail);
    assertEquals(1, actualWithChangesResult.changes().size());
    assertEquals(1, actualWithChangesResult.count());
    assertEquals(1, quarterResult.quarter());
    assertEquals(1, quarterResult.year());
    assertEquals(Quarter.Q1, quarterResult.quarterName());
  }

  /**
   * Test {@link ImmutableDateChangeInformation#withQuarter(QuarterDetail)}.
   *
   * <p>Method under test: {@link ImmutableDateChangeInformation#withQuarter(QuarterDetail)}
   */
  @Test
  @DisplayName("Test withQuarter(QuarterDetail)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDateChangeInformation ImmutableDateChangeInformation.withQuarter(QuarterDetail)"
  })
  void testWithQuarter() {
    // Arrange
    Builder builderResult = ImmutableDateChangeInformation.builder();
    ImmutableDateChangeInformation immutableDateChangeInformation =
        builderResult.quarter(ImmutableQuarterDetail.builder().quarter(1).year(1).build()).build();

    // Act
    ImmutableDateChangeInformation actualWithQuarterResult =
        immutableDateChangeInformation.withQuarter(
            ImmutableQuarterDetail.builder().quarter(1).year(1).build());

    // Assert
    assertEquals(immutableDateChangeInformation, actualWithQuarterResult);
  }
}
