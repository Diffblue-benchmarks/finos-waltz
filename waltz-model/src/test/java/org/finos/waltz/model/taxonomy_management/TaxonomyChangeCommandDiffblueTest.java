package org.finos.waltz.model.taxonomy_management;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.HashMap;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.taxonomy_management.ImmutableTaxonomyChangeCommand.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TaxonomyChangeCommandDiffblueTest {
  /**
   * Test {@link TaxonomyChangeCommand#paramAsBoolean(String, boolean)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TaxonomyChangeCommand#paramAsBoolean(String, boolean)}
   */
  @Test
  @DisplayName("Test paramAsBoolean(String, boolean); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TaxonomyChangeCommand.paramAsBoolean(String, boolean)"})
  void testParamAsBoolean_thenReturnTrue() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult =
        builderResult
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());

    // Act and Assert
    assertTrue(
        paramsResult
            .primaryReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .status(TaxonomyChangeLifecycleStatus.DRAFT)
            .build()
            .paramAsBoolean("Key", true));
  }

  /**
   * Test {@link TaxonomyChangeCommand#paramAsBoolean(String, boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TaxonomyChangeCommand#paramAsBoolean(String, boolean)}
   */
  @Test
  @DisplayName("Test paramAsBoolean(String, boolean); when 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TaxonomyChangeCommand.paramAsBoolean(String, boolean)"})
  void testParamAsBoolean_whenFalse_thenReturnFalse() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult =
        builderResult
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());

    // Act and Assert
    assertFalse(
        paramsResult
            .primaryReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .status(TaxonomyChangeLifecycleStatus.DRAFT)
            .build()
            .paramAsBoolean("Key", false));
  }

  /**
   * Test {@link TaxonomyChangeCommand#paramAsLong(String, Long)}.
   *
   * <ul>
   *   <li>Then return longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link TaxonomyChangeCommand#paramAsLong(String, Long)}
   */
  @Test
  @DisplayName("Test paramAsLong(String, Long); then return longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long TaxonomyChangeCommand.paramAsLong(String, Long)"})
  void testParamAsLong_thenReturnLongValueIsOne() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult =
        builderResult
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());

    // Act and Assert
    assertEquals(
        1L,
        paramsResult
            .primaryReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .status(TaxonomyChangeLifecycleStatus.DRAFT)
            .build()
            .paramAsLong("Key", 1L)
            .longValue());
  }

  /**
   * Test {@link TaxonomyChangeCommand#param(String)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TaxonomyChangeCommand#param(String)}
   */
  @Test
  @DisplayName("Test param(String); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TaxonomyChangeCommand.param(String)"})
  void testParam_thenReturnNull() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    Builder lastUpdatedByResult =
        builderResult
            .changeDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .changeType(TaxonomyChangeType.ADD_PEER)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder paramsResult = lastUpdatedByResult.params(new HashMap<>());

    // Act and Assert
    assertNull(
        paramsResult
            .primaryReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .status(TaxonomyChangeLifecycleStatus.DRAFT)
            .build()
            .param("Key"));
  }
}
