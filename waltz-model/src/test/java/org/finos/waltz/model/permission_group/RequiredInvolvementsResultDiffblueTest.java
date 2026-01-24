package org.finos.waltz.model.permission_group;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import org.finos.waltz.model.permission_group.ImmutableRequiredInvolvementsResult.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RequiredInvolvementsResultDiffblueTest {
  /**
   * Test {@link RequiredInvolvementsResult#isAllowed(Set)}.
   *
   * <ul>
   *   <li>Given builder addRequiredInvolvementKindIds one and minus two.
   * </ul>
   *
   * <p>Method under test: {@link RequiredInvolvementsResult#isAllowed(Set)}
   */
  @Test
  @DisplayName("Test isAllowed(Set); given builder addRequiredInvolvementKindIds one and minus two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RequiredInvolvementsResult.isAllowed(Set)"})
  void testIsAllowed_givenBuilderAddRequiredInvolvementKindIdsOneAndMinusTwo() {
    // Arrange
    Builder builderResult = ImmutableRequiredInvolvementsResult.builder();
    builderResult.addRequiredInvolvementKindIds(1L, -2L, 1L, -2L);
    ImmutableRequiredInvolvementsResult immutableRequiredInvolvementsResult =
        builderResult.areAllUsersAllowed(false).build();

    TreeSet<Long> userInvolvementKindIds = new TreeSet<>();
    userInvolvementKindIds.add(1L);

    // Act and Assert
    assertTrue(immutableRequiredInvolvementsResult.isAllowed(userInvolvementKindIds));
  }

  /**
   * Test {@link RequiredInvolvementsResult#isAllowed(Set)}.
   *
   * <ul>
   *   <li>Given builder areAllUsersAllowed {@code true} build.
   *   <li>When {@link HashSet#HashSet()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RequiredInvolvementsResult#isAllowed(Set)}
   */
  @Test
  @DisplayName(
      "Test isAllowed(Set); given builder areAllUsersAllowed 'true' build; when HashSet(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RequiredInvolvementsResult.isAllowed(Set)"})
  void testIsAllowed_givenBuilderAreAllUsersAllowedTrueBuild_whenHashSet_thenReturnTrue() {
    // Arrange
    ImmutableRequiredInvolvementsResult immutableRequiredInvolvementsResult =
        ImmutableRequiredInvolvementsResult.builder().areAllUsersAllowed(true).build();

    // Act and Assert
    assertTrue(immutableRequiredInvolvementsResult.isAllowed(new HashSet<>()));
  }

  /**
   * Test {@link RequiredInvolvementsResult#isAllowed(Set)}.
   *
   * <ul>
   *   <li>Given minus one.
   *   <li>When {@link TreeSet#TreeSet()} add minus one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link RequiredInvolvementsResult#isAllowed(Set)}
   */
  @Test
  @DisplayName(
      "Test isAllowed(Set); given minus one; when TreeSet() add minus one; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RequiredInvolvementsResult.isAllowed(Set)"})
  void testIsAllowed_givenMinusOne_whenTreeSetAddMinusOne_thenReturnFalse() {
    // Arrange
    ImmutableRequiredInvolvementsResult immutableRequiredInvolvementsResult =
        ImmutableRequiredInvolvementsResult.builder().areAllUsersAllowed(false).build();

    TreeSet<Long> userInvolvementKindIds = new TreeSet<>();
    userInvolvementKindIds.add(-1L);
    userInvolvementKindIds.add(1L);

    // Act and Assert
    assertFalse(immutableRequiredInvolvementsResult.isAllowed(userInvolvementKindIds));
  }

  /**
   * Test {@link RequiredInvolvementsResult#isAllowed(Set)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link TreeSet#TreeSet()} add one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link RequiredInvolvementsResult#isAllowed(Set)}
   */
  @Test
  @DisplayName("Test isAllowed(Set); given one; when TreeSet() add one; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RequiredInvolvementsResult.isAllowed(Set)"})
  void testIsAllowed_givenOne_whenTreeSetAddOne_thenReturnFalse() {
    // Arrange
    ImmutableRequiredInvolvementsResult immutableRequiredInvolvementsResult =
        ImmutableRequiredInvolvementsResult.builder().areAllUsersAllowed(false).build();

    TreeSet<Long> userInvolvementKindIds = new TreeSet<>();
    userInvolvementKindIds.add(1L);

    // Act and Assert
    assertFalse(immutableRequiredInvolvementsResult.isAllowed(userInvolvementKindIds));
  }

  /**
   * Test {@link RequiredInvolvementsResult#isAllowed(Set)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link RequiredInvolvementsResult#isAllowed(Set)}
   */
  @Test
  @DisplayName("Test isAllowed(Set); when HashSet(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RequiredInvolvementsResult.isAllowed(Set)"})
  void testIsAllowed_whenHashSet_thenReturnFalse() {
    // Arrange
    ImmutableRequiredInvolvementsResult immutableRequiredInvolvementsResult =
        ImmutableRequiredInvolvementsResult.builder().areAllUsersAllowed(false).build();

    // Act and Assert
    assertFalse(immutableRequiredInvolvementsResult.isAllowed(new HashSet<>()));
  }
}
