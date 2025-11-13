package org.finos.waltz.model.server_usage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.server_usage.ImmutableServerUsage.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ServerUsageDiffblueTest {
  /**
   * Test {@link ServerUsage#kind()}.
   *
   * <ul>
   *   <li>Then return {@code ALL}.
   * </ul>
   *
   * <p>Method under test: {@link ServerUsage#kind()}
   */
  @Test
  @DisplayName("Test kind(); then return 'ALL'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind ServerUsage.kind()"})
  void testKind_thenReturnAll() {
    // Arrange
    Builder builderResult = ImmutableServerUsage.builder();

    // Act and Assert
    assertEquals(
        EntityKind.ALL,
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .environment("Environment")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .serverId(1L)
            .build()
            .kind());
  }

  /**
   * Test {@link ServerUsage#environment()}.
   *
   * <ul>
   *   <li>Then return {@code Environment}.
   * </ul>
   *
   * <p>Method under test: {@link ServerUsage#environment()}
   */
  @Test
  @DisplayName("Test environment(); then return 'Environment'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String ServerUsage.environment()"})
  void testEnvironment_thenReturnEnvironment() {
    // Arrange
    Builder builderResult = ImmutableServerUsage.builder();

    // Act and Assert
    assertEquals(
        "Environment",
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .environment("Environment")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .serverId(1L)
            .build()
            .environment());
  }
}
