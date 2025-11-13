package org.finos.waltz.model.custom_environment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.custom_environment.ImmutableCustomEnvironment.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CustomEnvironmentDiffblueTest {
  /**
   * Test {@link CustomEnvironment#groupName()}.
   *
   * <ul>
   *   <li>Then return {@code Group Name}.
   * </ul>
   *
   * <p>Method under test: {@link CustomEnvironment#groupName()}
   */
  @Test
  @DisplayName("Test groupName(); then return 'Group Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String CustomEnvironment.groupName()"})
  void testGroupName_thenReturnGroupName() {
    // Arrange
    Builder nameResult =
        ImmutableCustomEnvironment.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .groupName("Group Name")
            .id(1L)
            .name("Name");

    // Act and Assert
    assertEquals(
        "Group Name",
        nameResult
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build()
            .groupName());
  }
}
