package org.finos.waltz.model.attestation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.attestation.ImmutableUserAttestationPermission.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class UserAttestationPermissionDiffblueTest {
  /**
   * Test {@link UserAttestationPermission#hasPermission()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link UserAttestationPermission#hasPermission()}
   */
  @Test
  @DisplayName("Test hasPermission(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserAttestationPermission.hasPermission()"})
  void testHasPermission_thenReturnFalse() {
    // Arrange
    Builder parentKindResult =
        ImmutableUserAttestationPermission.builder().parentKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference = Optional.of(immutableEntityReference);

    // Act and Assert
    assertFalse(
        parentKindResult
            .qualifierReference(qualifierReference)
            .subjectKind(EntityKind.ALL)
            .build()
            .hasPermission());
  }
}
