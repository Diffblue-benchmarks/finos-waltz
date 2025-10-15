package org.finos.waltz.model.involvement_group;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import org.finos.waltz.model.involvement_group.ImmutableInvolvementGroupCreateCommand.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableInvolvementGroupCreateCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllInvolvementKindIds(Iterable)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllInvolvementKindIds(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllInvolvementKindIds(Iterable); given one; when LinkedHashSet() add one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllInvolvementKindIds(Iterable)"})
  void testBuilderAddAllInvolvementKindIds_givenOne_whenLinkedHashSetAddOne() {
    // Arrange
    Builder builderResult = ImmutableInvolvementGroupCreateCommand.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    Builder actualAddAllInvolvementKindIdsResult = builderResult.addAllInvolvementKindIds(elements);

    // Assert
    assertSame(builderResult, actualAddAllInvolvementKindIdsResult);
  }

  /**
   * Test Builder {@link Builder#addAllInvolvementKindIds(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllInvolvementKindIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllInvolvementKindIds(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllInvolvementKindIds(Iterable)"})
  void testBuilderAddAllInvolvementKindIds_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableInvolvementGroupCreateCommand.builder();

    // Act
    Builder actualAddAllInvolvementKindIdsResult =
        builderResult.addAllInvolvementKindIds(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllInvolvementKindIdsResult);
  }

  /**
   * Test Builder {@link Builder#addInvolvementKindIds(long)} with {@code element}.
   *
   * <p>Method under test: {@link Builder#addInvolvementKindIds(long)}
   */
  @Test
  @DisplayName("Test Builder addInvolvementKindIds(long) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addInvolvementKindIds(long)"})
  void testBuilderAddInvolvementKindIdsWithElement() {
    // Arrange
    Builder builderResult = ImmutableInvolvementGroupCreateCommand.builder();

    // Act
    Builder actualAddInvolvementKindIdsResult = builderResult.addInvolvementKindIds(1L);

    // Assert
    assertSame(builderResult, actualAddInvolvementKindIdsResult);
  }

  /**
   * Test Builder {@link Builder#addInvolvementKindIds(long[])} with {@code elements}.
   *
   * <p>Method under test: {@link Builder#addInvolvementKindIds(long[])}
   */
  @Test
  @DisplayName("Test Builder addInvolvementKindIds(long[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addInvolvementKindIds(long[])"})
  void testBuilderAddInvolvementKindIdsWithElements() {
    // Arrange
    Builder builderResult = ImmutableInvolvementGroupCreateCommand.builder();

    // Act
    Builder actualAddInvolvementKindIdsResult =
        builderResult.addInvolvementKindIds(1L, -2L, 1L, -2L);

    // Assert
    assertSame(builderResult, actualAddInvolvementKindIdsResult);
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
  @MethodsUnderTest({"ImmutableInvolvementGroupCreateCommand Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableInvolvementGroupCreateCommand.builder();
    Builder actualAddInvolvementKindIdsResult =
        actualBuilderResult
            .addAllInvolvementKindIds(new ArrayList<>())
            .addInvolvementKindIds(1L)
            .addInvolvementKindIds(1L, -2L, 1L, -2L);
    ImmutableInvolvementGroup involvementGroup =
        ImmutableInvolvementGroup.builder()
            .externalId("42")
            .id(1L)
            .name("Name")
            .provenance("Provenance")
            .build();
    Builder actualInvolvementGroupResult =
        actualAddInvolvementKindIdsResult.involvementGroup(involvementGroup);
    ImmutableInvolvementGroupCreateCommand actualImmutableInvolvementGroupCreateCommand =
        actualInvolvementGroupResult.build();

    // Assert
    Set<Long> involvementKindIdsResult =
        actualImmutableInvolvementGroupCreateCommand.involvementKindIds();
    assertEquals(2, involvementKindIdsResult.size());
    assertTrue(involvementKindIdsResult.contains(-2L));
    assertTrue(involvementKindIdsResult.contains(1L));
    assertSame(involvementGroup, actualImmutableInvolvementGroupCreateCommand.involvementGroup());
  }

  /**
   * Test Builder {@link Builder#from(InvolvementGroupCreateCommand)}.
   *
   * <p>Method under test: {@link Builder#from(InvolvementGroupCreateCommand)}
   */
  @Test
  @DisplayName("Test Builder from(InvolvementGroupCreateCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(InvolvementGroupCreateCommand)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableInvolvementGroupCreateCommand.builder();

    Builder builderResult2 = ImmutableInvolvementGroupCreateCommand.builder();

    Builder involvementGroupResult =
        builderResult2.involvementGroup(
            ImmutableInvolvementGroup.builder()
                .externalId("42")
                .id(1L)
                .name("Name")
                .provenance("Provenance")
                .build());
    ImmutableInvolvementGroupCreateCommand instance =
        involvementGroupResult.addAllInvolvementKindIds(new ArrayList<>()).build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableInvolvementGroupCreateCommand actualImmutableInvolvementGroupCreateCommand =
        builderResult.build();
    assertEquals(instance, actualImmutableInvolvementGroupCreateCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(InvolvementGroupCreateCommand)}.
   *
   * <ul>
   *   <li>Given minus two.
   *   <li>When builder addInvolvementKindIds minus two.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(InvolvementGroupCreateCommand)}
   */
  @Test
  @DisplayName(
      "Test Builder from(InvolvementGroupCreateCommand); given minus two; when builder addInvolvementKindIds minus two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(InvolvementGroupCreateCommand)"})
  void testBuilderFrom_givenMinusTwo_whenBuilderAddInvolvementKindIdsMinusTwo() {
    // Arrange
    Builder builderResult = ImmutableInvolvementGroupCreateCommand.builder();

    Builder builderResult2 = ImmutableInvolvementGroupCreateCommand.builder();
    builderResult2.addInvolvementKindIds(-2L);

    Builder involvementGroupResult =
        builderResult2.involvementGroup(
            ImmutableInvolvementGroup.builder()
                .externalId("42")
                .id(1L)
                .name("Name")
                .provenance("Provenance")
                .build());
    ImmutableInvolvementGroupCreateCommand instance =
        involvementGroupResult.addAllInvolvementKindIds(new ArrayList<>()).build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableInvolvementGroupCreateCommand actualImmutableInvolvementGroupCreateCommand =
        builderResult.build();
    assertEquals(instance, actualImmutableInvolvementGroupCreateCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#involvementGroup(InvolvementGroup)}.
   *
   * <p>Method under test: {@link Builder#involvementGroup(InvolvementGroup)}
   */
  @Test
  @DisplayName("Test Builder involvementGroup(InvolvementGroup)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.involvementGroup(InvolvementGroup)"})
  void testBuilderInvolvementGroup() {
    // Arrange
    Builder builderResult = ImmutableInvolvementGroupCreateCommand.builder();
    ImmutableInvolvementGroup involvementGroup =
        ImmutableInvolvementGroup.builder()
            .externalId("42")
            .id(1L)
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act
    Builder actualInvolvementGroupResult = builderResult.involvementGroup(involvementGroup);

    // Assert
    assertSame(involvementGroup, builderResult.build().involvementGroup());
    assertSame(builderResult, actualInvolvementGroupResult);
  }

  /**
   * Test Builder {@link Builder#involvementKindIds(Iterable)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#involvementKindIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder involvementKindIds(Iterable); given one; when LinkedHashSet() add one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.involvementKindIds(Iterable)"})
  void testBuilderInvolvementKindIds_givenOne_whenLinkedHashSetAddOne() {
    // Arrange
    Builder builderResult = ImmutableInvolvementGroupCreateCommand.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    Builder actualInvolvementKindIdsResult = builderResult.involvementKindIds(elements);

    // Assert
    assertSame(builderResult, actualInvolvementKindIdsResult);
  }

  /**
   * Test Builder {@link Builder#involvementKindIds(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#involvementKindIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder involvementKindIds(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.involvementKindIds(Iterable)"})
  void testBuilderInvolvementKindIds_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableInvolvementGroupCreateCommand.builder();

    // Act
    Builder actualInvolvementKindIdsResult = builderResult.involvementKindIds(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualInvolvementKindIdsResult);
  }

  /**
   * Test {@link ImmutableInvolvementGroupCreateCommand#copyOf(InvolvementGroupCreateCommand)}.
   *
   * <ul>
   *   <li>Then involvementGroup return {@link ImmutableInvolvementGroup}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableInvolvementGroupCreateCommand#copyOf(InvolvementGroupCreateCommand)}
   */
  @Test
  @DisplayName(
      "Test copyOf(InvolvementGroupCreateCommand); then involvementGroup return ImmutableInvolvementGroup")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableInvolvementGroupCreateCommand ImmutableInvolvementGroupCreateCommand.copyOf(InvolvementGroupCreateCommand)"
  })
  void testCopyOf_thenInvolvementGroupReturnImmutableInvolvementGroup() {
    // Arrange
    Builder builderResult = ImmutableInvolvementGroupCreateCommand.builder();

    Builder involvementGroupResult =
        builderResult.involvementGroup(
            ImmutableInvolvementGroup.builder()
                .externalId("42")
                .id(1L)
                .name("Name")
                .provenance("Provenance")
                .build());
    ImmutableInvolvementGroupCreateCommand instance =
        involvementGroupResult.addAllInvolvementKindIds(new ArrayList<>()).build();

    // Act
    ImmutableInvolvementGroupCreateCommand actualCopyOfResult =
        ImmutableInvolvementGroupCreateCommand.copyOf(instance);

    // Assert
    InvolvementGroup involvementGroupResult2 = actualCopyOfResult.involvementGroup();
    assertTrue(involvementGroupResult2 instanceof ImmutableInvolvementGroup);
    assertEquals("42", involvementGroupResult2.externalId());
    assertEquals("Name", involvementGroupResult2.name());
    assertEquals("Provenance", involvementGroupResult2.provenance());
    assertTrue(actualCopyOfResult.involvementKindIds().isEmpty());
  }

  /**
   * Test {@link ImmutableInvolvementGroupCreateCommand#equals(Object)}, and {@link
   * ImmutableInvolvementGroupCreateCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableInvolvementGroupCreateCommand#equals(Object)}
   *   <li>{@link ImmutableInvolvementGroupCreateCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableInvolvementGroupCreateCommand.equals(Object)",
    "int ImmutableInvolvementGroupCreateCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableInvolvementGroupCreateCommand.builder();

    Builder involvementGroupResult =
        builderResult.involvementGroup(
            ImmutableInvolvementGroup.builder()
                .externalId("42")
                .id(1L)
                .name("Name")
                .provenance("Provenance")
                .build());
    ImmutableInvolvementGroupCreateCommand immutableInvolvementGroupCreateCommand =
        involvementGroupResult.addAllInvolvementKindIds(new ArrayList<>()).build();

    Builder builderResult2 = ImmutableInvolvementGroupCreateCommand.builder();

    Builder involvementGroupResult2 =
        builderResult2.involvementGroup(
            ImmutableInvolvementGroup.builder()
                .externalId("42")
                .id(1L)
                .name("Name")
                .provenance("Provenance")
                .build());
    ImmutableInvolvementGroupCreateCommand immutableInvolvementGroupCreateCommand2 =
        involvementGroupResult2.addAllInvolvementKindIds(new ArrayList<>()).build();

    // Act and Assert
    assertEquals(immutableInvolvementGroupCreateCommand, immutableInvolvementGroupCreateCommand2);
    assertEquals(
        immutableInvolvementGroupCreateCommand.hashCode(),
        immutableInvolvementGroupCreateCommand2.hashCode());
  }

  /**
   * Test {@link ImmutableInvolvementGroupCreateCommand#equals(Object)}, and {@link
   * ImmutableInvolvementGroupCreateCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableInvolvementGroupCreateCommand#equals(Object)}
   *   <li>{@link ImmutableInvolvementGroupCreateCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableInvolvementGroupCreateCommand.equals(Object)",
    "int ImmutableInvolvementGroupCreateCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableInvolvementGroupCreateCommand.builder();

    Builder involvementGroupResult =
        builderResult.involvementGroup(
            ImmutableInvolvementGroup.builder()
                .externalId("42")
                .id(1L)
                .name("Name")
                .provenance("Provenance")
                .build());
    ImmutableInvolvementGroupCreateCommand immutableInvolvementGroupCreateCommand =
        involvementGroupResult.addAllInvolvementKindIds(new ArrayList<>()).build();

    // Act and Assert
    assertEquals(immutableInvolvementGroupCreateCommand, immutableInvolvementGroupCreateCommand);
    int expectedHashCodeResult = immutableInvolvementGroupCreateCommand.hashCode();
    assertEquals(expectedHashCodeResult, immutableInvolvementGroupCreateCommand.hashCode());
  }

  /**
   * Test {@link ImmutableInvolvementGroupCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvementGroupCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableInvolvementGroupCreateCommand.equals(Object)",
    "int ImmutableInvolvementGroupCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableInvolvementGroupCreateCommand.builder();
    builderResult.addInvolvementKindIds(1L);

    Builder involvementGroupResult =
        builderResult.involvementGroup(
            ImmutableInvolvementGroup.builder()
                .externalId("42")
                .id(1L)
                .name("Name")
                .provenance("Provenance")
                .build());
    ImmutableInvolvementGroupCreateCommand immutableInvolvementGroupCreateCommand =
        involvementGroupResult.addAllInvolvementKindIds(new ArrayList<>()).build();

    Builder builderResult2 = ImmutableInvolvementGroupCreateCommand.builder();

    Builder involvementGroupResult2 =
        builderResult2.involvementGroup(
            ImmutableInvolvementGroup.builder()
                .externalId("42")
                .id(1L)
                .name("Name")
                .provenance("Provenance")
                .build());

    // Act and Assert
    assertNotEquals(
        immutableInvolvementGroupCreateCommand,
        involvementGroupResult2.addAllInvolvementKindIds(new ArrayList<>()).build());
  }

  /**
   * Test {@link ImmutableInvolvementGroupCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvementGroupCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableInvolvementGroupCreateCommand.equals(Object)",
    "int ImmutableInvolvementGroupCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableInvolvementGroupCreateCommand.builder();

    Builder involvementGroupResult =
        builderResult.involvementGroup(
            ImmutableInvolvementGroup.builder()
                .externalId("Name")
                .id(1L)
                .name("Name")
                .provenance("Provenance")
                .build());
    ImmutableInvolvementGroupCreateCommand immutableInvolvementGroupCreateCommand =
        involvementGroupResult.addAllInvolvementKindIds(new ArrayList<>()).build();

    Builder builderResult2 = ImmutableInvolvementGroupCreateCommand.builder();

    Builder involvementGroupResult2 =
        builderResult2.involvementGroup(
            ImmutableInvolvementGroup.builder()
                .externalId("42")
                .id(1L)
                .name("Name")
                .provenance("Provenance")
                .build());

    // Act and Assert
    assertNotEquals(
        immutableInvolvementGroupCreateCommand,
        involvementGroupResult2.addAllInvolvementKindIds(new ArrayList<>()).build());
  }

  /**
   * Test {@link ImmutableInvolvementGroupCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvementGroupCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableInvolvementGroupCreateCommand.equals(Object)",
    "int ImmutableInvolvementGroupCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableInvolvementGroupCreateCommand.builder();

    Builder involvementGroupResult =
        builderResult.involvementGroup(
            ImmutableInvolvementGroup.builder()
                .externalId("42")
                .id(1L)
                .name("Name")
                .provenance("Provenance")
                .build());

    // Act and Assert
    assertNotEquals(
        involvementGroupResult.addAllInvolvementKindIds(new ArrayList<>()).build(), null);
  }

  /**
   * Test {@link ImmutableInvolvementGroupCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvementGroupCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableInvolvementGroupCreateCommand.equals(Object)",
    "int ImmutableInvolvementGroupCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableInvolvementGroupCreateCommand.builder();

    Builder involvementGroupResult =
        builderResult.involvementGroup(
            ImmutableInvolvementGroup.builder()
                .externalId("42")
                .id(1L)
                .name("Name")
                .provenance("Provenance")
                .build());

    // Act and Assert
    assertNotEquals(
        involvementGroupResult.addAllInvolvementKindIds(new ArrayList<>()).build(),
        "Different type to ImmutableInvolvementGroupCreateCommand");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableInvolvementGroupCreateCommand#toString()}
   *   <li>{@link ImmutableInvolvementGroupCreateCommand#involvementGroup()}
   *   <li>{@link ImmutableInvolvementGroupCreateCommand#involvementKindIds()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "InvolvementGroup ImmutableInvolvementGroupCreateCommand.involvementGroup()",
    "Set ImmutableInvolvementGroupCreateCommand.involvementKindIds()",
    "String ImmutableInvolvementGroupCreateCommand.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableInvolvementGroupCreateCommand.builder();

    Builder involvementGroupResult =
        builderResult.involvementGroup(
            ImmutableInvolvementGroup.builder()
                .externalId("42")
                .id(1L)
                .name("Name")
                .provenance("Provenance")
                .build());
    ImmutableInvolvementGroupCreateCommand immutableInvolvementGroupCreateCommand =
        involvementGroupResult.addAllInvolvementKindIds(new ArrayList<>()).build();

    // Act
    String actualToStringResult = immutableInvolvementGroupCreateCommand.toString();
    InvolvementGroup actualInvolvementGroupResult =
        immutableInvolvementGroupCreateCommand.involvementGroup();

    // Assert
    assertTrue(actualInvolvementGroupResult instanceof ImmutableInvolvementGroup);
    assertEquals(
        "InvolvementGroupCreateCommand{involvementGroup=InvolvementGroup{id=1, name=Name, provenance=Provenance,"
            + " externalId=42}, involvementKindIds=[]}",
        actualToStringResult);
    assertTrue(immutableInvolvementGroupCreateCommand.involvementKindIds().isEmpty());
  }

  /**
   * Test {@link ImmutableInvolvementGroupCreateCommand#withInvolvementGroup(InvolvementGroup)}.
   *
   * <p>Method under test: {@link
   * ImmutableInvolvementGroupCreateCommand#withInvolvementGroup(InvolvementGroup)}
   */
  @Test
  @DisplayName("Test withInvolvementGroup(InvolvementGroup)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableInvolvementGroupCreateCommand ImmutableInvolvementGroupCreateCommand.withInvolvementGroup(InvolvementGroup)"
  })
  void testWithInvolvementGroup() {
    // Arrange
    Builder builderResult = ImmutableInvolvementGroupCreateCommand.builder();

    Builder involvementGroupResult =
        builderResult.involvementGroup(
            ImmutableInvolvementGroup.builder()
                .externalId("42")
                .id(1L)
                .name("Name")
                .provenance("Provenance")
                .build());
    ImmutableInvolvementGroupCreateCommand immutableInvolvementGroupCreateCommand =
        involvementGroupResult.addAllInvolvementKindIds(new ArrayList<>()).build();

    // Act
    ImmutableInvolvementGroupCreateCommand actualWithInvolvementGroupResult =
        immutableInvolvementGroupCreateCommand.withInvolvementGroup(
            ImmutableInvolvementGroup.builder()
                .externalId("42")
                .id(1L)
                .name("Name")
                .provenance("Provenance")
                .build());

    // Assert
    assertEquals(immutableInvolvementGroupCreateCommand, actualWithInvolvementGroupResult);
  }

  /**
   * Test {@link ImmutableInvolvementGroupCreateCommand#withInvolvementKindIds(Iterable)} with
   * {@code Iterable}.
   *
   * <p>Method under test: {@link
   * ImmutableInvolvementGroupCreateCommand#withInvolvementKindIds(Iterable)}
   */
  @Test
  @DisplayName("Test withInvolvementKindIds(Iterable) with 'Iterable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableInvolvementGroupCreateCommand ImmutableInvolvementGroupCreateCommand.withInvolvementKindIds(Iterable)"
  })
  void testWithInvolvementKindIdsWithIterable() {
    // Arrange
    Builder builderResult = ImmutableInvolvementGroupCreateCommand.builder();

    Builder involvementGroupResult =
        builderResult.involvementGroup(
            ImmutableInvolvementGroup.builder()
                .externalId("42")
                .id(1L)
                .name("Name")
                .provenance("Provenance")
                .build());
    ImmutableInvolvementGroupCreateCommand immutableInvolvementGroupCreateCommand =
        involvementGroupResult.addAllInvolvementKindIds(new ArrayList<>()).build();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    ImmutableInvolvementGroupCreateCommand actualWithInvolvementKindIdsResult =
        immutableInvolvementGroupCreateCommand.withInvolvementKindIds(elements);

    // Assert
    InvolvementGroup involvementGroupResult2 =
        actualWithInvolvementKindIdsResult.involvementGroup();
    assertTrue(involvementGroupResult2 instanceof ImmutableInvolvementGroup);
    assertEquals("42", involvementGroupResult2.externalId());
    assertEquals("Name", involvementGroupResult2.name());
    assertEquals("Provenance", involvementGroupResult2.provenance());
    assertEquals(elements, actualWithInvolvementKindIdsResult.involvementKindIds());
  }

  /**
   * Test {@link ImmutableInvolvementGroupCreateCommand#withInvolvementKindIds(long[])} with {@code
   * long[]}.
   *
   * <p>Method under test: {@link
   * ImmutableInvolvementGroupCreateCommand#withInvolvementKindIds(long[])}
   */
  @Test
  @DisplayName("Test withInvolvementKindIds(long[]) with 'long[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableInvolvementGroupCreateCommand ImmutableInvolvementGroupCreateCommand.withInvolvementKindIds(long[])"
  })
  void testWithInvolvementKindIdsWithLong() {
    // Arrange
    Builder builderResult = ImmutableInvolvementGroupCreateCommand.builder();

    Builder involvementGroupResult =
        builderResult.involvementGroup(
            ImmutableInvolvementGroup.builder()
                .externalId("42")
                .id(1L)
                .name("Name")
                .provenance("Provenance")
                .build());

    // Act
    ImmutableInvolvementGroupCreateCommand actualWithInvolvementKindIdsResult =
        involvementGroupResult
            .addAllInvolvementKindIds(new ArrayList<>())
            .build()
            .withInvolvementKindIds(1L, -1L, 1L, -1L);

    // Assert
    InvolvementGroup involvementGroupResult2 =
        actualWithInvolvementKindIdsResult.involvementGroup();
    assertTrue(involvementGroupResult2 instanceof ImmutableInvolvementGroup);
    assertEquals("42", involvementGroupResult2.externalId());
    assertEquals("Name", involvementGroupResult2.name());
    assertEquals("Provenance", involvementGroupResult2.provenance());
    Set<Long> involvementKindIdsResult = actualWithInvolvementKindIdsResult.involvementKindIds();
    assertEquals(2, involvementKindIdsResult.size());
    assertTrue(involvementKindIdsResult.contains(-1L));
    assertTrue(involvementKindIdsResult.contains(1L));
  }
}
