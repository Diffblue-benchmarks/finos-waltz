package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import org.finos.waltz.model.survey.ImmutableSurveyInstanceRecipientsAndOwners.Builder;
import org.finos.waltz.model.survey.ImmutableSurveyInstanceRecipientsAndOwners.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSurveyInstanceRecipientsAndOwnersDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllOwnerPersonIds(Iterable)}.
   *
   * <ul>
   *   <li>Then builder build ownerPersonIds is {@link LinkedHashSet#LinkedHashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllOwnerPersonIds(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllOwnerPersonIds(Iterable); then builder build ownerPersonIds is LinkedHashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllOwnerPersonIds(Iterable)"})
  void testBuilderAddAllOwnerPersonIds_thenBuilderBuildOwnerPersonIdsIsLinkedHashSet() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceRecipientsAndOwners.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    Builder actualAddAllOwnerPersonIdsResult = builderResult.addAllOwnerPersonIds(elements);

    // Assert
    assertEquals(elements, builderResult.build().ownerPersonIds());
    assertSame(builderResult, actualAddAllOwnerPersonIdsResult);
  }

  /**
   * Test Builder {@link Builder#addAllOwnerPersonIds(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllOwnerPersonIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllOwnerPersonIds(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllOwnerPersonIds(Iterable)"})
  void testBuilderAddAllOwnerPersonIds_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceRecipientsAndOwners.builder();

    // Act
    Builder actualAddAllOwnerPersonIdsResult =
        builderResult.addAllOwnerPersonIds(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllOwnerPersonIdsResult);
  }

  /**
   * Test Builder {@link Builder#addAllRecipientPersonIds(Iterable)}.
   *
   * <p>Method under test: {@link Builder#addAllRecipientPersonIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllRecipientPersonIds(Iterable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllRecipientPersonIds(Iterable)"})
  void testBuilderAddAllRecipientPersonIds() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceRecipientsAndOwners.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    Builder actualAddAllRecipientPersonIdsResult = builderResult.addAllRecipientPersonIds(elements);

    // Assert
    assertEquals(elements, builderResult.build().recipientPersonIds());
    assertSame(builderResult, actualAddAllRecipientPersonIdsResult);
  }

  /**
   * Test Builder {@link Builder#addAllRecipientPersonIds(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllRecipientPersonIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllRecipientPersonIds(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllRecipientPersonIds(Iterable)"})
  void testBuilderAddAllRecipientPersonIds_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceRecipientsAndOwners.builder();

    // Act
    Builder actualAddAllRecipientPersonIdsResult =
        builderResult.addAllRecipientPersonIds(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllRecipientPersonIdsResult);
  }

  /**
   * Test Builder {@link Builder#addOwnerPersonIds(long)} with {@code element}.
   *
   * <p>Method under test: {@link Builder#addOwnerPersonIds(long)}
   */
  @Test
  @DisplayName("Test Builder addOwnerPersonIds(long) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addOwnerPersonIds(long)"})
  void testBuilderAddOwnerPersonIdsWithElement() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceRecipientsAndOwners.builder();

    // Act
    Builder actualAddOwnerPersonIdsResult = builderResult.addOwnerPersonIds(1L);

    // Assert
    Set<Long> ownerPersonIdsResult = builderResult.build().ownerPersonIds();
    assertEquals(1, ownerPersonIdsResult.size());
    assertTrue(ownerPersonIdsResult.contains(1L));
    assertSame(builderResult, actualAddOwnerPersonIdsResult);
  }

  /**
   * Test Builder {@link Builder#addOwnerPersonIds(long[])} with {@code elements}.
   *
   * <p>Method under test: {@link Builder#addOwnerPersonIds(long[])}
   */
  @Test
  @DisplayName("Test Builder addOwnerPersonIds(long[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addOwnerPersonIds(long[])"})
  void testBuilderAddOwnerPersonIdsWithElements() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceRecipientsAndOwners.builder();

    // Act
    Builder actualAddOwnerPersonIdsResult = builderResult.addOwnerPersonIds(1L, -1L, 1L, -1L);

    // Assert
    Set<Long> ownerPersonIdsResult = builderResult.build().ownerPersonIds();
    assertEquals(2, ownerPersonIdsResult.size());
    assertTrue(ownerPersonIdsResult.contains(-1L));
    assertTrue(ownerPersonIdsResult.contains(1L));
    assertSame(builderResult, actualAddOwnerPersonIdsResult);
  }

  /**
   * Test Builder {@link Builder#addRecipientPersonIds(long)} with {@code element}.
   *
   * <p>Method under test: {@link Builder#addRecipientPersonIds(long)}
   */
  @Test
  @DisplayName("Test Builder addRecipientPersonIds(long) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addRecipientPersonIds(long)"})
  void testBuilderAddRecipientPersonIdsWithElement() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceRecipientsAndOwners.builder();

    // Act
    Builder actualAddRecipientPersonIdsResult = builderResult.addRecipientPersonIds(1L);

    // Assert
    Set<Long> recipientPersonIdsResult = builderResult.build().recipientPersonIds();
    assertEquals(1, recipientPersonIdsResult.size());
    assertTrue(recipientPersonIdsResult.contains(1L));
    assertSame(builderResult, actualAddRecipientPersonIdsResult);
  }

  /**
   * Test Builder {@link Builder#addRecipientPersonIds(long[])} with {@code elements}.
   *
   * <p>Method under test: {@link Builder#addRecipientPersonIds(long[])}
   */
  @Test
  @DisplayName("Test Builder addRecipientPersonIds(long[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addRecipientPersonIds(long[])"})
  void testBuilderAddRecipientPersonIdsWithElements() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceRecipientsAndOwners.builder();

    // Act
    Builder actualAddRecipientPersonIdsResult =
        builderResult.addRecipientPersonIds(1L, -1L, 1L, -1L);

    // Assert
    Set<Long> recipientPersonIdsResult = builderResult.build().recipientPersonIds();
    assertEquals(2, recipientPersonIdsResult.size());
    assertTrue(recipientPersonIdsResult.contains(-1L));
    assertTrue(recipientPersonIdsResult.contains(1L));
    assertSame(builderResult, actualAddRecipientPersonIdsResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#ownerId(String)}
   *   <li>{@link Builder#owningRole(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceRecipientsAndOwners Builder.build()",
    "Builder Builder.ownerId(String)",
    "Builder Builder.owningRole(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableSurveyInstanceRecipientsAndOwners actualImmutableSurveyInstanceRecipientsAndOwners =
        ImmutableSurveyInstanceRecipientsAndOwners.builder()
            .ownerId("42")
            .owningRole("Owning Role")
            .build();

    // Assert
    assertEquals("42", actualImmutableSurveyInstanceRecipientsAndOwners.ownerId());
    assertEquals("Owning Role", actualImmutableSurveyInstanceRecipientsAndOwners.owningRole());
    assertTrue(actualImmutableSurveyInstanceRecipientsAndOwners.ownerPersonIds().isEmpty());
  }

  /**
   * Test Builder {@link Builder#from(SurveyInstanceRecipientsAndOwners)}.
   *
   * <ul>
   *   <li>Then builder build is builder ownerId {@code 42} owningRole {@code Owning Role} build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(SurveyInstanceRecipientsAndOwners)}
   */
  @Test
  @DisplayName(
      "Test Builder from(SurveyInstanceRecipientsAndOwners); then builder build is builder ownerId '42' owningRole 'Owning Role' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SurveyInstanceRecipientsAndOwners)"})
  void testBuilderFrom_thenBuilderBuildIsBuilderOwnerId42OwningRoleOwningRoleBuild() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceRecipientsAndOwners.builder();

    Builder builderResult2 = ImmutableSurveyInstanceRecipientsAndOwners.builder();
    builderResult2.addOwnerPersonIds(0L);
    builderResult2.addRecipientPersonIds(1L);
    ImmutableSurveyInstanceRecipientsAndOwners instance =
        builderResult2.ownerId("42").owningRole("Owning Role").build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableSurveyInstanceRecipientsAndOwners actualImmutableSurveyInstanceRecipientsAndOwners =
        builderResult.build();
    assertEquals(instance, actualImmutableSurveyInstanceRecipientsAndOwners);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SurveyInstanceRecipientsAndOwners)}.
   *
   * <ul>
   *   <li>Then return build is builder ownerId {@code 42} owningRole {@code null} build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(SurveyInstanceRecipientsAndOwners)}
   */
  @Test
  @DisplayName(
      "Test Builder from(SurveyInstanceRecipientsAndOwners); then return build is builder ownerId '42' owningRole 'null' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SurveyInstanceRecipientsAndOwners)"})
  void testBuilderFrom_thenReturnBuildIsBuilderOwnerId42OwningRoleNullBuild() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceRecipientsAndOwners.builder();
    ImmutableSurveyInstanceRecipientsAndOwners instance =
        ImmutableSurveyInstanceRecipientsAndOwners.builder().ownerId("42").owningRole(null).build();

    // Act and Assert
    ImmutableSurveyInstanceRecipientsAndOwners actualImmutableSurveyInstanceRecipientsAndOwners =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableSurveyInstanceRecipientsAndOwners);
    ImmutableSurveyInstanceRecipientsAndOwners actualImmutableSurveyInstanceRecipientsAndOwners2 =
        builderResult.build();
    assertEquals(instance, actualImmutableSurveyInstanceRecipientsAndOwners2);
  }

  /**
   * Test Builder {@link Builder#from(SurveyInstanceRecipientsAndOwners)}.
   *
   * <ul>
   *   <li>Then return build is builder ownerId {@code 42} owningRole {@code Owning Role} build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(SurveyInstanceRecipientsAndOwners)}
   */
  @Test
  @DisplayName(
      "Test Builder from(SurveyInstanceRecipientsAndOwners); then return build is builder ownerId '42' owningRole 'Owning Role' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SurveyInstanceRecipientsAndOwners)"})
  void testBuilderFrom_thenReturnBuildIsBuilderOwnerId42OwningRoleOwningRoleBuild() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceRecipientsAndOwners.builder();
    ImmutableSurveyInstanceRecipientsAndOwners instance =
        ImmutableSurveyInstanceRecipientsAndOwners.builder()
            .ownerId("42")
            .owningRole("Owning Role")
            .build();

    // Act and Assert
    ImmutableSurveyInstanceRecipientsAndOwners actualImmutableSurveyInstanceRecipientsAndOwners =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableSurveyInstanceRecipientsAndOwners);
  }

  /**
   * Test Builder {@link Builder#from(SurveyInstanceRecipientsAndOwners)}.
   *
   * <ul>
   *   <li>Then return build is builder ownerId {@code 42} owningRole {@code Owning Role} build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(SurveyInstanceRecipientsAndOwners)}
   */
  @Test
  @DisplayName(
      "Test Builder from(SurveyInstanceRecipientsAndOwners); then return build is builder ownerId '42' owningRole 'Owning Role' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SurveyInstanceRecipientsAndOwners)"})
  void testBuilderFrom_thenReturnBuildIsBuilderOwnerId42OwningRoleOwningRoleBuild2() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceRecipientsAndOwners.builder();

    Builder builderResult2 = ImmutableSurveyInstanceRecipientsAndOwners.builder();
    builderResult2.addRecipientPersonIds(1L);
    ImmutableSurveyInstanceRecipientsAndOwners instance =
        builderResult2.ownerId("42").owningRole("Owning Role").build();

    // Act and Assert
    ImmutableSurveyInstanceRecipientsAndOwners actualImmutableSurveyInstanceRecipientsAndOwners =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableSurveyInstanceRecipientsAndOwners);
  }

  /**
   * Test Builder {@link Builder#from(SurveyInstanceRecipientsAndOwners)}.
   *
   * <ul>
   *   <li>Then return build is builder ownerId {@code null} owningRole {@code Owning Role} build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(SurveyInstanceRecipientsAndOwners)}
   */
  @Test
  @DisplayName(
      "Test Builder from(SurveyInstanceRecipientsAndOwners); then return build is builder ownerId 'null' owningRole 'Owning Role' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SurveyInstanceRecipientsAndOwners)"})
  void testBuilderFrom_thenReturnBuildIsBuilderOwnerIdNullOwningRoleOwningRoleBuild() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceRecipientsAndOwners.builder();
    ImmutableSurveyInstanceRecipientsAndOwners instance =
        ImmutableSurveyInstanceRecipientsAndOwners.builder()
            .ownerId(null)
            .owningRole("Owning Role")
            .build();

    // Act and Assert
    ImmutableSurveyInstanceRecipientsAndOwners actualImmutableSurveyInstanceRecipientsAndOwners =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableSurveyInstanceRecipientsAndOwners);
    ImmutableSurveyInstanceRecipientsAndOwners actualImmutableSurveyInstanceRecipientsAndOwners2 =
        builderResult.build();
    assertEquals(instance, actualImmutableSurveyInstanceRecipientsAndOwners2);
  }

  /**
   * Test Builder {@link Builder#ownerPersonIds(Iterable)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then builder build ownerPersonIds is {@link LinkedHashSet#LinkedHashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#ownerPersonIds(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder ownerPersonIds(Iterable); given one; then builder build ownerPersonIds is LinkedHashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.ownerPersonIds(Iterable)"})
  void testBuilderOwnerPersonIds_givenOne_thenBuilderBuildOwnerPersonIdsIsLinkedHashSet() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceRecipientsAndOwners.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    Builder actualOwnerPersonIdsResult = builderResult.ownerPersonIds(elements);

    // Assert
    assertEquals(elements, builderResult.build().ownerPersonIds());
    assertSame(builderResult, actualOwnerPersonIdsResult);
  }

  /**
   * Test Builder {@link Builder#ownerPersonIds(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#ownerPersonIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder ownerPersonIds(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.ownerPersonIds(Iterable)"})
  void testBuilderOwnerPersonIds_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceRecipientsAndOwners.builder();

    // Act
    Builder actualOwnerPersonIdsResult = builderResult.ownerPersonIds(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualOwnerPersonIdsResult);
  }

  /**
   * Test Builder {@link Builder#recipientPersonIds(Iterable)}.
   *
   * <ul>
   *   <li>Then builder build recipientPersonIds is {@link LinkedHashSet#LinkedHashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#recipientPersonIds(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder recipientPersonIds(Iterable); then builder build recipientPersonIds is LinkedHashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.recipientPersonIds(Iterable)"})
  void testBuilderRecipientPersonIds_thenBuilderBuildRecipientPersonIdsIsLinkedHashSet() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceRecipientsAndOwners.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    Builder actualRecipientPersonIdsResult = builderResult.recipientPersonIds(elements);

    // Assert
    assertEquals(elements, builderResult.build().recipientPersonIds());
    assertSame(builderResult, actualRecipientPersonIdsResult);
  }

  /**
   * Test Builder {@link Builder#recipientPersonIds(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#recipientPersonIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder recipientPersonIds(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.recipientPersonIds(Iterable)"})
  void testBuilderRecipientPersonIds_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceRecipientsAndOwners.builder();

    // Act
    Builder actualRecipientPersonIdsResult = builderResult.recipientPersonIds(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualRecipientPersonIdsResult);
  }

  /**
   * Test {@link
   * ImmutableSurveyInstanceRecipientsAndOwners#copyOf(SurveyInstanceRecipientsAndOwners)}.
   *
   * <ul>
   *   <li>When builder ownerId {@code 42} owningRole {@code Owning Role} build.
   *   <li>Then return ownerId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableSurveyInstanceRecipientsAndOwners#copyOf(SurveyInstanceRecipientsAndOwners)}
   */
  @Test
  @DisplayName(
      "Test copyOf(SurveyInstanceRecipientsAndOwners); when builder ownerId '42' owningRole 'Owning Role' build; then return ownerId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceRecipientsAndOwners ImmutableSurveyInstanceRecipientsAndOwners.copyOf(SurveyInstanceRecipientsAndOwners)"
  })
  void testCopyOf_whenBuilderOwnerId42OwningRoleOwningRoleBuild_thenReturnOwnerIdIs42() {
    // Arrange
    ImmutableSurveyInstanceRecipientsAndOwners instance =
        ImmutableSurveyInstanceRecipientsAndOwners.builder()
            .ownerId("42")
            .owningRole("Owning Role")
            .build();

    // Act
    ImmutableSurveyInstanceRecipientsAndOwners actualCopyOfResult =
        ImmutableSurveyInstanceRecipientsAndOwners.copyOf(instance);

    // Assert
    assertEquals("42", actualCopyOfResult.ownerId());
    assertEquals("Owning Role", actualCopyOfResult.owningRole());
    Set<Long> ownerPersonIdsResult = actualCopyOfResult.ownerPersonIds();
    assertTrue(ownerPersonIdsResult.isEmpty());
    assertSame(ownerPersonIdsResult, actualCopyOfResult.recipientPersonIds());
  }

  /**
   * Test {@link ImmutableSurveyInstanceRecipientsAndOwners#equals(Object)}, and {@link
   * ImmutableSurveyInstanceRecipientsAndOwners#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyInstanceRecipientsAndOwners#equals(Object)}
   *   <li>{@link ImmutableSurveyInstanceRecipientsAndOwners#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceRecipientsAndOwners.equals(Object)",
    "int ImmutableSurveyInstanceRecipientsAndOwners.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableSurveyInstanceRecipientsAndOwners immutableSurveyInstanceRecipientsAndOwners =
        ImmutableSurveyInstanceRecipientsAndOwners.builder()
            .ownerId("42")
            .owningRole("Owning Role")
            .build();
    ImmutableSurveyInstanceRecipientsAndOwners immutableSurveyInstanceRecipientsAndOwners2 =
        ImmutableSurveyInstanceRecipientsAndOwners.builder()
            .ownerId("42")
            .owningRole("Owning Role")
            .build();

    // Act and Assert
    assertEquals(
        immutableSurveyInstanceRecipientsAndOwners, immutableSurveyInstanceRecipientsAndOwners2);
    assertEquals(
        immutableSurveyInstanceRecipientsAndOwners.hashCode(),
        immutableSurveyInstanceRecipientsAndOwners2.hashCode());
  }

  /**
   * Test {@link ImmutableSurveyInstanceRecipientsAndOwners#equals(Object)}, and {@link
   * ImmutableSurveyInstanceRecipientsAndOwners#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyInstanceRecipientsAndOwners#equals(Object)}
   *   <li>{@link ImmutableSurveyInstanceRecipientsAndOwners#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceRecipientsAndOwners.equals(Object)",
    "int ImmutableSurveyInstanceRecipientsAndOwners.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableSurveyInstanceRecipientsAndOwners immutableSurveyInstanceRecipientsAndOwners =
        ImmutableSurveyInstanceRecipientsAndOwners.builder()
            .ownerId("42")
            .owningRole("Owning Role")
            .build();

    // Act and Assert
    assertEquals(
        immutableSurveyInstanceRecipientsAndOwners, immutableSurveyInstanceRecipientsAndOwners);
    int expectedHashCodeResult = immutableSurveyInstanceRecipientsAndOwners.hashCode();
    assertEquals(expectedHashCodeResult, immutableSurveyInstanceRecipientsAndOwners.hashCode());
  }

  /**
   * Test {@link ImmutableSurveyInstanceRecipientsAndOwners#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceRecipientsAndOwners#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceRecipientsAndOwners.equals(Object)",
    "int ImmutableSurveyInstanceRecipientsAndOwners.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceRecipientsAndOwners.builder();
    builderResult.addRecipientPersonIds(1L);
    ImmutableSurveyInstanceRecipientsAndOwners immutableSurveyInstanceRecipientsAndOwners =
        builderResult.ownerId("42").owningRole("Owning Role").build();

    // Act and Assert
    assertNotEquals(
        immutableSurveyInstanceRecipientsAndOwners,
        ImmutableSurveyInstanceRecipientsAndOwners.builder()
            .ownerId("42")
            .owningRole("Owning Role")
            .build());
  }

  /**
   * Test {@link ImmutableSurveyInstanceRecipientsAndOwners#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceRecipientsAndOwners#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceRecipientsAndOwners.equals(Object)",
    "int ImmutableSurveyInstanceRecipientsAndOwners.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceRecipientsAndOwners.builder();
    builderResult.addOwnerPersonIds(1L);
    ImmutableSurveyInstanceRecipientsAndOwners immutableSurveyInstanceRecipientsAndOwners =
        builderResult.ownerId("42").owningRole("Owning Role").build();

    // Act and Assert
    assertNotEquals(
        immutableSurveyInstanceRecipientsAndOwners,
        ImmutableSurveyInstanceRecipientsAndOwners.builder()
            .ownerId("42")
            .owningRole("Owning Role")
            .build());
  }

  /**
   * Test {@link ImmutableSurveyInstanceRecipientsAndOwners#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceRecipientsAndOwners#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceRecipientsAndOwners.equals(Object)",
    "int ImmutableSurveyInstanceRecipientsAndOwners.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableSurveyInstanceRecipientsAndOwners immutableSurveyInstanceRecipientsAndOwners =
        ImmutableSurveyInstanceRecipientsAndOwners.builder()
            .ownerId("Owner Id")
            .owningRole("Owning Role")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableSurveyInstanceRecipientsAndOwners,
        ImmutableSurveyInstanceRecipientsAndOwners.builder()
            .ownerId("42")
            .owningRole("Owning Role")
            .build());
  }

  /**
   * Test {@link ImmutableSurveyInstanceRecipientsAndOwners#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceRecipientsAndOwners#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceRecipientsAndOwners.equals(Object)",
    "int ImmutableSurveyInstanceRecipientsAndOwners.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableSurveyInstanceRecipientsAndOwners immutableSurveyInstanceRecipientsAndOwners =
        ImmutableSurveyInstanceRecipientsAndOwners.builder()
            .ownerId("42")
            .owningRole("java.lang.Long")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableSurveyInstanceRecipientsAndOwners,
        ImmutableSurveyInstanceRecipientsAndOwners.builder()
            .ownerId("42")
            .owningRole("Owning Role")
            .build());
  }

  /**
   * Test {@link ImmutableSurveyInstanceRecipientsAndOwners#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceRecipientsAndOwners#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceRecipientsAndOwners.equals(Object)",
    "int ImmutableSurveyInstanceRecipientsAndOwners.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableSurveyInstanceRecipientsAndOwners.builder()
            .ownerId("42")
            .owningRole("Owning Role")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableSurveyInstanceRecipientsAndOwners#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceRecipientsAndOwners#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceRecipientsAndOwners.equals(Object)",
    "int ImmutableSurveyInstanceRecipientsAndOwners.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableSurveyInstanceRecipientsAndOwners.builder()
            .ownerId("42")
            .owningRole("Owning Role")
            .build(),
        "Different type to ImmutableSurveyInstanceRecipientsAndOwners");
  }

  /**
   * Test {@link ImmutableSurveyInstanceRecipientsAndOwners#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add minus one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceRecipientsAndOwners#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given LinkedHashSet() add minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceRecipientsAndOwners ImmutableSurveyInstanceRecipientsAndOwners.fromJson(Json)"
  })
  void testFromJson_givenLinkedHashSetAddMinusOne() {
    // Arrange
    LinkedHashSet<Long> recipientPersonIds = new LinkedHashSet<>();
    recipientPersonIds.add(-1L);
    recipientPersonIds.add(1L);

    LinkedHashSet<Long> ownerPersonIds = new LinkedHashSet<>();
    ownerPersonIds.add(1L);

    Json json = new Json();
    json.setRecipientPersonIds(recipientPersonIds);
    json.setOwnerPersonIds(ownerPersonIds);
    json.setOwningRole("Json");
    json.setOwnerId("Json");

    // Act
    ImmutableSurveyInstanceRecipientsAndOwners actualFromJsonResult =
        ImmutableSurveyInstanceRecipientsAndOwners.fromJson(json);

    // Assert
    Set<Long> expectedRecipientPersonIdsResult = json.recipientPersonIds;
    assertEquals(expectedRecipientPersonIdsResult, actualFromJsonResult.recipientPersonIds());
  }

  /**
   * Test {@link ImmutableSurveyInstanceRecipientsAndOwners#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return ownerPersonIds size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceRecipientsAndOwners#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return ownerPersonIds size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceRecipientsAndOwners ImmutableSurveyInstanceRecipientsAndOwners.fromJson(Json)"
  })
  void testFromJson_thenReturnOwnerPersonIdsSizeIsOne() {
    // Arrange
    LinkedHashSet<Long> recipientPersonIds = new LinkedHashSet<>();
    recipientPersonIds.add(1L);

    LinkedHashSet<Long> ownerPersonIds = new LinkedHashSet<>();
    ownerPersonIds.add(1L);

    Json json = new Json();
    json.setRecipientPersonIds(recipientPersonIds);
    json.setOwnerPersonIds(ownerPersonIds);
    json.setOwningRole("Json");
    json.setOwnerId("Json");

    // Act
    ImmutableSurveyInstanceRecipientsAndOwners actualFromJsonResult =
        ImmutableSurveyInstanceRecipientsAndOwners.fromJson(json);

    // Assert
    Set<Long> ownerPersonIdsResult = actualFromJsonResult.ownerPersonIds();
    assertEquals(1, ownerPersonIdsResult.size());
    Set<Long> recipientPersonIdsResult = actualFromJsonResult.recipientPersonIds();
    assertEquals(1, recipientPersonIdsResult.size());
    assertTrue(ownerPersonIdsResult.contains(1L));
    assertTrue(recipientPersonIdsResult.contains(1L));
  }

  /**
   * Test {@link ImmutableSurveyInstanceRecipientsAndOwners#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) OwnerPersonIds is {@code null}.
   *   <li>Then return ownerPersonIds Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceRecipientsAndOwners#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) OwnerPersonIds is 'null'; then return ownerPersonIds Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceRecipientsAndOwners ImmutableSurveyInstanceRecipientsAndOwners.fromJson(Json)"
  })
  void testFromJson_whenJsonOwnerPersonIdsIsNull_thenReturnOwnerPersonIdsEmpty() {
    // Arrange
    LinkedHashSet<Long> recipientPersonIds = new LinkedHashSet<>();
    recipientPersonIds.add(1L);

    Json json = new Json();
    json.setRecipientPersonIds(recipientPersonIds);
    json.setOwnerPersonIds(null);
    json.setOwningRole("Json");
    json.setOwnerId("Json");

    // Act
    ImmutableSurveyInstanceRecipientsAndOwners actualFromJsonResult =
        ImmutableSurveyInstanceRecipientsAndOwners.fromJson(json);

    // Assert
    Set<Long> recipientPersonIdsResult = actualFromJsonResult.recipientPersonIds();
    assertEquals(1, recipientPersonIdsResult.size());
    assertTrue(recipientPersonIdsResult.contains(1L));
    assertTrue(actualFromJsonResult.ownerPersonIds().isEmpty());
  }

  /**
   * Test {@link ImmutableSurveyInstanceRecipientsAndOwners#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) RecipientPersonIds is {@code null}.
   *   <li>Then return recipientPersonIds Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceRecipientsAndOwners#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) RecipientPersonIds is 'null'; then return recipientPersonIds Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceRecipientsAndOwners ImmutableSurveyInstanceRecipientsAndOwners.fromJson(Json)"
  })
  void testFromJson_whenJsonRecipientPersonIdsIsNull_thenReturnRecipientPersonIdsEmpty() {
    // Arrange
    LinkedHashSet<Long> ownerPersonIds = new LinkedHashSet<>();
    ownerPersonIds.add(1L);

    Json json = new Json();
    json.setRecipientPersonIds(null);
    json.setOwnerPersonIds(ownerPersonIds);
    json.setOwningRole("Json");
    json.setOwnerId("Json");

    // Act
    ImmutableSurveyInstanceRecipientsAndOwners actualFromJsonResult =
        ImmutableSurveyInstanceRecipientsAndOwners.fromJson(json);

    // Assert
    Set<Long> ownerPersonIdsResult = actualFromJsonResult.ownerPersonIds();
    assertEquals(1, ownerPersonIdsResult.size());
    assertTrue(ownerPersonIdsResult.contains(1L));
    assertTrue(actualFromJsonResult.recipientPersonIds().isEmpty());
  }

  /**
   * Test {@link ImmutableSurveyInstanceRecipientsAndOwners#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor).
   *   <li>Then return ownerId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceRecipientsAndOwners#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor); then return ownerId is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceRecipientsAndOwners ImmutableSurveyInstanceRecipientsAndOwners.fromJson(Json)"
  })
  void testFromJson_whenJson_thenReturnOwnerIdIsNull() {
    // Arrange
    Json json = new Json();

    // Act
    ImmutableSurveyInstanceRecipientsAndOwners actualFromJsonResult =
        ImmutableSurveyInstanceRecipientsAndOwners.fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.ownerId());
    assertNull(actualFromJsonResult.owningRole());
    Set<Long> expectedRecipientPersonIdsResult = json.recipientPersonIds;
    assertSame(expectedRecipientPersonIdsResult, actualFromJsonResult.recipientPersonIds());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyInstanceRecipientsAndOwners#toString()}
   *   <li>{@link ImmutableSurveyInstanceRecipientsAndOwners#ownerId()}
   *   <li>{@link ImmutableSurveyInstanceRecipientsAndOwners#ownerPersonIds()}
   *   <li>{@link ImmutableSurveyInstanceRecipientsAndOwners#owningRole()}
   *   <li>{@link ImmutableSurveyInstanceRecipientsAndOwners#recipientPersonIds()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableSurveyInstanceRecipientsAndOwners.ownerId()",
    "Set ImmutableSurveyInstanceRecipientsAndOwners.ownerPersonIds()",
    "String ImmutableSurveyInstanceRecipientsAndOwners.owningRole()",
    "Set ImmutableSurveyInstanceRecipientsAndOwners.recipientPersonIds()",
    "String ImmutableSurveyInstanceRecipientsAndOwners.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableSurveyInstanceRecipientsAndOwners immutableSurveyInstanceRecipientsAndOwners =
        ImmutableSurveyInstanceRecipientsAndOwners.builder()
            .ownerId("42")
            .owningRole("Owning Role")
            .build();

    // Act
    String actualToStringResult = immutableSurveyInstanceRecipientsAndOwners.toString();
    String actualOwnerIdResult = immutableSurveyInstanceRecipientsAndOwners.ownerId();
    Set<Long> actualOwnerPersonIdsResult =
        immutableSurveyInstanceRecipientsAndOwners.ownerPersonIds();
    String actualOwningRoleResult = immutableSurveyInstanceRecipientsAndOwners.owningRole();
    Set<Long> actualRecipientPersonIdsResult =
        immutableSurveyInstanceRecipientsAndOwners.recipientPersonIds();

    // Assert
    assertEquals("42", actualOwnerIdResult);
    assertEquals("Owning Role", actualOwningRoleResult);
    assertEquals(
        "SurveyInstanceRecipientsAndOwners{recipientPersonIds=[], ownerPersonIds=[], owningRole=Owning Role,"
            + " ownerId=42}",
        actualToStringResult);
    assertTrue(actualOwnerPersonIdsResult.isEmpty());
    assertSame(actualOwnerPersonIdsResult, actualRecipientPersonIdsResult);
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
    assertNull(actualJson.ownerId);
    assertNull(actualJson.owningRole);
    assertTrue(actualJson.ownerPersonIds.isEmpty());
    assertTrue(actualJson.recipientPersonIds.isEmpty());
  }

  /**
   * Test Json {@link Json#ownerId()}.
   *
   * <p>Method under test: {@link Json#ownerId()}
   */
  @Test
  @DisplayName("Test Json ownerId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.ownerId()"})
  void testJsonOwnerId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().ownerId());
  }

  /**
   * Test Json {@link Json#ownerPersonIds()}.
   *
   * <p>Method under test: {@link Json#ownerPersonIds()}
   */
  @Test
  @DisplayName("Test Json ownerPersonIds()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.ownerPersonIds()"})
  void testJsonOwnerPersonIds() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().ownerPersonIds());
  }

  /**
   * Test Json {@link Json#owningRole()}.
   *
   * <p>Method under test: {@link Json#owningRole()}
   */
  @Test
  @DisplayName("Test Json owningRole()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.owningRole()"})
  void testJsonOwningRole() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().owningRole());
  }

  /**
   * Test Json {@link Json#recipientPersonIds()}.
   *
   * <p>Method under test: {@link Json#recipientPersonIds()}
   */
  @Test
  @DisplayName("Test Json recipientPersonIds()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.recipientPersonIds()"})
  void testJsonRecipientPersonIds() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().recipientPersonIds());
  }

  /**
   * Test {@link ImmutableSurveyInstanceRecipientsAndOwners#withOwnerId(String)}.
   *
   * <ul>
   *   <li>Then return builder ownerId {@code 42} owningRole {@code Owning Role} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceRecipientsAndOwners#withOwnerId(String)}
   */
  @Test
  @DisplayName(
      "Test withOwnerId(String); then return builder ownerId '42' owningRole 'Owning Role' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceRecipientsAndOwners ImmutableSurveyInstanceRecipientsAndOwners.withOwnerId(String)"
  })
  void testWithOwnerId_thenReturnBuilderOwnerId42OwningRoleOwningRoleBuild() {
    // Arrange
    ImmutableSurveyInstanceRecipientsAndOwners immutableSurveyInstanceRecipientsAndOwners =
        ImmutableSurveyInstanceRecipientsAndOwners.builder()
            .ownerId("42")
            .owningRole("Owning Role")
            .build();

    // Act
    ImmutableSurveyInstanceRecipientsAndOwners actualWithOwnerIdResult =
        immutableSurveyInstanceRecipientsAndOwners.withOwnerId("42");

    // Assert
    assertSame(immutableSurveyInstanceRecipientsAndOwners, actualWithOwnerIdResult);
  }

  /**
   * Test {@link ImmutableSurveyInstanceRecipientsAndOwners#withOwnerId(String)}.
   *
   * <ul>
   *   <li>Then return ownerId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceRecipientsAndOwners#withOwnerId(String)}
   */
  @Test
  @DisplayName("Test withOwnerId(String); then return ownerId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceRecipientsAndOwners ImmutableSurveyInstanceRecipientsAndOwners.withOwnerId(String)"
  })
  void testWithOwnerId_thenReturnOwnerIdIs42() {
    // Arrange and Act
    ImmutableSurveyInstanceRecipientsAndOwners actualWithOwnerIdResult =
        ImmutableSurveyInstanceRecipientsAndOwners.builder()
            .ownerId("Owner Id")
            .owningRole("Owning Role")
            .build()
            .withOwnerId("42");

    // Assert
    assertEquals("42", actualWithOwnerIdResult.ownerId());
    assertEquals("Owning Role", actualWithOwnerIdResult.owningRole());
    Set<Long> ownerPersonIdsResult = actualWithOwnerIdResult.ownerPersonIds();
    assertTrue(ownerPersonIdsResult.isEmpty());
    assertSame(ownerPersonIdsResult, actualWithOwnerIdResult.recipientPersonIds());
  }

  /**
   * Test {@link ImmutableSurveyInstanceRecipientsAndOwners#withOwnerPersonIds(Iterable)} with
   * {@code Iterable}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return ownerId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableSurveyInstanceRecipientsAndOwners#withOwnerPersonIds(Iterable)}
   */
  @Test
  @DisplayName(
      "Test withOwnerPersonIds(Iterable) with 'Iterable'; given one; then return ownerId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceRecipientsAndOwners ImmutableSurveyInstanceRecipientsAndOwners.withOwnerPersonIds(Iterable)"
  })
  void testWithOwnerPersonIdsWithIterable_givenOne_thenReturnOwnerIdIs42() {
    // Arrange
    ImmutableSurveyInstanceRecipientsAndOwners immutableSurveyInstanceRecipientsAndOwners =
        ImmutableSurveyInstanceRecipientsAndOwners.builder()
            .ownerId("42")
            .owningRole("Owning Role")
            .build();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    ImmutableSurveyInstanceRecipientsAndOwners actualWithOwnerPersonIdsResult =
        immutableSurveyInstanceRecipientsAndOwners.withOwnerPersonIds(elements);

    // Assert
    assertEquals("42", actualWithOwnerPersonIdsResult.ownerId());
    assertEquals("Owning Role", actualWithOwnerPersonIdsResult.owningRole());
    assertTrue(actualWithOwnerPersonIdsResult.recipientPersonIds().isEmpty());
    assertEquals(elements, actualWithOwnerPersonIdsResult.ownerPersonIds());
  }

  /**
   * Test {@link ImmutableSurveyInstanceRecipientsAndOwners#withOwnerPersonIds(long[])} with {@code
   * long[]}.
   *
   * <p>Method under test: {@link
   * ImmutableSurveyInstanceRecipientsAndOwners#withOwnerPersonIds(long[])}
   */
  @Test
  @DisplayName("Test withOwnerPersonIds(long[]) with 'long[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceRecipientsAndOwners ImmutableSurveyInstanceRecipientsAndOwners.withOwnerPersonIds(long[])"
  })
  void testWithOwnerPersonIdsWithLong() {
    // Arrange and Act
    ImmutableSurveyInstanceRecipientsAndOwners actualWithOwnerPersonIdsResult =
        ImmutableSurveyInstanceRecipientsAndOwners.builder()
            .ownerId("42")
            .owningRole("Owning Role")
            .build()
            .withOwnerPersonIds(1L, -1L, 1L, -1L);

    // Assert
    assertEquals("42", actualWithOwnerPersonIdsResult.ownerId());
    assertEquals("Owning Role", actualWithOwnerPersonIdsResult.owningRole());
    Set<Long> ownerPersonIdsResult = actualWithOwnerPersonIdsResult.ownerPersonIds();
    assertEquals(2, ownerPersonIdsResult.size());
    assertTrue(ownerPersonIdsResult.contains(-1L));
    assertTrue(ownerPersonIdsResult.contains(1L));
    assertTrue(actualWithOwnerPersonIdsResult.recipientPersonIds().isEmpty());
  }

  /**
   * Test {@link ImmutableSurveyInstanceRecipientsAndOwners#withOwningRole(String)}.
   *
   * <ul>
   *   <li>Then return builder ownerId {@code 42} owningRole {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceRecipientsAndOwners#withOwningRole(String)}
   */
  @Test
  @DisplayName(
      "Test withOwningRole(String); then return builder ownerId '42' owningRole '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceRecipientsAndOwners ImmutableSurveyInstanceRecipientsAndOwners.withOwningRole(String)"
  })
  void testWithOwningRole_thenReturnBuilderOwnerId42OwningRole42Build() {
    // Arrange
    ImmutableSurveyInstanceRecipientsAndOwners immutableSurveyInstanceRecipientsAndOwners =
        ImmutableSurveyInstanceRecipientsAndOwners.builder().ownerId("42").owningRole("42").build();

    // Act
    ImmutableSurveyInstanceRecipientsAndOwners actualWithOwningRoleResult =
        immutableSurveyInstanceRecipientsAndOwners.withOwningRole("42");

    // Assert
    assertSame(immutableSurveyInstanceRecipientsAndOwners, actualWithOwningRoleResult);
  }

  /**
   * Test {@link ImmutableSurveyInstanceRecipientsAndOwners#withOwningRole(String)}.
   *
   * <ul>
   *   <li>Then return ownerId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceRecipientsAndOwners#withOwningRole(String)}
   */
  @Test
  @DisplayName("Test withOwningRole(String); then return ownerId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceRecipientsAndOwners ImmutableSurveyInstanceRecipientsAndOwners.withOwningRole(String)"
  })
  void testWithOwningRole_thenReturnOwnerIdIs42() {
    // Arrange and Act
    ImmutableSurveyInstanceRecipientsAndOwners actualWithOwningRoleResult =
        ImmutableSurveyInstanceRecipientsAndOwners.builder()
            .ownerId("42")
            .owningRole("Owning Role")
            .build()
            .withOwningRole("42");

    // Assert
    assertEquals("42", actualWithOwningRoleResult.ownerId());
    assertEquals("42", actualWithOwningRoleResult.owningRole());
    Set<Long> ownerPersonIdsResult = actualWithOwningRoleResult.ownerPersonIds();
    assertTrue(ownerPersonIdsResult.isEmpty());
    assertSame(ownerPersonIdsResult, actualWithOwningRoleResult.recipientPersonIds());
  }

  /**
   * Test {@link ImmutableSurveyInstanceRecipientsAndOwners#withRecipientPersonIds(Iterable)} with
   * {@code Iterable}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return ownerId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableSurveyInstanceRecipientsAndOwners#withRecipientPersonIds(Iterable)}
   */
  @Test
  @DisplayName(
      "Test withRecipientPersonIds(Iterable) with 'Iterable'; given one; then return ownerId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceRecipientsAndOwners ImmutableSurveyInstanceRecipientsAndOwners.withRecipientPersonIds(Iterable)"
  })
  void testWithRecipientPersonIdsWithIterable_givenOne_thenReturnOwnerIdIs42() {
    // Arrange
    ImmutableSurveyInstanceRecipientsAndOwners immutableSurveyInstanceRecipientsAndOwners =
        ImmutableSurveyInstanceRecipientsAndOwners.builder()
            .ownerId("42")
            .owningRole("Owning Role")
            .build();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    ImmutableSurveyInstanceRecipientsAndOwners actualWithRecipientPersonIdsResult =
        immutableSurveyInstanceRecipientsAndOwners.withRecipientPersonIds(elements);

    // Assert
    assertEquals("42", actualWithRecipientPersonIdsResult.ownerId());
    assertEquals("Owning Role", actualWithRecipientPersonIdsResult.owningRole());
    assertTrue(actualWithRecipientPersonIdsResult.ownerPersonIds().isEmpty());
    assertEquals(elements, actualWithRecipientPersonIdsResult.recipientPersonIds());
  }

  /**
   * Test {@link ImmutableSurveyInstanceRecipientsAndOwners#withRecipientPersonIds(long[])} with
   * {@code long[]}.
   *
   * <p>Method under test: {@link
   * ImmutableSurveyInstanceRecipientsAndOwners#withRecipientPersonIds(long[])}
   */
  @Test
  @DisplayName("Test withRecipientPersonIds(long[]) with 'long[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceRecipientsAndOwners ImmutableSurveyInstanceRecipientsAndOwners.withRecipientPersonIds(long[])"
  })
  void testWithRecipientPersonIdsWithLong() {
    // Arrange and Act
    ImmutableSurveyInstanceRecipientsAndOwners actualWithRecipientPersonIdsResult =
        ImmutableSurveyInstanceRecipientsAndOwners.builder()
            .ownerId("42")
            .owningRole("Owning Role")
            .build()
            .withRecipientPersonIds(1L, -1L, 1L, -1L);

    // Assert
    assertEquals("42", actualWithRecipientPersonIdsResult.ownerId());
    assertEquals("Owning Role", actualWithRecipientPersonIdsResult.owningRole());
    Set<Long> recipientPersonIdsResult = actualWithRecipientPersonIdsResult.recipientPersonIds();
    assertEquals(2, recipientPersonIdsResult.size());
    assertTrue(recipientPersonIdsResult.contains(-1L));
    assertTrue(recipientPersonIdsResult.contains(1L));
    assertTrue(actualWithRecipientPersonIdsResult.ownerPersonIds().isEmpty());
  }
}
