package org.finos.waltz.model.permission_group;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Set;
import org.finos.waltz.model.permission_group.ImmutableRequiredInvolvementsResult.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RequiredInvolvementsResultDiffblueTest {
  /**
   * Test {@link RequiredInvolvementsResult#isAllowed(Set)}.
   *
   * <ul>
   *   <li>Given builder addRequiredInvolvementKindIds three and one.
   * </ul>
   *
   * <p>Method under test: {@link RequiredInvolvementsResult#isAllowed(Set)}
   */
  @Test
  @DisplayName("Test isAllowed(Set); given builder addRequiredInvolvementKindIds three and one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RequiredInvolvementsResult.isAllowed(Set)"})
  void testIsAllowed_givenBuilderAddRequiredInvolvementKindIdsThreeAndOne() {
    // Arrange
    Builder builderResult = ImmutableRequiredInvolvementsResult.builder();
    builderResult.addRequiredInvolvementKindIds(3L, 1L, 3L, 1L);
    ImmutableRequiredInvolvementsResult immutableRequiredInvolvementsResult =
        builderResult.areAllUsersAllowed(false).build();

    HashSet<Long> userInvolvementKindIds = new HashSet<>();
    userInvolvementKindIds.add(1L);

    // Act and Assert
    assertTrue(immutableRequiredInvolvementsResult.isAllowed(userInvolvementKindIds));
  }

  /**
   * Test {@link RequiredInvolvementsResult#isAllowed(Set)}.
   *
   * <ul>
   *   <li>Given builder areAllUsersAllowed {@code true} build.
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RequiredInvolvementsResult#isAllowed(Set)}
   */
  @Test
  @DisplayName(
      "Test isAllowed(Set); given builder areAllUsersAllowed 'true' build; when 'null'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RequiredInvolvementsResult.isAllowed(Set)"})
  void testIsAllowed_givenBuilderAreAllUsersAllowedTrueBuild_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        ImmutableRequiredInvolvementsResult.builder()
            .areAllUsersAllowed(true)
            .build()
            .isAllowed(null));
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
