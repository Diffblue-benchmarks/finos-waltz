package org.finos.waltz.model.involvement_kind;

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
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.involvement_kind.ImmutableInvolvementKindUsageStat.Builder;
import org.finos.waltz.model.involvement_kind.ImmutableInvolvementKindUsageStat.Json;
import org.finos.waltz.model.involvement_kind.InvolvementKindUsageStat.Stat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableInvolvementKindUsageStatDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllBreakdown(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllBreakdown(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllBreakdown(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllBreakdown(Iterable)"})
  void testBuilderAddAllBreakdown_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableInvolvementKindUsageStat.builder();

    // Act
    Builder actualAddAllBreakdownResult = builderResult.addAllBreakdown(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllBreakdownResult);
  }

  /**
   * Test Builder {@link Builder#addBreakdown(Stat)} with {@code element}.
   *
   * <ul>
   *   <li>When {@link ImmutableStat.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addBreakdown(Stat)}
   */
  @Test
  @DisplayName(
      "Test Builder addBreakdown(Stat) with 'element'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addBreakdown(Stat)"})
  void testBuilderAddBreakdownWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableInvolvementKindUsageStat.builder();

    // Act
    Builder actualAddBreakdownResult = builderResult.addBreakdown(new ImmutableStat.Json());

    // Assert
    assertSame(builderResult, actualAddBreakdownResult);
  }

  /**
   * Test Builder {@link Builder#addBreakdown(Stat[])} with {@code elements}.
   *
   * <ul>
   *   <li>When {@link ImmutableStat.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addBreakdown(Stat[])}
   */
  @Test
  @DisplayName(
      "Test Builder addBreakdown(Stat[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addBreakdown(Stat[])"})
  void testBuilderAddBreakdownWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableInvolvementKindUsageStat.builder();

    // Act
    Builder actualAddBreakdownResult = builderResult.addBreakdown(new ImmutableStat.Json());

    // Assert
    assertSame(builderResult, actualAddBreakdownResult);
  }

  /**
   * Test Builder {@link Builder#breakdown(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#breakdown(Iterable)}
   */
  @Test
  @DisplayName("Test Builder breakdown(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.breakdown(Iterable)"})
  void testBuilderBreakdown_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableInvolvementKindUsageStat.builder();

    // Act
    Builder actualBreakdownResult = builderResult.breakdown(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualBreakdownResult);
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
  @MethodsUnderTest({"ImmutableInvolvementKindUsageStat Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableInvolvementKindUsageStat.builder();
    ImmutableInvolvementKind involvementKind =
        ImmutableInvolvementKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build();
    ImmutableInvolvementKindUsageStat actualImmutableInvolvementKindUsageStat =
        actualBuilderResult.involvementKind(involvementKind).build();

    // Assert
    assertTrue(actualImmutableInvolvementKindUsageStat.breakdown().isEmpty());
    assertSame(involvementKind, actualImmutableInvolvementKindUsageStat.involvementKind());
  }

  /**
   * Test Builder {@link Builder#from(InvolvementKindUsageStat)}.
   *
   * <p>Method under test: {@link Builder#from(InvolvementKindUsageStat)}
   */
  @Test
  @DisplayName("Test Builder from(InvolvementKindUsageStat)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(InvolvementKindUsageStat)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableInvolvementKindUsageStat.builder();

    Builder builderResult2 = ImmutableInvolvementKindUsageStat.builder();
    ImmutableInvolvementKindUsageStat instance =
        builderResult2
            .involvementKind(
                ImmutableInvolvementKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .permittedRole("Permitted Role")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableInvolvementKindUsageStat actualImmutableInvolvementKindUsageStat =
        builderResult.build();
    assertEquals(instance, actualImmutableInvolvementKindUsageStat);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(InvolvementKindUsageStat)}.
   *
   * <p>Method under test: {@link Builder#from(InvolvementKindUsageStat)}
   */
  @Test
  @DisplayName("Test Builder from(InvolvementKindUsageStat)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(InvolvementKindUsageStat)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableInvolvementKindUsageStat.builder();

    Builder builderResult2 = ImmutableInvolvementKindUsageStat.builder();
    builderResult2.addBreakdown(
        ImmutableStat.builder()
            .entityKind(EntityKind.ALL)
            .isCountOfRemovedPeople(true)
            .personCount(3)
            .build());
    ImmutableInvolvementKindUsageStat instance =
        builderResult2
            .involvementKind(
                ImmutableInvolvementKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .permittedRole("Permitted Role")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableInvolvementKindUsageStat actualImmutableInvolvementKindUsageStat =
        builderResult.build();
    assertEquals(instance, actualImmutableInvolvementKindUsageStat);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#involvementKind(InvolvementKind)}.
   *
   * <ul>
   *   <li>When {@link ImmutableInvolvementKind.Json} (default constructor).
   *   <li>Then builder build involvementKind is {@link ImmutableInvolvementKind.Json} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link Builder#involvementKind(InvolvementKind)}
   */
  @Test
  @DisplayName(
      "Test Builder involvementKind(InvolvementKind); when Json (default constructor); then builder build involvementKind is Json (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.involvementKind(InvolvementKind)"})
  void testBuilderInvolvementKind_whenJson_thenBuilderBuildInvolvementKindIsJson() {
    // Arrange
    Builder builderResult = ImmutableInvolvementKindUsageStat.builder();
    ImmutableInvolvementKind.Json involvementKind = new ImmutableInvolvementKind.Json();

    // Act
    Builder actualInvolvementKindResult = builderResult.involvementKind(involvementKind);

    // Assert
    assertSame(involvementKind, builderResult.build().involvementKind());
    assertSame(builderResult, actualInvolvementKindResult);
  }

  /**
   * Test {@link ImmutableInvolvementKindUsageStat#copyOf(InvolvementKindUsageStat)}.
   *
   * <ul>
   *   <li>Then involvementKind return {@link ImmutableInvolvementKind}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableInvolvementKindUsageStat#copyOf(InvolvementKindUsageStat)}
   */
  @Test
  @DisplayName(
      "Test copyOf(InvolvementKindUsageStat); then involvementKind return ImmutableInvolvementKind")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableInvolvementKindUsageStat ImmutableInvolvementKindUsageStat.copyOf(InvolvementKindUsageStat)"
  })
  void testCopyOf_thenInvolvementKindReturnImmutableInvolvementKind() {
    // Arrange
    Builder builderResult = ImmutableInvolvementKindUsageStat.builder();

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    ImmutableInvolvementKindUsageStat instance =
        builderResult
            .involvementKind(
                ImmutableInvolvementKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(ofResult.atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .permittedRole("Permitted Role")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .build();

    // Act
    ImmutableInvolvementKindUsageStat actualCopyOfResult =
        ImmutableInvolvementKindUsageStat.copyOf(instance);

    // Assert
    InvolvementKind involvementKindResult = actualCopyOfResult.involvementKind();
    assertTrue(involvementKindResult instanceof ImmutableInvolvementKind);
    assertEquals("2020-03-01", involvementKindResult.lastUpdatedBy());
    assertEquals("Name", involvementKindResult.name());
    assertEquals("Permitted Role", involvementKindResult.permittedRole());
    assertEquals(
        "The characteristics of someone or something", involvementKindResult.description());
    assertEquals(EntityKind.ALL, involvementKindResult.kind());
    assertEquals(EntityKind.ALL, involvementKindResult.subjectKind());
    assertTrue(actualCopyOfResult.breakdown().isEmpty());
    assertTrue(involvementKindResult.transitive());
    assertTrue(involvementKindResult.userSelectable());
    assertSame(ofResult, involvementKindResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableInvolvementKindUsageStat#equals(Object)}, and {@link
   * ImmutableInvolvementKindUsageStat#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableInvolvementKindUsageStat#equals(Object)}
   *   <li>{@link ImmutableInvolvementKindUsageStat#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableInvolvementKindUsageStat.equals(Object)",
    "int ImmutableInvolvementKindUsageStat.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableInvolvementKindUsageStat.builder();
    ImmutableInvolvementKindUsageStat immutableInvolvementKindUsageStat =
        builderResult
            .involvementKind(
                ImmutableInvolvementKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .permittedRole("Permitted Role")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .build();

    Builder builderResult2 = ImmutableInvolvementKindUsageStat.builder();
    ImmutableInvolvementKindUsageStat immutableInvolvementKindUsageStat2 =
        builderResult2
            .involvementKind(
                ImmutableInvolvementKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .permittedRole("Permitted Role")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableInvolvementKindUsageStat, immutableInvolvementKindUsageStat2);
    assertEquals(
        immutableInvolvementKindUsageStat.hashCode(),
        immutableInvolvementKindUsageStat2.hashCode());
  }

  /**
   * Test {@link ImmutableInvolvementKindUsageStat#equals(Object)}, and {@link
   * ImmutableInvolvementKindUsageStat#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableInvolvementKindUsageStat#equals(Object)}
   *   <li>{@link ImmutableInvolvementKindUsageStat#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableInvolvementKindUsageStat.equals(Object)",
    "int ImmutableInvolvementKindUsageStat.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableInvolvementKindUsageStat.builder();
    ImmutableInvolvementKindUsageStat immutableInvolvementKindUsageStat =
        builderResult
            .involvementKind(
                ImmutableInvolvementKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .permittedRole("Permitted Role")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableInvolvementKindUsageStat, immutableInvolvementKindUsageStat);
    int expectedHashCodeResult = immutableInvolvementKindUsageStat.hashCode();
    assertEquals(expectedHashCodeResult, immutableInvolvementKindUsageStat.hashCode());
  }

  /**
   * Test {@link ImmutableInvolvementKindUsageStat#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvementKindUsageStat#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableInvolvementKindUsageStat.equals(Object)",
    "int ImmutableInvolvementKindUsageStat.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableInvolvementKindUsageStat.builder();
    builderResult.addBreakdown(
        ImmutableStat.builder()
            .entityKind(EntityKind.ALL)
            .isCountOfRemovedPeople(true)
            .personCount(3)
            .build());
    ImmutableInvolvementKindUsageStat immutableInvolvementKindUsageStat =
        builderResult
            .involvementKind(
                ImmutableInvolvementKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .permittedRole("Permitted Role")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .build();

    Builder builderResult2 = ImmutableInvolvementKindUsageStat.builder();

    // Act and Assert
    assertNotEquals(
        immutableInvolvementKindUsageStat,
        builderResult2
            .involvementKind(
                ImmutableInvolvementKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .permittedRole("Permitted Role")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableInvolvementKindUsageStat#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvementKindUsageStat#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableInvolvementKindUsageStat.equals(Object)",
    "int ImmutableInvolvementKindUsageStat.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableInvolvementKindUsageStat.builder();
    ImmutableInvolvementKindUsageStat immutableInvolvementKindUsageStat =
        builderResult
            .involvementKind(
                ImmutableInvolvementKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .permittedRole("Permitted Role")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .build();

    Builder builderResult2 = ImmutableInvolvementKindUsageStat.builder();

    // Act and Assert
    assertNotEquals(
        immutableInvolvementKindUsageStat,
        builderResult2
            .involvementKind(
                ImmutableInvolvementKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .permittedRole("Permitted Role")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableInvolvementKindUsageStat#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvementKindUsageStat#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableInvolvementKindUsageStat.equals(Object)",
    "int ImmutableInvolvementKindUsageStat.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableInvolvementKindUsageStat.builder();

    // Act and Assert
    assertNotEquals(
        builderResult
            .involvementKind(
                ImmutableInvolvementKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .permittedRole("Permitted Role")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableInvolvementKindUsageStat#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvementKindUsageStat#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableInvolvementKindUsageStat.equals(Object)",
    "int ImmutableInvolvementKindUsageStat.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableInvolvementKindUsageStat.builder();

    // Act and Assert
    assertNotEquals(
        builderResult
            .involvementKind(
                ImmutableInvolvementKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .permittedRole("Permitted Role")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .build(),
        "Different type to ImmutableInvolvementKindUsageStat");
  }

  /**
   * Test {@link ImmutableInvolvementKindUsageStat#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   *   <li>When {@link Json} (default constructor) Breakdown is {@link HashSet#HashSet()}.
   *   <li>Then return breakdown Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvementKindUsageStat#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given HashSet(); when Json (default constructor) Breakdown is HashSet(); then return breakdown Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableInvolvementKindUsageStat ImmutableInvolvementKindUsageStat.fromJson(Json)"
  })
  void testFromJson_givenHashSet_whenJsonBreakdownIsHashSet_thenReturnBreakdownEmpty() {
    // Arrange
    Json json = new Json();
    json.setBreakdown(new HashSet<>());
    ImmutableInvolvementKind.Json involvementKind = new ImmutableInvolvementKind.Json();
    json.setInvolvementKind(involvementKind);

    // Act
    ImmutableInvolvementKindUsageStat actualFromJsonResult =
        ImmutableInvolvementKindUsageStat.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.breakdown().isEmpty());
    assertSame(involvementKind, actualFromJsonResult.involvementKind());
  }

  /**
   * Test {@link ImmutableInvolvementKindUsageStat#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@link ImmutableStat.Json} (default
   *       constructor).
   *   <li>Then return breakdown size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvementKindUsageStat#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given LinkedHashSet() add Json (default constructor); then return breakdown size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableInvolvementKindUsageStat ImmutableInvolvementKindUsageStat.fromJson(Json)"
  })
  void testFromJson_givenLinkedHashSetAddJson_thenReturnBreakdownSizeIsOne() {
    // Arrange
    LinkedHashSet<Stat> breakdown = new LinkedHashSet<>();
    breakdown.add(new ImmutableStat.Json());

    Json json = new Json();
    json.setBreakdown(breakdown);
    ImmutableInvolvementKind.Json involvementKind = new ImmutableInvolvementKind.Json();
    json.setInvolvementKind(involvementKind);

    // Act
    ImmutableInvolvementKindUsageStat actualFromJsonResult =
        ImmutableInvolvementKindUsageStat.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.breakdown().size());
    assertSame(involvementKind, actualFromJsonResult.involvementKind());
  }

  /**
   * Test {@link ImmutableInvolvementKindUsageStat#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) Breakdown is {@code null}.
   *   <li>Then return breakdown Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvementKindUsageStat#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) Breakdown is 'null'; then return breakdown Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableInvolvementKindUsageStat ImmutableInvolvementKindUsageStat.fromJson(Json)"
  })
  void testFromJson_givenNull_whenJsonBreakdownIsNull_thenReturnBreakdownEmpty() {
    // Arrange
    Json json = new Json();
    json.setBreakdown(null);
    ImmutableInvolvementKind.Json involvementKind = new ImmutableInvolvementKind.Json();
    json.setInvolvementKind(involvementKind);

    // Act
    ImmutableInvolvementKindUsageStat actualFromJsonResult =
        ImmutableInvolvementKindUsageStat.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.breakdown().isEmpty());
    assertSame(involvementKind, actualFromJsonResult.involvementKind());
  }

  /**
   * Test {@link ImmutableInvolvementKindUsageStat#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return breakdown is {@link LinkedHashSet#LinkedHashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvementKindUsageStat#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return breakdown is LinkedHashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableInvolvementKindUsageStat ImmutableInvolvementKindUsageStat.fromJson(Json)"
  })
  void testFromJson_thenReturnBreakdownIsLinkedHashSet() {
    // Arrange
    LinkedHashSet<Stat> breakdown = new LinkedHashSet<>();
    breakdown.add(
        ImmutableStat.builder()
            .entityKind(EntityKind.ALL)
            .isCountOfRemovedPeople(true)
            .personCount(3)
            .build());
    breakdown.add(new ImmutableStat.Json());

    Json json = new Json();
    json.setBreakdown(breakdown);
    ImmutableInvolvementKind.Json involvementKind = new ImmutableInvolvementKind.Json();
    json.setInvolvementKind(involvementKind);

    // Act
    ImmutableInvolvementKindUsageStat actualFromJsonResult =
        ImmutableInvolvementKindUsageStat.fromJson(json);

    // Assert
    assertEquals(breakdown, actualFromJsonResult.breakdown());
    assertSame(involvementKind, actualFromJsonResult.involvementKind());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableInvolvementKindUsageStat#toString()}
   *   <li>{@link ImmutableInvolvementKindUsageStat#breakdown()}
   *   <li>{@link ImmutableInvolvementKindUsageStat#involvementKind()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ImmutableInvolvementKindUsageStat.breakdown()",
    "InvolvementKind ImmutableInvolvementKindUsageStat.involvementKind()",
    "String ImmutableInvolvementKindUsageStat.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableInvolvementKindUsageStat.builder();
    ImmutableInvolvementKindUsageStat immutableInvolvementKindUsageStat =
        builderResult
            .involvementKind(
                ImmutableInvolvementKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .permittedRole("Permitted Role")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .build();

    // Act
    String actualToStringResult = immutableInvolvementKindUsageStat.toString();
    Set<Stat> actualBreakdownResult = immutableInvolvementKindUsageStat.breakdown();

    // Assert
    assertTrue(
        immutableInvolvementKindUsageStat.involvementKind() instanceof ImmutableInvolvementKind);
    assertEquals(
        "InvolvementKindUsageStat{breakdown=[], involvementKind=InvolvementKind{id=1, name=Name, externalId=42,"
            + " lastUpdatedAt=1970-01-01T00:00, lastUpdatedBy=2020-03-01, kind=ALL, subjectKind=ALL, userSelectable=true,"
            + " permittedRole=Permitted Role, transitive=true}}",
        actualToStringResult);
    assertTrue(actualBreakdownResult.isEmpty());
  }

  /**
   * Test Json {@link Json#breakdown()}.
   *
   * <p>Method under test: {@link Json#breakdown()}
   */
  @Test
  @DisplayName("Test Json breakdown()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.breakdown()"})
  void testJsonBreakdown() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().breakdown());
  }

  /**
   * Test Json {@link Json#involvementKind()}.
   *
   * <p>Method under test: {@link Json#involvementKind()}
   */
  @Test
  @DisplayName("Test Json involvementKind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InvolvementKind Json.involvementKind()"})
  void testJsonInvolvementKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().involvementKind());
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
    assertNull(actualJson.involvementKind);
    assertTrue(actualJson.breakdown.isEmpty());
  }

  /**
   * Test {@link ImmutableInvolvementKindUsageStat#withBreakdown(Stat[])} with {@code Stat[]}.
   *
   * <p>Method under test: {@link ImmutableInvolvementKindUsageStat#withBreakdown(Stat[])}
   */
  @Test
  @DisplayName("Test withBreakdown(Stat[]) with 'Stat[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableInvolvementKindUsageStat ImmutableInvolvementKindUsageStat.withBreakdown(Stat[])"
  })
  void testWithBreakdownWithStat() {
    // Arrange
    Builder builderResult = ImmutableInvolvementKindUsageStat.builder();

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    ImmutableInvolvementKindUsageStat immutableInvolvementKindUsageStat =
        builderResult
            .involvementKind(
                ImmutableInvolvementKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(ofResult.atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .permittedRole("Permitted Role")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .build();

    // Act
    ImmutableInvolvementKindUsageStat actualWithBreakdownResult =
        immutableInvolvementKindUsageStat.withBreakdown(
            ImmutableStat.builder()
                .entityKind(EntityKind.ALL)
                .isCountOfRemovedPeople(true)
                .personCount(3)
                .build());

    // Assert
    InvolvementKind involvementKindResult = actualWithBreakdownResult.involvementKind();
    assertTrue(involvementKindResult instanceof ImmutableInvolvementKind);
    assertEquals("2020-03-01", involvementKindResult.lastUpdatedBy());
    assertEquals("Name", involvementKindResult.name());
    assertEquals("Permitted Role", involvementKindResult.permittedRole());
    assertEquals(
        "The characteristics of someone or something", involvementKindResult.description());
    assertEquals(1, actualWithBreakdownResult.breakdown().size());
    assertEquals(EntityKind.ALL, involvementKindResult.kind());
    assertEquals(EntityKind.ALL, involvementKindResult.subjectKind());
    assertTrue(involvementKindResult.transitive());
    assertTrue(involvementKindResult.userSelectable());
    assertSame(ofResult, involvementKindResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableInvolvementKindUsageStat#withInvolvementKind(InvolvementKind)}.
   *
   * <p>Method under test: {@link
   * ImmutableInvolvementKindUsageStat#withInvolvementKind(InvolvementKind)}
   */
  @Test
  @DisplayName("Test withInvolvementKind(InvolvementKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableInvolvementKindUsageStat ImmutableInvolvementKindUsageStat.withInvolvementKind(InvolvementKind)"
  })
  void testWithInvolvementKind() {
    // Arrange
    Builder builderResult = ImmutableInvolvementKindUsageStat.builder();
    ImmutableInvolvementKindUsageStat immutableInvolvementKindUsageStat =
        builderResult
            .involvementKind(
                ImmutableInvolvementKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .permittedRole("Permitted Role")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .build();

    // Act
    ImmutableInvolvementKindUsageStat actualWithInvolvementKindResult =
        immutableInvolvementKindUsageStat.withInvolvementKind(
            ImmutableInvolvementKind.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .permittedRole("Permitted Role")
                .subjectKind(EntityKind.ALL)
                .build());

    // Assert
    assertEquals(immutableInvolvementKindUsageStat, actualWithInvolvementKindResult);
  }
}
