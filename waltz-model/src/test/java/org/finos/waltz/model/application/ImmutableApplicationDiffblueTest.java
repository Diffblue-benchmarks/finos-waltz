package org.finos.waltz.model.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import org.finos.waltz.model.Criticality;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityKindProvider;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityLifecycleStatusProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.IsRemovedProvider;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.OrganisationalUnitIdProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.finos.waltz.model.application.ImmutableApplication.Builder;
import org.finos.waltz.model.application.ImmutableApplication.Json;
import org.finos.waltz.model.external_identifier.ExternalIdValue;
import org.finos.waltz.model.rating.RagRating;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableApplicationDiffblueTest {
  /**
   * Test {@link ImmutableApplication#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableApplication#builder()}
   *   <li>{@link ImmutableApplication#actualRetirementDate(LocalDateTime)}
   *   <li>{@link ImmutableApplication#assetCode(ExternalIdValue)}
   *   <li>{@link ImmutableApplication#businessCriticality(Criticality)}
   *   <li>{@link ImmutableApplication#commissionDate(LocalDateTime)}
   *   <li>{@link ImmutableApplication#description(String)}
   *   <li>{@link ImmutableApplication#entityLifecycleStatus(EntityLifecycleStatus)}
   *   <li>{@link ImmutableApplication#kind(EntityKind)}
   *   <li>{@link ImmutableApplication#parentAssetCode(ExternalIdValue)}
   *   <li>{@link ImmutableApplication#plannedRetirementDate(LocalDateTime)}
   *   <li>{@link ImmutableApplication#provenance(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.actualRetirementDate(LocalDateTime)",
      "Builder Builder.assetCode(ExternalIdValue)", "ImmutableApplication Builder.build()",
      "Builder Builder.businessCriticality(Criticality)", "Builder Builder.commissionDate(LocalDateTime)",
      "Builder Builder.description(String)", "Builder Builder.entityLifecycleStatus(EntityLifecycleStatus)",
      "Builder Builder.kind(EntityKind)", "Builder Builder.parentAssetCode(ExternalIdValue)",
      "Builder Builder.plannedRetirementDate(LocalDateTime)", "Builder Builder.provenance(String)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableApplication.builder();
    Builder actualActualRetirementDateResult = actualBuilderResult
        .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay());
    Optional<? extends LocalDateTime> actualRetirementDate = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    Builder actualActualRetirementDateResult2 = actualActualRetirementDateResult
        .actualRetirementDate(actualRetirementDate);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));
    Builder actualAssetCodeResult = actualActualRetirementDateResult2.assetCode(assetCode);
    Builder actualBusinessCriticalityResult = actualAssetCodeResult.assetCode(ExternalIdValue.of("42"))
        .businessCriticality(Criticality.LOW);
    Builder actualCommissionDateResult = actualBusinessCriticalityResult
        .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay());
    Optional<? extends LocalDateTime> commissionDate = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    Builder actualIdResult = actualCommissionDateResult.commissionDate(commissionDate)
        .description("The characteristics of someone or something")
        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
        .id(1L);
    Optional<Long> id = Optional.<Long>of(1L);
    Builder actualKindResult = actualIdResult.id(id).kind(EntityKind.ALL);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    Builder actualParentAssetCodeResult = actualKindResult.parentAssetCode(parentAssetCode);
    Builder actualParentAssetCodeResult2 = actualParentAssetCodeResult.parentAssetCode(ExternalIdValue.of("42"));
    Builder actualPlannedRetirementDateResult = actualParentAssetCodeResult2
        .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay());
    Optional<? extends LocalDateTime> plannedRetirementDate = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    Builder actualPlannedRetirementDateResult2 = actualPlannedRetirementDateResult
        .plannedRetirementDate(plannedRetirementDate);

    // Assert
    assertSame(actualPlannedRetirementDateResult2, actualPlannedRetirementDateResult2.provenance("Provenance"));
  }

  /**
   * Test Builder {@link Builder#actualRetirementDate(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#actualRetirementDate(Optional)}
   */
  @Test
  @DisplayName("Test Builder actualRetirementDate(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.actualRetirementDate(Optional)"})
  void testBuilderActualRetirementDateWithOptional() {
    // Arrange
    Builder builderResult = ImmutableApplication.builder();
    Optional<? extends LocalDateTime> actualRetirementDate = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act and Assert
    assertSame(builderResult, builderResult.actualRetirementDate(actualRetirementDate));
  }

  /**
   * Test Builder {@link Builder#applicationKind(ApplicationKind)}.
   * <p>
   * Method under test: {@link Builder#applicationKind(ApplicationKind)}
   */
  @Test
  @DisplayName("Test Builder applicationKind(ApplicationKind)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.applicationKind(ApplicationKind)"})
  void testBuilderApplicationKind() {
    // Arrange
    Builder builderResult = ImmutableApplication.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.applicationKind(ApplicationKind.IN_HOUSE));
  }

  /**
   * Test Builder {@link Builder#assetCode(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#assetCode(Optional)}
   */
  @Test
  @DisplayName("Test Builder assetCode(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.assetCode(Optional)"})
  void testBuilderAssetCodeWithOptional() {
    // Arrange
    Builder builderResult = ImmutableApplication.builder();
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    // Act and Assert
    assertSame(builderResult, builderResult.assetCode(assetCode));
  }

  /**
   * Test Builder {@link Builder#commissionDate(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#commissionDate(Optional)}
   */
  @Test
  @DisplayName("Test Builder commissionDate(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.commissionDate(Optional)"})
  void testBuilderCommissionDateWithOptional() {
    // Arrange
    Builder builderResult = ImmutableApplication.builder();
    Optional<? extends LocalDateTime> commissionDate = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act and Assert
    assertSame(builderResult, builderResult.commissionDate(commissionDate));
  }

  /**
   * Test Builder {@link Builder#from(Application)} with {@code Application}.
   * <p>
   * Method under test: {@link Builder#from(Application)}
   */
  @Test
  @DisplayName("Test Builder from(Application) with 'Application'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(Application)"})
  void testBuilderFromWithApplication() {
    // Arrange
    Builder builderResult = ImmutableApplication.builder();
    Application instance = mock(Application.class);
    when(instance.organisationalUnitId()).thenReturn(1L);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<LocalDateTime> ofResult2 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.commissionDate()).thenReturn(ofResult2);
    Optional<LocalDateTime> ofResult3 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.plannedRetirementDate()).thenReturn(ofResult3);
    when(instance.isRemoved()).thenReturn(true);
    Optional<LocalDateTime> ofResult4 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.actualRetirementDate()).thenReturn(ofResult4);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(instance.businessCriticality()).thenReturn(Criticality.LOW);
    Optional<ExternalIdValue> ofResult5 = Optional.of(ExternalIdValue.of("42"));
    when(instance.assetCode()).thenReturn(ofResult5);
    when(instance.overallRating()).thenReturn(RagRating.R);
    Optional<ExternalIdValue> ofResult6 = Optional.of(ExternalIdValue.of("42"));
    when(instance.parentAssetCode()).thenReturn(ofResult6);
    when(instance.applicationKind()).thenReturn(ApplicationKind.IN_HOUSE);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).id();
    verify(instance).isRemoved();
    verify(instance).name();
    verify(instance).organisationalUnitId();
    verify(instance).actualRetirementDate();
    verify(instance).applicationKind();
    verify(instance).assetCode();
    verify(instance).businessCriticality();
    verify(instance).commissionDate();
    verify(instance).kind();
    verify(instance).lifecyclePhase();
    verify(instance).overallRating();
    verify(instance).parentAssetCode();
    verify(instance).plannedRetirementDate();
    verify(instance).provenance();
    ImmutableApplication buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1L, buildResult.organisationalUnitId().longValue());
    assertEquals(Criticality.LOW, buildResult.businessCriticality());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, buildResult.entityLifecycleStatus());
    assertEquals(ApplicationKind.IN_HOUSE, buildResult.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, buildResult.lifecyclePhase());
    assertEquals(RagRating.R, buildResult.overallRating());
    assertTrue(buildResult.isRemoved());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(Application)} with {@code Application}.
   * <ul>
   *   <li>Then builder build description is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(Application)}
   */
  @Test
  @DisplayName("Test Builder from(Application) with 'Application'; then builder build description is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(Application)"})
  void testBuilderFromWithApplication_thenBuilderBuildDescriptionIsNull() {
    // Arrange
    Builder builderResult = ImmutableApplication.builder();
    Application instance = mock(Application.class);
    when(instance.organisationalUnitId()).thenReturn(1L);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<LocalDateTime> ofResult2 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.commissionDate()).thenReturn(ofResult2);
    Optional<LocalDateTime> ofResult3 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.plannedRetirementDate()).thenReturn(ofResult3);
    when(instance.isRemoved()).thenReturn(true);
    Optional<LocalDateTime> ofResult4 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.actualRetirementDate()).thenReturn(ofResult4);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(instance.businessCriticality()).thenReturn(Criticality.LOW);
    Optional<ExternalIdValue> ofResult5 = Optional.of(ExternalIdValue.of("42"));
    when(instance.assetCode()).thenReturn(ofResult5);
    when(instance.overallRating()).thenReturn(RagRating.R);
    Optional<ExternalIdValue> ofResult6 = Optional.of(ExternalIdValue.of("42"));
    when(instance.parentAssetCode()).thenReturn(ofResult6);
    when(instance.applicationKind()).thenReturn(ApplicationKind.IN_HOUSE);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn(null);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).id();
    verify(instance).isRemoved();
    verify(instance).name();
    verify(instance).organisationalUnitId();
    verify(instance).actualRetirementDate();
    verify(instance).applicationKind();
    verify(instance).assetCode();
    verify(instance).businessCriticality();
    verify(instance).commissionDate();
    verify(instance).kind();
    verify(instance).lifecyclePhase();
    verify(instance).overallRating();
    verify(instance).parentAssetCode();
    verify(instance).plannedRetirementDate();
    verify(instance).provenance();
    ImmutableApplication buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertNull(buildResult.description());
    assertEquals(1L, buildResult.organisationalUnitId().longValue());
    assertEquals(Criticality.LOW, buildResult.businessCriticality());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, buildResult.entityLifecycleStatus());
    assertEquals(ApplicationKind.IN_HOUSE, buildResult.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, buildResult.lifecyclePhase());
    assertEquals(RagRating.R, buildResult.overallRating());
    assertTrue(buildResult.isRemoved());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(Application)} with {@code Application}.
   * <ul>
   *   <li>Then return build name is {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(Application)}
   */
  @Test
  @DisplayName("Test Builder from(Application) with 'Application'; then return build name is 'Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(Application)"})
  void testBuilderFromWithApplication_thenReturnBuildNameIsName() {
    // Arrange
    Builder builderResult = ImmutableApplication.builder();
    Application instance = mock(Application.class);
    when(instance.organisationalUnitId()).thenReturn(1L);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<LocalDateTime> ofResult2 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.commissionDate()).thenReturn(ofResult2);
    Optional<LocalDateTime> ofResult3 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.plannedRetirementDate()).thenReturn(ofResult3);
    when(instance.isRemoved()).thenReturn(true);
    Optional<LocalDateTime> ofResult4 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.actualRetirementDate()).thenReturn(ofResult4);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(instance.businessCriticality()).thenReturn(Criticality.LOW);
    Optional<ExternalIdValue> emptyResult = Optional.empty();
    when(instance.assetCode()).thenReturn(emptyResult);
    when(instance.overallRating()).thenReturn(RagRating.R);
    Optional<ExternalIdValue> ofResult5 = Optional.of(ExternalIdValue.of("42"));
    when(instance.parentAssetCode()).thenReturn(ofResult5);
    when(instance.applicationKind()).thenReturn(ApplicationKind.IN_HOUSE);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).id();
    verify(instance).isRemoved();
    verify(instance).name();
    verify(instance).organisationalUnitId();
    verify(instance).actualRetirementDate();
    verify(instance).applicationKind();
    verify(instance).assetCode();
    verify(instance).businessCriticality();
    verify(instance).commissionDate();
    verify(instance).kind();
    verify(instance).lifecyclePhase();
    verify(instance).overallRating();
    verify(instance).parentAssetCode();
    verify(instance).plannedRetirementDate();
    verify(instance).provenance();
    ImmutableApplication buildResult = actualFromResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1L, buildResult.organisationalUnitId().longValue());
    assertEquals(Criticality.LOW, buildResult.businessCriticality());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, buildResult.entityLifecycleStatus());
    assertEquals(ApplicationKind.IN_HOUSE, buildResult.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, buildResult.lifecyclePhase());
    assertEquals(RagRating.R, buildResult.overallRating());
    assertFalse(buildResult.externalId().isPresent());
    assertTrue(buildResult.isRemoved());
    assertSame(emptyResult, builderResult.build().externalId());
  }

  /**
   * Test Builder {@link Builder#from(Application)} with {@code Application}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(Application)}
   */
  @Test
  @DisplayName("Test Builder from(Application) with 'Application'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(Application)"})
  void testBuilderFromWithApplication_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableApplication.builder();
    Application instance = mock(Application.class);
    when(instance.plannedRetirementDate()).thenThrow(new IllegalStateException("instance"));
    Optional<LocalDateTime> ofResult = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.actualRetirementDate()).thenReturn(ofResult);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(instance.businessCriticality()).thenReturn(Criticality.LOW);
    Optional<ExternalIdValue> ofResult2 = Optional.of(ExternalIdValue.of("42"));
    when(instance.assetCode()).thenReturn(ofResult2);
    when(instance.overallRating()).thenReturn(RagRating.R);
    Optional<ExternalIdValue> ofResult3 = Optional.of(ExternalIdValue.of("42"));
    when(instance.parentAssetCode()).thenReturn(ofResult3);
    when(instance.applicationKind()).thenReturn(ApplicationKind.IN_HOUSE);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).name();
    verify(instance).actualRetirementDate();
    verify(instance).applicationKind();
    verify(instance).assetCode();
    verify(instance).businessCriticality();
    verify(instance).kind();
    verify(instance).lifecyclePhase();
    verify(instance).overallRating();
    verify(instance).parentAssetCode();
    verify(instance).plannedRetirementDate();
    verify(instance).provenance();
  }

  /**
   * Test Builder {@link Builder#from(Application)} with {@code Application}.
   * <ul>
   *   <li>When {@link Application} {@link Application#actualRetirementDate()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(Application)}
   */
  @Test
  @DisplayName("Test Builder from(Application) with 'Application'; when Application actualRetirementDate() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(Application)"})
  void testBuilderFromWithApplication_whenApplicationActualRetirementDateReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableApplication.builder();
    Application instance = mock(Application.class);
    when(instance.organisationalUnitId()).thenReturn(1L);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<LocalDateTime> ofResult2 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.commissionDate()).thenReturn(ofResult2);
    Optional<LocalDateTime> ofResult3 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.plannedRetirementDate()).thenReturn(ofResult3);
    when(instance.isRemoved()).thenReturn(true);
    Optional<LocalDateTime> emptyResult = Optional.empty();
    when(instance.actualRetirementDate()).thenReturn(emptyResult);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(instance.businessCriticality()).thenReturn(Criticality.LOW);
    Optional<ExternalIdValue> ofResult4 = Optional.of(ExternalIdValue.of("42"));
    when(instance.assetCode()).thenReturn(ofResult4);
    when(instance.overallRating()).thenReturn(RagRating.R);
    Optional<ExternalIdValue> ofResult5 = Optional.of(ExternalIdValue.of("42"));
    when(instance.parentAssetCode()).thenReturn(ofResult5);
    when(instance.applicationKind()).thenReturn(ApplicationKind.IN_HOUSE);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).id();
    verify(instance).isRemoved();
    verify(instance).name();
    verify(instance).organisationalUnitId();
    verify(instance).actualRetirementDate();
    verify(instance).applicationKind();
    verify(instance).assetCode();
    verify(instance).businessCriticality();
    verify(instance).commissionDate();
    verify(instance).kind();
    verify(instance).lifecyclePhase();
    verify(instance).overallRating();
    verify(instance).parentAssetCode();
    verify(instance).plannedRetirementDate();
    verify(instance).provenance();
    ImmutableApplication buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1L, buildResult.organisationalUnitId().longValue());
    assertEquals(Criticality.LOW, buildResult.businessCriticality());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, buildResult.entityLifecycleStatus());
    assertEquals(ApplicationKind.IN_HOUSE, buildResult.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, buildResult.lifecyclePhase());
    assertEquals(RagRating.R, buildResult.overallRating());
    assertTrue(buildResult.isRemoved());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(Application)} with {@code Application}.
   * <ul>
   *   <li>When {@link Application} {@link Application#commissionDate()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(Application)}
   */
  @Test
  @DisplayName("Test Builder from(Application) with 'Application'; when Application commissionDate() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(Application)"})
  void testBuilderFromWithApplication_whenApplicationCommissionDateReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableApplication.builder();
    Application instance = mock(Application.class);
    when(instance.organisationalUnitId()).thenReturn(1L);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<LocalDateTime> emptyResult = Optional.empty();
    when(instance.commissionDate()).thenReturn(emptyResult);
    Optional<LocalDateTime> ofResult2 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.plannedRetirementDate()).thenReturn(ofResult2);
    when(instance.isRemoved()).thenReturn(true);
    Optional<LocalDateTime> ofResult3 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.actualRetirementDate()).thenReturn(ofResult3);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(instance.businessCriticality()).thenReturn(Criticality.LOW);
    Optional<ExternalIdValue> ofResult4 = Optional.of(ExternalIdValue.of("42"));
    when(instance.assetCode()).thenReturn(ofResult4);
    when(instance.overallRating()).thenReturn(RagRating.R);
    Optional<ExternalIdValue> ofResult5 = Optional.of(ExternalIdValue.of("42"));
    when(instance.parentAssetCode()).thenReturn(ofResult5);
    when(instance.applicationKind()).thenReturn(ApplicationKind.IN_HOUSE);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).id();
    verify(instance).isRemoved();
    verify(instance).name();
    verify(instance).organisationalUnitId();
    verify(instance).actualRetirementDate();
    verify(instance).applicationKind();
    verify(instance).assetCode();
    verify(instance).businessCriticality();
    verify(instance).commissionDate();
    verify(instance).kind();
    verify(instance).lifecyclePhase();
    verify(instance).overallRating();
    verify(instance).parentAssetCode();
    verify(instance).plannedRetirementDate();
    verify(instance).provenance();
    ImmutableApplication buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1L, buildResult.organisationalUnitId().longValue());
    assertEquals(Criticality.LOW, buildResult.businessCriticality());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, buildResult.entityLifecycleStatus());
    assertEquals(ApplicationKind.IN_HOUSE, buildResult.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, buildResult.lifecyclePhase());
    assertEquals(RagRating.R, buildResult.overallRating());
    assertTrue(buildResult.isRemoved());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(Application)} with {@code Application}.
   * <ul>
   *   <li>When {@link Application} {@link IdProvider#id()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(Application)}
   */
  @Test
  @DisplayName("Test Builder from(Application) with 'Application'; when Application id() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(Application)"})
  void testBuilderFromWithApplication_whenApplicationIdReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableApplication.builder();
    Application instance = mock(Application.class);
    when(instance.organisationalUnitId()).thenReturn(1L);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    Optional<LocalDateTime> ofResult = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.commissionDate()).thenReturn(ofResult);
    Optional<LocalDateTime> ofResult2 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.plannedRetirementDate()).thenReturn(ofResult2);
    when(instance.isRemoved()).thenReturn(true);
    Optional<LocalDateTime> ofResult3 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.actualRetirementDate()).thenReturn(ofResult3);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(instance.businessCriticality()).thenReturn(Criticality.LOW);
    Optional<ExternalIdValue> ofResult4 = Optional.of(ExternalIdValue.of("42"));
    when(instance.assetCode()).thenReturn(ofResult4);
    when(instance.overallRating()).thenReturn(RagRating.R);
    Optional<ExternalIdValue> ofResult5 = Optional.of(ExternalIdValue.of("42"));
    when(instance.parentAssetCode()).thenReturn(ofResult5);
    when(instance.applicationKind()).thenReturn(ApplicationKind.IN_HOUSE);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).id();
    verify(instance).isRemoved();
    verify(instance).name();
    verify(instance).organisationalUnitId();
    verify(instance).actualRetirementDate();
    verify(instance).applicationKind();
    verify(instance).assetCode();
    verify(instance).businessCriticality();
    verify(instance).commissionDate();
    verify(instance).kind();
    verify(instance).lifecyclePhase();
    verify(instance).overallRating();
    verify(instance).parentAssetCode();
    verify(instance).plannedRetirementDate();
    verify(instance).provenance();
    ImmutableApplication buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1L, buildResult.organisationalUnitId().longValue());
    assertEquals(Criticality.LOW, buildResult.businessCriticality());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, buildResult.entityLifecycleStatus());
    assertEquals(ApplicationKind.IN_HOUSE, buildResult.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, buildResult.lifecyclePhase());
    assertEquals(RagRating.R, buildResult.overallRating());
    assertTrue(buildResult.isRemoved());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(Application)} with {@code Application}.
   * <ul>
   *   <li>When {@link Application} {@link Application#parentAssetCode()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(Application)}
   */
  @Test
  @DisplayName("Test Builder from(Application) with 'Application'; when Application parentAssetCode() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(Application)"})
  void testBuilderFromWithApplication_whenApplicationParentAssetCodeReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableApplication.builder();
    Application instance = mock(Application.class);
    when(instance.organisationalUnitId()).thenReturn(1L);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<LocalDateTime> ofResult2 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.commissionDate()).thenReturn(ofResult2);
    Optional<LocalDateTime> ofResult3 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.plannedRetirementDate()).thenReturn(ofResult3);
    when(instance.isRemoved()).thenReturn(true);
    Optional<LocalDateTime> ofResult4 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.actualRetirementDate()).thenReturn(ofResult4);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(instance.businessCriticality()).thenReturn(Criticality.LOW);
    Optional<ExternalIdValue> ofResult5 = Optional.of(ExternalIdValue.of("42"));
    when(instance.assetCode()).thenReturn(ofResult5);
    when(instance.overallRating()).thenReturn(RagRating.R);
    Optional<ExternalIdValue> emptyResult = Optional.empty();
    when(instance.parentAssetCode()).thenReturn(emptyResult);
    when(instance.applicationKind()).thenReturn(ApplicationKind.IN_HOUSE);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).id();
    verify(instance).isRemoved();
    verify(instance).name();
    verify(instance).organisationalUnitId();
    verify(instance).actualRetirementDate();
    verify(instance).applicationKind();
    verify(instance).assetCode();
    verify(instance).businessCriticality();
    verify(instance).commissionDate();
    verify(instance).kind();
    verify(instance).lifecyclePhase();
    verify(instance).overallRating();
    verify(instance).parentAssetCode();
    verify(instance).plannedRetirementDate();
    verify(instance).provenance();
    ImmutableApplication buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1L, buildResult.organisationalUnitId().longValue());
    assertEquals(Criticality.LOW, buildResult.businessCriticality());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, buildResult.entityLifecycleStatus());
    assertEquals(ApplicationKind.IN_HOUSE, buildResult.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, buildResult.lifecyclePhase());
    assertEquals(RagRating.R, buildResult.overallRating());
    assertTrue(buildResult.isRemoved());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(Application)} with {@code Application}.
   * <ul>
   *   <li>When {@link Application} {@link Application#plannedRetirementDate()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(Application)}
   */
  @Test
  @DisplayName("Test Builder from(Application) with 'Application'; when Application plannedRetirementDate() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(Application)"})
  void testBuilderFromWithApplication_whenApplicationPlannedRetirementDateReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableApplication.builder();
    Application instance = mock(Application.class);
    when(instance.organisationalUnitId()).thenReturn(1L);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<LocalDateTime> ofResult2 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.commissionDate()).thenReturn(ofResult2);
    Optional<LocalDateTime> emptyResult = Optional.empty();
    when(instance.plannedRetirementDate()).thenReturn(emptyResult);
    when(instance.isRemoved()).thenReturn(true);
    Optional<LocalDateTime> ofResult3 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.actualRetirementDate()).thenReturn(ofResult3);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(instance.businessCriticality()).thenReturn(Criticality.LOW);
    Optional<ExternalIdValue> ofResult4 = Optional.of(ExternalIdValue.of("42"));
    when(instance.assetCode()).thenReturn(ofResult4);
    when(instance.overallRating()).thenReturn(RagRating.R);
    Optional<ExternalIdValue> ofResult5 = Optional.of(ExternalIdValue.of("42"));
    when(instance.parentAssetCode()).thenReturn(ofResult5);
    when(instance.applicationKind()).thenReturn(ApplicationKind.IN_HOUSE);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).id();
    verify(instance).isRemoved();
    verify(instance).name();
    verify(instance).organisationalUnitId();
    verify(instance).actualRetirementDate();
    verify(instance).applicationKind();
    verify(instance).assetCode();
    verify(instance).businessCriticality();
    verify(instance).commissionDate();
    verify(instance).kind();
    verify(instance).lifecyclePhase();
    verify(instance).overallRating();
    verify(instance).parentAssetCode();
    verify(instance).plannedRetirementDate();
    verify(instance).provenance();
    ImmutableApplication buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1L, buildResult.organisationalUnitId().longValue());
    assertEquals(Criticality.LOW, buildResult.businessCriticality());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, buildResult.entityLifecycleStatus());
    assertEquals(ApplicationKind.IN_HOUSE, buildResult.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, buildResult.lifecyclePhase());
    assertEquals(RagRating.R, buildResult.overallRating());
    assertTrue(buildResult.isRemoved());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   * <p>
   * Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider() {
    // Arrange
    Builder builderResult = ImmutableApplication.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   * <ul>
   *   <li>Given {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'; given 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider_givenNull() {
    // Arrange
    Builder builderResult = ImmutableApplication.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableApplication.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Test Builder {@link Builder#from(EntityKindProvider)} with {@code EntityKindProvider}.
   * <ul>
   *   <li>Given {@code ALL}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(EntityKindProvider)}
   */
  @Test
  @DisplayName("Test Builder from(EntityKindProvider) with 'EntityKindProvider'; given 'ALL'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(EntityKindProvider)"})
  void testBuilderFromWithEntityKindProvider_givenAll_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableApplication.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).kind();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(EntityKindProvider)} with {@code EntityKindProvider}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(EntityKindProvider)}
   */
  @Test
  @DisplayName("Test Builder from(EntityKindProvider) with 'EntityKindProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(EntityKindProvider)"})
  void testBuilderFromWithEntityKindProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableApplication.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).kind();
  }

  /**
   * Test Builder {@link Builder#from(EntityLifecycleStatusProvider)} with {@code EntityLifecycleStatusProvider}.
   * <ul>
   *   <li>Given {@code ACTIVE}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(EntityLifecycleStatusProvider)}
   */
  @Test
  @DisplayName("Test Builder from(EntityLifecycleStatusProvider) with 'EntityLifecycleStatusProvider'; given 'ACTIVE'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(EntityLifecycleStatusProvider)"})
  void testBuilderFromWithEntityLifecycleStatusProvider_givenActive_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableApplication.builder();
    EntityLifecycleStatusProvider instance = mock(EntityLifecycleStatusProvider.class);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).entityLifecycleStatus();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(EntityLifecycleStatusProvider)} with {@code EntityLifecycleStatusProvider}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(EntityLifecycleStatusProvider)}
   */
  @Test
  @DisplayName("Test Builder from(EntityLifecycleStatusProvider) with 'EntityLifecycleStatusProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(EntityLifecycleStatusProvider)"})
  void testBuilderFromWithEntityLifecycleStatusProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableApplication.builder();
    EntityLifecycleStatusProvider instance = mock(EntityLifecycleStatusProvider.class);
    when(instance.entityLifecycleStatus()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).entityLifecycleStatus();
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; given empty; when IdProvider id() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenEmpty_whenIdProviderIdReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableApplication.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   * <ul>
   *   <li>Given {@link Optional} with one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; given Optional with one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenOptionalWithOne() {
    // Arrange
    Builder builderResult = ImmutableApplication.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableApplication.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Test Builder {@link Builder#from(IsRemovedProvider)} with {@code IsRemovedProvider}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IsRemovedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IsRemovedProvider) with 'IsRemovedProvider'; given 'true'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IsRemovedProvider)"})
  void testBuilderFromWithIsRemovedProvider_givenTrue_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableApplication.builder();
    IsRemovedProvider instance = mock(IsRemovedProvider.class);
    when(instance.isRemoved()).thenReturn(true);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).isRemoved();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   * <ul>
   *   <li>Given {@code Name}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName("Test Builder from(NameProvider) with 'NameProvider'; given 'Name'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider_givenName_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableApplication.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(OrganisationalUnitIdProvider)} with {@code OrganisationalUnitIdProvider}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(OrganisationalUnitIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(OrganisationalUnitIdProvider) with 'OrganisationalUnitIdProvider'; given one; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(OrganisationalUnitIdProvider)"})
  void testBuilderFromWithOrganisationalUnitIdProvider_givenOne_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableApplication.builder();
    OrganisationalUnitIdProvider instance = mock(OrganisationalUnitIdProvider.class);
    when(instance.organisationalUnitId()).thenReturn(1L);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).organisationalUnitId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(OrganisationalUnitIdProvider)} with {@code OrganisationalUnitIdProvider}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(OrganisationalUnitIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(OrganisationalUnitIdProvider) with 'OrganisationalUnitIdProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(OrganisationalUnitIdProvider)"})
  void testBuilderFromWithOrganisationalUnitIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableApplication.builder();
    OrganisationalUnitIdProvider instance = mock(OrganisationalUnitIdProvider.class);
    when(instance.organisationalUnitId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).organisationalUnitId();
  }

  /**
   * Test Builder {@link Builder#from(ProvenanceProvider)} with {@code ProvenanceProvider}.
   * <ul>
   *   <li>Given {@code Provenance}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ProvenanceProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ProvenanceProvider) with 'ProvenanceProvider'; given 'Provenance'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ProvenanceProvider)"})
  void testBuilderFromWithProvenanceProvider_givenProvenance_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableApplication.builder();
    ProvenanceProvider instance = mock(ProvenanceProvider.class);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).provenance();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#id(long)} with {@code long}.
   * <p>
   * Method under test: {@link Builder#id(long)}
   */
  @Test
  @DisplayName("Test Builder id(long) with 'long'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.id(long)"})
  void testBuilderIdWithLong() {
    // Arrange
    Builder builderResult = ImmutableApplication.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Test Builder {@link Builder#id(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#id(Optional)}
   */
  @Test
  @DisplayName("Test Builder id(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.id(Optional)"})
  void testBuilderIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableApplication.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Test Builder {@link Builder#isRemoved(boolean)}.
   * <p>
   * Method under test: {@link Builder#isRemoved(boolean)}
   */
  @Test
  @DisplayName("Test Builder isRemoved(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.isRemoved(boolean)"})
  void testBuilderIsRemoved() {
    // Arrange
    Builder builderResult = ImmutableApplication.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.isRemoved(true));
  }

  /**
   * Test Builder {@link Builder#lifecyclePhase(LifecyclePhase)}.
   * <p>
   * Method under test: {@link Builder#lifecyclePhase(LifecyclePhase)}
   */
  @Test
  @DisplayName("Test Builder lifecyclePhase(LifecyclePhase)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.lifecyclePhase(LifecyclePhase)"})
  void testBuilderLifecyclePhase() {
    // Arrange
    Builder builderResult = ImmutableApplication.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lifecyclePhase(LifecyclePhase.PRODUCTION));
  }

  /**
   * Test Builder {@link Builder#name(String)}.
   * <p>
   * Method under test: {@link Builder#name(String)}
   */
  @Test
  @DisplayName("Test Builder name(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.name(String)"})
  void testBuilderName() {
    // Arrange
    Builder builderResult = ImmutableApplication.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Test Builder {@link Builder#organisationalUnitId(Long)}.
   * <p>
   * Method under test: {@link Builder#organisationalUnitId(Long)}
   */
  @Test
  @DisplayName("Test Builder organisationalUnitId(Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.organisationalUnitId(Long)"})
  void testBuilderOrganisationalUnitId() {
    // Arrange
    Builder builderResult = ImmutableApplication.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.organisationalUnitId(1L));
  }

  /**
   * Test Builder {@link Builder#overallRating(RagRating)}.
   * <p>
   * Method under test: {@link Builder#overallRating(RagRating)}
   */
  @Test
  @DisplayName("Test Builder overallRating(RagRating)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.overallRating(RagRating)"})
  void testBuilderOverallRating() {
    // Arrange
    Builder builderResult = ImmutableApplication.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.overallRating(RagRating.R));
  }

  /**
   * Test Builder {@link Builder#parentAssetCode(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#parentAssetCode(Optional)}
   */
  @Test
  @DisplayName("Test Builder parentAssetCode(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.parentAssetCode(Optional)"})
  void testBuilderParentAssetCodeWithOptional() {
    // Arrange
    Builder builderResult = ImmutableApplication.builder();
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));

    // Act and Assert
    assertSame(builderResult, builderResult.parentAssetCode(parentAssetCode));
  }

  /**
   * Test Builder {@link Builder#plannedRetirementDate(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#plannedRetirementDate(Optional)}
   */
  @Test
  @DisplayName("Test Builder plannedRetirementDate(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.plannedRetirementDate(Optional)"})
  void testBuilderPlannedRetirementDateWithOptional() {
    // Arrange
    Builder builderResult = ImmutableApplication.builder();
    Optional<? extends LocalDateTime> plannedRetirementDate = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act and Assert
    assertSame(builderResult, builderResult.plannedRetirementDate(plannedRetirementDate));
  }

  /**
   * Test Json {@link Json#actualRetirementDate()}.
   * <p>
   * Method under test: {@link Json#actualRetirementDate()}
   */
  @Test
  @DisplayName("Test Json actualRetirementDate()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.actualRetirementDate()"})
  void testJsonActualRetirementDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).actualRetirementDate());
  }

  /**
   * Test Json {@link Json#applicationKind()}.
   * <p>
   * Method under test: {@link Json#applicationKind()}
   */
  @Test
  @DisplayName("Test Json applicationKind()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ApplicationKind Json.applicationKind()"})
  void testJsonApplicationKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).applicationKind());
  }

  /**
   * Test Json {@link Json#assetCode()}.
   * <p>
   * Method under test: {@link Json#assetCode()}
   */
  @Test
  @DisplayName("Test Json assetCode()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.assetCode()"})
  void testJsonAssetCode() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).assetCode());
  }

  /**
   * Test Json {@link Json#businessCriticality()}.
   * <p>
   * Method under test: {@link Json#businessCriticality()}
   */
  @Test
  @DisplayName("Test Json businessCriticality()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Criticality Json.businessCriticality()"})
  void testJsonBusinessCriticality() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).businessCriticality());
  }

  /**
   * Test Json {@link Json#commissionDate()}.
   * <p>
   * Method under test: {@link Json#commissionDate()}
   */
  @Test
  @DisplayName("Test Json commissionDate()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.commissionDate()"})
  void testJsonCommissionDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).commissionDate());
  }

  /**
   * Test Json {@link Json#description()}.
   * <p>
   * Method under test: {@link Json#description()}
   */
  @Test
  @DisplayName("Test Json description()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.description()"})
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).description());
  }

  /**
   * Test Json {@link Json#entityLifecycleStatus()}.
   * <p>
   * Method under test: {@link Json#entityLifecycleStatus()}
   */
  @Test
  @DisplayName("Test Json entityLifecycleStatus()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityLifecycleStatus Json.entityLifecycleStatus()"})
  void testJsonEntityLifecycleStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).entityLifecycleStatus());
  }

  /**
   * Test Json {@link Json#externalId()}.
   * <p>
   * Method under test: {@link Json#externalId()}
   */
  @Test
  @DisplayName("Test Json externalId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.externalId()"})
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).externalId());
  }

  /**
   * Test Json {@link Json#id()}.
   * <p>
   * Method under test: {@link Json#id()}
   */
  @Test
  @DisplayName("Test Json id()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.id()"})
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).id());
  }

  /**
   * Test Json {@link Json#isRemoved()}.
   * <p>
   * Method under test: {@link Json#isRemoved()}
   */
  @Test
  @DisplayName("Test Json isRemoved()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Json.isRemoved()"})
  void testJsonIsRemoved() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).isRemoved());
  }

  /**
   * Test Json {@link Json#kind()}.
   * <p>
   * Method under test: {@link Json#kind()}
   */
  @Test
  @DisplayName("Test Json kind()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityKind Json.kind()"})
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).kind());
  }

  /**
   * Test Json {@link Json#lifecyclePhase()}.
   * <p>
   * Method under test: {@link Json#lifecyclePhase()}
   */
  @Test
  @DisplayName("Test Json lifecyclePhase()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LifecyclePhase Json.lifecyclePhase()"})
  void testJsonLifecyclePhase() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).lifecyclePhase());
  }

  /**
   * Test Json {@link Json#name()}.
   * <p>
   * Method under test: {@link Json#name()}
   */
  @Test
  @DisplayName("Test Json name()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.name()"})
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).name());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()"})
  void testJsonNewJson() {
    // Arrange and Act
    Json actualJson = new Json();

    // Assert
    assertNull(actualJson.organisationalUnitId);
    assertNull(actualJson.description);
    assertNull(actualJson.name);
    assertNull(actualJson.provenance);
    assertNull(actualJson.businessCriticality);
    assertNull(actualJson.kind);
    assertNull(actualJson.entityLifecycleStatus);
    assertNull(actualJson.applicationKind);
    assertNull(actualJson.lifecyclePhase);
    assertNull(actualJson.overallRating);
    assertFalse(actualJson.actualRetirementDate.isPresent());
    assertFalse(actualJson.assetCode.isPresent());
    assertFalse(actualJson.commissionDate.isPresent());
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.parentAssetCode.isPresent());
    assertFalse(actualJson.plannedRetirementDate.isPresent());
    assertFalse(actualJson.isRemoved);
    assertFalse(actualJson.isRemovedIsSet);
  }

  /**
   * Test Json {@link Json#organisationalUnitId()}.
   * <p>
   * Method under test: {@link Json#organisationalUnitId()}
   */
  @Test
  @DisplayName("Test Json organisationalUnitId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long Json.organisationalUnitId()"})
  void testJsonOrganisationalUnitId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).organisationalUnitId());
  }

  /**
   * Test Json {@link Json#overallRating()}.
   * <p>
   * Method under test: {@link Json#overallRating()}
   */
  @Test
  @DisplayName("Test Json overallRating()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RagRating Json.overallRating()"})
  void testJsonOverallRating() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).overallRating());
  }

  /**
   * Test Json {@link Json#parentAssetCode()}.
   * <p>
   * Method under test: {@link Json#parentAssetCode()}
   */
  @Test
  @DisplayName("Test Json parentAssetCode()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.parentAssetCode()"})
  void testJsonParentAssetCode() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).parentAssetCode());
  }

  /**
   * Test Json {@link Json#plannedRetirementDate()}.
   * <p>
   * Method under test: {@link Json#plannedRetirementDate()}
   */
  @Test
  @DisplayName("Test Json plannedRetirementDate()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.plannedRetirementDate()"})
  void testJsonPlannedRetirementDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).plannedRetirementDate());
  }

  /**
   * Test Json {@link Json#provenance()}.
   * <p>
   * Method under test: {@link Json#provenance()}
   */
  @Test
  @DisplayName("Test Json provenance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.provenance()"})
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).provenance());
  }

  /**
   * Test Json {@link Json#setIsRemoved(boolean)}.
   * <p>
   * Method under test: {@link Json#setIsRemoved(boolean)}
   */
  @Test
  @DisplayName("Test Json setIsRemoved(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setIsRemoved(boolean)"})
  void testJsonSetIsRemoved() {
    // Arrange
    Json json = new Json();

    // Act
    json.setIsRemoved(true);

    // Assert
    assertTrue(json.isRemoved);
    assertTrue(json.isRemovedIsSet);
  }
}
