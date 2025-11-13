package org.finos.waltz.model.permission_group;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RequiredInvolvementsResultDiffblueTest {
  /**
   * Test {@link RequiredInvolvementsResult#isAllowed(Set)}.
   *
   * <ul>
   *   <li>Given builder areAllUsersAllowed {@code false} build.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link RequiredInvolvementsResult#isAllowed(Set)}
   */
  @Test
  @DisplayName(
      "Test isAllowed(Set); given builder areAllUsersAllowed 'false' build; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RequiredInvolvementsResult.isAllowed(Set)"})
  void testIsAllowed_givenBuilderAreAllUsersAllowedFalseBuild_thenReturnFalse() {
    // Arrange
    ImmutableRequiredInvolvementsResult immutableRequiredInvolvementsResult =
        ImmutableRequiredInvolvementsResult.builder().areAllUsersAllowed(false).build();

    // Act and Assert
    assertFalse(immutableRequiredInvolvementsResult.isAllowed(new HashSet<>()));
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
}
