package org.finos.waltz.model.involvement_group;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.finos.waltz.model.involvement_group.ImmutableInvolvementGroupCreateCommand.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class InvolvementGroupCreateCommandDiffblueTest {
  /**
   * Test {@link InvolvementGroupCreateCommand#involvementKindIds()}.
   *
   * <p>Method under test: {@link InvolvementGroupCreateCommand#involvementKindIds()}
   */
  @Test
  @DisplayName("Test involvementKindIds()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set InvolvementGroupCreateCommand.involvementKindIds()"})
  void testInvolvementKindIds() {
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
    assertTrue(
        involvementGroupResult
            .addAllInvolvementKindIds(new ArrayList<>())
            .build()
            .involvementKindIds()
            .isEmpty());
  }
}
